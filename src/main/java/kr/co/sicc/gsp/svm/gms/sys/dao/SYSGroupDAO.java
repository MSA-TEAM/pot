package kr.co.sicc.gsp.svm.gms.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.sicc.gsp.svm.gms.sys.vo.SYSGroupVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

@Repository
public interface SYSGroupDAO {
	public List<Map<String, Object>> list(SYSGroupVO vo);
	
	public int total_cnt(SYSGroupVO vo);
	
	public int delete(String group_id);
	
	public int delete_granted_privilege(String major);
	
	public Map<String, Object> edit(SYSGroupVO vo);
	
	public int update(SYSGroupVO vo) throws SiccException;
	
	public void insert(SYSGroupVO vo) throws SiccException;
	
	public String check_duplication(String major);
	
	public int check_use_group(String major);
}
