/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.repository;

import com.btl.pojos.Schedule;
import java.util.List;

public interface ScheduleRepository {

    List<Schedule> getSchedules();

    boolean addOrUpdate(Schedule schedule);

    boolean delete(Schedule schedule);

    Schedule findById(int id);

    List<Schedule> getListSchedulesByIdRoute(int id);

}
