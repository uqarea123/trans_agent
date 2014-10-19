package com.trans.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trans.model.User;
import com.trans.service.IUserService;



/**
 * 用户控制类
 * 
 * @author llq
 * 
 */
@Controller
@RequestMapping({ "/user/" })
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	
	
	@RequestMapping("addUser.do")
	public String addUser(User user,ModelMap model){
		
		try {
			
			User user1=userService.save(user);
			if(user1!=null)
				model.addAttribute("message", "保存成功");
			else
				model.addAttribute("message", "保存失败");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务器出现未知错误");
		}
		
		return "message";
	}
}
