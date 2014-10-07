<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!--modal for form add user->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <a href="AdminUserController" class="close"  aria-hidden="true">&times;</a>
                <h4 class="modal-title" id="myModalLabel"><b>Form thêm nhân viên</b></h4>
            </div>
            <div class="modal-body">
                <s:form action="AdminUserController" name="frm" cssClass="form-horizontal form-modal"  label="Name" method="post">
                    <s:hidden name="action" value="addOrUpdate" cssClass="form-control"/>
                    <s:hidden name="user.userId" cssClass="form-control"/>
                    <s:textfield name="user.name" cssClass="form-control" label="Tên" />
                    <s:textfield name="user.username" label="Tên đăng nhập" cssClass="form-control"/>
                    <s:textfield name="user.password" label="Mật khẩu" cssClass="form-control"/>
                    <s:textfield name="user.birthday" label="Ngày sinh" cssClass="form-control"/>
                    <s:textfield name="user.address" label="Địa chỉ" cssClass="form-control"/>
                    <s:textfield name="user.phone" label="Điện thoại" cssClass="form-control"/>
                    <s:textfield name="user.email" label="Email" cssClass="form-control"/>
                    <s:select label="Giới tính" 
                              headerKey="-1" headerValue="chọn ...."
                              list="#{'1':'Nam', '0':'Nữ'}"  name="user.gender" cssClass="form-control"/>
                    <s:select label="Trạng thái" 
                              headerKey="-1" headerValue="chọn ...."
                              list="#{'1':'Hoạt động', '0':'Ngưng hoạt động'}"  name="user.active" cssClass="form-control"/>
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
<script>
    $('#myModal').modal({keyboard: true, backdrop : "static"});
</script>
