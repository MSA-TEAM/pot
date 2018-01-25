package kr.co.sicc.gsp.svm.gms.svm.photo;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

@Service
public class SVMPhotoServiceImpl implements SVMPhotoService{

	@Autowired
	@Resource(name="sqlSession")
	SqlSession session;

	@Override
	//@Transactional
	public void insert(SVMPhotoVO vo) throws SiccException {
		try{
			SVMPhotoDAO mapper = session.getMapper(SVMPhotoDAO.class);
			mapper.insert(vo);
		    
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public Map<String, Object> read(String ad_no  , String photo_fg) throws SiccException {
		try{
			SVMPhotoDAO mapper = session.getMapper(SVMPhotoDAO.class);
			return mapper.read(ad_no, photo_fg);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}catch(Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void delete(String ad_no  , String photo_fg) throws SiccException {
		try{
			SVMPhotoDAO mapper = session.getMapper(SVMPhotoDAO.class);
			mapper.delete(ad_no , photo_fg);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	//@Transactional
	public void insertPassport(SVMPhotoVO vo) throws SiccException {
		try{
			SVMPhotoDAO mapper = session.getMapper(SVMPhotoDAO.class);
			mapper.insertPassport(vo);
		    
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}catch(Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public Map<String, Object> readPassport(String ad_no  , String photo_fg) throws SiccException {
		try{
			SVMPhotoDAO mapper = session.getMapper(SVMPhotoDAO.class);
			return mapper.readPassport(ad_no , photo_fg);
			
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}catch(Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void deletePassport(String ad_no  , String photo_fg) throws SiccException {
		try{
			SVMPhotoDAO mapper = session.getMapper(SVMPhotoDAO.class);
			mapper.deletePassport( ad_no  , photo_fg);
			
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}catch(Exception e){
			throw SiccMessageUtil.getError(e);
		}
	}

	@Override
	public void insert(String ad_no, String photo_fg) throws SiccException {
		
		
	}
}
