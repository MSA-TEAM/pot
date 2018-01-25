package kr.co.sicc.gsp.svm.gms.common.photo;

import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

public interface PhotoService{
	/**
	 * 삽입 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void insert(PhotoVO vo) throws SiccException;
	
	/**
	 * 파일 하나의 정보 조회  
	 *
	 * @Version : 1.0
	 * @Method read
	 * @param file_no
	 * @return
	 * @throws SiccException
	 */
	public PhotoVO read(String ad_no) throws SiccException;

	/**
	 * 파일 하나 삭제  
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param file_no
	 * @throws SiccException
	 */
	public void delete(String ad_no) throws SiccException;
	
}
