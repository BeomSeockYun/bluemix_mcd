package com.samsung.smartretail.mcd.vo.analytics;

import java.sql.Timestamp;

public class TodayVisitorInfo {
//	private int idx;
	private Timestamp period_time;
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
	public Timestamp getPeriod_time() {
		return period_time;
	}
	public void setPeriod_time(Timestamp period_time) {
		this.period_time = period_time;
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
	@Override
	public String toString() {
		return "TodayVisitorInfo [period_time=" + period_time
				+ ", customer_cnt=" + customer_cnt + "]";
	}
		
}
