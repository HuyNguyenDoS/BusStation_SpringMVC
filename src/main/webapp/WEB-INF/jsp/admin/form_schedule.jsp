
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/schedules" var="action" />
<div class="right_col" role="main" style="margin-top: 100px;margin-left: 500px">
    <div class="">
                <div class="page-title">
                        <div class="title_left">
                                <h3>ĐĂNG KÝ LỊCH CHẠY</h3>
                        </div>

                      
                </div>
                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 " id="contain-form">
                                <div class="x_panel">
                                        <div class="x_title">
                                                <h2>FORM ĐĂNG KÝ <small>LỊCH TRÌNH</small>
                                                    </h2>
                                               
                                                <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">
                                                <br />

                                                <!-- Hien loi -->
                                                <c:if test="${errMsg != null}">

                                                    <div class="alert alert-danger">${errMsg}</div>

                                                </c:if>

                                                <form:form method="post" action="${action}" modelAttribute="schedule" id="demo-form2"  class="form-horizontal form-label-left"
                                                                    enctype="multipart/form-data">
                                                        <div class="item form-group">
                                                            <label for="bus" class="col-form-label col-md-3 col-sm-3 label-align">Tuyến xe <span class="required">*</span> </label>
                                                            <div class="col-md-6 col-sm-6 ">
                                                                <form:select  id="bus" class="form-control"  path="route.id">

                                                                    <c:forEach items="${routes}" var="r">
                                                                        <form:option value="${r.id}">${r.departure} - ${r.destination}</form:option>
                                                                    </c:forEach>

                                                                </form:select>                                                                        
                                                            </div>
                                                        </div>
                                                        
                               <div class="item form-group">
                                <label for="bus" class="col-form-label col-md-3 col-sm-3 label-align">Chuyến xe <span class="required">*</span> </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:select  id="bus" class="form-control"  path="bus">
                                        
                                        <c:forEach items="${buses}" var="bus">
                                            <option value="${bus.idBus}">${bus.busName} - ${bus.categoryBus.name}</option>
                                        </c:forEach>
                                        

                                    </form:select>                                                                        
                                </div>
                            </div>

                                   
                                        <div class="item form-group">
                                                            <label class="col-form-label col-md-3 col-sm-3 label-align">Ngày khởi hành <span class="required">*</span>
                                                            </label>
                                                            
                                                            <div class="col-md-6 col-sm-6 ">
                                                                            
                                                                    <form:input type="date" cssClass="form-control" id="departureDate" path="departureDate"/>
                                                                                <script>
                                                                                        function timeFunctionLong(input) {
                                                                                                setTimeout(function() {
                                                                                                        input.type = 'text';
                                                                                                }, 60000);
                                                                                        }
                                                                                </script>
                                                                        </div>
                                                        
                                                        </div>
                                                        <div class="item form-group">
                                                            <label class="col-form-label col-md-3 col-sm-3 label-align">Ngày về <span class="required">*</span>
                                                            </label>
                                                            
                                                            <div class="col-md-6 col-sm-6 ">
                                                                            
                                                                    <form:input type="date" cssClass="form-control" id="destinationDate" path="destinationDate"/>
                                                                                <script>
                                                                                        function timeFunctionLong(input) {
                                                                                                setTimeout(function() {
                                                                                                        input.type = 'text';
                                                                                                }, 60000);
                                                                                        }
                                                                                </script>
                                                                        </div>
                                                        
                                                        </div>
                                                                                
                                                    <div class="item form-group">
                                                                <label for="departureTime" class="col-form-label col-md-3 col-sm-3 label-align">Giờ khởi hành <span class="required">*</span> </label>
                                                                <div class="col-md-6 col-sm-6 ">
                                                                    <form:select id="heard" class="form-control" path="departureTime" items="${departureTimeList}">
                                                                            
                                                                    </form:select>                                                                        
                                                                </div>
                                                        </div>                            
                                                        
                                                        
                                                        
                                                       

                                                        
                                              
                                                        

                                                            <div class="button-form">
                                                            <div class="col-md-6 col-sm-6 offset-md-3" id="button-form-submit">
                                                                <form:button class="btn btn-primary" type="reset">Nhập lại</form:button>
                                                                <form:button type="submit" class="btn btn-success">Xác nhận</form:button>
                                                                </div>
                                                            </div>

                                                </form:form>
                                        </div>

                                </div>
                        </div>
                    </div>
        </div>

</div>




