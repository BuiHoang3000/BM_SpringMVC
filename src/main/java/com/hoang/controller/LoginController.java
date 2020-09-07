package com.hoang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoang.model.Employees;

@Controller
public class LoginController {
	
	private ApplicationContext context = null;
	private ConJDBC emJDBC = null;
	
	public LoginController() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		emJDBC = (ConJDBC) context.getBean("conJDBC");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("loginForm", new Employees());
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, @ModelAttribute("loginForm") Employees em, ModelMap model) {
		if(emJDBC.checkLoginEm(em)) {
			session.setAttribute("accType", emJDBC.getAccType(em));
			session.setAttribute("nameEmployee", emJDBC.getAccName(em));
			return "redirect:/product";
		} else {
			request.setAttribute("message", "Sai email hoặc mật khẩu!");
			return "login";
		}
	}
}
