/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.AdsBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DinhTu
 */
public class AdsDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfUsers = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM AdsBO ");
            sb.append(" WHERE  1 = 1  ");
            sb.append(" ORDER BY adsId DESC  ");
            org.hibernate.Query query = session.createQuery(sb.toString());
            listOfUsers = query.list();
            return listOfUsers;
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
//        AdsDAO obj = new AdsDAO();
//        List<AdsBO> persons = obj.getList();
//        for (int i = 0; i < persons.size(); i++) {
//            AdsBO person = (AdsBO) persons.get(i);
//            System.out.println("sinhVien " + person.getName());
//
//        }
        
//        UserBO user = obj.getDataById(1);
//        System.out.println(user.getName());
//        user.setName("Le Trang");
//        user.setAddress("Ha Noi");
//        Integer id = obj.save(user);
//        System.out.println(id);
//    }
}
