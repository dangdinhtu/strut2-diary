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
    
    $(document).ready(function() {
        $("#addResults").click(function() {
            var content = $(this).parent().find(".form-group").html();
            $(".js-form-add-results").append(content);
        });
    });
</script>

<div class="row">
    <div class="col-lg-12">
        <%
            if ("add".equals(action)) {
        %>
        <h1 class="page-header">Thêm trắc nghiệm dài</h1>
        <%        } else {
        %>
        <h1 class="page-header">Chỉnh sửa trắc nghiệm dài</h1>
        <% }%>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default" style="padding: 10px">
            <form class="form-horizontal" style="margin-top: 20px" action="AdminDiLongController" method="post">
                <s:hidden name="action" value="addOrUpdate"/>
                <s:hidden name="dlgBO.dlgId" />
                <div class="form-group">
                    <label for="name" class="col-sm-3 col-xs-12 control-label">Tiêu đề</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="dlgBO.name" cssClass="form-control" id="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="descript" class="col-sm-3 col-xs-12 control-label">Nội dung</label>
                    <div class="col-sm-7 col-xs-12">
                        <s:textfield name="dlgBO.descript" cssClass="form-control" id="descript" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="images" class="col-sm-3 col-xs-12 control-label">Ảnh minh họa</label>
                    <div class="col-sm-7 col-xs-12">
                        <input name="dlgBO.images" placeholder="Chọn ảnh từ máy" type="file" value="download.jsp"/>
                    </div>
                </div>
                <c:forEach var="items"  items="${listOfDiLongContent}">
                    <div class="form-group">
                        <label for="question" class="col-sm-3 col-xs-12 control-label">Câu hỏi</label>
                        <div class="col-sm-7 col-xs-12">
                            <input type="text" name="dlgBO.arrQuestion" value="${items.question}" class="form-control"  placeholder="Mời nhập câu hỏi">
                            <br>
                            <div class="form-group">
                                <label  class="col-sm-2 col-xs-12 control-label">Đáp án A</label>
                                <div class="col-sm-10 col-xs-12">
                                    <input type="text" name="dlgBO.arrA" value="${items.a}" style="width: 80%; float: left" class="form-control"  placeholder="Mời nhập đáp án A">
                                    <input type="text" name="dlgBO.arrMarkA" value="${items.markA}" style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 col-xs-12 control-label">Đáp án B</label>
                                <div class="col-sm-10 col-xs-12">
                                    <input type="text" name="dlgBO.arrB" value="${items.b}" style="width: 80%; float: left" class="form-control"  placeholder="Mời nhập đáp án B">
                                    <input type="text" name="dlgBO.arrMarkB" value="${items.markB}" style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 col-xs-12 control-label">Đáp án C</label>
                                <div class="col-sm-10 col-xs-12">
                                    <input type="text" name="dlgBO.arrC" value="${items.c}" style="width: 80%; float: left" class="form-control"  placeholder="Mời nhập đáp án C">
                                    <input type="text" name="dlgBO.arrMarkC" value="${items.markC}" style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-xs-12 control-label">Đáp án D</label>
                                <div class="col-sm-10 col-xs-12">
                                    <input type="text" name="dlgBO.arrD" value="${items.d}" class="form-control"  style="width: 80%; float: left" placeholder="Mời nhập đáp án D">
                                    <input type="text" name="dlgBO.arrMarkD" value="${items.markD}" style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                </div>
                            </div>

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
                                <label for="answer" class="col-sm-3 col-xs-12 control-label">Câu hỏi</label>
                                <div class="col-sm-7 col-xs-12">
                                    <input type="text" name="dlgBO.arrQuestion"  class="form-control"  placeholder="Mời nhập câu hỏi">
                                    <br>
                                    <div class="form-group">
                                        <label  class="col-sm-2 col-xs-12 control-label">Đáp án A</label>
                                        <div class="col-sm-10 col-xs-12">
                                            <input type="text" name="dlgBO.arrA"  class="form-control" style="width: 80%; float: left"  placeholder="Mời nhập đáp án A">
                                            <input type="text" name="dlgBO.arrMarkA" style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 col-xs-12 control-label">Đáp án B</label>
                                        <div class="col-sm-10 col-xs-12">
                                            <input type="text" name="dlgBO.arrB" class="form-control" style="width: 80%; float: left" placeholder="Mời nhập đáp án B">
                                            <input type="text" name="dlgBO.arrMarkB"  style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 col-xs-12 control-label">Đáp án C</label>
                                        <div class="col-sm-10 col-xs-12">
                                            <input type="text" name="dlgBO.arrC"  class="form-control" style="width: 80%; float: left" placeholder="Mời nhập đáp án C">
                                            <input type="text" name="dlgBO.arrMarkC"  style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-xs-12 control-label">Đáp án D</label>
                                        <div class="col-sm-10 col-xs-12">
                                            <input type="text" name="dlgBO.arrD" class="form-control" style="width: 80%; float: left" placeholder="Mời nhập đáp án D">
                                            <input type="text" name="dlgBO.arrMarkD"  style="width: 15%; float: right" class="form-control"  placeholder="Điểm">
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-3 col-xs-12 control-label">Kết quả</label>
                    <div class="col-sm-7 col-xs-12"></div>
                </div>
                <c:forEach var="itemResults"  items="${listOfResultDiLong}">
                    <div class="form-group">
                        <label class="col-sm-3 col-xs-12 control-label">Mức</label>
                        <div class="col-sm-7 col-xs-12">
                            <input type="text" name="dlgBO.arrScoreMin" value="${itemResults.scoreMin}" class="form-control"  style="width: 48%; float: left" placeholder="Ngưỡng trên">
                            <input type="text" name="dlgBO.arrScoreMax" value="${itemResults.scoreMax}" style="width: 48%; float: right" class="form-control"  placeholder="Ngưỡng dưới">
                            <br><br>
                            <textarea name="dlgBO.arrResult" value="${itemResults.results}"  class="form-control" rows="5" placeholder="${itemResults.results}"></textarea>
                        </div>
                    </div>
                </c:forEach>
                <div class="js-form-add-results">

                </div>
                <div class="form-group">
                    <label for="a" class="col-sm-3 col-xs-12 control-label"></label>
                    <div class="col-sm-7 col-xs-12">
                        <br><br>
                        <button type="button" class="btn btn-primary" id="addResults">Thêm kết quả</button>
                        <div style="display: none">
                            <div class="form-group">
                                <label class="col-sm-3 col-xs-12 control-label">Mức</label>
                                <div class="col-sm-7 col-xs-12">
                                    <input type="text" name="dlgBO.arrScoreMin"  class="form-control"  style="width: 47%; float: left" placeholder="Ngưỡng trên">
                                    <input type="text" name="dlgBO.arrScoreMax"  style="width: 47%; float: right" class="form-control"  placeholder="Ngưỡng dưới">
                                    <br><br><br>
                                    <textarea name="dlgBO.arrResult"  class="form-control" rows="5" placeholder="Kết quả"></textarea>
                                </div>
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








