/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.ZodiacBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author ThuTrang
 */
public class ZodiacDAO extends HibernateDAO{
    
 public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfUsers = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM ZodiacBO WHERE 1 = 1 ");
            org.hibernate.Query query = session.createQuery(sb.toString());
            listOfUsers = query.list();
            return listOfUsers;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.clear();
            session.close();
        }
        return null;
    }
 
   public static void main(String args[]) {
        ZodiacDAO obj = new ZodiacDAO();
        List persons = obj.getList("ZodiacBO", "name", "", "zodiacId");
        List persons1 = obj.getList();
//        for (int i = 0; i < persons.size(); i++) {
//            UserBO person = (UserBO) persons.get(i);
            System.out.println("sinhVien " + persons1.size());
//
//        }
        
       
    }
}
