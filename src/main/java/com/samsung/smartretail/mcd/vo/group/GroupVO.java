package com.samsung.smartretail.mcd.vo.group;

public class GroupVO {
    private String groupId;
    private String groupName;
    private String groupDesc;
    private String address;
    private String groupTelNr;
    private String email;
    private String anniversaryDay;
    private int isActive;
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupDesc() {
        return groupDesc;
    }
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGroupTelNr() {
        return groupTelNr;
    }
    public void setGroupTelNr(String groupTelNr) {
        this.groupTelNr = groupTelNr;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAnniversaryDay() {
        return anniversaryDay;
    }
    public void setAnniversaryDay(String anniversaryDay) {
        this.anniversaryDay = anniversaryDay;
    }
    public int getIsActive() {
        return isActive;
    }
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    @Override
    public String toString() {
	return "GroupVO [groupId=" + groupId + ", groupName=" + groupName
		+ ", groupDesc=" + groupDesc + ", address=" + address
		+ ", groupTelNr=" + groupTelNr + ", email=" + email
		+ ", anniversaryDay=" + anniversaryDay + ", isActive="
		+ isActive + "]";
    }
}
