/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.ViewDiaryBookBO;
import diary.common.Message;
import diary.dao.RoleDAO;
import diary.dao.ViewDiaryBookDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDiaryBookController extends ActionSupport{
    private ViewDiaryBookBO diaryBookBO;
    ViewDiaryBookDAO diaryBookDAO = new ViewDiaryBookDAO();
    private List<ViewDiaryBookBO> listDiaryBook;
    
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
         listDiaryBook = diaryBookDAO.getList();
         return SUCCESS;
     
     }

    public ViewDiaryBookBO getDiaryBookBO() {
        return diaryBookBO;
    }

    public void setDiaryBookBO(ViewDiaryBookBO diaryBookBO) {
        this.diaryBookBO = diaryBookBO;
    }

    public ViewDiaryBookDAO getDiaryBookDAO() {
        return diaryBookDAO;
    }

    public void setDiaryBookDAO(ViewDiaryBookDAO diaryBookDAO) {
        this.diaryBookDAO = diaryBookDAO;
    }

    public List<ViewDiaryBookBO> getListDiaryBook() {
        return listDiaryBook;
    }

    public void setListDiaryBook(List<ViewDiaryBookBO> listDiaryBook) {
        this.listDiaryBook = listDiaryBook;
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

    public String getCheckCouple() {
        return checkCouple;
    }

    public void setCheckCouple(String checkCouple) {
        this.checkCouple = checkCouple;
    }

    public String getCheckZodiac() {
        return checkZodiac;
    }

    public void setCheckZodiac(String checkZodiac) {
        this.checkZodiac = checkZodiac;
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
