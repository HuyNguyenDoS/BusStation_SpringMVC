<%-- 
    Document   : base
    Created on : Jul 25, 2022, 1:10:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<spring:url value="/resources/css/footer.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/css/trip.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/css/trip-detail.css" />" >
        <link rel="stylesheet" href="<spring:url value="/resources/css/cart.css" />" >
         <link rel="stylesheet" href="<spring:url value="/resources/css/style.css" />" >

        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery.min.js"></script>
        <script src="<spring:url value="/resources/js/main.js" />"></script>
        <script src="<spring:url value="/resources/js/cart.js" />"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>

    </head>
    <body>
        <tiles:insertAttribute name="header" />

        <tiles:insertAttribute name="content" />

        <tiles:insertAttribute name="footer" />


    </body>

</html>
