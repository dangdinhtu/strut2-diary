/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.BasicBO;
import diary.bo.PermissionBO;
import diary.bo.RoleBO;
import diary.bo.RolePermBO;
import diary.bo.UserBO;
import diary.bo.ViewUserRoleBO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DinhTu
 */
public class RoleDAO extends HibernateDAO{
   public RolePermDAO rolePermDAO;
   HttpServletRequest req = ServletActionContext.getRequest();
   String action = req.getParameter("action");
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM RoleBO ");
            sb.append(" ORDER BY roleId DESC  ");
            org.hibernate.Query query = session.createQuery(sb.toString());
            listOfCategory = query.list();
            return listOfCategory;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.clear();
            session.close();
        }
        return null;
    }
    public  <T> List<T> getListBySql(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List list = new ArrayList();
        String sql = "SELECT * FROM ROLE WHERE 1 = 1 ORDER BY ROLE_ID DESC" ;
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(RoleBO.class);
        return query.list();
    }
    
    public  String checkRole( String username, Integer permId, Integer functionId){
        String action = "style='display: none'";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List list = new ArrayList();
        String sql = "SELECT * FROM `view_user_role` WHERE USERNAME = '"+ username +"' and PERM_ID = "+ permId +" and FUNCTION_ID =" + functionId ;
        SQLQuery query = session.createSQLQuery(sql);
        list = query.list();
        if(list.size() > 0){
            action = "";
        }
        return action;
    }
    
    public int addRole(RoleBO roleBO) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer lastId = null;
        try {
            transaction = session.beginTransaction();
//            String sql = "INSERT INTO `ROLE`(NAME, DESCRIPT, STATUS) VALUES ("+ roleBO.getName() +","+ roleBO.getDescript() +","+ roleBO.getStatus()+")" ;
//            SQLQuery query = session.createSQLQuery(sql);
//            query.executeUpdate();System.out.println("truoc khi flush");
            session.save(roleBO);
            session.flush(); 
            lastId = roleBO.getRoleId();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lastId;
    }
    public boolean addRelation(RoleBO roleBO){
        boolean flag = true;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            
                String sql = "INSERT INTO `role_perm`(`PERM_ID`, `ROLE_ID`, `FUNCTION_ID`) VALUES ("+ roleBO.getPermId() +","+ roleBO.getRoleId() +","+ roleBO.getFunctionId()+")" ;
                SQLQuery query = session.createSQLQuery(sql);
                query.executeUpdate();
                transaction.commit();
        } catch (HibernateException e) {
            flag = false;
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag;
        
    }
    
    
    public int saveOrUpdateRole(Object idRole, RoleBO roleBO) {
        rolePermDAO = new RolePermDAO();
        boolean flag = false;
        Integer id = null;
        if (idRole == null || (Integer) idRole == 0){
            id = addRole(roleBO);
            flag = true;
        }else{
            flag = update(roleBO);
            id = roleBO.getRoleId();
            Object[] arrId = {id};
            rolePermDAO.multiDelete(arrId, RolePermBO.class, "roleId");
        }
        return id;
    }
    
//    public static void main(String[] abc){
//        RoleDAO a = new RoleDAO();
//        String b = a.checkRole("thutrangq1", 2, 1);
//        System.out.println("keets qua la : " + b);
//    }
    
}
