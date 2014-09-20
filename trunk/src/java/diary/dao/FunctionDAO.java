/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.FunctionBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author DinhTu
 */
public class FunctionDAO extends HibernateDAO {

    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM FunctionBO ");
            sb.append(" ORDER BY functionId DESC  ");
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

    public <T> List<T> getListFunctionBySql() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List list = new ArrayList();
        String sql = "SELECT * FROM  FUNCTION  WHERE 1 = 1 ORDER BY FUNCTION_ID DESC";
        try {
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(FunctionBO.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
