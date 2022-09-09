/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository.impl;

import com.btl.pojos.Booking;
import com.btl.pojos.BookingDetail;
import com.btl.pojos.Bus;
import com.btl.pojos.CategoryBus;
import com.btl.pojos.Employee;
import com.btl.pojos.Route;
import com.btl.pojos.Schedule;
import com.btl.repository.StatisticRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StatisticRepositoryImpl implements StatisticRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object> getStatis(String kw, int page) {
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

        Predicate p = builder.equal(rootB.get("idBus"), rootS.get("bus"));
        Predicate pc = builder.equal(rootC.get("id"), rootB.get("categoryBus"));
        Predicate pr = builder.equal(rootR.get("id"), rootS.get("route"));
        Predicate pk = builder.equal(rootK.get("id"), rootD.get("booking"));
        Predicate pd = builder.equal(rootS.get("id"), rootD.get("schedule"));
        Predicate pe = builder.equal(rootE.get("idEmployee"), rootB.get("employee"));

        query.multiselect(rootD.get("id"), rootD.get("quantity"), rootD.get("price"),
                rootR.get("departure"), rootR.get("destination"),
                rootS.get("departureDate"),
                rootK.get("bookingDate"),
                rootB.get("busName"), rootB.get("numberPlate"),
                rootC.get("name"),
                builder.count(rootB.get("idBus"))
        );
        query.groupBy(rootR.get("id"));
        if (kw != null) {

            Predicate p1 = builder.like(rootB.get("busName").as(String.class),
                    String.format("%%s%%", kw));
            Predicate p2 = builder.like(rootE.get("name").as(String.class),
                    String.format("%%s%%", kw));

            //Loai ghe
            Predicate p4 = builder.like(rootC.get("name").as(String.class),
                    String.format("%%s%%", kw));

//                
            query = query.where(builder.and(builder.or(p1, p2, p4), pe, pc, pr, p, pk, pd));

        } else {
            query = query.where(builder.and(pc, pe, pr, p, pk, pd));

        }
        query = query.orderBy(builder.asc(rootB.get("idBus")));

        Query q = session.createQuery(query);

        //Phan trang
        int maxPage = 6;
        q.setMaxResults(maxPage);
        //Vị trí bắt đầu
        q.setFirstResult((page - 1) * maxPage);
        return q.getResultList();

    }

    @Override
    public List<Object> RevenueStats(String kw, Date fromDate, Date toDate) {
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
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootB.get("idBus"), rootS.get("bus")));
        predicates.add(builder.equal(rootC.get("id"), rootB.get("categoryBus")));
        predicates.add(builder.equal(rootR.get("id"), rootS.get("route")));
        predicates.add(builder.equal(rootK.get("id"), rootD.get("booking")));
        predicates.add(builder.equal(rootS.get("id"), rootD.get("schedule")));
        predicates.add(builder.equal(rootE.get("idEmployee"), rootB.get("employee")));

        query.multiselect(rootK.get("id"), rootK.get("total"), rootK.get("bookingDate"),
                rootD.get("quantity"), rootD.get("price"),
                rootR.get("id"), rootR.get("departure"), rootR.get("destination"),
                rootB.get("busName"),
                rootC.get("name"),
                builder.sum(builder.prod(rootD.get("quantity"), rootD.get("price"))));

        query.groupBy(rootR.get("id"));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.or(builder.like(rootR.get("departure"), String.format("%%%s%%", kw)),
                    builder.like(rootR.get("destination"), String.format("%%%s%%", kw))));

        }
        if (fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootK.get("bookingDate"), fromDate));
        }
        if (toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootK.get("bookingDate"), toDate));
        }
        query.where(predicates.toArray(new Predicate[]{}));

        query = query.orderBy(builder.asc(rootB.get("idBus")));
        // query.groupBy(rootB.get("idBus"));
        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<Object> RevenueStatsMonth(String kw, Date fromDate, Date toDate) {
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
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootB.get("idBus"), rootS.get("bus")));
        predicates.add(builder.equal(rootC.get("id"), rootB.get("categoryBus")));
        predicates.add(builder.equal(rootR.get("id"), rootS.get("route")));
        predicates.add(builder.equal(rootK.get("id"), rootD.get("booking")));
        predicates.add(builder.equal(rootS.get("id"), rootD.get("schedule")));
        predicates.add(builder.equal(rootE.get("idEmployee"), rootB.get("employee")));

        query.multiselect(builder.function("MONTH", Integer.class, rootK.get("bookingDate")),
                builder.function("YEAR", Integer.class, rootK.get("bookingDate")),
                rootK.get("id"), rootK.get("total"), rootK.get("bookingDate"),
                rootD.get("quantity"), rootD.get("price"),
                rootR.get("id"), rootR.get("departure"), rootR.get("destination"),
                rootB.get("busName"),
                rootC.get("name"),
                builder.sum(builder.prod(rootD.get("quantity"), rootD.get("price"))));

        query.groupBy(builder.function("MONTH", Integer.class, rootK.get("bookingDate")),
                builder.function("YEAR", Integer.class, rootK.get("bookingDate")));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.or(builder.like(rootR.get("departure"), String.format("%%%s%%", kw)),
                    builder.like(rootR.get("destination"), String.format("%%%s%%", kw))));
        }
        if (fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootK.get("bookingDate"), fromDate));
        }
        if (toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootK.get("bookingDate"), toDate));
        }
        query.where(predicates.toArray(new Predicate[]{}));

        query = query.orderBy(builder.asc(rootK.get("bookingDate")));
        Query q = session.createQuery(query);

        return q.getResultList();

    }

    @Override
    public List<Object> RevenueStatsPeriod(Date fromDate, Date toDate) {
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
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootB.get("idBus"), rootS.get("bus")));
        predicates.add(builder.equal(rootC.get("id"), rootB.get("categoryBus")));
        predicates.add(builder.equal(rootR.get("id"), rootS.get("route")));
        predicates.add(builder.equal(rootK.get("id"), rootD.get("booking")));
        predicates.add(builder.equal(rootS.get("id"), rootD.get("schedule")));
        predicates.add(builder.equal(rootE.get("idEmployee"), rootB.get("employee")));

        query.multiselect(
                builder.function("MONTH", Integer.class, rootK.get("bookingDate")),
                builder.function("YEAR", Integer.class, rootK.get("bookingDate")),
                rootK.get("id"), rootK.get("total"), rootK.get("bookingDate"), builder.count(rootK.get("id")),
                rootD.get("quantity"), rootD.get("price"),
                rootR.get("id"), rootR.get("departure"), rootR.get("destination"),
                rootB.get("busName"),
                rootC.get("name"),
                builder.sum(builder.prod(rootD.get("quantity"), rootD.get("price"))));

        query.groupBy(builder.function("MONTH", Integer.class, rootK.get("bookingDate")),
                builder.function("YEAR", Integer.class, rootK.get("bookingDate")));

        if (fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootK.get("bookingDate"), fromDate));
        }
        if (toDate != null) {
            predicates.add(builder.lessThanOrEqualTo(rootK.get("bookingDate"), toDate));
        }
        query.where(predicates.toArray(new Predicate[]{}));

        query = query.orderBy(builder.asc(rootK.get("id")));
        Query q = session.createQuery(query);

        return q.getResultList();
    }

}
