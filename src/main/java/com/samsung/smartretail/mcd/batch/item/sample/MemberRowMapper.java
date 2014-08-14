package com.samsung.smartretail.mcd.batch.item.sample;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.samsung.smartretail.mcd.vo.batch.sample.MemberVO;




public class MemberRowMapper  implements RowMapper<MemberVO> {

	final Logger logger = LoggerFactory.getLogger(MemberRowMapper.class);
	
	
	@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	 
			MemberVO member = new MemberVO();
			
			member.setMbrId(rs.getString("mbr_id")+System.currentTimeMillis());
			member.setMbrNm(rs.getString("mbr_nm")+System.currentTimeMillis());
		
			logger.debug(">>>MemberRowMapper ::: Member ::: "+member.getMbrId()+" - "+member.getMbrNm() );
			
			return member;
		}

}

