/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationFastBO;
import diary.bo.DivinationLongBO;
import diary.dao.DivinationFastDAO;
import diary.dao.DivinationLongDAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DinhTu
 */
public class QuizController extends ActionSupport{
    private DivinationFastBO diFastBO;
    DivinationFastDAO diFastDAO = new DivinationFastDAO();
    private List<DivinationFastBO> listOfDiFast;
    
    private DivinationLongBO diLongBO;
    DivinationLongDAO diLongDAO = new DivinationLongDAO();
    private List<DivinationLongBO> listOfDiLong;
    
    private String viewPageFast = "";
    private String viewPageLong = "";
    private int startFast = 0;
    private int startLong = 0;
    
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");  
        
        QuizController quizController = new QuizController();
        quizController.loadDiFast();
        quizController.loadDiLong();
        return SUCCESS;
    }
    
    public void loadDiFast() {
        listOfDiFast = diFastDAO.getList("DIVINATION_FAST", "DFN_ID", startFast, 4);
        List<DivinationFastBO> list = new ArrayList<DivinationFastBO>();
        list = diFastDAO.getList();
        viewPageFast = loadPage(list.size());
    }

    public void loadDiLong(){
        listOfDiLong = diLongDAO.getList("DIVINATION_LONG", "DLG_ID", startLong, 4);
        List<DivinationFastBO> list = new ArrayList<DivinationFastBO>();
        list = diLongDAO.getList();
        viewPageLong = loadPage(list.size());
    }
    
    public String loadPage(int record){
        int start = 0;
        int display = 4;
        int page = record/display + 1;
        int end = start + display;
        int current = (start/display)+1;
        
        String viewPage = "Trang  " + current + "/" + page;
        
        return viewPage;
    }

    public int getStartFast() {
        return startFast;
    }

    public void setStartFast(int startFast) {
        this.startFast = startFast;
    }

    public int getStartLong() {
        return startLong;
    }

    public void setStartLong(int startLong) {
        this.startLong = startLong;
    }

    public DivinationFastBO getDiFastBO() {
        return diFastBO;
    }

    public void setDiFastBO(DivinationFastBO diFastBO) {
        this.diFastBO = diFastBO;
    }

    public List<DivinationFastBO> getListOfDiFast() {
        return listOfDiFast;
    }

    public void setListOfDiFast(List<DivinationFastBO> listOfDiFast) {
        this.listOfDiFast = listOfDiFast;
    }

    public DivinationLongBO getDiLongBO() {
        return diLongBO;
    }

    public void setDiLongBO(DivinationLongBO diLongBO) {
        this.diLongBO = diLongBO;
    }

    public List<DivinationLongBO> getListOfDiLong() {
        return listOfDiLong;
    }

    public void setListOfDiLong(List<DivinationLongBO> listOfDiLong) {
        this.listOfDiLong = listOfDiLong;
    }

    public String getViewPageFast() {
        return viewPageFast;
    }

    public void setViewPageFast(String viewPageFast) {
        this.viewPageFast = viewPageFast;
    }

    public String getViewPageLong() {
        return viewPageLong;
    }

    public void setViewPageLong(String viewPageLong) {
        this.viewPageLong = viewPageLong;
    }

    
    
}
