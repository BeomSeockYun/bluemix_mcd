package com.samsung.smartretail.mcd.dao.inventory;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.batch.inventory.HourlyInventoryVO;
import com.samsung.smartretail.mcd.vo.inventory.InventoryVO;
@Repository(value="InventoryMapper")
public interface InventoryMapper {
    List<InventoryVO> getItemList(String groupId, int marker, int limit);
    //List<InventoryVO> getItemList(InventoryVO vo);
    InventoryVO getItemDetail(String groupId, String itemId);
    
    List<InventoryVO> getShortageItems(String groupId);
    //특정기간내 top selling menu.
    List<InventoryVO> getTopLinkItems(String groupId, int topLink, String today, String yesterday);
    int createOrderItems(List list);
    
    List<InventoryVO> getMultiItemDetail(Map<String, Object> list);
    
    // demo를 위한 insert
    int updateDemodata(Map<String, Object> map);
}
