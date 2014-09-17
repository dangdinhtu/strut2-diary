/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.DiaryBookBO;
import diary.bo.DiaryBookContentBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author ThuTrang
 */
public class DiaryBookContentDAO extends HibernateDAO {
      public Integer countPage(DiaryBookBO dbkBO){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try { 
            List<DiaryBookContentBO> listOfDbc = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM DiaryBookContentBO ");
            sb.append(" Where DiaryBookContentBO.dbkId = "+ dbkBO.getDbkId());
            org.hibernate.Query query = session.createQuery(sb.toString());
            listOfDbc = query.list();
            return listOfDbc.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.clear();
            session.close();
        }
        return null;
    }
      
//      public static void main(String args[]) {
//          DiaryBookContentDAO a = new DiaryBookContentDAO();
//          int count = a.countPage();
//          System.out.print("dddddddddddddddddddddddđ"+ count);
//      }
}