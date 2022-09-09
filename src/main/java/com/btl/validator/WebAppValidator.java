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
//import com.btl.pojos.Employee;
//import com.btl.pojos.Route;
//import com.btl.pojos.Schedule;
//import com.btl.pojos.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.util.HashSet;
//import java.util.Set;
//import javax.validation.ConstraintViolation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
///**
// *
// * @author Nguyen
// */
//@Component
//public class WebAppValidator implements Validator{
//    @Autowired
//    private javax.validation.Validator beanValidator;
//    
//    private Set<Validator> springValidators  = new HashSet<>();
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Employee.class.isAssignableFrom(clazz)
//                ;
//    }
//
//     @Override
//    public void validate(Object target, Errors errors) {
//        Set<ConstraintViolation<Object>> constraintViolations 
//                = beanValidator.validate(target);
//        
//        for (ConstraintViolation<Object> obj: constraintViolations) 
//            errors.rejectValue(obj.getPropertyPath().toString(), 
//                    obj.getMessageTemplate(), obj.getMessage());
//        
//        for (Validator obj: springValidators)
//            obj.validate(target, errors);
//    }
//    
//    public void setSpringValidators(Set<Validator> springValidators) {
//        this.springValidators = springValidators;
//    }
//}
