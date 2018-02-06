package kr.co.sicc.gsp.svm.gms.svm.controller;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sicc.gsp.svm.gms.common.login.SiccUserService;
import kr.co.sicc.gsp.svm.gms.svm.service.SVMUserService;
import kr.co.sicc.gsp.svm.gms.svm.service.SendMailService;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMVolVO;
import kr.co.sicc.gsp.svm.sicc.common.SiccController;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.constants.MessageConstants;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>	
 * com.gms.svm.controller
 * SVMEmailController.java
 * Description 	:
 * 이메일 SMTP Controller
 * History     	:
 * </pre>
 *
 * @author	 	: gypark
 * @Date	 	: 2017.07.31
 * @Version 	: 1.0
 *
 */

@Controller
public class SVMEmailController extends SiccController {

	@Autowired
	SendMailService sendMailService;
	
	@Autowired
	SVMUserService userService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	@Resource(name="siccUserService")
	private SiccUserService siccUserService;
	
//	@RequestMapping(value="/mail/emailAuth")
//	public String emailAuth(Locale locale, 
//			Model model, 
//			@PathVariable String lang, 
//			@PathVariable String cmd, 
//			HttpSession session,
//			@ModelAttribute("svmVolVo") SVMVolVO vo,
//			RedirectAttributes redirectAttr)
//			throws SiccException{
//			
//		String email = vo.getE_mail();
//		String email = vo.getE_mail();
//
//		//보낼 사용자의 이메일 주소 셋팅
//		//보내는 이
//		//CONTENTS
//		SVMVolVO vo = new SVMVolVO();
//		vo.setEmail("qkrjg0909@gmail.com");
//		sendMailService.sendAuthEmail(vo.getEmail());
//		
//		vo.setForwardUrl("/mail/recieveEmail");
//		return vo.getUrl();
//	}
	
	
	@RequestMapping(value="/mail/recieveEmail")
	public String receiveEmail(
			Locale locale, 
			Model model, 
//			@PathVariable String lang, 
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("svmVolVo") SVMVolVO vo,
			RedirectAttributes redirectAttr)
			throws SiccException{
		
	    //UserInfo user = (UserInfo)session.getAttribute("userInfo");  
	
		String authYn = "N";
		String dummy = request.getParameter("dummy");
		String targetEmail = request.getParameter("targetEmail");
		//String targetEmail = session 에서 이메일 값 가져오는 방법;
		
		try{
			if(!"".equals(dummy) && null != dummy){
				//인증값 비교
				if(sendMailService.authCheck(dummy,targetEmail)){
					authYn = "Y";
				}else{
					authYn = "N";
				}
			}

			vo.setForwardUrl("/common/mail/recieveEmail");
		
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(vo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return vo.getError_url();
		}catch(Exception e){
			logger.debug("Exception", e);
			SiccMessageUtil.saveError(vo, "Exception" , MessageConstants.SHOW_TYPE_POPUP);
			return vo.getError_url();
		}
		model.addAttribute("authYn",authYn);
		model.addAttribute("email",targetEmail);
		return vo.getUrl();
	}
	
	@RequestMapping(value="/mail/handlerEmail")
	public String handlerEmail(
			Locale locale, 
			Model model, 
//			@PathVariable String lang, 
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("svmUserVo") SVMUserVO svmUserVo,
			@RequestParam(value = "isRegistered", required = false) String isRegistered,
			RedirectAttributes redirectAttr)
					throws SiccException{
		SVMUserVO userVo= (SVMUserVO) session.getAttribute("userInfo");
		String user_ip = "";
		//String targetEmail = session 에서 이메일 값 가져오는 방법;
		try{
			if(request != null)	user_ip = siccUserService.getClientIp(request);
			if(userVo != null){
				//인증값 비교
				
				if("Y".equals(userVo.getEmail_id_auth_yn())){
					// 이미 인증한 사람 URL로 접속
					return "redirect:/";
				}else{
					//미 인증
					if("true".equals(isRegistered)){
						//회원가입
						sendMailService.sendAuthEmail(svmUserVo.getEmail(),user_ip);
						redirectAttr.addAttribute("isRegistered", true);
						redirectAttr.addAttribute("resend",false);
					}else{
						//로그인 후 RESEND
						if("false".equals(isRegistered)){
							sendMailService.sendAuthEmail(svmUserVo.getEmail(),user_ip);
							redirectAttr.addAttribute("isLogin", false);
						}else{
							redirectAttr.addAttribute("isLogin", true);
						}
						redirectAttr.addAttribute("isRegistered", false);
						redirectAttr.addAttribute("resend",false);
					}
					svmUserVo.setRedirectUrl("mail/resendEmail","");
				}
			} else if(!"".equals(svmUserVo.getEmail())){
				//회원가입후 RESEND 버튼 예외 
				sendMailService.sendAuthEmail(svmUserVo.getEmail(),user_ip);
				//SiccMessageUtil.saveSuccess(redirectAttr, messageSource.getMessage("svm.info.msg.send_auth_mail",null, locale), MessageConstants.SHOW_TYPE_POPUP);
				redirectAttr.addFlashAttribute("resend",true);
				redirectAttr.addAttribute("email", svmUserVo.getEmail());
				redirectAttr.addAttribute("isRegistered", true);
				svmUserVo.setRedirectUrl("mail/resendEmail","");
			}
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveSuccess(svmUserVo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return svmUserVo.getError_url();
		}catch(Exception e){
			logger.debug("Exception", e);
			SiccMessageUtil.saveError(svmUserVo, "Exception" , MessageConstants.SHOW_TYPE_POPUP);
			return svmUserVo.getError_url();
		}
		return svmUserVo.getUrl();
	}

	@RequestMapping(value="/mail/resendEmail")
	public String resendEmail(
			Locale locale, 
			Model model, 
//			@PathVariable String lang, 
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("svmUserVo") SVMUserVO svmUserVo,
			@ModelAttribute("msg") String msg,
			@ModelAttribute("resend") String resend,
			@ModelAttribute("isRegistered") String isRegistered,
			@RequestParam(value = "isLogin" , required = false) String isLogin,
			RedirectAttributes redirectAttr)
					throws SiccException{
		SVMUserVO userVo= (SVMUserVO) session.getAttribute("userInfo");
		String authYn = "N";
		try{
			if(userVo != null){
				if("Y".equals(userVo.getEmail_id_auth_yn())) {
					svmUserVo.setUrl("/404");
				}else{ 
					//인증 하지않은 상태에서 RESEND 
					if("false".equals(isRegistered)){
						//msg = getMessage("svm.info.msg.send_auth_mail",null, locale);
						if("true".equals(isLogin)) {
							model.addAttribute("resend", false);
						}else {
							model.addAttribute("resend", true);
						}
					}else {
						msg = getMessage("svm.message.info_resend_email",null, locale);
					}
					model.addAttribute("userVo", userVo);
					svmUserVo.setForwardUrl("/common/mail/resendEmail");
				}
			} else if("false".equals(isRegistered)){
				model.addAttribute("userVo", svmUserVo);
				svmUserVo.setForwardUrl("/common/mail/resendEmail");
			} else if("true".equals(isRegistered)){
				model.addAttribute("userVo", svmUserVo);
				model.addAttribute("resend", resend);
				model.addAttribute("isRegistered", isRegistered);
				svmUserVo.setForwardUrl("/common/mail/resendEmail");
			}else {
				authYn = "NS";
				model.addAttribute("authYn", authYn);
			}
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(svmUserVo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return svmUserVo.getError_url();
		}catch(Exception e){
			logger.debug("Exception", e);
			SiccMessageUtil.saveError(svmUserVo, "Exception" , MessageConstants.SHOW_TYPE_POPUP);
			return svmUserVo.getError_url();
		}
		model.addAttribute("msg",msg);
		model.addAttribute("authYn",authYn);
		return svmUserVo.getUrl();
	}
	
	@RequestMapping(value="/mail/forgotPw")
	@ResponseBody
	public SVMUserVO forgotPw(
			Locale locale, 
			Model model, 
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "email", required = true) String email
			) throws SiccException{
		
		SVMUserVO vo = new SVMUserVO();
		String targetEmail = email;
		
		try{
			// 가입된 이메일인지 검증
			if(userService.chk_email(vo) > 0){
				if("N".equals(userService.chk_email_auth(targetEmail))){
					// email 인증 확인
					vo.setSuccess(false);
					vo.setMsg("EA");
					return vo;
				}
				// 패스워드 변경 유무 ,임시패스워드로 변경
				StringBuffer buffer = new StringBuffer();
				Random random = new Random();
				int randomInt = 0;
				String chars[] = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
				for (int i = 0; i < 5; i++) {
					if(chars.length < 53 ){
						randomInt = random.nextInt(chars.length);
						if(randomInt < 53) buffer.append(chars[randomInt]);
					}
				}

				vo.setPassword(buffer.append(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5)).toString());
				vo.setChange_pwd_yn("Y");
				vo.setEmail(targetEmail);
				userService.update_passwd(vo);
				
				// 이메일 발송
				vo.setEmail(targetEmail);
				sendMailService.sendNewPw(vo.getEmail(),vo.getPassword());
				return vo;
			}else {
				vo.setMsg("NFM");
				vo.setSuccess(false);
				return vo;
			}
		}catch(SiccException e){
			logger.debug("SiccException", e);
			SiccMessageUtil.saveError(vo, getMessage(e.getCode(), locale), MessageConstants.SHOW_TYPE_POPUP);
			return vo;
		}catch(Exception e){
			logger.debug("Exception", e);
			SiccMessageUtil.saveError(vo, "Exception" , MessageConstants.SHOW_TYPE_POPUP);
			return vo;
		}
	}
	
}
