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
                <s:form action="acount" name="frm" id="" cssClass="form-horizontal form-modal"  label="Name" method="post">
                    <s:hidden name="action" value="sign_in" cssClass="form-control"/>
                    <s:hidden name="userId" cssClass="form-control"/>
                    <s:hidden name="url" cssClass="current_url"/>
                    <s:textfield name="name" cssClass="form-control required" pattern="[\w\-'\s]+"  label="Tên" data-required="Tên không được để trống"  />
                    <s:textfield name="username" label="Tên đăng nhập" cssClass="form-control required" pattern="\w{6,20}" data-required="Tên đăng nhập không được để trống" />
                    <s:password name="password" label="Mật khẩu" pattern="\w{6,20}" cssClass="form-control required" data-required="Mật khẩu không được để trống" />
                    <s:password name="rePassword" label="Nhập lại mật khẩu" cssClass="form-control"/>
                    <s:textfield name="birthday" label="Ngày sinh" pattern="^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[\/]\d{4}$" cssClass="form-control required" data-required="Ngày sinh không được để trống" />
                    <s:textfield name="address" label="Địa chỉ"  pattern="[\w\-'\s]+" cssClass="form-control required" data-required="Địa chỉ không được để trống" />
                    <s:textfield name="phone" label="Điện thoại" pattern="[0][1-9][0-9]{8,9}" cssClass="form-control required" data-required="Điện thoại không được để trống" />
                    <s:textfield name="email" label="Email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$" cssClass="form-control required" data-required="Email không được để trống" />
                    <s:select label="Giới tính" data-required="Bạn chưa chọn giới tính" 
                              headerKey="" headerValue="chọn ...."
                              list="#{'1':'Nam', '0':'Nữ'}"  name="gender" cssClass="form-control required"/>
                    <s:submit value="Lưu lại " cssClass="js-add btn btn-primary" />
                    <s:reset value="Làm lại" id="resetFormId" cssClass="js-reset btn btn-warning" />
                </s:form>
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
                                <input type="text" class="form-control input-popup" name="username" id="inputEmail3" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-3 control-label">Mật khẩu</label>
                            <div class="col-sm-9 input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i> </span>
                                <input type="password" name="password" class="form-control input-popup" id="inputPassword3" placeholder="Password">
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
                                <input type="text" class="form-control" id="inputEmail4" placeholder="Email">
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