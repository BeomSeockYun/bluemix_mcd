package com.samsung.smartretail.mcd.dao.analytics;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.analytics.AnalyticsVO;
import com.samsung.smartretail.mcd.vo.analytics.ForecastVO;
import com.samsung.smartretail.mcd.vo.analytics.PastVisitorInfo;
import com.samsung.smartretail.mcd.vo.analytics.TodayVisitorInfo;

@Repository(value="AnalyticsMapper")
public interface AnalyticsMapper {

	int insertAnalyticsData(AnalyticsVO avo);
	List<AnalyticsVO> getAnalytics();
	List<ForecastVO> getForecastData(Map<String, Object> map);
	List<PastVisitorInfo> getPastInfo(Map<String, Object> map);
	List<TodayVisitorInfo> getTodayInfo(Map<String, Object> map);

	int insertDemodata(Map<String, Object> map);
	int insertAlertdata();

	int insertForecastData(@Param (value="idx") int idx , @Param(value = "period_time") Timestamp period_time,
		@Param(value = "traffic_time") Timestamp traffic_time,@Param(value = "customer_count") int customer_cnt);

	int insertHistoryData(@Param (value="idx") int idx , @Param(value = "period_time") Timestamp period_time,
		@Param(value = "customer_count") int customer_cnt);

	int insertTodayData(@Param (value="idx") int idx , @Param(value = "period_time") Timestamp period_time,
		@Param(value = "customer_count") int customer_cnt);

	int deleteForecastInfo();
	int deleteTodayInfo();
	int deleteHistoryInfo();

}
