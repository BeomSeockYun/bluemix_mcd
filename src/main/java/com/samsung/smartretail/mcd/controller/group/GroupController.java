package com.samsung.smartretail.mcd.controller.group;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.service.group.GroupService;
import com.samsung.smartretail.mcd.vo.group.GroupVO;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;
    
    @RequestMapping(value="/group/getGroupList", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getGroupList() {
	Map<String, Object> groupList = groupService.getGroupList();
	return groupList;
    }
    
    @RequestMapping(value="/group/getGroupDetail", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getGroupDetail(@RequestParam(value="groupId") String groupId) {
	Map<String, Object> groupList = groupService.getGroupDetail(groupId);
	return groupList;
    }
    
    @RequestMapping(value="/group/createGroup", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createUser(@RequestBody GroupVO vo) {
	Map<String, Object> ret = groupService.createGroup(vo);
	System.out.println(ret);
	return ret;
    }
}
