/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.CategoryBO;
import diary.bo.DiaryBookBO;
import diary.common.Constans;
import diary.dao.CategoryDAO;
import java.io.File;
import java.util.ArrayList;
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

    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");
        if ("create-diary".equals(action)) {
            CategoryDAO categoryDAO = new CategoryDAO();
            lstCategory = categoryDAO.getList();
            return Constans.DIARY_CREATE;
        } else if ("write-diary".equals(action)) {
            return Constans.DIARY_WRITE;
        } else if ("signin-diary".equals(action)) {
            HttpSession session = req.getSession();
            String filePath = session.getServletContext().getRealPath("/").concat("userimages");
//            File fileToCreate = new File(filePath, this.fileUploadFileName/);
//            FileUtils.copyFile(this.coverPhoto, fileToCreate);//copying image in the new file  
            for (int i = 0; i < fileUpload.size(); i++) {
                File fileToCreate = new File(filePath, fileUploadFileName.get(i));
                FileUtils.copyFile(this.fileUpload.get(i), fileToCreate);//copying image in the new file  
            }
        }
        return SUCCESS;
    }
    private List<CategoryBO> lstCategory;
    private List<File> fileUpload = new ArrayList<File>();
    private List<String> fileUploadContentType = new ArrayList<String>();
    private List<String> fileUploadFileName = new ArrayList<String>();
    private DiaryBookBO diaryBookBO;

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
