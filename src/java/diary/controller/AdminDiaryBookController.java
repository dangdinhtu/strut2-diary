/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DiaryBookBO;
import diary.common.Message;
import diary.dao.DiaryBookDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDiaryBookController extends ActionSupport{
    private DiaryBookBO diaryBookBO;
    DiaryBookDAO diaryBookDAO = new DiaryBookDAO();
    private List<DiaryBookBO> listDiaryBook;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer diaryBookId =  diaryBookBO.getDbkId();
            boolean flag = diaryBookDAO.saveOrUpdate( diaryBookId , diaryBookBO);
            if(diaryBookId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công" , "success");
            else if(diaryBookId != 0 || diaryBookId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            diaryBookBO = diaryBookDAO.get(DiaryBookBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            DiaryBookBO diaryBookBO = diaryBookDAO.get(DiaryBookBO.class, id);
            boolean check = diaryBookDAO.delete(diaryBookBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDiaryBookController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDiaryBookController");
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDiaryBook = diaryBookDAO.getList();
         System.out.println(listDiaryBook.get(0).getName());
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public DiaryBookBO getDiaryBook() {
        return diaryBookBO;
    }

    public void setDiaryBook(DiaryBookBO diaryBook) {
        this.diaryBookBO = diaryBook;
    }

    public DiaryBookDAO getDiaryBookDAO() {
        return diaryBookDAO;
    }

    public void setDiaryBookDAO(DiaryBookDAO diaryBookDAO) {
        this.diaryBookDAO = diaryBookDAO;
    }

    public List<DiaryBookBO> getListDiaryBook() {
        return listDiaryBook;
    }

    public void setListDiaryBook(List<DiaryBookBO> listDiaryBook) {
        this.listDiaryBook = listDiaryBook;
    }

}
