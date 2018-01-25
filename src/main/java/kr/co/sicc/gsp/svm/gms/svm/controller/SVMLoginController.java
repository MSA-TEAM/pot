package kr.co.sicc.gsp.svm.gms.svm.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sicc.gsp.svm.gms.common.sso.SSOProvider;
import kr.co.sicc.gsp.svm.gms.common.sso.serviceprovider.saml.util.SamlException;
import kr.co.sicc.gsp.svm.gms.svm.service.SVMSiccUserService;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;
import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.common.vo.ResponseVO;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;


/**
 * <pre>
 * com.gms.svm.controller
 * SVMLoginController.java
 * Description :
 *
 * History     :
 * </pre>
 *
 * @author	 : gypark
 * @Date	 : 2017. 8. 11.
 * @Version : 1.0
 *
 */
@Controller
public class SVMLoginController  extends SiccController {
	private static final Logger logger = LoggerFactory.getLogger(SVMLoginController.class);

	@Autowired
	@Resource(name="svmSiccUserService")
	private SVMSiccUserService svmSiccUserService;

	// kimjw sso
	@Autowired
	@Resource(name="siccProperties")
	private Properties properties;

	@Autowired
	//@Qualifier("SICC_SSO")
	@Value("${settings.SICC_SSO}")
	private Boolean SICC_SSO;

	@Autowired
	//@Qualifier("SICC_SYSTEM")
	@Value("${settings.SICC_SYSTEM}")
    private String SICC_SYSTEM;

//	@Autowired
//	private SessionAuthenticationStrategy sessionAuthenticationStrategy;

	public SVMLoginController(){
	}

//    /**
//     * Description
//     *
//     * @Version : 1.0
//     * @Method login
//     * @param request
//     * @param session
//     * @return
//     */
    @RequestMapping("/loginSVM")
    public String login(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	logger.info("loginSVM");

    	if(SICC_SSO) {
    		return "redirect:/";
    	}
    	
//    	if(request.getParameterMap().containsKey("error")) {
//        	return "/common/login/loginErr";
//    	}
    	if(request.getParameterMap().containsKey("relogin")) {
        	logger.info("relogin");
    	} else if(request.getParameterMap().containsKey("logout")) {
        	logger.info("logout");

        	SVMUserVO user = (SVMUserVO)session.getAttribute("SVMUserVO");
        	if(user != null){
        		svmSiccUserService.logout(user);
        	}

        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        	if (auth != null && auth.getPrincipal() != null && !"anonymousUser".equals(auth.getPrincipal().toString())){
        		new SecurityContextLogoutHandler().logout(request, response, auth);
        	}
        	
    	}

    	model.addAttribute("sicc_system", SICC_SYSTEM);
    	return "/svm/common/login";
    }

    @RequestMapping("/logoutSVM")
    public String logout(Locale locale, HttpServletRequest request, HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) {
    	logger.info("logout");
    	SVMUserVO user = (SVMUserVO)session.getAttribute("SVMUserVO");
    	if(user != null){
    		svmSiccUserService.logout(user);
    	}
    	
    	if(session.getAttribute("securityExceptionMsg") != null){
    		redirectAttributes.addFlashAttribute("securityExceptionMsg", ""+session.getAttribute("securityExceptionMsg"));
    	}
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (auth != null && auth.getPrincipal() != null && !"anonymouxsUser".equals(auth.getPrincipal().toString())){
    		new SecurityContextLogoutHandler().logout(request, response, auth);
    	}
    	session = request.getSession(true);
    	session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
    	return "redirect:/";
    }

    @RequestMapping("/login_successSVM")
    public String login_success(Locale locale, HttpSession session,  HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
    	logger.info("login_success");
    	SVMUserVO user = (SVMUserVO)session.getAttribute("SVMUserVO");
    	user.setCp_cd(request.getParameter("cp_cd")==null?"":request.getParameter("cp_cd"));
    	// 로그인 성공처리
    	svmSiccUserService.loginSuccess(user);
    	// 추가 세션 정보 셋팅
//    	session.setAttribute("addSVMUserVO", addUserSession(user));
    	// 중복로그인 체크용
    	session.setAttribute("username", user.getUsername());

    	if(SICC_SSO) {
    		session.setAttribute("prevPage", request.getParameter("returnPage"));
    	} else {
    		try {
    			session.setAttribute("prevPage", URLDecoder.decode(session.getAttribute("prevPage").toString(), "UTF-8"));
    		} catch(UnsupportedEncodingException e) {
    			e.printStackTrace();
    		} catch (SiccException e){
    			throw SiccMessageUtil.getError(e);
    		} catch (Exception e){
    			throw SiccMessageUtil.getError(e);
    		}
    	}
//    	redirectAttributes.addFlashAttribute("cp_cd", user.getCp_cd());

    	return "redirect:/";
    	//return "index";
    }

