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
            //var string = "<div class='form-group'>" +
//                    "<label for='answer' class='col-sm-3 col-xs-12 control-label'>Đáp án</label>" +
//                    "<div class='co'l-sm-7 col-xs-12'>" +
//                    "<textfield  cssClass='form-control' id='answer' /><br>" +
//                    "<textarea   cssClass='form-control' rows='5' id='result'/><br>" +
//                    "<input type='file' name = 'myFile' /> </div> </div>";
            var content = $(this).parent().find(".form-group").html();
            //content.find(".form-group").attr("style", "");
            $(".js-form-add").append(content);
            //$(string).appendTo("form");
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
            <form class="form-horizontal" style="margin-top: 20px" action="AdminDivinationFastController" method="get">
                <s:hidden name="action" value="addOrUpdate"/>
                <s:hidden name="divinationFastBO.dfnId"/>
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
                <c:forEach var="items"  items="${stt}">
                    <div class="form-group">
                        <label for="answer" class="col-sm-3 col-xs-12 control-label">Đáp án  </label>
                        <div class="col-sm-7 col-xs-12">
                            <s:textfield name="divinationFastBO.listAnswer" cssClass="form-control" id="answer" />
                            <br>
                            <s:textarea name="divinationFastBO.listResult"  cssClass="form-control" rows="5" id="result"/>
                            <br>
                            <input name="divinationFastBO.listImage" type="file" name="myFile" />
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
                                <s:textfield name="divinationFastBO.listAnswer" cssClass="form-control" id="answer" />
                                <br>
                                <s:textarea name="divinationFastBO.listResult"  cssClass="form-control" rows="5" id="result"/>
                                <br>
                                <input name="divinationFastBO.listImage" type="file" name="myFile" />
                            </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
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








