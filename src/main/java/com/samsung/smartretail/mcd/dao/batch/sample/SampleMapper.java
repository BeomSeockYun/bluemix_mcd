package com.samsung.smartretail.mcd.dao.batch.sample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.samsung.smartretail.mcd.vo.batch.sample.MemberVO;



@Repository(value="sampleMapper")
public interface SampleMapper {
	
	String getMbr(@Param("mbrId") String mbrId);

	public List<MemberVO> list() ;
	
	public int insertList(List<MemberVO> members) ;	
	

}
