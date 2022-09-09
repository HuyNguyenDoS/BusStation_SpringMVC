/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository.impl;

import com.btl.pojos.BookingDetail;
import com.btl.pojos.Bus;
import com.btl.pojos.CategoryBus;
import com.btl.pojos.Route;
import com.btl.pojos.Schedule;
import com.btl.repository.RouteRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Route> getRoutes() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Route");
        return q.getResultList();

    }

    @Override
    public boolean addOrUpdate(Route route) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (route.getId() > 0) {
                session.update(route);
            } else {
                session.save(route);     //create            
            }            //Thêm thành công
            return true;
        } catch (Exception ex) {
            System.err.println("Lỗi xảy ra khi thêm hoặc sửa" + ex.getMessage());
            ex.printStackTrace();
        }

        //Thêm thất bại
        return false;
    }

    @Override
    public boolean delete(Route route) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Transaction transaction = null;
        try {
            //delete
            session.delete(route);
            //delete thành công
            return true;
        } catch (Exception ex) {

            System.err.println("Delete route error" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Route findById(int idRoute) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Route.class, idRoute);
    }

    @Override
    public long totalItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Route");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Object> getListByCondition(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootB = query.from(Bus.class);
        Root rootR = query.from(Route.class);
        Root rootC = query.from(CategoryBus.class);

        Predicate p = builder.equal(rootB.get("idBus"), rootR.get("bus"));
        Predicate pc = builder.equal(rootC.get("id"), rootB.get("categoryBus"));

        query.multiselect(rootR.get("id"), rootB.get("idBus"), rootB.get("busName"), rootB.get("numberPlate"), rootC.get("name"), rootB.get("seatNumber"),
                rootR.get("departure"), rootR.get("destination"), rootR.get("journeyTime"), rootR.get("distance"), rootR.get("ticketPrice"),
                rootR.get("imageDeparture"), rootR.get("imageDestination"), rootR.get("pickUpPoint"), rootR.get("dropOffPoint"));

        if (kw != null) {
            Predicate p1 = builder.like(rootB.get("busName").as(String.class),
                    String.format("%%s%%", kw));
            //Loai ghe
            Predicate p4 = builder.like(rootC.get("name").as(String.class),
                    String.format("%%s%%", kw));

            Predicate p5 = builder.like(rootR.get("departure").as(String.class),
                    String.format("%%s%%", kw));
            Predicate p6 = builder.like(rootR.get("destination").as(String.class),
                    String.format("%%s%%", kw));

            query = query.where(builder.and(builder.or(p1, p4, p5, p6), p, pc));

        } else {
            query = query.where(builder.and(p, pc));
        }

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
    public List<Route> getRoutes(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Route> query = builder.createQuery(Route.class);
        Root root = query.from(Route.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p1 = builder.like(root.get("departure").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p2 = builder.like(root.get("destination").as(String.class),
                    String.format("%%%s%%", kw));

            query = query.where(builder.or(p1, p2));
        }

        Query q = session.createQuery(query);
        //Phan trang
        int maxPage = 6;
        q.setMaxResults(maxPage);
        //Vị trí bắt đầu
        q.setFirstResult((page - 1) * maxPage);
        return q.getResultList();

    }

    @Override
    public List<Object[]> getHotRoutes(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootR = query.from(Route.class);
        Root rootD = query.from(BookingDetail.class);
        Root rootS = query.from(Schedule.class);

        Predicate pr = builder.equal(rootR.get("id"), rootS.get("route"));
        Predicate pd = builder.equal(rootS.get("id"), rootD.get("schedule"));

        query.multiselect(rootR.get("id"), rootR.get("departure"), rootR.get("destination"),
                rootR.get("imageDeparture"), rootR.get("imageDestination"),
                builder.count(rootR.get("id")),
                rootR.get("ticketPrice"), rootR.get("journeyTime"), rootR.get("distance"));

        query = query.where(builder.and(pr, pd));

        query = query.groupBy(rootR.get("id"));
        query = query.orderBy(builder.desc(builder.count(rootR.get("id"))));

        Query q = session.createQuery(query);
        q.setMaxResults(num);
        return q.getResultList();

    }

}
