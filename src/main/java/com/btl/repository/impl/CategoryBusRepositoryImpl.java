/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository.impl;

import com.btl.pojos.CategoryBus;
import com.btl.repository.CategoryBusRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoryBusRepositoryImpl implements CategoryBusRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<CategoryBus> getCategoryBuses() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From CategoryBus");

        return q.getResultList();
    }

}
