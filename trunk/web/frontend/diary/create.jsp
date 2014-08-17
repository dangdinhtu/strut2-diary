<%-- 
    Document   : create
    Created on : 17-Aug-2014, 09:15:09
    Author     : DinhTu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html>
<div class="col-md-10 col-xs-12 col-md-offset-1">
    <div class="frm-create-diary">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Tạo Nhật kí</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputSuccess3">Tên nhật kí</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputSuccess3">
                            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputSuccess3">Mô tả</label>
                        <div class="col-sm-8">
                            <textarea class="form-control"></textarea>
                            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-error has-feedback">
                        <label class="control-label col-sm-3" for="inputSuccess3">Loại nhật kí</label>
                        <div class="col-sm-8">
                            <select class="form-control">
                                <option>Nhật kí đơn</option>
                                <option>Nhật kí đôi</option>
                            </select>
                            <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-warning has-feedback">
                        <label class="control-label col-sm-3" for="inputSuccess3">Input with success</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputSuccess3">
                            <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
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
