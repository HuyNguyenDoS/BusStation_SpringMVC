
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


    <h1 class="text-center text-danger" style="margin-top: 10px">TRANG CHUYẾN ĐI</h1>
<div>

        <div class="table-responsive" >
           
            <div class="flex-center">
                 <div class="title_right">
                                <form action="">
                                
                                <div class="col-md-5 col-sm-5  form-group pull-right top_search">
                                        <div class="input-group">
                                                <input type="text" class="form-control" name="kw" placeholder="Tìm kiếm tuyến xe...">
                                                <span class="input-group-btn">
                                                    <button class="btn btn-default" value="Search" type="submit">Tìm!</button>
                                                </span>
                                        </div>
                                </div>
                                
                            </form>
                        </div>
                <div class="table-routine">
                    
                    <table class="table table-striped jambo_table bulk_action">
                        <thead id="header-table">
                        <tr class="headings">
                          <th class="column-title">Tuyến xe</th>
                          <th class="column-title">Quãng đường</th>
                          <th class="column-title">Thời gian hành trình</th>
                          <th class="column-title">Giá vé</th>                                        
                          <th class="column-title"></th>                                       
                          <th class="end"></th>                                      


                        </tr>
                      </thead>
                    </table>

           
                
                 <c:forEach var="r" items="${routes}" >                     
            <div class="groups">
                <table class="table table-striped jambo_table bulk_action">
                    <thead>
                        <tr class="title-departure">
                            <th colspan="10" class="text">${r.departure} =>
                            </th>
                        </tr>
                    </thead>   
                
                
            <tbody>
              <tr class="headings">

                <td class="column-title ">${r.destination}</td>
                <td class="column-title ">${r.distance} km</td>
                <td class="column-title ">${r.journeyTime} hour</td>
                <td class="column-title "><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${r.ticketPrice}"  /> VND</td>
                <td class="column-title ">
                    <a class="user-name-sign-in" href="<c:url value="/home_routine/list_schedules?id=${r.id}"/>">
                        <button data-v-62c8fe4c="" class="time-detail" style="background-color: white;
                           border-radius: 10px;"> Chi tiết
                        <i data-v-62c8fe4c="" class="fa fa-info-circle" style="font-size: 18px;
                           "></i>
                        </button>
                    </a>
                </td>
                <td class="end"></td>

                
              </tr>

            </tbody>
          </table>
        </div>
                    
      </c:forEach>  
</div>
                <c:if test="${route.size() == 0}">
    <p>
        <strong>Khong co nha xe nao!!!</strong>
    </p>
</c:if>
    
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(counter/pageSize)}" var="i">
        <c:url value="/home_routine" var="u">
            <c:param name="page" value="${i}" />
        </c:url>
        <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
    </c:forEach>
</ul>
</div>
