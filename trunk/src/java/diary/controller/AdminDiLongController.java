/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationLongBO;
import diary.bo.DivinationLongContentBO;
import diary.bo.ResultDivinationLongBO;
import diary.common.Message;
import diary.dao.DivinationLongContentDAO;
import diary.dao.DivinationLongDAO;
import diary.dao.ResultDivinationLongDAO;
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
public class AdminDiLongController extends ActionSupport {

    private DivinationLongBO dlgBO;
    DivinationLongDAO dlgDAO = new DivinationLongDAO();
    private List<DivinationLongBO> listOfdlgBO;
    private DivinationLongContentBO diLongContentBO;
    DivinationLongContentDAO diLongContentDAO = new DivinationLongContentDAO();
    private List<DivinationLongContentBO> listOfDiLongContent;
    private ResultDivinationLongBO resultDiLongBO;
    ResultDivinationLongDAO resultDiLongDAO = new ResultDivinationLongDAO();
    private List<ResultDivinationLongBO> listOfResultDiLong;
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
        checkAdd = roleDAO.checkRole(username, 2, 6);
        checkEdit = roleDAO.checkRole(username, 3, 6);
        checkDel = roleDAO.checkRole(username, 4, 6);

        if ("addOrUpdate".equals(action)) {
            Integer dlgId = dlgBO.getDlgId();
            String[] arr = dlgBO.getArrQuestion();
            String[] arrA = dlgBO.getArrA();
            String[] arrB = dlgBO.getArrB();
            String[] arrC = dlgBO.getArrC();
            String[] arrD = dlgBO.getArrD();
            Integer[] arrMarkA = dlgBO.getArrMarkA();
            Integer[] arrMarkB = dlgBO.getArrMarkB();
            Integer[] arrMarkC = dlgBO.getArrMarkC();
            Integer[] arrMarkD = dlgBO.getArrMarkD();

            Integer[] arrScoreMin = dlgBO.getArrScoreMin();
            Integer[] arrScoreMax = dlgBO.getArrScoreMax();
            String[] arrResult = dlgBO.getArrResult();

            boolean check = true;
            boolean checkSaveContent = true;
            boolean checkSaveResult = true;

            Integer lastId = dlgDAO.saveOrUpdateDivinationLong(dlgId, dlgBO);
            for (int i = 0; i < arr.length; i++) {
                diLongContentBO = new DivinationLongContentBO();
                if (!"".equals(arr[i]) && !"".equals(arrA[i]) && !"".equals(arrB[i]) && !"".equals(arrC[i]) && !"".equals(arrD[i])) {
                    diLongContentBO.setQuestion(arr[i]);
                    diLongContentBO.setA(arrA[i]);
                    diLongContentBO.setB(arrB[i]);
                    diLongContentBO.setC(arrC[i]);
                    diLongContentBO.setD(arrD[i]);
                    diLongContentBO.setMarkA(arrMarkA[i]);
                    diLongContentBO.setMarkB(arrMarkB[i]);
                    diLongContentBO.setMarkC(arrMarkC[i]);
                    diLongContentBO.setMarkD(arrMarkD[i]);
                    diLongContentBO.setDlgId(lastId);
                    check = diLongContentDAO.save(diLongContentBO);
                    if (check == false) {
                        checkSaveContent = false;
                    }
                }
            }

            for (int i = 0; i < arrScoreMin.length; i++) {
                resultDiLongBO = new ResultDivinationLongBO();
                if (!"".equals(arrScoreMin[i]) && !"".equals(arrScoreMax[i]) && !"".equals(arrResult[i])) {
                    resultDiLongBO.setScoreMax(arrScoreMax[i]);
                    resultDiLongBO.setScoreMin(arrScoreMin[i]);
                    resultDiLongBO.setResults(arrResult[i]);
                    resultDiLongBO.setDlgId(lastId);
                    check = resultDiLongDAO.save(resultDiLongBO);
                    if (check == false) {
                        checkSaveResult = false;
                    }
                }

            }
            if (dlgId == null && checkSaveContent && checkSaveResult) {
                result = Message.getMessage("Thêm mới bản ghi thành công", "success");
            } else if (dlgId != 0 || dlgId != null && checkSaveContent && checkSaveResult) {
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
                Integer id = Integer.parseInt(req.getParameter("id"));
                dlgBO = dlgDAO.get(DivinationLongBO.class, id);
                String StringId = id.toString();
                listOfDiLongContent = new ArrayList<DivinationLongContentBO>();
                listOfResultDiLong = new ArrayList<ResultDivinationLongBO>();
                listOfDiLongContent = diLongContentDAO.getList("DivinationLongContentBO", "dlgId", StringId, "dlgId");
                listOfResultDiLong = resultDiLongDAO.getList("ResultDivinationLongBO", "dlgId", StringId, "dlgId");
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
                    boolean check = dlgDAO.multiDelete(arrId, DivinationLongBO.class, "dlgId");
                    if (check) {
                        result = Message.getMessage("Xóa bản ghi thành công", "success", "AdminDiLongController");
                    } else {
                        result = Message.getMessage("Xóa bản ghi thất bại", "error", "AdminDiLongController");
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
        listOfdlgBO = dlgDAO.getList();
        req.setAttribute("keyword", keyword);
        return SUCCESS;

    }

    public List<DivinationLongBO> getListOfdlgBO() {
        return listOfdlgBO;
    }

    public void setListOfdlgBO(List<DivinationLongBO> listOfdlgBO) {
        this.listOfdlgBO = listOfdlgBO;
    }

    public DivinationLongBO getDlgBO() {
        return dlgBO;
    }

    public void setDlgBO(DivinationLongBO dlgBO) {
        this.dlgBO = dlgBO;
    }

    public DivinationLongDAO getDlgDAO() {
        return dlgDAO;
    }

    public void setDlgDAO(DivinationLongDAO dlgDAO) {
        this.dlgDAO = dlgDAO;
    }

    public DivinationLongContentBO getDiLongContentBO() {
        return diLongContentBO;
    }

    public void setDiLongContentBO(DivinationLongContentBO diLongContentBO) {
        this.diLongContentBO = diLongContentBO;
    }

    public List<DivinationLongContentBO> getListOfDiLongContent() {
        return listOfDiLongContent;
    }

    public void setListOfDiLongContent(List<DivinationLongContentBO> listOfDiLongContent) {
        this.listOfDiLongContent = listOfDiLongContent;
    }

    public ResultDivinationLongBO getResultDiLongBO() {
        return resultDiLongBO;
    }

    public void setResultDiLongBO(ResultDivinationLongBO resultDiLongBO) {
        this.resultDiLongBO = resultDiLongBO;
    }

    public List<ResultDivinationLongBO> getListOfResultDiLong() {
        return listOfResultDiLong;
    }

    public void setListOfResultDiLong(List<ResultDivinationLongBO> listOfResultDiLong) {
        this.listOfResultDiLong = listOfResultDiLong;
    }

    public DivinationLongContentDAO getDiLongContentDAO() {
        return diLongContentDAO;
    }

    public void setDiLongContentDAO(DivinationLongContentDAO diLongContentDAO) {
        this.diLongContentDAO = diLongContentDAO;
    }

    public ResultDivinationLongDAO getResultDiLongDAO() {
        return resultDiLongDAO;
    }

    public void setResultDiLongDAO(ResultDivinationLongDAO resultDiLongDAO) {
        this.resultDiLongDAO = resultDiLongDAO;
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