package com.situ.crm.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.pojo.User;
import com.situ.crm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/index")
	public String index() {
		return "user_manager";
	}
	
	@RequestMapping("/login")
	public String login( HttpServletRequest req,String name,String password) {
		User user =	userService.findByNameAndPassword(name,password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			return "redirect:/index/index.action";
		} else {
			//登陆失败
			return "redirect:/index/login.action";
		}
	}
	
	
	@RequestMapping("/findAll")
	@ResponseBody
	public EasyUIDataGrideResult findAll(Integer page, Integer rows, User user) {
		return userService.findAll(page, rows, user);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ServerResponse delete(String ids) {
		return userService.delete(ids);
	}

	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(User user) {
		return userService.add(user);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(User user) {
		return userService.update(user);
	}
	@RequestMapping("/getCustomerManagerList")
	@ResponseBody
	public List<User> getCustomerManagerList() {
		return userService.getCustomerManagerList();
	}
}