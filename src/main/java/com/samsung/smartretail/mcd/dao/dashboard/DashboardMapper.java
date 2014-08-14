package com.samsung.smartretail.mcd.dao.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.dashboard.DashboardVO;
import com.samsung.smartretail.mcd.vo.happiness.happinessVO;

@Repository(value="DashboardMapper")
public interface DashboardMapper {

	List<DashboardVO> getSalesPerformancePrice(HashMap<String, Object> map);
	List<DashboardVO> getSalesPerformanceProduct(DashboardVO dvo);
	List<happinessVO> getCustomerHappiness(HashMap<String, Object> map);
	
	// random한 값을 집어넣음
	int insertDashboardData(HashMap<String, Object> map);
	int insertHappinessData(HashMap<String, Object> map);
	
	// demo 값을 집어 넣음
	int insertDemoData(Map<String, Object> map);
	
	// 최대값 리턴
	int selectMaxIndex();
	
	// switch 값 집어 넣음
	int insertSwitchData(Map<String, Object> map);
}

