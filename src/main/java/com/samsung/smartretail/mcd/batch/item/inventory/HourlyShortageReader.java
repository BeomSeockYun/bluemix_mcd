package com.samsung.smartretail.mcd.batch.item.inventory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.samsung.smartretail.mcd.service.batch.inventory.InventoryBatchService;
import com.samsung.smartretail.mcd.vo.batch.inventory.HourlyInventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.InventoryVO;


public class HourlyShortageReader  implements ItemReader<List<InventoryVO>> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private int procCount = 0;
    @Autowired
    InventoryBatchService batchService;

    public List<InventoryVO>  read() throws Exception {
	List<InventoryVO> list = batchService.getShortageItem();
	if (procCount == 0) {
	    if(list.size() <= 0) {
		return null;
	    }
	    procCount++;
	    return list;
	} else {
	    procCount = 0;
	    return null;
	}
    }
}
