

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url value="/carrier/buses" var="action" />
<div class="right_col" role="main" style="margin-top: 100px;margin-left: 500px" >
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>ĐĂNG KÝ CHUYẾN XE</h3>
            </div>


        </div>
        <div class="clearfix"></div>
        <div class="row">
            <div class="col-md-12 col-sm-12 " id="contain-form">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>FORM ĐĂNG KÝ <small>XE KHÁCH</small>
                            <small> | </small>
                            <small>XE LIMOUSINE</small></h2>

                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">

                        <form:form method="post" action="${action}" modelAttribute="bus" id="demo-form2"  class="form-horizontal form-label-left"
                                   enctype="multipart/form-data">
                            <form:errors path="*" cssClass="alert alert-danger" element="div" />

                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="bus-no">Biển số xe <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input type="text" id="first-name" required="required" class="form-control " path="numberPlate" />
                                </div>
                            </div>
                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="bus-name">Nhà xe <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input type="text" id="last-name" name="bus-name" required="required" class="form-control" path="busName"/>
                                    <form:errors path="busName" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="item form-group">
                                <label for="manufacturer" class="col-form-label col-md-3 col-sm-3 label-align">Hãng xe <span class="required">*</span> </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="middle-name" class="form-control" type="text" name="manufacturer" path="manufacturer" />
                                    <form:errors path="manufacturer" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="item form-group">
                                <label for="cate" class="col-form-label col-md-3 col-sm-3 label-align">Loại xe <span class="required">*</span> </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:select  id="heard" class="form-control"  path="categoryBus">
                                        <option value="">Chọn loại xe...</option>
                                        <option value="2">Giường nằm</option>
                                        <option value="1">Ghế ngồi</option>
                                        <option value="3">Giường nằm đôi</option>
                                        <option value="5">Phòng đơn VIP Limousine</option>
                                        <option value="6">Phòng đôi VIP Limousine</option>
                                        <option value="4">Ghế VIP Limousine</option> 

                                    </form:select>  
                                    <form:errors path="categoryBus" cssClass="text-danger" />
                                </div>
                            </div>

                            <div class="item form-group">
                                <label for="no-seats" class="col-form-label col-md-3 col-sm-3 label-align">Số chỗ <span class="required">*</span> </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="middle-name" required="required" class="form-control" type="text" name="no-seats" path="seatNumber" />
                                </div>
                            </div>

                            <div class="item form-group">
                                <label for="employee" class="col-form-label col-md-3 col-sm-3 label-align">Tài xế <span class="required">*</span> </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:select  id="employee" class="form-control"  path="employee.idEmployee">

                                        <c:forEach items="${employees}" var="e">
                                            <c:if test="${e.position == 'Tài xế'}">
                                                <option value="${e.idEmployee}">${e.name}</option>
                                            </c:if>
                                        </c:forEach>


                                    </form:select>                                                                        
                                </div>
                            </div>     

                            <div class="item form-group">
                                <label for="title" class="col-form-label col-md-3 col-sm-3 label-align">Tiêu đề </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="middle-name" class="form-control" type="text" name="title" path="title"/>
                                </div>
                            </div>
                            <div class="item form-group">
                                <label for="description" class="col-form-label col-md-3 col-sm-3 label-align">Mô tả </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:textarea id="message" required="required" class="form-control" name="description" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-minlength-message="Bạn cần nhập ít nhất 20 ký tự..." data-parsley-validation-threshold="10" path="description"  />
                                    <form:errors path="description" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="item form-group">
                                <label for="file" class="col-form-label col-md-3 col-sm-3 label-align">Hình ảnh </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <form:input id="file" Class="form-control" type="file" path="file"/>
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

