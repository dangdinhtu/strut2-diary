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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    private List<RolePermBO> listRolePerm;
    
    private String checkAdd = "";
    private String checkEdit = "";
    private String checkDel = "";
            
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");      
        String result = "";
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        checkAdd = roleDAO.checkRole(username, 2, 2);
        checkEdit = roleDAO.checkRole(username, 3, 2);
        checkDel = roleDAO.checkRole(username, 4, 2);
        
        if ("addOrUpdate".equals(action)) {
            Integer roleId =  roleBO.getRoleId();
            String[] arr = roleBO.getListPerm();
            boolean check = true;
            int lastId = roleDAO.saveOrUpdateRole(roleId, roleBO);
            if(roleBO.getListPerm().length > 0){
                for(int i = 0; i < roleBO.getListPerm().length; i++){
                    String[] tmpStr = arr[i].split("_");
                    int[] arrRelation = new int[tmpStr.length];
                    for (int j = 0; j < tmpStr.length; j++){
                        arrRelation[j] = Integer.parseInt(tmpStr[j]);
                    }
                    roleBO.setPermId(arrRelation[0]);
                    roleBO.setFunctionId(arrRelation[1]);
                    req.setAttribute(roleBO.getListPerm()[i], "checked");  
                    check = roleDAO.addRelation(roleBO);
                    if(check == false){
                        break;
                    }
                }
            }
            if (roleId == null && check) 
                    result = Message.getMessage("Thêm mới bản ghi thành công", "success", "AdminRoleController");
            if(roleId != 0 || roleId != null  && check)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success", "AdminRoleController");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error", "AdminRoleController");
            
        }else if ("add".equals(action)) {
            if (checkAdd == "") {
            listFunction = functionDAO.getListFunctionBySql();
            listPermission = permissionDAO.getListBySql();
            return INPUT;
            }
        }else if("form-edit".equals(action)){
             if (checkEdit == "") {
            listFunction = functionDAO.getListFunctionBySql();
            listPermission = permissionDAO.getListBySql();
            Integer id = Integer.parseInt(req.getParameter("id"));
            listRolePerm = rolePermDAO.getList("RolePermBO", "roleId", id, "rpmId");
            roleBO = roleDAO.get(RoleBO.class, id);
            return INPUT;
             }
        }else if("delete".equals(action)){
            if (checkDel == "") {
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
        }
        action = null;
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listRole = roleDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public String getCheckAdd() {
        return checkAdd;
    }

    public void setCheckAdd(String checkAdd) {
        this.checkAdd = checkAdd;
    }

    public String getCheckEdit() {
        return checkEdit;
    }

    public void setCheckEdit(String checkEdit) {
        this.checkEdit = checkEdit;
    }

    public String getCheckDel() {
        return checkDel;
    }

    public void setCheckDel(String checkDel) {
        this.checkDel = checkDel;
    }

    public RoleBO getRoleBO() {
        return roleBO;
    }

    public void setRoleBO(RoleBO roleBO) {
        this.roleBO = roleBO;
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

    public List<RolePermBO> getListRolePerm() {
        return listRolePerm;
    }

    public void setListRolePerm(List<RolePermBO> listRolePerm) {
        this.listRolePerm = listRolePerm;
    }
}
