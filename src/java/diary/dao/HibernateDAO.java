/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary.dao;

import diary.bo.BasicBO;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
    
    public boolean saveOrUpdate(String key, BasicBO entity) {
        boolean flag = false;
        if (key == null)
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
    /**
     * Hàm tìm kiếm trả về danh sách (Thường là danh mục) dựa vào tên thuộc tính
     *
     * @param <T>
     * @param tableName
     * @param propertyName
     * @param value
     * @param orderClause
     * @return
     */
    public <T> List<T> findByProperty(Class<T> tableName, String propertyName, Object value, String orderClause) {
       Session session = HibernateSessionFactory.getSessionFactory().openSession();
        String hql = " FROM " + tableName.getName() + " t WHERE t." + propertyName + " = ? ";
        if (!StringUtils.isBlank(orderClause)) {
            hql += " ORDER BY " + orderClause;
        }
        try {
            Query query = session.createQuery(hql);
            query.setParameter(0, value);
            return query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            session.flush();
            session.clear();
            session.close();
        }
        return null;
        
    }
    /**
     * 
     * @param <T> Kiểu lớp
     * @param <V> Kiểu trả về của tập hợp
     * @param tableName Tên BO
     * @param propertyName Tên thuộc tính lấy dữ liệu
     * @param propertyConstraint Tên thuộc tính mang ra so sánh ids
     * @param ids Tập các giá trị xuất hiện
     * @return 
     */
    public <T, V> List<V> getOneColumn(Class<T> tableName, String propertyName, String propertyConstraint, Object[] ids) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(tableName);
        criteria.setProjection(Projections.property(propertyName));
        criteria.add(Expression.in(propertyConstraint, ids));
        
        List lst = criteria.list();
        if(lst == null || lst.isEmpty()) {
            return null;
        }
        
        List lstResult = new ArrayList<V>();        
        for (Iterator it = lst.iterator(); it.hasNext();) {
            Object[] myResult = (Object[]) it.next();
            V value = (V)myResult;
            lstResult.add(value);
        }

        return lstResult;
    }

    /**
     * Hàm kiểm trùng giá trị trên một cột nào đó
     *
     * @param className Tên lớp cần kiểm trùng giá trị
     * @param idColumn Định danh cột khóa chính (Trường hợp sửa)
     * @param idValue Giá trị của cột định danh
     * @param codeColumn Tên cột cần kiểm trùng
     * @param codeValue Giá trị cột cần kiểm trùng
     * @return True -> Trùng, False -> Không trùng
     */
    public boolean duplicate(Class className, String idColumn, Object idValue, String codeColumn, String codeValue) {                
        Long id = null;
        String strId = "";
        if (idValue instanceof Integer) {
            id = ((Integer) idValue * 1L);
        } else if (idValue instanceof Long) {
            id = (Long) idValue;
        } else if (idValue instanceof String){
            strId = (String)idValue;
        } else {
            id = null;
            strId = null;
        }

        String hql = " SELECT COUNT(*) FROM " + className.getName() + " t WHERE LOWER(t." + codeColumn + ") = ? ";
        if ((id != null && id > 0) || !StringUtils.isBlank(strId)) {
            hql += " AND t." + idColumn + " != ? ";
        }
        Query query = createQuery(hql);
        query.setParameter(0, codeValue.trim().toLowerCase());
        if (id != null && id > 0) {
            query.setParameter(1, idValue);
        } else if(!StringUtils.isBlank(strId)){
            query.setParameter(1, strId);
        }
        query.setMaxResults(1);
        Object count = query.uniqueResult();
        int totalRowNum = (count instanceof BigInteger) ? ((BigInteger) count).intValue() : ((Long) count).intValue();
        return totalRowNum > 0;
    }
    public Query createQuery(String hql) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery(hql);
    }

    public SQLQuery createSQLQuery(String sql) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createSQLQuery(sql);
    }
}
