package kr.co.sicc.gsp.svm.gms.svm.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.co.sicc.gsp.svm.gms.svm.dao.MailDAO;
import kr.co.sicc.gsp.svm.gms.svm.service.SendMailService;
import com.gmsutil.dispatch.DispatchVO;
import com.gmsutil.dispatch.MailDispatcher;
import com.gmsutil.dispatch.SiccCmdDispatcher;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>	
 * com.gms.svm.service.impl
 * SendMailServiceImpl.java
 * Description 	:
 * EMAIL Service Impl
 * History     	:
 * </pre>
 *
 * @author	 	: gypark
 * @Date	 	: 2017.07.31
 * @Version 	: 1.0
 *
 */

@Component
@Service
public class SendMailServiceImpl implements SendMailService{
	
	@Autowired
	JavaMailSender mailSender;
	
	@Value("${mail.smtp.ip}")
	String mail_ip;

	@Value("${mail.smtp.fromEmail}")
	String fromEmail;

	@Value("${mail.smtp.sender.name}")
	String senderNm;
	
	@Autowired
	@Resource(name="sqlSession")
	SqlSession sqlSession;
	
	@Override
	public void sendAuthEmail(String to, String ip) {
		MailDAO mapper = sqlSession.getMapper(MailDAO.class);
		
		String targetEmail = "";
		String dummyKey ="";
		int success = -1;
		targetEmail = to;
		Map<String,String> param = new HashMap<String, String>();
		try {
			dummyKey = (UUID.randomUUID().toString().replaceAll("-", "")+targetEmail).substring(0,30); //vo.getE_mail();
			param.put("dummyKey", dummyKey);
			param.put("targetEmail", targetEmail);
			param.put("ip", ip);
			
			success = mapper.updateEmailDummy(param);
			if(success == 1){
				
				// 전송 정보
				DispatchVO sender_info = new DispatchVO();
				SiccCmdDispatcher dispatcher = new SiccCmdDispatcher();
				
				// 발신 대상자 정보는 DispatchVO의 List로 생성
				List<DispatchVO> contactList = new ArrayList<>();
				DispatchVO contactVo = null;
				contactVo = new DispatchVO();
				contactVo.setReceiver_email(to);	// 벤더의 이메일 정보로 보내기
				contactList.add(contactVo);
				
				// 발신 대상자 목록
				sender_info.setTitle("[JAKARTA PALEMBANG 2018 Volunteer] Account Activation");
				sender_info.setReceiver_list(contactList);
				
				sender_info.setSender(mailSender);
				sender_info.setHtml(true);
				String msg = "";
				
				msg += "<table width='700' border='0' cellspacing='0' cellpadding='0' align='center' style='background:#d52c40;'>";
				msg += "	<tr>";
				msg += "		<td>";
				msg += "			<div style='padding:16px 50px 5px 50px; width:600px; height:45px; color:#ffffff; font-size:24px; line-height:28px; vertical-align:middle;  font-family:Arial Bold, sans-serif;'>";
				msg += "				Account Activation";
				msg += "			</div>";	
				msg += "		</td>";	
				msg += "	</tr>";	
				msg += "</table>";
				msg += "<table width='700' border='0' cellspacing='0' cellpadding='0' align='center' style='background:#ffffff; border:5px solid #e6e6e6; border-top:none;'>";
				msg += "	<tr>";
				msg += "		<td>";
				msg += "			<div style='padding:40px 45px 40px 45px; width:600px; color:#333333; font-size:16px; line-height:20px; vertical-align:top; font-family:Arial, sans-serif;'>";
				msg += "				<div style='padding-bottom:20px;'>Welcome to the website of the JAKARTA PALEMBANG 2018 Volunteer. <br/> To activate your account, click the below button.</div>";
				msg += "				<div style=' text-align:center; margin:20px 0;'>";
//				msg += "					<a href='#' target='_blank' style='color:#0078ff;min-width:130px; height:28px; padding-top:9px; display:inline-block; color:#ffffff; font-size:16px; text-decoration:none;border: 1px solid #d52c40; background: #d52c40; -webkit-border-radius:4px; -moz-border-radius:4px; border-radius:4px;'>";
//				msg += "						Certify";
//				msg += "					</a>";
				msg += "					<a href='http://" + mail_ip + "/mail/recieveEmail?dummy=" + dummyKey + "&targetEmail=" + targetEmail + "' target='_blank' style='color:#0078ff; padding:9px 40px 9px 40px; display:inline-block; color:#ffffff; font-size:16px; text-decoration:none;border: 1px solid #d52c40; background: #d52c40; -webkit-border-radius:4px; -moz-border-radius:4px; border-radius:4px;'>";
				msg += "						Verification via email";
				msg += "					</a>";
				msg += "				</div>";
				msg += "				<div style='padding:0 0 20px 0; border-bottom:1px solid #d6d6d6;'>";
				//msg += "					Please activate your account within 48 hours, otherwise your registration will become invalid and you will have to register again.";
				msg += "				</div>";
				msg += "				<div style='padding:20px 0 0px 0;'>";
				msg += "					This is an automatic email. Don't reply to this email.";
				msg += "				</div>";
				msg += "			</div>";
				msg += "		</td>";
				msg += "	</tr>";
				msg += "</table>";
				msg += "<table width='700' border='0' cellspacing='0' cellpadding='0' align='center' style='background:#ffffff; '>";
				msg += "	<tr>";
				msg += "		<td>";
				msg += "			<div style='padding:10px 0px 0px 0px; width:700px; height:34px; color:#333333; font-size:12px; line-height:14px; vertical-align:middle; text-align:center; font-family:Arial, sans-serif;'>";
				msg += "				© The Indonesia Asian Games Organizing Committee. All rights reserved.";
				msg += "			</div>";
				msg += "		</td>";
				msg += "	</tr>";
				msg += "</table>";
				
				
				sender_info.setMsg(msg);
				sender_info.setSender_email(fromEmail);
				sender_info.setSender_nm(senderNm);

				dispatcher.dispatch(new MailDispatcher(), sender_info);
				
				
				
//				message.setSubject("[VOLUNTEER APPLICATION 가입 인증 ] 안내 ","UTF-8");
//				htmlContent += "<Strong>아래 인증하기 버튼을 눌러주세요.</Strong></br>";
//				htmlContent += "<a href='http://localhost:8080/mail/recieveEmail?dummy=" + dummyKey + "&targetEmail=" + targetEmail + "' target='_blank'>인증하기</a>";
//				message.setText(htmlContent, "utf-8", "html");
//				message.setFrom(new InternetAddress(fromEmail));
//				message.addRecipient(RecipientType.TO, new InternetAddress(targetEmail));
//				mailSender.send(message);
			}
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}catch (UnsupportedEncodingException | MessagingException e) {
			throw SiccMessageUtil.getError(e);
		}catch (MailSendException e) {
			throw SiccMessageUtil.getError(e);
		}catch (SiccException e){
			throw SiccMessageUtil.getError(e);
		} catch (Exception e){
			throw SiccMessageUtil.getError(e);
		} 
	}

