
package com.samsung.smartretail.mcd.entity.auth;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.samsung.smartretail.mcd.entity.common.ResultResponse;


@XmlType(name = "AuthResponse", propOrder = { "resultResponse" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "AuthResponse")
public class AuthResponse {

	
	private ResultResponse resultResponse;



	public ResultResponse getResultResponse() {
		return resultResponse;
	}
	
	
	
	
	public void setResultResponse(ResultResponse resultResponse) {
		this.resultResponse = resultResponse;
	}

	
	
   @Override
    public String toString(){
    	StringBuffer sb = new StringBuffer();
    	try{
	    	sb.append("AuthResponse {ResultResponse:[operationName:: "+resultResponse.getOperationName()+" -result::"+resultResponse.getResult()+" - successCount::" +resultResponse.getSuccessCount()+" - failCount::" +resultResponse.getFailCount()
	    			+" - ResultType:: "+resultResponse.getResultType() +" - errorCode:: "+ resultResponse.getErrorCode() +" - errorMessage:: "+ resultResponse.getErrorMessage() );	
	    	sb.append("] }");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return sb.toString(); 
    }








}
