package com.samsung.smartretail.mcd.service.dashboard.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.dashboard.DashboardMapper;
import com.samsung.smartretail.mcd.service.dashboard.DashboardService;
import com.samsung.smartretail.mcd.vo.dashboard.DashboardVO;
import com.samsung.smartretail.mcd.vo.happiness.happinessVO;

@Service
public class DashboardImpl implements DashboardService{

	@Autowired
	private DashboardMapper dashboardMapper;

	@Override
	public List<DashboardVO> getSalesPerformancePrice(String group_id,
			String temp_start_date, String temp_end_date) {

		Timestamp start_date = null;
		Timestamp end_date = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);



		if(temp_start_date != null) {
			temp_start_date += " 00:00:00";
			start_date = new Timestamp(0);
			start_date = start_date.valueOf(temp_start_date);
		}

		if(temp_end_date != null) {
			temp_end_date += " 00:00:00";
			end_date = new Timestamp(0);
			end_date = end_date.valueOf(temp_end_date);
		}

		map.put("start_date", start_date);
		map.put("end_date", end_date);

		List<DashboardVO> dashList = dashboardMapper.getSalesPerformancePrice(map);

		return dashList;
	}

	@Override
	public List<DashboardVO> getSalesPerformanceProduct(String group_id, String temp_date) {

		DashboardVO dvo = new DashboardVO();
		dvo.setGroup_id(group_id);
		Timestamp sales_date = null;

		if(temp_date != null){
			temp_date += " 00:00:00";
			sales_date = new Timestamp(0);
			sales_date = sales_date.valueOf(temp_date);
		}

		dvo.setSales_date(sales_date);

		List<DashboardVO> dashList = dashboardMapper.getSalesPerformanceProduct(dvo);

		// 순위를 정해준다.
		for(int i=0;i<dashList.size();i++){
			dashList.get(i).setRank(i+1);
		}

		return dashList;
	}

	@Override
	public List<happinessVO> getCustomerHappiness(String group_id,
			String temp_start_date, String temp_end_date) {

		Timestamp start_date = null;
		Timestamp end_date = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);

		if(temp_start_date != null) {
			temp_start_date += " 00:00:00";
			start_date = new Timestamp(0);
			start_date = start_date.valueOf(temp_start_date);
		}

		if(temp_end_date != null) {
			temp_end_date += " 00:00:00";
			end_date = new Timestamp(0);
			end_date = end_date.valueOf(temp_end_date);
		}

		map.put("start_date", start_date);
		map.put("end_date", end_date);

		List<happinessVO> happyList = dashboardMapper.getCustomerHappiness(map);

		return happyList;
	}

	@Override
	public int insertDashboardData(String temp_date) {

		String group_id = "mcd_0001";
		int product_count = 0;
		int product_total_price = 0;

		List<String> product_id_list = new ArrayList<String>();
		product_id_list.add("prod_mcd_0001");
		product_id_list.add("prod_mcd_0002");
		product_id_list.add("prod_mcd_0003");
		product_id_list.add("prod_mcd_0004");
		product_id_list.add("prod_mcd_0005");

		List<String> product_name_list = new ArrayList<String>();
		product_name_list.add("Big Mac");
		product_name_list.add("Daily Double");
		product_name_list.add("Veggle Burger");
		product_name_list.add("Crunch Burger");
		product_name_list.add("Quarter Pounder With Cheese");

		List<Integer> product_price_list = new ArrayList<Integer>();
		product_price_list.add(5000);
		product_price_list.add(4000);
		product_price_list.add(3000);
		product_price_list.add(2000);
		product_price_list.add(1800);


		// 기준값
		int mi = 1000*60;
		int hr = mi*60;
		int dy = hr*24;
		//long timestamp = new Date().getTime();


		for(int i=0;i<200;i++){
			HashMap<String, Object> map = new HashMap<String, Object>();

			// product_id, product_name, product_price 를 위한 random 값
			int id_random = (int)(Math.random() * 5);

			map.put("group_id", group_id);
			map.put("product_id", product_id_list.get(id_random));
			map.put("product_name", product_name_list.get(id_random));
			map.put("product_price", product_price_list.get(id_random));

			// product_count random 값
			product_count = 1 + (int)(Math.random() * 5);
			map.put("product_count", product_count);
			map.put("product_total_price", (product_price_list.get(id_random)*product_count));

			// 날짜 random값
			//Date temp_date = new Date();

			/*int day = dy*2; * (1 + (int)(Math.random() * 4));
			int hour = hr * (1 + (int)(Math.random() * 8));
			int seconds = 1000 * (1 + (int)(Math.random() * 59));
			int minutes = seconds * (1 + (int)(Math.random() * 59));

			temp_date.setTime(timestamp+(day-hour+minutes+seconds));
			 */

			String getCurrentDate = temp_date;

			Timestamp sales_date = new Timestamp(0);


			int hour = (1 + (int)(Math.random() * 23));
			int minutes = (1 + (int)(Math.random() * 59));
			int seconds = (1 + (int)(Math.random() * 59));

			getCurrentDate += " "+hour+":"+minutes+":"+seconds;

			//System.out.println(getCurrentDate);

			sales_date = sales_date.valueOf(getCurrentDate);
			map.put("sales_date", sales_date);

			//System.out.println(map.get("sales_date").toString());

			dashboardMapper.insertDashboardData(map);
		}

		return 0;
	}

	@Override
	public int insertHappinessData(String temp_date) {

		String group_id = "mcd_0001";

		// 기준값
		/*	int mi = 1000*60;
		int hr = mi*60;
		int dy = hr*24;
		long timestamp = new Date().getTime();*/

		for(int i=0;i<200;i++){

			int happiness = (int)(Math.random()*2);
			int product_idx = 1 + (int)(Math.random()*9);

			// 날짜 random값
			String getCurrentDate = temp_date;

			Timestamp date = new Timestamp(0);


			int hour = (1 + (int)(Math.random() * 23));
			int minutes = (1 + (int)(Math.random() * 59));
			int seconds = (1 + (int)(Math.random() * 59));

			getCurrentDate += " "+hour+":"+minutes+":"+seconds;

			//System.out.println(getCurrentDate);

			date = date.valueOf(getCurrentDate);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("group_id", group_id);
			map.put("happiness", happiness);
			map.put("product_idx", product_idx);
			map.put("date", date);

			//ystem.out.println(map.get("date").toString());

			dashboardMapper.insertHappinessData(map);

		}

		return 0;
	}

	@Override
	public int insertDamoData(String proudct_name, int product_count) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("group_id", "mcd_0001");
		map.put("product_name", proudct_name);

		if(proudct_name.equals("Big Mac")){

			map.put("product_id", "prod_mcd_0001");
			map.put("product_price", 5000);

		} else if(proudct_name.equals("Daily Double")){

			map.put("product_id", "prod_mcd_0002");
			map.put("product_price", 4000);

		} else if(proudct_name.equals("Veggle Burger"))
		{
			map.put("product_id", "prod_mcd_0003");
			map.put("product_price", 3000);

		} else if(proudct_name.equals("Crunch Burger")){

			map.put("product_id", "prod_mcd_0004");
			map.put("product_price", 2000);

		} else {

			map.put("product_id", "prod_mcd_0005");
			map.put("product_price", 1800);

		}

		map.put("product_count", product_count);
		map.put("product_total_price", (Integer)map.get("product_price")*product_count);

		// db에 insert
		dashboardMapper.insertDemoData(map);

		// switch에 insert
		int last_idx = dashboardMapper.selectMaxIndex();

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("dashboard_index", last_idx);
		map2.put("dashboard_switch", false);

		dashboardMapper.insertSwitchData(map2);

		return 0;
	}

	private String setOperationDate(String mode, int value) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar cal = new GregorianCalendar();

		if (mode.equals("plus")) {
			cal.add(Calendar.DATE, value); // ���糯¥�� value ���� ���Ѵ�.
		} else if (mode.equals("minus")) {
			cal.add(Calendar.DATE, value); // ���糯¥�� value ���� ����.
		}

		Date date = cal.getTime(); // ����� ���ڸ� ��.
		String setDate = fmt.format(date);

		return setDate;
	}

}
