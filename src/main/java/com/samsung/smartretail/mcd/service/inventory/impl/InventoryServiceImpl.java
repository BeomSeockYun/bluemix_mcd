package com.samsung.smartretail.mcd.service.inventory.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.inventory.InventoryMapper;
import com.samsung.smartretail.mcd.service.inventory.InventoryService;
import com.samsung.smartretail.mcd.vo.inventory.InventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.OrderItemsVO;
import com.samsung.smartretail.mcd.vo.inventory.OrderItemsVO.OrderItem;
import com.samsung.smartretail.mcd.vo.inventory.StockActionHistoryVO;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    private Map<String, String> makeResultResponse(String type, String op, String err, String errMsg) {
	Map<String, String> resultResponse = new HashMap<String, String>();
	resultResponse.put("resultType", type);
	resultResponse.put("operationName", op);
	resultResponse.put("errorCode", err);
	resultResponse.put("errorMessage", errMsg);
	return resultResponse;
    }

    @Override
    public Map<String, Object> getItemList(String groupId, int marker, int limit) {
	List<InventoryVO> list = inventoryMapper.getItemList(groupId, marker, limit);
	Map<String, Object> ret = new HashMap<String, Object>();

	ret.put("resultresponse", makeResultResponse("SUCCESS", "getItemList", "", ""));
	ret.put("items", list);
	ret.put("totalCount", list.size());
	return ret;
    }

    @Override
    public Map<String, Object> getItemDetail(String groupId, String itemId) {
	InventoryVO vo = inventoryMapper.getItemDetail(groupId, itemId);
	Map<String, Object> ret = new HashMap<String, Object>();
	ret.put("resultresponse", makeResultResponse("SUCCESS", "getItemDetail", "", ""));
	ret.put("item", vo);
	return ret;
    }

    @Override
    public Map<String, Object> getShortageItems(String groupId) {
	List<InventoryVO> list = inventoryMapper.getShortageItems(groupId);
	Map<String, Object> ret = new HashMap<String, Object>();

	ret.put("resultresponse", makeResultResponse("SUCCESS", "getShortageItems", "", ""));
	ret.put("items", list);
	ret.put("totalCount", list.size());
	return ret;
    }

    @Override
    public Map<String, Object> getTopLinkItems(String groupId, int topLink) {
	//top selling menu for yesterday 
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String today =  dateFormat.format(date);
	Calendar c = Calendar.getInstance();
	try {
	    c.setTime(dateFormat.parse(today));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	}
	c.add(Calendar.DATE, -1);
	String yesterday =  dateFormat.format(c.getTime());

	List<InventoryVO> list = inventoryMapper.getTopLinkItems(groupId, topLink, yesterday,today);
	Map<String, Object> ret = new HashMap<String, Object>();

	ret.put("resultresponse", makeResultResponse("SUCCESS", "getTopLinkItems", "", ""));
	ret.put("items", list);
	ret.put("totalCount", list.size());
	return ret;
    }

    @Override
    public Map<String, Object> createOrderItems(OrderItemsVO orders) {
	
	String groupId = orders.getGroupId();
	List<OrderItem> orderList = orders.getOrderList();
	
	List<StockActionHistoryVO> updateList = new ArrayList<StockActionHistoryVO>();
	
	
	List<String> items = new ArrayList<String>();
	for (OrderItem order : orderList) {
	    StockActionHistoryVO vo = new StockActionHistoryVO();
	    vo.setGroupId(groupId);
	    vo.setItemId(order.getItemId());
	    items.add(order.getItemId());
	    vo.setValueOfStock(Integer.parseInt(order.getQuantity()));
	    vo.setAction(1);
	    updateList.add(vo);
	}

	int  affectedCnt = inventoryMapper.createOrderItems(updateList);
	Map<String, Object> ret = new HashMap<String, Object>();
	ret.put("resultresponse", makeResultResponse("SUCCESS", "createOrderItems", "", ""));
	ret.put("result", affectedCnt);
/*	//TODO : affected row count의 조건을 확인해야함.
	Map<String, Object> sel = new HashMap<String, Object>();
	sel.put("groupId", groupId);
	sel.put("itemIds", items);
	List<InventoryVO> list = inventoryMapper.getMultiItemDetail(sel);
	
	Map<String, Object> ret = new HashMap<String, Object>();
	ret.put("resultresponse", makeResultResponse("SUCCESS", "createOrderItems", "", ""));
	ret.put("items", list);
	ret.put("result", list.size());*/
	return ret;
    }

	@Override
	public int updateDemodata(int current_level) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("current_level", current_level);
		
		inventoryMapper.updateDemodata(map);
		
		return 0;
	}

}