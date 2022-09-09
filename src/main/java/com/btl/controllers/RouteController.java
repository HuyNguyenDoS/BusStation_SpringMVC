/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Bus;
import com.btl.pojos.Route;
import com.btl.service.BusService;
import com.btl.service.CategoryBusService;
import com.btl.service.RouteService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/admin/routes")
    public String list(Model model) {
        model.addAttribute("route", new Route());
        return "route";
    }

    //Tính năng upload
    //Khai báo upload controller và thêm chuyến đi
    @PostMapping("/admin/routes")
    public String addRoute(Model model, @ModelAttribute(value = "route") @Valid Route route, BindingResult result) {
        if (result.hasErrors()) {
            return "route";

        }
        //Trường hợp dữ liệu ổn
        if (this.routeService.addOrUpdate(route) == true) {
//           model.addAttribute("message", "Thêm tuyến xe thành công");
            return "redirect:/admin/routes";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");

        }
        return "route";
    }

    //EDIT ROUTE
    @RequestMapping("/admin/data_routes")
    public String indexUpdate(Model model,
            @RequestParam(required = false) Map<String, String> params) {

        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1")); // nếu có thì lấy biến page còn không thì trả về 1

        model.addAttribute("routes", this.routeService.getRoutes(kw, page));
        model.addAttribute("size", this.routeService.getRoutes(kw, page).size());
        model.addAttribute("counter", this.routeService.totalItem());

        return "data_route";
    }

    @PostMapping("/admin/data_routes/update")
    public String Update(Model model, @ModelAttribute(value = "route") Route route) {

        //Trường hợp dữ liệu ổn
        if (this.routeService.addOrUpdate(route) == true) {

            return "redirect:/admin/data_routes";
        } else {
            model.addAttribute("errMsg", "Có lỗi xảy ra");
            //Khi upload thất bại vẫn ở lại trang bus.
        }
        return "update_route";

    }

    @GetMapping("/admin/data_routes/update")
    public String listEdit(Model model,
            @RequestParam(name = "id", defaultValue = "0") int id) {
        if (id > 0) {
            model.addAttribute("route", this.routeService.findById(id));

        } else {
            model.addAttribute("route", new Route());
        }
        return "update_route";
    }

    //DELETE DATA_ROUTES
    @GetMapping("/admin/data_routes/delete")
    public String delete(Model model,
            @RequestParam(name = "id", defaultValue = "0") int id) {
        if (this.routeService.delete(id)) {
            model.addAttribute("message", "Xóa thành công");
        } else {
            model.addAttribute("message", "Xóa thất bại");
        }

        return "redirect:/admin/data_routes";
    }

}
