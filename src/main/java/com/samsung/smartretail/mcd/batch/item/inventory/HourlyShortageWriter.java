package com.samsung.smartretail.mcd.batch.item.inventory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.samsung.smartretail.mcd.service.batch.inventory.InventoryBatchService;
import com.samsung.smartretail.mcd.service.push.GcmPushService;
import com.samsung.smartretail.mcd.vo.inventory.InventoryVO;


public class HourlyShortageWriter implements ItemWriter<InventoryVO> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    InventoryBatchService batchService;
    
    @Autowired GcmPushService gcmPushService;
    
    @Override
    public void write(List<? extends InventoryVO> items) throws Exception {
	
	List<InventoryVO> vos = (List<InventoryVO>) items.get(0);
	String id= "2";
	String title ="Item Shortage"; 
	String msg ="Item Shortage Alarm ";
	String userId="manager@mcd.com";
	Boolean result = false;
	
	try {
	    if (vos.size() > 0) {
		result = gcmPushService.sendPushMessage(id,title, msg, userId);
	    } 
	} catch (Exception e) {
		// TODO Auto-generated catch block
	}
	
	//정기적인 인벤토리 리포팅
	/*title ="Regular Reporting"; 
	msg ="Item Regular Reporting";
	result = gcmPushService.sendPushMessage(title, msg, userId);*/
    }
}
