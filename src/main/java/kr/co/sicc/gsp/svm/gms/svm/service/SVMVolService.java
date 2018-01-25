package kr.co.sicc.gsp.svm.gms.svm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import kr.co.sicc.gsp.svm.gms.svm.vo.SVMVolVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>	
 * com.gms.svm.service
 * SVMVolService.java
 * Description 	:
 * 대회 참가자 관리 Service
 * History     	:
 * </pre>
 *
 * @author	 	: 
 * @Date	 	: 2017.07.14
 * @Version 	: 1.0
 *
 */
public interface SVMVolService {
	
	/**
	 * 대회 자원봉사 지원서 , 수정 화면 
	 *
	 * @Version : 1.0
	 * @Method application
	 * @param vo
	 * @throws SiccException
	 */
	public SVMVolVO application(SVMVolVO vo) throws SiccException;
	
	/**
	 * 대회 자원봉사 지원서 등록 input 화면
	 *
	 * @Version : 1.0
	 * @Method input
	 * @param vo
	 * @param viewTab 
	 * @throws SiccException
	 */
	public SVMVolVO input(SVMVolVO vo, String viewTab) throws SiccException;
	
	/**
	 * 대회 자원봉사 지원서 등록 insert 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @param filePassport 
	 * @param filePhoto 
	 * @param bodyPhoto 
	 * @param facePhoto 
	 * @param skillPhoto 
	 * @param req 
	 * @return
	 * @throws SiccException
	 */
	public SVMVolVO insert(SVMVolVO vo, MultipartFile filePhoto, MultipartFile filePassport, MultipartFile facePhoto, MultipartFile bodyPhoto, List<MultipartFile> skillPhoto, HttpServletRequest req) throws SiccException;
	/**
	 * 대회 자원봉사 지원서 등록 전 중복체크
	 *
	 * @Version : 1.0
	 * @Method validation
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public SVMVolVO validation(SVMVolVO vo) throws SiccException;
	
	/**
	 * 대회 자원봉사 지원서 수정
	 *
	 * @Version : 1.0
	 * @Method edit
	 * @param vo
	 * @return
	 */
	public SVMVolVO edit(SVMVolVO vo) throws SiccException;
	
	/**
	 * 대회 자원봉사 지원서 수정
	 *
	 * @Version : 1.0
	 * @Method update
	 * @param vo
	 * @param bodyPhoto 
	 * @param facePhoto 
	 * @param req 
	 * @throws SiccException
	 */
	public SVMVolVO update(SVMVolVO vo, MultipartFile filePhoto, MultipartFile filePassport, MultipartFile facePhoto, MultipartFile bodyPhoto,List<MultipartFile> skillPhoto, HttpServletRequest req) throws SiccException;
	
	/**
	 * 대회 자원봉사 지원서 삭제
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param vo
	 * @throws SiccException
	 */
	public int delete(SVMVolVO vo) throws SiccException;

	/**
	 * 사진, 여권사본 이미지 읽기
	 *
	 * @Version : 1.0
	 * @Method readImage
	 * @param vo
	 * @throws SiccException
	 */
	public Map<String, Object> readImage(String ad_no, String phto_fg, String File_nm ) throws SiccException;
	
	/**
	 * 사진, 여권사본 이미지 읽기
	 *
	 * @Version : 1.0
	 * @Method deleteImage
	 * @param vo
	 * @throws SiccException
	 */
	public void deleteImage(SVMVolVO vo) throws SiccException;

	/**
	 * 주소 콤보박스
	 *
	 * @Version : 1.0
	 * @Method changeAddr
	 * @param SVMVolVO
	 * @param string
	 * @throws SiccException
	 */
	public SVMVolVO changeAddr(String code_value, String flag) throws SiccException;
	
	/**
	 * GameInfo Experience 콤보박스
	 * @param nextTargetId 
	 *
	 * @Version : 1.0
	 * @Method changeExperience
	 * @param SVMVolVO
	 * @param string
	 * @throws SiccException
	 */
	public SVMVolVO changeExperience(String code_value, String flag, String nextTargetId) throws SiccException;
}
