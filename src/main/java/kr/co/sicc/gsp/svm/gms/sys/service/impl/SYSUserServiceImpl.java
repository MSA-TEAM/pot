package kr.co.sicc.gsp.svm.gms.sys.service.impl;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
import kr.co.sicc.gsp.svm.gms.sys.dao.SYSToolsDAO;
import kr.co.sicc.gsp.svm.gms.sys.dao.SYSUserDAO;
import kr.co.sicc.gsp.svm.gms.sys.service.SYSUserService;
import kr.co.sicc.gsp.svm.gms.sys.vo.SYSUserVO;
import kr.co.sicc.gsp.svm.sicc.aeschiper.FileCoder;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsManager;
import kr.co.sicc.gsp.svm.sicc.util.GMSStringUtil;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;
import kr.co.sicc.gsp.svm.sicc.util.SiccUserUtil;

@Service
public class SYSUserServiceImpl implements SYSUserService {
	
	@Autowired
	@Resource(name="sqlSession")
	SqlSession session;
	
	@Autowired
	SiccToolsManager toolsManager;
	
	@Override
	public SYSUserVO list_view(SYSUserVO vo) throws SiccException {
		try {
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			ToolsVO group_id 	= new ToolsVO("SYS", "GROUP_LIST", "CODE_NM1", "");
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			vo_list.add(group_id);
			
			vo.setResult(toolsManager.select(vo_list));
			
			return vo;
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SYSUserVO list(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);
			
			vo.pageInit();
			vo.setList(mapper.list(vo));
			vo.setTotal_cnt(mapper.total_cnt(vo));
			
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			ToolsVO group_id 	= new ToolsVO("SYS", "GROUP_LIST", "CODE_NM1", "");
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			vo_list.add(group_id);
			
			vo.setResult(toolsManager.select(vo_list));
			
			return vo;
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public int delete(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);
			
			SiccUserUtil.setDefaultUserInfo(vo);
			
			String[] user_id = vo.getHd_user_id();
			String[] user_nm = vo.getHd_user_nm();
			String[] system_cd = vo.getHd_system_cd();
			String[] chk = vo.getChk();
			
			int cnt = 0;
			
			int index = 0;
			
			if((chk != null && chk.length > 0) == false){
				return 0;
			}
			
			for(int i=0; i<chk.length; i++) {
				index = Integer.valueOf(chk[i]);
				
				vo.setP_user_id(user_id[index]);
				vo.setUser_nm(user_nm[index]);
				vo.setSystem_cd(system_cd[index]);
				
				cnt += mapper.delete(vo.getP_user_id(), vo.getSystem_cd());
				
				// History
//				vo.setStatus("DELETE");
//				vo.setRevision_history("Data deleted.");
//				mapper.insert_history(vo);
			}
			
			return cnt;
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SYSUserVO edit(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);
			
			System.out.println("X");
			
			Map<String, Object> resultMap = mapper.edit(vo.getP_user_id(), vo.getP_system_cd());
			SiccBeanUtils.populate(vo, resultMap);
			
			vo.setPassword("");
			vo.setPassword_confirm("");
			
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			ToolsVO group_id = new ToolsVO("SYS", "GROUP_LIST", "CODE_NM1", "", vo.getP_system_cd(),  vo.getP_user_id());
			
			ToolsVO granted_group_id = new ToolsVO("SYS", "GRANTED_GROUP_LIST", "CODE_NM1", vo.getGroup_system_cd(),  vo.getP_system_cd(), vo.getP_user_id());
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			vo_list.add(group_id);
			vo_list.add(granted_group_id);
			
			vo.setResult(toolsManager.select(vo_list));
			
			return vo;
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	@Transactional
	public SYSUserVO input(SYSUserVO vo) throws SiccException {
		try {
			ToolsVO system 		= new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			ToolsVO group_id = new ToolsVO("SYS", "GROUP_LIST", "CODE_NM1", vo.getGroup_system_cd(), vo.getP_system_cd(), vo.getP_user_id());
//			ToolsVO granted_group_id = new ToolsVO("SYS", "GRANTED_GROUP_LIST", "CODE_NM1", vo.getP_user_id());
			
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			vo_list.add(group_id);
//			vo_list.add(granted_group_id);
			
			vo.setResult(toolsManager.select(vo_list));
			
			return vo;
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	@Transactional
	public void insert(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);

			SiccUserUtil.setDefaultUserInfo(vo);
			
			// password	: 암호화하기 위한 salt값 생성
			String strSalt = FileCoder.getSalt();
			// user_id + password 와 salt 값을 조합하여 암호화된 암호를 생성한다.
			String newPassword = FileCoder.ComputeHash(vo.getUser_id() + vo.getPassword(), strSalt);	
			// salt 값을 보호하기 위해 암호화하여 DB에 저장
			String saltBase64 = FileCoder.byteToBase64(strSalt.getBytes("UTF-8"));
			
			vo.setNewPassword(newPassword);
			vo.setSaltBase64(saltBase64);
			
//			// 그룹ID 값(배열 TO 문자열) 설정
//			STRING ASSIGNED_GROUP_ID = GMSSTRINGUTIL.TOTOKENFROMSTRING(VO.GETGRANTED_GROUP_ID(), ",");
//			VO.SETASSIGN_GROUP_ID(ASSIGNED_GROUP_ID);

			// SYSUSERM
			mapper.insert(vo);
			
			if(vo.getGranted_group_id() != null) {
				for(int i=0; i<vo.getGranted_group_id().length; i++) {
					vo.setGroup_id(vo.getGranted_group_id()[i]);
					mapper.insert_group(vo);
				}
			} 
			vo.setP_user_id(vo.getUser_id());
			vo.setP_system_cd(vo.getSystem_cd());
			
			// History
//			vo.setStatus("INSERT");
//			vo.setRevision_history("User created.");
//			mapper.insert_history(vo);
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch(NoSuchAlgorithmException e) {
			throw SiccMessageUtil.getError(e);
		} catch(UnsupportedEncodingException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public void update(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);
			
			SiccUserUtil.setDefaultUserInfo(vo);
			
 			if(!vo.getPassword().equals("")) {
				// password	: 암호화하기 위한 salt값 생성
				String strSalt = FileCoder.getSalt();
				// user_id + password 와 salt 값을 조합하여 암호화된 암호를 생성한다.
				String newPassword = FileCoder.ComputeHash(vo.getUser_id() + vo.getPassword(), strSalt);	
				// salt 값을 보호하기 위해 암호화하여 DB에 저장
				String saltBase64 = FileCoder.byteToBase64(strSalt.getBytes("UTF-8"));
				
				vo.setNewPassword(newPassword);
				vo.setSaltBase64(saltBase64);
			} 
			
			// 그룹ID 값(배열 to 문자열) 설정
			String assigned_group_id = GMSStringUtil.toTokenFromString(vo.getGranted_group_id(), ",");
			vo.setAssign_group_id(assigned_group_id);
			
			// SYSUSERM
			int result = mapper.update(vo);
			
			if(result == 0) {
				throw SiccMessageUtil.getError("db.sql.update_fail");
			}
			
			// History
//			vo.setStatus("UPDATE");
//			vo.setRevision_history("Data updated. ");
//			mapper.insert_history(vo);
//			
//			
			if(!vo.getAssign_group_id().equals(vo.getPre_group_id())) {
				// 그룹 id 삭제
				mapper.delete_group(vo.getP_user_id(), vo.getSystem_cd());

				// 그룹 id 등록
				for(int i=0; i<vo.getGranted_group_id().length; i++) {
					vo.setGroup_id(vo.getGranted_group_id()[i]);
					// SYSUSERGROUPD
					mapper.insert_group(vo);
				}
			}
			
			vo.setP_system_cd(vo.getSystem_cd());
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		} catch(NoSuchAlgorithmException e) {
			throw SiccMessageUtil.getError(e);
		} catch(UnsupportedEncodingException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	@Transactional
	public void insert_priv(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);
			
			SiccUserUtil.setDefaultUserInfo(vo);
			
			String[] system_priv_auth;
			String pre_system_cd = "";
			String system_cd 	= "";
			String pre_priv 	= "";
			String priv 		= "";
			StringBuffer auth 	= new StringBuffer();
			
			for(int i=0; i<vo.getChk_group_authority().length; i++) {
				system_priv_auth = vo.getChk_group_authority()[i].split("/");		// ex) "MED/MED_ADMIN/1", "MED/MED_ADMIN/2", "ADM/ADM_USER/2"
				system_cd 	= system_priv_auth[0];
				priv 		= system_priv_auth[1];
				
				if(!priv.equals(pre_priv) && i != 0) {
					vo.setPriv_system_cd(pre_system_cd);
					vo.setAccess_priv(pre_priv);
					vo.setAuthority(auth.toString());
					
					if(!vo.getAuthority().equals("") && !vo.getAuthority().equals("0")) {
						// SYSUSERPOWERD
						mapper.insert_auth(vo);
					}
					
					auth.setLength(0);
					auth.append(system_priv_auth[2]);
					
					pre_system_cd = system_cd;
					pre_priv = priv;
					
				} else {
					if(i == 0) {
						pre_system_cd = system_cd;
						pre_priv = priv;
					}
					auth.append(system_priv_auth[2]);
				}
				
				// Last 
				if(i == vo.getChk_group_authority().length-1) {
					vo.setPriv_system_cd(system_cd);
					vo.setAccess_priv(priv);
					vo.setAuthority(auth.toString());
					
					if(!vo.getAuthority().equals("") && !vo.getAuthority().equals("0")) {
						// SYSUSERPOWERD
						mapper.insert_auth(vo);
					}
				}
			}
			
			// History
			vo.setStatus("UPDATE");
			vo.setRevision_history("Priv Insert : ");
			mapper.insert_history(vo);
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public void update_priv(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);
			
			SiccUserUtil.setDefaultUserInfo(vo);

			// 부여된 권한 삭제
			mapper.delete_priv(vo.getP_user_id(), vo.getSystem_cd());
			
			// 새로 권한 부여
			String[] system_priv_auth;
			String pre_system_cd = "";
			String system_cd 	= "";
			String pre_priv 	= "";
			String priv 		= "";
			StringBuffer auth 	= new StringBuffer();
			
			if(vo.getChk_granted_authority() != null && !vo.getChk_granted_authority().equals("")) {
				for(int i=0; i<vo.getChk_granted_authority().length; i++) {
					system_priv_auth = vo.getChk_granted_authority()[i].split("/");		// ex) "MED/MED_ADMIN/1", "MED/MED_ADMIN/2", "ADM/ADM_USER/2"
					system_cd 	= system_priv_auth[0];
					priv 		= system_priv_auth[1];
					
					if(!priv.equals(pre_priv) && i != 0) {
						vo.setPriv_system_cd(pre_system_cd);
						vo.setAccess_priv(pre_priv);
						vo.setAuthority(auth.toString());
						
						if(!vo.getAuthority().equals("") && !vo.getAuthority().equals("0")) {
							// SYSUSERPOWERD
							mapper.insert_auth(vo);
						}
						
						auth.setLength(0);
						auth.append(system_priv_auth[2]);
						
						pre_system_cd = system_cd;
						pre_priv = priv;
						
					} else {
						if(i == 0) {
							pre_system_cd = system_cd;
							pre_priv = priv;
						}
						auth.append(system_priv_auth[2]);
					}
					
					// Last 
					if(i == vo.getChk_granted_authority().length-1) {
						vo.setPriv_system_cd(system_cd);
						vo.setAccess_priv(priv);
						vo.setAuthority(auth.toString());
						
						if(!vo.getAuthority().equals("") && !vo.getAuthority().equals("0")) {
							// SYSUSERPOWERD
							mapper.insert_auth(vo);
						}
					}
				}
			}
			
			// History
			vo.setStatus("UPDATE");
			vo.setRevision_history("Priv Update : ");
			mapper.insert_history(vo);
						
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SYSUserVO list_priv(SYSUserVO vo) throws SiccException {
		try {
			SYSUserDAO mapper = session.getMapper(SYSUserDAO.class);
			SYSToolsDAO mapper_tool = session.getMapper(SYSToolsDAO.class);
			
			if(vo.getPriv_system_cd().equals("")) {
				vo.setPriv_system_cd("ACR");
			} 
			
			// CODE_FIND : SYSTEM_CD
			ToolsVO system = new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM2", "");
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);
			vo.setResult(toolsManager.select(vo_list));
			
			// 접근권한 목록 조회
			vo.setList_priv(mapper.list_priv(vo));
			
			// CODE_FIND : GMS Authority
			ToolsVO vo_tools = new ToolsVO();
			vo_tools.setCode_find("COMMIT_PRIV");
			vo.setList_auth(mapper_tool.tco(vo_tools));
			
			return vo;
			
		} catch(DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch(ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
}
