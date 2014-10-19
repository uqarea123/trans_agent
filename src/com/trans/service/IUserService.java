package com.trans.service;

import com.trans.core.service.IBaseService;
import com.trans.model.User;

/**
 * 
 * @author llq
 *
 * @param <T>
 */
public interface IUserService extends IBaseService<User>{

	public User saveUser(User user);
	public User findUserById(Integer id);
	public void delUserById(Integer id);
	public void updateUser(User user); 
}
