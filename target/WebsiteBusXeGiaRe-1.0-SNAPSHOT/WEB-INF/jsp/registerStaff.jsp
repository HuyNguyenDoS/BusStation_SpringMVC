<%-- 
    Document   : pages-register
    Created on : Aug 10, 2022, 10:07:17 PM
    Author     : HUY NGUYEN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

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
        <!-- thiết lập hình nền cho form register -->
        <style>
            body {
                background-image: url('resources/img/logo.png');
            }
        </style>

        <main>
            <div class="container">

                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                                <div class="d-flex justify-content-center py-4">
                                    <a href="index.html" class="logo d-flex align-items-center w-auto">
                                        <img src="resources/img/logo.png" alt="">
                                        <span class="d-none d-lg-block">Transport Amin</span>
                                    </a>
                                </div><!-- End Logo -->

                                <div class="card mb-3">

                                    <div class="card-body">

                                        <div class="pt-4 pb-2">
                                            <h5 class="card-title text-center pb-0 fs-4">Create an Account Staff</h5>
                                            <p class="text-center small">Enter your personal details to create account</p>
                                        </div>
                                        <c:url value="/admin/registerStaff" var ="action" />
                                        <form:form method="post" action="${action}" modelAttribute="user" class="row g-3 needs-validation">
                                            <div class="col-12">
                                                <label for="firstname" class="form-label">First Name</label>
                                                <form:input type="text" id="firstname" path="firstName" class="form-control" />
                                                <div class="invalid-feedback">Please, enter first name!</div>
                                            </div>
                                            <div class="col-12">
                                                <label for="lastname">Last Name</label>
                                                <form:input type="text" id="lastname" path="lastName" class="form-control" />
                                                <div class="invalid-feedback">Please, enter last name!</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="email">Email</label>
                                                <form:input type="email" id="email" path="email" class="form-control" />
                                                <div class="invalid-feedback">Please, enter email!</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="phone">Phone</label>
                                                <form:input type="number" id="phone" path="phone" class="form-control" />
                                                <div class="invalid-feedback">Please, enter your phone!</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="username">Username</label>
                                                <form:input type="text" id="username" path="username" class="form-control" />
                                                <div class="invalid-feedback">Please, enter your name!</div>
                                            </div>
                                            <div class="col-12">
                                                <label for="password">Password</label>
                                                <form:input type="password" id="password" path="password" class="form-control" />
                                                <div class="invalid-feedback">Please, enter your password!</div>
                                            </div>
                                            <div class="col-12">
                                                <label for="password">Confirm Password</label>
                                                <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
                                                <div class="invalid-feedback">Please, enter your confirm password!</div>
                                            </div>

                                            <div class="col-12">
                                                <button class="btn btn-primary w-100" type="submit">Create Account</button>
                                            </div>
                                        </form:form>

                                    </div>
                                </div>

                                <div class="credits">
                                    <!-- All the links in the footer should remain intact. -->
                                    <!-- You can delete the links only if you purchased the pro version. -->
                                    <!-- Licensing information: https://bootstrapmade.com/license/ -->
                                    <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                                    Designed by <a href="https://bootstrapmade.com/">HuyNguyenDos</a>
                                </div>

                            </div>
                        </div>
                    </div>

                </section>

            </div>

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
        <script src="resources/js/main.js"></script>

    </body>

</html>