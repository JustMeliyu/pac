package com.yto.pac.sync;

import org.apache.log4j.Logger;

import com.yto.pac.context.PacContext;
import com.yto.pac.mail.MailUtil;

public class DeadObserver implements Runnable{
	private Logger log = Logger.getLogger(DeadObserver.class);	
	
	private final int ALETER_LEVEL=2000;
	@Override
	public void run() {
		int deadQueueTime = PacContext.sysConfig.getProperty("deadqueuetime") == null 
				? 86400000 : Integer.parseInt(PacContext.sysConfig.getProperty("deadqueuetime"));
		
		while(true)
		{
			try {
				if(PacContext.deadQueue.size()>ALETER_LEVEL)
					MailUtil.sendTo( PacContext.deadQueue.size());
			} catch (Exception e) {
				log.error("发送邮件失败",e);
			}
			
			try {
				Thread.sleep(deadQueueTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
