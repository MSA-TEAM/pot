package kr.co.sicc.gsp.svm.gms.common.interceptor;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

/**
 * <pre>
 * com.gms.svm.dao
 * BasicInfoDAO.java
 * Description : Tenant정보 등 for basicinfo
 *
 * History     :
 * </pre>
 *
 * @author         : pmj
 * @Date         : 2018. 02. 02.
 * @Version : 1.0
 *
 */

@SuppressWarnings("serial")
public class BasicInfo extends SiccGenericVO {

	String tenant_id;
	String cp_cd;
	String service_cd;
	
	public String getTenantId() {
		return tenant_id;
	}
	public void setTenantId(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getCpCd() {
		return cp_cd;
	}
	public void setCpCd(String cp_cd) {
		this.cp_cd = cp_cd;
	}
	public String getService_cd() {
		return service_cd;
	}
	public void setService_cd(String service_cd) {
		this.service_cd = service_cd;
	}
    
}
