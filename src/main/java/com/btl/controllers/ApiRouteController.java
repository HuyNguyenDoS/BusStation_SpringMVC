/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Route;
import com.btl.service.RouteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/api/routes")
    public ResponseEntity<List<Route>> listRoutes() {
        List<Route> routes = this.routeService.getRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

}
