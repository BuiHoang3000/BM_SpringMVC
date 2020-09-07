package com.hoang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hoang.model.Product;

public class ProductMapper implements RowMapper<Product> {
	
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
		Product pr = new Product();
		pr.setPr_ID(rs.getString("PR_ID"));
		pr.setPr_CA(rs.getString("CA_Name"));
		pr.setPr_Name(rs.getString("PR_Name"));
		pr.setPr_Price(Float.parseFloat(rs.getString("PR_Price")));
		pr.setPr_Quantify(Integer.parseInt(rs.getString("PR_Quantify")));
		pr.setPr_SU(rs.getString("SU_Name"));
		pr.setPr_Status(rs.getString("PR_Status"));
		return pr;
	}
}
