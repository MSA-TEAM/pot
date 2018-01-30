package kr.co.sicc.gsp.svm.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebInitConfiguration implements ServletContextInitializer{
	private static final String CONFIG_LOCATION = "ckr.co.sicc.gsp.svm.config";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(RequestContextListener.class);
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setDisplayName("contextConfigLocation");
		webApplicationContext.setConfigLocation(CONFIG_LOCATION);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
		dispatcher.setLoadOnStartup(1);
	}
}
