/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diarry.bean.BeanDiaryBook;
import diary.bo.CategoryBO;
import diary.bo.DiaryBookBO;
import diary.bo.DiaryBookContentBO;
import diary.common.Constans;
import diary.common.Message;
import diary.dao.CategoryDAO;
import diary.dao.DiaryBookDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author DinhTu
 */
public class DiaryController extends ActionSupport  {
    DiaryBookDAO diaryBookDAO = new DiaryBookDAO();
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");
        if ("create-diary".equals(action)) {
            CategoryDAO categoryDAO = new CategoryDAO();
            lstCategory = categoryDAO.getList();
            return Constans.DIARY_CREATE;
        } else if ("write-diary".equals(action)) {
            return "write-diary";
        }  else if ("read".equals(action)) {
            int userId = 125;
            int dbkId = 1;
            List<Object> lstDiaryBookContent = diaryBookDAO.getDiaryBookContent(userId, dbkId);
            List<BeanDiaryBook> lst = new ArrayList<BeanDiaryBook>();
            for (int i=0; i<lstDiaryBookContent.size(); i++){
                Object[] row = (Object[]) lstDiaryBookContent.get(i);
                BeanDiaryBook obj = new BeanDiaryBook();
                obj.setUserId((Integer) row[0]);
                obj.setDbkId((Integer) row[1]);
                obj.setTitle((String) row[2]);
                obj.setContent((String) row[3]);
                obj.setDateWritten((Date) row[4]);
                lst.add(obj);
            }
                  
            req.setAttribute("lstDiaryBookContent", lst);
            return "read";
        }else if ("signin-diary".equals(action)) {
            HttpSession session = req.getSession();
            String filePath = session.getServletContext().getRealPath("/").concat("userimages");
            for (int i = 0; i < fileUpload.size(); i++) {
                String contentType = fileUploadContentType.get(i);
                File fileToCreate = new File(filePath, fileUploadFileName.get(i));
                FileUtils.copyFile(this.fileUpload.get(i), fileToCreate);//copying image in the new file  
                
            }
            diaryBookBO.setCoverPhoto(fileUploadFileName.get(0));
            diaryBookBO.setBackgroundImages(fileUploadFileName.get(1));
            diaryBookBO.setAudioAutoPlay(false);
            diaryBookBO.setBackgroundAudio(fileUploadFileName.get(2));
            diaryBookBO.setDateCreate(new Date());
            DiaryBookDAO diaryBookDAO = new DiaryBookDAO();
            String result = "";
            try {
                diaryBookDAO.save(diaryBookBO);
                result = Message.getMessage("Đăng kí  thành công", "success", "diary?action=write-diary");
            } catch (Exception e) {
                result = Message.getMessage("Đăng kí  thành công", "fail");
                e.printStackTrace();
            }
            req.setAttribute("result", result);
        }else if("review-diary".equals(action)){
            // lấy các cuốn nhật kí mà người dùng đã viết
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
            if(userId != null){
                beanDiaryBook = diaryBookDAO.getDiaryBookByUser(userId);
            }
            return "reviewDiary";
        }else if("save".equals(action)){
            String result = "";
            try {
                Date date = new Date();
                bookContent.setDateWrite(date);
                
                diaryBookDAO.save(bookContent);
                result = Message.getMessage("Đăng kí tài khoản thành công", "success", "diary");
            } catch (Exception e) {
                e.printStackTrace();
                result = Message.getMessage("Đăng kí tài khoản thành công", "error");
            }
            req.setAttribute("result", result);
            //return "reviewDiary";
        }
        return SUCCESS;
    }
    private List<CategoryBO> lstCategory;
    private List<File> fileUpload = new ArrayList<File>();
    private List<String> fileUploadContentType = new ArrayList<String>();
    private List<String> fileUploadFileName = new ArrayList<String>();
    private DiaryBookBO diaryBookBO;
    private List<BeanDiaryBook> lstDiaryBook;
    private DiaryBookContentBO bookContent;
    private List<BeanDiaryBook> beanDiaryBook;

    public List<BeanDiaryBook> getBeanDiaryBook() {
        return beanDiaryBook;
    }

    public void setBeanDiaryBook(List<BeanDiaryBook> beanDiaryBook) {
        this.beanDiaryBook = beanDiaryBook;
    }
    
    public DiaryBookDAO getDiaryBookDAO() {
        return diaryBookDAO;
    }

    public void setDiaryBookDAO(DiaryBookDAO diaryBookDAO) {
        this.diaryBookDAO = diaryBookDAO;
    }

    public DiaryBookContentBO getBookContent() {
        return bookContent;
    }

    public void setBookContent(DiaryBookContentBO bookContent) {
        this.bookContent = bookContent;
    }
    
    public List<BeanDiaryBook> getLstDiaryBook() {
        return lstDiaryBook;
    }

    public void setLstDiaryBook(List<BeanDiaryBook> lstDiaryBook) {
        this.lstDiaryBook = lstDiaryBook;
    }
    
    public List<File> getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(List<File> fileUpload) {
        this.fileUpload = fileUpload;
    }

    public List<String> getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(List<String> fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public List<String> getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(List<String> fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }
    
    public DiaryBookBO getDiaryBookBO() {
        return diaryBookBO;
    }

    public void setDiaryBookBO(DiaryBookBO diaryBookBO) {
        this.diaryBookBO = diaryBookBO;
    }

    public List<CategoryBO> getLstCategory() {
        return lstCategory;
    }

    public void setLstCategory(List<CategoryBO> lstCategory) {
        this.lstCategory = lstCategory;
    }

    
}
