package com.samsung.smartretail.mcd.service.preparation.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.common.util.IdGenerator;
import com.samsung.smartretail.mcd.dao.preparation.PreparationMapper;
import com.samsung.smartretail.mcd.service.preparation.PreparationService;
import com.samsung.smartretail.mcd.vo.preparation.PreparationVO;

@Service(value="preparationService")
public class PreparationServiceImpl implements PreparationService {

	@Autowired
	private PreparationMapper preparationMapper;

	@Override
	public List<PreparationVO> getTodolist(String owner_id, String temp_date) {
		PreparationVO pvo = new PreparationVO();
		pvo.setOwner_id(owner_id);

		// 원하는 날짜가 있는 경우
		if(temp_date != null){
			temp_date += " 00:00:00";
			Timestamp start_date = new Timestamp(0);
			start_date = start_date.valueOf(temp_date);	
			pvo.setStart_date(start_date);

		}

		List<PreparationVO> todolist = preparationMapper.getTodolist(pvo);

		return todolist;
	}

	@Override
	public List<PreparationVO> getNotCHeckedTodolist(String owner_id,
			String temp_date) {

		PreparationVO pvo = new PreparationVO();
		pvo.setOwner_id(owner_id);

		if(temp_date != null){
			temp_date += " 00:00:00";
			Timestamp start_date = new Timestamp(0);
			start_date = start_date.valueOf(temp_date);
			pvo.setStart_date(start_date);

		}

		List<PreparationVO> todolist = preparationMapper.getNotCheckedTodolist(pvo);

		return todolist;
	}

	@Override
	public int updateTodolist(List<HashMap<String, Object>> originList, int listCount) {

		Map<String, Object> tempList = new HashMap<String, Object>();

		int result = 0;

		// preparationVO로 파싱
		List<PreparationVO> list = new ArrayList<PreparationVO>();

		for(int i=0;i<listCount;i++){
			PreparationVO tempVO = new PreparationVO();
			tempVO.setIdx((Integer)originList.get(i).get("idx"));
			String tempChecked = (String)originList.get(i).get("is_checked");

			if(tempChecked.equals("true")){
				tempVO.setIs_checked(true);
			}else {
				tempVO.setIs_checked(false);
			}

			list.add(tempVO);
		}

		List<Integer> trueList = new ArrayList<Integer>();
		List<Integer> falseList = new ArrayList<Integer>();

		// true, false 리스트를 각각 생성
		// foreach문에서 처리해주기 위해
		for(int i=0;i<list.size();i++) {

			if(list.get(i).isIs_checked()){
				trueList.add(list.get(i).getIdx());
			} else {
				falseList.add(list.get(i).getIdx());
			}
		}

		if(!trueList.isEmpty()){
			tempList.put("listType", true);
			tempList.put("trueList", trueList);
			result += preparationMapper.updateTodolist(tempList);
		}

		if(!falseList.isEmpty()){
			tempList.clear();
			tempList.put("listType", false);
			tempList.put("falseList", falseList);
			result += preparationMapper.updateTodolist(tempList);
		}

		return result;
	}

	@Override
	public int insertTodolist(String temp_start_date, String temp_end_date) {

		String to_do_id = "";
		String owner_id = "manager@mcd.com";
		boolean is_checked = false;
		boolean is_canceled = false;
		boolean is_modified = false;
		boolean is_new = true;
		
		// create 날짜 생성
		Timestamp create_date = new Timestamp(0);
		create_date = create_date.valueOf("2014-07-26 08:00:00");
	
		// start_date, end_date 생성
		Timestamp start_date = new Timestamp(0);
		Timestamp end_date = new Timestamp(0);
		start_date = start_date.valueOf(temp_start_date+" 08:00:00");
		end_date = end_date.valueOf(temp_end_date+" 23:59:59");

		// title
		List<String> title_list = new ArrayList<String>();
		title_list.add("Inventory");
		title_list.add("Attendance");
		title_list.add("ETQ");
		title_list.add("Device");
		title_list.add("Device");
		title_list.add("ETQ");
		title_list.add("Device");
		title_list.add("Inventory");
		title_list.add("Device");
		title_list.add("ETQ");

		// category
		List<String> category_list = new ArrayList<String>();
		category_list.add("Check inventory");
		category_list.add("Check member");
		category_list.add("Check expected quantities");
		category_list.add("IR Alert - Place cover on 3rd Fry vat");
		category_list.add("3 Cleaning Tasks to be completed");
		category_list.add("Organize stockroom");
		category_list.add("Order new flags");
		category_list.add("Order additional bacon");
		category_list.add("Check device");
		category_list.add("Review refrigerator stock levles");

		String created_by = "manager@mcd.com";

		// 10개를 랜덤하게 돌려서 데이터를 밀어넣음
		List<Boolean> is_select = new ArrayList<Boolean>();

		for(int i=0;i<10;i++){
			is_select.add(false);
		}


		while(true){
			int count=0;

			while(true){
				if((count == 10)||(!is_select.get(count))){
					break;
				}
				count++;
			}


			if(count==10){
				break;
			}else{
				int idx = (int)(Math.random()*10);
				
				if(!is_select.get(idx)){
					is_select.set(idx, true);
					Map<String, Object> map = new HashMap<String, Object>();
					IdGenerator idg = new IdGenerator();
					map.put("to_do_id", idg.generateTodoId());
					map.put("owner_id", owner_id);
					map.put("is_checked", is_checked);
					map.put("is_canceled", is_canceled);
					map.put("is_modified", is_modified);
					map.put("is_new", is_new);
					map.put("title", title_list.get(idx));
					map.put("category", category_list.get(idx));
					map.put("create_date", create_date);
					map.put("created_by", created_by);
					map.put("start_date", start_date);
					map.put("end_date", end_date);
					map.put("priority", 4);
					
					preparationMapper.insertTodolist(map);

				}

			}	
		}


		return 0;
	}

}
