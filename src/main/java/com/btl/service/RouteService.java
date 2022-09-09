/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service;

import com.btl.pojos.Route;
import java.util.List;

public interface RouteService {

    List<Route> getRoutes();

    boolean addOrUpdate(Route route);

    boolean delete(int id);

    Route findById(int idRoute);

    Long totalItem();

    List<Object> getListByCondition(String kw, int page);

    List<Route> getRoutes(String kw, int page);

    List<Object[]> getListHotRoutes(int num);
}
