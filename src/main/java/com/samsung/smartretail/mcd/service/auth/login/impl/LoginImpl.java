package com.samsung.smartretail.mcd.service.auth.login.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.auth.login.LoginMapper;
import com.samsung.smartretail.mcd.entity.common.ResultType;
import com.samsung.smartretail.mcd.service.auth.login.LoginService;
import com.samsung.smartretail.mcd.vo.auth.login.loginVO;

@Service
public class LoginImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public ResultType loginUser(String userId, String password) {
		
		loginVO lvo = new loginVO();
		lvo.setUserId(userId);
		lvo.setPassword(password);
		
		loginVO temp = loginMapper.loginUser(lvo);
		
		if(temp == null){
			// Id가 존재하지 않는 경우
			return ResultType.FAIL;
		} else {
			
			String originalPassword = temp.getPassword();
			String inputPassword = lvo.getPassword();
			
			if(originalPassword.equals(inputPassword)){
				return ResultType.SUCCESS;
			} else {
				// 비밀번호가 일치하지 않는 경우
				return ResultType.FAIL;
			}
			
		}
		
	}

	@Override
	public ResultType logoutUser(String userId) {
		
		loginVO lvo = new loginVO();
		lvo.setUserId(userId);
		
		loginVO temp = loginMapper.loginUser(lvo);
		
		if(temp != null){
			return ResultType.SUCCESS;
		} else {
			return ResultType.FAIL;
		}
	}

	@Override
	public int insertRegistrationId(String user_id, String registration_id) {
		int result = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("registration_id", registration_id);
		
		result = loginMapper.insertRegistrationId(map);
		
		return result;
	}

//Get RegistrationID
	public String getRegistrationKey(String userId) {
		
		loginVO lvo = this.loginMapper.selectRegistrationId(userId);
		
		return lvo.getPush_register_key();
	}	
}
