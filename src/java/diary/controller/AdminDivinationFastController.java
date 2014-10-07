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
    
    
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
        Integer id = null;
        divinationFastBO = new DivinationFastBO();
         listOfResult = new ArrayList<ResultsDivinationFastBO>();
        if(!"".equals(req.getParameter("divinationFastBO.dfnId"))){
             id = Integer.parseInt(req.getParameter("divinationFastBO.dfnId"));
        }
        divinationFastBO.setName(req.getParameter("divinationFastBO.name"));
        divinationFastBO.setDescript(req.getParameter("divinationFastBO.descript"));
        System.out.println("length = "+ req.getParameter("listOfResult.answer").length());
        ResultsDivinationFastBO arrAnswer[] = new ResultsDivinationFastBO[req.getParameter("listOfResult.answer").length()];
         
            for (int i = 0; i < arrAnswer.length; i++) {
                resultsBO = new ResultsDivinationFastBO();
                System.out.println("tra loi = "+req.getParameter("listOfResult.answer"));
                resultsBO.setAnswer(req.getParameter("listOfResult.answer"));
                resultsBO.setImages(req.getParameter("listOfResult.answer"));
                resultsBO.setResult(req.getParameter("listOfResult.images"));
                listOfResult.add(resultsBO);
                
            }
            divinationFastBO.setListOfResult(listOfResult);
            
            boolean checkDel = true;
            boolean checkInsert = true;
            int lastId = divinationFastDAO.saveOrUpdateDivinationFast(id, divinationFastBO);
            Object[] arrId = {lastId};
            if(!"".equals(req.getParameter("divinationFastBO.dfnId"))){
                checkDel = resultsDAO.multiDelete(arrId, ResultsDivinationFastBO.class, "dfnId");
            }
            if(listOfResult.size() > 0){
                for (int i = 0; i < listOfResult.size(); i++) {
                    resultsBO = new ResultsDivinationFastBO();
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
                boolean check = divinationFastDAO.multiDelete(arrId, DivinationFastBO.class, "dfnId");
                if (check) {
                    result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDivinationFastController");
                } else {
                    result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDivinationFastController");
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = Message.getMessage("Xóa bản ghi thất bại", "error");
            }
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDivinationFast = divinationFastDAO.getList();
        listOfResult = divinationFastDAO.getListResult(divinationFastBO);
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public DivinationFastBO getDivinationFastBO() {
        return divinationFastBO;
    }

    public void setDivinationFastBO(DivinationFastBO divinationFastBO) {
        this.divinationFastBO = divinationFastBO;
    }

    public List<DivinationFastBO> getListDivinationFast() {
        return listDivinationFast;
    }

    public void setListDivinationFast(List<DivinationFastBO> listDivinationFast) {
        this.listDivinationFast = listDivinationFast;
    }

    public ResultsDivinationFastBO getResultsBO() {
        return resultsBO;
    }

    public void setResultsBO(ResultsDivinationFastBO resultsBO) {
        this.resultsBO = resultsBO;
    }

    public List<ResultsDivinationFastBO> getListOfResult() {
        return listOfResult;
    }

    public void setListOfResult(List<ResultsDivinationFastBO> listOfResult) {
        this.listOfResult = listOfResult;
    }
    
}