/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @DeleteMapping("/api/updateCart/{scheduleId}")
    @ResponseStatus(HttpStatus.OK)
    public void RemoveItemFromCart(@PathVariable(name = "scheduleId") int scheduleId) {
        this.scheduleService.delete(scheduleId);
    }
}
