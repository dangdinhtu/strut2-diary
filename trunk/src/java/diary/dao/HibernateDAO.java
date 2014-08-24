/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.BasicBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DinhTu
 */
public class HibernateDAO {

    public boolean save(BasicBO objectToSave) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean flag = true;
        try {
            transaction = session.beginTransaction();
            session.save(objectToSave);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }
    public boolean update(Object entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean flag = true;
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            session.close();
        }
        return flag;
    }
    public boolean saveOrUpdate(Object id, BasicBO entity) {
        boolean flag = false;
        if (id == null || (Integer) id == 0)
            flag = save(entity);
         else 
            flag = update(entity);
        
        return flag;
    }
    public <T> T get(Class<T> entityClass, Serializable id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return (T) session.get(entityClass, id);
    }

    public boolean delete(Object entity) {
        boolean flag = true;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (HibernateException e) {
            flag = false;
            transaction.rollback();
            e.printStackTrace();
        }
        return flag;
    }
    
    public boolean multiDelete(Object[] arrId, Class className, String idColumn) {
        boolean flag = true;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            if ((arrId != null) && (arrId.length > 0)) {
                String hql = " DELETE FROM " + className.getName() + " t WHERE t." + idColumn + " IN (:arrId) ";
                Query query = session.createQuery(hql);
                query.setParameterList("arrId", arrId);
                query.executeUpdate();
                transaction.commit();
            }
            
        } catch (HibernateException e) {
            flag = false;
            transaction.rollback();
            e.printStackTrace();
        }
        return flag;
    }
    
    public List getList(String nameBO, String col1, String col2, String col3, String key, String order) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfUsers = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM "+ nameBO +" ");
            sb.append(" WHERE  "+ col1 +" like '%"+ key +"%'  ");
            sb.append(" OR  "+ col2 +" like '%"+ key +"%'  ");
            sb.append(" OR  "+ col3 +" like '%"+ key +"%'  ");
            sb.append(" ORDER BY "+ order +" DESC  ");
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
    
    public List getList(String nameBO, String col1, String col2, String key, String order) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfUsers = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM "+ nameBO +" ");
            sb.append(" WHERE  "+ col1 +" like '%"+ key +"%'  ");
            sb.append(" OR  "+ col2 +" like '%"+ key +"%'  ");
            sb.append(" ORDER BY "+ order +" DESC  ");
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
    
    public List getList(String nameBO, String col, String key, String order) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            List listOfUsers = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" FROM "+ nameBO +" ");
            sb.append(" WHERE  "+ col +" like '%"+ key +"%'  ");
            sb.append(" ORDER BY "+ order +" DESC  ");
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
}
