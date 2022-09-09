<%-- 
    Document   : admin
    Created on : Aug 10, 2022, 9:35:41 PM
    Author     : HUY NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="<spring:url value="/resources/js/style.js" />"></script>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Dashboard - Transport Admin </title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="resources/img/favicon.png" rel="icon">
        <link href="resources/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="resources/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="resources/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="resources/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="resources/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="resources/vendor/simple-datatables/style.css" rel="stylesheet">


        <!-- Template Main CSS File -->
        <link href="resources/css/style.css" rel="stylesheet">

        <!-- =======================================================
        * Template Name: NiceAdmin - v2.3.1
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>

    <body>
        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Dashboard</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="<c:url value="/" />">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section dashboard">
                <div class="row">

                    <!-- Left side columns -->
                    <div class="col-lg-8">
                        <div class="row">

                            <!-- Sales Card -->
                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card sales-card">

                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                            <li class="dropdown-header text-start">
                                                <h6>Filter</h6>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Today</a></li>
                                            <li><a class="dropdown-item" href="#">This Month</a></li>
                                            <li><a class="dropdown-item" href="#">This Year</a></li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">Bill Number <span>| Today</span></h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-cart"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>${countBooking}</h6>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Sales Card -->

                            <!-- Revenue Card -->
                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card revenue-card">

                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                            <li class="dropdown-header text-start">
                                                <h6>Filter</h6>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Today</a></li>
                                            <li><a class="dropdown-item" href="#">This Month</a></li>
                                            <li><a class="dropdown-item" href="#">This Year</a></li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">Revenue <span>| This Month</span></h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-currency-dollar"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>$3,264</h6>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Revenue Card -->

                            <!-- Customers Card -->
                            <div class="col-xxl-4 col-xl-12">

                                <div class="card info-card customers-card">

                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                            <li class="dropdown-header text-start">
                                                <h6>Filter</h6>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Today</a></li>
                                            <li><a class="dropdown-item" href="#">This Month</a></li>
                                            <li><a class="dropdown-item" href="#">This Year</a></li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">Curent User <span>| This Year</span></h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-people"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>${countUser} </h6>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div><!-- End Customers Card -->

                            

                            
                            <!--<!-- Carrier ======================== -->

                            <div class="col-12">
                                <div class="card top-selling overflow-auto">
                                    <div class="card-body pb-0">
                                        <h5 class="card-title"> List Carrier <span>| Today</span></h5>
                                        <table class="table table-borderless">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Image</th>
                                                    <th scope="col">Name</th>
                                                    <th scope="col">License Plate</th>
                                                    <th scope="col">Created Date</th>
                                                    <th scope="col">Status</th>
                                                    <th scope="col"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${bus}" var="p">
                                                    <tr>
                                                        <td>${p.idBus}</td>
                                                        <td class="text-primary fw-bold">${p.busName}</td>
                                                        <td class="fw-bold">${p.numberPlate}</td>
                                                        <td class="fw-bold">${p.createdDate}</td>
                                                        <c:if test="${p.active == true}">
                                                            <c:url value="/admin/update" var="cUrl">
                                                                <c:param name="idBus" value="${p.idBus}" />
                                                                <c:param name="active" value="${p.active}" />
                                                            </c:url>
                                                            <td class="fw-bold text-success">Đang hoạt động</td>
                                                            <td>
                                                                <a type="button" class="btn btn-success" href="${cUrl}">Tắt hoạt động</a>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${p.active == false}">
                                                            <c:url value="/admin/update" var="cUrl">
                                                                <c:param name="idBus" value="${p.idBus}" />
                                                                <c:param name="active" value="${p.active}" />
                                                            </c:url>
                                                            <td class="fw-bold text-danger">Đã dừng</td>
                                                            <td>
                                                                <a type="button" class="btn btn-success" href="${cUrl}">Bật hoạt động</a>
                                                            </td>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div><!-- End Carrier -->
                        </div>
                    </div><!-- End Left side columns -->

                    

                </div>
            </section>

        </main><!-- End #main -->

        

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="resources/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="resources/vendor/chart.js/chart.min.js"></script>
        <script src="resources/vendor/echarts/echarts.min.js"></script>
        <script src="resources/vendor/quill/quill.min.js"></script>
        <script src="resources/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="resources/vendor/tinymce/tinymce.min.js"></script>
        <script src="resources/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="resources/js/style.js"></script>

    </body>

</html>
