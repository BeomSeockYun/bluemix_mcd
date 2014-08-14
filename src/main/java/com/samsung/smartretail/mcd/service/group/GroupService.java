package com.samsung.smartretail.mcd.service.group;

import java.util.Map;

import com.samsung.smartretail.mcd.vo.group.GroupVO;

public interface GroupService {
    Map<String, Object> getGroupList();
    Map<String, Object> getGroupDetail(String groupId);
    Map<String, Object> createGroup(GroupVO vo);
    
}
