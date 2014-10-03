/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.DivinationBO;
import diary.bo.DivinationFastBO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ThuTrang
 */
public class DivinationFastDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List<DivinationFastBO> df = new LinkedList<DivinationFastBO>();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM DivinationFastBO ");
            sb.append(" ORDER BY dfnId DESC  ");
            org.hibernate.Query query = session.createQuery(sb.toString());
            df = query.list();
            return df;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.clear();
            session.close();
        }
        return null;
    }
    public int addDivination(DivinationFastBO roleBO) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer lastId = null;
        try {
            transaction = session.beginTransaction();
            session.save(roleBO);
            session.flush(); 
            lastId = roleBO.getDfnId();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lastId;
    }
    
    public int saveOrUpdateDivinationFast(Object idDFast, DivinationFastBO divinationFastBO) {
        boolean flag = false;
        Integer id = null;
        if (idDFast == null || (Integer) idDFast == 0){
            id = addDivination(divinationFastBO);
            flag = true;
        }else{
            flag = update(divinationFastBO);
            id = divinationFastBO.getDfnId();
        }
        return id;
    }
//    public static void main(String abc[]){
//       
//        DivinationFastDAO d = new DivinationFastDAO();
////        List<DivinationBO> df = new LinkedList<DivinationBO>();
////        df = d.getList(); 
////        if(df.size() > 0)
////            System.out.println(df.get(0).getName());
//        
//        DivinationFastBO b = new DivinationFastBO( 3,"cfffffffffff", "b", 1);
//        Object id = 3;
//        Integer check = d.saveOrUpdateDivinationFast(id, b);
//        if (check > 0 || check != null ) {
//            System.out.println("hahahaa thành công rồi" + check );
//        }else{
//            System.out.println("thốn vồn");
//        }
//            
//    }
}
