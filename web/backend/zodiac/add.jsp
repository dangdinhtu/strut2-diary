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
        <h1 class="page-header">Thêm Cung hoàng đạo</h1>
        <%        } else {
        %>
        <h1 class="page-header">Chỉnh sửa Cung hoàng đạo</h1>
        <% }%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminZodiacController" method="post">
               <s:hidden name="action" value="addOrUpdate" />
               <s:hidden name="zodiacBO.zodiacId" />
                <div class="form-group">
                    <label for="name" class="col-sm-3 col-xs-12 control-label">Tên cung hoàng đạo</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="zodiacBO.name" cssClass="form-control" id="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="date" class="col-sm-3 col-xs-12 control-label">Ngày</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textarea name="zodiacBO.date"  cssClass="form-control" rows="5" id="date"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="image" class="col-sm-3 control-label">Ảnh minh họa</label>
                    <div class="col-sm-7 col-xs-12">
                       <input name="zodiacBO.image" type="file" name="myFile" />
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






