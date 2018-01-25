package kr.co.sicc.gsp.svm.gms.sys.service;

import kr.co.sicc.gsp.svm.gms.sys.vo.SYSUserVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

public interface SYSUserService {
	
	public SYSUserVO list_view(SYSUserVO vo) throws SiccException;
	
	public SYSUserVO list(SYSUserVO vo) throws SiccException;
	
	public int delete(SYSUserVO vo) throws SiccException;
	
	public SYSUserVO edit(SYSUserVO vo) throws SiccException;
	
	public void update(SYSUserVO vo) throws SiccException;
	
	public void update_priv(SYSUserVO vo) throws SiccException;
	
	public void insert(SYSUserVO vo) throws SiccException;
	
	public void insert_priv(SYSUserVO vo) throws SiccException;
	
	public SYSUserVO list_priv(SYSUserVO vo) throws SiccException;
	
	public SYSUserVO input(SYSUserVO vo) throws SiccException;

}
