package com.samsung.smartretail.mcd.controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.service.user.UserService;
import com.samsung.smartretail.mcd.vo.user.UserVO;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/user/getUserList", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserList(
	    @RequestParam(value="groupId", required=false, defaultValue="") String groupId) {
	Map<String, Object> userList = userService.getUserList(groupId);
	return userList;
    }
    
    @RequestMapping(value="/user/getUserDetail", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserDetail(
	    @RequestParam(value="groupId", required=false, defaultValue="") String groupId,
	    @RequestParam(value="userId", required=false, defaultValue="") String userId) {
	Map<String, Object> user = userService.getUserDetail(groupId, userId);
	return user;
    }
    
    
    @RequestMapping(value="/user/createUser", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createUser(@RequestBody UserVO vo) {
	Map<String, Object> ret = userService.createUser(vo);
	System.out.println("<------- 반영 결과 ------->");
	System.out.println(ret);
	return ret;
    }
}
