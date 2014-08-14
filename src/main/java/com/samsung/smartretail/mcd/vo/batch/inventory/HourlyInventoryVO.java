package com.samsung.smartretail.mcd.vo.batch.inventory;

public class HourlyInventoryVO {
    private String itemId;
    private String groupId;
    private int decreaseCount;
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
    public int getDecreaseCount() {
        return decreaseCount;
    }
    public void setDecreaseCount(int decreaseCount) {
        this.decreaseCount = decreaseCount;
    }
    @Override
    public String toString() {
	return "HoulryInventoryVO [itemId=" + itemId + ", groupId=" + groupId
		+ ", decreaseCount=" + decreaseCount + "]";
    }
    
    
}
