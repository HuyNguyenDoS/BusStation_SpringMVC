

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="right_col" role="main" style="margin-top: 80px;margin-left: 320px">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>CẬP NHẬT CHUYẾN ĐI</h3>
            </div>

            
        </div>
        <div class="clearfix"></div>
        <div class="row">
            <div class="col-md-12 col-sm-12 " id="contain-form">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>FORM THÊM ĐIỂM KHỞI HÀNH   -   ĐIỂM ĐẾN</h2>
                        
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        
                        <!-- Hien loi -->
                        <c:if test="${errMsg != null}">
                            
                            <div class="alert alert-danger">${errMsg}</div>
                            
                        </c:if>
                        <form:form method="post" action="${action}" modelAttribute="route" id="demo-form2"  class="form-horizontal form-label-left"
                                   enctype="multipart/form-data">
                            <!-- id="demo-form2" data-parsley-validate class="form-horizontal form-label-left"-->

                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="departure">Điểm khởi hành <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input type="text" id="departure" required="required" class="form-control " path="departure" />
                                </div>
                            </div>
                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="destination">Điểm đến <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input type="text" id="destination" name="destination" required="required" class="form-control" path="destination"/>
                                </div>
                            </div>
                            <div class="item form-group">
                                <label for="distance" class="col-form-label col-md-3 col-sm-3 label-align">Khoảng cách <span class="required">*</span> </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="distance" class="form-control" type="text" name="distance" path="distance" />
                                </div>
                            </div>
                            
                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="journeyTime">Thời gian di chuyển <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input type="text" id="journeyTime" name="journeyTime" required="required" class="form-control" path="journeyTime"/>
                                </div>
                            </div>    
                                
                                
                            

                            
                            <div class="item form-group">
                                <label for="ticketPrice" class="col-form-label col-md-3 col-sm-3 label-align">Giá vé </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="ticketPrice" class="form-control" type="text" name="ticketPrice" path="ticketPrice"/>
                                </div>
                            </div>
                             
                                
                             <div class="item form-group">
                                <label for="pickUpPoint" class="col-form-label col-md-3 col-sm-3 label-align">Điểm đón </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="pickUpPoint" class="form-control" type="text" name="pickUpPoint" path="pickUpPoint"/>
                                </div>
                            </div>
                                
                            <div class="item form-group">
                                <label for="dropOffPoint" class="col-form-label col-md-3 col-sm-3 label-align">Điểm trả </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="dropOffPoint" class="form-control" type="text" name="dropOffPoint" path="dropOffPoint"/>
                                </div>
                            </div>    
                                   
                                
                                
                            
                            <div class="item form-group">
                                <label for="imageDeparture" class="col-form-label col-md-3 col-sm-3 label-align">Hình ảnh điểm khởi hành </label>
                                <div class="col-md-6 col-sm-6 ">
                                <c:if test="${route.imageDeparture != null && route.imageDeparture.startsWith('https') == true}">
                                    <img class="img-fluid" id="size-image" src="${route.imageDeparture}" alt="${route.departure}"/>
                                    <form:input id="fileDeparture" Class="form-control" type="file" path="fileDeparture"/>

                                </c:if>
                                <c:if test="${route.imageDeparture == null || route.imageDeparture.startsWith('https') == false}">
                                          <form:input id="fileDeparture" Class="form-control" type="file" path="fileDeparture"/>

                                </c:if>            
                            </div>
                          </div>
                                
                                
                            <div class="item form-group">
                                <label for="imageDestination" class="col-form-label col-md-3 col-sm-3 label-align">Hình ảnh điểm đến </label>
                                <div class="col-md-6 col-sm-6 ">
                                <c:if test="${route.imageDestination != null && route.imageDestination.startsWith('https') == true}">
                                    <img class="img-fluid" id="size-image" src="${route.imageDestination}" alt="${route.destination}"/>
                                    <form:input id="fileDestination" Class="form-control" type="file" path="fileDestination"/>

                                </c:if>
                                <c:if test="${route.imageDestination == null || route.imageDestination.startsWith('https') == false}">
                                          <form:input id="fileDestination" Class="form-control" type="file" path="fileDestination"/>

                                </c:if>            
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

