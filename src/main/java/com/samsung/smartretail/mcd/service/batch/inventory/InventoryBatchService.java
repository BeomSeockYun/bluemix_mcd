package com.samsung.smartretail.mcd.service.batch.inventory;

import java.util.List;

import com.samsung.smartretail.mcd.vo.batch.inventory.HourlyInventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.InventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.StockActionHistoryVO;

public interface InventoryBatchService {
    List<HourlyInventoryVO> getItemCountForHourlyBatch();
    int updateForHourlyBatch(List<? extends HourlyInventoryVO> items);
    int updateForHourlyBatch(HourlyInventoryVO item);
    int updateOrderItem(StockActionHistoryVO vo);
    List<InventoryVO> getShortageItem();
}
