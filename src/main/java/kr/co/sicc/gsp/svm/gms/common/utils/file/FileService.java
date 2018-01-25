package kr.co.sicc.gsp.svm.gms.common.utils.file;

import java.util.List;
import java.util.Map;

import com.gmsutil.file.FileVO;

import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>
 * com.gms.sys.service
 * SYSNoticeFileService.java
 * Description : 
 *		공지사항 첨부파일 서비스
 * History     :
 * </pre>
 *
 * @author	 : randy80
 * @Date	 : 2016. 1. 29.
 * @Version : 1.0
 *
 */
public interface FileService{
	
	/**
	 * 게시글의 첨부파일 목록 조회  
	 *
	 * @Version : 1.0
	 * @Method list
	 * @param group_no
	 * @return
	 * @throws SiccException
	 */
	public List<Map<String, Object>> list(String group_no) throws SiccException;
	
	/**
	 * 다운로드 건수 증가 
	 *
	 * @Version : 1.0
	 * @Method count_up
	 * @param file_no
	 * @throws SiccException
	 */
	public void count_up(String file_no) throws SiccException;
	
	/**
	 * 삽입 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void insert(FileVO vo) throws SiccException;
	
	/**
	 * 파일 하나의 정보 조회  
	 *
	 * @Version : 1.0
	 * @Method read
	 * @param file_no
	 * @return
	 * @throws SiccException
	 */
	public FileVO read(String file_no) throws SiccException;

	/**
	 * 파일 하나 삭제  
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param file_no
	 * @throws SiccException
	 */
	public void delete(String file_no) throws SiccException;

	/**
	 * 게시물에 포함되는 파일 전체 삭제  
	 *
	 * @Version : 1.0
	 * @Method delete_all
	 * @param group_no
	 * @throws SiccException
	 */
	public void delete_all(String group_no) throws SiccException;
}
