package kr.co.sicc.gsp.svm.gms.common.tools;

import java.util.List;
import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

public interface WholeToolsDAO {
	public List<Map<String, Object>> tco(SiccToolsVO vo);
	
	public List<Map<String, Object>> atv(SiccToolsVO vo);
	
	public List<Map<String, Object>> cfs(SiccToolsVO vo);
}
