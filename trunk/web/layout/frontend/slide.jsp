<%-- 
    Document   : slide
    Created on : 17-Aug-2014, 08:05:08
    Author     : DinhTu
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<div class="col-xs-12 col-md-10 col-md-offset-1">
    <div id="slide_outer">
        <div class="mainslide">

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
                <li class="clearfix">
                    <div class="slide_img">
                        <img src="images/icons/iphone_4_icon.png" alt="">
                    </div>
                    <div class="flex-caption">
                        <h5>Now it's available<br><span>IPhone 4 is Released</span></h5>
                        <p>
                            Quisque pharetra neque at odio viverra pellentesque ultrices mi sodales. Nam accumsan lacus sed ipsum tempus mollis. Nulla vitae lorem libero, at porta enim. Aenean quis justo metus.
                        </p>
                        <p>
                            Nam accumsan lacus sed ipsum tempus mollis. Nulla vitae lorem libero, at porta enim. Aenean quis justo metus.
                        </p>
                        <a href="#"><span>View Item</span><span class="shadow">$190.00</span></a>
                    </div>
                </li>

                <li class="clearfix">
                    <div class="slide_img">
                        <img src="images/icons/iphone_4_icon2.png" alt="">
                    </div>
                    <div class="flex-caption">
                        <h5>Now it's available<br><span>IPhone 4 is Released</span></h5>
                        <p>
                            Quisque pharetra neque at odio viverra pellentesque ultrices mi sodales. Nam accumsan lacus sed ipsum tempus mollis. Nulla vitae lorem libero, at porta enim. Aenean quis justo metus.
                        </p>
                        <p>
                            Nam accumsan lacus sed ipsum tempus mollis. Nulla vitae lorem libero, at porta enim. Aenean quis justo metus.
                        </p>
                        <a href="#"><span>View Item</span><span class="shadow">$190.00</span></a>
                    </div>
                </li>

                <li class="clearfix">
                    <div class="slide_img">
                        <img src="images/icons/camcorder.png" alt="">
                    </div>
                    <div class="flex-caption">
                        <h5>New Entry this day<br><span>DV Camcorder</span></h5>
                        <p>
                            Quisque pharetra neque at odio viverra pellentesque ultrices mi sodales. Nam accumsan lacus sed ipsum tempus mollis. Nulla vitae lorem libero, at porta enim. Aenean quis justo metus.
                        </p>
                        <a href="#"><span>View Item</span><span class="shadow">$210.90</span></a>
                    </div>
                </li>
            </ul>
        </div>
        <div class="shadow_left"></div>
        <div class="shadow_right"></div>
    </div>
</div>
