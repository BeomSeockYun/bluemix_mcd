package com.samsung.smartretail.mcd.dao.batch.inventory;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.batch.inventory.HourlyInventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.InventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.StockActionHistoryVO;


@Repository(value="batchInventoryMapper")
public interface BatchInventoryMapper {
    //methods for batch job
    List<HourlyInventoryVO> getItemCountForHourlyBatch(String fromDate, String toDate);
    int updateForHourlyBatch(List<? extends HourlyInventoryVO> items);
    int updateOneForHourlyBatch(HourlyInventoryVO item);
    
    int updateOrderItem(StockActionHistoryVO vo);
    int updateStockHistory(StockActionHistoryVO vo);
    
    
    List<InventoryVO> getShortageItem();
    
}
