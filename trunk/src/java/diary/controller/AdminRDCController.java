/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.ResultsDivinationCouplesBO;
import diary.common.Message;
import diary.dao.ResultsDivinationCouplesDAO;
import diary.dao.RoleDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminRDCController extends ActionSupport {
    private ResultsDivinationCouplesBO resultsDivinationCouples;
    ResultsDivinationCouplesDAO resultsDivinationCouplesDAO = new ResultsDivinationCouplesDAO();
    private List<ResultsDivinationCouplesBO> listResultsDivinationCouples;
    
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
        checkAdd = roleDAO.checkRole(username, 2, 7);
        checkEdit = roleDAO.checkRole(username, 3, 7);
        checkDel = roleDAO.checkRole(username, 4, 7);
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
            Integer resultsDivinationCouplesId =  resultsDivinationCouples.getRdcId();
            boolean flag = resultsDivinationCouplesDAO.saveOrUpdate(resultsDivinationCouplesId, resultsDivinationCouples);
            if(resultsDivinationCouplesId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if(resultsDivinationCouplesId != 0 || resultsDivinationCouplesId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            if (checkAdd == "") {
                return INPUT;
            }
        }else if("form-edit".equals(action)){
            if (checkEdit == "") {
            Integer id = Integer.parseInt(req.getParameter("id"));
            resultsDivinationCouples = resultsDivinationCouplesDAO.get(ResultsDivinationCouplesBO.class, id);
            return INPUT;
            }
        }else if("delete".equals(action)){
             if (checkDel == "") {
            Integer id = Integer.parseInt(req.getParameter("id"));
            ResultsDivinationCouplesBO resultsDivinationCouplesBO = resultsDivinationCouplesDAO.get(ResultsDivinationCouplesBO.class, id);
            boolean check = resultsDivinationCouplesDAO.delete(resultsDivinationCouplesBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminRDCController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminRDCController");
        }
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listResultsDivinationCouples = resultsDivinationCouplesDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
        
     }

    public ResultsDivinationCouplesBO getResultsDivinationCouples() {
        return resultsDivinationCouples;
    }

    public void setResultsDivinationCouples(ResultsDivinationCouplesBO resultsDivinationCouples) {
        this.resultsDivinationCouples = resultsDivinationCouples;
    }

    public ResultsDivinationCouplesDAO getResultsDivinationCouplesDAO() {
        return resultsDivinationCouplesDAO;
    }

    public void setResultsDivinationCouplesDAO(ResultsDivinationCouplesDAO resultsDivinationCouplesDAO) {
        this.resultsDivinationCouplesDAO = resultsDivinationCouplesDAO;
    }

    public List<ResultsDivinationCouplesBO> getListResultsDivinationCouples() {
        return listResultsDivinationCouples;
    }

    public void setListResultsDivinationCouples(List<ResultsDivinationCouplesBO> listResultsDivinationCouples) {
        this.listResultsDivinationCouples = listResultsDivinationCouples;
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