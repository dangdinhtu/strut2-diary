/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.UserBO;
import diary.dao.UserDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminStartController extends ActionSupport{
    
    private UserBO userBO;
    UserDAO userDAO = new UserDAO();
    private List<UserBO> listUser;
    
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        
        listUser = userDAO.getList("UserBO", "username", username, "userId");
        for (int i = 0; i < listUser.size(); i++) {
            userBO = listUser.get(i);
        }
        return SUCCESS;
    }

    public UserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(UserBO userBO) {
        this.userBO = userBO;
    }
    
    
}
