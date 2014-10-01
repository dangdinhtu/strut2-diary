/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author DinhTu
 */
public class UserRoleDAO extends HibernateDAO {

    Session session;

    public UserRoleDAO() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public Boolean deleteByUserId(Integer userId) {
        Boolean flag = true;
        try {
            String sql = "DELETE FROM USER_ROLE WHERE USER_ID = " + userId;
            SQLQuery query = session.createSQLQuery(sql);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
