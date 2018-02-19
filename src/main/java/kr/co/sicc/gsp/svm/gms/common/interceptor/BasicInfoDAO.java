package kr.co.sicc.gsp.svm.gms.common.interceptor;

import java.util.List;

import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>
 * com.gms.svm.dao
 * BasicInfoDAO.java
 * Description : Tenant 관련 정보들 
 *
 * History     :
 * </pre>
 *
 * @author         : pmj
 * @Date         : 2018. 02. 02.
 * @Version : 1.0
 *
 */
public interface BasicInfoDAO {
	
	public List<BasicInfo> BasicInfo(String service_url_addr) throws SiccException;
		
}	