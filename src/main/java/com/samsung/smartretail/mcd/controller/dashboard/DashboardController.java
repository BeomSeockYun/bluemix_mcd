package com.samsung.smartretail.mcd.controller.dashboard;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.service.dashboard.DashboardService;
import com.samsung.smartretail.mcd.vo.dashboard.DashboardVO;
import com.samsung.smartretail.mcd.vo.happiness.happinessVO;

@Controller
@RequestMapping(value="/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(value="/getSalesPerformancePrice", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getSalesPerformancePrice(
			@RequestParam(value="group_id") String group_id,
			@RequestParam(value="start_date" , required=false) String start_date,
			@RequestParam(value="end_date" , required=false) String end_date
			){

		List<DashboardVO> dashList = dashboardService.getSalesPerformancePrice(group_id, start_date, end_date);

		// json 형태로 파싱
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String, String>> priceinfo = new ArrayList<Map<String, String>>();

		for(int i=0;i<dashList.size();i++){
			Map<String,String> temp = new HashMap<String,String>();
			temp.put("sales_date", dashList.get(i).getSales_date().toString());
			temp.put("total_price", Integer.toString(dashList.get(i).getTotal_price()));

			priceinfo.add(temp);
		}
		result.put("totalCount", dashList.size());
		result.put("priceinfo", priceinfo);	

		return result;
	}

	@RequestMapping(value="getSalesPerformanceProduct", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getSalesPerformanceProduct(
			@RequestParam(value="group_id") String group_id,
			@RequestParam(value="sales_date" , required=false) String sales_date
			){

		List<DashboardVO> dashList = dashboardService.getSalesPerformanceProduct(group_id,sales_date);
		
		// list가 없을경우
		if(dashList.isEmpty()){
			return null;
		}
			
		// json 형태로 파싱
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String, String>> productinfo = new ArrayList<Map<String, String>>();

		for(int i=0;i<dashList.size();i++){
			Map<String,String> temp = new HashMap<String,String>();
			temp.put("rank", Integer.toString(dashList.get(i).getRank()));
			temp.put("product_name", dashList.get(i).getProduct_name());
			temp.put("product_count", Integer.toString(dashList.get(i).getProduct_count()));
			temp.put("product_price", Integer.toString(dashList.get(i).getProduct_price()));

			productinfo.add(temp);
		}
		
		if( dashList.get(0).getSales_date() != null){
			result.put("sales_date", dashList.get(0).getSales_date().toString());
		}
		
		result.put("productinfo", productinfo);	

		return result;
	}
	
	@RequestMapping(value="/getCustomerHappiness", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getCustomerHappiness(
			@RequestParam(value="group_id") String group_id,
			@RequestParam(value="start_date" , required=false) String start_date,
			@RequestParam(value="end_date" , required=false) String end_date
			){

		List<happinessVO> happyList = dashboardService.getCustomerHappiness(group_id, start_date, end_date);

		// json 형태로 파싱
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String, String>> happinessinfo = new ArrayList<Map<String, String>>();
		int totalCount = 0;
		
		for(int i=0;i<happyList.size();i++){
			Map<String,String> temp = new HashMap<String,String>();
			String prev_date = happyList.get(i).getDate().toString();
			temp.put("sales_date", prev_date);
			totalCount += 1;

			if(happyList.get(i).isHappiness()){
				temp.put("praises", Integer.toString(happyList.get(i).getCount()));
			}else{
				temp.put("complaints", Integer.toString(happyList.get(i).getCount()));
			}
			
			if(i != happyList.size()-1){
				String next_date = happyList.get(i+1).getDate().toString();
				prev_date = prev_date.substring(0, 10);
				next_date = next_date.substring(0, 10);
				
				if(prev_date.equals(next_date)){
					if(happyList.get(i+1).isHappiness()){
						temp.put("praises", Integer.toString(happyList.get(i+1).getCount()));
					}else{
						temp.put("complaints", Integer.toString(happyList.get(i+1).getCount()));
					}
					i += 1;
				}
			}
			
			happinessinfo.add(temp);
		}
		
		result.put("totalCount", totalCount);
		result.put("happinessinfo", happinessinfo);
		
		return result;
	}
	
	@RequestMapping(value="insertDashboardData" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertDashboardData(
			@RequestParam(value="sales_date") String sales_date
			){
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		dashboardService.insertDashboardData(sales_date);
		
		result.put("result", "success");
		
		return result;
	}
	
	@RequestMapping(value="insertHappinessData",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> insertHappinessData(
			@RequestParam(value="date") String date
			){
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		dashboardService.insertHappinessData(date);
		
		result.put("result", "success");
		return result;
	}
	
	@RequestMapping(value="insertDamoData",method=RequestMethod.POST)
	@ResponseBody
	public String insertDamoData(
			@RequestParam(value="product_name") String proudct_name,
			@RequestParam(value="product_count") int product_count
			){
		
		dashboardService.insertDamoData(proudct_name, product_count);
	
		return "success";
	}
}

