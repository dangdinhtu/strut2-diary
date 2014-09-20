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
        <h1 class="page-header">Thêm người dùng</h1>
        <%        } else {
        %>
        <h1 class="page-header">Chỉnh sửa thông tin người dùng</h1>
        <% }%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-horizontal" action="AdminUserController?action=addOrUpdate" method="post">
                        <s:hidden name="user.userId" cssClass="form-control"/>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Tên</label>
                            <div class="col-sm-8">
                                <input type="text" name="user.name" class="form-control" id="name" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username"  class="col-sm-2 control-label">Tên đăng nhập</label>
                            <div class="col-sm-8">
                                <input type="text" name="user.username" class="form-control" id="username" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">Ngày sinh</label>
                            <div class="col-sm-8">
                                <input type="text" name="user.birthday" class="form-control" id="birthday" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">Địa chỉ </label>
                            <div class="col-sm-8">
                                <input type="text" name="user.address" class="form-control" id="address" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">Điện thoại</label>
                            <div class="col-sm-8">
                                <input type="text" name="user.phone" class="form-control" id="phone" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="gender" class="col-sm-2 control-label">Giới tính</label>
                            <div class="col-sm-8">
                                <div class="checkbox">
                                    <label><input type="radio" name="user.gender" value="1"> Nam </label>
                                    <label><input type="radio" name="user.gender" value="0"> Nữ </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="active" class="col-sm-2 control-label">Trạng thái</label>
                            <div class="col-sm-8">
                                <div class="checkbox">
                                    <label><input type="radio" name="user.active" value="1"> Hoạt động </label>
                                    <label><input type="radio" name="user.active" value="0"> Ngừng hoạt động </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Thêm mới</button>
                            </div>
                        </div>
                    </form>						

                </div>
                <!-- /.panel-body -->
                <div class="panel-footer table-footer">

                </div>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

<div><script>${result}</script></div>




