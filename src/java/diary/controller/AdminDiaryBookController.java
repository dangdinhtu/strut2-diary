/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.ViewDiaryBookBO;
import diary.common.Message;
import diary.dao.ViewDiaryBookDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDiaryBookController extends ActionSupport{
    private ViewDiaryBookBO diaryBookBO;
    ViewDiaryBookDAO diaryBookDAO = new ViewDiaryBookDAO();
    private List<ViewDiaryBookBO> listDiaryBook;
     public String execute() throws Exception {
         listDiaryBook = diaryBookDAO.getList();
         return SUCCESS;
     
     }

    public ViewDiaryBookBO getDiaryBookBO() {
        return diaryBookBO;
    }

    public void setDiaryBookBO(ViewDiaryBookBO diaryBookBO) {
        this.diaryBookBO = diaryBookBO;
    }

    public ViewDiaryBookDAO getDiaryBookDAO() {
        return diaryBookDAO;
    }

    public void setDiaryBookDAO(ViewDiaryBookDAO diaryBookDAO) {
        this.diaryBookDAO = diaryBookDAO;
    }

    public List<ViewDiaryBookBO> getListDiaryBook() {
        return listDiaryBook;
    }

    public void setListDiaryBook(List<ViewDiaryBookBO> listDiaryBook) {
        this.listDiaryBook = listDiaryBook;
    }


}
