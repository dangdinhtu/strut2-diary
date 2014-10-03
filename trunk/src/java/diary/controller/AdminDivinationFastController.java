/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationFastBO;
import diary.bo.ResultsDivinationFastBO;
import diary.common.Message;
import diary.dao.DivinationFastDAO;
import diary.dao.ResultDivinationFastDAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDivinationFastController extends ActionSupport {
    
    private DivinationFastBO divinationFastBO;
    DivinationFastDAO divinationFastDAO = new DivinationFastDAO();
    private List<DivinationFastBO> listDivinationFast;
    
    private ResultsDivinationFastBO resultsBO;
    ResultDivinationFastDAO resultsDAO = new ResultDivinationFastDAO();
    private List<ResultsDivinationFastBO> listOfResult;
    
    private String destPath;
    
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        destPath = "C:/Users/ThuTrang/Documents/strut2-diary/uploadImage/";/* Copy file to a safe location */
        if ("addOrUpdate".equals(action)) {
            boolean checkDel = true;
            boolean checkInsert = true;
            int lastId = divinationFastDAO.saveOrUpdateDivinationFast(divinationFastBO.getDfnId(), divinationFastBO);
            Object[] arrId = {lastId};
            checkDel = resultsDAO.multiDelete(arrId, ResultsDivinationFastBO.class, "dfnId");
            if(checkDel == true)
                System.out.println("xóa đk rồi đấy");
            else
                System.out.println("có xóa đk đâu mà");
            System.out.println("kích thước của listOfResult = "+listOfResult.size());
            if(listOfResult.size() > 0){
                for (int i = 0; i < listOfResult.size(); i++) {
                    resultsBO.setDfnId(lastId);
                    resultsBO.setAnswer(listOfResult.get(i).getAnswer());
                    resultsBO.setImages(listOfResult.get(i).getImages());
                    resultsBO.setResult(listOfResult.get(i).getResult());
                    checkInsert = resultsDAO.save(resultsBO);
                    if(checkInsert == false){
                        break;
                    }
                }
            }
            if(lastId != 0 || divinationFastBO.getDfnId() != null  && checkInsert)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            listOfResult = resultsDAO.getList(divinationFastBO);
            Integer id = Integer.parseInt(req.getParameter("id"));
            divinationFastBO = divinationFastDAO.get(DivinationFastBO.class, id);
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
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public ResultsDivinationFastBO getResultsBO() {
        return resultsBO;
    }

    public void setResultsBO(ResultsDivinationFastBO resultsBO) {
        this.resultsBO = resultsBO;
    }

    public ResultDivinationFastDAO getResultsDAO() {
        return resultsDAO;
    }

    public void setResultsDAO(ResultDivinationFastDAO resultsDAO) {
        this.resultsDAO = resultsDAO;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public DivinationFastBO getDivinationFastBO() {
        return divinationFastBO;
    }

    public void setDivinationFastBO(DivinationFastBO divinationFastBO) {
        this.divinationFastBO = divinationFastBO;
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
    
    public List<ResultsDivinationFastBO> getListOfResult() {
        return listOfResult;
    }

    public void setListOfResult(List<ResultsDivinationFastBO> listOfResult) {
        this.listOfResult = listOfResult;
    }
     

}