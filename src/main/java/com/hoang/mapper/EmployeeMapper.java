package com.hoang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hoang.model.Employees;

public class EmployeeMapper implements RowMapper<Employees> {
	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employees em = new Employees();
		em.setPs_Email(rs.getString("EM_Email"));
		em.setPs_Password(rs.getString("EM_Password"));
		em.setPs_ID(rs.getString("EM_ID"));
		em.setPs_Name(rs.getString("EM_Name"));
		em.setPs_BirthDate(rs.getString("EM_BirthDate"));
		em.setPs_Address(rs.getString("EM_Address"));
		em.setPs_PhoneNumber(rs.getString("EM_PhoneNumber"));
		em.setEm_Position(rs.getString("EM_Position"));
		em.setPs_Status(rs.getString("EM_Status"));
		return em;
	}
}
