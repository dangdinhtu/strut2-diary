<%@page import="org.dom4j.CDATA"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="commonTags"%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Danh sách Chức vụ</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                DataTables Advanced Tables ${haha}
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-action">
                    
                    <div class="pull-left">
                        <a href="AdminRoleController?action=add" class="btn btn-default">Thêm </a>
                        <input type="button" class="btn btn-default btn-delete" data-delete-all="AdminRoleController?action=delete&id=" value="Xóa">
                    </div>
                    <div class="pull-right search-table">
                        <form action="AdminRoleController" method="post">
                            <div class="input-group">
                                <input type="text" name="keyword" value="${keyword}" class="form-control" placeholder="Nhập từ khóa tìm kiếm..">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit" >
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </span>
                            </div><!-- /input-group -->
                        </form>
                    </div>
                </div>
                <br>

                <div class="table-responsive">
                    <display:table id="data"  export="true" name="listRole" requestURI="/AdminRoleController" pagesize="10" class="table table-striped table-bordered table-hover" >
                        <display:column title="<input type='checkbox' name='selectall' class='js-ck-all'  />" media="html">
                            <input type="checkbox" name="roleBO.listId[]" class="checkbox-selection " value="${data.roleId}">
                        </display:column>
                        <display:column property="name" title="Tên" sortable="true"/>
                        <display:column property="descript" title="Mô tả"/>
                        <display:column title="Trạng thái">
                            <c:out value="${data.status eq true ? 'Đang hoạt động': 'Ngung hoạt động'}"/>
                        </display:column>
                        <display:column title="resource.key">
                            <a href="AdminRoleController?action=form-edit&id=${data.roleId}" class="table-a-edit"><i class="glyphicon glyphicon-pencil"></i></a>
                            <a href="#"  class="table-a-delete" data-redirect ="AdminRoleController?action=delete&id=${data.roleId}"><i class="glyphicon glyphicon-trash"></i></a>
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
