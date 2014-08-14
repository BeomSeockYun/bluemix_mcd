package com.samsung.smartretail.mcd.service.push.impl;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
//import com.google.android.gcm.server.*;
import com.samsung.smartretail.mcd.common.util.IdGenerator;
import com.samsung.smartretail.mcd.service.push.GcmPushService;

@Service
public class GcmPushServiceImpl implements GcmPushService{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    // Spring EL 로 값 가져오기 spring-context.xml - <util:properties id="appProperties" 	location="classpath:/conf/properties/application.properties" />
	@Value("#{appProperties['push.proxy.useYn']}") private String useProxyYn;
	@Value("#{appProperties['push.proxy.ip']}") private String proxyIp;
	@Value("#{appProperties['push.apikey']}") private String apiKey;
	@Value("#{appProperties['push.mananger.registeration.id']}") private String regstrationId;
	
	@Autowired IdGenerator idGenerator;

/**
 * 
 * CGM, Google Push 을 이용한 메시지 전송 메쏘드
 * 
 * 현재는 application.properites에서 읽어와서 push하고 있음
 * 현재는 방화벽 안쪽이라 Proxy 세팅에 의해 작동함
 * @param title      메시지 제목
 * @param msg        메시지 
 * @param userId     Push 대상 userId
 * @return Boolean   true: success , false: fail
 * @throws Exception 
 */
public  Boolean sendPushMessage(String id,String title, String content, String userId) throws Exception {
	
	logger.debug("sendMessage() >>> userId::"+userId+" - title:: "+title +" - content::"+content +"- apiKey:: "+ apiKey+" - regstrationId"+regstrationId);
	logger.debug("sendMessage() >>> +++ useProxyYn::"+useProxyYn +" - proxyIp"+proxyIp);


	String pushId = idGenerator.generatePushId();
	logger.debug("sendMessage() >>> +++ pushId::"+pushId);


try {

	
	/**
 * 현재는 application.properites에서 읽어와서 push하고 있음
 * 
 * TO-DO 
 * table user 에서 user_id 를 키로  push_register_key 를 가져와서 사용해야 함
 * 
 * */
   
URI uri = URIUtils.createURI("https", "android.googleapis.com", 443, "/gcm/send", null, null);
HttpPost post = new HttpPost(uri);
post.addHeader("Accept", "application/json");
post.addHeader("Content-Type","application/json; charset=UTF-8");
//post.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36");
post.addHeader("Authorization", "key="+apiKey);
//post.addHeader("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
//post.addHeader("Accept-Encoding", "gzip,deflate,sdch");
logger.debug("uri: " + uri);

HttpClient httpclient =  getHttpClient();


if (useProxyYn.equalsIgnoreCase("Y")){
/* proxy setting START  */
HttpHost proxy = new HttpHost(proxyIp, 8080);    	    
httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,  proxy);
/* proxy setting END  */    	    
}else{
//No Operation	
}


StringBuffer sb = new StringBuffer();

sb.append("{");
sb.append("\"registration_ids\": [ \""+regstrationId);
sb.append("\"], ");
sb.append("\"data\": { \"id\": \""+id+ "\", \"title\": \""+title+ "\", \"content\": \""+content);
sb.append("\"}");

sb.append("}");


logger.debug("sendMessage() >>> reqEntity: " + sb.toString());


StringEntity reqEntity = new StringEntity(sb.toString());
HttpResponse response =  null;
 try{

	post.setEntity(reqEntity);
	
    logger.debug("sendMessage() >>> post: " + post.getRequestLine());

response = httpclient.execute(post);

logger.debug("sendMessage() >>> response: >>> StatusLine:: " + response.getStatusLine());

HttpEntity entity = response.getEntity();

if( entity != null ) {
	
	if (entity != null) {
        String resp = EntityUtils.toString(entity,"UTF-8");
        logger.debug("sendMessage() >>> responseData ::: "+ resp );
        
        //{"multicast_id":6630043253530097859,"success":1,"failure":0,"canonical_ids":0,"results":[{"message_id":"0:1406531499166725%ceade3c1f9fd7ecd"}]}
        
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(resp);
        
        Long multicast_id = (Long) jsonObject.get("multicast_id");
        Long success = (Long) jsonObject.get("success");
        Long failure = (Long) jsonObject.get("failure");
        Long canonical_ids = (Long) jsonObject.get("canonical_ids");

        logger.debug("sendMessage() >>> responseData ::: multicast_id:: "+ multicast_id+" - success::"+success+" - failure::"+failure+" - canonical_ids::"+canonical_ids );
        
        
        JSONArray results= (JSONArray) jsonObject.get("results");
        
        List<String>mids = new ArrayList<String>();
        
        @SuppressWarnings("rawtypes")
		Iterator i = results.iterator();

        while (i.hasNext()) {
        	
        	JSONObject innerObj = (JSONObject) i.next();

        	String message_id = (String) innerObj.get("message_id");
        	mids.add(message_id);               
        
        }


        StringBuffer sb1 =new StringBuffer();
        for (String m: mids){
        	sb1.append(m+" ");
        }
        
        logger.debug("sendMessage() >>> responseData ::: message_id:: "+sb1.toString() );
	            
	        }
	    }
	    
	 }catch(Exception e){
          e.printStackTrace();
     }
		 
	 
	 if (response.getStatusLine().getStatusCode()==200){
	
		 return true;
		 
	 }else{
		 
		 return false;	 
	 }

} catch (Exception e) {
	
	e.printStackTrace();
	logger.debug("sendMessage() >>> pushId:::"+pushId+" Error::" + e.getMessage());
		
		return false;
	}

}

    

    
/**
 * 
 * CGM, Google Push 을 이용한 메시지 전송 메쏘드
 * 
 * 현재는 application.properites에서 읽어와서 push하고 있음
 * <<주의!>> 현재는 방화벽 안쪽이라 Proxy세팅이 안되서 작동하지 않음
 * @param title      메시지 제목
 * @param msg        메시지 
 * @param userId     Push 대상 userId
 * @return Boolean   true: success , false: fail
 * @throws Exception 
 */
