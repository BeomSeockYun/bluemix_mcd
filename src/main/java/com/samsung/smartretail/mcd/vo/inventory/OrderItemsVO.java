package com.samsung.smartretail.mcd.vo.inventory;

import java.util.List;


public class OrderItemsVO {
    private String groupId;
    private List<OrderItem> orderItems;
    
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<OrderItem> getOrderList() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static class OrderItem {
	private String itemId;
	private String quantity;
	
	public String getItemId() {
	    return itemId;
	}
	public void setItemId(String itemId) {
	    this.itemId = itemId;
	}
	public String getQuantity() {
	    return quantity;
	}
	public void setQuantity(String quantity) {
	    this.quantity = quantity;
	}
	@Override
	public String toString() {
	    return "OrderItem [itemId=" + itemId + ", quantity=" + quantity
		    + "]";
	}

    }

    @Override
    public String toString() {
	return "OrderItemsVo [groupId=" + groupId + ", orderItems="
		+ orderItems + "]";
    }
    
}
