<%-- 
    Document   : index
    Created on : 17-Aug-2014, 09:43:21
    Author     : DinhTu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link href="${contextPath}/layout/frontend/css/lib/bootstrap.min.css" type="text/css" rel="stylesheet" />
        <link href="${contextPath}/layout/layout-user/css/layout.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="${contextPath }/layout/frontend/js/lib/jquery-1.9.js"></script>
        <script type="text/javascript" src="${contextPath }/layout/frontend/js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="${contextPath }/layout/layout-user/js/process.js"></script>
    </head>
    <style>
        .nav a{
            text-decoration: none!important;
            font-size: 17px;
        }
        </style>
    <body>
        <tiles:insertAttribute name="menu" />
        <br>
        <div class="wflow">  
            <tiles:insertAttribute name="body" />
        </div> 
    </body>
</html>
