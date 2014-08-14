package com.samsung.smartretail.mcd.service.pos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.pos.PosMapper;
import com.samsung.smartretail.mcd.service.pos.PosService;
import com.samsung.smartretail.mcd.vo.pos.PosVO;

@Service
public class PosServiceImpl implements PosService {

	@Autowired
	private PosMapper posMapper;

	@Override
	public int insertPosData(PosVO pvo) {

		return posMapper.insertPosData(pvo);
	}

	@Override
	public List<PosVO> getPosData() {
		List<PosVO> tempList = posMapper.getPosData();
		return tempList;
	}

}
