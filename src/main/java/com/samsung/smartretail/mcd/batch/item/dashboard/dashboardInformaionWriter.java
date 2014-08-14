package com.samsung.smartretail.mcd.batch.item.dashboard;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.samsung.smartretail.mcd.service.batch.dashboard.DashboardBatchService;
import com.samsung.smartretail.mcd.service.push.GcmPushService;
import com.samsung.smartretail.mcd.vo.dashboard.DashboardVO;


public class dashboardInformaionWriter implements ItemWriter<DashboardVO> {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	DashboardBatchService dashboardBatchService;

	@Autowired GcmPushService gcmPushService;

	@Override
	public void write(List<? extends DashboardVO> items) throws Exception {

		int size = items.size();
		
		DashboardVO dvo = items.get(0);
		
		int last_index = dashboardBatchService.lastData();
		int is_true = dashboardBatchService.selectData(last_index);
		

		String id="3";
		String title ="Dashboard Alert"; 
		String msg ="New Sales Performance Data";
		String userId="manager@mcd.com";
		Boolean result = false;
		
		if(is_true==0){
			logger.info("***********************************************************************true");
			dashboardBatchService.insertData(last_index);
			result = gcmPushService.sendPushMessage(id,title, msg, userId);
		} else {
			logger.info("***********************************************************************false");
		}
		
		logger.info("Dashboard Push Result : "+result);
		
	}
}
