<%-- 
    Document   : footer
    Created on : Jul 30, 2022, 1:38:05 PM
    Author     : Nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <link rel="stylesheet" href="<spring:url value="/resources/css/chart.css" />" >
<script  type="text/javascript" src="<c:url value="/resources/js/state.js"/>" ></script>
<div class="right_col" role="main" style="margin-top: 80px;margin-left: 320px">
    
    <div class="page-title">
                        <div class="title_left">
                                <h3>THỐNG KÊ DANH MỤC</h3>
                        </div>

                 
                </div>
        <div class="clearfix"></div>
                <div class="row">

                    <div class="col-md-12 col-sm-12  " id="table-buses">
                            <div class="x_panel">
                              <div class="x_title">
                                <h2>THỐNG KÊ MẬT ĐỘ TUYẾN XE THEO CHUYẾN XE</h2>
                                
                                <div class="clearfix"></div>
                              </div>

                              <div class="x_content">


                            <div class="">

                                <div class="chart-size" >
                                      <canvas id="myChart"></canvas>
                                    </div>
                                    <table class="table table-striped jambo_table bulk_action">
                                        <thead>
                                        <tr class="headings">
                                            <th class="column-title" id="col-num">Id</th>
                                             <th class="column-title">Tuyến xe</th>
                                             <th class="column-title">Nhà xe</th>
                                             <th class="column-title" id="col-num">Số lượng xe</th>



                                        </tr>
                                        </thead>

                                         <c:forEach items="${buses}" var="b">
                                            <tr>
                                                    <td class=" ">${b[0]}</td>
                                                    <td class=" ">${b[3]} - ${b[4]}</td>
                                                    <td class=" ">${b[7]} - ${b[9]}</td>
                                                    <td class="">${b[10]}</td>

                                            </tr>
                                        </c:forEach> 
                                    </table>

                                <script>
                                let cateLabels=[], cateInfo=[];
                                <c:forEach items="${buses}" var="c">
                                    cateLabels.push('${c[3]} - ${c[4]}')
                                    cateInfo.push(${c[10]})
                                </c:forEach>
                                window.onload = function(){
                                    cateChart("myChart", cateLabels,cateInfo)
                                }
                            </script>
                            </div>

                              </div>
                            </div>
                          </div>
                </div>
        
        
        
</div>

