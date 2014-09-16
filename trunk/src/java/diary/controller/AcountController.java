/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.UserBO;
import diary.common.Common;
import diary.common.Message;
import diary.dao.UserDAO;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author DinhTu
 */
public class AcountController extends ActionSupport {
    private UserBO user = new UserBO();
    private final String SIGN_IN = "sign_in";
    HttpServletRequest req = ServletActionContext.getRequest();
    UserDAO userDAO = new UserDAO();

    public String execute() throws Exception {

        AcountController acountController = new AcountController();
        String action = req.getParameter("action");
        if ("sign_in".equals(action)) {
            acountController.singIn();
            //return SIGN_IN;
        } else if ("login".equals(action)) {
            acountController.login();
            //return "login";
        }else if("logout".equals(action)){
            acountController.logout();
        }
        return SIGN_IN;
    }

    public void singIn() {
        String result = "";
        boolean flag = true;
        boolean checkExist = true;
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String actionName = req.getParameter("url");
        boolean gender = Boolean.valueOf(req.getParameter("gender"));
        java.util.Date birthday = Common.convertStringToDate(req.getParameter("birthday"));
        try {
            List<UserBO> lstUser = userDAO.findByProperty(UserBO.class, "username", username, "");
            List<UserBO> lstByEmail = userDAO.findByProperty(UserBO.class, "email", email, "");
            if (lstUser.size() > 0 || lstByEmail.size() > 0) {
                result = Message.getMessage("Email hoặc username đã tồn tại", "error", actionName);
                checkExist = false;
            } else {
                user.setActive(true);
                user.setAddress(address);
                user.setBirthday(birthday);
                user.setEmail(email);
                user.setGender(gender);
                user.setName(name);
                user.setPassword(password);
                user.setUsername(username);
                user.setPhone(phone);
                userDAO.save(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        if (flag && checkExist) {
            result = Message.getMessage("Đăng kí tài khoản thành công", "success", actionName);
        } else if (!flag) {
            result = Message.getMessage("Đăng kí tài khoản thất bại", "error", actionName);
        }
        req.setAttribute("result", result);
    }

    public void login() {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserBO userBO = userDAO.checkLogin(username, password);
        String result = "";
        String actionName = req.getParameter("url");
        if (userBO != null) {
            HttpSession session = req.getSession();
            //String contextPath = req.getContextPath();
            session.setAttribute("userName", userBO.getUsername());
            result = Message.getMessage("Đăng nhập thành công", "success", actionName);
        } else {
            result = Message.getMessage("Mật khẩu hoặc Tên đăng nhập chưa chính xác", "error", actionName);
        }
        req.setAttribute("result", result);
    }

    public void forgetPassword() {
    }

    public void logout() {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
    
}
