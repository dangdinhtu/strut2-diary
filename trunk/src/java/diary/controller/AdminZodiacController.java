/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.ZodiacBO;
import diary.common.Message;
import diary.dao.ZodiacDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminZodiacController extends ActionSupport{
    private ZodiacBO zodiacBO;
    ZodiacDAO zodiacDAO = new ZodiacDAO();
    private List<ZodiacBO> listZodiac;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            Integer zodiacId =  zodiacBO.getZodiacId();
            boolean flag = zodiacDAO.saveOrUpdate(zodiacId, zodiacBO);
            if(zodiacId == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if(zodiacId != 0 || zodiacId != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            Integer id = Integer.parseInt(req.getParameter("id"));
            zodiacBO = zodiacDAO.get(ZodiacBO.class, id);
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
                boolean check = zodiacDAO.multiDelete(arrId, ZodiacBO.class, "zodiacId");
                if(check)
                    result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminZodiacController");
                else
                    result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminZodiacController");
            } catch (Exception e) {
                e.printStackTrace();
                result = Message.getMessage("Xóa bản ghi thất bại", "error");
            }
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listZodiac = zodiacDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public ZodiacBO getZodiacBO() {
        return zodiacBO;
    }

    public void setZodiacBO(ZodiacBO zodiacBO) {
        this.zodiacBO = zodiacBO;
    }

    public ZodiacDAO getZodiacDAO() {
        return zodiacDAO;
    }

    public void setZodiacDAO(ZodiacDAO zodiacDAO) {
        this.zodiacDAO = zodiacDAO;
    }

    public List<ZodiacBO> getListZodiac() {
        return listZodiac;
    }

    public void setListZodiac(List<ZodiacBO> listZodiac) {
        this.listZodiac = listZodiac;
    }
     
     
}
