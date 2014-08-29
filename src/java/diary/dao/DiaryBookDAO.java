/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.DiaryBookBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ThuTrang
 */
public class DiaryBookDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try { 
            List<DiaryBookBO> listOfDbc = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM DiaryBookBO ");
            sb.append(" ORDER BY DBK_ID DESC  ");
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
//        public static void main(String args[]) {
//            DiaryBookDAO obj = new DiaryBookDAO();
//            List<DiaryBookBO> persons = obj.getList();
//            for (int i = 0; i < persons.size(); i++) {
//                DiaryBookBO person = (DiaryBookBO) persons.get(i);
//                System.out.println("sinhVien " + person.getName());
//
//            }
//        }

   
}
