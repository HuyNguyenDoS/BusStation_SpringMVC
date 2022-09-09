/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Cart;
import com.btl.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Nguyen
 */
@Controller
public class CartController {

    //HttpSession bộ dữ liệu để nạp session
    @GetMapping("/cart")
    public String gioHang(Model model, HttpSession session) {

        // kiem tra có giỏ hàng chưa
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null)// có giỏ rồi
        {
            model.addAttribute("carts", cart.values());// ds các item bỏ vô giỏ
        } else {
            model.addAttribute("carts", null);
        }

        model.addAttribute("totalMoney", Utils.totalMoney(cart));

        return "cart";
    }
}
