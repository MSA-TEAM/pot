package kr.co.sicc.gsp.svm.gms.common.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface SiccSessionService {
	public Map<String, Object> addUserSession(UserInfo vo);
}


