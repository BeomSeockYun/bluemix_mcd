package com.samsung.smartretail.mcd.vo.inventory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RefillRowMapper implements RowMapper<StockActionHistoryVO> {

    @Override
    public StockActionHistoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	StockActionHistoryVO vo = new StockActionHistoryVO();
	vo.setSn(rs.getInt("sn"));
	vo.setItemId(rs.getString("item_id"));
	vo.setGroupId(rs.getString("group_id"));
	vo.setValueOfStock(rs.getInt("value_of_stock"));
	vo.setOpDate(rs.getString("op_date"));
	
	return vo;
    }

}
