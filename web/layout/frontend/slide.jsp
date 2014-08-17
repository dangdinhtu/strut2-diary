<%-- 
    Document   : slide
    Created on : 17-Aug-2014, 08:05:08
    Author     : DinhTu
--%>

<%@page import="diary.bo.AdsBO"%>
<%@page import="diary.bo.UserBO"%>
<%@page import="java.util.List"%>
<%@page import="diary.dao.AdsDAO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<div class="col-xs-12 col-md-10 col-md-offset-1">
    <div id="slide_outer">
        <div class="mainslide">
                <% 
                    AdsDAO ads = new AdsDAO();
                    List<AdsBO> list = ads.getList();
                    System.out.println(list.get(0).getName());
                
                %>
            <div class="pagers center">
                <a class="prev slide_prev" href="#prev">Prev</a>
                <a class="nxt slide_nxt" href="#nxt">Next</a>
            </div>

            <ul class="cycle-slideshow clearfix" 
                data-cycle-fx="scrollHorz"
                data-cycle-timeout="2000"
                data-cycle-slides="> li"
                data-cycle-pause-on-hover="true"
                data-cycle-prev="div.pagers a.slide_prev"
                data-cycle-next="div.pagers a.slide_nxt"
                >
                <c:forEach items="<%= list%>" var="adsObj" varStatus="status">
                <li class="clearfix">
                    <div class="slide_img">
                        <img src="${contextPath}/images/ads/${adsObj.getImages()}" height="305px" alt="">
                    </div>
                    <div class="flex-caption">
                        <h5>${adsObj.getTitle()}</h5>
                        <p>${adsObj.getContent()}</p>
                        <a href="#"><span>View Item</span><span class="shadow">$190.00</span></a>
                    </div>
                </li>
                </c:forEach>
                
            </ul>
        </div>
        <div class="shadow_left"></div>
        <div class="shadow_right"></div>
    </div>
</div>
