package kr.co.sicc.gsp.svm.sicc.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class SiccAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private String loginIdName;				
	private String loginPwdName;			
	private String loginRedirectName;		
	private String exceptionMsgName;		
	private String defaultFailureUrl;		
	
	public SiccAuthenticationFailureHandler(){
		this.loginIdName = "id";
		this.loginPwdName = "pw";
		this.loginRedirectName = "loginRedirect";
		this.exceptionMsgName = "securityExceptionMsg";
		this.defaultFailureUrl = "/login";
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String loginId = request.getParameter(loginIdName);
		String loginPwd = request.getParameter(loginPwdName);
		String loginRedirect = request.getParameter(loginRedirectName);
		
		request.setAttribute(loginIdName, loginId);
		request.setAttribute(loginPwdName, loginPwd);
		request.setAttribute(loginRedirectName, loginRedirect);
		System.out.println(exception);		
		if(SessionAuthenticationException.class.isInstance(exception)) {
			request.setAttribute(exceptionMsgName, "Maximum.sessions.exceeded");			
		} else {
			request.setAttribute(exceptionMsgName, exception.getMessage());
		}
		
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
		//response.sendRedirect(defaultFailureUrl);
	}

	public String getLoginIdName() {
		return loginIdName;
	}


	public void setLoginIdName(String loginIdName) {
		this.loginIdName = loginIdName;
	}


	public String getLoginPwdName() {
		return loginPwdName;
	}


	public void setLoginPwdName(String loginPwdName) {
		this.loginPwdName = loginPwdName;
	}


	public String getLoginRedirectName() {
		return loginRedirectName;
	}


	public void setLoginRedirectName(String loginRedirectName) {
		this.loginRedirectName = loginRedirectName;
	}


	public String getExceptionMsgName() {
		return exceptionMsgName;
	}


	public void setExceptionMsgName(String exceptionMsgName) {
		this.exceptionMsgName = exceptionMsgName;
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}
}
