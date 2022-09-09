/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository.impl;

import com.btl.pojos.Booking;
import com.btl.pojos.Bus;
import com.btl.pojos.CategoryBus;
import com.btl.pojos.Comment;
import com.btl.pojos.Employee;
import com.btl.pojos.Route;
import com.btl.pojos.Schedule;
import com.btl.pojos.User;
import com.btl.repository.BusRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

/**
 *
 * @author Nguyen
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class BusRepositoryImpl implements BusRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public Booking getBookingById(int bookingID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Booking.class, bookingID);
    }

    @Override
    public List<Object[]> getBooking(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootK = q.from(Booking.class);
        Root rootU = q.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rootU.get("id"), rootK.get("user")));

        q.multiselect(
                rootK.get("id"), rootK.get("bookingDate"), rootK.get("total"), rootK.get("status"),
                rootU.get("firstName"), rootU.get("lastName"), rootU.get("email"), rootU.get("phone"), rootU.get("username")
        );

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rootK.get("id"));
        q = q.orderBy(b.asc(rootK.get("id")));

        Query query = session.createQuery(q);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    @Override
    //@Transactional
    public List<Booking> getBooking() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Booking");
        return q.getResultList();

    }

    @Override
    public boolean updateBooking(Booking booking, String status, String value) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            if (value.contains("noaccept")) {
                booking.setStatus("noaccept");
                session.update(booking);
                return true;
            }
            if (value.contains("accept")) {
                booking.setStatus("accept");
                session.update(booking);
                return true;
            }
        } catch (Exception ex) {
            System.err.println("lỗi");
            return false;
        }
        return true;
    }

    @Override
    public List<Bus> getBuses(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Bus> q = b.createQuery(Bus.class);
        Root root = q.from(Bus.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("busName").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(tp));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));

        }

        q.orderBy(b.desc(root.get("idBus")), b.desc(root.get("busName")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countBus() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Bus");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    //@Transactional
    public List<Bus> getBuses() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Bus");
        return q.getResultList();

    }

    @Override
    public Bus getBusById(int busId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Bus.class, busId);
    }

    //CREATE
    @Override
    public boolean addOrUpdate(Bus bus) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (bus.getIdBus() > 0) {
                session.update(bus);
            } else {
                session.save(bus);     //create
            }
            //Thêm thành công
            return true;
        } catch (Exception ex) {
            System.err.println("Lỗi xảy ra khi thêm hoặc sửa" + ex.getMessage());
            ex.printStackTrace();
        }

        //Thêm thất bại
        return false;

    }

    //DELETE
    @Override
    public boolean delete(Bus bus) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Transaction transaction = null;
        try {
            //delete
            session.delete(bus);
            //delete thành công
            return true;
        } catch (Exception ex) {

            System.err.println("Delete bus error" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    //FIND BY ID
    @Override
    public Bus findById(int idBus) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Bus.class, idBus);
    }

    @Override
    public List<Object> getListByCondition(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootB = query.from(Bus.class);
        Root rootE = query.from(Employee.class);
        Root rootC = query.from(CategoryBus.class);

        Predicate pc = builder.equal(rootC.get("id"), rootB.get("categoryBus"));
        Predicate pe = builder.equal(rootE.get("idEmployee"), rootB.get("employee"));

        query.multiselect(rootB.get("idBus"), rootB.get("busName"), rootB.get("numberPlate"), rootB.get("manufacturer"), rootC.get("name"),
                rootB.get("seatNumber"), rootB.get("title"), rootB.get("description"), rootB.get("image"),
                rootE.get("idEmployee"), rootE.get("name"),
                rootE.get("position"));
        if (kw != null) {

            Predicate p1 = builder.like(rootB.get("busName").as(String.class),
                    String.format("%%s%%", kw));
            Predicate p2 = builder.like(rootE.get("name").as(String.class),
                    String.format("%%s%%", kw));
            //Loai ghe
            Predicate p4 = builder.like(rootC.get("name").as(String.class),
                    String.format("%%s%%", kw));

//                
            query = query.where(builder.and(builder.or(p1, p2, p4), pe, pc));

        } else {
            query = query.where(builder.and(pc, pe));

        }
        query = query.orderBy(builder.asc(rootB.get("idBus")));

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
    public long totalItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Bus");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Object> getListByCondition(String kw, String kw2, Date fromDate, int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootB = query.from(Bus.class);
        Root rootR = query.from(Route.class);
        Root rootE = query.from(Employee.class);
        Root rootS = query.from(Schedule.class);
        Root rootC = query.from(CategoryBus.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootB.get("idBus"), rootS.get("bus")));
        predicates.add(builder.equal(rootC.get("id"), rootB.get("categoryBus")));
        predicates.add(builder.equal(rootR.get("id"), rootS.get("route")));
        predicates.add(builder.equal(rootE.get("idEmployee"), rootB.get("employee")));

        query.multiselect(
                rootR.get("id"), rootR.get("departure"), rootR.get("destination"), rootR.get("distance"), rootR.get("ticketPrice"),
                rootB.get("busName"), rootB.get("seatNumber"),
                rootC.get("name"),
                rootS.get("departureDate"), rootS.get("departureTime"));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(builder.like(rootR.get("departure"), String.format("%%%s%%", kw)));
        }

        if (kw2 != null && !kw2.isEmpty()) {
            predicates.add(builder.like(rootR.get("destination"), String.format("%%%s%%", kw2)));

        }
        if (fromDate != null) {
            predicates.add(builder.greaterThanOrEqualTo(rootS.get("departureDate"), fromDate));
        }
        query.where(predicates.toArray(new Predicate[]{}));

//        query = query.orderBy(builder.asc(rootR.get("id")));
        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public boolean update(Bus bus, String active) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            System.err.println("trước if");
            if (active.contains("true")) {
                bus.setActive(false);
                session.update(bus);
                System.err.println("sau if");
                return true;
            }
            System.err.println("if false");
            if (active.contains("false")) {
                bus.setActive(true);
                session.update(bus);
                return true;
            }
        } catch (Exception ex) {
            System.err.println("lỗi");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkBusName(String busName) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bus> cr = builder.createQuery(Bus.class);

        Root<Bus> root = cr.from(Bus.class);
        CriteriaQuery query = cr.select(root);
        query.where(builder.equal(builder.upper(root.get("busName").as(String.class)),
                busName.toUpperCase()));

        return session.createQuery(query).getSingleResult() == null;
    }

    @Override
    public boolean bookingConfirm(String value, String gmail, int total, String nameCustomer, String date) {
        System.err.println("Ngay đay la cai value: " + value);
        if (value.contains("noaccept")) {
            try {
                String to = gmail + ".com";
                System.err.println(to);

                String from = "huynguyenvo2001@gmail.com";

                String host = "smtp.gmail.com";

                Properties properties = System.getProperties();

                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");

                javax.mail.Session session = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("huynguyenvo2001@gmail.com", "gxgsqmhhdsgwcekb");
                    }
                });

                //session.setDebug(true);
                try {
                    MimeMessage message = new MimeMessage(session);

                    message.setFrom(new InternetAddress(from));

                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                    message.setSubject("Mail confirm from Transport DoubleN!");

                    message.setText("Transport DoubleN \n\n"
                            + "Dear " + nameCustomer + "\n"
                            + "Sorry for not being able to accept your reservation. \n\n\n\n"
                            + "BOOKING INFORMATION  \n"
                            + "Total:        " + total + "VND \n"
                            + "Booking date: " + date + "\n \n \n \n \n"
                            + "Thank you for being with us");
                    System.out.println("sending...");
                    // Send message
                    Transport.send(message);
                    System.out.println("Sent message successfully....");
                    return true;
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
            } catch (Exception mex) {
                System.err.println("Send failed");
            }
        }
        if (value.contains("accept")) {
            try {
                String to = gmail + ".com";
                System.err.println(to);

                String from = "huynguyenvo2001@gmail.com";

                String host = "smtp.gmail.com";

                Properties properties = System.getProperties();

                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");

                javax.mail.Session session = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("huynguyenvo2001@gmail.com", "gxgsqmhhdsgwcekb");
                    }
                });

                //session.setDebug(true);
                try {
                    MimeMessage message = new MimeMessage(session);

                    message.setFrom(new InternetAddress(from));

                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                    message.setSubject("Mail confirm from Transport DoubleN!");

                    message.setText("Transport DoubleN \n\n"
                            + "Dear " + nameCustomer + "\n"
                            + "Your booking request has been successfully confirmed. Please check your booking information. \n\n\n\n"
                            + "BOOKING INFORMATION  \n"
                            + "Total:        " + total + "VND \n"
                            + "Booking date: " + date + "\n \n \n \n \n"
                            + "Thank you for being with us");
                    System.out.println("sending...");
                    // Send message
                    Transport.send(message);
                    System.out.println("Sent message successfully....");
                    return true;
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
            } catch (Exception mex) {
                System.err.println("Send failed");
            }
        }

        return false;
    }

}
