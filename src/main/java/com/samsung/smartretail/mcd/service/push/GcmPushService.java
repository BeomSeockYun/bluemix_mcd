package com.samsung.smartretail.mcd.service.push;

public interface GcmPushService {

	/**
	 * 
	 * CGM, Google Push 을 이용한 메시지 전송 메쏘드
	 * 
	 * @param title      메시지 제목
	 * @param msg        메시지 
	 * @param userId     Push 대상 userId
	 * @return Boolean   true: success , false: fail
	 * @throws Exception 
	 */
	public Boolean sendPushMessage(String id,String title, String content, String userId) throws Exception;
	
	
	public  Boolean sendPushSrvMessage(String title, String content, String userId) throws Exception;
	
}
