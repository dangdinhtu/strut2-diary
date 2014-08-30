/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.DivinationCategoryBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ThuTrang
 */
public class DivinationCategoryDAO extends HibernateDAO{
     public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try { 
            List<DivinationCategoryBO> listOfDbc = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM DivinationCategoryBO ");
            sb.append(" ORDER BY DCY_ID DESC  ");
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
     
     public static void main(String abc[]){
         DivinationCategoryDAO a = new DivinationCategoryDAO();
         List<DivinationCategoryBO> listOfDbc = new ArrayList();
         listOfDbc = a.getList();
         System.out.print(listOfDbc.get(0).getName());
     }
     
     
}
