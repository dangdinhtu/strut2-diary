<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Thêm người dùng </h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-horizontal" action="AdminUserController" method="post">
                        <input type="hidden" name="userId" value="${user.userId}">
                        <s:hidden name="action" value="addOrUpdate" cssClass="form-control"/>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Tên</label>
                            <div class="col-sm-8">
                                <input type="text" name="name" value="${user.name}" class="form-control" id="name" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username"  class="col-sm-2 control-label">Tên đăng nhập</label>
                            <div class="col-sm-8">
                                <input type="text" name="username" value="${user.username}" class="form-control" id="username" placeholder="">
                            </div>
                        </div>
                            <div class="form-group">
                            <label for="email"  class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-8">
                                <input type="email" name="email" value="${user.email}" class="form-control" id="email" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">Ngày sinh</label>
                            <div class="col-sm-8">
                                <input type="date" name="birthday" value="${user.birthday}" class="form-control" id="birthday" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">Địa chỉ </label>
                            <div class="col-sm-8">
                                <input type="text" name="address" value="${user.address}" class="form-control" id="address" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">Điện thoại</label>
                            <div class="col-sm-8">
                                <input type="text" name="phone" value="${user.phone}" class="form-control" id="phone" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="gender" class="col-sm-2 control-label">Giới tính</label>
                            <div class="col-sm-8">
                                <div class="checkbox">
                                    <label><input type="radio" name="gender" <c:out value="${user.gender eq true ? 'checked' : ''}"/> value="1"> Nam </label>
                                    <label><input type="radio" name="gender" <c:out value="${user.gender eq false ? 'checked' : ''}"/> value="0"> Nữ </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="active" class="col-sm-2 control-label">Trạng thái</label>
                            <div class="col-sm-8">
                                <div class="checkbox">
                                    <label><input type="radio" name="active" <c:out value="${user.active eq true ? 'checked' : ''}"/> value="1"> Hoạt động </label>
                                    <label><input type="radio" name="active" <c:out value="${user.active eq false ? 'checked' : ''}"/> value="0"> Ngừng hoạt động </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="gender" class="col-sm-2 control-label">Chức vụ</label>
                            <div class="col-sm-8">
                                <div class="checkbox">
                                    <c:forEach var="item" items="${lstRole}">
                                        <label>
                                            <input type="checkbox" name="lstRoleId" 
                                                      value="${item.roleId}"
                                                      <c:forEach var="itemRoleUser" items="${lstRoleUser}">
                                                          <c:if test="${itemRoleUser.roleId eq item.roleId}">checked</c:if>
                                                      </c:forEach>
                                                      > ${item.name}
                                        </label><br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>        
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" class="btn btn-info" value="Lưu lại">
                            </div>
                        </div>
                    </form>						

                </div>
                <!-- /.panel-body -->
                <div class="panel-footer table-footer">

                </div>
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

<div><script>${result}</script></div>




