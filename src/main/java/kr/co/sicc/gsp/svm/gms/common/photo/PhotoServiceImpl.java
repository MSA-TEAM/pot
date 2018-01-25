package kr.co.sicc.gsp.svm.gms.common.photo;

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
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	@Resource(name="sqlSession")
	SqlSession session;

	@Override
	//@Transactional
	public void insert(PhotoVO vo) throws SiccException {
		try{
			PhotoDAO mapper = session.getMapper(PhotoDAO.class);
			mapper.insert(vo);
		    
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public PhotoVO read(String ad_no) throws SiccException {
		try{
			PhotoDAO mapper = session.getMapper(PhotoDAO.class);
			return mapper.read(ad_no);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	//@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void delete(String ad_no) throws SiccException {
		try{
			PhotoDAO mapper = session.getMapper(PhotoDAO.class);
			mapper.delete(ad_no);
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
}
