/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.ResourceBO;
import diary.common.Message;
import diary.dao.ResourceDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminResourceController extends ActionSupport {
    private ResourceBO resource;
    ResourceDAO resourceDAO = new ResourceDAO();
    private List<ResourceBO> listResource;
     public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");      
        String result = "";
        
        if ("addOrUpdate".equals(action)) {
            String resourceKey =  resource.getResourceKey();
            boolean flag = resourceDAO.saveOrUpdate(resourceKey, resource);
            if(resourceKey == null && flag)
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            else if(resourceKey != null && flag)
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            else
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            
        }else if ("add".equals(action)) {
            return INPUT;
        }else if("form-edit".equals(action)){
            String id = (String)req.getParameter("id");
            resource = resourceDAO.get(ResourceBO.class, id);
            return INPUT;
        }else if("delete_all".equals(action)){
        
        }else if("delete".equals(action)){
            String id = (String)req.getParameter("id");
            ResourceBO resourceBO = resourceDAO.get(ResourceBO.class, id);
            boolean check = resourceDAO.delete(resourceBO);
            if(check)
                result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminResourceController");
            else
                result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminResourceController");
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listResource = resourceDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;
     
     }

    public ResourceBO getResource() {
        return resource;
    }

    public void setResource(ResourceBO resource) {
        this.resource = resource;
    }

    public ResourceDAO getResourceDAO() {
        return resourceDAO;
    }

    public void setResourceDAO(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    public List<ResourceBO> getListResource() {
        return listResource;
    }

    public void setListResource(List<ResourceBO> listResource) {
        this.listResource = listResource;
    }
     
}