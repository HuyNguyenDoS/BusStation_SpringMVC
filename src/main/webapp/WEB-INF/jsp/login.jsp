<%-- 
    Document   : login
    Created on : Aug 3, 2022, 9:10:25 PM
    Author     : HUY NGUYEN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1 class="text-center text-danger">LOGIN</h1>

<c:if  test="${param.error != null}">
    <div class="alert alert-danger">
        <p><spring:message code="user.login.error1" /></p>
    </div>
</c:if>
    
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        <p><spring:message code="user.login.error2" /></p>
    </div>
</c:if>

<c:url value="/login" var="action" />

<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="LOGIN" />
    </div>
</form>    

