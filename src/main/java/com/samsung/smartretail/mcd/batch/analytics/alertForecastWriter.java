package com.samsung.smartretail.mcd.batch.analytics;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.samsung.smartretail.mcd.service.batch.inventory.InventoryBatchService;
import com.samsung.smartretail.mcd.service.push.GcmPushService;
import com.samsung.smartretail.mcd.vo.analytics.AnalyticsVO;


public class alertForecastWriter implements ItemWriter<AnalyticsVO> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    InventoryBatchService batchService;
    
    @Autowired GcmPushService gcmPushService;
    
    @Override
    public void write(List<? extends AnalyticsVO> items) throws Exception {
//    logger.info("##### Analytics #####");
    String id="1";
	String title ="Event Info"; 	
	String userId="manager@mcd.com";
	Boolean result = false;
	
	try {
	    if (items.size() > 0) {
	    	
	    	AnalyticsVO vo = items.get(0);
	    	String msg = vo.getEvent_info();
	    	result = gcmPushService.sendPushMessage(id,title, msg, userId);
	    } 
	} catch (Exception e) {
		// TODO Auto-generated catch block
	}
	
    }
}