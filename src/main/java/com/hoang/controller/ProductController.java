package com.hoang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoang.model.Employees;
import com.hoang.model.Product;

@Controller
public class ProductController {
	
	private ApplicationContext context = null;
	private ConJDBC prJDBC = null;
	
	private ProductController() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		prJDBC = (ConJDBC) context.getBean("conJDBC");
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(@ModelAttribute("loginForm") Employees em, HttpServletRequest request, HttpSession session, ModelMap model) {
		if(session.getAttribute("accType") == "Boss" || session.getAttribute("accType") == "Employee") {
			
			// Trang hiện tại
			int page = 1;
			if(request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			request.setAttribute("page", page);
			
			// Số trang hiển thị và lấy số bắt đầu | kết thúc
			int totalProduct = prJDBC.countProduct();
			int numOfPages = 0;
			if(totalProduct % 10 == 0)
				numOfPages = totalProduct / 10;
			else
				numOfPages = (totalProduct / 10) + 1;
			int formPr = 10 * (page - 1) + 1;
			int toPr = 10 * page;
			request.setAttribute("numOfPages", numOfPages);
			
			// Lấy data
			List<Product> prList = prJDBC.getListPr(formPr, toPr);
			model.put("prList", prList);
			return "product";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logoout(@ModelAttribute("loginForm") Employees em, HttpSession session) {
		//session.invalidate();
		session.removeAttribute("nameEmployee");
		session.setAttribute("accType", "-1");
		return "login";
	}
}
