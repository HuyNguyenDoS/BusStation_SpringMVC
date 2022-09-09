

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<body>

    <h1 class="text-center text-danger" style="margin-top: 10px">TRANG CHI TIẾT CHUYẾN ĐI</h1>
    <h1></h1>
    <div class="container"id="contain-ticket-item">

        <c:forEach begin="0" end="0" var="s" items="${schedules}">  
            <div class="title-route">
                <h2>Tuyến xe từ ${s.route.departure} đi ${s.route.destination}</h2>
            </div>
        </c:forEach>

        <c:forEach var="s" items="${schedules}">


            <div class="row ticket-item">
                <div class="ticket-item-img col-3">
                    <c:choose>
                        <c:when test="${s.bus.image != null && s.bus.image.startsWith('http') == true}">
                            <img class="img-fluid" src="${s.bus.image}" alt=${s.bus.busName} />
                        </c:when>
                        <c:when test="${s.bus.image == null ||s.bus.image.startsWith('http') == false}">
                            <img class="img-fluid" src="<c:url value="/resources/images/bus.jpg"/>" ${s.bus.busName}/>
                        </c:when>
                    </c:choose>
                </div>

                <div class="ticket-item-info col-6">
                    <div class="ticket-header">
                        <h2>${s.bus.busName}</h2>
                        <div class="ticket-header-seat">
                            <p>${s.bus.categoryBus.name}</p>
                            <c:if test="${s.bus.seatNumber > 0}">
                                <p class="seat-pos"> Còn
                                    <span>${s.bus.seatNumber}</span> 
                                    ghế trống
                                </p>
                            </c:if>
                            <c:if test="${s.bus.seatNumber <= 0}">
                                <p class="seat-pos">
                                    <span>Hết chỗ</span> 

                                </p>
                            </c:if>
                        </div>
                    </div>
                    <div class="ticket-content">
                        <div class="ticket-content-station">
                            <div class="ticket-content-from">
                                <div>
                                    <p class="ticket-content-title">Nơi đón</p>
                                    <p class="ticket-content-info pickup" ">${s.route.pickUpPoint}</p>
                                </div>
                                <div>
                                    <p class="ticket-content-title">Ngày khởi hành</p>
                                    <p class="ticket-content-info pickup-time" >${s.departureDate}</p>
                                </div>
                            </div>
                            <div class="ticket-content-to">
                                <div>
                                    <p class="ticket-content-title">Nơi trả</p>
                                    <p class="ticket-content-info dropoff" >${s.route.dropOffPoint}</p>
                                </div>
                                <div><p class="ticket-content-title">Thời gian đi</p>
                                    <div>   
                                        <p class="ticket-content-info pickup-time">${s.departureTime}</p> 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ticket-content-suggest">
                            <div class="ticket-content-way">
                                <div>
                                    <p class="ticket-content-title">Khoảng cách</p>
                                    <p class="ticket-content-info">${s.route.distance} km</p>
                                </div>
                                <div>
                                    <p class="ticket-content-title">Tổng thời gian</p>
                                    <p class="ticket-content-info">${s.route.journeyTime} hour</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="ticket-item-price col-3">
                    <div >
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${s.route.ticketPrice}"  /> VND
                    </div>
                    <div class="vote"><i aria-hidden="true" class="fa fa-star active"></i>
                        <i aria-hidden="true" class="fa fa-star active"></i>
                        <i aria-hidden="true" class="fa fa-star active"></i>
                        <i aria-hidden="true" class="fa fa-star active"></i>
                        <i aria-hidden="true" class="fa fa-star active"></i>
                        <p><span>Xem chi tiết</span></p></div>
                    <a href="javascript:;"  onclick="addToCart(${s.id}, '${s.route.departure}', '${s.route.destination}',
                                    '${s.bus.busName}', '${s.bus.categoryBus.name}'
                                    ,${s.route.ticketPrice}, ${s.bus.seatNumber}, ${s.departureDate}, '${s.departureTime}')">
                        <button type="button" class="btn-book" style="background-color: blue;border-radius: 10px">Đặt vé</button>  
                    </a>



                </div>
            </div>
        </c:forEach>
    </div>
</body>

