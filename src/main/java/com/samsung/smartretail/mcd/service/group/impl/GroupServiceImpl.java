package com.samsung.smartretail.mcd.service.group.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsung.smartretail.mcd.dao.group.GroupMapper;
import com.samsung.smartretail.mcd.service.group.GroupService;
import com.samsung.smartretail.mcd.vo.group.GroupVO;
import com.samsung.smartretail.mcd.vo.user.UserRoleVO;
import com.samsung.smartretail.mcd.vo.user.UserVO;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;

    private Map<String, String> makeResultResponse(String type, String op, String err, String errMsg) {
	Map<String, String> resultResponse = new HashMap<String, String>();
	resultResponse.put("resultType", type);
	resultResponse.put("operationName", op);
	resultResponse.put("errorCode", err);
	resultResponse.put("errorMessage", errMsg);
	return resultResponse;
    }

    @Override
    public Map<String, Object> getGroupList() {

	List<GroupVO> list = groupMapper.getGroupList();
	Map<String, Object> ret = new HashMap<String, Object>();

	ret.put("resultresponse", makeResultResponse("SUCCESS", "getGroupList", "", ""));
	ret.put("groups", list);
	ret.put("totalCount", list.size());
	return ret;
    }

    @Override
    public Map<String, Object> getGroupDetail(String groupId) {

	GroupVO vo = groupMapper.getGroupDetail(groupId);
	Map<String, Object> ret = new HashMap<String, Object>();

	ret.put("resultresponse", makeResultResponse("SUCCESS", "getGroupList", "", ""));
	ret.put("group", vo);
	return ret;
    }
    @Override
    @Transactional()
    public Map<String, Object> createGroup(GroupVO vo) {
	//insert user table
	int insertGroupCnt =  groupMapper.createGroup(vo);
	//return
	Map<String, Object> ret = new HashMap<String, Object>();
	ret.put("resultresponse", makeResultResponse("SUCCESS", "createUser", "", ""));
	return ret;

    }
}