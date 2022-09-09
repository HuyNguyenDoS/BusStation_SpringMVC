/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.sql.Date;
//import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nguyen
 */
@Entity
@Table(name = "schedule")
@JsonRootName(value = "schedules")
public class Schedule implements Serializable {

    @Id
    @Column(name = "id_schedule")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "departure_date")
    //@Temporal (javax.persistence.TemporalType.TIMESTAMP)
    private Date departureDate;

    @Column(name = "destination_date")
    //@Temporal (javax.persistence.TemporalType.TIMESTAMP)
    //@JsonIgnore
    private Date destinationDate;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "destination_time")
    private String destinationTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_route")
    //@JsonIgnore
    private Route route;

    //Cau hinh khoa ngoai
    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonIgnore
    @JoinColumn(name = "id_bus")
    private Bus bus;

    //ChiTietHoaDon
    @OneToMany(mappedBy = "schedule")//gắn với thuộc tính trong class bên kết nối
    //@JsonIgnore// k lay khi truyenlen Json
    private List<BookingDetail> bookingDetails;

    public Schedule() {
    }

    public Schedule(int id, Route route, Bus bus, Date departureDate, Date destinationDate, String departureTime, String destinationTime) {
        this.id = id;
        this.route = route;
        this.bus = bus;
        this.departureDate = departureDate;
        this.destinationDate = departureDate;
        this.departureTime = departureTime;
        this.destinationTime = departureTime;

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the destinationDate
     */
    public Date getDestinationDate() {
        return destinationDate;
    }

    /**
     * @param destinationDate the destinationDate to set
     */
    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    /**
     * @return the route
     */
    public Route getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(Route route) {
        this.route = route;
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

    /**
     * @return the destinationTimeString
     */
    public String getDestinationTime() {
        return destinationTime;
    }

    /**
     * @param destinationTime the destinationTimeString to set
     */
    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    /**
     * @return the bus
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * @param bus the bus to set
     */
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    /**
     * @return the bookingDetails
     */
    public List<BookingDetail> getBookingDetails() {
        return bookingDetails;
    }

    /**
     * @param bookingDetails the bookingDetails to set
     */
    public void setBookingDetails(List<BookingDetail> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

}
