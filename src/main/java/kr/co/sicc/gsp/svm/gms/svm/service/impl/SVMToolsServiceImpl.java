package kr.co.sicc.gsp.svm.gms.svm.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.sicc.gsp.svm.gms.svm.dao.SVMToolsDAO;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsService;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsVO;

import kr.co.sicc.gsp.svm.sicc.util.SVMSiccUserUtil;
import kr.co.sicc.gsp.svm.gms.svm.vo.SVMUserVO;

@Service
public class SVMToolsServiceImpl implements SiccToolsService {

	@Override
	public List<Map<String, Object>> select(SiccToolsVO vo, SqlSession session) throws SiccException {
		try {
			SVMToolsDAO mapper = session.getMapper(SVMToolsDAO.class);
			
			SVMUserVO userVo = SVMSiccUserUtil.getUserInfo();
			
			vo.setAd_no(userVo.getAd_no());
			
			switch(vo.getCode_find()){
				case "CATEGORY_CD" :
					return mapper.categoryList(vo);
				case "FUNCTION_CD" :
					return mapper.functionList(vo);
				case "ORG_CD" :
					return mapper.orgList(vo);
				case "CTRY_CD_FG" 	 		:  
				case "E_MAIL" 				:  
				case "BANK_CD" 				:  
				case "OCCU_CD"				:  
				case "UNIV_CD" 		 		:  
				case "UNIV_STAT" 	 		:  
				case "VOL_CENTER_CD" 		:  
				case "AVAIL_LOCATION_CD" 	:  
				case "JOB_CD" 				:  
				case "LANG_LVL_CD" 			:  
				case "AVAIL_WORK_CD" 		:  
				case "UNI_SHIRTS_CD" 		:  
				case "UNI_WAIST_CD" 		:  
				case "UNI_SHOES_CD" 		:  
				case "VOL_DIV_CD" 			:  
				case "MARRIED" 				:  
				case "TOV" 					:  
				case "PD" 					:  
				case "OCCU_OR_UNIV_CD"		:  
				case "OCCU_OR_UNIV_MAJOR_CD":  
				case "RELATION_CD"			:  
				case "SPORT_EXP_LVL"		:  
				case "ETC_EXP_LVL" 			:  
				case "PROVINCE_CD"			:  
				case "CITY_CD"				:  
				case "VILLAGE_CD"			:  
				case "DISTRICT_CD" 			:  
					return mapper.svmCodeList(vo);
				case "SPORT_EXP_NM"			:
					return mapper.changeExperience(vo);
				default :
					return mapper.tco(vo);
			}
		} catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
}