     //각 시스템마다 필요한 추가 session 정보
//    private Map<String, Object> addUserSession(SVMUserVO user) {
//    	SiccSessionService siccSession = null;
//    	Map<String, Object> infomap = new HashMap<>();
//    	switch(user.getCurrent_system_cd()){
//			case "BRP" :
//				//siccSession = new BRPSessionServiceImpl();
//				//infomap = siccSession.addUserSession(user);
//				break;
//		}
//
//		return infomap;
//    }

    @ResponseBody
    @RequestMapping("/login_duplicate_jsonSVM")
    public ResponseVO loginDuplicateJson(Locale locale, HttpSession session, HttpServletRequest request, HttpServletResponse response){
    	logger.info("login_duplicate_jsonSVM");
    	ResponseVO resvo = new ResponseVO();
    	SiccMessageUtil.saveError(resvo, getMessage("login.notlogon", locale), MessageConstants.SHOW_TYPE_POPUP);
    	resvo.setErrType("L");

    	return resvo;
    }
//
    @RequestMapping(value="/login_duplicateSVM")
    public String loginDuplicate(Locale locale, HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws SamlException, IOException{
    	logger.info("login_duplicate" + "  " + locale);
    	String accept = request.getHeader("accept");

    	// 제3언어 일 때 영어로 셋팅
    	if(locale == null || !"in".equals(locale.getLanguage())) {
    		locale = Locale.ENGLISH;
    	}
    	redirectAttributes.addFlashAttribute("securityExceptionMsg", getMessage("login.notlogon", locale));
    	
    	logger.info("login_duplicate... : accept = "+accept);
        if( StringUtils.indexOf(accept, "application/json") > -1 ) {
        	return "redirect:/not_login";
        } else {
        	return SICC_SSO ? "redirect:"+this.computeLogoutUrl(request):"redirect:/login";
        }
    }

//    @RequestMapping("/login_failSVM")
//    public String loginFail(Locale locale, HttpServletRequest request, RedirectAttributes redirectAttributes){
//    	logger.info("login_fail");
//    	logger.info(" locale - " +  locale);
//    	if( !"ko".equals(locale.getLanguage()) ){
//    		locale = Locale.ENGLISH;
//    	}
//    	String failMsg = request.getAttribute("securityExceptionMsg").toString();
//
//    	redirectAttributes.addFlashAttribute("securityExceptionMsg", getMessage(failMsg, locale));
//
//    	if(failMsg.equals("login.access.denied_failcnt")) {
//    		return "redirect:/login?error";
//    	} else {
//        	SVMUserVO user = new SVMUserVO();
//        	user.setUsername(request.getParameter("id")==null?"":request.getParameter("id"));
//        	user.setCp_cd(request.getParameter("cp_cd")==null?"":request.getParameter("cp_cd"));
//        	user.setUserIdx5(failMsg);
//        	siccUserService.loginFail(user);
//
//    		return "redirect:/login";
//    	}
//    }

//    @RequestMapping("/getSessionSVM")
//    @ResponseBody
//    public ResponseVO getSession(Locale locale, HttpSession session,  HttpServletRequest request){
//    	logger.info("getSession");
//
//    	//SVMUserVO user = (SVMUserVO)SecurityContextHolder.getContext().getAuthentication().getDetails();
//    	SVMUserVO user = (SVMUserVO)session.getAttribute("SVMUserVO");
////    	String cpCd = (String)session.getAttribute("cp_cd");
//
////    	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//
//    	ResponseVO resvo = new ResponseVO();
//    	if(user == null) {
//        	resvo.setErrType("L");
//	    	SiccMessageUtil.saveError(resvo, getMessage("login.user.expired", locale), MessageConstants.SHOW_TYPE_POPUP);
//    	} else {
//	    	Map<String, String> map = new HashMap<>();
//	    	map.put("user_id", user.getUsername());
//	    	map.put("user_nm", user.getUser_nm());
//	    	map.put("noc_cd", user.getUserNOCCd());
//	    	map.put("noc_nm", user.getUserNOCNm());
//	    	map.put("dept_cd", user.getUserDeptCd());
//	    	map.put("dept_nm", user.getUserDeptNm());
//	    	map.put("fa_cd", user.getUserFaCd());
//	    	map.put("fa_nm", user.getUserFaNm());
//	    	map.put("user_system_cd", user.getUserSystemCd());
//	    	map.put("assigned_group_cd", user.getUserGroupId());
//	    	map.put("venue_cd", user.getUserVenueCd());
//	    	map.put("system_cd", user.getCurrent_system_cd());
////	    	map.put("cp_cd", cpCd);
//
////	    	map.put("csrf_name", token.getParameterName());
////	    	map.put("csrf_token", token.getToken());
//
////	    	resvo.appendDataMap("info", map);
//	    	resvo.setSuccess(true);
//    	}
//
//    	return resvo;
//    }

//    @RequestMapping("/not_loginSVM")
//    @ResponseBody
//    public ResponseVO notLogin(Locale locale, HttpSession session, RedirectAttributes redirectAttributes){
//    	logger.info("not_login" + "  " + locale);
//    	ResponseVO resvo = new ResponseVO();    	
//
//    	// 제3언어 일 때 영어로 셋팅
//    	if(locale == null || !Locale.KOREAN.getLanguage().equals(locale.getLanguage())) {
//    		locale = Locale.ENGLISH;
//    	}
//    	redirectAttributes.addFlashAttribute("securityExceptionMsg", getMessage("login.notlogon", locale));
//    	session.setAttribute("securityExceptionMsg", getMessage("login.notlogon", locale));
//    	
//    	SiccMessageUtil.saveError(resvo, getMessage("login.notlogon", locale), MessageConstants.SHOW_TYPE_POPUP);
//    	resvo.setErrType("L");
//
//    	return resvo;
//    }
//
//    @RequestMapping("/access_deniedSVM")
//    @ResponseBody
//    public ResponseVO accessDenied(Locale locale, HttpSession session){
//    	logger.info("access_denied");
//    	ResponseVO resvo = new ResponseVO();
//    	//resvo.setSuccess(false);
//    	resvo.setErrType("L");
//    	SiccMessageUtil.saveError(resvo, getMessage("login.access.denied", locale), MessageConstants.SHOW_TYPE_POPUP);
//
//    	return resvo;
//    }

//    // kimjw sso
//    @RequestMapping("/saml/logoutSVM")
//    public String samlLogout(Locale locale, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//    	logger.info("saml/logout");
//
//    	SVMUserVO user = (SVMUserVO)session.getAttribute("SVMUserVO");
//    	siccUserService.logout(user);
//
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	if (auth != null){
//    		new SecurityContextLogoutHandler().logout(request, response, auth);
//    	}
//
//    	SSOProvider.deleteCookies(request, response);
//
//    	return "redirect:/saml/login";
//    }
//
//    // kimjw sso
    private String computeLogoutUrl(HttpServletRequest request) throws SamlException, IOException {
    	String logoutPage = "";
        if(SICC_SSO) {
	        String returnPage = SSOProvider.getSpDomainUrl(request) + properties.getProperty("sp.logoutUrl");
	        String idpUrl = properties.getProperty("ip.domain") + properties.getProperty("ip.idpLogoutUrl");
	        logoutPage = SSOProvider.computeLogoutURL(idpUrl, returnPage);
        } else {
	        logoutPage = "/logout";
        }
        return logoutPage;
    }

//    // kimjw sso
//    @RequestMapping("/saml/loginSVM")
//    public ModelAndView samlLogin(Locale locale, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//    	logger.info("/saml/login");
//
//    	String prevPage = (String)session.getAttribute("prevPage");
//    	logger.info("/saml/login :: prevPage : "+prevPage);
//
//		ModelAndView mav = new ModelAndView();
//
//    	String idpRedirectURL = null;
//    	try{
//        	if(request.getParameterMap().containsKey("error")) {
////            	return "login/loginErr";
//        	}
//        	if(request.getParameterMap().containsKey("relogin")) {
//            	logger.info("relogin");
//        	} else if(request.getParameterMap().containsKey("logout")) {
//            	logger.info("logout");
//
//            	SVMUserVO user = (SVMUserVO)session.getAttribute("SVMUserVO");
//            	siccUserService.logout(user);
//
//            	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            	if (auth != null){
//            		new SecurityContextLogoutHandler().logout(request, response, auth);
//            	}
//        	}
//
//        	String providerName = properties.getProperty("sp.providerName");
//    		String spDomainUrl = SSOProvider.getSpDomainUrl(request);
//    		logger.debug(spDomainUrl);
//    		String acsUrl = spDomainUrl + properties.getProperty("sp.acsUrl");
//    		String idpUrl = properties.getProperty("ip.domain") + properties.getProperty("ip.idpUrl");
//
////    		if("Y".equals(DRServlet.drStatusYn)){
////    			idpUrl = SiccPropertiesHolder.getProperty("ip.domain.DR") + SiccPropertiesHolder.getProperty("ip.idpUrl");
////    		}
//
//    		String returnPage = prevPage==null?"/":prevPage;
//
//    		String SAMLRequest = null;
//
//    		SAMLRequest = Util.createAuthnRequest(acsUrl, providerName);
//    		try {
//    			idpRedirectURL = SSOProvider.computeURL(idpUrl, SAMLRequest, returnPage);
//    		} catch (SamlException e) {
//    			logger.debug(e.getMessage());
//    		} catch (IOException e) {
//    			logger.debug(e.getMessage());
//    		}
//    		System.out.println("sso location-----"+idpRedirectURL);
//    		response.setStatus(302);
//    		response.setHeader("Location",idpRedirectURL);
//
//    		RedirectView redirectView = new RedirectView(); // redirect url 설정
//    		redirectView.setUrl(idpRedirectURL);
//    		redirectView.setExposeModelAttributes(false);
//
//    		mav.setView(redirectView);
//
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
//		return mav;
//    }

//    // kimjw sso
//    @RequestMapping("/saml/acsSVM")
//    public String acs(Locale locale, HttpServletRequest request, HttpServletResponse response) throws SiccException, ServletException {
//		logger.info("login -> acs");
//		String returnUrlStr = "";
//		String publicKeyFilePath = properties.getProperty("sp.publicKeyFilePath");
//
//		String SAMLResponse = request.getParameter("SAMLResponse")==null ? "":request.getParameter("SAMLResponse");
//		if(!SAMLResponse.equals("")){
//			try {
//				ByteArrayOutputStream baos = Util.decodeRequestXML(SAMLResponse);
//				logger.debug("acs::publicKeyFilePath:" + publicKeyFilePath);
//				RSAPublicKey publicKey = (RSAPublicKey) Util.getPublicKey(publicKeyFilePath, "RSA");
//
//				SAMLParser parser = new SAMLParser(new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()), "UTF-8"));
//
//				if (parser.isValid(publicKey)) {
//					String loginid = parser.getUserID();
//					String fullName = parser.getUserName();
//					String returnPage = request.getParameter("returnPage")==null?"/":(String)request.getParameter("returnPage");
//	    			logger.debug("returnPage : " + returnPage);
//
//					logger.debug("acs::id:" + loginid);
//
//					// security login
//					SVMUserVO user = new SVMUserVO();
//					user.setUsername(loginid);
//
//					Authentication authentication = null;
//					try {
//						// user 정보/권한 조회
//						authentication = siccUserService.authenticate_acs(user);
//					} catch(AuthenticationException e) {
//						// 에러 로그인 없이 포털로 이동?? -> 에러 페이지 필요
//					}
//					SecurityContext securityContext = SecurityContextHolder.getContext();
//					securityContext.setAuthentication(authentication);
//
//					HttpSession session = request.getSession();
//					if(session != null) {
//						session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//					}
//			        session.setAttribute("SVMUserVO", authentication.getDetails());
//			        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
//			        session.setAttribute("logoutUrl", this.computeLogoutUrl(request));
//			        session.setAttribute("userFullName", fullName);
//
//			        sessionAuthenticationStrategy.onAuthentication(authentication, request, response);
//
//			        user = (SVMUserVO)authentication.getDetails();
//
//			        if(user.getSso_msg().equals("login.user.notfound")) {
//				        returnUrlStr = "redirect:/login_success?first"; //계정이 존재하지 않을 경우
//			        } else if (user.getAuthorities().isEmpty()) {
//				        returnUrlStr = "redirect:/login_success?potal"; //권한이 없을 경우
//			        } else {
//				        returnUrlStr = "redirect:/login_success?returnPage="+returnPage;
//			        }
//
//			        // 쿠키 생성
//			        SSOProvider.createCookies(request, response);
//
//				} else {
//					returnUrlStr = "redirect:/login_fail";
//				}
//
//			} catch(SamlException se) {
//				logger.debug("SamlException", se);
//				throw new SiccException(se);
//			} catch(UnsupportedEncodingException se) {
//				logger.debug("UnsupportedEncodingException", se);
//				throw new SiccException(se);
//			} catch(ParserConfigurationException se) {
//				logger.debug("ParserConfigurationException", se);
//				throw new SiccException(se);
//			} catch(SAXException se) {
//				logger.debug("SAXException", se);
//				throw new SiccException(se);
//			} catch(IOException se) {
//				logger.debug("IOException", se);
//				throw new SiccException(se);
//			} catch (NoSuchProviderException e) {
//				logger.debug("NoSuchProviderException", e);
//				throw new SiccException(e);
//			} catch (MarshalException e) {
//				logger.debug("MarshalException", e);
//				throw new SiccException(e);
//			} catch (XMLSignatureException e) {
//				logger.debug("XMLSignatureException", e);
//				throw new SiccException(e);
//			}
//		}
//
//		response.setStatus(200);
//    	return returnUrlStr;
//    }
}
