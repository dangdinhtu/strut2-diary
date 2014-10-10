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
        <h1 class="page-header">Thêm thể loại</h1>
        <%
             } else{
        %>
        <h1 class="page-header">Chỉnh sửa thể loại</h1>
        <% } %>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminCategoryController" method="post">
                <s:hidden name="action" value="addOrUpdate" />
                <s:hidden name="category.categoryId"/>
                <div class="form-group">
                    <label for="name" class="col-sm-3 col-xs-12 control-label">Tên thể loại</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="category.name"  cssClass="form-control" id="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripts" class="col-sm-3 col-xs-12 control-label">Mô tả</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textarea name="category.descript"  cssClass="form-control" rows="5" id="descript"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="status" class="col-sm-3 control-label">Trạng thái</label>
                    <div class="col-sm-7">
                        <label class="radio-inline">
                            <input type="radio" <c:out value="${category.active eq true ? 'checked' : ''}"/> name="category.active" id="inlineRadio1" value="true"> Hoạt động
                        </label>
                        <label class="radio-inline">
                            <input type="radio" <c:out value="${category.active eq false ? 'checked' : ''}"/> name="category.active" id="inlineRadio2" value="false"> Ngừng hoạt động
                        </label>
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
 