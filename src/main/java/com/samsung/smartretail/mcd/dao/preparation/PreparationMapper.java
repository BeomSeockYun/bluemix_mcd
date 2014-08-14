package com.samsung.smartretail.mcd.dao.preparation;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.preparation.PreparationVO;

@Repository(value="PreparationMapper")
public interface PreparationMapper {
	
	List<PreparationVO> getTodolist(PreparationVO pvo);
	List<PreparationVO> getNotCheckedTodolist(PreparationVO pvo);
	int updateTodolist(Map<String, Object> list);
	
	//random 데이터 삽입
	int insertTodolist(Map<String, Object> map);
}
