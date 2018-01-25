package kr.co.sicc.gsp.svm.sicc.tools;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface SiccToolsService{
	public List<Map<String, Object>> select(SiccToolsVO vo, SqlSession session);
}
