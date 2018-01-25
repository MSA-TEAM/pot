<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Locale"%>
<%@page import="org.springframework.web.servlet.i18n.SessionLocaleResolver"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="kr.co.sicc.gsp.svm.gms.common.login.UserInfo"%>
<%@page import="kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="shortcut icon" href="/images/favicon.png" type="image/x-icon" />
<link rel="icon" href="/images/favicon.png" type="image/x-icon" />
<%
	Locale locale = (Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
	String lang = null; 
	if(locale == null){
		locale = RequestContextUtils.getLocale(request);
		lang = locale.getLanguage();
	}else{
		lang = locale.getLanguage();
	}
	if( !"in".equalsIgnoreCase(lang) ){
		lang = "en";
	}
	boolean isLogin = false;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//UserInfo user = (UserInfo)session.getAttribute("userInfo");
	SVMUserVO user = (SVMUserVO)session.getAttribute("SVMUserVO");
	
	if(auth != null && auth.getPrincipal() != null && !"anonymousUser".equals(String.valueOf(auth.getPrincipal()))){
		isLogin = true;
	}
	
	//개발
	String scheme = ((HttpServletRequest)pageContext.getRequest()).isSecure() ? "https" : "http";
	
	//운영
// 	String scheme = "https";
	
	String serverName = request.getServerName();
	String serverPort = String.valueOf(request.getServerPort());
	
	StringBuffer path = new StringBuffer();
	path.append(scheme).append("://").append(serverName);
	
	StringBuffer langPath = new StringBuffer();
	
	langPath.append(scheme).append("://").append(serverName);
	
	StringBuffer ImgPath = new StringBuffer();
	ImgPath.append(scheme).append("://").append(serverName);
	
	if(serverPort != null && !"".equals(serverPort) && ",80,443,8443,".indexOf(","+serverPort+",") < 0){
		path.append(":").append(serverPort);
		langPath.append(":").append(serverPort).append("/").append(lang);
		ImgPath.append(":").append(serverPort).append("/images/").append(lang);
	}else{
		langPath.append("/").append(lang);
		ImgPath.append("/images/").append(lang);
	}
	
	String contextPath = path.toString();
	String contextLangPath = langPath.toString();
	String contextImgPath = ImgPath.toString();
	String controlUrl = String.valueOf(request.getAttribute("javax.servlet.forward.request_uri"));
	String system_cd = "";
	if(controlUrl.length() > 7){
		Pattern regx = Pattern.compile("/(id|en)/");
		Matcher m = regx.matcher(controlUrl);
		
		while(m.find()){
			system_cd = controlUrl.substring(m.end());
			system_cd = system_cd.substring(0, 3);
		}
		controlUrl = controlUrl.substring(4);
	}
	String sicc_prev_page = String.valueOf(session.getAttribute("sicc_prev_page"));
	// kimjw SSO
	String logoutUrl = session.getAttribute("logoutUrl")==null ? "/logout":(String)session.getAttribute("logoutUrl");
	//jhlee date check, gameType check
// 	String curDate = session.getAttribute("curDate")==null ? "":(String)session.getAttribute("curDate");
// 	String gameType = session.getAttribute("gameType")==null ? "":(String)session.getAttribute("gameType");
%>
