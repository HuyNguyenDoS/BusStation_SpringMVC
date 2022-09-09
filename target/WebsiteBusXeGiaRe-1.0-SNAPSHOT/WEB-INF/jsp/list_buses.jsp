<%-- 
    Document   : footer
    Created on : Jul 30, 2022, 1:38:05 PM
    Author     : Nguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="property" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html lang="es" dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
        <meta charset="utf-8">
        <link rel="stylesheet" href="<spring:url value="/resources/css/style.css" />" >
    </head>

    <body>
        <h1 class="text-center text-danger">TRANG NHÀ XE</h1>



        <c:if test="${counter > 0}">
            <div class="row">
                <c:forEach var="b" items="${buses}"> 
                    <div class="col-md-4 col-xs-12" style="padding: 10px">
                        <div class="card">
                            <c:choose>
                                <c:when test="${b[8] != null && b[8].startsWith('http') == true}">
                                    <img class="card-img-top img-fluid" src="${b[8]}" alt="Card image" />
                                </c:when>
                                <c:when test="${b[8] == null || b[8].startsWith('http') == false}">
                                    <img class="card-img-top img-fluid" src="<c:url value="/resources/images/bus.jpg"/>" alt="Card image"/>
                                </c:when>
                            </c:choose>
                            <div class="card-body">   
                                <h2 class="card-title">${b[1]}</h2>
                                <h4 class="card-title">Thương hiệu: ${b[3]}</h4>
                                <p class="card-text">Biển số xe: ${b[2]}</p>
                                <div class="label" data-v-7026b95e="">
                                    ${b[4]} <span class="dot" data-v-7026b95e=""></span>
                                    <span data-v-7026b95e="">${b[5]} chỗ</span> 
                                    <a href="<c:url value="/bus_detail/${b[0]}"/>" class="btn btn-primary" >Chi tiet</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </c:if>
        <nav class="pagi">
            <ul class="pagination">
                <c:forEach begin="1" end="${Math.ceil(counter/pageSize)}" var="i">
                    <c:url value="/list_buses" var="u">
                        <c:param name="page" value="${i}" />
                    </c:url>
                    <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
                    </c:forEach>
            </ul>

        </nav>
        <c:if test="${counter == 0}">
            <div class="container">
                <div class="empty-result">
                    <i class="fa fa-times fa-5x pt-3" aria-hidden="true"></i>
                    <p>
                        Không tìm thấy thông tin
                    </p>
                </div>
            </div>
        </c:if>
    </section><!-- End Our Services Section -->

    <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

</body>
</html>