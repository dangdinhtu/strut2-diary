<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!DOCTYPE html>
<%
    HttpServletRequest req = ServletActionContext.getRequest();
    HttpServletResponse res = ServletActionContext.getResponse();
    String action = req.getParameter("action");
%>

<script>
    $(document).ready(function() {
        $("#add").click(function() {
            var content = $(this).parent().find(".form-group").html();
            $(".js-form-add").append(content);
        });
    });
</script>

<div class="row">
    <div class="col-lg-12">
        <%
            if ("add".equals(action)) {
        %>
        <h1 class="page-header">Thêm trắc nghiệm nhanh</h1>
        <%        } else {
        %>
        <h1 class="page-header">Chỉnh sửa trắc nghiệm nhanh</h1>
        <% }%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminDivinationFastController" method="post">
                <s:hidden name="action" value="addOrUpdate"/>
                <input type="hidden" name="divinationFastBO.dfnId"">
                <div class="form-group">
                    <label for="name" class="col-sm-3 col-xs-12 control-label">Tiêu đề</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="divinationFastBO.name" cssClass="form-control" id="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="descript" class="col-sm-3 col-xs-12 control-label">Nội dung</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="divinationFastBO.descript" cssClass="form-control" id="descript" />
                    </div>
                </div>
                <c:forEach var="items"  items="${listOfResult}">
                    <div class="form-group">
                        <label for="answer" class="col-sm-3 col-xs-12 control-label">Đáp án</label>
                        <div class="col-sm-7 col-xs-12">
                            <input type="text" name="listOfResult.answer" value="${items.answer}" class="form-control"  placeholder="Mời nhập đáp án">
                            <br>
                            <s:textarea name="listOfResult.result"  cssClass="form-control" rows="5" placeholder="Mời nhập kết quả" id="result"/>
                            <br>
                            <input name="listOfResult.images" placeholder="Chọn ảnh từ máy" type="file" />
                        </div>
                    </div>
                </c:forEach>
                    <div class="js-form-add">
                        
                    </div>
                <div class="form-group">
                    <label for="a" class="col-sm-3 col-xs-12 control-label"></label>
                    <div class="col-sm-7 col-xs-12">
                        <button type="button" class="btn btn-primary" id="add">Thêm đáp án</button>
                        <div style="display: none">
                            <div class="form-group">
                            <label for="answer" class="col-sm-3 col-xs-12 control-label">Đáp án  </label>
                            <div class="col-sm-7 col-xs-12">
                                <input type="text" name="listOfResult.answer" value="${items.answer}" class="form-control"  placeholder="Mời nhập đáp án">
                                <br>
                                <s:textarea name="listOfResult.result"  cssClass="form-control" rows="5" placeholder="Mời nhập kết quả" id="result"/>
                                <br>
                                <input name="listOfResult.images" placeholder="Chọn ảnh từ máy" type="file" />
                            </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
                                <br>
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








