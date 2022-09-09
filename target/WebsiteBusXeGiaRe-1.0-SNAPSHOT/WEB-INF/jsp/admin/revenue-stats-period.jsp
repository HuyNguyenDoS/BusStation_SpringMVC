<%-- 
    Document   : footer
    Created on : Jul 30, 2022, 1:38:05 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

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
                                <h2>DOANH THU THEO QUÝ</h2>
                                
                                <div class="clearfix"></div>
                              </div>

                              <div class="x_content">

                            <div class="content">
                                    <div class="container-fluid">
                                        <div class="filter input-group mb-3">
                                            <nav class="nav-menu d-none d-lg-block">
                                                <ul>
                                                    <!-- THE LEVEL FILTER OF CONDITIONS -->
                                                    <li class="nav-item"><a class="nav-link collapsed" href="<c:url value="/admin/revenue-stats-period"/>">ĐIỀU KIỆN THEO MÙA</a>
                                                        <ul class="scrolltable" style="list-style-type: none">                     
                                                            <li><a class="nav-link collapsed" >
                                                                    <input type="radio" name="rbdM" value="spring" id="xuan"/> <label for="xuan">&nbsp;&nbsp;XUÂN</label>
                                                                </a></li>
                                                            <li><a  class="nav-link collapsed" >
                                                                    <input type="radio" name="rbdM" value="summer" id="ha"/> <label for="ha">&nbsp;&nbsp;HẠ</label>
                                                                </a></li>
                                                            <li><a class="nav-link collapsed" >
                                                                    <input type="radio" name="rbdM" value="fall" id="thu"/> <label for="thu">&nbsp;&nbsp;THU</label>
                                                                </a></li>
                                                            <li><a class="nav-link collapsed" >
                                                                    <input type="radio" name="rbdM" value="winter" id="dong"/> <label for="dong">&nbsp;&nbsp;ĐÔNG</label>
                                                                </a></li>
                                                        </ul>
                                                    </li>
                                                    <!-- THE SALARY FILTER OF CONDITIONS -->
                                                    <li class="drop-down"><a class="nav-link collapsed" href="<c:url value="/admin/revenue-stats-period"/>">ĐIỀU KIỆN THEO NĂM</a>
                                                        <ul class="scrolltable" style="list-style-type: none">                    
                                                            <li><a class="nav-link collapsed" >
                                                                    <input type="radio" name="rdbY" value="2022" id="nam"/><label for="nam">&nbsp;&nbsp;2022</label>
                                                                </a></li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </nav>

                                        </div>
                                        <div class=" input-group mb-3">
                                               <button type="button"
                                                        class="btn btn-success" onclick="sendCondition()">Báo cáo
                                                </button>
                                        </div>
                                                        
                                           
                                                        <div class="card-body" style="width: 400px">
                                                        <canvas id="doughnutchart"></canvas>  
                                                    </div>
                                                        
                                         
                                                    <div class="card-body ">
                                                        <div class="ct-chart">
                                                            <table id="chartTable" class="table table-striped jambo_table bulk_action">
                                                                <thead id="title-Table">
                                                                <tr class="headings">
<!--                                                                        <th>Id</th>-->
                                                                        <th>Số lượng</th>
                                                                        <th>Tháng</th>
                                                                        <th>Doanh thu</th>
                                                                </tr>
                                                                </thead>
                                                               <c:forEach items="${revenueStatsPeriodd}" var="b">
                                                                    <tr>
                                                                        <td>${b[5]}</td>
                                                                        <td>${b[0]}/${b[1]} </td>
                                                                         <td>${b[13]} VND </td>
                                                                    </tr>
                                                                </c:forEach> 
                                                            </table>
                                                        </div>
                                                    </div>
                                       
                                      
                                    </div>
                                </div>  

                              </div>
                            </div>
                          </div>
                </div>
        
<!--         <script>

            let cvLabels=[], cvInfo=[];
            <!c:forEach items="$!{productStatsPeriod}" var="b">
                cvLabels.push('$!{b[9]} - $!{b[10]}')
                cvInfo.push($!{b[5]});
            </!c:forEach>
            window.onload = function(){
                cateChart("doughnutchart", cvLabels,cvInfo)
            }
            
            
        </script>  -->
        
</div>
