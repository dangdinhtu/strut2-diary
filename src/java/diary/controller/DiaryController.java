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
import diary.common.Constans;
import diary.common.Message;
import diary.dao.CategoryDAO;
import diary.dao.DiaryBookDAO;
import java.io.File;
import java.util.ArrayList;
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
public class DiaryController extends ActionSupport implements ServletRequestAware {
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
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
            //lstDiaryBook = diaryBookDAO.getDiaryBookByUser(userId);
            
            return "reviewDiary";
        }else if("save".equals(action)){
            return "reviewDiary";
        }
        return SUCCESS;
    }
    private List<CategoryBO> lstCategory;
    private List<File> fileUpload = new ArrayList<File>();
    private List<String> fileUploadContentType = new ArrayList<String>();
    private List<String> fileUploadFileName = new ArrayList<String>();
    private DiaryBookBO diaryBookBO;
    private List<BeanDiaryBook> lstDiaryBook;

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

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
