/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Bus;
import com.btl.pojos.Schedule;
import com.btl.service.BusService;
import com.btl.service.CategoryBusService;
import com.btl.service.EmployeeService;
import com.btl.service.RouteService;
import com.btl.service.ScheduleService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice
public class ScheduleControllers {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BusService busService;

    @Autowired
    private CategoryBusService categoryBusService;

    @Autowired
    private RouteService routeService;

    @GetMapping("/admin/schedules")
    public String list(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("employees", this.employeeService.getEmployees());
        model.addAttribute("routes", this.routeService.getRoutes());
        model.addAttribute("bus", this.busService.getBuses());

        List<String> departureTimeList = Arrays.asList("01:00", "03:00", "05:00", "07:00", "09:00", "11:00", "13:00", "15:00", "17:00", "19:00", "21:00", "23:00");
        model.addAttribute("departureTimeList", departureTimeList);

        return "schedule";
    }

    //Tính năng upload
    //Khai báo upload controller và thêm chuyến xe
    @PostMapping("/admin/schedules")
    public String add(Model model, @ModelAttribute(value = "schedule") Schedule schedule) {

        //Trường hợp dữ liệu ổn
        if (this.scheduleService.addOrUpdate(schedule) == true) {
            return "redirect:/admin/schedules";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");
            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "schedule";

    }

    //EDIT BUS
    @RequestMapping("/admin/data_schedules")
    public String indexUpdate(Model model) {
        model.addAttribute("schedules", this.scheduleService.getSchedules());
        model.addAttribute("employees", this.employeeService.getEmployees());
        model.addAttribute("routes", this.routeService.getRoutes());
        model.addAttribute("buses", this.busService.getBuses());
        model.addAttribute("categoryBuses", this.categoryBusService.getCategoryBuses());
        return "data_schedule";
    }

    @PostMapping("/admin/data_schedules/update")
    public String Update(Model model, @ModelAttribute(value = "schedule") Schedule schedule) {

        //Trường hợp dữ liệu ổn
        if (this.scheduleService.addOrUpdate(schedule) == true) {
            return "redirect:/admin/data_schedules";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");

            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "update_schedule";

    }

    @GetMapping("/admin/data_schedules/update")
    public String listEdit(Model model,
            @RequestParam(name = "id", defaultValue = "0") int id) {
        if (id > 0) {
            model.addAttribute("schedule", this.scheduleService.findById(id));
            model.addAttribute("routes", this.routeService.getRoutes());

        } else {
            model.addAttribute("schedule", new Schedule());
        }
        return "update_schedule";
    }

    //DELETE DATA_SCHEDULE
    @GetMapping("/admin/data_schedules/delete")
    public String delete(Model model,
            @RequestParam(name = "id", defaultValue = "0") int id) {
        if (this.scheduleService.delete(id)) {
            model.addAttribute("message", "Xóa thành công");
        } else {
            model.addAttribute("message", "Xóa thất bại");
        }

        return "redirect:/admin/data_schedules";
    }

}
