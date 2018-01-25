package kr.co.sicc.gsp.svm.gms.common.utils.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.gmsutil.file.FilePath;
import com.gmsutil.file.FileUpDown;
import com.gmsutil.file.FileVO;

import kr.co.sicc.gsp.svm.gms.common.login.UserInfo;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

@Component
public class CmmFileManager extends FileUpDown{
	@Autowired
	FileService fileService;

	/**
	 * 
	 */
	public CmmFileManager() {

	}

	/**
	 * 파일을 저장하고 파일 정보를 DB에 저장한다. 
	 *
	 * @Version : 1.0
	 * @Method save
	 * @param uploadPathId
	 * @param workNm
	 * @param groupNo
	 * @param file
	 * @param userInfo
	 * @return
	 * @throws IOException
	 */
	public FilePath save(String uploadPath, String workNm, String groupNo, MultipartFile file, UserInfo userInfo) throws SiccException {
		if (file.isEmpty() == true) {
			return null;
		}
		FilePath filePath = null;
		String fileOrigianlName = null;
		try {
			if(uploadPath != null && !uploadPath.equals("")){
				filePath = new FilePath(uploadPath, file.getOriginalFilename());
				upload(filePath, file.getBytes());
	
				FileVO fileVO = new FileVO();
				fileVO.setSystem_cd(userInfo.getCurrent_system_cd());
				fileVO.setWork_nm(workNm);
				fileVO.setFile_group_no(groupNo);
				fileVO.setFile_no(filePath.getFileNo());
				
				fileOrigianlName = file.getOriginalFilename();
				if(fileOrigianlName != null && fileOrigianlName.indexOf("\\") > -1){
					fileOrigianlName = fileOrigianlName.substring(fileOrigianlName.lastIndexOf("\\")+1);
				}
				fileVO.setFile_nm(fileOrigianlName);
				
				fileVO.setSave_file_nm(filePath.getWebPathName());
				fileVO.setFile_size((int) file.getSize());
				fileVO.setFile_content_type(file.getContentType());
				fileVO.setDownload_cnt(0);
				fileVO.setCrt_id(userInfo.getUsername());
				fileVO.setCrt_ip(userInfo.getUser_ip());
				fileVO.setUdt_id(userInfo.getUsername());
				fileVO.setUdt_ip(userInfo.getUser_ip());
	
				fileService.insert(fileVO);
			}else{
				return null;
			}
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		}
		
		return filePath;
	}
	
	/**
	 * 파일 정보를 생성하고 관련 정보를 DB에 넣는다. 
	 *
	 * @Version : 1.0
	 * @Method getFilePath
	 * @param uploadPathId
	 * @param workNm
	 * @param groupNo
	 * @param fileName
	 * @param userInfo
	 * @return
	 * @throws IOException
	 */
	public FilePath getFilePath(String uploadPath, String workNm, String groupNo, String fileName, UserInfo userInfo) throws IOException {
		FilePath filePath = null;
		if(uploadPath != null && !uploadPath.equals("")){
			filePath = new FilePath(uploadPath, fileName);
			
			FileVO fileVO = new FileVO();
			fileVO.setSystem_cd(userInfo.getCurrent_system_cd());
			fileVO.setWork_nm(workNm);
			fileVO.setFile_group_no(groupNo);
			fileVO.setFile_no(filePath.getFileNo());
			fileVO.setFile_nm(fileName);
			fileVO.setSave_file_nm(filePath.getWebPathName());
			fileVO.setFile_size(0);
			fileVO.setFile_content_type("");
			fileVO.setDownload_cnt(0);
			fileVO.setCrt_id(userInfo.getUsername());
			fileVO.setCrt_ip(userInfo.getUser_ip());
			fileVO.setUdt_id(userInfo.getUsername());
			fileVO.setUdt_ip(userInfo.getUser_ip());

			fileService.insert(fileVO);
		}else{
			return null;
		}
		
		return filePath;
	}

	/**
	 * 파일을 삭제한다. 
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param file_no
	 */
	public void delete(String file_no) {
		fileService.delete(file_no);
	}

	/**
	 * 같은 그룹넘버를 가진 파일 전부를 삭제한다. 
	 *
	 * @Version : 1.0
	 * @Method delete_all
	 * @param group_no
	 */
	public void delete_all(String group_no) {
		fileService.delete_all(group_no);
	}

	/**
	 * 같은 그룹넘버를 가진 파일의 목록을 반환한다. 
	 *
	 * @Version : 1.0
	 * @Method list
	 * @param group_no
	 * @return
	 */
	public List<Map<String, Object>> list(String group_no) {
		return fileService.list(group_no);
	}

	/**
	 * 파일을 다운로드 한다. 
	 *
	 * @Version : 1.0
	 * @Method download
	 * @param uploadPathId
	 * @param file_no
	 * @param userAgent
	 * @return
	 * @throws SiccException
	 */
	public ResponseEntity<byte[]> download(String uploadPath, String file_no, String userAgent) throws SiccException {
		try {
			FilePath filePath = null;
			if(uploadPath != null && !uploadPath.equals("")){
				FileVO fileVo = fileService.read(file_no);
				fileService.count_up(file_no);
				filePath = new FilePath(uploadPath, fileVo.getSave_file_nm(), fileVo.getFile_nm());
			}else{
				return null;
			}
			
			return download(filePath, userAgent);
		} catch (UnsupportedEncodingException e) {
			throw SiccMessageUtil.getError(e);
		} catch (FileNotFoundException e) {
			throw SiccMessageUtil.getError(e);
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/**
	 * 이미지를 다운로드 한다. 
	 *
	 * @Version : 1.0
	 * @Method image
	 * @param uploadPathId
	 * @param file_no
	 * @param userAgent
	 * @return
	 * @throws SiccException
	 */
	public ResponseEntity<byte[]> image(String uploadPath, String file_no, String userAgent) throws SiccException {
		try {
			FilePath filePath = null;
			if(uploadPath != null && !uploadPath.equals("")){
				FileVO fileVo = fileService.read(file_no);
				filePath = new FilePath(uploadPath, fileVo.getSave_file_nm(), fileVo.getFile_nm());
			}else{
				return null;
			}
			
			return image(filePath, userAgent);
		} catch (UnsupportedEncodingException e) {
			throw SiccMessageUtil.getError(e);
		} catch (FileNotFoundException e) {
			throw SiccMessageUtil.getError(e);
		} catch (IOException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
}
