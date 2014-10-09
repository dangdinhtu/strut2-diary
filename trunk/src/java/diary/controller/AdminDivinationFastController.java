/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationFastBO;
import diary.bo.ResultsDivinationFastBO;
import diary.common.Message;
import diary.dao.DivinationFastDAO;
import diary.dao.ResultDivinationFastDAO;
import diary.dao.RoleDAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ThuTrang
 */
public class AdminDivinationFastController extends ActionSupport {

    private DivinationFastBO divinationFastBO;
    DivinationFastDAO divinationFastDAO = new DivinationFastDAO();
    private List<DivinationFastBO> listDivinationFast;
    private ResultsDivinationFastBO resultsBO;
    ResultDivinationFastDAO resultsDAO = new ResultDivinationFastDAO();
    private List<ResultsDivinationFastBO> listOfResult;
    RoleDAO roleDAO = new RoleDAO();
    private String checkAdd = "";
    private String checkEdit = "";
    private String checkDel = "";
    private String checkUser = "";
    private String checkRole = "";
    private String checkCat = "";
    private String checkDiary = "";
    private String checkDiFast = "";
    private String checkDiLong = "";
    private String checkCouple = "";
    private String checkZodiac = "";
    private String checkImage = "";
    private String checkResource = "";

    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        String action = req.getParameter("action");
        String result = "";
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        checkAdd = roleDAO.checkRole(username, 2, 5);
        checkEdit = roleDAO.checkRole(username, 3, 5);
        checkDel = roleDAO.checkRole(username, 4, 5);
        checkUser = roleDAO.checkRole(username, 1, 1);
        checkRole = roleDAO.checkRole(username, 1, 2);
        checkCat = roleDAO.checkRole(username, 1, 3);
        checkDiary = roleDAO.checkRole(username, 1, 4);
        checkDiFast = roleDAO.checkRole(username, 1, 5);
        checkDiLong = roleDAO.checkRole(username, 1, 6);
        checkCouple = roleDAO.checkRole(username, 1, 7);
        checkZodiac = roleDAO.checkRole(username, 1, 8);
        checkImage = roleDAO.checkRole(username, 1, 9);
        checkResource = roleDAO.checkRole(username, 1, 10);

        if ("addOrUpdate".equals(action)) {
            Integer id = null;
            divinationFastBO = new DivinationFastBO();
            listOfResult = new ArrayList<ResultsDivinationFastBO>();
            if (!"".equals(req.getParameter("divinationFastBO.dfnId"))) {
                id = Integer.parseInt(req.getParameter("divinationFastBO.dfnId"));
            }
            divinationFastBO.setName(req.getParameter("divinationFastBO.name"));
            divinationFastBO.setDescript(req.getParameter("divinationFastBO.descript"));
            System.out.println("length = " + req.getParameter("listOfResult.answer").length());
            ResultsDivinationFastBO arrAnswer[] = new ResultsDivinationFastBO[req.getParameter("listOfResult.answer").length()];

            for (int i = 0; i < arrAnswer.length; i++) {
                resultsBO = new ResultsDivinationFastBO();
                System.out.println("tra loi = " + req.getParameter("listOfResult.answer"));
                resultsBO.setAnswer(req.getParameter("listOfResult.answer"));
                resultsBO.setImages(req.getParameter("listOfResult.answer"));
                resultsBO.setResult(req.getParameter("listOfResult.images"));
                listOfResult.add(resultsBO);

            }
            divinationFastBO.setListOfResult(listOfResult);

            boolean checkDel = true;
            boolean checkInsert = true;
            int lastId = divinationFastDAO.saveOrUpdateDivinationFast(id, divinationFastBO);
            Object[] arrId = {lastId};
            if (!"".equals(req.getParameter("divinationFastBO.dfnId"))) {
                checkDel = resultsDAO.multiDelete(arrId, ResultsDivinationFastBO.class, "dfnId");
            }
            if (listOfResult.size() > 0) {
                for (int i = 0; i < listOfResult.size(); i++) {
                    resultsBO = new ResultsDivinationFastBO();
                    resultsBO.setDfnId(lastId);
                    resultsBO.setAnswer(listOfResult.get(i).getAnswer());
                    resultsBO.setImages(listOfResult.get(i).getImages());
                    resultsBO.setResult(listOfResult.get(i).getResult());
                    checkInsert = resultsDAO.save(resultsBO);
                    if (checkInsert == false) {
                        break;
                    }
                }
            }
            if (lastId != 0 || divinationFastBO.getDfnId() != null && checkInsert) {
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
                listOfResult = resultsDAO.getList(divinationFastBO);
                Integer id = Integer.parseInt(req.getParameter("id"));
                divinationFastBO = divinationFastDAO.get(DivinationFastBO.class, id);
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
                    boolean check = divinationFastDAO.multiDelete(arrId, DivinationFastBO.class, "dfnId");
                    if (check) {
                        result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDivinationFastController");
                    } else {
                        result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDivinationFastController");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result = Message.getMessage("Xóa bản ghi thất bại", "error");
                }
            }
        }
        req.setAttribute("result", result);
        String keyword = req.getParameter("keyword");
        keyword = keyword == null ? "" : keyword;
        listDivinationFast = divinationFastDAO.getList();
        listOfResult = divinationFastDAO.getListResult(divinationFastBO);
        req.setAttribute("keyword", keyword);
        return SUCCESS;

    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getCheckRole() {
        return checkRole;
    }

