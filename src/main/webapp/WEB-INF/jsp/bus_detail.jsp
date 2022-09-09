<%-- 
    Document   : footer
    Created on : Jul 30, 2022, 1:38:05 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="<c:url value = "/css/bus_detail.css" />"/>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap" rel="stylesheet"/>
    </head>

    <body>
        <div class="container" id="contain-bus-description">
            <div class="grid second-nav">
                <div class="column-xs-12">
                    <nav>
                        <ol class="breadcrumb-list">
                            <li class="breadcrumb-item"><a href="<c:url value="/list_buses"/>">Nhà xe</a></li>
                            <li class="breadcrumb-item active">Chi tiết nhà xe ${bus.busName}</li>
                        </ol>
                    </nav>
                </div>
            </div>
            <div class="grid product">
                <div class="column-xs-12 column-md-7">
                    <div class="product-gallery">
                        <div class="product-image">
                            <c:if test="${bus.image != null && bus.image.startsWith('https') == true}">
                                <img class="active" src="${bus.image}" alt="${bus.busName}" style="width: 600px; object-fit: cover"/>
                            </c:if>
                            <c:if test="${bus.image == null || bus.image.startsWith('https') == false}">
                                <img class="img-fluid " src="<c:url value="/resources/images/bus.jpg"/>" alt="${bus.busName}"/>
                            </c:if>              
                        </div>

                    </div>
                </div>

                <div class="column-xs-12 column-md-5">
                    <h1>Nhà xe ${bus.busName}</h1>
                    <h2><b>Biển số xe:</b>  ${bus.numberPlate}<br>
                        <b>Loại xe:</b>  ${bus.categoryBus.name}<br>
                        <b>Thương hiệu:</b>  ${bus.manufacturer}<br>
                        <b>Số chỗ:</b>  ${bus.seatNumber}<br>
                    </h2>
                    <div class="description">
                        <p>${bus.description}</p>
                    </div>
                </div>
            </div>


            <div class="comments-app">
                <!-- From -->
                <div class="comment-form">
                    <!-- Comment Avatar -->
                    <div class="comment-avatar">
                        <c:forEach var="c" items="${comments}">
                            <img style="height:100%;width:100%" x="0" y="0" src="${c.user.avatar}">
                        </c:forEach>
                    </div>

                    <form class="form" name="form">
                        <div class="form-row">
                            <textarea id="commentId"
                                      class="input"
                                      placeholder="Thêm bình luận..."
                                      ></textarea>
                        </div>



                        <div class="form-right">
                            <c:if test="${currentUser.id == null}">
                                <a class="btn-comment" href="<c:url value="/login" />">Bạn cần đăng nhập để bình luận</a>
                                </c:if>
                                <c:if test="${currentUser.id !=null}">
                                <input type="button" onclick="addComment(${bus.idBus})" value="Bình luận" class="btn-comment">
                                </c:if>
                      
                        </div>
                    </form>
                </div>

                <!-- Comments List -->
                <div class="comments" id="commentArea">

                    <div class="cmt-des">
                        <div>
                            <i class="fa fa-user-circle-o" aria-hidden="true">
                            </i>
                            &nbsp;&nbsp;${counter}&nbsp;Bình luận

                        </div>
                    </div>


                    <c:forEach var="c" items="${comments}" > 
                        <!-- Comment - Dummy -->
                        <div class="comment">
                            <!-- Comment Avatar -->
                            <div class="comment-avatar">
                                <img class="img-container" style="height:100%;width:100%" x="0" y="0" height="100%"  width="100%" src="${c.user.avatar}">
                            </div>

                            <!-- Comment Box -->
                            <div class="comment-box">
                                <div class="comment-text">${c.content}</div>
                                <div class="comment-footer">
                                    <div class="comment-info">
                                        <span class="comment-author">
                                            <a>${c.user.username}</a>
                                        </span>
                                        <span class="comment-date">${c.createDate}</span>
                                    </div>


                                </div>
                            </div>
                        </div>
                    </c:forEach>



                    <nav class="pagi">
                        <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(commentCounter/pageSize)}" var="i">
            <c:url value="/bus_detail/${bus.idBus}/" var="u">
                <c:param name="page" value="${i}" />
            </c:url>
            <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
            </c:forEach>
    </ul>

                    </nav>

                </div>
            </div>

        </div>


        <script>
            window.onload = function () {
                let dates = document.querySelectorAll(".comment-date");
                for (let i = 0; i < dates.length; i++) {
                    let d = dates[i];
                    d.innerText = "Comments " + moment(d.innerText).format("MMM Do YY");
                }
            }


        </script>
    </body>
</html>  
