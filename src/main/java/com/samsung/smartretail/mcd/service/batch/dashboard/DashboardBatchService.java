package com.samsung.smartretail.mcd.service.batch.dashboard;

import java.util.HashMap;

import com.samsung.smartretail.mcd.vo.dashboard.DashboardVO;

public interface DashboardBatchService {
	
	int insertData(int dashboard_index);
	int selectData(int dashboard_index);
	int lastData();

}