    public void setCheckRole(String checkRole) {
        this.checkRole = checkRole;
    }

    public String getCheckCat() {
        return checkCat;
    }

    public void setCheckCat(String checkCat) {
        this.checkCat = checkCat;
    }

    public String getCheckDiary() {
        return checkDiary;
    }

    public void setCheckDiary(String checkDiary) {
        this.checkDiary = checkDiary;
    }

    public String getCheckDiFast() {
        return checkDiFast;
    }

    public void setCheckDiFast(String checkDiFast) {
        this.checkDiFast = checkDiFast;
    }

    public String getCheckDiLong() {
        return checkDiLong;
    }

    public void setCheckDiLong(String checkDiLong) {
        this.checkDiLong = checkDiLong;
    }

    public String getCheckCouple() {
        return checkCouple;
    }

    public void setCheckCouple(String checkCouple) {
        this.checkCouple = checkCouple;
    }

    public String getCheckZodiac() {
        return checkZodiac;
    }

    public void setCheckZodiac(String checkZodiac) {
        this.checkZodiac = checkZodiac;
    }

    public String getCheckImage() {
        return checkImage;
    }

    public void setCheckImage(String checkImage) {
        this.checkImage = checkImage;
    }

    public String getCheckResource() {
        return checkResource;
    }

    public void setCheckResource(String checkResource) {
        this.checkResource = checkResource;
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

    public DivinationFastBO getDivinationFastBO() {
        return divinationFastBO;
    }

    public void setDivinationFastBO(DivinationFastBO divinationFastBO) {
        this.divinationFastBO = divinationFastBO;
    }

    public List<DivinationFastBO> getListDivinationFast() {
        return listDivinationFast;
    }

    public void setListDivinationFast(List<DivinationFastBO> listDivinationFast) {
        this.listDivinationFast = listDivinationFast;
    }

    public ResultsDivinationFastBO getResultsBO() {
        return resultsBO;
    }

    public void setResultsBO(ResultsDivinationFastBO resultsBO) {
        this.resultsBO = resultsBO;
    }

    public List<ResultsDivinationFastBO> getListOfResult() {
        return listOfResult;
    }

    public void setListOfResult(List<ResultsDivinationFastBO> listOfResult) {
        this.listOfResult = listOfResult;
    }
}