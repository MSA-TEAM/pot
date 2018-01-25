package kr.co.sicc.gsp.svm.gms.sys.service;

import kr.co.sicc.gsp.svm.gms.sys.vo.SYSGroupVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

public interface SYSGroupService{
	public SYSGroupVO list_view(SYSGroupVO vo) throws SiccException;
	
	public SYSGroupVO list(SYSGroupVO vo) throws SiccException;
	
	public SYSGroupVO input(SYSGroupVO vo) throws SiccException;
	
	public int delete(SYSGroupVO vo) throws SiccException;
	
	public SYSGroupVO edit(SYSGroupVO vo) throws SiccException; 
	
	public void update(SYSGroupVO vo) throws SiccException;
	
	public void insert(SYSGroupVO vo) throws SiccException;
}
