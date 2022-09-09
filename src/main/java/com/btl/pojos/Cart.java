/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.pojos;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Nguyen
 */
public class Cart {

    private int scheduleId;
    private String departure;
    private String destination;

    private Date departureDate;
    private String departureTime;

    private String busName;
    private String categoryBus;

    private BigDecimal price;
    private int quantity;

    private int seatNumber;

    /**
     * @return the scheduleId
     */
    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId the scheduleId to set
     */
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * @return the name
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param departure the name to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the seatNumber
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber the seatNumber to set
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the busName
     */
    public String getBusName() {
        return busName;
    }

    /**
     * @param busName the busName to set
     */
    public void setBusName(String busName) {
        this.busName = busName;
    }

    /**
     * @return the categoryBus
     */
    public String getCategoryBus() {
        return categoryBus;
    }

    /**
     * @param categoryBus the categoryBus to set
     */
    public void setCategoryBus(String categoryBus) {
        this.categoryBus = categoryBus;
    }

    /**
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime the departureTime to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

}
