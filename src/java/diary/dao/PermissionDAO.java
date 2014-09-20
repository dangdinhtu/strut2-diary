/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.PermissionBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author DinhTu
 */
public class PermissionDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM PermissionBO ");
            sb.append(" ORDER BY permId DESC  ");
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
        String sql = "SELECT * FROM  PERMISSION" ;
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(PermissionBO.class);
        return query.list();
    }
    
}
