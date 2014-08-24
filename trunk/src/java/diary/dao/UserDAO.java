/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.UserBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DinhTu
 */
public class UserDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfUsers = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM UserBO ");
            sb.append(" WHERE  1 = 1  ");
            sb.append(" ORDER BY userId DESC  ");
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

    public UserBO getDataById1(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        UserBO data = (UserBO) session.createCriteria(UserBO.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        // .add( Restrictions.between("weight", 0, 100) ) .list();
        return data;
    }
    public static void main(String args[]) {
        UserDAO obj = new UserDAO();
        List<UserBO> persons = obj.getList();
        for (int i = 0; i < persons.size(); i++) {
            UserBO person = (UserBO) persons.get(i);
            System.out.println("sinhVien " + person.getName());

        }
        
        UserBO user = obj.getDataById1(1);
        System.out.println(user.getName());
        user.setName("Le Trang");
        user.setAddress("Ha Noi");
        boolean id = obj.save(user);
        System.out.println(id);
    }
}
