/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository.impl;

import com.btl.pojos.Employee;
import com.btl.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Employee> getEmployees() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Employee");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Employee employee) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (employee.getIdEmployee() > 0) {
                session.update(employee);
            } else {
                session.save(employee);
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

    @Override
    public boolean delete(Employee empl) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Transaction transaction = null;
        try {
            //delete
            session.delete(empl);
            //delete thành công
            return true;
        } catch (Exception ex) {

            System.err.println("Delete employee error" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Employee findById(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Employee.class, i);

    }

    @Override
    public List<Object> getListByCondition(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootE = query.from(Employee.class);

        query = query.select(rootE);
        List<Predicate> predicates = new ArrayList<>();

        if (kw != null) {
            Predicate p2 = builder.like(rootE.get("name").as(String.class),
                    String.format("%%s%%", kw));
        }

        query = query.where(predicates.toArray(new Predicate[]{}));
        Query q = session.createQuery(query);

        //Phan trang
        int maxPage = 6;
        q.setMaxResults(maxPage);
        //Vị trí bắt đầu
        q.setFirstResult((page - 1) * maxPage);
        return q.getResultList();

    }

    @Override
    public long totalItem() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Employee");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Employee> getEmployees(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root root = query.from(Employee.class);
        query = query.select(root);

        if (kw != null) {

            Predicate p2 = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%", kw));

            query = query.where(p2);
        }

        Query q = session.createQuery(query);
        //Phan trang
        int maxPage = 6;
        q.setMaxResults(maxPage);
        //Vị trí bắt đầu
        q.setFirstResult((page - 1) * maxPage);
        return q.getResultList();

    }

}
