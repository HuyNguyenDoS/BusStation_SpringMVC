/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.User;
import com.btl.service.UserService;
//import com.btl.validator.WebAppValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HUY NGUYEN
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;

//    @Autowired
//    private WebAppValidator userValidator;
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(userValidator);
//    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult result) {
        String errMsg = "";
        if (result.hasErrors()) {
            return "register";
        }
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Da co loi xay ra!";
            }
        } else {
            errMsg = "Mat khau khong khop!";
        }
        model.addAttribute("errMsg", errMsg);

        return "register";
    }

    @GetMapping("/registerCarrierIndex")
    public String registerCarrierView(Model model) {
        model.addAttribute("user", new User());
        return "registerCarrierIndex";
    }

    @PostMapping("/registerCarrierIndex")
    public String registerCarrierIndex(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";

        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addCarrier(user) == true) {
                System.out.println(user.getUserRole());
                return "redirect:/login";
            } else {
                errMsg = "Da co loi xay ra!";
            }

        } else {
            errMsg = "Mat khau khong khop!";
        }

        model.addAttribute("errMsg", errMsg);

        return "login";
    }

}
