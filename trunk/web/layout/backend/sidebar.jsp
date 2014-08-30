<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<!---=======bắt đầu với menu sidebar=============-->
<div class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <!--mục tìm kiếm tổng thể-->
            <li class="sidebar-search">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
                <!-- /input-group -->
            </li><!--kết thúc mục tìm kiếm tổng thể-->
            <li>
                <a href="index.html"><i class="glyphicon glyphicon-home"></i> Trang chủ</a>
            </li>
            <li>
                <a href="#"><i class="glyphicon glyphicon-user"></i>  Người dùng<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="AdminUserController">Thông tin người dùng</a>
                    </li>
                    
                </ul>
                <!-- /.nav-second-level -->
            </li>

            <li>
                <a href="#"><i class="fa fa-edit fa-fw"></i> Bài viết<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="flot.html">Danh sách bài viết</a>
                    </li>
                    <li>
                        <a href="flot.html">Dach sách từ khóa</a>
                    </li>
                    <li>
                        <a href="morris.html">Danh sách liên kết</a>
                    </li>
                    <li>
                        <a href="morris.html">Cấu hình yêu cầu bài viết</a>
                    </li>
                    <li>
                        <a href="morris.html">Thể loại bài viết</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="tables.html"><i class="glyphicon glyphicon-list-alt"></i> Lịch sử thanh toán <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="flot.html">Yêu cầu thanh toán</a>
                    </li>
                    <li>
                        <a href="flot.html">Đã thanh toán</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="forms.html"><i class="glyphicon glyphicon-file"></i> Thông tin chung</a>
            </li>
            <li>
                <a href="forms.html"><i class="glyphicon glyphicon-tree-deciduous"></i> Tài nguyên</a>
            </li>
            <li>
                <a href="#"><i class="glyphicon glyphicon-usd"></i> Quản lý thu chi<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="panels-wells.html">Quản lý nhóm</a>
                    </li>
                    <li>
                        <a href="buttons.html">Phân loại thu chi</a>
                    </li>
                    <li>
                        <a href="notifications.html">Thu chi</a>
                    </li>
                    <li>
                        <a href="typography.html">Phân loại kế hoạch</a>
                    </li>
                    <li>
                        <a href="grid.html">Dach sách tên miền</a>
                    </li>
                    <li>
                        <a href="grid.html">Cảnh báo tên miền hết hạn</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="glyphicon glyphicon-globe"></i> Trỏ lĩnh vực site vệ tinh<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="blank.html">Danh sách tên miền</a>
                    </li>
                    <li>
                        <a href="login.html">Danh sách lĩnh vực</a>
                    </li>
                    <li>
                        <a href="login.html">Trỏ lĩnh vực vào tên miền</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
        </ul>
        <!-- /#side-menu -->
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!---=======kết thúc menu sidebar=============-->