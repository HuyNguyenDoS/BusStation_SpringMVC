<%-- 
    Document   : admin_header
    Created on : Aug 16, 2022, 11:44:33 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <!--                    <img src="resources/img/logo.png" alt="">-->
            <span class="d-none d-lg-block">TransportAdmin</span>
        </a>
    </div><!-- End Logo -->


    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle " href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li><!-- End Search Icon-->

            </li><!-- End Messages Nav -->

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
      
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li class="">
                            <c:if test="${currentUser.avatar != null}">
                                <img style="width: 30px" src="${currentUser.avatar  }" class="img-fluid"/>
                            </c:if>
                            <c:if test="${currentUser.avatar == null}">
                                <i class="fa fa-user"></i>
                            </c:if>
                            <span class="d-none d-md-block ps-2" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</span>
                        </li>
                        <li class="">
                            <a class="nav-link" href="<c:url value="/logout" />">ĐĂNG XUẤT</a>
                        </li>
                    </c:if>  
                   
                </a><!-- End Profile Iamge Icon -->

            </li><!-- End Profile Nav -->

        </ul>
    </nav><!-- End Icons Navigation -->

</header><!-- End Header -->
