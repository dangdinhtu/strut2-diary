/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.UserBO;
import diary.bo.UserRoleBO;
import diary.bo.ViewUserRoleBO;
import diary.dao.RoleDAO;
import diary.dao.UserDAO;
import diary.dao.UserRoleDAO;
import java.util.ArrayList;
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
    UserRoleDAO userRoleDAO = new UserRoleDAO();
    List<ViewUserRoleBO> listUserRole;
    String avata = "";
    
    RoleDAO roleDAO = new RoleDAO();
    private String checkUser = "";
    private String checkRole = "";
    private String checkCat = "";
    private String checkDiary = "";
    private String checkDiFast = "";
    private String checkDiLong = "";
    private String checkCouple = "";
    private String checkZodiac = "";
    private String checkImage = "";
    private String checkResource = "";
    
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");
        
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        checkUser = roleDAO.checkRole(username, 1, 1);
        checkRole = roleDAO.checkRole(username, 1, 2);
        checkCat = roleDAO.checkRole(username, 1, 3);
        checkDiary = roleDAO.checkRole(username, 1, 4);
        checkDiFast = roleDAO.checkRole(username, 1, 5);
        checkDiLong = roleDAO.checkRole(username, 1, 6);
        checkCouple = roleDAO.checkRole(username, 1, 7);
        checkZodiac = roleDAO.checkRole(username, 1, 8);
        checkImage = roleDAO.checkRole(username, 1, 9);
        checkResource = roleDAO.checkRole(username, 1, 10);
        
        listUser = userDAO.getList("UserBO", "username", username, "userId");
        if(listUser.size() > 0){
            userBO = listUser.get(0);
            listUserRole = userRoleDAO.getList("ViewUserRoleBO", "userId", userBO.getUserId(), "userId");
            avata = userBO.getAvartar();
        }
        
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

    public List<ViewUserRoleBO> getListUserRole() {
        return listUserRole;
    }

    public void setListUserRole(List<ViewUserRoleBO> listUserRole) {
        this.listUserRole = listUserRole;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }

    public UserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(UserBO userBO) {
        this.userBO = userBO;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getCheckRole() {
        return checkRole;
    }

    public void setCheckRole(String checkRole) {
        this.checkRole = checkRole;
    }

    public String getCheckCat() {
        return checkCat;
    }

    public void setCheckCat(String checkCat) {
        this.checkCat = checkCat;
    }

    public String getCheckDiary() {
        return checkDiary;
    }

    public void setCheckDiary(String checkDiary) {
        this.checkDiary = checkDiary;
    }

    public String getCheckDiFast() {
        return checkDiFast;
    }

    public void setCheckDiFast(String checkDiFast) {
        this.checkDiFast = checkDiFast;
    }

    public String getCheckDiLong() {
        return checkDiLong;
    }

    public void setCheckDiLong(String checkDiLong) {
        this.checkDiLong = checkDiLong;
    }

    public String getCheckZodiac() {
        return checkZodiac;
    }

    public void setCheckZodiac(String checkZodiac) {
        this.checkZodiac = checkZodiac;
    }

    public String getCheckCouple() {
        return checkCouple;
    }

    public void setCheckCouple(String checkCouple) {
        this.checkCouple = checkCouple;
    }

    public String getCheckImage() {
        return checkImage;
    }

    public void setCheckImage(String checkImage) {
        this.checkImage = checkImage;
    }

    public String getCheckResource() {
        return checkResource;
    }

    public void setCheckResource(String checkResource) {
        this.checkResource = checkResource;
    }
    
    
}
