/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository.impl;

import com.btl.pojos.Customer;
import com.btl.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public boolean addOrUpdate(Customer customer) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (customer.getId() > 0) {
                session.update(customer);
            } else {
                session.save(customer);
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
    public Customer findById(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Customer.class, i);
    }
}
