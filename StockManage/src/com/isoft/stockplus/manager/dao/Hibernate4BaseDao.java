package com.isoft.stockplus.manager.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName:HibernateJpa
 * @Description: 
 * @Copyright: Copyright (c) 2016
 * @Company:天津市融创软通科技有限公司
 * @author: 周楠
 * @date 2016年4月16日 下午7:24:58
 */

public  abstract  class Hibernate4BaseDao<T> {
	
	private SessionFactory sessionFactory;
	
	private Class<T> poclazz;
	
	
	public Hibernate4BaseDao(){
		
		Type genericSuperclass = this.getClass().getGenericSuperclass();
	    Type[] params = ((ParameterizedType)genericSuperclass).getActualTypeArguments();
	    poclazz = null;
	    if ((params.length > 0) && (params[0] != null)) {
	    	poclazz = (Class)params[0];
	    }
		
	}
	

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	
	
	public  T findById(Integer id) {
		
	Session session=openSession();
	T obj=	(T)openSession().get(poclazz, id);
		
	session.close();
	
       return  obj;
    }
	
	public  List<T> findAll() {
		
	Session session=	openSession();
	
	List<T> list  =session.createQuery("from " + poclazz.getSimpleName()).list();
	
	session.close();
	
        return list;
    }
	
	public  Map<String,Object> findByPage(Integer first,Integer max) {
		
	
		Map<String,Object> map=new HashMap<String, Object>();
		
		Session session=	openSession();
		
		Query query =session.createQuery("from " + poclazz.getSimpleName());
					
		query.setFirstResult(first); 
		
		query.setMaxResults(max);
				
	    List<T> list  = query.list();
	    
	    
	   String total=  session.createQuery("select count(*)  from  "+poclazz.getSimpleName()).uniqueResult().toString();
		
	   map.put("rows", list);
	   map.put("total", total);
	   
		session.close();
		
	        return map;
	    }
	
	
	
    public  void saveOrUpdate(T entity) {
		System.out.println("-============================-");

     Session session=openSession();
     
     session.beginTransaction();
    	
     session.saveOrUpdate(entity);
    	
     session.getTransaction().commit();
     session.close();
    }

    public  T update(T entity) {
    	 Session session=openSession();
    	 session.beginTransaction();
    	session.update(entity);
    	session.getTransaction().commit();
    	   session.close();
        return entity;
    }

    public  void delete(T entity) {
    	Session session=openSession();
    	 session.beginTransaction();
    	session.delete(entity);
    	session.getTransaction().commit();
    	   session.close();
    }

    
    public  void deleteById(Integer id) {
    	
    Session session=openSession(); 
    session.beginTransaction();
     T entity = (T) session.get(poclazz, id);
       delete(entity);
       session.getTransaction().commit();
       session.close();
    }
    
    public  void deleteById(String entityId) {
    	
        Session session=openSession(); 
        session.beginTransaction();
         T entity = (T) session.get(poclazz, entityId);
           delete(entity);
           session.getTransaction().commit();
           session.close();
        }
	
}
