package kr.co.sicc.gsp.svm.gms.svm.service;

import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

public interface SVMUserService {

//	public SVMUserVO list_view(SVMUserVO vo) throws SiccException;
//	public SVMUserVO list(SVMUserVO vo) throws SiccException;
//	public int delete(SVMUserVO vo) throws SiccException;
//	public SVMUserVO edit(SVMUserVO vo) throws SiccException;
//	public SVMUserVO list_priv(SVMUserVO vo) throws SiccException;
//	public SVMUserVO input(SVMUserVO vo) throws SiccException;
	
	public void insert(SVMUserVO vo) throws SiccException;
	public void insert_priv(SVMUserVO vo) throws SiccException;
	
	public void update(SVMUserVO vo) throws SiccException;
	public void update_priv(SVMUserVO vo) throws SiccException;
	
	public void update_passwd(SVMUserVO vo) throws SiccException;
	public int chk_email(SVMUserVO vo) throws SiccException;
	
	public boolean chk_passwd(SVMUserVO vo) throws SiccException;
	public String chk_email_auth(String email) throws SiccException;

}
