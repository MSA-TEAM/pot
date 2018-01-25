package kr.co.sicc.gsp.svm.gms.common.tools;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsService;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

@Service
public class ToolsServiceImpl implements SiccToolsService{
	
	@Override
	public List<Map<String, Object>> select(SiccToolsVO vo, SqlSession session) throws SiccException{
		try{
			ToolsDAO mapper = session.getMapper(ToolsDAO.class);
			
			switch(vo.getCode_find()){
				case "PARTI_NOC" :
					return mapper.tco(vo);
				case "VOL_APPLICATION" :
					return mapper.tco(vo);
				default :
					return mapper.tco(vo);
	    	}
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}

}
