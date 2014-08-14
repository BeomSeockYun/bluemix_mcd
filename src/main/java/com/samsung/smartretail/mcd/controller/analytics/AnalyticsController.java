package com.samsung.smartretail.mcd.controller.analytics;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.service.analytics.AnalyticsService;
import com.samsung.smartretail.mcd.service.analytics.impl.TestDataInputServiceImpl;
import com.samsung.smartretail.mcd.vo.analytics.AnalyticsVO;

@Controller
public class AnalyticsController {

	final Logger logger = LoggerFactory.getLogger(AnalyticsController.class);

	@Autowired
	private AnalyticsService analyticsService;

	@Autowired
	TestDataInputServiceImpl testDataInput;

	@RequestMapping(value="/insertAnalyticsData", method=RequestMethod.POST)
	@ResponseBody
	public String insertAnalyticsData(AnalyticsVO analyticsData){

		logger.debug("insertAnalyticsData() >>>");

		analyticsService.insertAnalyticsData(analyticsData);

		return "success";

	}

	@RequestMapping(value="/analytics/getEventInfo")
	@ResponseBody
	public  Map<String,Object> getAnalyticsData(){
		Map<String,Object> analyticsList = analyticsService.getAnalyticsData();
		return analyticsList;
	}

	@RequestMapping(value="/analytics/getTrafficInfo")
	@ResponseBody
	public  Map<String,Object> getTrafficInfo(
			@RequestParam(value="start_date") String start_date,
			@RequestParam(value="end_date") String end_date) {

		logger.debug("getTrafficInfo() >>> start::" +start_date+ " ~ end::"+end_date);


		Map<String,Object> result = analyticsService.getTrafficInfo(start_date, end_date);

		return result;
	}

	@RequestMapping(value="/analytics/getActionGuide")
	@ResponseBody
	public  Map<String,Object> getActionGuide(
			@RequestParam(value="eventInfo", required=false) String eventInfo,
			@RequestParam(value="adjustTime") String adjustTime) {

		logger.debug("getActionGuide() >>> eventInfo::" +eventInfo+ " ~ adjustTime::"+adjustTime);


		Map<String,Object> result = analyticsService.getActionGuide(eventInfo, adjustTime);


		return result;
	}

	@RequestMapping(value="/analytics/insertDemodata", method=RequestMethod.POST)
	@ResponseBody
	public  String insertDemodata(
			@RequestParam(value="period_time") String period_time,
			@RequestParam(value="customer_cnt") int customer_cnt){

		analyticsService.insertDemodata(period_time, customer_cnt);

		return "success";
	}

	/**
	 * Insert sample data
	 */
	@RequestMapping(value="/analytics/insertSampleData")
	@ResponseBody
	public  void insertSampleData(){
	    try{
		testDataInput.deleteAnalyticsData();
		testDataInput.insertForecasetData();
	    }catch(Exception e){
		e.printStackTrace();
	    }

	}

}
