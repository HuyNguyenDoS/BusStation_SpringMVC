/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Bus;
import com.btl.pojos.User;
import com.btl.service.BusService;
import com.btl.service.CommentService;
import com.btl.service.EmployeeService;
import com.btl.service.UserService;
//import com.btl.validator.WebAppValidator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

//    @Autowired
//    private WebAppValidator busValidator;
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(busValidator);
//    }
    @GetMapping("/admin/buses")
    public String list(Model model) {

        model.addAttribute("bus", new Bus());
        model.addAttribute("employees", this.employeeService.getEmployees());

        return "bus";
    }

    //Tính năng upload
    //Khai báo upload controller và thêm chuyến xe
    @PostMapping("/admin/buses")
    public String add(Model model, @ModelAttribute(value = "bus") @Valid Bus bus, BindingResult result) {
        if (result.hasErrors()) {
            return "bus";

        }//Trường hợp dữ liệu ổn
        if (this.busService.addOrUpdate(bus) == true) {
            return "redirect:/admin/buses";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");
            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "bus";

    }

    //EDIT BUS
    @RequestMapping("/admin/data_buses")
    public String indexUpdate(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1")); // nếu có thì lấy biến page còn không thì trả về 1

        model.addAttribute("buses", this.busService.getListByCondition(kw, page));
        model.addAttribute("size", this.busService.getListByCondition(kw, page).size());
        model.addAttribute("counter", this.busService.totalItem());
        model.addAttribute("employees", this.employeeService.getEmployees());

        return "data_bus";
    }

    @PostMapping("/admin/data_buses/update")
    public String Update(Model model, @ModelAttribute(value = "bus") Bus bus) {

        //Trường hợp dữ liệu ổn
        if (this.busService.addOrUpdate(bus) == true) {
            return "redirect:/admin/data_buses";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");
            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "update_bus";

    }

    @GetMapping("/admin/data_buses/update")
    public String listEdit(Model model,
            @RequestParam(name = "idBus", defaultValue = "0") int idBus) {
        if (idBus > 0) {
            model.addAttribute("bus", this.busService.findById(idBus));
            model.addAttribute("employees", this.employeeService.getEmployees());

        } else {
            model.addAttribute("bus", new Bus());
        }
        return "update_bus";
    }

    //DELETE DATA BUSES
    @GetMapping("/admin/data_buses/delete")
    public String delete(Model model,
            @RequestParam(name = "idBus", defaultValue = "0") int idBus) {
        if (this.busService.delete(idBus)) {
            model.addAttribute("message", "Xóa thành công");
        } else {
            model.addAttribute("message", "Xóa thất bại");
        }

        return "redirect:/admin/data_buses";
    }

    //BUS_DETAIL
    @GetMapping("/list_buses")
    public String listBuses(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        model.addAttribute("buses", this.busService.getListByCondition(kw, page));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        model.addAttribute("counter", this.busService.totalItem());

        return "list_buses";
    }

    @GetMapping("/bus_detail/{idBus}")
    public String busDetail(Model model,
            @PathVariable(value = "idBus") int id,
            @RequestParam(required = false) Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        Bus b = this.busService.findById(id);

        User u = this.userService.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("bus", b);
        model.addAttribute("comments", this.commentService.getCommentsByidBus(id, page));
        model.addAttribute("commentCounter", this.commentService.totalItem(id));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "bus_detail";
    }

}
