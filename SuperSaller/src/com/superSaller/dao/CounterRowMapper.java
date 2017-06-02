package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CounterRowMapper implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt("counter");
	}

}
