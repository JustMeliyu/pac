package com.yto.pac.listener;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yto.pac.context.PacContext;
import com.yto.pac.sync.Consumer;
import com.yto.pac.sync.DeadObserver;
import com.yto.pac.sync.Produce;


public class PACListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		
		PacContext.sprinContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context.getServletContext());
		
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
			PacContext.sysConfig = prop;
			
			prop = new Properties();
			prop.load(this.getClass().getClassLoader().getResourceAsStream("redis.properties"));
			PacContext.redisConfig = prop;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//生产者
		new Thread(new Produce()).start();
		//消费者
		new Thread(new Consumer()).start();
		//死信队列报警
		new Thread(new DeadObserver()).start();
	}

}
