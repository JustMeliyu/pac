package com.yto.pac.sync;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.yto.pac.context.PacContext;
import com.yto.pac.http.HttpHelper;
import com.yto.pac.http.ResponseData;

public class Consumer implements Runnable{
	private Logger log = Logger.getLogger(Consumer.class);	
	
	private final Integer TIMES_1 = 5*1000;
	private final Integer TIMES_2 = 60*1000;
	private final Integer TIMES_3 = 20*60*1000;
	@Override
	public void run() {
		
		while(true)
		{
			while(PacContext.retryQueue.size()>=1) {
				RetryEntity entity = PacContext.retryQueue.poll();
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				Long cur = cal.getTimeInMillis();
				cal.setTime(entity.getUpdateTime());
				Long queueTime = cal.getTimeInMillis();
				if((entity.getTimes() == 1 && (cur-queueTime)>TIMES_1)
						||(entity.getTimes() == 2 && (cur-queueTime)>TIMES_2)
						||(entity.getTimes() == 3 && (cur-queueTime)>TIMES_3))
				{
					log.info("重试发送，运单号："+entity.getData().getVehicleNo()+",重试次数："+entity.getTimes());
					log.info("重试队列个数："+PacContext.retryQueue.size());
					ResponseData data = HttpHelper.requestPac(entity.getHeader());
					if(!data.getSuccess())
					{
						//失败，并且需要重试则进入重试队列
						if(data.getRetryLater()== null || data.getRetryLater())
						{

							entity.setTimes(entity.getTimes()+1);
							entity.setUpdateTime(new Date());
							PacContext.retryQueue.offer(entity);
						}
					}
				}else if(entity.getTimes()>3)
				{
					//进入死信队列
					PacContext.deadQueue.offer(entity);
				}else {
					//其他情况，重新进入队列
					PacContext.retryQueue.offer(entity);
				}
				
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
