/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author HUY NGUYEN
 */
public interface UserService extends UserDetailsService {

    boolean addUser(User user);

    boolean addStaff(User user);

    boolean addCarrier(User user);

    List<User> getUsers(String username);

    User getUser();

    int countUser();

    List<User> getUsers(String username, int page);

    boolean updateUserRole(User user);

    User getUserByUsername(String username);

    User findById(int id);

    boolean delete(int id);

}
