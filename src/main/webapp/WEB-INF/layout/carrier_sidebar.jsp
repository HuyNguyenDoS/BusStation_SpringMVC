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
            <a class="nav-link " href="<c:url value="/carrier" />">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li><!-- End Dashboard Nav -->
        <li class="nav-heading">Pages</li>
        
        <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/carrier/buses"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Đăng kí chuyến xe</span>
            </a>
        </li><!-- End Profile Page Nav -->      
         <li class="nav-item">
            <a class="nav-link collapsed" href="<c:url value ="/carrier/data_buses"></c:url>">
                <i class="fa fa-edit"></i>
                <span>Cập nhật chuyến xe</span>
            </a>
        </li><!-- End Profile Page Nav -->
    </ul>

</aside><!-- End Sidebar-->

              