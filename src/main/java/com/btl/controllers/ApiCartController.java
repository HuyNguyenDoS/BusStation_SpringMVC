/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Cart;
import com.btl.pojos.Route;
import com.btl.pojos.Schedule;
import com.btl.service.BookingService;
import com.btl.service.RouteService;
import com.btl.service.ScheduleService;
import com.btl.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiCartController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/api/schedules")
    public ResponseEntity<List<Schedule>> listSchedules() {
        List<Schedule> schedules = this.scheduleService.getSchedules();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PostMapping("api/cart") // Gửi bằng javascript thì dùng @RequestBody
    public int addToCart(@RequestBody Cart params,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");

        int scheduleId = params.getScheduleId();

        Schedule s = this.scheduleService.findById(scheduleId);

        if (cart == null)//Neu la null thi tao gio moi
        {
            cart = new HashMap<>();
        }

        //neu san pham da co trong gio roi
        if (cart.containsKey(scheduleId) == true) {
            Cart c = cart.get(scheduleId);
            //c.setName(s.);
            c.setDeparture(s.getRoute().getDeparture());
            c.setDestination(s.getRoute().getDestination());
            c.setBusName(s.getBus().getBusName());
            c.setCategoryBus(s.getBus().getCategoryBus().getName());
            c.setPrice(s.getRoute().getTicketPrice());
            c.setDepartureDate(s.getDepartureDate());
            c.setDepartureTime(s.getDepartureTime());

            c.setQuantity(c.getQuantity() + 1);

            c.setSeatNumber(s.getBus().getSeatNumber());
        } else {
            //san pham chua co trong gio

            cart.put(scheduleId, params);
        }
        session.setAttribute("cart", cart);

        return Utils.countCart(cart);

    }

    //CẬP NHẬT GIỎ HÀNG
    @PutMapping("/api/cart")
    public ResponseEntity<Map<String, String>> updateCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        int scheduleId = params.getScheduleId();

        if (cart.containsKey(scheduleId) == true) {
            Cart c = cart.get(scheduleId);
            c.setQuantity(params.getQuantity());

        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(Utils.totalMoney(cart), HttpStatus.OK);

    }

    //XÓA VÉ KHỎI GIỎI HÀNG
    @DeleteMapping("/api/cart/{scheduleId}")
    public ResponseEntity<Map<String, String>> removeItemFromCart(HttpSession session,
            @PathVariable(value = "scheduleId") int scheduleId) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(scheduleId)) {
            cart.remove(scheduleId);
            session.setAttribute("cart", cart);
        }
        return new ResponseEntity<>(Utils.totalMoney(cart), HttpStatus.OK);

    }

    @PostMapping("/api/payment/{id}")
    public HttpStatus payment(HttpSession session,
            @PathVariable(value = "id") int id) {
        if (this.bookingService.addBill((Map<Integer, Cart>) session.getAttribute("cart"), id) == true) {
            session.removeAttribute("cart");
            return HttpStatus.OK;

        }
        return HttpStatus.BAD_REQUEST;
    }

}
