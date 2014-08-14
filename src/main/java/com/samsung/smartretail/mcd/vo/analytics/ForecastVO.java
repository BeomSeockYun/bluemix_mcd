package com.samsung.smartretail.mcd.vo.analytics;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ForecastVO {
//	private int idx;
	private String event_info;
	private Timestamp period_time;
	private Timestamp traffic_time;
	
	private String traffic_date;
	private String traffic_hour;
	

	private int customer_cnt;
/*	
	private int bigmac_cnt;
	private int beverage_cnt;
	private int frenchfry_cnt;
	
	private int total_kitchen_crew;
	private int total_serving_crew;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
*/	
	public String getEvent_info() {
		return event_info;
	}
	public void setEvent_info(String event_info) {
		this.event_info = event_info;
	}
	public Timestamp getPeriod_time() {
		return period_time;
	}
	public void setPeriod_time(Timestamp period_time) {
		this.period_time = period_time;
	}
	public Timestamp getTraffic_time() {
		return traffic_time;
	}
	public void setTraffic_time(Timestamp traffic_time) {
		this.traffic_time = traffic_time;
	}
	public int getCustomer_cnt() {
		return customer_cnt;
	}
	public void setCustomer_cnt(int customer_cnt) {
		this.customer_cnt = customer_cnt;
	}
/*	
	public int getBigmac_cnt() {
		return bigmac_cnt;
	}
	public void setBigmac_cnt(int bigmac_cnt) {
		this.bigmac_cnt = bigmac_cnt;
	}
	public int getBeverage_cnt() {
		return beverage_cnt;
	}
	public void setBeverage_cnt(int beverage_cnt) {
		this.beverage_cnt = beverage_cnt;
	}
	public int getFrenchfry_cnt() {
		return frenchfry_cnt;
	}
	public void setFrenchfry_cnt(int frenchfry_cnt) {
		this.frenchfry_cnt = frenchfry_cnt;
	}

	public int getTotal_kitchen_crew() {
		return total_kitchen_crew;
	}
	public void setTotal_kitchen_crew(int total_kitchen_crew) {
		this.total_kitchen_crew = total_kitchen_crew;
	}
	public int getTotal_serving_crew() {
		return total_serving_crew;
	}
	public void setTotal_serving_crew(int total_serving_crew) {
		this.total_serving_crew = total_serving_crew;
	}
*/	
	public String getTraffic_date() {
		return traffic_date;
	}
	public void setTraffic_date(String traffic_date) {
		this.traffic_date = traffic_date;
	}
	public String getTraffic_hour() {
		return traffic_hour;
	}
	public void setTraffic_hour(String traffic_hour) {
		this.traffic_hour = traffic_hour;
	}
	
	public void convert2DateHour(){
		
		SimpleDateFormat dFormat = new SimpleDateFormat ( "dd/MMM",Locale.ENGLISH);
		Date dt= new Date(getTraffic_time().getTime());
		 
		String date = dFormat.format(dt);
		
		setTraffic_date(date);
		
		String hour = ""+getTraffic_time().getHours();
		
		setTraffic_hour(hour);
		 
	}
	
	@Override
	public String toString() {
		return "ForecastVO [event_info=" + event_info
				+ ", period_time=" + period_time + ", traffic_time="+ traffic_time
				+ ", traffic_date=" + traffic_date+ ", traffic_hour=" + traffic_hour
				+ ", customer_cnt=" + customer_cnt
				+ "]";
	}
			
}
