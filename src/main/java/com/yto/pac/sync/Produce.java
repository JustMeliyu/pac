package com.yto.pac.sync;

import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yto.pac.context.PacContext;
import com.yto.pac.http.AESCoder;
import com.yto.pac.http.HttpHelper;
import com.yto.pac.http.ResponseData;
import com.yto.pac.pojo.HeaderData;
import com.yto.pac.pojo.OrderData;
import com.yto.pac.service.IPacService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class Produce implements Runnable {
	private Logger log = Logger.getLogger(Produce.class);	
	
	private final String KEY="camel:cainiao:trans:list";
	private final String DATE_PATTERN_1="yyyy-MM-dd HH:mm:ss";
	private final String REDIS_PASS="redis.pass";
	private final String REDIS_DBINDEX="redis.dbIndex";
	@Override
	public void run() {
		Jedis jedis = PacContext.sprinContext.getBean(Jedis.class);
		IPacService pacService = PacContext.sprinContext.getBean(IPacService.class);
		
		if(StringUtils.isNotBlank(PacContext.redisConfig.getProperty(REDIS_PASS)))
		{
			jedis.auth(PacContext.redisConfig.getProperty(REDIS_PASS));
		}
		if(StringUtils.isNotBlank(PacContext.redisConfig.getProperty(REDIS_DBINDEX)))
		{
			jedis.select(Integer.parseInt(PacContext.redisConfig.getProperty(REDIS_DBINDEX)));
		}
		//从reis获取运单号
		while(true)
		{
			try {
				log.info("从redis获取数据，阻塞等待");
				List<String> transNumbers=jedis.blpop(0,KEY);
				if(transNumbers == null)
					continue;
				log.info("获取数据运单号："+ transNumbers.get(1));
				OrderData order=pacService.getOrderData(transNumbers.get(1));
				
				if(order == null) continue;
				//
				Gson gson = new GsonBuilder().setDateFormat(DATE_PATTERN_1).serializeNulls().create(); 
				String logistics_interface = gson.toJson(order);
				log.info(logistics_interface);
				
				String charset = PacContext.sysConfig.getProperty("charset");
				 // 报文加密，日常加密key是：TxmGdfBw2E3D6F11jIBNlw== 线上：待定
				String logistics_interface_encry = encrypt(PacContext.sysConfig.getProperty("encryptkey"), 
						charset, logistics_interface);
				// 报文编码使用UTF-8，签名key日常是：workplatform，线上是: jNpKcyXrHfNJ
				String data_digest = doSign(logistics_interface, charset, PacContext.sysConfig.getProperty("signkey"));
				HeaderData header = new HeaderData("VEHICLE_TRACE","YTO",data_digest,"alphabet",logistics_interface_encry);
				ResponseData data = HttpHelper.requestPac(header);
				if(!data.getSuccess())
				{
					//失败则进入重试队列
					if(data.getRetryLater()== null || data.getRetryLater())
					{
						RetryEntity entity = new RetryEntity();
						entity.setData(order);
						entity.setTimes(1);
						entity.setUpdateTime(new Date());
						entity.setHeader(header);
						PacContext.retryQueue.offer(entity);
					}
				}
			}catch(JedisConnectionException e){
				log.error("redis connection error,please check redis config.");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			catch (Exception e) {
				log.error("request error",e);
			}
		}
		
	}

	public String encrypt(String encryKey, String charSet, String content) throws Exception {
        if (StringUtils.isBlank(encryKey)) {
            throw new Exception("[sec.encryption] is null");
        }
        // 解密
        try {
            byte[] key = Base64.decodeBase64(encryKey.getBytes(charSet));
            // content Base64解码
            byte[] inputData = content.getBytes(charSet);
            byte[] outputData = AESCoder.encrypt(inputData, key);
            content = new String(Base64.encodeBase64(outputData), charSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
	   /**
     * 请求报文签名
     * @param content
     * @param charset
     * @param keys
     * @return
     */
    public String doSign(String content, String charset, String keys) {
        String sign;
        content = content + keys;
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(content.getBytes(charset));
            sign = new String(Base64.encodeBase64(md.digest()), charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sign;
    }
}
