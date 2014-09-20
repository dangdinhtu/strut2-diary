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
        <h1 class="page-header">Thêm chức vụ</h1>
        <%        } else {
        %>
        <h1 class="page-header">Chỉnh sửa chức vụ</h1>
        <% }%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminRoleController?action=addOrUpdate" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-3 col-xs-12 control-label">Tên chức vụ</label>
                    <div class="col-sm-7 col-xs-12">
                        <input type="text" class="form-control" id="name" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripts" class="col-sm-3 col-xs-12 control-label">Mô tả chức vụ</label>
                    <div class="col-sm-7 col-xs-12">
                        <textarea class="form-control" rows="5" id="descripts"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="status" class="col-sm-2 control-label">Trạng thái</label>
                    <div class="col-sm-8">
                        <label class="radio-inline">
                            <input type="radio" name="status" id="inlineRadio1" value="1"> Hoạt động
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="status" id="inlineRadio2" value="0"> Ngừng hoạt động
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="permission" class="col-sm-2 control-label">Quyền hạn</label>
                    <div class="col-sm-8">
                        <c:forEach var="itemFunction" items="${listFunction}">
                            <span>${itemFunction.name} : </span><br>
                            <div style="margin-left: 20px">
                                <c:forEach var="item" items="${listPermission}">
                                    <span style="margin-left: 10px"><input type="checkbox" value="${item.name}"> ${item.name} </span>
                                </c:forEach>
                            </div>
                        </c:forEach>
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






