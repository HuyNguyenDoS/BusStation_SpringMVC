<%-- 
    Document   : index.jsp
    Created on : Jul 24, 2022, 2:15:52 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.css" />" >
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <section id="hero" class="hero d-flex align-items-center section-bg">
            <div class="container">
                <div class="row justify-content-between gy-5">
                    <div class="col-lg-5 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start">
                        <h2 data-aos="fade-up">Enjoy Your Healthy<br>Safe Trip</h2>
                        <p data-aos="fade-up" data-aos-delay="100">Have a great trip</p>
                    </div>
                    <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
                        <img src="resources/images/banner.png" class="img-fluid" alt="" data-aos="zoom-out" data-aos-delay="300">
                    </div>
                </div>
            </div>
        </section>
    </body>


    <div class="banner-container">
        <section class=""  id="home"  >
            <div class="background-city">

                <div class="title-text">
                    <p class="title-text-h1">ĐIỂM ĐẾN PHỔ BIẾN</p> 
                    <p class="small-title">Gợi ý những điểm du lịch được ưa thích trong năm</p> 
                </div>


                <main class="page-content">
                    <div class="card">
                        <div class="content">
                            <h2 class="title">Hội An</h2>
                            <!--            <p class="copy">Check out all of these gorgeous mountain trips with beautiful views of, you guessed it, the mountains</p>-->
                            <a href="<c:url value="/home_schedule"/>">    
                                <button class="btn">Xem chuyến</button>
                            </a>
                        </div>
                    </div>
                    <div class="card">
                        <div class="content">
                            <h2 class="title">Ninh Bình</h2>
                            <!--            <p class="copy">Plan your next beach trip with these fabulous destinations</p>-->
                            <a href="<c:url value="/home_schedule"/>">    
                                <button class="btn">Xem chuyến</button>
                            </a>
                        </div>
                    </div>
                    <div class="card">
                        <div class="content">
                            <h2 class="title">Đà Nẵng</h2>
                            <!--            <p class="copy">It's the desert you've always dreamed of</p>-->
                            <a href="<c:url value="/home_schedule"/>">    
                                <button class="btn">Xem chuyến</button>
                            </a>
                        </div>
                    </div>
                    <div class="card">
                        <div class="content">
                            <h2 class="title">TP.HCM</h2>
                            <!--            <p class="copy">Seriously, straight up, just blast off into outer space today</p>-->
                            <a href="<c:url value="/home_schedule"/>">

                                <button class="btn">Xem chuyến</button>
                            </a>
                        </div>
                    </div>
                </main>



                <img class="background-img" src="<c:url value="/resources/images/backgroundcity.png"/>" >





            </div>

        </section>
    </div>     
    <section class="hot-routes" id="hot-routes">
          
      <h1 class="heading-route">
        <span>T</span>
        <span>U</span>
        <span>Y</span>
        <span>Ế</span>
        <span>N</span>
        <span>X</span>
        <span>E</span>

    </h1>
    
    <div class="main-routes">
  <ul class="cards">
    <c:forEach var="h" items="${hotRoutes}">
        <li class="cards_item">
          <div class="card-route">
              <div class="card_image">
                <c:if test="${h[4] != null && h[4].startsWith('https') == true}">
                    <img class="img-fluid" id="img-hot-routes" src="${h[4]}" alt="${h[2]}"/>
                </c:if>              
              </div>
            <div class="card_content">
              <h2 class="card_title">${h[1]} ĐẾN ${h[2]}</h2>
              <div class="card_text">
                  <div class="details-container" data-v-8fbac40c="">
                      
                      
                      <div class="distance-journeyTime">
                              <div class="details" style="justify-content: center" data-v-8fbac40c="">
                                  <em class="fa fa-clock-o icon" data-v-8fbac40c=""></em> 
                                  <span>${h[7]}</span>
                              </div>
                              <div class="details" data-v-8fbac40c="">
                                  <em class="fa fa-map-marker icon" data-v-8fbac40c=""></em>
                                  <span>${h[8]} km</span>
                              </div>
                    </div>
                      <div class="details" data-v-8fbac40c="">
                          <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" viewBox="0 0 38 39" fill="white" fill-rule="evenodd" class="icon" data-v-8fbac40c="">
                          <path fill-rule="nonzero" d="M23.833 11.25v-4.5c0-1.249-.975-2.25-2.166-2.25H4.333c-1.191 0-2.155 1.001-2.155 2.25v4.5c1.191 0 2.155 1.012 2.155 2.25s-.964 2.25-2.166 2.25v4.5c0 1.238.975 2.25 2.166 2.25h17.334c1.191 0 2.166-1.012 2.166-2.25v-4.5c-1.191 0-2.166-1.012-2.166-2.25s.975-2.25 2.166-2.25zm-9.75 8.438h-2.166v-2.25h2.166v2.25zm0-5.063h-2.166v-2.25h2.166v2.25zm0-5.063h-2.166v-2.25h2.166v2.25z" transform="rotate(-45 23.243 9.257)">
                              
                          </path>
                          </svg> 
                          <span class="price item-price" data-v-8fbac40c="">${h[6]}</span>
                      </div> 
                  </div>
              </div>
            </div>
          </div>
        </li>
    </c:forEach>
    
  </ul>
</div>

    
</section>            
    <div>
        <footer class="site-footer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <h6>About</h6>
                        <p class="text-justify">WEBSITE BUS STATION</p>
                        <p> Địa chỉ: 240D Hà Huy Giáp, Phường Thạnh Lộc, Quận 12, Thành phố Hồ Chí Minh. </p>
                    </div>
                    <div class="col-xs-6 col-md-3">
                    </div>

                    <hr>

                </div>

                <div class="row">
                    <div class="col-md-8 col-sm-6 col-xs-12">
                        <p class="copyright-text">Copyright &copy; 2021 All Rights Reserved by 
                            <a href="#">BUS STATION</a>.
                        </p>
                    </div>

                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <ul class="social-icons">
                            <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>   
                        </ul>
                    </div>
                </div>
            </div>

    </div>
</html>

