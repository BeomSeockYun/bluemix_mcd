package com.samsung.smartretail.mcd.vo.inventory;

public class StockActionHistoryVO {
    private int sn;
    private String itemId;
    private String groupId;
    private int action;
    private int valueOfStock;
    private String unit;
    private String opDate;
    
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
    public int getAction() {
        return action;
    }
    public void setAction(int action) {
        this.action = action;
    }
    public int getValueOfStock() {
        return valueOfStock;
    }
    public void setValueOfStock(int valueOfStock) {
        this.valueOfStock = valueOfStock;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getOpDate() {
        return opDate;
    }
    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }
    
    public int getSn() {
        return sn;
    }
    public void setSn(int sn) {
        this.sn = sn;
    }
    @Override
    public String toString() {
	return "StockActionHistoryVo [sn = " + sn + ", itemId=" + itemId + ", groupId="
		+ groupId + ", action=" + action + ", valueOfStock="
		+ valueOfStock + ", unit=" + unit + ", opDate=" + opDate + "]";
    }
    
}
