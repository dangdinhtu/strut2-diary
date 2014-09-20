/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.UserBO;
import diary.common.Common;
import diary.common.Message;
import diary.dao.RoleDAO;
import diary.dao.UserDAO;
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

    private List<UserBO> listUser;
    private UserBO user;
    UserDAO userDAO = new UserDAO();
    RoleDAO roleDAO = new RoleDAO();
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");
        
        String result = "";
        if ("addOrUpdate".equals(action)) {
            Integer userId = null;
            user = new UserBO();
            if (!"".equals(req.getParameter("userId"))) {
                userId = Integer.parseInt(req.getParameter("userId"));
            }
            if("1".equals(req.getParameter("active")))
                user.setActive(true);
            else
                user.setActive(false);
            
            if("1".equals(req.getParameter("gender")))
                user.setGender(true);
            else
                user.setGender(false);
            user.setAddress(req.getParameter("address"));
            user.setBirthday(Date.valueOf(req.getParameter("birthday")));
            user.setEmail(req.getParameter("email"));
            user.setName(req.getParameter("name"));
            user.setPhone(req.getParameter("phone"));
            user.setUsername(req.getParameter("username"));
            user.setPassword("123456");
            user.setUserId(userId);
            // check duplicate username and email
            List<UserBO> lstUser = userDAO.findByProperty(UserBO.class, "username", user.getUsername(), "");
            List<UserBO> lstByEmail = userDAO.findByProperty(UserBO.class, "email", user.getEmail(), "");
            String url = "AdminUserController?action=add";
            int size = 0;
            if(userId != null){
                url = "AdminUserController?action=form-edit";
                size = 1;
            }
            if (lstUser.size() > size || lstByEmail.size() > size) {
                
                if(userId != null)
                    //url = "AdminUserController?action=form-edit";
                result = Message.getMessage("Email hoặc username đã tồn tại", "error", url);
            } else {
                Boolean flag = userDAO.saveOrUpdate(userId, user);
                if (userId == null && flag) {
                    result = Message.getMessage("Thêm mới bản ghi thành công", "success", "AdminUserController");
                } else if (userId != null && flag) {
                    result = Message.getMessage("Cập nhật bản ghi thành công", "success", "AdminUserController");
                } else {
                    result = Message.getMessage("Cập nhật bản ghi thất bại", "error", "AdminUserController");
                }
            }
        } else if ("add".equals(action)) {
            req.setAttribute("lstRole", roleDAO.getListBySql());
            return INPUT;
        } else if ("form-edit".equals(action)) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            user = userDAO.get(UserBO.class, id);
            req.setAttribute("user", user);
            req.setAttribute("lstRole", roleDAO.getListBySql());
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
        } else {
            String keyword = req.getParameter("keyword");
            keyword = keyword == null ? "" : keyword;
            listUser = userDAO.getList("UserBO", "username", "email", keyword, "userId");
            req.setAttribute("keyword", keyword);
        }
        req.setAttribute("result", result);
        return SUCCESS;
    }

    public List<UserBO> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserBO> listUser) {
        this.listUser = listUser;
    }
}
