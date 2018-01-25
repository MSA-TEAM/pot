package kr.co.sicc.gsp.svm.gms.svm.dao;

import java.util.List;
import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;
/**
 * <pre>
 * com.gms.svm.dao
 * SVMToolsDAO.java
 * Description :
 *
 * History     :
 * </pre>
 *
 * @author         : 박근영
 * @Date         : 2017. 07. 14.
 * @Version : 1.0
 *
 */
public interface SVMToolsDAO {
	
	public List<Map<String, Object>> tco(SiccToolsVO vo);
	
	public List<Map<String, Object>> categoryList(SiccToolsVO vo);
	
	public List<Map<String, Object>> functionList(SiccToolsVO vo);
	
	public List<Map<String, Object>> orgList(SiccToolsVO vo);
	
	public List<Map<String, Object>> svmCodeList(SiccToolsVO vo);

	public List<Map<String, Object>> svmDivCodeList(SiccToolsVO vo);

	public List<Map<String, Object>> changeExperience(SiccToolsVO vo);
	
}
