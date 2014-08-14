package com.samsung.smartretail.mcd.controller.inventory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.service.inventory.InventoryService;
import com.samsung.smartretail.mcd.vo.inventory.OrderItemsVO;


@Controller
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value="/inventory/getItemList", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getItemList(@RequestParam(value="groupId") String groupId, 
	    @RequestParam(value="marker", required=false, defaultValue="0") int marker, 
	    @RequestParam(value="limit", required=false, defaultValue="10") int limit) {
	Map<String, Object> listIven = inventoryService.getItemList(groupId, marker, limit);
	return listIven;
    }

/*    @RequestMapping(value="/inventory/getItemDetail", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getItemDetail(@ModelAttribute InventoryVO){
	Map<String, Object> ret = inventoryService.getItemDetail(vo);
	
    }*/
    @RequestMapping(value="/inventory/getItemDetail", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getItemDetail(
	    @RequestParam(value="groupId") String groupId,
	    @RequestParam(value="itemId") String itemId
	    ) {
	Map<String, Object> ret = inventoryService.getItemDetail(groupId, itemId);
	return ret;
    }

    @RequestMapping(value="/inventory/getShortageItems", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getShortageItems(@RequestParam(value="groupId") String groupId,
	    @RequestParam(value="marker", required=false) String marker, 
	    @RequestParam(value="limit", required=false, defaultValue="10") int limit) {
	Map<String, Object> ret = inventoryService.getShortageItems(groupId);
	return ret;
    }

    @RequestMapping(value="/inventory/getTopLinkItems", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTopLinkItems(@RequestParam(value="groupId") String groupId, 
	    @RequestParam(value="topLink") int topLink, @RequestParam(value="marker", required=false) String marker,
	    @RequestParam(value="limit", required=false, defaultValue="10") int limit) {
	Map<String, Object> ret = inventoryService.getTopLinkItems(groupId, topLink);
	return ret;
    }

/*    @RequestMapping(value="/inventory/createOrderItems", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createOrderItems(@RequestBody Map<String, Object> reqBody) {
	//Map<String, Object> ret = inventoryService.createOrderItems(reqBody);
	System.out.println("*****************************************************");
	System.out.println(reqBody);
	System.out.println("*****************************************************");
	Map<String, Object> ret = new HashMap<String, Object>();
	return ret;
    }*/
    
    @RequestMapping(value="/inventory/createOrderItems", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createOrderItems(@RequestBody OrderItemsVO reqBody) {
	System.out.println("REQ BODY : " + reqBody);
	Map<String, Object> ret = inventoryService.createOrderItems(reqBody);
	return ret;
    }
     /**
     * Object returning sample
     * @return
     */
    @RequestMapping(value="/test4yun.html",method = RequestMethod.GET)
    public String test(){
	System.out.println("----TEST---");
	return "redirect:/pages/test4yun.html";

    }
    
    // demo를 위해서 데이터를 입력 받아서 analytics TABLE에 저장합니다.
 	@RequestMapping(value="/inventory/updateDemodata", method=RequestMethod.POST)
 	@ResponseBody
 	public  String insertDemodata(
 			@RequestParam(value="current_level") int current_level){
 				
 		inventoryService.updateDemodata(current_level);
 		
 		return "success";
 	}	
}
