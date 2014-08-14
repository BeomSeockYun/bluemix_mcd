package com.samsung.smartretail.mcd.vo.preparation;

import java.sql.Timestamp;

public class PreparationVO {
	
	private int idx;
	private String to_do_id;
	private String owner_id;
	private boolean is_checked;
	private boolean is_canceled;
	private boolean is_modified;
	private boolean is_new;
	private String title;
	private String category;
	private String detail;
	private String comment;
	private Timestamp create_date;
	private String created_by;
	private Timestamp remind_date;
	private Timestamp start_date;
	private Timestamp end_date;
	private Timestamp checked_date;
	private int priority;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getto_do_id() {
		return to_do_id;
	}
	public void setto_do_id(String to_do_id) {
		this.to_do_id = to_do_id;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public boolean isIs_checked() {
		return is_checked;
	}
	public void setIs_checked(boolean is_checked) {
		this.is_checked = is_checked;
	}
	public boolean isIs_canceled() {
		return is_canceled;
	}
	public void setIs_canceled(boolean is_canceled) {
		this.is_canceled = is_canceled;
	}
	public boolean isIs_modified() {
		return is_modified;
	}
	public void setIs_modified(boolean is_modified) {
		this.is_modified = is_modified;
	}
	public boolean isIs_new() {
		return is_new;
	}
	public void setIs_new(boolean is_new) {
		this.is_new = is_new;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Timestamp getRemind_date() {
		return remind_date;
	}
	public void setRemind_date(Timestamp remind_date) {
		this.remind_date = remind_date;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public Timestamp getChecked_date() {
		return checked_date;
	}
	public void setChecked_date(Timestamp checked_date) {
		this.checked_date = checked_date;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "PreparationVO [idx=" + idx + ", to_do_id=" + to_do_id
				+ ", owner_id=" + owner_id + ", is_checked=" + is_checked
				+ ", is_canceled=" + is_canceled + ", is_modified="
				+ is_modified + ", is_new=" + is_new + ", title=" + title
				+ ", category=" + category + ", detail=" + detail
				+ ", comment=" + comment + ", create_date=" + create_date
				+ ", created_by=" + created_by + ", remind_date=" + remind_date
				+ ", start_date=" + start_date + ", end_date=" + end_date
				+ ", checked_date=" + checked_date + ", priority=" + priority
				+ "]";
	}
	
}
