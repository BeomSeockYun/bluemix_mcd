package com.samsung.smartretail.mcd.vo.analytics;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AlertForecastMapper implements RowMapper<AnalyticsVO> {

    @Override
    public AnalyticsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
    AnalyticsVO vo = new AnalyticsVO();
	vo.setEvent_info(rs.getString("event_info"));
	
	return vo;
    }

}
