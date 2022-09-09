/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.utils;

import com.btl.pojos.Cart;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

///**
// *
// * @author Nguyen
// */
public class Utils {

    public static int countCart(Map<Integer, Cart> cart) {
        int count = 0;
        if (cart != null) // nếu cart khác null
        {
            for (Cart c : cart.values()) //Trả ra danh sách các giá trị của giỏ
            {
                count += c.getQuantity();
            }
        }
        return count;
    }

    //Tính tiền
    public static Map<String, String> totalMoney(Map<Integer, Cart> cart) {
        BigDecimal total = BigDecimal.ZERO;
        int count = 0;

        if (cart != null) {
            for (Cart c : cart.values()) {
                count += c.getQuantity();
                total = total.add(c.getPrice().multiply(BigDecimal.valueOf(c.getQuantity())));

            }
        }
        Map<String, String> result = new HashMap<>();
        result.put("total", String.valueOf(total));
        result.put("quantity", String.valueOf(count));

        return result;
    }

}
