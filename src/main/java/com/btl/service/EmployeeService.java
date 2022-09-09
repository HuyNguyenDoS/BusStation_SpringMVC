/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service;

import com.btl.pojos.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    boolean addOrUpdate(Employee employee);

    boolean delete(int id);

    Employee findById(int id);

    Long totalItem();

    List<Object> getListByCondition(String kw, int page);

    List<Employee> getEmployees(String kwString, int page);
}
