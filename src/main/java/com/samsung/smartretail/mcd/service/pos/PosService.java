package com.samsung.smartretail.mcd.service.pos;

import java.util.List;

import com.samsung.smartretail.mcd.vo.pos.PosVO;

public interface PosService {

	int insertPosData(PosVO pvo);
	List<PosVO> getPosData();

}
