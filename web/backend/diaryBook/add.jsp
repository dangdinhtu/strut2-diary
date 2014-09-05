<%@page import="diary.bo.CategoryBO"%>
<%@page import="java.util.List"%>
<%@page import="diary.dao.CategoryDAO"%>
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
        <h1 class="page-header">Thêm nhật kí</h1>
        <%
             } else{
        %>
        <h1 class="page-header">Chỉnh sửa thông tin nhật kí</h1>
        <% } %>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
             <form action="AdminDiaryBookController" method="post">
            <!-- /.panel-heading -->
            <div class="panel-body">
              

                <div class="table-responsive">
                   <div class="form-add">
                           <s:hidden name="action" value="addOrUpdate" cssClass="form-control"/>
                            <s:hidden name="diaryBookBO.dbkId" cssClass="form-control"/>
                            <s:textfield name="diaryBookBO.name" cssClass="form-control" label="Tên" />
                            <s:textfield name="diaryBookBO.dateCreate" label="Ngày tạo" displayFormat="MM/dd/yyyy" cssClass="form-control"/>
                            <s:textfield name="diaryBookBO.coverPhoto" label="coverPhoto" cssClass="form-control"/>
                            <s:textfield name="diaryBookBO.backgroundImages" label="Ảnh bìa" cssClass="form-control"/>
                            <s:textfield name="diaryBookBO.backgroundAudio" label="Nhạc nền" cssClass="form-control"/>
                             <s:textfield name="diaryBookBO.audioAutoPlay" label="Video" cssClass="form-control"/>
                           
                           <%
                                CategoryDAO categoryDAO = new CategoryDAO();
                                List<CategoryBO> listCategory = categoryDAO.getList();
                                CategoryBO categoryBO = new CategoryBO();
                                if(listCategory.size() > 0)
                            %>
                         <s:select label="Thể loại"  headerKey="-1" headerValue="chọn ...." list="#@java.util.LinkedHashMap@{'4':'Nhật kí cá nhân', '5':'Nhật kí nhóm', '6':'Nhật kí tình yêu'}" name="user.gender" cssClass="form-control" required="true"/>
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
    

                    



