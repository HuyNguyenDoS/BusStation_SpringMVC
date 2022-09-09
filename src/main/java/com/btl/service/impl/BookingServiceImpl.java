/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service.impl;

import com.btl.pojos.Cart;
import com.btl.repository.BookingRepository;
import com.btl.service.BookingService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

///**
// *
// * @author Nguyen
// */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public boolean addBill(Map<Integer, Cart> cart, int id) {
        if (cart != null) {
            return this.bookingRepository.addBill(cart, id);
        }
        return false;
    }

    @Override
    public List<Object[]> getListBooking(String kw, int page) {
        return this.bookingRepository.getListBooking(kw, page);
    }

    @Override
    public List<Object[]> getListBookingDetail(int id) {
        return this.bookingRepository.getListBookingDetail(id);
    }

    @Override
    public long totalItem() {
        return this.bookingRepository.totalItem();
    }

    @Override
    public int countBooking() {
        return this.bookingRepository.countBooking();
    }
}
