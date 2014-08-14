package com.samsung.smartretail.mcd.service.inventory;

import java.util.Map;

import com.samsung.smartretail.mcd.vo.inventory.OrderItemsVO;

public interface InventoryService {
    	Map<String, Object> getItemList(String groupId, int marker, int limit);
    	Map<String, Object> getItemDetail(String groupId, String itemId);
    	//Map<String, Object> getItemDetail(InventoryVO vo);
    	Map<String, Object> getShortageItems(String groupId);
    	Map<String, Object> getTopLinkItems(String groupId, int topLink);
    	//Map<String, Object> createOrderItems(Map<String, Object> orders);
    	Map<String, Object> createOrderItems(OrderItemsVO vo);
    	
    	// demo를 위한 insert
    	int updateDemodata(int current_level);
}

