/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DinhTu
 */
public class DiaryController extends ActionSupport{
    public String execute() throws Exception {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpServletResponse res = ServletActionContext.getResponse();
        String action = req.getParameter("action");  
        if("create-diary".equals(action)){
            return "create-diary";
        }else if("write-diary".equals(action)){
            return "write-diary";
        }
        return SUCCESS;
    }
}
