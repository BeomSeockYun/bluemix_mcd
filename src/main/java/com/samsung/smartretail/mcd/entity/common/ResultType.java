package com.samsung.smartretail.mcd.entity.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "ResultType")
@XmlEnum
public enum ResultType {
	@XmlEnumValue("SUCCESS")
	SUCCESS , 
	@XmlEnumValue("FAIL")
	FAIL
	;

	public String value() {
		return name();
	}

	public static ResultType fromValue(String v) {
		return valueOf(v);
	}

}
