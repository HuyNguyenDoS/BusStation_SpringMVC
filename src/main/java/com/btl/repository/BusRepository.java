/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository;

import com.btl.pojos.Booking;
import com.btl.pojos.Bus;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen
 */
public interface BusRepository {

    List<Bus> getBuses(Map<String, String> params, int page);

    Bus getBusById(int busId);

    int countBus();

    //thêm mới hai method
    List<Object[]> getBooking(Map<String, String> params, int page);

    List<Booking> getBooking();

    Booking getBookingById(int bookingID);

    boolean updateBooking(Booking booking, String status, String value);

    boolean bookingConfirm(String value, String gmail, int total, String nameCustomer, String date);

    List<Bus> getBuses();

    //create
    boolean addOrUpdate(Bus bus);

    //delete
    boolean delete(Bus bus);

    boolean update(Bus bus, String active);

    //find by id
    Bus findById(int idBus);

    //total item
    long totalItem();

    List<Object> getListByCondition(String kw, int page);

    List<Object> getListByCondition(String kw, String kw2, Date fromDate, int page);

    boolean checkBusName(String name);

}
