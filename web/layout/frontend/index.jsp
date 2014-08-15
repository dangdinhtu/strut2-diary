<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=yes" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/lib/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/lib/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/layout.css">
    <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/custom-mobile.css">

    <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/default.css" />
    <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/component.css" />

    <script type="text/javascript" src="${contextPath }/layout/frontend/js/lib/jquery-1.9.js"></script>
    <script type="text/javascript" src="${contextPath }/layout/frontend/js/lib/bootstrap.min.js"></script>



	
</head>
<body>
<div class="container dev-main">
    <!--========header=================-->
    <div class="row">
        <tiles:insertAttribute name="header" />
    </div><br>
    <!--========menu=================-->
    <div class="row">
        <tiles:insertAttribute name="menu" />
    </div>
    <!--========body=================-->
    <div class="row">
        <tiles:insertAttribute name="body" />       
    </div>
    <br><hr class="hr-footer" size="2px" width="83%">
    <div class="row">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script src="${contextPath }/layout/frontend/js/modernizr.custom.js"></script>
<script src="${contextPath }/layout/frontend/js/books1.js"></script>
<script>
    $(function() {

        Books.init();

    });
    $(document).on("click", ".demo-popup", function(){
        $('#myModal').modal('show')
    })
</script>
</body>
</html>