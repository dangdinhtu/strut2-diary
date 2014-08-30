/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationFastBO;
import diary.common.Message;
import diary.dao.DivinationFastDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDivinationFastController extends ActionSupport {
    
    private List<DivinationFastBO> divinationFastBO;
    private DivinationFastBO divinationFast;
    DivinationFastDAO divinationFastDAO = new DivinationFastDAO();
    private List<DivinationFastBO> listDivinationFast;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer divinationFastId =  divinationFast.getDfnId();
            boolean flag = divinationFastDAO.saveOrUpdate(divinationFastId, divinationFast);
            if(divinationFastId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if(divinationFastId != 0 || divinationFastId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            divinationFast = divinationFastDAO.get(DivinationFastBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            DivinationFastBO divinationFastBO = divinationFastDAO.get(DivinationFastBO.class, id);
            boolean check = divinationFastDAO.delete(divinationFastBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDivinationFastController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDivinationFastController");
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDivinationFast = divinationFastDAO.getList();
         System.out.println(listDivinationFast.get(0).getName());
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public List<DivinationFastBO> getDivinationFastBO() {
        return divinationFastBO;
    }

    public void setDivinationFastBO(List<DivinationFastBO> divinationFastBO) {
        this.divinationFastBO = divinationFastBO;
    }

    public DivinationFastBO getDivinationFast() {
        return divinationFast;
    }

    public void setDivinationFast(DivinationFastBO divinationFast) {
        this.divinationFast = divinationFast;
    }

    public DivinationFastDAO getDivinationFastDAO() {
        return divinationFastDAO;
    }

    public void setDivinationFastDAO(DivinationFastDAO divinationFastDAO) {
        this.divinationFastDAO = divinationFastDAO;
    }

    public List<DivinationFastBO> getListDivinationFast() {
        return listDivinationFast;
    }

    public void setListDivinationFast(List<DivinationFastBO> listDivinationFast) {
        this.listDivinationFast = listDivinationFast;
    }
     

}