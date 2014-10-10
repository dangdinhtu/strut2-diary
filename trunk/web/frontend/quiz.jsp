<%-- 
    Document   : quiz
    Created on : 17-Aug-2014, 08:34:23
    Author     : DinhTu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>


    <div class="col-md-10 col-xs-12 col-md-offset-1">
        <div class="pull-left main-quiz">
            <div class="quiz-fast quiz-fast-left">
                <div class="quiz-fast-title">
                    Trắc nghiệm nhanh
                </div>
            <c:forEach var="item" items="${listOfDiFast}">
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object img-responsive" src="${contextPath}/layout/frontend/images/${item.image}" alt="...">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading"><a href="#">TRẮC NGHIỆM: ${item.name}</a></h4>
                        ${item.descript}
                    </div>
                </div>
            </c:forEach>
            

            <div class="media">
                <span></span>
            </div>
        </div>
    </div>
    <div class="pull-right main-quiz">
        <div class="quiz-fast quiz-fast-right">
            <div class="quiz-fast-title">
                Trắc nghiệm dài
            </div>

            <c:forEach var="item" items="${listOfDiLong}">
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object img-responsive" src="${contextPath}/layout/frontend/images/${item.images}" alt="...">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading"><a href="#">TRẮC NGHIỆM: ${item.name}</a></h4>
                        ${item.descript}
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
