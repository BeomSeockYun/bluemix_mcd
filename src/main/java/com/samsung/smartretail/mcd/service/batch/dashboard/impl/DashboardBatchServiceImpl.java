package com.samsung.smartretail.mcd.service.batch.dashboard.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.batch.dashboard.DashboardBatchMapper;
import com.samsung.smartretail.mcd.service.batch.dashboard.DashboardBatchService;

@Service
public class DashboardBatchServiceImpl implements DashboardBatchService {
	
	@Autowired
	private DashboardBatchMapper dashboardBatchMapper;

	@Override
	public int insertData(int dashboard_index) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("dashboard_index", dashboard_index);
		
		dashboardBatchMapper.insertData(map);		
		
		return 0;
	}

	@Override
	public int selectData(int dashboard_index) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("dashboard_index", dashboard_index);
		
		return dashboardBatchMapper.selectData(map);
	}

	@Override
	public int lastData() {
		
		return dashboardBatchMapper.lastData();
	}

}
