<%-- 
    Document   : create
    Created on : 17-Aug-2014, 09:15:09
    Author     : DinhTu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<div class="col-md-10 col-xs-12 col-md-offset-1">
    <div class="frm-create-diary">
        <form method="post" action="diary" class="form-horizontal" role="form" enctype="multipart/form-data">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Tạo Nhật kí</h3>
            </div>
            <div class="panel-body">
                    <input type="hidden" name="action" value="signin-diary">
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="inputSuccess3">Tên nhật kí</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="">
                        </div>
                    </div>
                    <div class="form-group ">
                        <label class="control-label col-sm-3" for="">Ảnh bìa</label>
                        <div class="col-sm-7">
                            <div class="img-preview" style="display: none;">
                                <i class="glyphicon glyphicon-remove"></i>
                                <img id="uploadPreview1" src="no_image.jpg" style="width: 150px;"/><br />
                            </div>
                            <input type="file"  id="uploadImage1" onchange="PreviewImage(1);" name="coverPhoto">
                        </div>
                    </div>
                    <div class="form-group ">
                        <label class="control-label col-sm-3" for="">Ảnh nền</label>
                        <div class="col-sm-7">
                            <div class="img-preview" style="display: none;">
                                <i class="glyphicon glyphicon-cloud-upload"></i>
                                <img id="uploadPreview2" src="no_image.jpg" style="width: 150px;"/><br />
                            </div>
                            <input type="file" name="backgroundImages" id="uploadImage2" onchange="PreviewImage(2);" >
                        </div>
                    </div>
                    <div class="form-group ">
                        <label class="control-label col-sm-3" for="">Nhạc nền</label>
                        <div class="col-sm-7">
                            <input type="file" name="backgroundAudio">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="">Loại nhật kí</label>
                        <div class="col-sm-7">
                            <select name="categoryId" class="form-control">
                                <option value="-1">-- Chọn -- </option>
                                <c:forEach var="items" items="${lstCategory}">
                                    <option value="${items.categoryId}">${items.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel-footer panel-footer-create">
                <div class="pull-right">
                    <input type="submit" class="btn btn-info">
                    <input type="reset" class="btn btn-default">
                </div>
            </div>
        </div>
    </div>
    </div>
</div>
<script type="text/javascript">
    function PreviewImage(no) {
        var oFReader = new FileReader();
        oFReader.readAsDataURL(document.getElementById("uploadImage"+no).files[0]);
        
        $("#uploadImage" + no).parent().find(".img-preview").show();
        oFReader.onload = function (oFREvent) {
            document.getElementById("uploadPreview"+no).src = oFREvent.target.result;
        };
    }
    
    $(document).on("click", ".img-preview > i", function (){
        $(this).parent().hide("slow");
        $(this).parent().find("img").attr("src", "");
        $(this).parent().parent().find("input[type=file]").val("");
    })

</script>