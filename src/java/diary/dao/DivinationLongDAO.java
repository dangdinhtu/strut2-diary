/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.DivinationLongBO;
import diary.bo.DivinationLongContentBO;
import diary.bo.ResultDivinationLongBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ThuTrang
 */
public class DivinationLongDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM DivinationLongBO ");
            sb.append(" ORDER BY dlgId DESC  ");
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
    
    public int addDivination(DivinationLongBO diLOngBO) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer lastId = null;
        try {
            transaction = session.beginTransaction();
            session.save(diLOngBO);
            session.flush(); 
            lastId = diLOngBO.getDlgId();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lastId;
    }
    
    public int saveOrUpdateDivinationLong(Integer idDiLOng, DivinationLongBO divinationLongBO) {
        DivinationLongContentDAO dlcDao = new DivinationLongContentDAO();
        ResultDivinationLongDAO rdlDao = new ResultDivinationLongDAO();
        boolean flag = false;
        Integer id = null;
        if (idDiLOng == null || (Integer) idDiLOng == 0){
            id = addDivination(divinationLongBO);
            flag = true;
        }else{
            flag = update(divinationLongBO);
            id = divinationLongBO.getDlgId();
            Object[] arrId = {id};
            dlcDao.multiDelete(arrId, DivinationLongContentBO.class, "dlgId");
            dlcDao.multiDelete(arrId, ResultDivinationLongBO.class, "dlgId");
        }
        return id;
    }
    
//    public static void main(String[] abc){
//        DivinationLongDAO dao = new DivinationLongDAO();
////        DivinationLongBO a = new DivinationLongBO(2 , "ten2222224321", "anh", "mo ta", 1);
////        Integer id = dao.saveOrUpdateDivinationFast(a.getDlgId(), a);
////        System.out.println("id = "+ id);
//        List<DivinationLongBO> b = new ArrayList<DivinationLongBO>();
//        b = dao.getList();
//        System.out.println("ten moi = "+ b.size());
//    }
}
