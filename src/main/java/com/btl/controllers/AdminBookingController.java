/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Customer;
import com.btl.pojos.Employee;
import com.btl.service.BookingService;
import com.btl.service.BusService;
import com.btl.service.CustomerService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PropertySource("classpath:messages.properties")
public class AdminBookingController {

    @Autowired
    private BusService busService;

    @Autowired
    private Environment env;
    @Autowired
    private BookingService bookingService;

    //BOOKING
    @GetMapping("/admin/data_booking")
    public String ListBooking(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1")); // nếu có thì lấy biến page còn không thì trả về 1

        model.addAttribute("booking", this.bookingService.getListBooking(kw, page));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        model.addAttribute("counter", this.bookingService.totalItem());

        return "data_booking";
    }

    //BOOKING-DETAIL
    @GetMapping("/admin/data_booking_detail/{id}")
    public String ListBookingDetail(Model model,
            @PathVariable(value = "id") int id,
            @RequestParam(required = false) Map<String, String> params) {

        model.addAttribute("BookingDetail", this.bookingService.getListBookingDetail(id));

        return "data_booking_detail";
    }

}
