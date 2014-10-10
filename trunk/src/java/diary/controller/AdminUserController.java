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
import javax.servlet.http.HttpSession;
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
    private String checkAdd = "";
    private String checkEdit = "";
    private String checkDel = "";
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
        String result = "";

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        checkAdd = roleDAO.checkRole(username, 2, 3);
        checkEdit = roleDAO.checkRole(username, 3, 3);
        checkDel = roleDAO.checkRole(username, 4, 3);
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
        if ("addOrUpdate".equals(action)) {
            Integer userId = userBO.getUserId();
            Integer[] arrRoleId = userBO.getArrRoleId();

            List<UserBO> lstUser = userDAO.getList("UserBO", "username", userBO.getUsername(), "userId");
            List<UserBO> lstByEmail = userDAO.getList("UserBO", "email", userBO.getEmail(), "userId");

            int size = 0;
            if (userId != null) {
                size = 1;
            }

            if (lstUser.size() > size || lstByEmail.size() > size) {
                result = Message.getMessage("Email hoặc username đã tồn tại", "error");
                req.setAttribute("result", result);
                listRole = roleDAO.getListBySql();
                Integer id = Integer.parseInt(req.getParameter("id"));
                userBO = userDAO.get(UserBO.class, id);
                listUserRole = userRoleDAO.getList("UserRoleBO", "userId", id, "ureId");
                return INPUT;
            } else {
                if (size == 0) {
                    userBO.setPassword("123456");
                }
                Integer id = userDAO.saveOrUpdateUser(userId, userBO);

                if (userBO.getArrRoleId() != null) {
                    for (int i = 0; i < arrRoleId.length; i++) {
                        UserRoleBO userRoleBO = new UserRoleBO();
                        userRoleBO.setRoleId(arrRoleId[i]);
                        userRoleBO.setStatus(true);
                        userRoleBO.setUserId(id);
                        userRoleDAO.save(userRoleBO);
                    }
                }
                if (userId == null && id != null) {
                    result = Message.getMessage("Thêm mới bản ghi thành công", "success", "AdminUserController");
                } else if (userId != null && id != null) {
                    result = Message.getMessage("Cập nhật bản ghi thành công", "success", "AdminUserController");
                } else {
                    result = Message.getMessage("Cập nhật bản ghi thất bại", "error", "AdminUserController");
                }
            }
        } else if ("add".equals(action)) {
            if (checkAdd == "") {
                listRole = roleDAO.getListBySql();
                userBO = new UserBO();
                return INPUT;
            }
        } else if ("form-edit".equals(action)) {
            if (checkEdit == "") {
                listRole = roleDAO.getListBySql();
                Integer id = Integer.parseInt(req.getParameter("id"));
                userBO = userDAO.get(UserBO.class, id);
                listUserRole = userRoleDAO.getList("UserRoleBO", "userId", id, "ureId");
                return INPUT;
            }
        } else if ("delete".equals(action)) {
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
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listUser = userDAO.getList();
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

    public List<UserRoleBO> getListUserRole() {
        return listUserRole;
    }

    public void setListUserRole(List<UserRoleBO> listUserRole) {
        this.listUserRole = listUserRole;
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
