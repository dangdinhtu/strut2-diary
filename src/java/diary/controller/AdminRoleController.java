/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.RoleBO;
import diary.common.Message;
import diary.dao.RoleDAO;
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
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer roleId =  roleBO.getRoleId();
            boolean flag = roleDAO.saveOrUpdate(roleId, roleBO);
            if(roleId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if(roleId != 0 || roleId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            roleBO = roleDAO.get(RoleBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            RoleBO roleBO = roleDAO.get(RoleBO.class, id);
            boolean check = roleDAO.delete(roleBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminRoleController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminRoleController");
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
     
     
}
