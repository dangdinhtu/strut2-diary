<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10 col-xs-12 col-md-offset-1">
    <!--======== start header===========-->
    <nav class="navbar navbar-default nav-menu" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <li class="<c:out value="${requestScope['javax.servlet.forward.servlet_path'] eq '/Index' ? 'active-icon-home' : ''} "/>" style="list-style:none"><a class="navbar-brand" href="Index"><span class="glyphicon glyphicon-home"></span> </a></li>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class='<c:out value="${requestScope['javax.servlet.forward.servlet_path'] eq '/QuizController' ? 'active' : ''} "/>'><a href="QuizController">Trắc nghiệm</a></li>
                    <li><a href="#">Xem bói</a></li>
                    <li><a href="#">Tạo ảnh</a></li>
                    <li class="dropdown <c:out value="${requestScope['javax.servlet.forward.servlet_path'] eq '/diary' ? 'active' : ''} "/>">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nhật kí <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="diary?action=review-diary">Nhật kí của tôi</a></li>
                            <li><a href="diary?action=write-diary">Viết nhật kí</a></li>
                            <li class="divider"></li>
                            <li><a href="diary?action=create-diary">Tạo mới nhật kí</a></li>
                        </ul>
                    </li>
                </ul>
                <c:if test="${sessionScope.userName != null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Xin chào ${sessionScope.userName} <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Thiết lập</a></li>
                                <li><a href="#">Đổi mật khẩu</a></li>
                                <li><a href="AdminStartController"> Trang Admin</a></li>
                                <li class="divider"></li>
                                <li><a href="acount?action=logout">Thoát</a></li>
                            </ul>
                        </li>
                    </ul>
                </c:if>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>