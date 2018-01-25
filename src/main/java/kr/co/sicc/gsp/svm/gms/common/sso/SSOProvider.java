package kr.co.sicc.gsp.svm.gms.common.sso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.DeflaterOutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import kr.co.sicc.gsp.svm.gms.common.sso.serviceprovider.saml.util.SamlException;
import kr.co.sicc.gsp.svm.gms.common.sso.serviceprovider.saml.util.Util;

public class SSOProvider {
	
	private static Random random = new Random();
	private static final char[] charMapping = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p' };
	
	private static final String IDP_COOKIE_TOKEN = "exp_idp_token";
	private static final String SP_COOKIE_TOKEN = "brp_sp_token";
	private static final String COOKIE_DOMAIN = ".pyeongchang2018.com";
	private static final int COOKIE_AGE = 1*60*60;
	private static final boolean COOKIE_SECURE = true;
	
	public static String createAuthRequest(String acsUrl, String providerName){
		StringBuilder authnRequestXML = new StringBuilder();
		authnRequestXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><samlp:AuthnRequest xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\" ID=\"")
			.append(createID())
			.append("\" IssueInstant=\"")
			.append(Util.getDateAndTime())
			.append("\" Version=\"2.0\" ProtocolBinding=\"urn:oasis:names.tc:SAML:2.0:bindings:HTTP-Redirect\" ProviderName=\"")
			.append(providerName)
			.append("\" AssertionConsumerServiceURL=\"")
			.append(acsUrl)
			.append("\"/>");
		return authnRequestXML.toString();
	}
	
	public static String createID() {
		byte[] bytes = new byte[20]; // 160 bits
		random.nextBytes(bytes);

		char[] chars = new char[40];

		for (int i = 0; i < bytes.length; i++) {
			int left = (bytes[i] >> 4) & 0x0f;
			int right = bytes[i] & 0x0f;
			chars[i * 2] = charMapping[left];
			chars[i * 2 + 1] = charMapping[right];
		}

		return String.valueOf(chars);
	}
	
	public static String computeURL(String idpUrl, String authnRequest, String returnPage) throws SamlException, IOException {
		StringBuilder buf = new StringBuilder();
		try {
			buf.append(idpUrl);
			buf.append("?SAMLRequest=");
			buf.append(encodeMessage(authnRequest));
			buf.append("&returnPage=");
			buf.append(URLEncoder.encode(returnPage, "UTF-8"));
			return buf.toString();
		} catch (UnsupportedEncodingException e) {
			throw new SamlException(
					"Error encoding SAML Request into URL: Check encoding scheme - "+ e.getMessage());
		}
	}

	public static String computeLogoutURL(String idpUrl, String returnPage) throws SamlException, IOException {
		StringBuilder buf = new StringBuilder();
		try {
			buf.append(idpUrl);
			buf.append("?returnPage=");
			buf.append(URLEncoder.encode(returnPage, "UTF-8"));
			return buf.toString();
		} catch (UnsupportedEncodingException e) {
			throw new SamlException(
					"Error encoding SAML Request into URL: Check encoding scheme - "+ e.getMessage());
		}
	}
	
	public static String encodeMessage(String xmlString) throws IOException, UnsupportedEncodingException {
		byte[] xmlBytes = xmlString.getBytes("UTF-8");
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteOutputStream);
		deflaterOutputStream.write(xmlBytes, 0, xmlBytes.length);
		deflaterOutputStream.close();
		Base64 base64Encoder = new Base64();
		byte[] base64EncodedByteArray = base64Encoder.encode(byteOutputStream.toByteArray());
		String base64EncodedMessage = new String(base64EncodedByteArray);
		String urlEncodedMessage = URLEncoder.encode(base64EncodedMessage, "UTF-8");
		return urlEncodedMessage;
	}
	
	public static String getDateAndTime() {
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		Date date = new Date();
		return dayFormat.format(date) + 'T' + timeFormat.format(date) + 'Z';
	}
	
	public static String getSpDomainUrl(HttpServletRequest request) {
		String spDomainUrl = "";
		
		if(SSOProvider.COOKIE_SECURE)
			spDomainUrl += "https://";
		else 
			spDomainUrl += request.getScheme() + "://";
		
		spDomainUrl += request.getServerName();
		
		if(request.getServerPort() != 80)
			spDomainUrl += ":" + request.getServerPort();
		
		spDomainUrl += request.getContextPath();
		
		return spDomainUrl;
    }
	public static String getIdpCookieTokenNm() {    	
    	return SSOProvider.IDP_COOKIE_TOKEN;    	
    }
	public static String getSpCookieTokenNm() {				
		return SSOProvider.SP_COOKIE_TOKEN;
    }
	public static boolean checkCookies(HttpServletRequest request) {
        String idpToken = "";
        String gmsToken = "";
        if(request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
                if(getIdpCookieTokenNm().equals(cookie.getName())){
                    idpToken = cookie.getValue();
                }
                if(getSpCookieTokenNm().equals(cookie.getName())) {
                	gmsToken = cookie.getValue();
                }
            }
        }
        
    	if(idpToken == null || idpToken.equals("")){
        	//인증서버토큰이 존재 하지 않을 경우 로그아웃처리
    		return false;
    	}else{
        	if(!idpToken.equals(gmsToken)){
            	//인증서버 쿠키와 복사한 쿠키값이 서로 다를 경우 로그아웃처리
        		return false;
        	}
    	}
    	return true;
    }
	public static void createCookies(HttpServletRequest request, HttpServletResponse response) {
        String idpToken = "";
        if(request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
                if (getIdpCookieTokenNm().equals(cookie.getName())){
                    idpToken = cookie.getValue();
                }
            }
        }
    	
        Cookie cookie = new Cookie(getSpCookieTokenNm(), idpToken);
        cookie.setPath("/");  
        cookie.setMaxAge(SSOProvider.COOKIE_AGE);
        cookie.setHttpOnly(true);
        cookie.setDomain(SSOProvider.COOKIE_DOMAIN);
        cookie.setSecure(SSOProvider.COOKIE_SECURE);
        response.addCookie(cookie);
    }

	public static void deleteCookies(HttpServletRequest request, HttpServletResponse response) {
        if(request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
                if (getSpCookieTokenNm().equals(cookie.getName())){
                    cookie.setPath("/");  
                    cookie.setMaxAge(0);
                    cookie.setHttpOnly(true);
                    cookie.setDomain(SSOProvider.COOKIE_DOMAIN);
                    cookie.setSecure(SSOProvider.COOKIE_SECURE);
                    response.addCookie(cookie);
                    break;
                }
                if (getIdpCookieTokenNm().equals(cookie.getName())){
                    cookie.setPath("/");  
                    cookie.setMaxAge(0);
                    cookie.setHttpOnly(true);
                    cookie.setDomain(SSOProvider.COOKIE_DOMAIN);
                    cookie.setSecure(SSOProvider.COOKIE_SECURE);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

	public static void updateCookies(HttpServletRequest request, HttpServletResponse response) {
        if(request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
                if (getSpCookieTokenNm().equals(cookie.getName())){
                    cookie.setPath("/");  
                    cookie.setMaxAge(SSOProvider.COOKIE_AGE);
                    cookie.setHttpOnly(true);
                    cookie.setDomain(SSOProvider.COOKIE_DOMAIN);
                    cookie.setSecure(SSOProvider.COOKIE_SECURE);
                    response.addCookie(cookie);
                }
                if (getIdpCookieTokenNm().equals(cookie.getName())){
                    cookie.setPath("/");  
                    cookie.setMaxAge(SSOProvider.COOKIE_AGE);
                    cookie.setHttpOnly(true);
                    cookie.setDomain(SSOProvider.COOKIE_DOMAIN);
                    cookie.setSecure(SSOProvider.COOKIE_SECURE);
                    response.addCookie(cookie);
                }
            }
        }
    }
}