	@Override
	public Boolean authCheck(String emailDummyKey, String chkTargetEmail) {
		Boolean isAuth = false;
		MailDAO mapper = sqlSession.getMapper(MailDAO.class);
		String originDummyKey = mapper.authCheck(chkTargetEmail);
		if(originDummyKey != null){
			if(originDummyKey.trim().equals(emailDummyKey.trim())){
				if(1 == mapper.authSuccess(chkTargetEmail)) isAuth = true;
				return isAuth;
			}
		}else{
			isAuth = false;
		}
		return isAuth;
	}
	
	@Override
	public void sendNewPw(String targetEmail,String randomPw) {
		 
			Map<String,String> param = new HashMap<String, String>();
			try {
				
				param.put("targetEmail", targetEmail);
					
				// 전송 정보
				DispatchVO sender_info = new DispatchVO();
				SiccCmdDispatcher dispatcher = new SiccCmdDispatcher();
				
				// 발신 대상자 정보는 DispatchVO의 List로 생성
				List<DispatchVO> contactList = new ArrayList<>();
				DispatchVO contactVo = null;
				contactVo = new DispatchVO();
				contactVo.setReceiver_email(targetEmail);	// 벤더의 이메일 정보로 보내기
				contactList.add(contactVo);
				
				// 발신 대상자 목록
				sender_info.setReceiver_list(contactList);
				sender_info.setTitle("[JAKARTA PALEMBANG 2018 Volunteer] Change Password");
				
				sender_info.setSender(mailSender);
				sender_info.setHtml(true);
				
				String msg = "";
				
				msg += " <table width='700' border='0' cellspacing='0' cellpadding='0' align='center' style='background:#d52c40; '>";
				msg += " 	<tr>";
				msg += " 		<td>";
				msg += " 			<div style='padding:16px 50px 5px 50px; width:600px; height:45px; color:#ffffff; font-size:24px; line-height:28px; vertical-align:middle;  font-family:Arial Bold, sans-serif;'>";
				msg += "		Change Password";
				msg += " 			</div>";
				msg += " 		</td>";
				msg += " 	</tr>";
				msg += " </table>";
				msg += " <table width='700' border='0' cellspacing='0' cellpadding='0' align='center' style='background:#ffffff; border:5px solid #e6e6e6; border-top:none; '>";
				msg += " 	<tr>";
				msg += " 		<td>";
				msg += " 			<div style='padding:40px 45px 40px 45px; width:600px; color:#333333; font-size:16px; line-height:20px; vertical-align:top; font-family:Arial, sans-serif;'>";
				msg += " 				<div style='padding-bottom:20px;border-bottom:1px solid #d6d6d6;'>";
				msg += "  				This email is a guide for changing your password.<br/>Below is a temporary password to access your account.<br/>";
				msg += " 					<span style='color:#0078ff;'>";
				msg += "  						[ " + randomPw +" ]<br/>";
				msg += " 					</span>";
				msg += "  						<br/>Please set your new password through the issued temporary password.";
				msg += "  				</div>";
				msg += "  				<div style='padding:20px 0 0px 0;'>";
				msg += "  					This is an automatic email. Don't reply to this email.";
				msg += "  				</div>";
				msg += "  			</div>";
				msg += "  		</td>";
				msg += "  	</tr>";
				msg += "  </table>";
				msg += "  <table width='700' border='0' cellspacing='0' cellpadding='0' align='center' style='background:#ffffff; '>";
				msg += "  	<tr>";
				msg += "  		<td>";
				msg += "  			<div style='padding:10px 0px 0px 0px; width:700px; height:34px; color:#333333; font-size:12px; line-height:14px; vertical-align:middle; text-align:center; font-family:Arial, sans-serif;'>";
				msg += "  				© The Indonesia Asian Games Organizing Committee. All rights reserved.";
				msg += "  			</div>";
				msg += "  		</td>";
				msg += "  	</tr>";
				msg += "  </table>";
				
				sender_info.setMsg(msg);
				sender_info.setSender_email(fromEmail);
				sender_info.setSender_nm(senderNm);

				dispatcher.dispatch(new MailDispatcher(), sender_info);
			}catch(DataAccessException e){
				throw SiccMessageUtil.getError(e);
			}catch(ClassCastException e){
				throw SiccMessageUtil.getError(e);
			}catch (UnsupportedEncodingException | MessagingException e) {
				throw SiccMessageUtil.getError(e);
			}catch (MailSendException e) {
				throw SiccMessageUtil.getError(e);
			}catch (SiccException e){
				throw SiccMessageUtil.getError(e);
			} catch (Exception e){
				throw SiccMessageUtil.getError(e);
			}
	}

}
