package com.samsung.smartretail.mcd.service.auth.login;

import com.samsung.smartretail.mcd.entity.common.ResultType;

public interface LoginService {

	ResultType loginUser(String userId, String password);
	ResultType logoutUser(String userId);
	
	int insertRegistrationId(String user_id, String registration_id);
}
