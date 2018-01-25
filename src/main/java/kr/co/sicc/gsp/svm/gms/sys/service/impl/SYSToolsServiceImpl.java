package kr.co.sicc.gsp.svm.gms.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.sicc.gsp.svm.gms.sys.dao.SYSToolsDAO;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsService;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

@Service
public class SYSToolsServiceImpl implements SiccToolsService{
	@Override
	public List<Map<String, Object>> select(SiccToolsVO vo, SqlSession session) throws SiccException{
		try{
			SYSToolsDAO mapper = session.getMapper(SYSToolsDAO.class);
			
			switch(vo.getCode_find()){
				case "PARTI_NOC" :
					return mapper.tco(vo);
				case "SYS_PROGRAM_MENU" :
					return mapper.order_list(vo);
				case "SYS_ACCESSPRIV_LIST" :
					return mapper.accesspriv_list(vo);
				case "SYS_PROGRAM_MENU_INSERT" :
					return mapper.order_list_insert(vo);
				case "GROUP_LIST" :
					System.out.println("GROUP_LIST");
					return mapper.group_list(vo);
				case "GRANTED_GROUP_LIST" :
					System.out.println("GRANTED_GROUP_LIST");
					return mapper.granted_group_list(vo);	
				case "PROGRAM_GROUP_LIST" :
					return mapper.program_group_list(vo);
				case "GRANTED_PROGRAM_GROUP_LIST" :
					return mapper.granted_program_group_list(vo);
				case "CHK_USER_ID":
					return mapper.chk_user_id(vo);
				case "MENU_LIST":
					return mapper.menu_list(vo);
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
