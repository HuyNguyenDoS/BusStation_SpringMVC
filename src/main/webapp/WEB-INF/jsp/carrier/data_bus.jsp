

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<div class="right_col" role="main" style="margin-top: 80px;margin-left: 320px">
    
    <div class="page-title">
                        <div class="title_left">
                                <h3>BẢNG DỮ LIỆU CHUYẾN XE</h3>
                        </div>
  
                </div>
        <div class="clearfix"></div>
                <div class="row">

                    <div class="col-md-12 col-sm-12  " id="table-buses">
                            <div class="x_panel">
                              <div class="x_title">
                                <h2>Cập nhật chuyến xe</h2>
                                
                                <div class="clearfix"></div>
                              </div>

                              <div class="x_content">


                                <div class="table-responsive">
                                  <table class="table table-striped jambo_table bulk_action">
                                    <thead>
                                      <tr class="headings">

                                        <th class="column-title" id="col-num">Id </th>
                                        <th class="column-title">Tên xe </th>
                                        <th class="column-title">Biển số xe </th>
                                        <th class="column-title">Thương hiệu </th>
                                        <th class="column-title">Loại xe </th>
                                        <th class="column-title" id="col-num">Số chỗ </th>
                                        <th class="column-title">Tài xế </th>                                        
                                        <th class="column-title">Tiêu đề </th>
                                        <th class="column-title" id="description">Mô tả </th>
                                        <th class="column-title" id="col-image">Hình ảnh </th>                                        
                                        <th class="column-title no-link last  a-right a-right"><span class="nobr ">Action</span>
                                        </th>
                                        <th class="bulk-actions" colspan="7">
                                          <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                        </th>
                                      </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="b" items="${buses}">
                                      <tr class="even pointer">

                                        <td class=" ">${b[0]}</td>
                                        <td class=" ">${b[1]}</td>
                                        <td class=" ">${b[2]}</td>
                                        <td class=" ">${b[3]}</td>
                                        <td class=" ">${b[4]}</td>
                                        <td class=" ">${b[5]}</td>
                                        <td class=" ">${b[10]}</td>
                                        <td class=" ">${b[6]}</td>
                                        <td class=" ">${b[7]}</td>

                                        <td>
                                                <img class="img-fluid" src="${b[8]}" alt="${b[1]}"/>
                                           

                                        </td>

                                        <td class=" last a-right a-right ">
                                            <div class="btn-edit">
                                                <a class="btn btn-default" href=" <c:url value="data_buses/update?idBus=${b[0]}" />"><span class="glyphicon glyphicon-pencil"></span></a>
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
                                              
                                          <li class="page-item"><a class="page-link" href="<c:url value="/carrier/data_buses"/>?page=${i}">${i}</a></li>
                                              
                                          </c:forEach>
                                       
                                        </ul>
                                          
                                  </div>    
                                  
                              </div>
                            </div>
                          </div>
                </div>
        
        
        
</div>