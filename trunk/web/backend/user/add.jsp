<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<%
    HttpServletRequest req = ServletActionContext.getRequest();
    HttpServletResponse res = ServletActionContext.getResponse();
    String action = req.getParameter("action");
%>
<div class="row">
    <div class="col-lg-12">
        <%
            if ("add".equals(action)) {
        %>
        <h1 class="page-header">Thêm tài khoản</h1>
        <%        } else {
        %>
        <h1 class="page-header">Chỉnh sửa tài khoản</h1>
        <% }%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminUserController" method="get">
                <s:hidden name="action" value="addOrUpdate" />
                <s:hidden name="userBO.userId" />
                <div class="form-group">
                    <label for="username" class="col-sm-3 col-xs-12 control-label">Tên tài khoản</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="userBO.username" cssClass="form-control" id="username" />
                    </div>
                </div>
                <div class="form-group" style='display: none'>
                    <label for="pass" class="col-sm-3 col-xs-12 control-label">Mật khẩu</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="userBO.password" cssClass="form-control"  id="pass" />
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
                    <label for="status" class="col-sm-2 control-label">Trạng thái</label>
                    <div class="col-sm-8">
                        <label class="radio-inline">
                            <input type="radio" <c:out value="${userBO.active eq true ? 'checked' : ''}"/> name="userBO.active" id="inlineRadio1" value="true"> Hoạt động
                        </label>
                        <label class="radio-inline">
                            <input type="radio" <c:out value="${userBO.active eq false ? 'checked' : ''}"/> name="userBO.active" id="inlineRadio2" value="false"> Ngừng hoạt động
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">Chức vụ</label>
                    <div class="col-sm-8">
                        <div class="checkbox">
                            <c:forEach var="item" items="${listRole}">
                                <label>
                                    <input type="checkbox" name="userBO.arrRole" 
                                           value="${item.roleId}"
                                           <c:forEach var="itemUserRole" items="${listUserRole}">
                                               <c:if test="${itemUserRole.roleId eq item.roleId}">checked</c:if>
                                           </c:forEach>
                                           > ${item.name}
                                </label><br>
                            </c:forEach>
                        </div>
                    </div>
                </div>        
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-info" value="Lưu lại">
                    </div>
                </div>
            </form>						

            <!-- /.panel-body -->
            <div class="panel-footer table-footer">

            </div>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

<div><script>${result}</script></div>




