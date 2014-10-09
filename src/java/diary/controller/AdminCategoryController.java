/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.NONE;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.CategoryBO;
import diary.bo.UserBO;
import diary.common.Message;
import diary.dao.CategoryDAO;
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
public class AdminCategoryController extends ActionSupport {

    private List<CategoryBO> categoryBO;
    private CategoryBO category;
    CategoryDAO categoryDAO = new CategoryDAO();
    private List<CategoryBO> listCategory;
    RoleDAO roleDAO = new RoleDAO();
    private String checkAdd = "";
    private String checkEdit = "";
    private String checkDel = "";

    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");
        String result = "";
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        checkAdd = roleDAO.checkRole(username, 2, 3);
        checkEdit = roleDAO.checkRole(username, 3, 3);
        checkDel = roleDAO.checkRole(username, 4, 3);

        if ("addOrUpdate".equals(action)) {
            Integer categoryId = category.getCategoryId();
            boolean flag = categoryDAO.saveOrUpdate(categoryId, category);
            if (categoryId == null && flag) {
                result = Message.getMessage("Thêm mới bản ghi thành công", "success", "AdminCategoryController");
            } else if (categoryId != 0 || categoryId != null && flag) {
                result = Message.getMessage("Cập nhật bản ghi thành công", "success", "AdminCategoryController");
            } else {
                result = Message.getMessage("Cập nhật bản ghi thất bại", "error", "AdminCategoryController");
            }

        } else if ("add".equals(action)) {
            if (checkAdd == "") {
                return INPUT;
            }
        } else if ("form-edit".equals(action)) {
            if (checkEdit == "") {
                Integer id = Integer.parseInt(req.getParameter("id"));
                category = categoryDAO.get(CategoryBO.class, id);
                return INPUT;
            }
        } else if ("delete".equals(action)) {
            if (checkDel == "") {
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
                    boolean check = categoryDAO.multiDelete(arrId, CategoryBO.class, "categoryId");
                    if (check) {
                        result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminCategoryController");
                    } else {
                        result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminCategoryController");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminCategoryController");
                }
            }

        }


        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listCategory = categoryDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;



    }

    public List<CategoryBO> getCategoryBO() {
        return categoryBO;
    }

    public void setCategoryBO(List<CategoryBO> categoryBO) {
        this.categoryBO = categoryBO;
    }

    public CategoryBO getCategory() {
        return category;
    }

    public void setCategory(CategoryBO category) {
        this.category = category;
    }

    public List<CategoryBO> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<CategoryBO> listCategory) {
        this.listCategory = listCategory;
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
