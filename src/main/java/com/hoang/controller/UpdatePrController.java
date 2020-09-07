package com.hoang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoang.model.Product;

@Controller
public class UpdatePrController {
	
	private ApplicationContext context = null;
	private ConJDBC prJDBC = null;
	
	private UpdatePrController() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		prJDBC = (ConJDBC) context.getBean("conJDBC");
	}
	
	@RequestMapping(value = "/product/getInfo", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getInfo(HttpServletRequest request) {
		String idPr = request.getParameter("idPr");
		List<Product> pr = prJDBC.getProductUpdate(idPr);
		return pr;
	}
}
