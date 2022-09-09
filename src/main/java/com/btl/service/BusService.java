/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service;

import com.btl.pojos.Booking;
import com.btl.pojos.Bus;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BusService {

    List<Bus> getBuses(Map<String, String> params, int page);

    Bus getBusById(int busId);

    int countBus();

    List<Object[]> getBooking(Map<String, String> params, int page);

    List<Booking> getBooking();

    Booking getBookingById(int bookingID);

    boolean updateBooking(Booking booking, String status, String value);

    boolean bookingConfirm(String value, String gmail, int total, String nameCustomer, String date);

    List<Bus> getBuses();

    boolean addOrUpdate(Bus bus);

    boolean update(Bus bus, String active);

    //boolean update(Bus bus);
    boolean delete(int id);

    Bus findById(int idBus);

    Long totalItem();

    List<Object> getListByCondition(String kw, int page);

    List<Object> getListByCondition(String kw, String kw2, Date fromDate, int page);

    boolean checkBusName(String busName);

}
