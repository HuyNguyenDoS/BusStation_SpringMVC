<%-- 
    Document   : admin_base
    Created on : Aug 16, 2022, 11:43:32 PM
    Author     : Nguyen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Dashboard - Transport Admin </title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <title>
            <tiles:insertAttribute name="title"/>
        </title>


        <link rel="stylesheet" href="<spring:url value="/resources/css/style.css" />" >

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>


        <!-- Favicons -->
        <link rel="icon" href="<spring:url value="/resources/img/favicon.png" />" >
        <link rel="apple-touch-icon" href="<spring:url value="/resources/img/apple-touch-icon.png" />" >


        <!-- Google Fonts -->
        <link rel="stylesheet" href="<spring:url value="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" />" >
        <link rel="preconnect" href="<spring:url value="https://fonts.gstatic.com" />" >

        <!-- Vendor CSS Files -->
<!--        <link rel="stylesheet" href="<spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" >-->
        <link rel="stylesheet" href="<spring:url value="/resources/vendor/bootstrap-icons/bootstrap-icons.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/vendor/boxicons/css/boxicons.min.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/vendor/quill/quill.snow.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/vendor/quill/quill.bubble.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/vendor/remixicon/remixicon.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/vendor/simple-datatables/style.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/css/chart.css" />" >



    </head>

    <body>

        <!-- HEADER -->
        <tiles:insertAttribute name="admin_header"/>

        <!-- SIDEBAR -->
        <tiles:insertAttribute name="admin_sidebar"/>

        <!-- page content -->



        <tiles:insertAttribute name="admin_content"/>


        <!-- FOOTER -->
        <tiles:insertAttribute name="admin_footer"/>



        <script src="<spring:url value="/resources/vendor/apexcharts/apexcharts.min.js" />"></script>
        <script src="<spring:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
        <script src="<spring:url value="/resources/vendor/chart.js/chart.min.js" />"></script>
        <script src="<spring:url value="/resources/vendor/echarts/echarts.min.js" />"></script>
        <script src="<spring:url value="/resources/vendor/quill/quill.min.js" />"></script>
        <script src="<spring:url value="/resources/vendor/simple-datatables/simple-datatables.js" />"></script>
        <script src="<spring:url value="/resources/vendor/tinymce/tinymce.min.js" />"></script>
        <script src="<spring:url value="/resources/vendor/php-email-form/validate.js" />"></script>
 
        <script  type="text/javascript" src="<c:url value="/resources/js/state.js"/>" ></script>



    </body>
</html>
