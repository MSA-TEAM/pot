package kr.co.sicc.gsp.svm.gms.common.login;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoginDAO {
	public List<? extends Role> authList(@Param("user_id") String user_id, @Param("system_cd") String system_cd);
	
	public UserInfo auth(@Param("user_id") String user_id, @Param("system_cd") String system_cd);
	
	public UserInfo userInfo(@Param("user_id") String user_id, @Param("system_cd") String system_cd);
	
	public int loginSuccess(UserInfo userinfo);
	public int loginFail(UserInfo userinfo);
	public int logout(UserInfo userinfo);

	public int loginFailCount(UserInfo userinfo);
	public int loginFailCountReset(UserInfo userinfo);
	public String calculateLoginFailResetCriterion(@Param("user_id") String user_id, @Param("system_cd") String system_cd);
	
}
