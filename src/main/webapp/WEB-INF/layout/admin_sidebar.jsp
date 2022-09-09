<%-- 
    Document   : admin_sidebar
    Created on : Aug 16, 2022, 11:45:15 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="<c:url value="/admin" />">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li><!-- End Dashboard Nav -->


        <li class="nav-heading">Pages</li>
        
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/buses"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Đăng kí chuyến xe</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/routes"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Đăng kí tuyến xe</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/schedules"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Đăng kí lịch trình</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/data_booking"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Thông tin đặt vé</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/data_routes"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Cập nhật tuyến đi</span>
            </a>
        </li><!-- End Profile Page Nav -->
         <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/data_buses"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Cập nhật nhà xe</span>
            </a>
        </li><!-- End Profile Page Nav -->
        
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/category-statistic"></c:url>">
                <i class="fa fa-bar-chart-o"></i>
                <span>Mật độ chuyến xe theo tuyến xe</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/revenue-stats"></c:url>">
                <i class="fa fa-bar-chart-o"></i>
                <span>Doanh thu theo ngày</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/revenue-stats-month"></c:url>">
                <i class="fa fa-bar-chart-o"></i>
                <span>Doanh thu theo tháng</span>
            </a>
        </li><!-- End Profile Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/admin/revenue-stats-period"></c:url>">
                <i class="fa fa-bar-chart-o"></i>
                <span>Doanh thu theo quý</span>
            </a>
        </li><!-- End Register Page Nav -->
        
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value="/admin/registerStaff" />">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Register Staff</span>
            </a>
        </li><!-- End Login Page Nav -->
    </ul>

</aside><!-- End Sidebar-->

              