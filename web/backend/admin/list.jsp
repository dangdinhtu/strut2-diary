<%@page import="org.dom4j.CDATA"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="commonTags"%>
<div class="row">
    <div class="col-lg-12">
        <h2 class="page-header">Tài khoản cá nhân</h2>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div>
                    <div class="col-xs-12 col-md-2">
                        <img src="${contextPath}/images/${avata}" width="161px" height="200px">
                    </div>
                    <div class="col-xs-12 col-md-10">
                        <form class="form-horizontal" style="margin-top: 20px" action="AdminStartController" method="post">
                            <s:hidden name="action" value="addOrUpdate" />
                            <s:hidden name="userBO.userId"/>
                            <div class="form-group">
                                <label for="username" class="col-sm-3 col-xs-12 control-label">Tên tài khoản</label>
                                <div class="col-sm-7 col-xs-12">
                                    <s:textfield name="userBO.username" cssClass="form-control" id="username" />
                                </div>
                            </div>
                            <div class="form-group" >
                                <label for="pass" class="col-sm-3 col-xs-12 control-label">Mật khẩu</label>
                                <div class="col-sm-7 col-xs-12">
                                    <input type="password" class="form-control" name="userBO.password"  id="pass" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-3 col-xs-12 control-label">Tên chủ tài khoản</label>
                                <div class="col-sm-7 col-xs-12">
                                    <s:textfield name="userBO.name" cssClass="form-control" id="name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-3 col-xs-12 control-label">Email</label>
                                <div class="col-sm-7 col-xs-12">
                                    <s:textfield name="userBO.email" cssClass="form-control" id="email" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="birthday" class="col-sm-3 col-xs-12 control-label">Ngày sinh</label>
                                <div class="col-sm-7 col-xs-12">
                                    <input type="date" name="userBO.birthday" value="${user.birthday}" class="form-control" id="birthday" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address" class="col-sm-3 col-xs-12 control-label">Địa chỉ</label>
                                <div class="col-sm-7 col-xs-12">
                                    <s:textfield name="userBO.address" cssClass="form-control" id="address" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="col-sm-3 col-xs-12 control-label">Điện thoại</label>
                                <div class="col-sm-7 col-xs-12">
                                    <s:textfield name="userBO.phone" cssClass="form-control" id="phone" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="col-sm-3 col-xs-12 control-label">Giới tính</label>
                                <div class="col-sm-7 col-xs-12">
                                    <label class="radio-inline">
                                        <input type="radio" <c:out value="${userBO.gender eq true ? 'checked' : ''}"/> name="userBO.gender" id="inlineRadio1" value="true"> Nam
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" <c:out value="${userBO.gender eq false ? 'checked' : ''}"/> name="userBO.gender" id="inlineRadio2" value="false"> Nữ
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status" class="col-sm-3 control-label">Trạng thái</label>
                                <div class="col-sm-7">
                                    <label class="radio-inline">
                                        <input type="radio" checked name="userBO.active" id="inlineRadio1" value="true"> Hoạt động
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="gender" class="col-sm-3 control-label">Chức vụ</label>
                                <div class="col-sm-7">
                                    <div class="checkbox">
                                        <c:forEach var="item" items="${listUserRole}">
                                            <label>
                                                <input type="checkbox" checked> ${item.role}
                                            </label><br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>        
                        </form>
                    </div>
                </div>

            </div>
            <!-- /.panel-body -->
            <div class="panel-footer table-footer">


            </div>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
