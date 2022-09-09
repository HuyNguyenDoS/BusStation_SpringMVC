/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nguyen
 */
@Entity
@Table(name = "category_bus")
public class CategoryBus implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_bus_type")

    private int id;

    private String name;

    private String description;

    //Demo oneToMany
    @OneToMany(mappedBy = "categoryBus", fetch = FetchType.EAGER) //nếu để trống thì mặc định của OneToMany là LAZY
    //Mappedby đến "private CategoryBus categoryBus;" của lớp Bus.java
    private List<Bus> buses;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the buses
     */
    public List<Bus> getBuses() {
        return buses;
    }

    /**
     * @param buses the buses to set
     */
    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

}
