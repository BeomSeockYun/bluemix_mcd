package com.samsung.smartretail.mcd.vo.dashboard;

import java.sql.Timestamp;

public class DashboardVO {

	private int idx;
	private String group_id;
	private String product_id;
	private String product_name;
	private int product_count;
	private int product_price;
	private int total_price;
	
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	private Timestamp sales_date;
	private int rank;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public Timestamp getSales_date() {
		return sales_date;
	}
	public void setSales_date(Timestamp sales_date) {
		this.sales_date = sales_date;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "DashboardVO [idx=" + idx + ", group_id=" + group_id
				+ ", product_id=" + product_id + ", product_name="
				+ product_name + ", product_count=" + product_count
				+ ", product_price=" + product_price + ", sales_date="
				+ sales_date + ", rank=" + rank + "]";
	}
	
}
