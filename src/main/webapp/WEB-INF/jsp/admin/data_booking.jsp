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
            <h3>BẢNG DỮ LIỆU THÔNG TIN ĐẶT VÉ</h3>
        </div>


    </div>
    <div class="clearfix"></div>
    <div class="row">

        <div class="col-md-12 col-sm-12  " id="table-buses">
            <div class="x_panel">
                <div class="x_title">
                    <h2><small>Thông tin đặt vé</small></h2>

                    <div class="clearfix"></div>
                </div>

                <div class="x_content">


                    <div class="table-responsive">
                        <table class="table table-striped jambo_table bulk_action">
                            <thead>
                                <tr class="headings">
                                    <th class="column-title" id="col-num">Id </th>
                                    <th class="column-title">Khách hàng </th>
                                    <th class="column-title">Email </th>                                        
                                    <th class="column-title">Số điện thoại </th>
                                    <th class="column-title">Tên đăng nhập </th>
                                    <th class="column-title">Ngày đặt vé </th>   
                                    <th class="column-title">Tổng tiền </th>                                        


                                    <th class="column-title no-link last  a-right a-right"><span class="nobr ">Action</span>
                                    </th>
                                    <th class="bulk-actions" colspan="7">
                                        <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                    </th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="b" items="${booking}">
                                    <tr class="even pointer">
                                        <td class=" ">${b[0]}</td>
                                        <td class=" ">${b[3]} ${b[4]}</td>
                                        <td class=" ">${b[5]}</td>
                                        <td class=" ">${b[6]}</td>
                                        <td class=" ">${b[7]}</td>
                                        <td class=" ">${b[1]}</td>
                                        <td class=" "><fmt:formatNumber type = "number" maxFractionDigits = "3" 
                                                          value = "${b[2]}"  /></td>



                                        <td class="column-title ">
                                            <a class="user-name-sign-in" href="<c:url value="/admin/data_booking_detail/${b[0]}"/>">
                                                <button data-v-62c8fe4c="" class="time-detail" > Chi tiết
                                                    <i data-v-62c8fe4c="" class="fa fa-info-circle" style="font-size: 18px;"></i>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <div class="pagination-table">
                        <!--$!{counter}-->
                        <ul class="pagination">
                            <c:forEach begin="1" end="${Math.ceil(counter/pageSize)}" var="i">
                                <c:url value="/admin/data_booking" var="u">
                                    <c:param name="page" value="${i}" />
                                </c:url>
                                <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
                                </c:forEach>
                        </ul>


                    </div>       

                </div>
            </div>
        </div>
    </div>



</div>

