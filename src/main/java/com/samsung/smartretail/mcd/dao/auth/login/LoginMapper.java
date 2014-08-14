package com.samsung.smartretail.mcd.dao.auth.login;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.auth.login.loginVO;

@Repository(value="LoginMapper")
public interface LoginMapper {

	loginVO loginUser(loginVO lvo);
	loginVO logoutUser(loginVO lvo);
	int insertRegistrationId(Map<String, Object> map);
	loginVO selectRegistrationId(@Param (value="user_id") String user_id);	//Get RegistrationID
}
