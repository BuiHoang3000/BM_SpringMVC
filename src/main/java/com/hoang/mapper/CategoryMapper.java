package com.hoang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hoang.model.Category;

public class CategoryMapper implements RowMapper<Category>{
	
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException{
		Category ca = new Category();
		ca.setCa_ID(rs.getString("CA_ID"));
		ca.setCa_Name(rs.getString("CA_Name"));
		ca.setCa_Status(rs.getString("CA_Status"));
		return ca;
	}
}
