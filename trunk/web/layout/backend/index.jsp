<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>ï»¿
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <!-- Core CSS - Include with every page -->
        <link href="${contextPath }/layout/backend/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath }/layout/backend/css/bootstrap-theme.css" rel="stylesheet">
        <link href="${contextPath }/layout/backend/font-awesome/css/font-awesome.css" rel="stylesheet">
        <!-- SB Admin CSS - Include with every page -->
        <link href="${contextPath }/layout/backend/css/sb-admin.css" rel="stylesheet">
        <link href="${contextPath }/layout/backend/css/table.css" rel="stylesheet">
        <link href="${contextPath }/layout/backend/css/jquery.toastmessage.css" rel="stylesheet" >
        
        
        <!-- Core Scripts - Include with every page -->
        <script src="${contextPath }/layout/backend/js/lib/jquery-1.9.js"></script>
        <script src="${contextPath }/layout/backend/js/lib/bootstrap.min.js"></script>
        <script src="${contextPath }/layout/backend/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <!-- SB Admin Scripts - Include with every page -->
        <script src="${contextPath }/layout/backend/js/sb-admin.js"></script>
        <script src= "${contextPath }/layout/backend/js/jquery.toastmessage.js"></script>
        <script src= "${contextPath }/layout/backend/js/admin-main.js"></script>
        <script src= "${contextPath }/layout/backend/js/click-button.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
                <tiles:insertAttribute name="header" />
                <tiles:insertAttribute name="sidebar" />
            </nav>
            
            <div id="page-wrapper">
                <tiles:insertAttribute name="body" />
                <!-- /.row -->
            </div>
        </div>
        <tiles:insertAttribute name="form" />
        

    </body>

</html>
