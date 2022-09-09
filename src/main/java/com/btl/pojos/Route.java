/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.pojos;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "route")
@JsonRootName(value = "routes ")
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departure;
    private String destination;
    private Double distance;

    @Column(name = "journey_time")
    private String journeyTime;

    @Column(name = "ticket_price")
    @NotNull(message = "{route.price.error.notNullMsg}")
    private BigDecimal ticketPrice;

    @Column(name = "image_departure")
    private String imageDeparture;

    @Column(name = "image_destination")
    private String imageDestination;

    @Column(name = "pick_up_point")
    private String pickUpPoint;

    @Column(name = "drop_off_point")
    private String dropOffPoint;

    //Không ứng với một cột của bảng csdl nào thì gắn @Transient
    @Transient
    private MultipartFile fileDeparture;

    @Transient
    private MultipartFile fileDestination;

    //Đối tượng cha bị xóa, thì đối tượng con cũng bị xóa
    @OneToMany(mappedBy = "route", cascade = {CascadeType.REMOVE},
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Schedule> schedules;

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
     * @return the departure
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
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
     * @return the distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * @return the journeyTime
     */
    public String getJourneyTime() {
        return journeyTime;
    }

    /**
     * @param journeyTime the journeyTime to set
     */
    public void setJourneyTime(String journeyTime) {
        this.journeyTime = journeyTime;
    }

    /**
     * @return the ticketPrice
     */
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    /**
     * @param ticketPrice the ticketPrice to set
     */
    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * @return the imageDeparture
     */
    public String getImageDeparture() {
        return imageDeparture;
    }

    /**
     * @param imageDeparture the imageDeparture to set
     */
    public void setImageDeparture(String imageDeparture) {
        this.imageDeparture = imageDeparture;
    }

    /**
     * @return the imageDestination
     */
    public String getImageDestination() {
        return imageDestination;
    }

    /**
     * @param imageDestination the imageDestination to set
     */
    public void setImageDestination(String imageDestination) {
        this.imageDestination = imageDestination;
    }

    /**
     * @return the fileDeparture
     */
    public MultipartFile getFileDeparture() {
        return fileDeparture;
    }

    /**
     * @param fileDeparture the fileDeparture to set
     */
    public void setFileDeparture(MultipartFile fileDeparture) {
        this.fileDeparture = fileDeparture;
    }

    /**
     * @return the fileDestination
     */
    public MultipartFile getFileDestination() {
        return fileDestination;
    }

    /**
     * @param fileDestination the fileDestination to set
     */
    public void setFileDestination(MultipartFile fileDestination) {
        this.fileDestination = fileDestination;
    }

    /**
     * @return the schedules
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * @param schedules the schedules to set
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    /**
     * @return the pickUpPoint
     */
    public String getPickUpPoint() {
        return pickUpPoint;
    }

    /**
     * @param pickUpPoint the pickUpPoint to set
     */
    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    /**
     * @return the dropOffPoint
     */
    public String getDropOffPoint() {
        return dropOffPoint;
    }

    /**
     * @param dropOffPoint the dropOffPoint to set
     */
    public void setDropOffPoint(String dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }

}
