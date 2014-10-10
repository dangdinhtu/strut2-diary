<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set  var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
    <div class="col-md-10 col-xs-12 col-md-offset-1">
        <div class="footer">
            <h3>Hệ Thống Nhật Kí Tình Yêu</h3>
            <p>Trường Đào tạo lập trình viên quốc tế AiTi-Aptech</p>
        </div>
    </div>

    <div class="modal fade" id="myModal-signin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel"><b>Đăng kí tài khoản</b></h4>
                </div>
                <div class="modal-body">
                    <!--  Lỗi ở đây -->
                    <form class="form-horizontal" action="acount" role="form">
                    <s:hidden name="action" value="sign_in" cssClass="form-control"/>
                    <s:hidden name="userId" cssClass="form-control"/>
                    <s:hidden name="url" cssClass="current_url"/>
                    <div class="js-form-login">
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">Tên</label>
                            <div class="col-sm-9 input-group">
                                <input type="text" pattern="[\w\-'\s]+" required class="form-control input-popup" name="name" id="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="col-sm-3 control-label">Tên đăng nhập</label>
                            <div class="col-sm-9 input-group">
                                <input type="text" class="form-control input-popup" required pattern="\w{6,20}" name="username" id="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">Mật khẩu</label>
                            <div class="col-sm-9 input-group">
                                <input type="text" pattern="\w{6,20}" required class="form-control input-popup" name="password" id="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="rePassword" class="col-sm-3 control-label">Nhập lại mật khẩu</label>
                            <div class="col-sm-9 input-group">
                                <input type="text" class="form-control input-popup" required name="rePassword" id="rePassword" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-3 control-label">Ngày sinh</label>
                            <div class="col-sm-9 input-group">
                                <input type="date" class="form-control input-popup" required name="birthday" id="birthday" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-3 control-label">Địa chỉ</label>
                            <div class="col-sm-9 input-group">
                                <input type="text" pattern="[\w\-'\s]+"  class="form-control input-popup" required name="address" id="address" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-3 control-label">Điện thoại</label>
                            <div class="col-sm-9 input-group">
                                <input type="text" pattern="[0][1-9][0-9]{8,9}" class="form-control input-popup" required name="phone" id="phone" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-9 input-group">
                                <input type="email" class="form-control input-popup" required name="email" id="email" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Giới tính</label>
                            <div class="col-sm-8 input-group">
                                <select class="form-control" required>
                                    <option value="-1">Chọn ...</option>
                                    <option value="0">Nữ</option>
                                    <option value="1">Nam</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-success">Hoàn tất</button>
                                <button type="reset" class="btn btn-default">Nhập lại</button>
                            </div>
                        </div>
                    </div>              
                </form>
                <!-- end -->
            </div>
            <div class="modal-footer" style="height: 50px">
                <input type="button" class="btn" value="xóa" style="display: none;">
            </div>
        </div>
    </div>
</div>


<!-- form  login -->
<div class="modal fade myModal-login" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"><b>Đăng nhập hệ thống</b></h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="acount" role="form">
                    <input type="hidden" name="action" class="js-action-login" value="login">
                    <s:hidden name="url" cssClass="current_url"/>
                    <div class="js-form-login">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Tên đăng nhập</label>
                            <div class="col-sm-9 input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i> </span>
                                <input type="text" class="form-control input-popup" name="username" required placeholder="Tên đăng nhập" pattern="\w{5,40}" id="inputEmail3" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-3 control-label">Mật khẩu</label>
                            <div class="col-sm-9 input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i> </span>
                                <input type="password" name="password" class="form-control input-popup" pattern="\w{5,40}"  required id="inputPassword3" placeholder="Mật khẩu">
                            </div>
                        </div>
                        <div class="form-group login-remember-password">
                            <div class="col-sm-offset-3 col-sm-9">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group login-bt">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-success">Đăng nhập</button>
                                <button type="reset" class="btn btn-default">Nhập lại</button>
                            </div>
                        </div>
                    </div>
                    <!--                       form quên mật khẩu-->
                    <div class="js-hidden js-form-forget-password">
                        <div class="form-group">
                            <label for="inputEmail4" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-9 input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i> </span>
                                <input type="text" class="form-control" id="inputEmail4" >
                            </div>
                        </div>
                        <div class="form-group login-bt">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-success">Gửi đi</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer" style="height: 50px">
                <a href="#" class="js-a-forget-password" >Quên mật khẩu</a>
                <a href="#" class="js-a-login js-hidden" >Đăng nhập</a>
            </div>
        </div>
    </div>
</div>