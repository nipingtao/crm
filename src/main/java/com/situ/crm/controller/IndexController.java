package com.situ.crm.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	private String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginout")
	public String loginout(HttpServletRequest req, HttpServletResponse resp)  {
		 //1.获取HttpSession
		 		HttpSession session = req.getSession(false);
		 		if (session != null) {
		 			session.invalidate();
		 		}
		 		 return "login";
		 	}
	
}
