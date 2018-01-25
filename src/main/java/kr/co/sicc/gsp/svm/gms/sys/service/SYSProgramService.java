package kr.co.sicc.gsp.svm.gms.sys.service;

import kr.co.sicc.gsp.svm.gms.sys.vo.SYSProgramVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

public interface SYSProgramService{
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method list
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public SYSProgramVO list_view(SYSProgramVO vo) throws SiccException;
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method list
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public SYSProgramVO list(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param vo
	 * @throws SiccException
	 */
	public void delete(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method edit
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public SYSProgramVO edit(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method edit
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public SYSProgramVO input(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method update
	 * @param vo
	 * @throws SiccException
	 */
	public void update(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void insert(SYSProgramVO vo) throws SiccException;

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method check_duplication
	 * @param vo
	 * @throws SiccException
	 */
	public void check_duplication(SYSProgramVO vo) throws SiccException;
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method list
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public SYSProgramVO langlist(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method lang_insert
	 * @param vo
	 * @throws SiccException
	 */
	public void lang_insert(SYSProgramVO vo) throws SiccException;

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method lang_delete
	 * @param programVo
	 * @return
	 */
	public int lang_delete(SYSProgramVO programVo);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method lang_update
	 * @param programVo
	 */
	public void lang_update(SYSProgramVO programVo);
}
