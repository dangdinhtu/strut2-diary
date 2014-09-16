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
import org.hibernate.Session;

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
    
//    public static void main(String abc[]){
////        
//        DivinationFastDAO d = new DivinationFastDAO();
//        List<DivinationBO> df = new LinkedList<DivinationBO>();
//        df = d.getList(); 
//        if(df.size() > 0)
//            System.out.println(df.get(0).getName());
//    }
}