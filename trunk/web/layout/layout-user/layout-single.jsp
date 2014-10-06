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
        <link href="${contextPath}/layout/frontend/css/read-content.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/layout/frontend/css/read-book.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/layout/frontend/css/read-mobile.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Quattrocento:400,700' rel='stylesheet' type='text/css'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=yes" />


        <title><tiles:insertAttribute name="title" /></title
    </head>
    <body>
        <div id="book-wrapper" class="notthreed">
            <div id="book">
                <tiles:insertAttribute name="body" />
                <a href="" title="< Previous" id="previous">&lt;</a>
                <a href="" title="Next >" id="next">&gt;</a>
            </div>
            <ul id="booktopbar">
                <li id="explode1" style="text-align: left;position: absolute;  left: 1%;">
                    <a href="${contextPath}/Index" title="Explode"><b></b><b></b><b></b><b></b> Trang chủ</a>
                </li>
                <li id="unexplode">
                    <a href="" title="Explode"><b></b><b></b> Un-Explode</a>
                </li>
                <li id="booknav">
                    <a id="navfirst" href="" title="First">&Iota;&lt;</a>
                    <a id="navback" class="move" href="" title="Previous">&lt;</a>
                    <a id="mobback" class="move" href="" title="Previous">&lt;</a>
                    <p></p>
                    <a id="navforward" class="move" href="" title="Next">&gt;</a>
                    <a id="mobforward" class="move" href="" title="Next">&gt;</a>
                    <a id="navlast" href="" title="Last">&gt;&Iota;</a>
                </li>
                <li id="threedoverride">
                    <a class="notthreedeed" href="#" title="3D Over Ride Switch"><b></b> 3D</a>
                </li>
            </ul>
            <ul id="bookpagezoomwrapper">
                <li id="bookpagezoom">
                    <a id="bookzoomclose" href="#" title="Close">X</a>
                    <div></div>
                    <!--<a href="" title="< Previous" id="zoomprevious">&lt;</a>
                    <a href="" title="Next >" id="zoomnext">&gt;</a>-->
                </li>
            </ul>
            <audio id="audio1" preload="auto">
                <source src="audio/page-flip-1b.mp3" type="audio/mpeg" />
                <source src="audio/page-flip-1b.ogg" type="audio/ogg" />
            </audio>
            <audio id="audio2" preload="auto">
                <source src="audio/flick-through-2b.mp3" type="audio/mpeg" />
                <source src="audio/flick-through-2b.ogg" type="audio/ogg" />
            </audio>
            <audio id="audio3" preload="auto">
                <source src="audio/paper-rip-1b.mp3" type="audio/mpeg" />
                <source src="audio/paper-rip-1b.ogg" type="audio/ogg" />
            </audio>
            <audio id="audio4" preload="auto">
                <source src="audio/3d.mp3" type="audio/mpeg" />
                <source src="audio/3d.ogg" type="audio/ogg" />
            </audio>

        </div>
        <div id="bodyshadow"></div>
        <script src="${contextPath}/layout/frontend/js/read-ga.js" type="text/javascript" async="" ></script>
        <script src="${contextPath}/layout/frontend/js/lib/jquery-1.8.js" type="text/javascript"></script>
        <script src="${contextPath}/layout/frontend/js/read-js.js" type="text/javascript"></script>
        <script src="${contextPath}/layout/frontend/js/read-3d.js" type="text/javascript"></script>
        <script src="${contextPath}/layout/frontend/js/read-mobile.js" type="text/javascript"></script>
        <script type="text/javascript">
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-4415130-7']);
            _gaq.push(['_trackPageview']);
            (function() {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();
        </script>
    </body>
</html>
