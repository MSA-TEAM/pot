package kr.co.sicc.gsp.svm.gms.svm.photo;

import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

@Repository
public interface SVMPhotoDAO {
	/**
	 * 삽입 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void insert(SVMPhotoVO vo) throws SiccException;
	
	/**
	 * 파일 하나의 정보 조회  
	 *
	 * @Version : 1.0
	 * @Method read
	 * @param file_no
	 * @return
	 * @throws SiccException
	 */
	public Map<String, Object> read(String ad_no  , String photo_fg) throws SiccException;
	
	/**
	 * 파일 하나 삭제  
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param file_no
	 * @throws SiccException
	 */
	public void delete(String ad_no  , String photo_fg) throws SiccException;
	
	/**
	 * SVMPHOTOM - 여권 사본 등록 
	 *
	 * @Version : 1.0
	 * @Method insertPassport
	 * @param vo
	 * @throws SiccException
	 */
	public void insertPassport(SVMPhotoVO vo) throws SiccException;
	
	/**
	 * 한 개의 여권 사본 정보 조회  
	 *
	 * @Version : 1.0
	 * @Method readPassport
	 * @param file_no
	 * @return
	 * @throws SiccException
	 */
	public Map<String, Object> readPassport(String ad_no , String photo_fg) throws SiccException;
	
	/**
	 * SVMPHOTOM - 한 개의 여권 사본 삭제 
	 *
	 * @Version : 1.0
	 * @Method deletePassport
	 * @param file_no
	 * @throws SiccException
	 */
	public void deletePassport(String ad_no , String photo_fg) throws SiccException;

}
