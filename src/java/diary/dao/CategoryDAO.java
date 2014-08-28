/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.CategoryBO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ThuTrang
 */
public class CategoryDAO extends HibernateDAO{
    public List getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfCategory = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM CategoryBO ");
            sb.append(" ORDER BY categoryId DESC  ");
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
    
//    public static  void main(String abc[]){
//        CategoryDAO categoryDAO = new CategoryDAO();
//        List<CategoryBO> listCategory = categoryDAO.getList();
//        System.out.print(listCategory.get(0).getName());
//               
//    }
    
    
}
