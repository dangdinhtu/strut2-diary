<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang quáº£n trá» Nhuáº­n BÃºt</title>

    <!-- Core CSS - Include with every page -->
    <link href="${contextPath }/layout/frontend/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath }/layout/frontend/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- SB Admin CSS - Include with every page -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
</head>

<body>


    <div class="panel panel-default panel-login">
        <div class="panel-heading"><h4><b>ÄÄng nháº­p há» thá»ng</b></h4></div>
        <div class="panel-body">
            <form class="form-horizontal" action="login" role="form">
                <div class="js-form-login">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">Email</label>
                        <div class="col-sm-9 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i> </span>
                            <input type="text" class="form-control" id="inputEmail3" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">Password</label>
                        <div class="col-sm-9 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i> </span>
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group login-remember-password">
                        <div class="col-sm-offset-3 col-sm-9">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group login-bt">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success">ÄÄng nháº­p</button>
                            <button type="reset" class="btn btn-default">Nháº­p láº¡i</button>
                        </div>
                    </div>
                </div>

                <div class="js-hidden js-form-forget-password">
                    <div class="form-group">
                        <label for="inputEmail4" class="col-sm-3 control-label">Email</label>
                        <div class="col-sm-9 input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i> </span>
                            <input type="text" class="form-control" id="inputEmail4" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group login-bt">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success">Gá»­i Äi</button>
                        </div>
                    </div>
                </div>
            </form>


        </div>
        <div class="panel-footer">
            <a href="#" class="js-a-forget-password" >QuÃªn máº­t kháº©u</a>
            <a href="#" class="js-a-login js-hidden" >ÄÄng nháº­p</a>
        </div>
    </div>







    <!-- Core Scripts - Include with every page -->
    <script src="../js/lib/jquery-1.9.js"></script>
    <script src="../js/lib/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <!-- SB Admin Scripts - Include with every page -->
    <script src="js/sb-admin.js"></script>
    <script src= "js/admin-main.js">  </script>
    <script src= "js/click-button.js">  </script>

</body>

</html>
