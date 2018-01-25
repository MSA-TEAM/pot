package kr.co.sicc.gsp.svm.gms.svm.service;

import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>
 * com.gms.svm.service
 * SendMailService.java
 * Description :
 * 	SendMailService Interface
 * History     :
 * </pre>
 *
 * @author	 : gypark
 * @Date	 : 2017. 8. 03.
 * @Version : 1.0
 *
 */
public interface SendMailService {
	
	/**
	 * 이메일 인증 메일 보내기 
	 *
	 * @Version : 1.0
	 * @Method sendAuthEmail
	 * @param toEmail
	 * @throws SiccException
	 */
	public void sendAuthEmail(String toEmail , String ip) throws SiccException;
	
	/**
	 * 이메일 인증값 비교 
	 *
	 * @Version : 1.0
	 * @Method authCheck
	 * @param String emailDummyKey, String userEmail
	 * @throws SiccException
	 */
	public Boolean authCheck(String emailDummyKey , String userEmail) throws SiccException;
	
	/**
	 * 임시 비밀번호 전송 
	 *
	 * @Version : 1.0
	 * @Method sendNewPw
	 * @param  String userEmail
	 * @throws SiccException
	 */
	public void sendNewPw(String targetEmail,String randomPw) throws SiccException;
}
