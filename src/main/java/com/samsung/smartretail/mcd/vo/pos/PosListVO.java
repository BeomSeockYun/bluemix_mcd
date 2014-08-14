package com.samsung.smartretail.mcd.vo.pos;

import java.util.List;

public class PosListVO {

	private int listCount;
	private List<PosVO> posList;
	
	public PosListVO() {
		super();
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public List<PosVO> getPosList() {
		return posList;
	}

	public void setPosList(List<PosVO> posList) {
		this.posList = posList;
	}
	
}

