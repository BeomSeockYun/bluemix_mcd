package com.samsung.smartretail.mcd.vo.inventory;

public class StockInventoryVO {
    private String itemId;
    private String groupId;
    private int currentLevel;
    private int minimumLevel;
    private int alarmLevel;
    private int recommendedLevel;
    private String categoryId;
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
    @Override
    public String toString() {
	return "ItemVo [itemId=" + itemId + ", groupId=" + groupId
		+ ", currentLevel=" + currentLevel + ", minimumLevel="
		+ minimumLevel + ", alarmLevel=" + alarmLevel
		+ ", recommendedLevel=" + recommendedLevel + ", categoryId="
		+ categoryId + "]";
    }
    
}
