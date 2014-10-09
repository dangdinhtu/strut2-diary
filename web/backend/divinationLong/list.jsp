<%@page import="org.dom4j.CDATA"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="commonTags"%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Danh sách Trắc nghiệm dài</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                DataTables Advanced Tables 
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-action">
                    
                    <div class="pull-left">
                        <a href="AdminDiLongController?action=add" ${checkAdd} class="btn btn-default">Thêm </a>
                        <input type="button" ${checkDel} class="btn btn-default btn-delete" data-delete-all="AdminDiLongController?action=delete&id=" value="Xóa">
                    </div>
                    <div class="pull-right search-table">
                        <form action="AdminDiLongController" method="post">
                            <div class="input-group">
                                <input type="text" name="keyword" value="${keyword}" class="form-control" placeholder="Nhập từ khóa tìm kiếm..">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit">
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </span>
                            </div><!-- /input-group -->
                        </form>
                    </div>
                </div>
                <br>

                <div class="table-responsive">
                    <display:table id="data"  export="true" name="listOfdlgBO" requestURI="/AdminDiLongController" pagesize="10" class="table table-striped table-bordered table-hover" >
                        <display:column title="<input type='checkbox' name='selectall' class='js-ck-all'  />" media="html">
                            <input type="checkbox" name="diaryBook.listId[]" class="checkbox-selection " value="${data.dlgId}">
                        </display:column>
                        <display:column property="name" title="Tên" sortable="true"/>
                        <display:column property="descript" title="Mô tả"/>
                         <display:column  title="Ảnh minh họa" style="width:20%;text-align:center;">
                            <img src="${contextPath}/images/${data.images}" width="100px" height="90px">
                        </display:column>
                        <display:column title="Sửa / Xóa">
                            <a href="AdminDiLongController?action=form-edit&id=${data.dlgId}" class="table-a-edit"><i class="glyphicon glyphicon-pencil" ${checkEdit} ></i></a>
                            <a href="#"  class="table-a-delete" ${checkDel} data-redirect ="AdminDiLongController?action=delete&id=${data.dlgId}"><i class="glyphicon glyphicon-trash"></i></a>
                        </display:column>
                    </display:table>
                </div>						
                <div><script>${result}</script></div>
            </div>
            <!-- /.panel-body -->
            <div class="panel-footer table-footer">


            </div>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
