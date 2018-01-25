package kr.co.sicc.gsp.svm.gms.common.utils.file;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gmsutil.file.FileVO;

import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>
 * com.gms.sys.service.impl
 * FileServiceImpl.java
 * Description : 
 *		첨부파일 서비스 Impl
 * History     :
 * </pre>
 *
 * @author	 : randy80
 * @Date	 : 2016. 1. 29.
 * @Version : 1.0
 *
 */
@Service
public class FileServiceImpl implements FileService{

	@Autowired
	@Resource(name="sqlSession")
	SqlSession session;
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.FileService#list(java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> list(String group_no) throws SiccException{
		try{
			FileDAO mapper = session.getMapper(FileDAO.class);

			return mapper.list(group_no);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gms.sys.service.FileService#count_up(java.lang.Integer, java.lang.String)
	 */
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void count_up(String file_no) throws SiccException {
		try{
			FileDAO mapper = session.getMapper(FileDAO.class);
			mapper.count_up(file_no);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gms.sys.service.FileService#insert(com.gms.sys.vo.FileVO)
	 */
	@Override
	//@Transactional
	public void insert(FileVO vo) throws SiccException {
		try{
			FileDAO mapper = session.getMapper(FileDAO.class);
			mapper.insert(vo);
		    
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.FileService#read(java.lang.Integer, java.lang.String)
	 */
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public FileVO read(String file_no) throws SiccException {
		try{
			FileDAO mapper = session.getMapper(FileDAO.class);
			return mapper.read(file_no);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.FileService#delete(java.lang.Integer, java.lang.String)
	 */
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void delete(String file_no) throws SiccException {
		try{
			FileDAO mapper = session.getMapper(FileDAO.class);
			mapper.delete(file_no);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.FileService#delete_all(java.lang.Integer)
	 */
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void delete_all(String group_no) throws SiccException {
		try{
			FileDAO mapper = session.getMapper(FileDAO.class);
			mapper.delete_all(group_no);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
}
