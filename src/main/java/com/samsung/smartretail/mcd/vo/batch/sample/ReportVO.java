package com.samsung.smartretail.mcd.vo.batch.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * JSON / XML MemberVO Entity 
 *
 */
@XmlType(name = "Report", propOrder = { "Date", "Impressions","Clicks","Earning" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@XStreamAlias("Report")
public class ReportVO {

	private String Date;
	private String Impressions;
	private String Clicks;
	private String Earning;
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getImpressions() {
		return Impressions;
	}
	public void setImpressions(String impressions) {
		Impressions = impressions;
	}
	public String getClicks() {
		return Clicks;
	}
	public void setClicks(String clicks) {
		Clicks = clicks;
	}
	public String getEarning() {
		return Earning;
	}
	public void setEarning(String earning) {
		Earning = earning;
	}

	
}