

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="right_col" role="main" style="margin-top: 80px;margin-left: 320px">

    <div class="page-title">
        <div class="title_left">
            <h3>BẢNG DỮ LIỆU TUYẾN XE</h3>
        </div>


    </div>
    <div class="col-md-12 col-sm-12  " id="table-buses">
            <div class="x_panel">
                <div class="x_title">
                    <h2><small> Cập nhật tuyến xe</small></h2>

                    <div class="clearfix"></div>
                </div>

                <div class="x_content">


                                <div class="table-responsive">
                                  <table class="table table-striped jambo_table bulk_action">
                                    <thead>
                                      <tr class="headings">

                                        <th class="column-title" id="col-num">Id </th>
                                        <th class="column-title">Điểm khởi hành </th>
                                        <th class="column-title">Điểm đến </th>
                                        <th class="column-title">Thời gian di chuyển</th>
                                        <th class="column-title">Khoảng cách (km) </th>
                                        <th class="column-title">Giá vé </th>    
                                        <th class="column-title">Điểm đón</th>
                                        <th class="column-title">Điểm trả</th>
                                        <th class="column-title" id="col-image">Hình ảnh điểm khởi hành </th>
                                        <th class="column-title" id="col-image">Hình ảnh điểm đến </th>                                        
                                        
                                        <th class="column-title no-link last  a-right a-right"><span class="nobr ">Action</span>
                                        </th>
                                        <th class="bulk-actions" colspan="7">
                                          <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                        </th>
                                      </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="r" items="${routes}">
                                      <tr class="even pointer">

                                        <td class=" ">${r.id}</td>
                                        <td class=" ">${r.departure}</td>
                                        <td class=" ">${r.destination}</td>
                                        <td class=" ">${r.journeyTime}</td>
                                        <td class=" ">${r.distance}km</td>
                                        <td class=" "><fmt:formatNumber type = "number" maxFractionDigits = "3" 
                                                          value = "${r.ticketPrice}"  /></td>
                                        <td class=" ">${r.pickUpPoint}</td>
                                        <td class=" ">${r.dropOffPoint}</td>
                                       
                                        <td>
                                            <c:if test="${r.imageDeparture != null && r.imageDeparture.startsWith('https') == true}">
                                                <img class="img-fluid" src="${r.imageDeparture}" alt="${r.departure}"/>
                                            </c:if>

                                        </td>
                                        <td>
                                            <c:if test="${r.imageDestination != null && r.imageDestination.startsWith('https') == true}">
                                                <img class="img-fluid" src="${r.imageDestination}" alt="${r.destination}"/>
                                            </c:if>

                                        </td>
                                        

                                        <td class=" last a-right a-right ">
                                            <div class="btn-edit">
                                                <a class="btn btn-default" href=" <c:url value="data_routes/update?id=${r.id}" />"><span class="glyphicon glyphicon-pencil"></span></a>
                                            </div>
                                        </td>
                                      </tr>
                                        </c:forEach>

                                    </tbody>
                                  </table>
                                </div>
                            
                            <div class="pagination-table">
                                      <!--$!{counter}-->
                                      <ul class="pagination">
                                          <c:forEach  begin="1" end="${Math.ceil(counter/6)}" var="i">
                                              
                                          <li class="page-item"><a class="page-link" href="<c:url value="/admin/data_routes"/>?page=${i}">${i}</a></li>
                                              
                                          </c:forEach>
                                       
                                        </ul>
                                          
                                  </div>

                              </div>
                            </div>
                          </div>
                </div>
        
        
        
</div>

