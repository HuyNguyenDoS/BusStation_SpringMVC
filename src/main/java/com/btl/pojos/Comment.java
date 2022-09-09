/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nguyen
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int idComment;

    private String content;
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;

    @ManyToOne(
            optional = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    @ManyToOne(
            optional = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_bus")
    @JsonIgnore
    private Bus bus;

    /**
     * @return the idComment
     */
    public int getIdComment() {
        return idComment;
    }

    /**
     * @param idComment the idComment to set
     */
    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
}
