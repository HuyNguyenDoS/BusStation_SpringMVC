/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Cart;
import com.btl.pojos.User;
import com.btl.service.BusService;
import com.btl.service.CategoryBusService;
import com.btl.service.EmployeeService;
import com.btl.service.RouteService;
import com.btl.service.ScheduleService;
import com.btl.utils.Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class HomeController {

    @Autowired
    private CategoryBusService categoryBusService;

    @Autowired
    private BusService busService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private Environment env;

    @ModelAttribute
    public void commAttr(Model model, HttpSession session) {
        model.addAttribute("categoryBuses", this.categoryBusService.getCategoryBuses());
        model.addAttribute("buses", this.busService.getBuses());
        model.addAttribute("schedules", this.scheduleService.getSchedules());
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));

    }

    @GetMapping("/") //HTTP GET
    @Transactional
    public String index(Model model,
            @RequestParam(required = false) Map<String, String> params,
            HttpSession session) {

        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute(("hotRoutes"), this.routeService.getListHotRoutes(6));

        return "index";
    }

    //LỊCH TRÌNH
    @RequestMapping("/home_routine") //HTTP GET
    @Transactional
    public String homeRoutine(Model model,
            @RequestParam(required = false) Map<String, String> params) {

        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("bus", this.busService.getBuses());
        model.addAttribute("routes", this.routeService.getRoutes(kw, page));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        model.addAttribute("counter", this.routeService.totalItem());
        model.addAttribute("schedules", this.scheduleService.getSchedules());
        return "home_routine";

        //s.close();
    }

    //LỊCH TRÌNH
    @RequestMapping("/home_routine/list_schedules") //HTTP GET
    @Transactional
    public String listSchedule(Model model,
            @RequestParam(name = "id", defaultValue = "0") int id) {

        model.addAttribute("schedules", this.scheduleService.getListSchedulesByIdRoute(id));
        model.addAttribute("size", this.scheduleService.getListSchedulesByIdRoute(id).size());

        //s.close();
        return "list_schedules";
    }

    @GetMapping("/home_schedule")
    public String getListHomeSchedule(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        String kw2 = params.getOrDefault("kw2", null);

        int page = Integer.parseInt(params.getOrDefault("page", "1")); // nếu có thì lấy biến page còn không thì trả về 1

        Date fromDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("schedules", this.busService.getListByCondition(kw, kw2, fromDate, page));
        model.addAttribute("counter", this.busService.getListByCondition(kw, kw2, fromDate, page).size());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        System.err.println("fromDate");
        return "home_schedule";
    }

}
