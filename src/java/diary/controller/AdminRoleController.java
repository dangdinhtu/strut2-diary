/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.FunctionBO;
import diary.bo.PermissionBO;
import diary.bo.RoleBO;
import diary.bo.RolePermBO;
import diary.common.Message;
import diary.dao.FunctionDAO;
import diary.dao.PermissionDAO;
import diary.dao.RoleDAO;
import diary.dao.RolePermDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DinhTu
 */
public class AdminRoleController extends ActionSupport{
    private RoleBO roleBO;
    RoleDAO roleDAO = new RoleDAO();
    private List<RoleBO> listRole;
    
    private FunctionBO functionBO;
    FunctionDAO functionDAO = new FunctionDAO();
    private List<FunctionBO> listFunction;
    
    private PermissionBO permissionBO;
    PermissionDAO permissionDAO = new PermissionDAO();
    private List<PermissionBO> listPermission;
    
    private RolePermBO rolePermBO;
    RolePermDAO rolePermDAO = new RolePermDAO();
    private RolePermBO[] listRolePerm;
    
    public List<String> listPost;
            
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer roleId =  roleBO.getRoleId();
            boolean flag = roleDAO.saveOrUpdateRole(roleId, roleBO, listRolePerm);
            if(roleId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if(roleId != 0 || roleId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            listFunction = functionDAO.getListFunctionBySql();
            listPermission = permissionDAO.getListBySql();
            //req.setAttribute("listPermission", res);
            return INPUT;
        }else if("form-edit".equals(action)){
            listFunction = functionDAO.getListFunctionBySql();
            listPermission = permissionDAO.getListBySql();
            Integer id = Integer.parseInt(req.getParameter("id"));
            roleBO = roleDAO.get(RoleBO.class, id);
            return INPUT;
        }else if("delete".equals(action)){
            String str = req.getParameter("id");
            String arr[] = str.split(",");
            Integer arrId[] = new Integer[arr.length];
            for (int i = 0; i < arrId.length; i++) {
                try {
                    arrId[i] = Integer.parseInt(arr[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                boolean check = roleDAO.multiDelete(arrId, RoleBO.class, "roleId");
                if(check)
                    result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminRoleController");
                else
                    result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminRoleController");
            } catch (Exception e) {
                e.printStackTrace();
                result = Message.getMessage("Xóa bản ghi thất bại", "error");
            }
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listRole = roleDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public RoleBO getRoleBO() {
        return roleBO;
    }

    public void setRoleBO(RoleBO roleBO) {
        this.roleBO = roleBO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public List<RoleBO> getListRole() {
        return listRole;
    }

    public void setListRole(List<RoleBO> listRole) {
        this.listRole = listRole;
    }

    public FunctionBO getFunctionBO() {
        return functionBO;
    }

    public void setFunctionBO(FunctionBO functionBO) {
        this.functionBO = functionBO;
    }

    public FunctionDAO getFunctionDAO() {
        return functionDAO;
    }

    public void setFunctionDAO(FunctionDAO functionDAO) {
        this.functionDAO = functionDAO;
    }

    public List<FunctionBO> getListFunction() {
        return listFunction;
    }

    public void setListFunction(List<FunctionBO> listFunction) {
        this.listFunction = listFunction;
    }

    public PermissionBO getPermissionBO() {
        return permissionBO;
    }

    public void setPermissionBO(PermissionBO permissionBO) {
        this.permissionBO = permissionBO;
    }

    public PermissionDAO getPermissionDAO() {
        return permissionDAO;
    }

    public void setPermissionDAO(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    public List<PermissionBO> getListPermission() {
        return listPermission;
    }

    public void setListPermission(List<PermissionBO> listPermission) {
        this.listPermission = listPermission;
    }

    public RolePermBO getRolePermBO() {
        return rolePermBO;
    }

    public void setRolePermBO(RolePermBO rolePermBO) {
        this.rolePermBO = rolePermBO;
    }

    public RolePermDAO getRolePermDAO() {
        return rolePermDAO;
    }

    public void setRolePermDAO(RolePermDAO rolePermDAO) {
        this.rolePermDAO = rolePermDAO;
    }

    public RolePermBO[] getListRolePerm() {
        return listRolePerm;
    }

    public void setListRolePerm(RolePermBO[] listRolePerm) {
        this.listRolePerm = listRolePerm;
    }

  
     
}
