<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<!---=======bắt đầu với menu sidebar=============-->
<div class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            
            <!--kết thúc mục tìm kiếm tổng thể-->
            <li>
                <h4 class="text-success" style="margin-left: 10px"><b>Xin chào ${sessionScope.userName}</b></h4>
            </li>
            <li>
                <a href="Index"><i class="glyphicon glyphicon-home"></i> Trang chủ</a>
            </li>
            <li>
                <a href="#"><i class="glyphicon glyphicon-user"></i>  Người dùng<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li ${checkUser}>
                        <a href="AdminUserController">Tài khoản người dùng</a>
                    </li>
                    <li ${checkRole}>
                        <a href="AdminRoleController">Thông tin chức vụ</a>
                    </li>
                    
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="glyphicon glyphicon-user"></i>Nhật kí<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li ${checkCat}>
                        <a href="AdminCategoryController">Thể loại</a>
                    </li>
                    <li ${checkDiary}>
                        <a href="AdminDiaryBookController">Danh sách nhật kí</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-edit fa-fw"></i>Giải trí<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li ${checkDiFast}>
                        <a href="AdminDivinationFastController">Trắc nghiệm nhanh</a>
                    </li>
                    <li ${checkDiLong}>
                        <a href="AdminDiLongController">Trắc nghiệm dài</a>
                    </li>
                    <li ${checkCouple}>
                        <a href="AdminRDCController">Cặp đôi ăn ý</a>
                    </li>
                    <li ${checkZodiac}>
                        <a href="AdminZodiacController">Danh sách cung hoàng đạo</a>
                    </li>
                    <li ${checkImage}>
                        <a href="#">Tạo ảnh ngộ nghĩnh</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="AdminResourceController" ${checkResource}><i class="glyphicon glyphicon-list-alt"></i> Quản trị tài nguyên<span class="fa arrow"></span></a>
            </li>
        </ul>
        <!-- /#side-menu -->
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!---=======kết thúc menu sidebar=============-->