/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.btl.pojos.User;
import com.btl.repository.UserRepository;
import com.btl.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author HUY NGUYEN
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User user) {

        try {
            String pass = user.getPassword();
            user.setPassword(this.passwordEncoder.encode(pass));

            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));
            return this.userRepository.addUser(user);
        } catch (IOException ex) {
            System.err.println("loi ngay day=======");
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean addStaff(User user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));

        user.setUserRole(User.STAFF);

        return this.userRepository.addUser(user);
    }

    @Override
    public boolean addCarrier(User user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));

        user.setUserRole(User.CARRIER);

        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String username, int page) {
        return this.userRepository.getUsers(username, page);

    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist!!!");
        }
        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public User getUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countUser() {
        return this.userRepository.countUser();
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean updateUserRole(User user) {
        return this.userRepository.updateUser(user);
    }

    @Override
    public User findById(int i) {
        return this.userRepository.findById(i);
    }

    @Override
    public boolean delete(int i) {
        return this.userRepository.delete(i);
    }
}
