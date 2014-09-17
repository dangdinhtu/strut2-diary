/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;


import diary.bo.ViewDiaryBookBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author ThuTrang
 */
public class ViewDiaryBookDAO extends HibernateDAO {
    
     public List getList() {System.out.println("2");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        System.out.println("3");
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM ViewDiaryBookBO ");
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
     
     public static void main(String abc[]){
         ViewDiaryBookDAO a = new ViewDiaryBookDAO(); System.out.println("1");
         List<ViewDiaryBookBO> listOfCategory = a.getList();
         if(listOfCategory.size() > 0){
         System.out.println(listOfCategory.get(0).getName());
         }
     }
}