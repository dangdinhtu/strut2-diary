/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationCategoryBO;
import diary.common.Message;
import diary.dao.DivinationCategoryDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDCYController extends ActionSupport {
    
    private List<DivinationCategoryBO> dcyBO;
    private DivinationCategoryBO dcy;
    DivinationCategoryDAO dcyDAO = new DivinationCategoryDAO();
    private List<DivinationCategoryBO> listDCY;
    
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer dcyId =  dcy.getDcyId();
            boolean flag = dcyDAO.saveOrUpdate( dcyId , dcy);
            if(dcyId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công" , "success");
            else if(dcyId != 0 || dcyId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            dcy = dcyDAO.get(DivinationCategoryBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            DivinationCategoryBO dcyBO = dcyDAO.get(DivinationCategoryBO.class, id);
            boolean check = dcyDAO.delete(dcyBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDCYController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDCYController");
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDCY = dcyDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
    }

    public List<DivinationCategoryBO> getDcyBO() {
        return dcyBO;
    }

    public void setDcyBO(List<DivinationCategoryBO> dcyBO) {
        this.dcyBO = dcyBO;
    }

    public DivinationCategoryBO getDcy() {
        return dcy;
    }

    public void setDcy(DivinationCategoryBO dcy) {
        this.dcy = dcy;
    }

    public DivinationCategoryDAO getDcyDAO() {
        return dcyDAO;
    }

    public void setDcyDAO(DivinationCategoryDAO dcyDAO) {
        this.dcyDAO = dcyDAO;
    }

    public List<DivinationCategoryBO> getListDCY() {
        return listDCY;
    }

    public void setListDCY(List<DivinationCategoryBO> listDCY) {
        this.listDCY = listDCY;
    }
    
    
}