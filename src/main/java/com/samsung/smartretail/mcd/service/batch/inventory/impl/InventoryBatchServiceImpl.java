package com.samsung.smartretail.mcd.service.batch.inventory.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsung.smartretail.mcd.dao.batch.inventory.BatchInventoryMapper;
import com.samsung.smartretail.mcd.service.batch.inventory.InventoryBatchService;
import com.samsung.smartretail.mcd.vo.batch.inventory.HourlyInventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.InventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.StockActionHistoryVO;

@Service
public class InventoryBatchServiceImpl implements InventoryBatchService {
    
    @Autowired
    private BatchInventoryMapper batchInventoryMapper;

    @Override
    public List<HourlyInventoryVO> getItemCountForHourlyBatch() {
	// TODO Auto-generated method stub
	// 한시간에 1회 배치 된다는 가정. 매시 1분에 구동.
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
	String toDate =  dateFormat.format(date);
	Calendar c = Calendar.getInstance();
	try {
	    c.setTime(dateFormat.parse(toDate));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	}
	/*c.add(Calendar.HOUR_OF_DAY, -1);
	String fromDate =  dateFormat.format(c.getTime())+":00:00";
	toDate = dateFormat.format(c.getTime())+":59:59";*/
	c.add(Calendar.SECOND, -16);
	String fromDate =  dateFormat.format(c.getTime());
	List<HourlyInventoryVO> list = batchInventoryMapper.getItemCountForHourlyBatch(fromDate, toDate);
	return list;
    }

    @Override
    public int updateForHourlyBatch(List<? extends HourlyInventoryVO> items) {
	// TODO Auto-generated method stub
	int affectedCount = batchInventoryMapper.updateForHourlyBatch(items);
	return affectedCount;
    }

    @Override
    public int updateForHourlyBatch(HourlyInventoryVO item) {
	// TODO Auto-generated method stub
	int affectedCount = batchInventoryMapper.updateOneForHourlyBatch(item);
	return affectedCount;
    }

    @Override
    @Transactional
    public int updateOrderItem(StockActionHistoryVO vo) {
	int affectedCount = batchInventoryMapper.updateOrderItem(vo);
	affectedCount = batchInventoryMapper.updateStockHistory(vo);
	return affectedCount;
    }

    @Override
    public List<InventoryVO> getShortageItem() {
	List<InventoryVO> list = batchInventoryMapper.getShortageItem();
	return list;
    }
    
}
