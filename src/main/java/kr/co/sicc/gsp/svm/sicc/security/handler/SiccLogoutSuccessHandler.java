package kr.co.sicc.gsp.svm.sicc.security.handler;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;  
  
public class SiccLogoutSuccessHandler implements LogoutSuccessHandler {  

	private String defaultUrl;
	
	@Override  
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
    		throws IOException, ServletException 
    {  
        System.out.println("onLogoutSuccess...");  
        if (authentication != null && authentication.getDetails() != null) {  
            try {  
            	request.getSession().invalidate();  
                System.out.println("User Successfully Logout");  
            } catch (IllegalStateException e) {  
                throw e; 
            }  
        }  
  
        response.setStatus(HttpServletResponse.SC_OK);  
        //redirect to login  
        request.getRequestDispatcher(defaultUrl).forward(request, response);
    }

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}  
} 
