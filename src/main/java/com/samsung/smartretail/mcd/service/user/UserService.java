package com.samsung.smartretail.mcd.service.user;

import java.util.Map;

import com.samsung.smartretail.mcd.vo.user.UserVO;

public interface UserService {
    Map<String, Object> getUserList(String groupId);
    Map<String, Object> getUserDetail(String groupId, String userId);
    Map<String, Object> createUser(UserVO vo);
}

