package kr.co.sicc.gsp.svm.gms.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.sicc.gsp.svm.gms.sys.vo.SYSUserVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

@Repository
public interface SYSUserDAO {
	
	public List<Map<String, Object>> list(SYSUserVO vo);
	
	public int total_cnt(SYSUserVO vo);
	
	public Map<String, Object> edit(String user_id, String system_cd);
	
	public int update(SYSUserVO vo) throws SiccException;
	
	public void insert(SYSUserVO vo) throws SiccException;
	
	public int delete(String user_id, String system_cd);
	
	public void insert_group(SYSUserVO vo) throws SiccException;

	public int delete_group(String user_id, String system_cd);
	
	public List<Map<String, Object>> list_priv(SYSUserVO vo);
	
	public void insert_priv(SYSUserVO vo) throws SiccException;

	public void delete_priv(String user_id, String system_cd);
	
	public void insert_auth(SYSUserVO vo) throws SiccException;
	
	public List<Map<String, Object>> list_granted_priv(SYSUserVO vo);
	
	public void delete_group_priv(String user_id, String system_cd);
	
	public void insert_history(SYSUserVO vo) throws SiccException;
}
