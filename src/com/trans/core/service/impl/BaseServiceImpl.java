package com.trans.core.service.impl;

import java.util.List;

import com.trans.core.dao.IBaseDao;
import com.trans.core.service.IBaseService;

/**
 * 负责为单个Entity对象提供CRUD操作的服务层基类.
 * 避免在服务层重复实现CURD操作
 * @author llq
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

	
	protected abstract IBaseDao<T> getBaseDao();
	/**
	 * 插入一个实体（在数据库INSERT一条记录）
	 * @param entity 实体对象
	 * @return 插入成功后实体对象
	 */
	@Override
	public T save(T entity) {
		this.getBaseDao().save(entity);
		return entity;
	}

	/**
	 * 更新对象记录
	 * @param entity
	 */
	@Override
	public void update(T entity) {
		this.getBaseDao().update(entity);
	}

	/**
	 * 按主键取记录 
	 * @param id 主键值
	 * @return 记录实体对象，如果没有符合主键条件的记录，则返回null  
	 */
	@Override
	public T get(Integer id) {
		T bean = (T) this.getBaseDao().get(id);
		return bean;
	}

	/**
	 * 取得所有记录
	 * @return 实体对象集合
	 */
	@Override
	public List<T> getAll() {
		return this.getBaseDao().getAll();
	}


	/**
	 * 根据对象信息删除对象
	 * @param entity 要删除的对象信息
	 */
	@Override
	public void remove(T entity) {
		this.getBaseDao().remove(entity);
	}

	/**
	 * 按主键删除记录 
	 * @param id 主键对象
	 */
	@Override
	public void remove(Integer id) {
		this.getBaseDao().remove(id);
	}
}