public  Boolean sendPushSrvMessage(String title, String content, String userId) throws Exception {
	
	logger.debug("sendMessage() >>> userId::"+userId+" - title:: "+title +" - content::"+content );
	logger.debug("sendMessage() >>> apiKey:: "+ apiKey+" - regstrationId:: "+regstrationId);
	
	String pushId = idGenerator.generatePushId();
	logger.debug("sendMessage() >>> +++ pushId::"+pushId);
	
		
		/**
		 * 현재는 application.properites에서 읽어와서 push하고 있음
		 * 
		 * TO-DO 
		 * table user 에서 user_id 를 키로  push_register_key 를 가져와서 사용해야 함
		 * 
		 * */
	       
		 Sender sender = new Sender(apiKey);  //구글 코드에서 발급받은 서버 키
		 Message message = new Message.Builder()
		                                               .addData("title", title)  //데이터 추가
		                                               .addData("content", content)  //데이터 추가
		                                               .build();

		   //푸시 전송. 파라미터는 푸시 내용, 보낼 단말의 id 
		   Result result = null;

		   try{
		    result = sender.send(message, regstrationId, 3);
		  
			   //결과 처리
			   if(result.getMessageId() != null) {
			      //푸시 전송 성공
		
					 return true;
			   }
			   else {
			      String error = result.getErrorCodeName();   //에러 내용 받기
	
			      //에러 처리
			      if(Constants.ERROR_INTERNAL_SERVER_ERROR.equals(error)) {
			         //구글 푸시 서버 에러
			      }
					 return false;	 
			   }
		   
		   }catch (Exception e) {
			
			e.printStackTrace();
			logger.debug("sendPushSrvMessage() >>> pushId:::"+pushId+" Error::" + e.getMessage());
			
				return false;
		  }

}

private HttpClient getHttpClient() {
    try {

        SSLSocketFactory sf = buildSSLSocketFactory();

        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(new Scheme("https", sf, 443));

        ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

        return new DefaultHttpClient(ccm, params);
    } catch (Exception e) {
        return new DefaultHttpClient();
    }
}

private SSLSocketFactory buildSSLSocketFactory() {
	TrustStrategy ts = new TrustStrategy() {
		@Override
		public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
			return true; // heck yea!
		}
	};

	SSLSocketFactory sf = null;

	try {
		/* build socket factory with hostname verification turned off. */
		sf = new SSLSocketFactory(ts, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	} catch (NoSuchAlgorithmException e) {
		logger.error("Failed to initialize SSL handling.", e);
	} catch (KeyManagementException e) {
		logger.error("Failed to initialize SSL handling.", e);
	} catch (KeyStoreException e) {
		logger.error("Failed to initialize SSL handling.", e);
	} catch (UnrecoverableKeyException e) {
		logger.error("Failed to initialize SSL handling.", e);
	}

	return sf;
}

}
