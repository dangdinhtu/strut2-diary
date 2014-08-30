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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminRDCController extends ActionSupport {
    private ResultsDivinationCouplesBO resultsDivinationCouples;
    ResultsDivinationCouplesDAO resultsDivinationCouplesDAO = new ResultsDivinationCouplesDAO();
    private List<ResultsDivinationCouplesBO> listResultsDivinationCouples;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
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
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            resultsDivinationCouples = resultsDivinationCouplesDAO.get(ResultsDivinationCouplesBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            ResultsDivinationCouplesBO resultsDivinationCouplesBO = resultsDivinationCouplesDAO.get(ResultsDivinationCouplesBO.class, id);
            boolean check = resultsDivinationCouplesDAO.delete(resultsDivinationCouplesBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminRDCController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminRDCController");
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
     
}