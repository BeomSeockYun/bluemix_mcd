package com.samsung.smartretail.mcd.dao.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.user.UserVO;

@Repository(value="UserMapper")
public interface UserMapper {
    List<UserVO> getUserList(Map groupId);
    UserVO getUserDetail(String groupId, String userId);
    int createUser(UserVO vo);
    int createUserGroupMapping(Map<String, String> map);
    int createUserRoleMapping(List<Map> list);
}
