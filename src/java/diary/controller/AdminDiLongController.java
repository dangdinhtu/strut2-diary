/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationLongBO;
import diary.common.Message;
import diary.dao.DivinationLongDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDiLongController extends ActionSupport {
    
     private List<DivinationLongBO> dlgBO;
    private DivinationLongBO dlg;
    DivinationLongDAO dlgDAO = new DivinationLongDAO();
    private List<DivinationLongBO> listDlg;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer dlgId =  dlg.getDlgId();
            boolean flag = dlgDAO.saveOrUpdate(dlgId, dlg);
            if(dlgId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if(dlgId != 0 || dlgId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            dlg = dlgDAO.get(DivinationLongBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            DivinationLongBO dlgBO = dlgDAO.get(DivinationLongBO.class, id);
            boolean check = dlgDAO.delete(dlgBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDiLongController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDiLongController");
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDlg = dlgDAO.getList();
         System.out.println(listDlg.get(0).getName());
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public List<DivinationLongBO> getDlgBO() {
        return dlgBO;
    }

    public void setDlgBO(List<DivinationLongBO> dlgBO) {
        this.dlgBO = dlgBO;
    }

    public DivinationLongBO getDlg() {
        return dlg;
    }

    public void setDlg(DivinationLongBO dlg) {
        this.dlg = dlg;
    }

    public DivinationLongDAO getDlgDAO() {
        return dlgDAO;
    }

    public void setDlgDAO(DivinationLongDAO dlgDAO) {
        this.dlgDAO = dlgDAO;
    }

    public List<DivinationLongBO> getListDlg() {
        return listDlg;
    }

    public void setListDlg(List<DivinationLongBO> listDlg) {
        this.listDlg = listDlg;
    }
     
     
}