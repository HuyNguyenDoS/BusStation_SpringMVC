<%-- 
    Document   : register
    Created on : Jul 27, 2022, 10:03:00 PM
    Author     : HUY NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:url value="/register" var ="action" />

<h1 class="text-center text-danger title-login">ĐĂNG KÝ KHÁCH HÀNG</h1>



<form:form method="post" action="${action}" modelAttribute="user" class="form-login container" enctype="multipart/form-data" >
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <div class="form-group">
        <label for="firstname">First Name</label>
        <form:input type="text" id="firstname" path="firstName" class="form-control" />
        <form:errors path="firstName" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="lastname">Last Name</label>
        <form:input type="text" id="lastname" path="lastName" class="form-control" />
        <form:errors path="lastName" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
        <form:errors path="email" cssClass="text-danger" />
    </div>

    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input type="number" id="phone" path="phone" class="form-control" />
        <form:errors path="phone" cssClass="text-danger" />
    </div>

    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
        <form:errors path="username" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />
        <form:errors path="password" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="password">Confirm Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
        <form:errors path="confirmPassword" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="avatar">Avatar</label>
        <form:input type="file" path="file" class="form-control" />
    </div>
    <div class="form-group btn-login">
        <label>Chọn loại tài khoảng</label>
        <form:select class="form-control" path = "userRole">
            <option value="customer">Khách hàng</option>
            <option value="carrier">Nhà xe</option>
        </form:select>
    </div>
    <br>
    <div class="form-group btn-login">
        <input class="btn btn-danger" type="submit" value="Dang ky"/>
    </div>
</form:form>
