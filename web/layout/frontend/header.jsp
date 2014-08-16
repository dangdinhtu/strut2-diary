<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
    <div class="col-xs-12 col-md-10 col-md-offset-1">
        <div class="pull-left choose-language">
            <select class="form-control">
                <option>Việt Nam</option>
                <option>English</option>
                <option>日本語</option>
            </select>
        </div>
        <div class="input-group header-search pull-right">
            <!----start-social-icons----->
            <div class="social-icons">
                <ul>
                    <li><a href="#"><img src="${contextPath}/layout/frontend/images/facebook.png" title="facebook" /></a></li>
                    <li><a href="#"><img src="${contextPath}/layout/frontend/images/twitter.png" title="twitter" /></a></li>
                    <li><a href="#"><img src="${contextPath}/layout/frontend/images/google.png" title="google pluse" /></a></li>
                </ul>
            </div>
            <!----End-social-icons----->
        </div><!-- /input-group -->
    </div>
    <div class="col-xs-12 col-md-10 col-md-offset-1">
        <div class="header">
            <img src="${contextPath}/layout/frontend/images/logo_1375239887.jpg" class="img-responsive">
    </div>
</div>