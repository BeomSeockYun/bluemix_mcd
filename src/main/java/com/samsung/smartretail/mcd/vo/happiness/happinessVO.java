package com.samsung.smartretail.mcd.vo.happiness;

import java.sql.Timestamp;

public class happinessVO {
	
	private int count;
	private Timestamp date;
	private boolean happiness;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public boolean isHappiness() {
		return happiness;
	}
	public void setHappiness(boolean happiness) {
		this.happiness = happiness;
	}
	
	@Override
	public String toString() {
		return "happinessVO [count=" + count + ", date=" + date
				+ ", happiness=" + happiness + "]";
	}
	
	
}
