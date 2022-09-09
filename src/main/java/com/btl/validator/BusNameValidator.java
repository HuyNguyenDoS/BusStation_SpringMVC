///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.btl.validator;
//
//import com.btl.pojos.Booking;
//import com.btl.pojos.BookingDetail;
//import com.btl.pojos.Bus;
//import com.btl.pojos.Cart;
//import com.btl.pojos.CategoryBus;
//import com.btl.pojos.Route;
//import com.btl.pojos.Schedule;
//import com.btl.pojos.User;
//import com.btl.service.BusService;
//import javax.persistence.NoResultException;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
///**
// *
// * @author Nguyen
// */
//public class BusNameValidator implements ConstraintValidator<BusName, String> {
//    @Autowired
//    private BusService busService;
//
//    @Override
//    public void initialize(BusName constraintAnnotation) {
//        
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        try {
//            return busService.checkBusName(value);
//        } catch (NoResultException ex) {
//            return false;
//        }
//    }
//}
