<%-- 
    Document   : body
    Created on : 17-Aug-2014, 09:54:20
    Author     : DinhTu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<div class="content">
    <div class="icon-bar">
        <a href="#" title="New Enty"><img src="images/add.gif" /></a>
        <a href="#" title="Save"><img src="images/save.gif" /></a>
        <a href="#" title="Print"><img src="images/print.gif" /></a>
        <a href="#" title="Insert Photo"><img src="images/photo.gif" /></a>
        <a href="#" title="Format"><img src="images/format.gif" /></a>
        <a href="#" title="Tag"><img src="images/tag.gif" /></a>
        <a href="#" title="Customize"><img src="images/cus.gif" /></a>
        <a href="#" title="Versions"><img src="images/ver.gif" /></a>
        <a href="#" title="Comments"><img src="images/cmt.gif" /></a>
    </div>
    <a href="#"><div class="icon-content-1"></div></a>

    <div class="content-l">
        <div class="l-top">
            <div style="position:relative;">
                <div class="loading"><img src="images/ajax-loader.gif" /></br> Loading...</div>
                <div class="save"><img src="images/save.png" /></br> Save !</div>
            </div>
        </div>
        <div class="l-main"></div>
        <div class="l-bot"></div>
    </div>
    <div class="content-r">                    
        <div class="r-top">
            <input type="text" id="tit-here" value="Enter title !" />
        </div>
        <div class="r-main">
            <textarea id="text-here" row="40" cols="60">
                            write content here!
            s</textarea>
        </div>
        <div class="r-bot"></div>
    </div>
</div>
<div class="bottom"></div>
