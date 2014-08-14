package com.samsung.smartretail.mcd.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsung.smartretail.mcd.dao.user.UserMapper;
import com.samsung.smartretail.mcd.service.user.UserService;
import com.samsung.smartretail.mcd.vo.user.UserRoleVO;
import com.samsung.smartretail.mcd.vo.user.UserVO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    private Map<String, String> makeResultResponse(String type, String op, String err, String errMsg) {
	Map<String, String> resultResponse = new HashMap<String, String>();
	resultResponse.put("resultType", type);
	resultResponse.put("operationName", op);
	resultResponse.put("errorCode", err);
	resultResponse.put("errorMessage", errMsg);
	return resultResponse;
    }
    

    @Override
    public Map<String, Object> getUserList(String groupId) {
	Map<String, String> gr = new HashMap<String, String>();
	gr.put("groupId", groupId);
	List<UserVO> list = userMapper.getUserList(gr);
	Map<String, Object> ret = new HashMap<String, Object>();

	ret.put("resultresponse", makeResultResponse("SUCCESS", "getUserList", "", ""));
	ret.put("users", list);
	ret.put("totalCount", list.size());
	return ret;
    }

    @Override
    public Map<String, Object> getUserDetail(String groupId, String userId) {
	UserVO user = userMapper.getUserDetail(groupId, userId);
	Map<String, Object> ret = new HashMap<String, Object>();
	ret.put("resultresponse", makeResultResponse("SUCCESS", "getUserDetail", "", ""));
	ret.put("user", user);
	return ret;
    }

    @Override
    @Transactional
    public Map<String, Object> createUser(UserVO vo) {
	System.out.println("USER VO : --------------------------------------------");
	System.out.println(vo);
	//insert user table
	int insertUserCnt =  userMapper.createUser(vo);
	System.out.println("insertUserCnt : ==> " +insertUserCnt);
	//insert group_user mapping.
	Map<String, String> ugrMap = new HashMap<String, String>();
	ugrMap.put("groupId", vo.getGroup().getGroupId());
	ugrMap.put("userId", vo.getUserId());
	int insertUGMCnt = userMapper.createUserGroupMapping(ugrMap);

	//insert user_role mapping.
	List<Map> userRoleMapList = new ArrayList<Map>();
	for(UserRoleVO rvo : vo.getRole()) { 
	    Map<String, String> urm = new HashMap<String, String>();
	    urm.put("roleId", rvo.getRoleId());
	    urm.put("userId", vo.getUserId());
	    userRoleMapList.add(urm);
	}
	int insertURMCnt = userMapper.createUserRoleMapping(userRoleMapList);
	
	//return
	Map<String, Object> ret = new HashMap<String, Object>();
	ret.put("resultresponse", makeResultResponse("SUCCESS", "createUser", "", ""));
	return ret;
    }
}