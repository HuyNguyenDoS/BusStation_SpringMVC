<%-- 
    Document   : product-stats-month
    Created on : Feb 13, 2022, 2:32:22 PM
    Author     : ASUS-LAPTOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
                                <h2>DOANH THU THEO THÁNG</h2>
                                
                                <div class="clearfix"></div>
                              </div>

                              <div class="x_content">



                                  <div class="content-padding" style="padding: 10px 120px;">
                                <h1 class="text-center text-danger"></h1>
                                <form action="">
<!--                                    <div class="form-group">
                                        <label  class="timestats">Từ khóa</label> comment 
                                        <input type="text" name="kw" class="form-control"/>

                                    </div>-->
                                    <div class="form-group">
                                        <label class="timestats">Từ thời điểm</label><!-- comment -->
                                        <input type="date" name="fromDate" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="timestats">Đến thời điểm</label><!-- comment -->
                                        <input type="date" name="toDate" class="form-control"/>

                                    </div>
                                    <input type="submit" value="Báo cáo" class="btn btn-success"/>
                                </form>
                                <div class="chart-size" >
                                    <canvas id="myRevenueStatsMonthChart" style="margin-bottom: 50px; margin-top: 50px"></canvas>
                                    </div>
                                    <table class="table table-striped jambo_table bulk_action">
                                        <thead>
                                            <tr class="headings">
                                                <th class="column-title">Tháng</th>
                                                <th class="column-title">Tuyến đi</th>
                                                <th class="column-title">Doanh thu</th>
                                        </tr>
                                        </thead>
                                         <c:forEach items="${revenueStatsMonth}" var="b">
                                            <tr>
                                                <td>${b[0]}/${b[1]} </td> 
                                                <td>${b[8]} - ${b[9]} </td> 
                                                  <td class=" "><fmt:formatNumber type = "number" maxFractionDigits = "3" 
                                                          value = "${b[12]}"  /> VND</td>
                                            </tr>
                                        </c:forEach> 
                                    </table>
                                  <script>
                                let revenueLabels=[], revenueInfo=[];
                                <c:forEach items="${revenueStatsMonth}" var="c">
                                    revenueLabels.push('${c[0]} - ${c[1]}')
                                    revenueInfo.push(${c[12]})
                                </c:forEach>
                                window.onload = function(){
                                    revenueMonthChart("myRevenueStatsMonthChart", revenueLabels,revenueInfo);
                                }
                            </script>
                            </div>
                            </div>
                            </div>
                          </div>
                </div>
        

        
        
</div>


