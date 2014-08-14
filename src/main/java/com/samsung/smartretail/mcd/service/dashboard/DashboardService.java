package com.samsung.smartretail.mcd.service.dashboard;

import java.util.HashMap;
import java.util.List;

import com.samsung.smartretail.mcd.vo.dashboard.DashboardVO;
import com.samsung.smartretail.mcd.vo.happiness.happinessVO;

public interface DashboardService {
	
	List<DashboardVO> getSalesPerformancePrice(String group_id,String start_date,String end_date);
	List<DashboardVO> getSalesPerformanceProduct(String group_id,String sales_date);
	
	List<happinessVO> getCustomerHappiness(String group_id,String start_date,String end_date);
	
	// random한 값을 집어넣음
	int insertDashboardData(String sales_date);
	int insertHappinessData(String date);
	
	// damo 값 넣기
	int insertDamoData(String proudct_name,int product_count);
}
