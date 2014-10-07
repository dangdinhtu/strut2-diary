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
             if("add".equals(action)) {  
        %>
        <h1 class="page-header">Thêm Cặp đôi</h1>
        <%
             } else{
        %>
        <h1 class="page-header">Chỉnh sửa cặp đôi</h1>
        <% } %>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminRDCController" method="get">
               <s:hidden name="action" value="addOrUpdate" />
               <s:hidden name="roleBO.roleId" />
                <div class="form-group">
                    <label for="name" class="col-sm-3 col-xs-12 control-label">Tên chức vụ</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="roleBO.name" cssClass="form-control" id="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripts" class="col-sm-3 col-xs-12 control-label">Mô tả chức vụ</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textarea name="roleBO.descript"  cssClass="form-control" rows="5" id="descript"/>
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






