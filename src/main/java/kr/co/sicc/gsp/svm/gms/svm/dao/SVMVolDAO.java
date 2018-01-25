package kr.co.sicc.gsp.svm.gms.svm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.sicc.gsp.svm.gms.svm.vo.SVMInfoVO;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMVolVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>	
 * com.gms.svm.dao
 * SVMVolDAO.java
 * Description 	:
 * 대회 자원봉사 지원서 관리 DAO
 * History     	:
 * </pre>
 *
 * @author	 	: gypark
 * @Date	 	: 2017.07.14
 * @Version 	: 1.0
 *
 */
@Repository
public interface SVMVolDAO {
	
	/**
	 * 대회 자원 봉사자 지원서 리스트
	 *
	 * @Version : 1.0
	 * @Method list
	 * @param vo
	 * @return
	 */
	public List<Map<String, Object>> list(SVMVolVO vo);
	
	/**
	 * 리스트 총 카운트를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method total_cnt
	 * @param vo
	 * @return
	 */
	public int total_cnt(SVMVolVO vo);
	
	/**
	 * 선택항목 삭제처리를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param major
	 * @param minor
	 * @return
	 */
	public int delete(String ad_no);
	
	/**
	 * 상세조회를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method edit
	 * @param major
	 * @param minor
	 * @return
	 */
	public Map<String, Object> edit(SVMVolVO vo);
	
	/**
	 * 업데이트 처리를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method update
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public void update(SVMVolVO vo) throws SiccException;
	
	/**
	 * 등록 처리를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void insert(SVMVolVO vo) throws SiccException;
	
	/**
	 * 등록 처리를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method makeNewADNo
	 * @param vo
	 * @throws SiccException
	 */
	public String makeNewADNo(SVMVolVO vo) throws SiccException;
	
	/**
	 * ACRCATEGORYM 업데이트 처리를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method update_category
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public int update_category(SVMVolVO vo) throws SiccException;
	
	/**
	 * 히스토리 등록 처리를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method insert_history
	 * @param vo
	 * @throws SiccException
	 */
	public void insert_history(SVMVolVO vo) throws SiccException;
	
	/**
	 * 참가자 사진 등록 메소드 - 공통으로 빼기
	 *
	 * @Version : 1.0
	 * @Method insertPhoto
	 * @param 
	 * @return
	 */
	public void insertPhoto(Map<String, Object> map);
	
	/**
	 * 참가자 여권 사본 등록 메소드 - 공통으로 빼기
	 *
	 * @Version : 1.0
	 * @Method insertPassport
	 * @param 
	 * @return
	 */
	public void insertPassport(Map<String, Object> map);

	/**
	 * 등록 처리를 위한 메소드
	 *
	 * @Version : 1.0
	 * @Method insertInfor
	 * @param vo
	 * @throws SiccException
	 */
	public void insertInfor(SVMVolVO vo);

	/**
	 * 신청서 정보
	 *
	 * @Version : 1.0
	 * @Method select
	 * @param vo
	 * @throws SiccException
	 */
	public SVMVolVO select(SVMVolVO vo);

	/**
	 * 신청서 상세 정보 리스트
	 *
	 * @Version : 1.0
	 * @Method selectInfo
	 * @param vo
	 * @throws SiccException
	 */
	public List<SVMInfoVO> selectInfo(String ad_no,String lang);
	
	/**
	 * 신청서 상세 정보 리스트 삭제
	 *
	 * @Version : 1.0
	 * @Method deleteInfor
	 * @param voParam
	 * @throws SiccException
	 */
	public void deleteInfor(SVMInfoVO voParam);
	
	/**
	 * 신청서 등록 번호 생성
	 *
	 * @Version : 1.0
	 * @Method selectRegiNo
	 * @param voParam
	 * @throws SiccException
	 */
	public String selectRegiNo(SVMVolVO vo);
	
}
