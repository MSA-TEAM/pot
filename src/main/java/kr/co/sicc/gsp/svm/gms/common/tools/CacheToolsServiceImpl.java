package kr.co.sicc.gsp.svm.gms.common.tools;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsService;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

public class CacheToolsServiceImpl  implements SiccToolsService{

	@Override
	public List<Map<String, Object>> select(SiccToolsVO vo, SqlSession session) {
		try{
			WholeToolsDAO mapper = session.getMapper(WholeToolsDAO.class);
			
			switch(vo.getSystem_cd()){
				case "TCO" :
					return mapper.tco(vo);
				case "ATV" :
					return mapper.atv(vo);
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
