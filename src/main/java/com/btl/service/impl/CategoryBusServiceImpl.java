/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service.impl;

import com.btl.pojos.CategoryBus;
import com.btl.repository.CategoryBusRepository;
import com.btl.service.CategoryBusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryBusServiceImpl implements CategoryBusService {

    @Autowired
    private CategoryBusRepository categoryBusRepository;

    @Override
    public List<CategoryBus> getCategoryBuses() {
        return this.categoryBusRepository.getCategoryBuses();
    }

}
