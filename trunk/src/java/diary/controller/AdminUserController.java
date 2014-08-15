/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.UserBO;
import diary.common.Message;
import diary.dao.UserDAO;
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
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        if ("addOrUpdate".equals(action)) {
            Integer userId =  user.getUserId();
            boolean flag = userDAO.saveOrUpdate(userId, user);
            if(userId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if( userId == null && !flag)
                result = Message.getMessage("Thêm mới bản ghi thất bại", "error");
            else if(userId != 0 || userId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        } else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            user = userDAO.get(UserBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            UserBO userBO = userDAO.get(UserBO.class, id);
            boolean check = userDAO.delete(userBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminUserController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminUserController");
        }
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

    public UserBO getUser() {
        return user;
    }

    public void setUser(UserBO user) {
        this.user = user;
    }
}
