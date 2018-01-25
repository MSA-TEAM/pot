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
import kr.co.sicc.gsp.svm.gms.sys.dao.SYSGroupDAO;
import kr.co.sicc.gsp.svm.gms.sys.service.SYSGroupService;
import kr.co.sicc.gsp.svm.gms.sys.vo.SYSGroupVO;
import kr.co.sicc.gsp.svm.sicc.common.SiccMessageUtil;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;
import kr.co.sicc.gsp.svm.sicc.tools.SiccToolsManager;
import kr.co.sicc.gsp.svm.sicc.util.SiccBeanUtils;
import kr.co.sicc.gsp.svm.sicc.util.SiccUserUtil;

@Service
public class SYSGroupServiceImpl implements SYSGroupService {

	@Autowired
	@Resource(name = "sqlSession")
	SqlSession session;
	
	@Autowired
	SiccToolsManager toolsManager;

	@Override
	public SYSGroupVO list_view(SYSGroupVO vo) throws SiccException {
		try {
			ToolsVO system = new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM1", "");
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);

			vo.setResult(toolsManager.select(vo_list));

			return vo;
		} catch (DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SYSGroupVO list(SYSGroupVO vo) throws SiccException {
		try {
			SYSGroupDAO mapper = session.getMapper(SYSGroupDAO.class);
			
			vo.pageInit();
			vo.setList(mapper.list(vo));
			vo.setTotal_cnt(mapper.total_cnt(vo));
			
			ToolsVO system = new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM1", "");
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);

			vo.setResult(toolsManager.select(vo_list));

			return vo;
		} catch (DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
	
	@Override
	public SYSGroupVO input(SYSGroupVO vo) throws SiccException {
		try {
			ToolsVO system = new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM1", "");
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);

			vo.setResult(toolsManager.select(vo_list));

			return vo;
		} catch (DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public int delete(SYSGroupVO vo) throws SiccException {
		try {
			SYSGroupDAO mapper = session.getMapper(SYSGroupDAO.class);

			SiccUserUtil.setDefaultUserInfo(vo);

			String[] groupId = (String[]) vo.getHd_group_id(); // Ȯ���غ���

			int cnt = 0;

			for (int i = 0; i < groupId.length; i++) {
				if(mapper.check_use_group(groupId[i]) > 0){
					throw SiccMessageUtil.getError("db.sql.used_code");
				}
				cnt += mapper.delete(groupId[i]);
			}

			return cnt;
		} catch (DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}

	}

	@Override
	public SYSGroupVO edit(SYSGroupVO vo) throws SiccException {
		try {
			SYSGroupDAO mapper = session.getMapper(SYSGroupDAO.class);
			Map<String, Object> resultMap = mapper.edit(vo);
			
			SiccBeanUtils.populate(vo, resultMap);
			
			ToolsVO system = new ToolsVO("SYS", "SYSTEM_CD", "CODE_NM1", "");
			List<ToolsVO> vo_list = new ArrayList<ToolsVO>();
			vo_list.add(system);

			vo.setResult(toolsManager.select(vo_list));

			return vo;
		} catch (DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void update(SYSGroupVO vo) throws SiccException {
		try {
			SYSGroupDAO mapper = session.getMapper(SYSGroupDAO.class);

			SiccUserUtil.setDefaultUserInfo(vo);
			
			mapper.update(vo);
			
			vo.setP_group_id(vo.getGroup_id());
		
		} catch (DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}

	@Override
	@Transactional
	public void insert(SYSGroupVO vo) throws SiccException {
		try {
			SYSGroupDAO mapper = session.getMapper(SYSGroupDAO.class);

			SiccUserUtil.setDefaultUserInfo(vo);


			String cnt = mapper.check_duplication(vo.getGroup_id());
			
			if (cnt.equals("0")) {
				mapper.insert(vo);
				vo.setP_group_id(vo.getGroup_id());
			} else
			{
				throw SiccMessageUtil.getError("db.sql.insert_fail");
			}

		} catch (DataAccessException e) {
			throw SiccMessageUtil.getError(e);
		} catch (ClassCastException e) {
			throw SiccMessageUtil.getError(e);
		}
	}
}
