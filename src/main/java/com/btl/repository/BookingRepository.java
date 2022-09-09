/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository;

import com.btl.pojos.Cart;
import java.util.List;
import java.util.Map;

public interface BookingRepository {

    boolean addBill(Map<Integer, Cart> cart, int id);

    int countBooking();

    List<Object[]> getListBooking(String kw, int page);

    List<Object[]> getListBookingDetail(int id);

    long totalItem();

}
