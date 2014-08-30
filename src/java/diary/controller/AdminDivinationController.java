/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationBO;
import diary.common.Message;
import diary.dao.DivinationDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDivinationController extends ActionSupport{
    private List<DivinationBO> divinationBO;
    private DivinationBO divination;
    DivinationDAO divinationDAO = new DivinationDAO();
    private List<DivinationBO> listDivination;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer divinationId =  divination.getDivinationId();
            boolean flag = divinationDAO.saveOrUpdate( divinationId , divination);
            if(divinationId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công" , "success");
            else if(divinationId != 0 || divinationId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            divination = divinationDAO.get(DivinationBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            DivinationBO divinationBO = divinationDAO.get(DivinationBO.class, id);
            boolean check = divinationDAO.delete(divinationBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDivinationController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDivinationController");
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDivination = divinationDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public List<DivinationBO> getDivinationBO() {
        return divinationBO;
    }

    public void setDivinationBO(List<DivinationBO> divinationBO) {
        this.divinationBO = divinationBO;
    }

    public DivinationBO getDivination() {
        return divination;
    }

    public void setDivination(DivinationBO divination) {
        this.divination = divination;
    }

    public DivinationDAO getDivinationDAO() {
        return divinationDAO;
    }

    public void setDivinationDAO(DivinationDAO divinationDAO) {
        this.divinationDAO = divinationDAO;
    }

    public List<DivinationBO> getListDivination() {
        return listDivination;
    }

    public void setListDivination(List<DivinationBO> listDivination) {
        this.listDivination = listDivination;
    }

   
     
     
}
