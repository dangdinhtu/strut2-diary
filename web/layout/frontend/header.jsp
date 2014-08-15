<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<div class="col-xs-12 col-md-10 col-md-offset-1">
    <div class="pull-left choose-language">
        <select class="form-control">
            <option>Việt Nam</option>
            <option>English</option>
            <option>日本語</option>
        </select>
    </div>
    <div class="input-group header-search pull-right">
        <input type="text" class="form-control" placeholder="Search...">
        <span class="input-group-btn"><button class="btn btn-info btn-search" type="submit"><i class="glyphicon glyphicon-search"></i></button></span>
    </div><!-- /input-group -->
</div>
<div class="col-xs-12 col-md-10 col-md-offset-1">
    <div class="header">
        <img src="${contextPath}/layout/frontend/images/logo_1375239887.jpg" class="img-responsive">
    </div>
</div>