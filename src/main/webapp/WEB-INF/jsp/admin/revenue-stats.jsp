<%-- 
    Document   : footer
    Created on : Jul 30, 2022, 1:38:05 PM
    Author     : Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="right_col" role="main" style="margin-top: 80px;margin-left: 320px">
    
    <div class="page-title">
                        <div class="title_left">
                                <h3>THỐNG KÊ DOANH THU</h3>
                        </div>
                </div>
        <div class="clearfix"></div>
                <div class="row">

                    <div class="col-md-12 col-sm-12  " id="table-buses">
                            <div class="x_panel">
                              <div class="x_title">
                                <h2>DOANH THU THEO NGÀY</h2>
                                
                                <div class="clearfix"></div>
                              </div>

                              <div class="x_content">

                            <div class="">
                                <h1 class="text-center text-danger"></h1>
                                <form action="">
                                    <div class="form-group">
                                        <label  class="timestats">Từ khóa</label>
                                        <input type="text" name="kw" class="form-control"/>

                                    </div>
                                    <div class="form-group">
                                        <label class="timestats">Từ thời điểm</label>
                                        <input type="date" name="fromDate" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="timestats">Đến thời điểm</label>
                                        <input type="date" name="toDate" class="form-control"/>

                                    </div>
                                    <input type="submit" value="Báo cáo" class="btn btn-success"/>
                                </form>
                                <div class="chart-size" >
                                      <canvas id="myRevenueStatsChart"></canvas>
                                    </div>
                                    <table class="table table-striped jambo_table bulk_action">
                                        <thead>
                                        <tr class="headings">
                                            <th class="column-title" id="col-num">Id</th>
                                            <th class="column-title">Tên tuyến xe</th>
                                              <th class="column-title">Ngày đặt</th>
                                              <th class="column-title">Doanh thu</th>
                                        </tr>
                                        </thead>
                                         <c:forEach items="${revenueStats}" var="b">
                                            <tr>
                                                <td>${b[5]}</td><!-- comment -->
                                                <td>${b[6]} - ${b[7]} </td>
                                                <td>${b[2]} </td> 
                                                <td class=" "><fmt:formatNumber type = "number" maxFractionDigits = "3" 
                                                          value = "${b[10]}"  /> VND</td>
                                            </tr>
                                        </c:forEach> 
                                    </table>
                                  <script>
                                let revenueLabels=[], revenueInfo=[];
                                <c:forEach items="${revenueStats}" var="c">
                                    revenueLabels.push('${c[6]} - ${c[7]}')
                                    revenueInfo.push(${c[10]})
                                </c:forEach>
                                window.onload = function(){
                                    revenueChart("myRevenueStatsChart", revenueLabels,revenueInfo)
                                }
                            </script>
                            </div>
                                  
                             </div>
                            </div>
                          </div>
                </div>
        
        
        
</div>


