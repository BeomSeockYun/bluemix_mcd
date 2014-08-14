package com.samsung.smartretail.mcd.vo.dashboard;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class dashbpardRowMapper implements RowMapper<DashboardVO>{

	@Override
	public DashboardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DashboardVO dvo = new DashboardVO();
		dvo.setIdx(rs.getInt("idx"));
		
		return dvo;
	}

}
