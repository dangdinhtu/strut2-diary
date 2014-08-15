<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
                <li class="active active-icon-home"><a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span> </a></li>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class=""><a href="quiz.html">Trắc nghiệm</a></li>
                    <li><a href="#">Xem bói</a></li>
                    <li><a href="#">Tạo ảnh</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nhật kí <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="read-diary.html">Đọc nhật kí</a></li>
                            <li><a href="#">Viết nhật kí</a></li>
                            <li class="divider"></li>
                            <li><a href="create-diary.html">Tạo mới nhật kí</a></li>
                        </ul>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Xin chào Admin <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Thiết lập</a></li>
                            <li><a href="#">Đổi mật khẩu</a></li>
                            <li><s:a href="AdminUserController"> Trang Admin</s:a></li>
                            <li class="divider"></li>
                            <li><a href="#">Thoát</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>