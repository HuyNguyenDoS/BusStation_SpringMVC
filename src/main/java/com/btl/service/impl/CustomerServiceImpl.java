/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service.impl;

import com.btl.pojos.Customer;
import com.btl.repository.CustomerRepository;
import com.btl.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(int id) {
        return this.customerRepository.getCustomerById(id);
    }

    @Override
    public boolean addOrUpdate(Customer customer) {
        return this.customerRepository.addOrUpdate(customer);
    }

    @Override
    public Customer findById(int i) {
        return this.customerRepository.findById(i);

    }

}
