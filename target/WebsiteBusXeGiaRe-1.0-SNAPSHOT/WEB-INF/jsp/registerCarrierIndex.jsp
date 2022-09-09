<%-- 
    Document   : register
    Created on : Jul 27, 2022, 10:03:00 PM
    Author     : HUY NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/registerCarrierIndex" var ="action" />

<h1 class="text-center text-danger title-login">ĐĂNG KÝ TRỞ THÀNH NHÀ XE</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<form:form method="post" action="${action}" modelAttribute="user" class="form-login container">
    <div class="form-group">
        <label for="firstname">First Name</label>
        <form:input type="text" id="firstname" path="firstName" class="form-control" />
    </div>
    <div class="form-group">
        <label for="lastname">Last Name</label>
        <form:input type="text" id="lastname" path="lastName" class="form-control" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
    </div>

    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input type="number" id="phone" path="phone" class="form-control" />
    </div>

    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Confirm Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
    </div>
    <br>
    <div class="form-group btn-login">
        <input class="btn btn-danger" type="submit" value="Dang ky"/>
    </div>
</form:form>
  