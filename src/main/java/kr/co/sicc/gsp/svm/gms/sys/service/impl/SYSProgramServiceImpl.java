package kr.co.sicc.gsp.svm.gms.sys.service.impl;

import java.util.ArrayList;
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

import kr.co.sicc.gsp.svm.gms.common.tools.ToolsVO;
import kr.co.sicc.gsp.svm.gms.sys.dao.SYSProgramDAO;
import kr.co.sicc.gsp.svm.gms.sys.service.SYSProgramService;
import kr.co.sicc.gsp.svm.gms.sys.vo.SYSProgramVO;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsManager;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;
import kr.co.sicc.gsp.svm.sicc.util.SiccUserUtil;

@Service
public class SYSProgramServiceImpl implements SYSProgramService{

	@Autowired
	@Resource(name="sqlSession")
	SqlSession session;
	
	@Autowired
	SiccToolsManager toolsManager;
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#list(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	public SYSProgramVO list_view(SYSProgramVO vo) throws SiccException{
		try{
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			
			vo.setResult(toolsManager.select(vo_list));
			
			return vo;
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#list(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	public SYSProgramVO list(SYSProgramVO vo) throws SiccException{
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			
			vo.setList(mapper.list(vo));
			
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			
			vo.setResult(toolsManager.select(vo_list));
			
			return vo;
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#delete(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void delete(SYSProgramVO vo) throws SiccException {
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			
			if("0".equals(vo.getP_menu_lvl())){
				mapper.delete_attached_group_lv0(vo);				
			}else{
				mapper.delete_granted_group(vo);
			}
			mapper.delete(vo);
			
			mapper.lang_delete(vo.getP_menu_id(), "en");
			
//			if (vo.getMenu_lvl().equals("0")){
//				vo.setDelete_list(mapper.delete_list(vo));
//				mapper.delete_0(vo);
//				for(int i=0; i<vo.getDelete_list().size(); i++){
//					mapper.delete_lang_0(vo.getDelete_list().get(i));
//				}
//			}else{
//				mapper.delete(vo);
//				mapper.delete_lang(vo);
//			}
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#edit(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	public SYSProgramVO edit(SYSProgramVO vo) throws SiccException {
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			Map<String, Object> resultMap = mapper.edit(vo.getP_menu_id());
		    
			SiccBeanUtils.populate(vo, resultMap);
			
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			
			ToolsVO menu = null;
			
			if(vo.getP_menu_lvl() != null && vo.getP_menu_lvl().equals("0")){
				menu = new ToolsVO("SYS", "MENU_LIST", "CODE_NM1", "0", vo.getSystem_cd());				
			}else{
				menu = new ToolsVO("SYS", "MENU_LIST", "CODE_NM1", "1", vo.getSystem_cd(), vo.getP_menu_id());
			}
			
			ToolsVO group_id = new ToolsVO("SYS", "PROGRAM_GROUP_LIST", "CODE_NM1", vo.getP_menu_id());
			ToolsVO granted_group_id = new ToolsVO("SYS", "GRANTED_PROGRAM_GROUP_LIST", "CODE_NM1", vo.getP_menu_id());
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			vo_list.add(menu);
			vo_list.add(group_id);
			vo_list.add(granted_group_id);
			
			vo.setResult(toolsManager.select(vo_list));
			
			vo.setGroup_system_cd(vo.getSystem_cd());
			
			return vo;
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#edit(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	public SYSProgramVO input(SYSProgramVO vo) throws SiccException {
		try{
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			
			ToolsVO menu = null;
			if(vo.getP_menu_lvl() != null && vo.getP_menu_lvl().equals("new")){
				menu = new ToolsVO("SYS", "MENU_LIST", "CODE_NM1", "0", vo.getSystem_cd());
			}else{
				menu = new ToolsVO("SYS", "MENU_LIST", "CODE_NM1", "1", vo.getSystem_cd(), vo.getP_menu_id());
			}
			
			ToolsVO group_id = new ToolsVO("SYS", "PROGRAM_GROUP_LIST", "CODE_NM1");
			ToolsVO granted_group_id = new ToolsVO("SYS", "GRANTED_PROGRAM_GROUP_LIST", "CODE_NM1");
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			vo_list.add(menu);
			vo_list.add(group_id);
			vo_list.add(granted_group_id);
			
			vo.setResult(toolsManager.select(vo_list));
			
			vo.setGroup_system_cd(vo.getSystem_cd());
			
			return vo;
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#update(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void update(SYSProgramVO vo) throws SiccException {
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			int result = mapper.update(vo);
			
//			int cnt = 0;
//			cnt = mapper.check_en_language(vo);
//			if (cnt > 0) {
//				int result_en = mapper.en_update(vo);
//			}else{
//				mapper.en_insert(vo);
//			}
			
			if (!"0".equals(vo.getP_menu_lvl())) {
                check_duplication(vo);
            }
			
			String[] hd_order_list = vo.getHd_order_list();
			
			if(hd_order_list != null && hd_order_list.length > 0){
				if("0".equals(vo.getMenu_lvl())){
					for(int i=0 ; i<hd_order_list.length ; i++){
						mapper.update_order_0(i+1, hd_order_list[i], vo.getSystem_cd());
					}
					mapper.update_order_0_main(vo.getSystem_cd());
				}else{
					for(int i=0 ; i<hd_order_list.length ; i++){
						mapper.update_order_1(i+1, hd_order_list[i]);
					}
				}
			}
			
			if(null != vo.getHd_granted_group_id() && vo.getHd_granted_group_id().length > 0){
				mapper.delete_granted_group(vo);
				mapper.insert_granted_group(vo);				
			}
			
			vo.setMenu_lang("en");
			vo.setP_menu_lang("en");
			
			int lang_cnt = mapper.check_lang(vo);
			if(lang_cnt > 0){
				mapper.lang_update(vo);
			}else{
				mapper.lang_insert(vo);
			}
			
			
//			String p_menu_ord_list = vo.getP_menu_ord_list();
//			String[] menu_ord_list = new String(p_menu_ord_list).split(",");
//			if (vo.getMenu_lvl().equals("0")) {			
//				for(int i=0;i < menu_ord_list.length; i++){
//					mapper.update_order_0(
//							vo.getP_system_cd().equals("SYS")?90+i+1:i+1, 
//							vo.getP_system_cd(), 
//							menu_ord_list[i].equals("0")?vo.getMenu_id():menu_ord_list[i] );
//				}
//				
//				mapper.update_order_0_main(vo.getP_system_cd());
//				
//			} else {
//				for(int i=0;i< menu_ord_list.length; i++){
//					mapper.update_order_1(
//							i+1, 
//							vo.getP_system_cd(), 
//							menu_ord_list[i].equals("0")?vo.getMenu_id():menu_ord_list[i] );
//				}				
//			}
			if(0 == result){
				throw SiccMessageUtil.getError("db.sql.update_fail");				
			}
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#insert(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	@Transactional
	public void insert(SYSProgramVO vo) throws SiccException {
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			
			String gen_menu_id = null;
			if(mapper.insert_menu_id(vo)==null){
				gen_menu_id = vo.getSystem_cd()+"0000001";
				
			}else{
				gen_menu_id = mapper.insert_menu_id(vo);
			}
			vo.setMenu_id(gen_menu_id);
			vo.setP_menu_id(gen_menu_id);
			
			if (!"new".equals(vo.getP_menu_lvl())) {
                check_duplication(vo);
            }
			
			if ("1".equals(vo.getMenu_lvl())) {
                vo.setMenu_ord(vo.getP_menu_ord());
                vo.setP_menu_lvl("1");
            }else{
            	vo.setP_menu_lvl("0");
            }
			
			mapper.insert(vo);
			
			String[] hd_order_list = vo.getHd_order_list();
			
			if(hd_order_list != null && hd_order_list.length > 0){
				if("new".equals(vo.getP_menu_lvl()) || "0".equals(vo.getMenu_lvl())){
					for(int i=0 ; i<hd_order_list.length ; i++){
						if("new".equalsIgnoreCase(hd_order_list[i])){
							mapper.update_order_0(i+1, gen_menu_id, vo.getSystem_cd());
						}else{
							mapper.update_order_0(i+1, hd_order_list[i], vo.getSystem_cd());
						}
					}
					mapper.update_order_0_main(vo.getSystem_cd());
				}else{
					for(int i=0 ; i<hd_order_list.length ; i++){
						if("new".equalsIgnoreCase(hd_order_list[i])){
							mapper.update_order_1(i+1, gen_menu_id);
						}else{
							mapper.update_order_1(i+1, hd_order_list[i]);
						}
					}
				}
			}
			
			if(null != vo.getHd_granted_group_id() && vo.getHd_granted_group_id().length > 0){
				mapper.delete_granted_group(vo);
				mapper.insert_granted_group(vo);				
			}
			
			vo.setMenu_lang("en");
			vo.setP_menu_lang("en");
			mapper.lang_insert(vo);
			
//			vo.setP_menu_id(vo.getMenu_id());			
//			mapper.en_insert(vo);

//			String p_menu_ord_list = vo.getP_menu_ord_list();
//			String[] menu_ord_list = new String(p_menu_ord_list).split(",");
//			if (vo.getMenu_lvl().equals("0")) {			
//				for(int i=0;i < menu_ord_list.length; i++){
//					mapper.update_order_0(
//							vo.getP_system_cd().equals("SYS")?90+i+1:i+1, 
//							vo.getP_system_cd(), 
//							menu_ord_list[i].equals("0")?vo.getMenu_id():menu_ord_list[i] );
//				}
//				
//				mapper.update_order_0_main(vo.getP_system_cd());
//				
//			} else {
//				for(int i=0;i< menu_ord_list.length; i++){
//					mapper.update_order_1(
//							i+1, 
//							vo.getP_system_cd(), 
//							menu_ord_list[i].equals("0")?vo.getMenu_id():menu_ord_list[i] );
//				}				
//			}
		    
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#check_duplication(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	public void check_duplication(SYSProgramVO vo) throws SiccException{
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			//SiccUserUtil.setDefaultUserInfo(vo);
			
			int cnt = 0;
			cnt = mapper.check_duplication_control(vo);
			
			if (cnt > 0) {
				throw SiccMessageUtil.getError("db.sql.update_fail");	
            }
			
			cnt = mapper.check_duplication(vo);
			if (cnt > 0) {
				throw SiccMessageUtil.getError("db.sql.update_fail");		
            }
			
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#langlist(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	public SYSProgramVO langlist(SYSProgramVO vo) throws SiccException{
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			
			vo.pageInit();
			vo.setList(mapper.langlist(vo));
			
			return vo;
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#lang_insert(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	@Transactional
	public void lang_insert(SYSProgramVO vo) throws SiccException {
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			int cnt = 0;
			cnt = mapper.check_duplication_language(vo);
			
			if (cnt > 0) {
				throw SiccMessageUtil.getError("db.sql.update_fail");	
            }
						
			mapper.lang_insert(vo);

		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}	
	
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#lang_delete(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public int lang_delete(SYSProgramVO vo) throws SiccException {
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			
			SiccUserUtil.setDefaultUserInfo(vo);
			
//			String[] menu_id = vo.getHd_menu_id();
//			String[] menu_lang = vo.getHd_menu_lang();
			
			int cnt = 0;
			
//			for(int i=0;i<menu_id.length;i++){
//				cnt += mapper.lang_delete(menu_id[i], menu_lang[i]);
//			}
			
			return cnt;
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.gms.sys.service.SYSProgramService#lang_update(com.gms.sys.vo.SYSProgramVO)
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void lang_update(SYSProgramVO vo) throws SiccException {
		try{
			SYSProgramDAO mapper = session.getMapper(SYSProgramDAO.class);
			int result = mapper.lang_update(vo);
			
			if(0 == result){
				throw SiccMessageUtil.getError("db.sql.update_fail");				
			}
		}catch(DataAccessException e){
			throw SiccMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw SiccMessageUtil.getError(e);
		}
	}
}
