/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Bus;
import com.btl.pojos.User;
import com.btl.repository.StatisticRepository;
import com.btl.service.BookingService;
import com.btl.service.BusService;
import com.btl.service.CategoryBusService;
import com.btl.service.EmployeeService;
import com.btl.service.StatisticService;
import com.btl.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

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
    public String admin(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        //đếm số lượng user
        model.addAttribute("countUser", this.userDetailsService.countUser());
        //liệt kê danh sách carrirer
        Model car = model.addAttribute("bus", this.busService.getBuses(params, page));
        //đếm toognr số bill
        model.addAttribute("countBooking", this.bookingService.countBooking());

        System.err.println(this.busService.getBuses(params, page).get(0).getTitle());
        return "admin-index";
    }

    @GetMapping("/update")
    public String updateBus(Model model, @ModelAttribute(value = "bus") Bus bus, @RequestParam Map<String, String> params) {
        int idBus = Integer.parseInt(params.get("idBus"));
        String active = params.get("active");
        Bus c = this.busService.getBusById(idBus);
        System.err.println(c);
        System.err.println(idBus);
        System.err.println(active);
        if (this.busService.update(c, active)) {
            return "redirect:/admin";
        } else {
            return "redirect:/admin";
        }
    }

    @GetMapping("/registerStaff")
    public String registerStaffView(Model model) {
        model.addAttribute("user", new User());
        return "registerStaff";
    }

    @PostMapping("/registerStaff")
    public String registerStaff(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";

        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addStaff(user) == true) {
                System.out.println(user.getUserRole());
                return "redirect:/admin";
            } else {
                errMsg = "Da co loi xay ra!";
            }
        } else {
            errMsg = "Mat khau khong khop!";
        }

        model.addAttribute("errMsg", errMsg);

        return "admin";
    }

    @GetMapping("/registerCarrier")
    public String list(Model model) {

        model.addAttribute("bus", new Bus());
        model.addAttribute("employees", this.employeeService.getEmployees());

        return "registerCarrier";
    }

    @PostMapping("/registerBus")
    public String add(Model model, @ModelAttribute(value = "buses") Bus bus) {

        //Trường hợp dữ liệu ổn
        if (this.busService.addOrUpdate(bus) == true) {
            return "redirect:/admin/";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");
            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "registerBus";

    }

    //EDIT BUS
    @RequestMapping("/category-statistic")
    public String indexUpdate(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1")); // nếu có thì lấy biến page còn không thì trả về 1

        model.addAttribute("buses", this.statisticService.getStatistic(kw, page));
        model.addAttribute("size", this.statisticService.getStatistic(kw, page).size());

        return "category-statistic";
    }

    @GetMapping("/revenue-stats")
    public String revenueStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }
            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("revenueStats", this.statisticService.RevenueStats(kw, fromDate, toDate));
        return "revenue-stats";
    }

    @GetMapping("/revenue-stats-month")
    public String revenueStatsMonth(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }
            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("revenueStatsMonth", this.statisticService.RevenueStatsMonth(kw, fromDate, toDate));

        return "revenue-stats-month";
    }

    @GetMapping("/revenue-stats-period")
    public String revenueStatsPeriod(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }
            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("revenueStatsPeriod", this.statisticService.RevenueStatsPeriod(fromDate, toDate));
        return "revenue-stats-period";
    }
}
