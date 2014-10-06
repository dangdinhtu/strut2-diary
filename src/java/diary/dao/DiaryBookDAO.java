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
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

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
        try {
            SQLQuery query = session.createSQLQuery("SELECT udb.user_id, udb.dbk_id, dbk.name, dbk.date_create, dbk.cover_photo, "
                    + "dbk.background_images FROM user_diary_book as udb inner join diary_book as dbk on udb.dbk_id = dbk.dbk_id "
                    + " WHERE  udb.user_id = :userId");
            query.setParameter("userId", userId);
            query.addScalar("userId", new LongType());
            query.addScalar("dbkId", new LongType());
            query.addScalar("name", new StringType());
            query.addScalar("dateCreate", new DateType());
            query.addScalar("coverPhoto", new StringType());
            query.addScalar("backgroundImages", new StringType());
            query.setResultTransformer(Transformers.aliasToBean(BeanDiaryBook.class));
            return query.list();                    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.flush();
            session.clear();
            session.close();
        }
        return null;
    }
    // lay noi dung fill vao trang doc nhat ki
    public List getDiaryBookContent(Integer userId, Integer dbkId) {
        try {
            SQLQuery query = session.createSQLQuery("SELECT udb.user_Id, dbk.dbk_Id, title, content, date_Written\n" +
                    "FROM user_diary_book AS udb\n" +
                    "INNER JOIN diary_book AS dbk ON udb.dbk_Id = dbk.dbk_Id\n" +
                    "INNER JOIN diary_book_content AS dbc ON dbk.dbk_Id = dbc.dbk_Id "
                    + " WHERE  udb.user_id = :userId AND dbk.dbk_Id = :dbkId");
            query.setParameter("userId", userId);
            query.setParameter("dbkId", dbkId);
//            query.addEntity("userId", BeanDiaryBook.class);
//            query.addEntity("dbkId", BeanDiaryBook.class);
//            query.addEntity("title", BeanDiaryBook.class);
//            query.addEntity("content", BeanDiaryBook.class);
//            query.addEntity("dateWritten", BeanDiaryBook.class);
//            query.addScalar("dbkId", new LongType());
//            query.addScalar("title", new StringType());
//            query.addScalar("content", new StringType());
//            query.addScalar("dateWritten", new DateType());
            //query.setResultTransformer(Transformers.aliasToBean(BeanDiaryBook.class));
            return query.list();                    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.flush();
            session.clear();
            session.close();
        }
        return null;
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
