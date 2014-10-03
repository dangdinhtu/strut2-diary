/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import com.opensymphony.xwork2.ActionSupport;
import diary.bo.DivinationFastBO;
import diary.bo.ResultsDivinationFastBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ThuTrang
 */
public class ResultDivinationFastDAO extends HibernateDAO {
    
    public List<ResultsDivinationFastBO> getList(DivinationFastBO divinationFastBO){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM ResultsDivinationFastBO ");
            sb.append(" ORDER BY rdfId DESC  ");
            sb.append(" WHERE dfnId = "+ divinationFastBO.getDfnId());
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
    
//    public static void main(String[] abc){
//        ResultDivinationFastDAO a = new ResultDivinationFastDAO();
//        List<ResultsDivinationFastBO> b = new ArrayList<ResultsDivinationFastBO>();
//          b = a.getList(1);
//          for (int i = 0; i < b.size(); i++) {
//              System.out.println("answer = "+ b.get(i).getAnswer() + "   kết quả = " + b.get(i).getResult());
//        }
//    }
}