package com.samsung.smartretail.mcd.dao.group;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.group.GroupVO;

@Repository(value="GroupMapper")
public interface GroupMapper {
    List<GroupVO> getGroupList();
    GroupVO getGroupDetail(String groupId);
    int createGroup(GroupVO vo);
}
