package com.samsung.smartretail.mcd.controller.preparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.service.preparation.PreparationService;
import com.samsung.smartretail.mcd.vo.preparation.PreparationVO;

@Controller
@RequestMapping(value="/preparation")
public class PreparationController {

	@Autowired
	private PreparationService preparationService;

	@RequestMapping(value="/get_checkin")
	@ResponseBody
	public String getCheckedInTime(@RequestParam(value = "emp_id", required = false, defaultValue = "1") int emp_id) {

		System.out.println("GOOD");
		//sampleService.getCheckedInTime(emp_id);
		return "TEST WORLD";
	}

	@RequestMapping(value="/helloMcd", method=RequestMethod.GET)
	@ResponseBody
	public String helloMcd(){
		return "Hi! Mcdonalds";
	}

	@RequestMapping(value="/getTodolist", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getTodolist(
			@RequestParam(value="owner_id") String owner_id,
			@RequestParam(value="start_date", required=false) String start_date
			){

		List<PreparationVO> listPvo = preparationService.getTodolist(owner_id, start_date);

		// json 형태로 파싱
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String, String>> todolist = new ArrayList<Map<String, String>>();
		
		for(int i=0;i<listPvo.size();i++){
			Map<String,String> temp = new HashMap<String,String>();
			temp.put("idx", Integer.toString(listPvo.get(i).getIdx()) );
			temp.put("to_do_id", listPvo.get(i).getto_do_id() );
			temp.put("owner_id",  listPvo.get(i).getOwner_id() );
			temp.put("category",  listPvo.get(i).getCategory() );
			temp.put("title",  listPvo.get(i).getTitle());
			temp.put("detail",  listPvo.get(i).getDetail() );
			temp.put("start_date",  listPvo.get(i).getStart_date().toString());
			temp.put("end_date",  listPvo.get(i).getEnd_date().toString());
			
			if(listPvo.get(i).getChecked_date()==null){
				temp.put("checked_date", "null");
			} else {
				temp.put("checked_date", listPvo.get(i).getChecked_date().toString());
			}
			
			if(listPvo.get(i).isIs_checked()){
				temp.put("is_checked","true");
			}else {
				temp.put("is_checked","false");
			}
			
			todolist.add(temp);
		}
		result.put("totalCount", listPvo.size());
		result.put("todolist", todolist);	
		
		return result;
	}

	@RequestMapping(value = "/getNotCheckedTodolist", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getNotCheckedTodoList(
			@RequestParam(value="owner_id") String owner_id,
			@RequestParam(value="start_date" , required=false) String start_date
			){

		List<PreparationVO> listPvo = preparationService.getNotCHeckedTodolist(owner_id, start_date);
		
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String, String>> todolist = new ArrayList<Map<String, String>>();
		
		for(int i=0;i<listPvo.size();i++){
			Map<String,String> temp = new HashMap<String,String>();
			temp.put("idx", Integer.toString(listPvo.get(i).getIdx()) );
			temp.put("to_do_id", listPvo.get(i).getto_do_id() );
			temp.put("owner_id",  listPvo.get(i).getOwner_id() );
			temp.put("category",  listPvo.get(i).getCategory() );
			temp.put("title",  listPvo.get(i).getTitle());
			temp.put("detail",  listPvo.get(i).getDetail() );
			temp.put("start_date",  listPvo.get(i).getStart_date().toString());
			temp.put("end_date",  listPvo.get(i).getEnd_date().toString());
			
			if(listPvo.get(i).getChecked_date()==null){
				temp.put("checked_date", "null");
			} else {
				temp.put("checked_date", listPvo.get(i).getChecked_date().toString());
			}
			
			if(listPvo.get(i).isIs_checked()){
				temp.put("is_checked","true");
			}else {
				temp.put("is_checked","false");
			}
			
			todolist.add(temp);
		}
		result.put("totalCount", listPvo.size());
		result.put("todolist", todolist);	
		
		return result;
	}

	@RequestMapping(value="/updateTodolist" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateTodolist(
			@RequestBody Map<String, Object> jsonData,
			HttpServletResponse response
			){
		
		int listCount = (Integer)jsonData.get("listCount");
		List<HashMap<String, Object>> tempList = (ArrayList)jsonData.get("todolist");
		
		int temp = preparationService.updateTodolist(tempList,listCount);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", Integer.toString(temp));
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return result;
	}
	
	@RequestMapping(value="/insertTodolist", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> insertTodolist(
			@RequestParam(value="start_date") String start_date,
			@RequestParam(value="end_date") String end_date
			){
		Map<String, String> result = new HashMap<String, String>();
		
		preparationService.insertTodolist(start_date, end_date);
		
		result.put("result", "success");
		
		return result;
	}

}
