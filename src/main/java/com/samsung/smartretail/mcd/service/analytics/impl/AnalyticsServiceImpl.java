package com.samsung.smartretail.mcd.service.analytics.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.analytics.AnalyticsMapper;
import com.samsung.smartretail.mcd.service.analytics.AnalyticsService;
import com.samsung.smartretail.mcd.vo.analytics.AnalyticsVO;
import com.samsung.smartretail.mcd.vo.analytics.ForecastVO;
import com.samsung.smartretail.mcd.vo.analytics.PastVisitorInfo;
import com.samsung.smartretail.mcd.vo.analytics.TodayVisitorInfo;


@Service
public class AnalyticsServiceImpl implements AnalyticsService {

	final Logger logger = LoggerFactory.getLogger(AnalyticsServiceImpl.class);

	@Autowired
	private AnalyticsMapper analyticsMapper;

	@Override
	public int insertAnalyticsData(AnalyticsVO avo) {

		logger.debug("insertAnalyticsData() >>> ");

		return analyticsMapper.insertAnalyticsData(avo);
	}

	@Override
	public Map<String, Object> getAnalyticsData() {

		logger.debug("getAnalyticsData() >>> ");

		Map<String,Object> result = new HashMap<String,Object>();
		/*
		List<String> eventType = new ArrayList<String>();
		eventType.add(0, "RefillOrder");
		eventType.add(1, "CrewShift");
		eventType.add(2, "WorkOrder");
		eventType.add(3, "etc");
		result.put("eventType", eventType);
		 */				
		List<AnalyticsVO> alist = analyticsMapper.getAnalytics();
		result.put("detailInfo", alist);

		result.put("alertConfirm", "checked");
		return result;
	}

	@Override
	public Map<String, Object> getTrafficInfo(String start_date, String end_date) {

		logger.debug("getTrafficInfo() >>>  "+start_date+ " "+end_date);

		Map<String, Object> ret = new HashMap<String, Object>();


		//		ret.put("date", "2014-07-07 07:07:07");
		ret.put("start_date", start_date);
		ret.put("end_date", end_date);

		List<ForecastVO> flist = this.getForecastData(ret);
		List<PastVisitorInfo> plist = this.getPastInfo(ret);
		List<TodayVisitorInfo> tlist = this.getTodayInfo(ret);

		ret.put("forecast", flist);
		ret.put("past", plist);
		ret.put("realtime", tlist);
		return ret;		
	}

	@Override
	public List<ForecastVO> getForecastData(Map<String, Object> map) {
		List<ForecastVO> tempList = analyticsMapper.getForecastData(map);

		for (ForecastVO f:tempList ){

			//f.convert2DateHour();

		}

		return tempList;
	}	

	@Override
	public List<PastVisitorInfo> getPastInfo(Map<String, Object> map) {		
		List<PastVisitorInfo> tempList = analyticsMapper.getPastInfo(map);
		return tempList;
	}

	@Override
	public List<TodayVisitorInfo> getTodayInfo(Map<String, Object> map) {
		List<TodayVisitorInfo> tempList = analyticsMapper.getTodayInfo(map);
		return tempList;
	}

	@Override
	public Map<String, Object> getActionGuide(String eventInfo, String adjustTime) {

		Map<String, Object> ret = new HashMap<String, Object>();

		List<String> RO = new ArrayList<String>();
		RO.add(0, "1 available crew on prep.line");
		ret.put("Crew Shift", RO);

		List<String> CS = new ArrayList<String>();
		CS.add(0, "High");
		ret.put("UHC Level", CS);

		return ret;		
	}

	@Override
	public int insertDemodata(String period_time, int customer_cnt) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("period_time", period_time);
		map.put("customer_cnt", customer_cnt);

		analyticsMapper.insertDemodata(map);
		analyticsMapper.insertAlertdata();

		return 0;
	}	

}
