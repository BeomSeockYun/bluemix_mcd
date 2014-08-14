package com.samsung.smartretail.mcd.vo.auth.login;

import java.sql.Timestamp;

public class loginVO {
	private String userId;
	private String password;
	private boolean is_account_non_expired;
	private boolean is_account_non_locked;
	private boolean is_credentials_non_expired;
	private boolean is_enabled;
	private int unlock_try;
	private Timestamp account_expire_date;
	private Timestamp cedentials_expire_date;
	private Timestamp disabled_date;
	private String push_register_key;	//Get RegistrationID
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIs_account_non_expired() {
		return is_account_non_expired;
	}
	public void setIs_account_non_expired(boolean is_account_non_expired) {
		this.is_account_non_expired = is_account_non_expired;
	}
	public boolean isIs_account_non_locked() {
		return is_account_non_locked;
	}
	public void setIs_account_non_locked(boolean is_account_non_locked) {
		this.is_account_non_locked = is_account_non_locked;
	}
	public boolean isIs_credentials_non_expired() {
		return is_credentials_non_expired;
	}
	public void setIs_credentials_non_expired(boolean is_credentials_non_expired) {
		this.is_credentials_non_expired = is_credentials_non_expired;
	}
	public boolean isIs_enabled() {
		return is_enabled;
	}
	public void setIs_enabled(boolean is_enabled) {
		this.is_enabled = is_enabled;
	}
	public int getUnlock_try() {
		return unlock_try;
	}
	public void setUnlock_try(int unlock_try) {
		this.unlock_try = unlock_try;
	}
	public Timestamp getAccount_expire_date() {
		return account_expire_date;
	}
	public void setAccount_expire_date(Timestamp account_expire_date) {
		this.account_expire_date = account_expire_date;
	}
	public Timestamp getCedentials_expire_date() {
		return cedentials_expire_date;
	}
	public void setCedentials_expire_date(Timestamp cedentials_expire_date) {
		this.cedentials_expire_date = cedentials_expire_date;
	}
	public Timestamp getDisabled_date() {
		return disabled_date;
	}
	public void setDisabled_date(Timestamp disabled_date) {
		this.disabled_date = disabled_date;
	}
	
	public String getPush_register_key() {
		return push_register_key;
	}
	public void setPush_register_key(String push_register_key) {
		this.push_register_key = push_register_key;
	}
	
	@Override
	public String toString() {
		return "loginVO [userId=" + userId + ", password=" + password
				+ ", is_account_non_expired=" + is_account_non_expired
				+ ", is_account_non_locked=" + is_account_non_locked
				+ ", is_credentials_non_expired=" + is_credentials_non_expired
				+ ", is_enabled=" + is_enabled + ", unlock_try=" + unlock_try
				+ ", account_expire_date=" + account_expire_date
				+ ", cedentials_expire_date=" + cedentials_expire_date
				+ ", disabled_date=" + disabled_date + "]";
	}
	
}
