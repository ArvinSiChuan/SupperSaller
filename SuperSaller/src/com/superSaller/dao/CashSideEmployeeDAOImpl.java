package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.superSaller.beans.persons.entities.CashSideEmployee;
import com.superSaller.beans.persons.entities.EmRole;

@Service(value = "cashSideEmDAO")
public class CashSideEmployeeDAOImpl extends BaseDAO<CashSideEmployee> {

	@Override
	public CashSideEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
		CashSideEmployee employee = new CashSideEmployee();
		employee.setEmID(rs.getString("EM_ID"));
		employee.setEmRole(EmRole.valueOf(rs.getString("EM_ROLE")));
		return employee;
	}

	public CashSideEmployee queryEmployeeByID(String emID) {
		String sql = "select EM_ID,EM_ROLE from CASH_SIDE_EMPLOYEES where EM_ID=?";
		return getJdbcTemplate().queryForObject(sql, this, emID);
	}

}
