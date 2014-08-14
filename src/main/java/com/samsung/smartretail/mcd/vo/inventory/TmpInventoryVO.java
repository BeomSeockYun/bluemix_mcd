package com.samsung.smartretail.mcd.vo.inventory;


public class TmpInventoryVO {
    
    private String itemId;
    private String itemName;
    private String groupId;
    private String groupName;
    private int currentLevel;
    private int minimumLevel;
    private int alarmLevel;
    private int recommendedLevel;
    private String categoryId;
    private String categoryName;
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

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

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getMinimumLevel() {
        return minimumLevel;
    }

    public void setMinimumLevel(int minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    public int getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(int alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public int getRecommendedLevel() {
        return recommendedLevel;
    }

    public void setRecommendedLevel(int recommendedLevel) {
        this.recommendedLevel = recommendedLevel;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
	return "InventoryVO [itemId=" + itemId + ", itemName=" + itemName
		+ ", groupId=" + groupId + ", groupName=" + groupName
		+ ", currentLevel=" + currentLevel + ", minimumLevel="
		+ minimumLevel + ", alarmLevel=" + alarmLevel
		+ ", recommendedLevel=" + recommendedLevel + ", categoryId="
		+ categoryId + ", categoryName=" + categoryName + "]";
    }
    
    
}
