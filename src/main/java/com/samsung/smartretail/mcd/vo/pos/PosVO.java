package com.samsung.smartretail.mcd.vo.pos;

public class PosVO {
	
	private int idx;
	private String product_name;
	private String product_price;
	private int product_count;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	
	@Override
	public String toString() {
		return "PosVO [idx=" + idx + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", product_count="
				+ product_count + "]";
	}
	
}
