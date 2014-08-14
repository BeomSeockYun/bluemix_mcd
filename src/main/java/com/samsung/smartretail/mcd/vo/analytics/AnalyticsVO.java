package com.samsung.smartretail.mcd.vo.analytics;

import java.sql.Timestamp;

public class AnalyticsVO {
	private int idx;
	private String event_info;
//	private String event_type;
	private int attendance_group;
	private int attendance_count;
	private Timestamp start_schedule;
	private Timestamp end_schecule;
	private String location;
	private String distance;
	private Timestamp alert_time;
	private boolean alert_confirm;

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getEvent_info() {
		return event_info;
	}
	public void setEvent_info(String event_info) {
		this.event_info = event_info;
	}	
/*	
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
*/	
	public int getAttendance_group() {
		return attendance_group;
	}
	public void setAttendance_group(int attendance_group) {
		this.attendance_group = attendance_group;
	}
	public int getAttendance_count() {
		return attendance_count;
	}
	public void setAttendance_count(int attendance_count) {
		this.attendance_count = attendance_count;
	}
	public Timestamp getStart_schedule() {
		return start_schedule;
	}
	public void setStart_schedule(Timestamp start_schedule) {
		this.start_schedule = start_schedule;
	}
	public Timestamp getEnd_schecule() {
		return end_schecule;
	}
	public void setEnd_schecule(Timestamp end_schecule) {
		this.end_schecule = end_schecule;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public Timestamp getAlert_time() {
		return alert_time;
	}
	public void setAlert_time(Timestamp alert_time) {
		this.alert_time = alert_time;
	}
	public boolean isAlert_confirm() {
		return alert_confirm;
	}
	public void setAlert_confirm(boolean alert_confirm) {
		this.alert_confirm = alert_confirm;
	}
	@Override
	public String toString() {
		return "AnalyticsVO [idx=" + idx +", event_info=" + event_info
				+ ", event_type=" + /*event_type +*/ ", attendance_group="
				+ attendance_group + ", attendance_count=" + attendance_count
				+ ", start_schedule=" + start_schedule + ", end_schecule="
				+ end_schecule + ", location=" + location + ", distance="
				+ distance + ", alert_time=" + alert_time + ", alert_confirm="
				+ alert_confirm + "]";
	}
	
}
