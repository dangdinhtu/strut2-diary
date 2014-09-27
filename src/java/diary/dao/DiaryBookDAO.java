/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diarry.bean.BeanDiaryBook;
import diary.bo.DiaryBookBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author ThuTrang
 */
public class DiaryBookDAO extends HibernateDAO {

    Session session = null;

    public DiaryBookDAO() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public List getList() {
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

    public List<BeanDiaryBook> getDiaryBookByUser(Integer userId) {
        List<BeanDiaryBook> listOfDbc = new ArrayList();
        try {
//            SQLQuery query = session.createSQLQuery("SELECT DBK.NAME, DBK.COVER_PHOTO, BACKGROUND_IMAGES, UDB.USER_ID "
//                    + " FROM USER_DIARY_BOOK AS UDB INNER JOIN DIARY_BOOK AS DBK ON DBK.DBK_ID = UDB.DBK_ID "
//                    + "WHERE UDB.USER_ID = 1");
//            //query.setParameter(0, userId);
//            return query.list();
            
            StringBuffer sb = new StringBuffer();
            sb.append("FROM USER_DIARY_BOOK AS UDB INNER JOIN DIARY_BOOK AS DBK ");
            sb.append("ON DBK.DBK_ID = UDB.DBK_ID ");
            org.hibernate.Query query = session.createQuery(sb.toString());
            listOfDbc = query.list();
                    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.flush();
            session.clear();
            session.close();
        }
        return listOfDbc;

    }

    public static void main(String args[]) {
        DiaryBookDAO obj = new DiaryBookDAO();
        List<BeanDiaryBook> persons = obj.getDiaryBookByUser(1);
        System.out.println(persons.size());
        for (int i = 0; i < persons.size(); i++) {
            System.out.println("sinhVien " + persons.get(i).getName());

        }
    }
}
