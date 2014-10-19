package com.trans.core.dao;

import java.util.List;


public interface IBaseDao<T> {

	/**
	 * 插入一个实体（在数据库INSERT一条记录）
	 * @param entity 实体对象
	 * @return 插入成功后实体对象
	 */
	public T save(T entity);
	
	/**
	 * 更新对象记录
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 按主键取记录 
	 * @param id 主键值
	 * @return 记录实体对象，如果没有符合主键条件的记录，则返回null  
	 */
	public T get(Integer id);
	
	
	/**
	 * 取得所有记录
	 * @return 实体对象集合
	 */
	public List<T> getAll();
	
	/**
	 * 根据对象信息删除对象
	 * @param entity 要删除的对象信息
	 */
	public void remove(T entity);
	
	/**
	 * 按主键删除记录 
	 * @param id 主键对象
	 */
	public void remove(Integer id);
	
}
