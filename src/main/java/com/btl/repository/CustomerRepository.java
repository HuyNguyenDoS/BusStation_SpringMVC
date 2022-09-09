/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository;

import com.btl.pojos.Customer;
import java.util.List;

public interface CustomerRepository {

    Customer getCustomerById(int customerId);

    boolean addOrUpdate(Customer customer);

    Customer findById(int id);

}
