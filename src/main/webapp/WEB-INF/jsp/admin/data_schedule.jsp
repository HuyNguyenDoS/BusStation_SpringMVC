

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<div class="right_col" role="main" style="margin-top: 80px;margin-left: 320px">
    
    <div class="page-title">
                        <div class="title_left">
                                <h3>BẢNG DỮ LIỆU LỊCH CHẠY</h3>
                        </div>                      
                </div>
        <div class="clearfix"></div>
                <div class="row">

                    <div class="col-md-12 col-sm-12  " id="table-buses">
                            <div class="x_panel">
                              <div class="x_title">
                                <h2><small> Cập nhật  lịch trình</small></h2>
                                
                                <div class="clearfix"></div>
                              </div>

                              <div class="x_content">


                                <div class="table-responsive">
                                  <table class="table table-striped jambo_table bulk_action">
                                    <thead>
                                      <tr class="headings">
                                        <th class="column-title" id="col-num">Id </th>
                                        <th class="column-title">Tuyến xe </th>
                                        <th class="column-title">Ngày khởi hành </th>
                                        <th class="column-title">Ngày về </th>
                                        <th class="column-title">Thời gian đi</th>
                                        <th class="column-title">Chuyến xe </th>                                       
                                   
                                        
                                        <th class="column-title no-link last  a-right a-right"><span class="nobr ">Action</span>
                                        </th>
                                        <th class="bulk-actions" colspan="7">
                                          <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                        </th>
                                      </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="s" items="${schedules}">
                                      <tr class="even pointer">

                                        <td class=" ">${s.id}</td>
                                        <td class=" ">${s.route.departure} - <br>  ${s.route.destination}</td>
                                        <td class=" ">${s.departureDate}</td>
                                        <td class=" ">${s.destinationDate}</td>
                                        <td class=" ">${s.departureTime}</td>                                                                      -->
                                        <td class=" ">${s.bus.busName} - ${s.bus.categoryBus.name}</td>
                                       
                                        
                                        

                                        <td class=" last a-right a-right ">
                                            <div class="btn-edit">
                                                <a class="btn btn-default" href=" <c:url value="data_schedules/update?id=${s.id}" />"><span class="glyphicon glyphicon-pencil"></span></a>
                                            </div>
                                        </td>
                                      </tr>
                                        </c:forEach>

                                    </tbody>
                                  </table>
                                </div>


                              </div>
                            </div>
                          </div>
                </div>
        
        
        
</div>

