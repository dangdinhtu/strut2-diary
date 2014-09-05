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
        <div class="panel panel-default">
             <form action="AdminCategoryController" method="post">
            <!-- /.panel-heading -->
            <div class="panel-body">
              

                <div class="table-responsive">
                   <div class="form-add">
                           <s:hidden name="action" value="addOrUpdate" cssClass="form-control"/>
                            <s:hidden name="category.categoryId" cssClass="form-control"/>
                            <s:textfield name="category.name" cssClass="form-control" label="Tên thể loại" />
                            <s:text name="category.descript" label="Mô tả " cssClass="form-control"/>
                            <s:select label="Trạng thái" 
                                      headerKey="-1" headerValue="chọn ...."
                                      list="#@java.util.LinkedHashMap@{'1':'Hoạt động', '0':'Ngưng hoạt động'}"  name="category.active" cssClass="form-control"/>->

                           
                   </div>
                </div>						
                <div><script>${result}</script></div>
            </div>
            <!-- /.panel-body -->
            <div class="panel-footer table-footer">
                     <s:submit value="Lưu lại " cssClass="js-add btn btn-primary" />
                    <s:reset value="Làm lại" id="resetFormId" cssClass="js-reset btn btn-warning" />

            </div>
                     </form>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
    

                    



