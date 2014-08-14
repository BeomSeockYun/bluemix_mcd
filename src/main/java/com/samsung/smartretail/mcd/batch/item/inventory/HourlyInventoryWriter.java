package com.samsung.smartretail.mcd.batch.item.inventory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samsung.smartretail.mcd.service.batch.inventory.InventoryBatchService;
import com.samsung.smartretail.mcd.vo.batch.inventory.HourlyInventoryVO;

@Component(value="hourlyInventoryWriter")
public class HourlyInventoryWriter implements ItemWriter<HourlyInventoryVO> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    InventoryBatchService batchService;

    @Override
    public void write(List<? extends HourlyInventoryVO> items) throws Exception {
	// TODO Auto-generated method stub
	List<HourlyInventoryVO> vos = (List<HourlyInventoryVO>) items.get(0);
	int affectedCount = 0;
	for (HourlyInventoryVO hourlyInventoryVO : vos) {
	    affectedCount = batchService.updateForHourlyBatch(hourlyInventoryVO);
	}
/*	List<HourlyInventoryVO> vos = (List<HourlyInventoryVO>) items.get(0);
	logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	logger.debug(vos.toString());
	int a = batchService.updateForHourlyBatch(vos);
	*/
	//logger.debug("HourlyInventoryWriter : AFFECTED COUNT : " + affectedCount);
    }
}
