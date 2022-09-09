///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.btl.validator;
//
//
//import com.btl.pojos.Bus;
//import java.math.BigDecimal;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
///**
// *
// * @author Nguyen
// */
//@Component
//public class PriceValidator implements Validator {
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Bus.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Bus bus = (Bus) target;
//       
//       
//    }    
//}