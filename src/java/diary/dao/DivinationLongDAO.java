/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ThuTrang
 */
public class DivinationLongDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM DivinationLongBO ");
            sb.append(" ORDER BY dlgId DESC  ");
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
}
