package com.samsung.smartretail.mcd.service.batch.sample;

import java.util.List;
import com.samsung.smartretail.mcd.vo.batch.sample.MemberVO;


public interface SampleService {
	
	public List<MemberVO> list() throws Exception;
	
	public int insertList(List<MemberVO> members) throws Exception;	

}
