/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository.impl;

import com.btl.pojos.Booking;
import com.btl.pojos.BookingDetail;
import com.btl.pojos.Bus;
import com.btl.pojos.Cart;
import com.btl.pojos.CategoryBus;
import com.btl.pojos.Employee;
import com.btl.pojos.Route;
import com.btl.pojos.Schedule;
import com.btl.pojos.User;
import com.btl.repository.BookingRepository;
import com.btl.repository.BusRepository;
import com.btl.repository.CustomerRepository;
import com.btl.repository.ScheduleRepository;
import com.btl.repository.UserRepository;
import com.btl.service.ScheduleService;
import com.btl.utils.Utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nguyen
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class BookingRepositoryImpl implements BookingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Environment env;

    @Override
    //Cập nhật nhiều giao tác và có mối quan hệ cha con 
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addBill(Map<Integer, Cart> cart, int id) {
        try {
            Session session = sessionFactory.getObject().getCurrentSession();

            Booking booking = new Booking();
            booking.setUser(this.userRepository.findById(id));
            booking.setBus(this.busRepository.findById(id));

            booking.setStatus("waiting");
            booking.setBookingDate(new Date());

            Map<String, String> totalMoney = Utils.totalMoney(cart);
            booking.setTotal(BigDecimal.valueOf(Long.parseLong(totalMoney.get("total"))));

            session.save(booking);

            for (Cart c : cart.values()) {
                BookingDetail b = new BookingDetail();
                b.setPrice(c.getPrice());
                b.setQuantity(c.getQuantity());
                b.setBooking(booking);
                b.setSchedule(this.scheduleRepository.findById(c.getScheduleId()));

                Schedule schedule = this.scheduleRepository.findById(c.getScheduleId());
                schedule.getBus().setSeatNumber(schedule.getBus().getSeatNumber() - c.getQuantity());
                session.save(schedule);

                session.save(b);
            }

            return true;

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int countBooking() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("SELECT Count(*) FROM Booking");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<Object[]> getListBooking(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootK = query.from(Booking.class);
        Root rootD = query.from(BookingDetail.class);
        Root rootU = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(rootK.get("id"), rootD.get("booking")));
        predicates.add(builder.equal(rootU.get("id"), rootK.get("user")));

        query.multiselect(
                rootK.get("id"), rootK.get("bookingDate"), rootK.get("total"),
                rootU.get("firstName"), rootU.get("lastName"), rootU.get("email"), rootU.get("phone"), rootU.get("username")
        );

//        query.groupBy(rootR.get("id"));
        if (kw != null && !kw.isEmpty()) {

//            predicates.add(builder.like(rootU.get("firstName"), String.format("%%%s%%", kw)));
            predicates.add(builder.or(builder.like(rootU.get("firstName"), String.format("%%%s%%", kw)),
                    builder.like(rootU.get("lastName"), String.format("%%%s%%", kw))));

        }

        query.where(predicates.toArray(new Predicate[]{}));
        query.groupBy(rootK.get("id"));
        query = query.orderBy(builder.asc(rootK.get("id")));

        Query q = session.createQuery(query);

        //Phan trang
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            q.setFirstResult(start);
            q.setMaxResults(size);
        }
        return q.getResultList();

    }

    @Override
    public List<Object[]> getListBookingDetail(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootB = query.from(Bus.class);
        Root rootR = query.from(Route.class);
        Root rootE = query.from(Employee.class);
        Root rootS = query.from(Schedule.class);
        Root rootC = query.from(CategoryBus.class);
        Root rootK = query.from(Booking.class);
        Root rootD = query.from(BookingDetail.class);
        Root rootU = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootB.get("idBus"), rootS.get("bus")));
        predicates.add(builder.equal(rootC.get("id"), rootB.get("categoryBus")));
        predicates.add(builder.equal(rootR.get("id"), rootS.get("route")));
        predicates.add(builder.equal(rootK.get("id"), rootD.get("booking")));
        predicates.add(builder.equal(rootS.get("id"), rootD.get("schedule")));
        predicates.add(builder.equal(rootE.get("idEmployee"), rootB.get("employee")));
        predicates.add(builder.equal(rootU.get("id"), rootK.get("user")));
        predicates.add(builder.equal(rootD.get("booking"), id));

        query.multiselect(rootD.get("id"), rootD.get("quantity"), rootD.get("price"),
                rootR.get("departure"), rootR.get("destination"),
                rootB.get("busName"), rootB.get("numberPlate"),
                rootC.get("name"),
                rootS.get("departureDate"), rootS.get("departureTime"),
                rootK.get("id"), rootK.get("bookingDate"), rootK.get("total"),
                rootU.get("firstName"), rootU.get("lastName"), rootU.get("email"), rootU.get("phone"), rootU.get("username")
        );

        query.where(predicates.toArray(new Predicate[]{}));

        query.orderBy(builder.asc(rootD.get("id")));

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public long totalItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Booking");
        return Long.parseLong(q.getSingleResult().toString());
    }

}
