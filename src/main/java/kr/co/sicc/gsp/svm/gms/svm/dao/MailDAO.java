package kr.co.sicc.gsp.svm.gms.svm.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * <pre>	
 * com.gms.svm.dao
 * MailDAO.java
 * Description 	:
 * MAIL DAO
 * History     	:
 * </pre>
 *
 * @author	 	: gypark
 * @Date	 	: 2017.07.31
 * @Version 	: 1.0
 *
 */

@Repository
public interface MailDAO {

	/**
	 * 인증키 체크
	 *
	 * @Version : 1.0
	 * @Method authCheck
	 * @param String
	 * @return
	 */
	public String authCheck(String targetEmail);
	
	/**
	 * 인증키 체크
	 *
	 * @Version : 1.0
	 * @Method authSuccess
	 * @param String
	 * @return
	 */
	public int authSuccess(String targetEmail);

	/**
	 * 인증키 업데이트
	 * @param ip 
	 *
	 * @Version : 1.0
	 * @Method updateEmailDummy
	 * @param HashMap<String,String>
	 * @return
	 */
	public int updateEmailDummy(Map<String, String> param);

	
}
