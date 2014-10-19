package com.trans.service.impl;

import javax.annotation.Resource;

import com.trans.core.dao.IBaseDao;
import com.trans.core.service.impl.BaseServiceImpl;
import com.trans.dao.IUserDao;
import com.trans.model.User;
import com.trans.service.IUserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{

	@Resource
	private IUserDao userDao;
	
	@Override
	protected IBaseDao<User> getBaseDao() {
		return userDao;
	}
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	@Override
	public User findUserById(Integer id) {
		return userDao.get(id);
	}
	
	@Override
	public void delUserById(Integer id) {
		userDao.remove(id);
	}
	
	@Override
	public void updateUser(User user) {
		
		userDao.update(user);
	}
	
	

}
