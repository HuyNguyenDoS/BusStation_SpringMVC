/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.service.BusService;
import com.btl.service.StatisticService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS-LAPTOP
 */
@RestController
public class ApiAdminController {

    @Autowired
    private BusService busService;

    @Autowired
    private StatisticService statisticService;

    @PostMapping("/api/state")
    public ResponseEntity<List<Object>> getrevenueStatsPeriod(@RequestBody Map<String, String> params, Model model) {
        try {
            String timeFrom = null, timeTo = null;

            String year = params.get("year");
            String period = params.get("period");

            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

            switch (period) {
                case "spring":
                    timeFrom = year + "-1-1";
                    timeTo = year + "-3-31";
                    break;
                case "summer":
                    timeFrom = year + "-4-1";
                    timeTo = year + "-6-30";
                    break;
                case "fall":
                    timeFrom = year + "-7-1";
                    timeTo = year + "-9-30";
                    break;
                case "winter":
                    timeFrom = year + "-10-1";
                    timeTo = year + "-12-31";
                    break;
            }

            Date fromDate = f.parse(timeFrom);
            Date toDate = f.parse(timeTo);

            List<Object> list = this.statisticService.RevenueStatsPeriod(fromDate, toDate);

            return ResponseEntity.ok(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
