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
import diary.dao.RoleDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminResourceController extends ActionSupport {

    private ResourceBO resource;
    ResourceDAO resourceDAO = new ResourceDAO();
    private List<ResourceBO> listResource;
    RoleDAO roleDAO = new RoleDAO();
    private String checkAdd = "";
    private String checkEdit = "";
    private String checkDel = "";

    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");
        String result = "";
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        checkAdd = roleDAO.checkRole(username, 2, 10);
        checkEdit = roleDAO.checkRole(username, 3, 10);
        checkDel = roleDAO.checkRole(username, 4, 10);

        if ("addOrUpdate".equals(action)) {
            String resourceKey = resource.getResourceKey();
            boolean flag = resourceDAO.saveOrUpdate(resourceKey, resource);
            if (resourceKey == null && flag) {
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            } else if (resourceKey != null && flag) {
                result = Message.getMessage("Cập nhật bản ghi thành công", "success");
            } else {
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error");
            }

        } else if ("add".equals(action)) {
            if (checkAdd == "") {
                return INPUT;
            }
        } else if ("form-edit".equals(action)) {
            if (checkEdit == "") {
                String id = (String) req.getParameter("id");
                resource = resourceDAO.get(ResourceBO.class, id);
                return INPUT;
            }
        } else if ("delete".equals(action)) {
            if (checkDel == "") {
                String id = (String) req.getParameter("id");
                ResourceBO resourceBO = resourceDAO.get(ResourceBO.class, id);
                boolean check = resourceDAO.delete(resourceBO);
                if (check) {
                    result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminResourceController");
                } else {
                    result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminResourceController");
                }
            }
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

    public String getCheckAdd() {
        return checkAdd;
    }

    public void setCheckAdd(String checkAdd) {
        this.checkAdd = checkAdd;
    }

    public String getCheckEdit() {
        return checkEdit;
    }

    public void setCheckEdit(String checkEdit) {
        this.checkEdit = checkEdit;
    }

    public String getCheckDel() {
        return checkDel;
    }

    public void setCheckDel(String checkDel) {
        this.checkDel = checkDel;
    }
    
}