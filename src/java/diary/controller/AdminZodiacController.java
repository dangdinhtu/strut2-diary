/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.ZodiacBO;
import diary.common.Message;
import diary.dao.RoleDAO;
import diary.dao.ZodiacDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminZodiacController extends ActionSupport {

    private ZodiacBO zodiacBO;
    ZodiacDAO zodiacDAO = new ZodiacDAO();
    private List<ZodiacBO> listZodiac;
    RoleDAO roleDAO = new RoleDAO();
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
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");
        String result = "";
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        checkAdd = roleDAO.checkRole(username, 2, 8);
        checkEdit = roleDAO.checkRole(username, 3, 8);
        checkDel = roleDAO.checkRole(username, 4, 8);
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
            Integer zodiacId = zodiacBO.getZodiacId();
            boolean flag = zodiacDAO.saveOrUpdate(zodiacId, zodiacBO);
            if (zodiacId == null && flag) {
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            } else if (zodiacId != 0 || zodiacId != null && flag) {
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            } else {
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            }

        } else if ("add".equals(action)) {
            if (checkAdd == "") {
                return INPUT;
            }
        } else if ("form-edit".equals(action)) {
            if (checkEdit == "") {
                Integer id = Integer.parseInt(req.getParameter("id"));
                zodiacBO = zodiacDAO.get(ZodiacBO.class, id);
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
                    boolean check = zodiacDAO.multiDelete(arrId, ZodiacBO.class, "zodiacId");
                    if (check) {
                        result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminZodiacController");
                    } else {
                        result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminZodiacController");
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
        listZodiac = zodiacDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;

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

    public ZodiacBO getZodiacBO() {
        return zodiacBO;
    }

    public void setZodiacBO(ZodiacBO zodiacBO) {
        this.zodiacBO = zodiacBO;
    }
    public List<ZodiacBO> getListZodiac() {
        return listZodiac;
    }

    public void setListZodiac(List<ZodiacBO> listZodiac) {
        this.listZodiac = listZodiac;
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
    
    
}
