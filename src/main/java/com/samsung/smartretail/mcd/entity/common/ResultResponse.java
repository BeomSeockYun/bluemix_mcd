
package com.samsung.smartretail.mcd.entity.common;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@XmlType(name = "ResultResponse", propOrder = { "resultType", "result","successCount","failCount", "operationName", "errorCode","errorMessage" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "ResultResponse")
public class ResultResponse {

	
	private ResultType resultType;
	private String operationName;

	private Boolean result;
	private Integer successCount;
	private Integer failCount;
	
	private String errorCode;
	private String errorMessage;
	//private String requestId;

	
	public ResultType getResultType() {
		return resultType;
	}


	public void setResultType(ResultType value) {
		this.resultType = value;
	}


	public Boolean getResult() {
		return result;
	}
	
	
	public void setResult(Boolean result) {
		this.result = result;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String value) {
		this.errorCode = value;
	}
	

	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
//	public String getRequestId() {
//		return requestId;
//	}
//
//
//	public void setRequestId(String requestId) {
//		this.requestId = requestId;
//	}

	public String getOperationName() {
		return operationName;
	}


	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}	
	public Integer getSuccessCount() {
		return successCount;
	}


	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}


	public Integer getFailCount() {
		return failCount;
	}


	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	
   @Override
    public String toString(){
    	StringBuffer sb = new StringBuffer();
    	try{
	    	sb.append("ResultResponse:[operationName:: "+operationName+" -result::"+result+" - successCount::" +successCount+" - failCount::" +failCount
	    			+" - ResultType:: "+resultType +" - errorCode:: "+errorCode);	
	    	sb.append("]");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return sb.toString(); 
    }






}
