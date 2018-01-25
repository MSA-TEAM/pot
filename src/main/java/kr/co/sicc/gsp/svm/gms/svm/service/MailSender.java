package kr.co.sicc.gsp.svm.gms.svm.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

/**
 * <pre>
 * com.gms.svm.service
 * MailSender.java
 * Description :
 * 	메일 서비스
 * History     :
 * </pre>
 *
 * @author	 : gypark
 * @Date	 : 2017. 8. 03.
 * @Version : 1.0
 *
 */

public interface MailSender {
	
	void send(SimpleMailMessage simpleMessage) throws MailException; 
	
	void send(SimpleMailMessage[] simpleMessages) throws MailException;
}
