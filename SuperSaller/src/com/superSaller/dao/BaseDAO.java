package com.superSaller.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class BaseDAO<T> extends JdbcDaoSupport implements RowMapper<T> {
	@Resource(name = "oracleDataSource")
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	protected static String contactSqlFieds(String... fileds) {
		String contacted = " ";
		for (int i = 0; i < fileds.length; i++) {
			if (i == (fileds.length - 1)) {
				contacted += fileds[i] + " ";
			} else {
				contacted += fileds[i] + ",";
			}
		}
		return contacted;
	}
}
