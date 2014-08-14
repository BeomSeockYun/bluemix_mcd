package com.samsung.smartretail.mcd.controller.auth.login;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.entity.auth.AuthResponse;
import com.samsung.smartretail.mcd.entity.common.ResultResponse;
import com.samsung.smartretail.mcd.entity.common.ResultType;
import com.samsung.smartretail.mcd.service.auth.login.LoginService;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login" , method = { RequestMethod.POST}, headers = "Accept=application/xml,application/json")
	@ResponseBody
	public AuthResponse loginUser(
			@RequestParam(value="userId") String userId,
			@RequestParam(value="password") String password
			){
		
		logger.debug("login() >>>  "); 
		

		ResultType rt =  loginService.loginUser(userId , password);
		
		ResultResponse rr = new ResultResponse();

		if (rt.equals(ResultType.SUCCESS)) {
		
			rr.setResultType(ResultType.SUCCESS);
		    rr.setOperationName("login");
		    rr.setResult(true);
	
		} else{

			rr.setResultType(ResultType.FAIL);
		    rr.setOperationName("login");
		    rr.setResult(false);
		    
		}
		
		AuthResponse ar = new AuthResponse();
		ar.setResultResponse(rr);
		
		return ar;
	}
	
	@RequestMapping(value="/logout" , method = { RequestMethod.POST}, headers = "Accept=application/xml,application/json")
	@ResponseBody
	public AuthResponse logoutUser(
			@RequestParam(value="userId") String userId,
			@RequestParam(value="password") String password
			){
		

		logger.debug("logout() >>>  "); 

		ResultType rt =  loginService.logoutUser(userId);
		
		ResultResponse rr = new ResultResponse();

		if (rt.equals(ResultType.SUCCESS)) {
		
			rr.setResultType(ResultType.SUCCESS);
		    rr.setOperationName("logout");
		    rr.setResult(true);
		    
		} else{

			rr.setResultType(ResultType.FAIL);
		    rr.setOperationName("logout");
		    rr.setResult(false);
		    
		}
		
		AuthResponse ar = new AuthResponse();
		ar.setResultResponse(rr);
		
		return ar;
	}
	
	@RequestMapping(value="/insertRegistrationId", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertRegistrationId(
			@RequestParam(value="user_id") String user_id,
			@RequestParam(value="registration_id") String registration_id
			){
		
		int result_count = loginService.insertRegistrationId(user_id, registration_id);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		
		return result;
	}

}
