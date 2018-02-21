package kr.co.sicc.gsp.svm.gms.common.interceptor;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	/* tenant 정보 가져오기*/
	public BasicInfo TenantInfo(String service_url_addr) throws SiccException;	
	
	/* 사용 서비스 시스템 정보 가져오기 */
	public List<BasicInfo> ServiceInfo(@Param("tenant_id") String tenant_id, @Param("cp_cd") String cp_cd) throws SiccException;
	
}	