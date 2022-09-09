/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service.impl;

import com.btl.pojos.Route;
import com.btl.repository.RouteRepository;
import com.btl.service.RouteService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Route> getRoutes() {
        return this.routeRepository.getRoutes();
    }

    @Override
    public boolean addOrUpdate(Route route) {
        try {
            if (route.getId() > 0) {
                if (route.getFileDeparture().getBytes().length == 0 && route.getFileDestination().getBytes().length == 0) {
                    Route ro = this.routeRepository.findById(route.getId());
                    route.setImageDeparture(ro.getImageDeparture());
                } else {
                    // Để hứng dữ liệu sau khi upload xong dùng Map
                    Map r = this.cloudinary.uploader().upload(route.getFileDeparture().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    route.setImageDeparture((String) r.get("secure_url"));

                    Map n = this.cloudinary.uploader().upload(route.getFileDestination().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    route.setImageDestination((String) n.get("secure_url"));
                }
            } else {
                if (route.getFileDeparture().getBytes().length != 0 && route.getFileDestination().getBytes().length != 0) {
                    // Để hứng dữ liệu sau khi upload xong dùng Map
                    Map r = this.cloudinary.uploader().upload(route.getFileDeparture().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    route.setImageDeparture((String) r.get("secure_url"));

                    Map n = this.cloudinary.uploader().upload(route.getFileDestination().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    route.setImageDestination((String) n.get("secure_url"));
                } else {
                    route.setImageDeparture("");
                    route.setImageDestination("");
                }
            }
            //Gọi repository để lưu xuống
            return this.routeRepository.addOrUpdate(route);

            //Khi upload thành công tạm thời cho trở về trang chủ
            //return "redirect:/";
        } catch (IOException ex) {
            //Xuất lỗi
            System.err.println("Add route " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Route r = this.findById(id);
        return this.routeRepository.delete(r);
    }

    @Override
    public Route findById(int idRoute) {
        return this.routeRepository.findById(idRoute);
    }

    @Override
    public Long totalItem() {
        return this.routeRepository.totalItem();
    }

    @Override
    public List<Object> getListByCondition(String kw, int page) {
        return this.routeRepository.getListByCondition(kw, page);
    }

    @Override
    public List<Route> getRoutes(String kw, int page) {
        return this.routeRepository.getRoutes(kw, page);
    }

    @Override
    public List<Object[]> getListHotRoutes(int num) {
        return this.routeRepository.getHotRoutes(num);
    }

}
