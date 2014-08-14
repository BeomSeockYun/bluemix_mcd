package com.samsung.smartretail.mcd.vo.user;

import java.util.List;

import com.samsung.smartretail.mcd.vo.group.GroupVO;

public class UserVO {
    private String userId;
    private String userName;
    private String cellPhoneNr;
    private String email;
    private String birthday;
    private String anniversaryDay;
    private String push_register_key;
/*    private String groupId;
    private String roleId;*/
    
    public String getPush_register_key() {
		return push_register_key;
	}

	public void setPush_register_key(String push_register_key) {
		this.push_register_key = push_register_key;
	}

	private GroupVO group;
    
    //여러개의 role 을 갖을수도.
    private List<UserRoleVO> role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCellPhoneNr() {
        return cellPhoneNr;
    }

    public void setCellPhoneNr(String cellPhoneNr) {
        this.cellPhoneNr = cellPhoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAnniversaryDay() {
        return anniversaryDay;
    }

    public void setAnniversaryDay(String anniversaryDay) {
        this.anniversaryDay = anniversaryDay;
    }

    public GroupVO getGroup() {
        return group;
    }

    public void setGroup(GroupVO group) {
        this.group = group;
    }

    public List<UserRoleVO> getRole() {
        return role;
    }

    public void setRole(List<UserRoleVO> role) {
        this.role = role;
    }
/*
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }*/

    @Override
    public String toString() {
	return "UserVO [userId=" + userId + ", userName=" + userName
		+ ", cellPhoneNr=" + cellPhoneNr + ", email=" + email
		+ ", birthday=" + birthday + ", anniversaryDay="
		+ anniversaryDay + ", group=" + group + ", role=" + role + "]";
    }
}
