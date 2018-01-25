package kr.co.sicc.gsp.svm.gms.sys.dao;

import java.util.List;
import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

public interface SYSToolsDAO {
	public List<Map<String, Object>> tco(SiccToolsVO vo);
	
	public List<Map<String, Object>> web_group(SiccToolsVO vo);
	
	public List<Map<String, Object>> group_list(SiccToolsVO vo);
	
	public List<Map<String, Object>> granted_group_list(SiccToolsVO vo);
	
	public List<Map<String, Object>> program_group_list(SiccToolsVO vo);
	
	public List<Map<String, Object>> granted_program_group_list(SiccToolsVO vo);

	public List<Map<String, Object>> order_list(SiccToolsVO vo);

	public List<Map<String, Object>> accesspriv_list(SiccToolsVO vo);

	public List<Map<String, Object>> order_list_insert(SiccToolsVO vo);
	
	public List<Map<String, Object>> chk_user_id(SiccToolsVO vo);
	
	public List<Map<String, Object>> menu_list(SiccToolsVO vo);
}
