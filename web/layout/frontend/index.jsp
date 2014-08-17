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
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
            <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/lib/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/lib/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/layout.css">
        <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/custom-mobile.css">

        <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/default.css" />
        <link rel="stylesheet" type="text/css" href="${contextPath }/layout/frontend/css/component.css" />
        <script type="text/javascript" src="${contextPath }/layout/frontend/js/lib/jquery-1.9.js"></script>
        <script type="text/javascript" src="${contextPath }/layout/frontend/js/lib/bootstrap.min.js"></script>
        <!-- slide-->
        <link rel="stylesheet" href="${contextPath}/layout/frontend/css/home.css">
        <!-- CSS==================================== -->
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
                <script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
                <link rel="stylesheet" type="text/css" href="css/ie8-and-down.css" />
        <![endif]-->

        <!-- Favicons================================ -->
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
        <script src="${contextPath}/layout/frontend/js/jquery.cycle2.min.js"></script>

        

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
            <!--========slide=================-->
            <div class="row">
                <tiles:insertAttribute name="slide" />
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
            $(document).on("click", ".demo-popup", function() {
                $('#myModal').modal('show')
            })
        </script>
        <!-- like mạng xã hội-->
        <script src='https://apis.google.com/js/plusone.js' type='text/javascript' ></script>
        <script src='http://connect.facebook.net/en_US/all.js#xfbml=1? ' type='text/javascript' ></script>

        <!-- bắt đầu di chuột lên đầu trang-->
        <a href="#code1k-totop" id="toppage1k"><img src="${contextPath}/layout/frontend/images/up.png"></a>
        <script type='text/javascript'>
            $(function() {
                $.fn.scrollToTop = function() {
                    $(this).hide().removeAttr("href");
                    if ($(window).scrollTop() != "0") {
                        $(this).fadeIn("slow")
                    }
                    var scrollDiv = $(this);
                    $(window).scroll(function() {
                        if ($(window).scrollTop() == "0") {
                            $(scrollDiv).fadeOut("slow")
                        } else {
                            $(scrollDiv).fadeIn("slow")
                        }
                    });
                    $(this).click(function() {
                        $("html, body").animate({scrollTop: 0}, "slow")
                    })
                }
            });
            $(function() {
                $("#toppage1k").scrollToTop();
            });
        </script><!-- kết thúc di chuyển chuột-->
        <a style='display:scroll;position:fixed;top:200px;right:10px;' href='#'>
            <div id="like1">
                <div class='g-plusone'></div><br><br>
                <script type='text/javascript'>
                    document.write("<fb:like layout='button_count' show_faces='false' width='100?'></fb:like");
                </script>
                <br>	
            </div>
        </a>
    </body>
</html>