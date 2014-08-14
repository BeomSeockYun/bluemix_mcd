package com.samsung.smartretail.mcd.service.analytics;

import java.util.List;
import java.util.Map;

import com.samsung.smartretail.mcd.vo.analytics.AnalyticsVO;
import com.samsung.smartretail.mcd.vo.analytics.ForecastVO;
import com.samsung.smartretail.mcd.vo.analytics.PastVisitorInfo;
import com.samsung.smartretail.mcd.vo.analytics.TodayVisitorInfo;

public interface AnalyticsService {
	
	int insertAnalyticsData(AnalyticsVO avo);
	Map<String, Object> getAnalyticsData();	
	Map<String, Object> getTrafficInfo(String start_date, String end_date);
	
	List<ForecastVO> getForecastData(Map<String, Object> map);
	List<PastVisitorInfo> getPastInfo(Map<String, Object> map);
	List<TodayVisitorInfo> getTodayInfo(Map<String, Object> map);
	
	Map<String, Object> getActionGuide(String eventInfo, String adjustTime);

	int insertDemodata(String period_time,int customer_cnt);
}
