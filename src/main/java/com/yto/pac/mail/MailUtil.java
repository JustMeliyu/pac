package com.yto.pac.mail;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

import com.yto.pac.context.PacContext;
import com.yto.pac.util.FileUtil;


public class MailUtil {
	
	private static Logger log = Logger.getLogger(MailUtil.class);	
	//发送邮件
		public static void sendTo(int deadnum) throws Exception {
			String host = PacContext.sysConfig.getProperty("address");
			String port = PacContext.sysConfig.getProperty("port");
			String email = PacContext.sysConfig.getProperty("email");
			String emailpass = PacContext.sysConfig.getProperty("emailpass");
			String sendtoemail = PacContext.sysConfig.getProperty("sendtoemail");
			if(StringUtils.isBlank(host)
					|| StringUtils.isBlank(port)
					|| StringUtils.isBlank(email)
					|| StringUtils.isBlank(emailpass)
					|| StringUtils.isBlank(sendtoemail))
			{
				log.error("邮件参数未设置。");
				return;
			}
			Email mail = new SimpleEmail();
			mail.setHostName(host);
			mail.setSmtpPort(Integer.parseInt(port));
			mail.setAuthenticator(new DefaultAuthenticator(email, emailpass));
			mail.setCharset("UTF-8");// 必须放在前面，否则乱码
			mail.setSSLOnConnect(true);
			mail.setFrom(email);
			mail.setSubject("死信队列提醒");
			String msg = FileUtil.readFile(MailUtil.class.getClassLoader().getResourceAsStream("mail"));
			msg = msg.replace("{deadnum}", String.valueOf(deadnum));
			mail.setMsg(msg);
			mail.addTo(sendtoemail);
			mail.send();

		}
}
