package com.samsung.smartretail.mcd.dao.pos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.pos.PosVO;

@Repository(value="PosMapper")
public interface PosMapper {

	int insertPosData(PosVO pvo);
	List<PosVO> getPosData();
}

