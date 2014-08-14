package com.samsung.smartretail.mcd.service.preparation;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.samsung.smartretail.mcd.vo.preparation.PreparationVO;

public interface PreparationService {
	
	List<PreparationVO> getTodolist(String owner_id, String start_date);
	List<PreparationVO> getNotCHeckedTodolist(String owner_id, String start_date);
	int updateTodolist(List<HashMap<String, Object>> tempList, int listCount);
	
	// Random 한 to_do_list 삽입
	int insertTodolist(String start_date, String end_date);
}
