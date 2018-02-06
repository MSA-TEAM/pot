package kr.co.sicc.gsp.svm.gms.svm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.sicc.gsp.svm.gms.common.login.Role;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;

public interface SVMLoginDAO {
	public List<? extends Role> authList(@Param("tenantId") String tenant_id, @Param("cpCd") String cp_cd, @Param("emailId") String email_id); //email 제외한 항목 추가
	
	public SVMUserVO auth(@Param("email") String email);
	
	public SVMUserVO userInfo(@Param("tenantId") String tenant_id, @Param("cpCd") String cp_cd, @Param("emailId") String email_id); //email 제외한 항목 추가
	
//	public int loginSuccess(SVMUserVO SVMUserVO);
//	public int loginFail(SVMUserVO SVMUserVO);
	public int logout(SVMUserVO SVMUserVO);

//	public int loginFailCount(SVMUserVO SVMUserVO);
//	public int loginFailCountReset(SVMUserVO SVMUserVO);
//	public String calculateLoginFailResetCriterion(@Param("user_id") String user_id);
	
}
