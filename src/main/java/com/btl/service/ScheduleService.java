/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service;

import com.btl.pojos.Schedule;
import java.util.List;

public interface ScheduleService {

    List<Schedule> getSchedules();

    boolean addOrUpdate(Schedule schedule);

    boolean delete(int id);

    Schedule findById(int id);

    List<Schedule> getListSchedulesByIdRoute(int id);

}
