package kr.co.sicc.gsp.svm.sicc.security.handler;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//import com.syaku.rest.commons.ResponseResult;

@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    private String loginFormUrl;
    private String deniedFwdUrl;
    private boolean redirect;

    public String getLoginFormUrl() {
        return loginFormUrl;
    }

    public void setLoginFormUrl(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }

	public String getDeniedFwdUrl() {
		return deniedFwdUrl;
	}

	public void setDeniedFwdUrl(String deniedFwdUrl) {
		this.deniedFwdUrl = deniedFwdUrl;
	}

	public boolean isRedirect() {
		return redirect;
	}	

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
    public UnauthorizedEntryPoint() {

    }

    public UnauthorizedEntryPoint(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String accept = request.getHeader("accept");

    	String qstr = request.getQueryString()==null?"":"?"+request.getQueryString();
    	    	
    	System.out.println("url = "+request.getRequestURL()+qstr);
    	
        String prevPage = String.valueOf(URLEncoder.encode(request.getRequestURL()+qstr, "UTF-8"));
        
        request.getSession().setAttribute("prevPage", prevPage);
        
        
//        if( StringUtils.indexOf(accept, "html") > -1 || StringUtils.indexOf(accept, "*/*") > -1) {
//            response.sendRedirect(loginFormUrl);
//            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Authentication token was either missing or invalid.");
//        } else {
//            // forward access_denied
//        	System.out.println("commence... : accept = "+accept);
//			request.getRequestDispatcher(deniedFwdUrl).forward(request, response);
//			//response.sendRedirect(deniedFwdUrl);
//        }
    	System.out.println("commence... : accept = "+accept);
        if( StringUtils.indexOf(accept, "application/json") > -1 ) {
			request.getRequestDispatcher(deniedFwdUrl).forward(request, response);
        } else {
            response.sendRedirect(loginFormUrl);
        }
    }

}