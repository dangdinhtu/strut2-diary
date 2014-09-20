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
        <h1 class="page-header">Thêm người dùng</h1>
        <%
             } else{
        %>
        <h1 class="page-header">Chỉnh sửa thông tin người dùng</h1>
        <% } %>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
             <form action="AdminUserController" method="post">
            <!-- /.panel-heading -->
            <div class="panel-body">
              

                <div class="table-responsive">
                   <div class="form-add">
                           <s:hidden name="action" value="addOrUpdate" cssClass="form-control"/>
                            <s:hidden name="user.userId" cssClass="form-control"/>
                            <s:textfield name="user.name" cssClass="form-control" label="Tên" />
                            <s:textfield name="user.username" label="Tên đăng nhập" cssClass="form-control"/>
                            <s:textfield name="user.password" label="Mật khẩu" cssClass="form-control"/>
                            <s:textfield name="user.birthday" label="Ngày sinh" displayFormat="MM/dd/yyyy" cssClass="form-control"/>
                            <s:textfield name="user.address" label="Địa chỉ" cssClass="form-control"/>
                            <s:textfield name="user.phone" label="Điện thoại" cssClass="form-control"/>
                            <s:textfield name="user.email" label="Email" cssClass="form-control"/>
                           <s:select label="Giới tính"  headerKey="-1" headerValue="chọn ...." list="#@java.util.LinkedHashMap@{'1':'Nam', '0':'Nữ'}" name="user.gender" cssClass="form-control" required="true"/> 
                            <s:select label="Trạng thái" 
                                      headerKey="-1" headerValue="chọn ...."
                                      list="#@java.util.LinkedHashMap@{'1':'Hoạt động', '0':'Ngưng hoạt động'}"  name="user.active" cssClass="form-control"/>->

                         
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
    

                    



