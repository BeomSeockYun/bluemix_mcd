package com.samsung.smartretail.mcd.vo.batch.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * JSON / XML MemberVO Entity 
 *
 */
@XmlType(name = "Member", propOrder = { "mbrId", "mbrNm" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@XStreamAlias("Member")
public class MemberVO  {

	
	private String mbrId;
	private String mbrNm;

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getMbrNm() {

		return mbrNm;
	}

	public void setMbrNm(String mbrNm) {
		this.mbrNm = mbrNm;
	}
}
