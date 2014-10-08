/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.RoleBO;
import diary.bo.UserBO;
import diary.bo.UserRoleBO;
import diary.common.Common;
import diary.common.Message;
import diary.dao.RoleDAO;
import diary.dao.UserDAO;
import diary.dao.UserRoleDAO;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DinhTu
 */
public class AdminUserController extends ActionSupport {

    private UserBO userBO;
    UserDAO userDAO = new UserDAO();
    private List<UserBO> listUser;
    RoleDAO roleDAO = new RoleDAO();
    private List<RoleBO> listRole;
    UserRoleDAO userRoleDAO = new UserRoleDAO();
    List<UserRoleBO> listUserRole;

    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");

        String result = "";
        if ("addOrUpdate".equals(action)) {
            Integer userId = userBO.getUserId();

            List<UserBO> lstUser = userDAO.findByProperty(UserBO.class, "username", userBO.getUsername(), "");
            List<UserBO> lstByEmail = userDAO.findByProperty(UserBO.class, "email", userBO.getEmail(), "");
            int size = 0;
            if (userId != null) {
                size = 1;
            }
            if (lstUser.size() > size || lstByEmail.size() > size) {
                result = Message.getMessage("Email hoặc username đã tồn tại", "error");
            } else {
                Integer id = userDAO.saveOrUpdateUser(userId, userBO);
                Boolean check = null;

                for (int i = 0; i < userBO.getListRole().length; i++) {
                    Integer[] roleId = userBO.getListRole();
                    UserRoleBO userRoleBO = new UserRoleBO();
                    userRoleBO.setRoleId(roleId[i]);
                    userRoleBO.setStatus(true);
                    userRoleBO.setUserId(id);
                    check = userRoleDAO.save(userRoleBO);
                }
                if (userId == null && check) {
                    result = Message.getMessage("Thêm mới bản ghi thành công", "success", "AdminUserController");
                } else if (userId != null && check) {
                    result = Message.getMessage("Cập nhật bản ghi thành công", "success", "AdminUserController");
                } else {
                    result = Message.getMessage("Cập nhật bản ghi thất bại", "error", "AdminUserController");
                }
            }
        } else if ("add".equals(action)) {
            listRole = roleDAO.getListBySql();
            return INPUT;
        } else if ("form-edit".equals(action)) {
            listRole = roleDAO.getListBySql();
            Integer id = Integer.parseInt(req.getParameter("id"));
            userBO = userDAO.get(UserBO.class, id);
            listUserRole = userRoleDAO.findByProperty(UserRoleBO.class, "userId", id, "");
            return INPUT;
        } else if ("delete".equals(action)) {
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
                boolean check = userDAO.multiDelete(arrId, UserBO.class, "userId");
                if (check) {
                    result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminUserController");
                } else {
                    result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminUserController");
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = Message.getMessage("Xóa bản ghi thất bại", "error");
            }
        }
        action = null;
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listUser = userDAO.getList("UserBO", "username", "email", keyword, "userId");
        req.setAttribute("keyword", keyword);

        return SUCCESS;
    }

    public List<UserBO> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserBO> listUser) {
        this.listUser = listUser;
    }

    public UserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(UserBO userBO) {
        this.userBO = userBO;
    }

    public List<RoleBO> getListRole() {
        return listRole;
    }

    public void setListRole(List<RoleBO> listRole) {
        this.listRole = listRole;
    }
}
