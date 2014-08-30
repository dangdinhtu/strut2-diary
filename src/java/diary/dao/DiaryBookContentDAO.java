/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.DiaryBookContentBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ThuTrang
 */
public class DiaryBookContentDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try { 
            List<DiaryBookContentBO> listOfDbc = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM DiaryBookContentBO ");
            sb.append(" ORDER BY DBC_ID DESC  ");
            org.hibernate.Query query = session.createQuery(sb.toString());
            listOfDbc = query.list();
            return listOfDbc;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.clear();
            session.close();
        }
        return null;
    }
}
