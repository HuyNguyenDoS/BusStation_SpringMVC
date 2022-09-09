<%-- 
    Document   : footer
    Created on : Jul 30, 2022, 1:38:05 PM
    Author     : Nguyen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="right_col" role="main" style="margin-top: 80px;margin-left: 320px">
    
    <div class="page-title">
                        <div class="title_left">
                                <h3>CHI TIẾT THÔNG TIN VÉ ĐÃ ĐẶT</h3>
                        </div>
  
                </div>
        <div class="clearfix"></div>
                <div class="row">

                    <div class="col-md-12 col-sm-12  " id="table-buses">
                            <div class="x_panel">
                              <div class="x_title">
                                <h2>Khách hàng<small>${BookingDetail[13]} ${BookingDetail[14]}</small></h2>
              
                                <div class="clearfix"></div>
                              </div>

                              <div class="x_content">


                                <div class="table-responsive">
                                  <table class="table table-striped jambo_table bulk_action">
                                    <thead>
                                      <tr class="headings">

                                        <th class="column-title" id="col-num">Id</th>
                                        <th class="column-title">Tuyến xe</th>
                                        <th class="column-title">Nhà xe - Loại xe</th>                                        
                                        <th class="column-title">Biển số xe </th>
                                        <th class="column-title">Ngày khởi hành </th>
                                        <th class="column-title">Giờ khởi hành </th>   
                                        <th class="column-title">Số lượng </th>                                        
                                        <th class="column-title">Đơn giá </th>                                        

                                      </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="b" items="${BookingDetail}">
                                      <tr class="even pointer">

                                        <td class=" ">${b[0]}</td>
                                        <td class=" ">${b[3]} - ${b[4]}</td>
                                        <td class=" ">${b[5]} - ${b[7]}</td>
                                        <td class=" ">${b[6]}</td>
                                        <td class=" ">${b[8]}</td>
                                        <td class=" ">${b[9]}</td>
                                        <td class=" ">${b[1]}</td>
                                        <td class=" "><fmt:formatNumber type = "number" maxFractionDigits = "3" 
                                                          value = "${b[2]}"  /></td>
                                                                           
                                        

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

