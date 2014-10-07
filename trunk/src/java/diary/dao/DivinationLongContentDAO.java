/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.DivinationLongContentBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThuTrang
 */
public class DivinationLongContentDAO extends HibernateDAO{
    public static void main(String[] abc){
        DivinationLongContentDAO dao = new DivinationLongContentDAO();
        List<DivinationLongContentBO> listBO = new ArrayList<DivinationLongContentBO>();
        Object[] arrId = {18};
        boolean check = dao.multiDelete(arrId, DivinationLongContentBO.class, "dlgId");
        System.out.println("hahaha" + check);
    }
}
