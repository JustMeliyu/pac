package com.yto.pac.context;

import java.util.Properties;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.ApplicationContext;

import com.yto.pac.sync.RetryEntity;

public class PacContext {
	//重试队列
	public static ConcurrentLinkedQueue<RetryEntity> retryQueue = new ConcurrentLinkedQueue<RetryEntity>();
	//死信队列
	public static ConcurrentLinkedQueue<RetryEntity> deadQueue = new ConcurrentLinkedQueue<RetryEntity>();
	
	//
	public static ApplicationContext sprinContext;
	//系统配置
	public static Properties sysConfig;
	//redis配置
	public static Properties redisConfig;
	
}
