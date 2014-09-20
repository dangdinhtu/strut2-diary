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
        <h1 class="page-header">Thêm chức vụ</h1>
        <%
             } else{
        %>
        <h1 class="page-header">Chỉnh sửa chức vụ</h1>
        <% } %>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
             <form class="form-horizontal" action="AdminRoleController?action=addOrUpdate" method="post">
                    <div class="form-group">
                      <label for="name" class="col-sm-2 control-label">Name</label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" >
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="descripts" class="col-sm-2 control-label">Mô tả</label>
                      <div class="col-sm-8">
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
                       
                      </div>
                    </div>
                 <div class="form-group">
                        <label for="permission" class="col-sm-1 control-label"></label>
                        <div class="col-sm-10">
                            <c:forEach var="item" items="${listPermission}">
                                <label><c:out value="${item.name}"/></label>
                            </c:forEach>
                            
                         </div>
                      </div>
                    <div class="form-group">
                      <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Lưu lại</button>
                      </div>
                    </div>
                  </form>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
    

                    



