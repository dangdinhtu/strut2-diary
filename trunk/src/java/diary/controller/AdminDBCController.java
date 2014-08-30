/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DiaryBookContentBO;
import diary.common.Message;
import diary.dao.DiaryBookContentDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDBCController extends ActionSupport{
    private List<DiaryBookContentBO> dbcBO;
    private DiaryBookContentBO dbc;
    DiaryBookContentDAO dbcDAO = new DiaryBookContentDAO();
    private List<DiaryBookContentBO> listDBC;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer dbcId =  dbc.getDbcId();
            boolean flag = dbcDAO.saveOrUpdate( dbcId , dbc);
            if(dbcId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công" , "success");
            else if(dbcId != 0 || dbcId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            dbc = dbcDAO.get(DiaryBookContentBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            DiaryBookContentBO dbcBO = dbcDAO.get(DiaryBookContentBO.class, id);
            boolean check = dbcDAO.delete(dbcBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDBCController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDBCController");
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDBC = dbcDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public List<DiaryBookContentBO> getDbcBO() {
        return dbcBO;
    }

    public void setDbcBO(List<DiaryBookContentBO> dbcBO) {
        this.dbcBO = dbcBO;
    }

    public DiaryBookContentBO getDbc() {
        return dbc;
    }

    public void setDbc(DiaryBookContentBO dbc) {
        this.dbc = dbc;
    }

    public DiaryBookContentDAO getDbcDAO() {
        return dbcDAO;
    }

    public void setDbcDAO(DiaryBookContentDAO dbcDAO) {
        this.dbcDAO = dbcDAO;
    }

    public List<DiaryBookContentBO> getListDBC() {
        return listDBC;
    }

    public void setListDBC(List<DiaryBookContentBO> listDBC) {
        this.listDBC = listDBC;
    }

  
     
     
}
