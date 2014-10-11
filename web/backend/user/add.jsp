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
        <h1 class="page-header">Chỉnh sửa thông tin tài khoản</h1>
        <% }%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminUserController" method="post">
                <s:hidden name="action" value="addOrUpdate" />
                <s:hidden name="userBO.userId" />
                <s:hidden name="userBO.password"/>
                <div class="form-group">
                    <label for="username" class="col-sm-3 col-xs-12 control-label">Tên tài khoản</label>
                    <div class="col-sm-7 col-xs-12">
                        <input type="text" name="userBO.username" value="${userBO.username}" class="form-control" id="username" required/>
                    </div>
                </div>
                    <div class="form-group">
                    <label for="username" class="col-sm-3 col-xs-12 control-label">Tên người dùng</label>
                    <div class="col-sm-7 col-xs-12">
                        <input type="text" name="userBO.name" value="${userBO.name}" class="form-control" id="username" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 col-xs-12 control-label">Email</label>
                    <div class="col-sm-7 col-xs-12">
                        <input type="email" name="userBO.email" value="${userBO.email}" class="form-control" id="email" required/>
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
                        <input type="text" name="userBO.address" value="${userBO.address}" class="form-control" id="address" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-3 col-xs-12 control-label">Điện thoại</label>
                    <div class="col-sm-7 col-xs-12">
                        <input type="text" name="userBO.phone" value="${userBO.phone}" class="form-control" id="phone" required/>
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
                            <input type="radio" <c:out value="${userBO.active eq true ? 'checked' : ''}"/> name="userBO.active" id="inlineRadio1" value="true"> Hoạt động
                        </label>
                        <label class="radio-inline">
                            <input type="radio" <c:out value="${userBO.active eq false ? 'checked' : ''}"/> name="userBO.active" id="inlineRadio2" value="false"> Ngừng hoạt động
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-3 control-label">Chức vụ</label>
                    <div class="col-sm-7">
                        <div class="checkbox">
                            <c:forEach var="item" items="${listRole}">
                                <label>
                                    <input type="checkbox" name="userBO.arrRoleId" 
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
                        <button type="submit" class="btn btn-info">Lưu lại</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>






