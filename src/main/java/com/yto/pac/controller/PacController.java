package com.yto.pac.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yto.pac.context.PacContext;
import com.yto.pac.http.HttpHelper;
import com.yto.pac.sync.RetryEntity;

@Controller
public class PacController {
	private Logger log = Logger.getLogger(PacController.class);	
	private final Integer SUCCESS=1;
	@RequestMapping(value="/admin/home",method=RequestMethod.GET)
	public String main_get()
	{
		return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login_get() {
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login_post(String username,String password) {
		
		try {
			//shiro授权认证
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){ //如果用户已登录，先踢出
				SecurityUtils.getSecurityManager().logout(subject);
			}
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			return "successful";
		} catch (IncorrectCredentialsException e) {  
        	return "unkownCredentials";
        } catch (AuthenticationException e) {  
        	return "false";
        }		
	}
	@RequestMapping(value="/cleandeadlist",method=RequestMethod.POST)
	@ResponseBody
	public int cleanDeadlist(){
		PacContext.deadQueue.clear();
		return SUCCESS;
	} 
	@RequestMapping(value="/resend",method=RequestMethod.POST)
	@ResponseBody
	public int resend(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				RetryEntity entity = null;
				
				while((entity = PacContext.deadQueue.poll())!=null)
				{
					log.info("重试发送，运单号："+entity.getData().getVehicleNo()+",重试次数："+entity.getTimes());
					log.info("死信队列个数："+PacContext.deadQueue.size());
					HttpHelper.requestPac(entity.getHeader());
				}				
			}
		}).start();
		
		return SUCCESS;
	} 
	@RequestMapping(value="/deadsize",method=RequestMethod.POST)
	@ResponseBody
	public int getsize()
	{
		return PacContext.deadQueue.size();
	}
}
