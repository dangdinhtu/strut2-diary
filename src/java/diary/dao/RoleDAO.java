/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.BasicBO;
import diary.bo.PermissionBO;
import diary.bo.RoleBO;
import diary.bo.RolePermBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DinhTu
 */
public class RoleDAO extends HibernateDAO{
   public RolePermDAO rolePermDAO;
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
    
    public boolean addRole(RoleBO roleBO, RolePermBO[] lisRolePerm) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean flag = true;
        try {
            transaction = session.beginTransaction();
            session.save(roleBO);
            for(int i = 0; i < lisRolePerm.length; i++){
                session.save(lisRolePerm[i]);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }
    
    public boolean editRole(RoleBO roleBO, RolePermBO[] lisRolePerm) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        rolePermDAO = new RolePermDAO();
        Integer[] arrId = null ;
        for (int i = 0; i < lisRolePerm.length; i++) {
            arrId[i] = lisRolePerm[i].getRpmId();
            
        }
        boolean flag = true;
        try {
            transaction = session.beginTransaction();
            rolePermDAO.multiDelete(arrId, RolePermBO.class, "rpmId");
            session.save(roleBO);
            for(int i = 0; i < lisRolePerm.length; i++){
                session.save(lisRolePerm[i]);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }
    
    public boolean saveOrUpdateRole(Object idRole, RoleBO roleBO, RolePermBO[] lisRolePerm) {
        boolean flag = false;
        if (idRole == null || (Integer) idRole == 0)
            flag = addRole(roleBO, lisRolePerm);
        else 
            flag = editRole(roleBO, lisRolePerm);
        return flag;
    }
    
}
