/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.RoleBO;

/**
 *
 * @author DinhTu
 */
public class RolePermDAO extends HibernateDAO{
    public String checkRolePerm(RoleBO roleBO){
        String check = "";
        int count = ((Long)getSession().createQuery("select count(*) from role_perm where PERM_ID = "+ roleBO.getPermId()+" and ROLE_ID = "+ roleBO.getRoleId()+" and FUNCTION_ID = "+ roleBO.getFunctionId()).uniqueResult()).intValue();
        if(count == 1){
            check = "checked";
        }
        return check;
    }
}
