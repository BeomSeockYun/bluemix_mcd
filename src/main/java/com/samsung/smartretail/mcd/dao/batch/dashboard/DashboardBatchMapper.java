package com.samsung.smartretail.mcd.dao.batch.dashboard;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("DashboardBatchMapper")
public interface DashboardBatchMapper {

	int insertData(Map<String, Object> map);
	int selectData(Map<String, Object> map);
	int lastData();
	
}
