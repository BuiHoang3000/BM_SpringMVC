package com.hoang.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;

import com.hoang.mapper.CategoryMapper;
import com.hoang.mapper.EmployeeMapper;
import com.hoang.mapper.ProductMapper;
import com.hoang.mapper.SupplierMapper;
import com.hoang.model.Category;
import com.hoang.model.Employees;
import com.hoang.model.Product;
import com.hoang.model.Supplier;

public class ConJDBC {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	// EMPLOYEE
			
	public boolean checkLoginEm(Employees em) {
		String sql = "EXEC [dbo].[LOGIN_ACOUNT] @em_Email = ?, @em_Password = ?";
		List<Employees> result = jdbcTemplateObject.query(sql, new Object[] {em.getPs_Email(), em.getPs_Password()}, new EmployeeMapper());
		if(result.size() > 0)
			return true;
		return false;
	}
	
	public String getAccType(Employees em) {
		String sql = "EXEC GETACCTYPE @em_Email = ?, @em_Password = ?";
		List<Employees> employee = jdbcTemplateObject.query(sql, new Object[] {em.getPs_Email(), em.getPs_Password()}, new EmployeeMapper());
		if(employee != null && employee.get(0).getPs_Status().equals("1"))
			return "Boss";
		else {
			if(employee != null && employee.get(0).getPs_Status().equals("0"))
				return "Employee";
		}
		return null;
	}
	
	public String getAccName(Employees em) {
		String sql = "EXEC GETACCTYPE @em_Email = ?, @em_Password = ?";
		List<Employees> employee = jdbcTemplateObject.query(sql, new Object[] {em.getPs_Email(), em.getPs_Password()}, new EmployeeMapper());
		if(employee != null) {
			return employee.get(0).getPs_Name();
		}
		return null;
	}
	
	// PRODUCT
	
	public List<Product> getListPr(int formPr, int toPr) {
		String sql = "SHOW_PRO_LM @from = ?, @to = ?";
		List<Product> pr = jdbcTemplateObject.query(sql, new Object[] {formPr, toPr}, new ProductMapper());
		return pr;
	}
	
	public int countProduct() {
		int cou = 0;
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		String sql = "EXEC SHOW_PRODUCT";
		jdbcTemplateObject.query(sql, countCallback);
		cou = countCallback.getRowCount();
		return cou;
	}
	
	public List<Product> getProductUpdate(String id) {
		String sql = "EXEC FIND_PRODUCT_ALL_BY_ID @IntFind = ?";
		List<Product> pr =  jdbcTemplateObject.query(sql, new Object[] {id}, new ProductMapper());
		return pr;
	}

	public void addProduct(Product pr){
		
	}
	
	
	// CATEGORY
	
	public List<Category> getCategories(){
		String sql = "EXEC SHOW_CATEGORIES";
		List<Category> ca = jdbcTemplateObject.query(sql, new Object[] {}, new CategoryMapper());
		return ca;
	}
	
	
	// SUPPLIER
	
	public List<Supplier> getSupplier(){
		String sql = "EXEC SHOW_SUPPLIERS";
		List<Supplier> su = jdbcTemplateObject.query(sql, new Object[] {}, new SupplierMapper());
		return su;
	}
}
