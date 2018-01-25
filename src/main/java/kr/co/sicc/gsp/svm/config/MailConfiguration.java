package kr.co.sicc.gsp.svm.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {

	@Value("${mail.smtp.host}")
	String host;
 
	@Value("${mail.smtp.port}")
	String port;
 
	@Value("${mail.smtp.user}")
	String user;
 
	@Value("${mail.smtp.password}")
	String password;

	@Bean(autowire=Autowire.BY_NAME)
	public JavaMailSender mailSender()
	{	
		JavaMailSenderImpl sender = new JavaMailSenderImpl();		
		sender.setUsername(user);
		sender.setPassword(password);
		sender.setJavaMailProperties(getMailProperties());
		return sender;
	}
 
	private Properties getMailProperties()
	{
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.ssl.trust", host);
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.port", port);
		properties.setProperty("mail.smtp.socketFactory.port", port);
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");		
		return properties;
	}
	
}
