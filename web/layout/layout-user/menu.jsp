<%-- 
    Document   : menu
    Created on : 17-Aug-2014, 09:52:36
    Author     : DinhTu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<div id="menu-hide" class="hide-div">
    <ul>
        <li><a href="#">menu 1</a></li>
        <li><a href="#">something like that</a></li>
        <li><a href="#">something like that</a></li>
        <li><a href="#">something like that</a></li>
        <li><a href="#">something like that</a></li>
        <li><a href="#">something like that</a></li>
    </ul>
</div>        
<div class="icon-left"></div>
<div class="icon-right"><span id="number-count">0</span></div>
<div class="menu">
    <div class="logo">
        <a href="#" ><img src="${contextPath}/layout/layout-user/images/logo.png" alt="Logo" /></a>
    </div>
    <a href="">
        <div class="upgrade">

        </div>
    </a>
</div>
