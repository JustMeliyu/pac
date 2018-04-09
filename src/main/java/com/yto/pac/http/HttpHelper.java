package com.yto.pac.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.yto.pac.context.PacContext;
import com.yto.pac.pojo.HeaderData;

public class HttpHelper {
	private static Logger log = Logger.getLogger(HttpHelper.class);	
	
	public static ResponseData requestPac(HeaderData header)
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(PacContext.sysConfig.getProperty("pacurl"));
		post.addHeader("Content-Type","application/x-www-form-urlencoded;charset="+PacContext.sysConfig.getProperty("charset"));
		post.addHeader("Character Encoding",PacContext.sysConfig.getProperty("charset"));
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("logistics_interface", header.getLogistics_interface()));
        formparams.add(new BasicNameValuePair("logistic_provider_id", header.getLogistic_provider_id()));
        formparams.add(new BasicNameValuePair("msg_type", header.getMsg_type()));
        formparams.add(new BasicNameValuePair("data_digest", header.getData_digest()));
        formparams.add(new BasicNameValuePair("to_code", header.getTo_code()));
        CloseableHttpResponse response =null;
        ResponseData data =new ResponseData(false);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,PacContext.sysConfig.getProperty("charset"));			
			post.setEntity(entity);
			
			log.info("pac request start");
			response = httpClient.execute(post);
			
			int sc = response.getStatusLine().getStatusCode();
			String result = EntityUtils.toString(response.getEntity(),PacContext.sysConfig.getProperty("charset"));
			log.info(result);
			if(sc==200)
			{				
				Gson gson = new Gson();
				data = gson.fromJson(result, ResponseData.class);				
			}
			
		} catch (Exception e) {
			log.error(e);
		}finally{
			if(response != null)
				try {
					response.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			post.abort();
			// 关闭连接,释放资源
            try {
            	httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		
		return data;
	}
	
}
