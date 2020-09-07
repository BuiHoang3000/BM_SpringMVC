package com.hoang.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoang.model.Category;
import com.hoang.model.Product;
import com.hoang.model.Supplier;

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
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String idPr = request.getParameter("idPr");
		List<Product> pr = prJDBC.getProductUpdate(idPr);
		return pr;
	}
	
	@RequestMapping(value = "/category/getInfo", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Category> getInfoCategory() {
		List<Category> ca = prJDBC.getCategories();
		return ca;
	}
	
	@RequestMapping(value = "/supplier/getInfo", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Supplier> getInfoSupplier() {
		List<Supplier> su = prJDBC.getSupplier();
		return su;
	}
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
	@ResponseBody
	public void UpdateProduct() {
		
	}
}
