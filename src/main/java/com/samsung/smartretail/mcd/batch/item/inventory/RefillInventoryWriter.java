package com.samsung.smartretail.mcd.batch.item.inventory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samsung.smartretail.mcd.service.batch.inventory.InventoryBatchService;
import com.samsung.smartretail.mcd.vo.batch.inventory.HourlyInventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.StockActionHistoryVO;

public class RefillInventoryWriter implements ItemWriter<StockActionHistoryVO>  {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    InventoryBatchService batchService;

    @Override
    public void write(List<? extends StockActionHistoryVO> items) throws Exception {
	// TODO Auto-generated method stub
	int affectedCount = 0;
	for (StockActionHistoryVO stockActionHistoryVO : items) {
	    affectedCount = batchService.updateOrderItem(stockActionHistoryVO);
	}
    }
}
