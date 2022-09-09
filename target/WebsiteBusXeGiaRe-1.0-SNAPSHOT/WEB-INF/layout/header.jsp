<%-- 
    Document   : footer
    Created on : Jul 30, 2022, 1:38:05 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/WebsiteBusXeGiaRe/">BẾN XE</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">&#128293; TRANG CHỦ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/home_routine" />">QUẢN LÝ TUYẾN ĐI</a>
                </li>   
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/list_buses" />">NHÀ XE</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="<c:url value="/cart" />">
                        <i class="fa fa-cart-plus"></i>
                        <div class="badge badge-danger" id="quantityTicket">${cartCounter}</div>
                    </a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login" />">ĐĂNG NHẬP</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register" />">ĐĂNG KÍ</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                        <a class="nav-link text-success" href="<c:url value="/" />">
                            <c:if test="${currentUser.avatar != null}">
                                <img style="width: 30px" src="${currentUser.avatar  }" class="img-fluid"/>
                            </c:if>
                            <c:if test="${currentUser.avatar == null}">
                                <i class="fa fa-user"></i>
                            </c:if>
                            ${pageContext.request.userPrincipal.name}
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout" />">ĐĂNG XUẤT</a>
                    </li>
                </c:if>   


            </ul>

        </div>
    </div>
</nav>

