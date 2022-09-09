/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service;

import com.btl.pojos.Customer;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public interface CustomerService {

    Customer getCustomerById(int id);

    boolean addOrUpdate(Customer customer);

    Customer findById(int i);

}
