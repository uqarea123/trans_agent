package com.trans.core.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trans.core.dao.IBaseDao;

public class BaseDaoImpl<T> implements IBaseDao<T>{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;
	
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 插入一个实体（在数据库INSERT一条记录）
	 * @param entity 实体对象
	 * @return 插入成功后实体对象
	 */
	@Override
	public T save(T entity) {
		this.getSession().saveOrUpdate(entity);
		return entity;
	}

	/**
	 * 更新对象记录
	 * @param entity
	 */
	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	/**
	 * 按主键取记录 
	 * @param id 主键值
	 * @return 记录实体对象，如果没有符合主键条件的记录，则返回null  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T get(Integer id) {
		T bean = (T) this.getSession().get(getClz(), id);
		return bean;
	}

	/**
	 * 取得所有记录
	 * @return 实体对象集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		String hql ="from "+this.getClz().getSimpleName();
		Query query = getSession().createQuery(hql);
		List<T> list = query.list();
		return list;
	}


	/**
	 * 根据对象信息删除对象
	 * @param entity 要删除的对象信息
	 */
	@Override
	public void remove(T entity) {
		this.getSession().delete(entity);
	}

	/**
	 * 按主键删除记录 
	 * @param id 主键对象
	 */
	@Override
	public void remove(Integer id) {
		T bean = get(id);
		if(bean != null)
			this.getSession().delete(bean);
	}
}
