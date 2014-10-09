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
