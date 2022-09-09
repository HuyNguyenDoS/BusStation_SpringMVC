/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Booking;
import com.btl.pojos.Bus;
import com.btl.service.BookingService;
import com.btl.service.BusService;
import com.btl.service.CategoryBusService;
import com.btl.service.EmployeeService;
import com.btl.service.StatisticService;
import com.btl.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen
 */
@Controller
@RequestMapping("/carrier")
public class CarrierController {

    @Autowired
    private BusService busService;
    @Autowired
    private CategoryBusService categoryBusSevice;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public String carrier(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        //đếm số lượng user
        model.addAttribute("countUser", this.userDetailsService.countUser());
        //liệt kê danh sách carrirer
        Model car = model.addAttribute("bus", this.busService.getBuses(params, page));
        //liệt kê danh sách đơn hàng đang chờ
        Model booking = model.addAttribute("booking", this.busService.getBooking(params, page));

        //đếm toognr số bill
        model.addAttribute("countBooking", this.bookingService.countBooking());

        System.err.println(this.busService.getBuses(params, page).get(0).getTitle());
        return "carrier-index";
    }
    //mới

    @GetMapping("/update/{value}/{gmail}")
    public String updateBooking(Model model, @ModelAttribute(value = "booking") Booking booking, @PathVariable(value = "value") String value,
            @PathVariable(value = "gmail") String gmail, @RequestParam Map<String, String> params) {
        int bookingID = Integer.parseInt(params.get("bookingID"));
        String status = params.get("status");
        int total = Integer.parseInt(params.get("total"));
        String nameCustomer = params.get("nameCustomer");
        String date = params.get("date");
        Booking c = this.busService.getBookingById(bookingID);

        System.err.println(bookingID);
        System.err.println(status);
        System.err.println(value);
        System.err.println(gmail);
        System.err.println(total);
        System.err.println(nameCustomer);
        System.err.println(date);

        if (this.busService.updateBooking(c, status, value)) {
            this.busService.bookingConfirm(value, gmail, total, nameCustomer, date);
            return "redirect:/carrier";
        } else {
            return "redirect:/carrier";
        }
    }

    @GetMapping("/buses")
    public String list(Model model) {

        model.addAttribute("bus", new Bus());
        model.addAttribute("employees", this.employeeService.getEmployees());

        return "busCarrier";
    }

    @PostMapping("/buses")
    public String add(Model model, @ModelAttribute(value = "bus") @Valid Bus bus, BindingResult result) {
        if (result.hasErrors()) {
            return "busCarrier";

        }
        //Trường hợp dữ liệu ổn
        if (this.busService.addOrUpdate(bus) == true) {
            return "redirect:/carrier/buses";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");
            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "busCarrier";

    }

    //EDIT BUS
    @RequestMapping("/data_buses")
    public String indexUpdate(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1")); // nếu có thì lấy biến page còn không thì trả về 1

        model.addAttribute("buses", this.busService.getListByCondition(kw, page));
        model.addAttribute("size", this.busService.getListByCondition(kw, page).size());
        model.addAttribute("counter", this.busService.totalItem());
        model.addAttribute("employees", this.employeeService.getEmployees());

        return "data_busCarrier";
    }

    @PostMapping("/data_buses/update")
    public String Update(Model model, @ModelAttribute(value = "bus") Bus bus) {

        //Trường hợp dữ liệu ổn
        if (this.busService.addOrUpdate(bus) == true) {
            return "redirect:/carrier/data_buses";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");
            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "update_busCarrier";

    }

    @GetMapping("/data_buses/update")
    public String listEdit(Model model,
            @RequestParam(name = "idBus", defaultValue = "0") int idBus) {
        if (idBus > 0) {
            model.addAttribute("bus", this.busService.findById(idBus));
            model.addAttribute("employees", this.employeeService.getEmployees());

        } else {
            model.addAttribute("bus", new Bus());
        }
        return "update_busCarrier";
    }
}
