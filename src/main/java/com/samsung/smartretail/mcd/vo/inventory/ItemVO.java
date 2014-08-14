package com.samsung.smartretail.mcd.vo.inventory;

public class ItemVO {

    private String itemId;
    private int hasChild;
    private String parentItemId;
    private String itemName;
    private int valueOfItem;
    private String category;
    private int valueOfStock;
    private String stockUnit;
    private String itemUnit;
    private String capacityUnit;
    private int numberOfStockUnit;
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public int getHasChild() {
        return hasChild;
    }
    public void setHasChild(int hasChild) {
        this.hasChild = hasChild;
    }
    public String getParentItemId() {
        return parentItemId;
    }
    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getValueOfItem() {
        return valueOfItem;
    }
    public void setValueOfItem(int valueOfItem) {
        this.valueOfItem = valueOfItem;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getValueOfStock() {
        return valueOfStock;
    }
    public void setValueOfStock(int valueOfStock) {
        this.valueOfStock = valueOfStock;
    }
    public String getStockUnit() {
        return stockUnit;
    }
    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }
    public String getItemUnit() {
        return itemUnit;
    }
    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }
    public String getCapacityUnit() {
        return capacityUnit;
    }
    public void setCapacityUnit(String capacityUnit) {
        this.capacityUnit = capacityUnit;
    }
    public int getNumberOfStockUnit() {
        return numberOfStockUnit;
    }
    public void setNumberOfStockUnit(int numberOfStockUnit) {
        this.numberOfStockUnit = numberOfStockUnit;
    }
    @Override
    public String toString() {
	return "ItemVo [itemId=" + itemId + ", hasChild=" + hasChild
		+ ", parentItemId=" + parentItemId + ", itemName=" + itemName
		+ ", valueOfItem=" + valueOfItem + ", category=" + category
		+ ", valueOfStock=" + valueOfStock + ", stockUnit=" + stockUnit
		+ ", itemUnit=" + itemUnit + ", capacityUnit=" + capacityUnit
		+ ", numberOfStockUnit=" + numberOfStockUnit + "]";
    }
    
    
}
