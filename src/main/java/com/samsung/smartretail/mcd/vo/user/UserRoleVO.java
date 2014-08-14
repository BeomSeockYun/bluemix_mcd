package com.samsung.smartretail.mcd.vo.user;

public class UserRoleVO {
    private String roleId;
    private String roleName;
    private String category;
    private String description;
    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
	return "UserRole [roleId=" + roleId + ", roleName=" + roleName
		+ ", category=" + category + ", description=" + description
		+ "]";
    }
}
