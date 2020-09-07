package com.hoang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hoang.model.Supplier;

public class SupplierMapper implements RowMapper<Supplier>{
	
	public Supplier mapRow(ResultSet rs, int numRow) throws SQLException {
		Supplier su = new Supplier();
		su.setSu_ID(rs.getString("SU_ID"));
		su.setSu_Name(rs.getString("SU_Name"));
		su.setSu_PhoneNumber(rs.getString("SU_PhoneNumber"));
		su.setSu_Address(rs.getString("SU_Address"));
		su.setSu_Status(rs.getString("SU_Status"));
		return su;
	}
}
