package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.superSaller.beans.persons.entities.CashSideEmployee;
import com.superSaller.beans.persons.entities.EmRole;

@Service(value = "cashSideEmDAO")
public class CashSideEmployeeDAO extends BaseDAO<CashSideEmployee> {
	public final static String emIDCol = "EM_ID";
	public final static String emRoleCol = "EM_ROLE";
	public final static String table = "CASH_SIDE_EMPLOYEES";
	public final static String fromTable = "from " + table;
	public final static String fromTableWhere = fromTable + " where ";
	public final static String allFields = contactSqlFieds(emIDCol, emRoleCol);

	@Override
	public CashSideEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
		CashSideEmployee employee = new CashSideEmployee();
		employee.setEmID(rs.getString("EM_ID"));
		employee.setEmRole(EmRole.valueOf(rs.getString("EM_ROLE")));
		return employee;
	}

	public CashSideEmployee queryEmployeeByID(String emID) {
		String sql = "select " + allFields + fromTableWhere + emIDCol + "=?";
		return getJdbcTemplate().queryForObject(sql, this, emID);
	}

	public List<CashSideEmployee> queryAllEm() {
		String querySql = "select" + allFields + fromTable;
		return getJdbcTemplate().query(querySql, this);
	}

	public Boolean deleteEm(String emID) {
		String deleteSql = "delete " + fromTableWhere + emIDCol + "=?";
		System.out.println(deleteSql + emID);
		int r = getJdbcTemplate().update(deleteSql, emID);
		return r == 1;
	}

}
