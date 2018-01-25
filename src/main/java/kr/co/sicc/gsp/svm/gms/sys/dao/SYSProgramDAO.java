package kr.co.sicc.gsp.svm.gms.sys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.sicc.gsp.svm.gms.sys.vo.SYSProgramVO;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

@Repository
public interface SYSProgramDAO {
	/**
	 * 목록 조회
	 *
	 * @Version : 1.0
	 * @Method list
	 * @param vo
	 * @return
	 */
	public List<Map<String, Object>> list(SYSProgramVO vo);
		
	/**
	 * menu_lvl 0 삭제
	 *
	 * @Version : 1.0
	 * @Method delete_0
	 * @param vo
	 */
	public void delete_0(SYSProgramVO vo);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method delete
	 * @param vo
	 */
	public void delete(SYSProgramVO vo);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method edit
	 * @param menu_id
	 * @return
	 */
	public Map<String, Object> edit(String menu_id);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method update
	 * @param vo
	 * @return
	 * @throws SiccException
	 */
	public int update(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void insert(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void delete_granted_group(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void delete_attached_group_lv0(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method insert
	 * @param vo
	 * @throws SiccException
	 */
	public void insert_granted_group(SYSProgramVO vo) throws SiccException;

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method update_order_0
	 * @param i
	 * @param system_cd
	 * @param object
	 */
	public void update_order_0(int i, String menu_id, String system_cd);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method update_order_1
	 * @param i
	 * @param system_cd
	 * @param object
	 */
	public void update_order_1(int i, String menu_id);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method update_order_0_main
	 * @param system_cd
	 */
	public void update_order_0_main(String system_cd);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method insert_menu_id
	 * @param vo
	 * @return
	 */
	public String insert_menu_id(SYSProgramVO vo);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method check_duplication_control
	 * @param vo
	 * @return
	 */
	public int check_duplication_control(SYSProgramVO vo);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method check_duplication
	 * @param vo
	 * @return
	 */
	public int check_duplication(SYSProgramVO vo);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method check_lang
	 * @param vo
	 * @return
	 */
	public int check_lang(SYSProgramVO vo);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method langlist
	 * @param vo
	 * @return
	 */
	public List<Map<String, Object>> langlist(SYSProgramVO vo);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method lang_insert
	 * @param vo
	 * @throws SiccException
	 */
	public void lang_insert(SYSProgramVO vo) throws SiccException;
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method lang_delete
	 * @param menu_id
	 * @param menu_lang
	 * @return
	 */
	public int lang_delete(String menu_id, String menu_lang);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method lang_update
	 * @param vo
	 * @return
	 */
	public int lang_update(SYSProgramVO vo);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method en_insert
	 * @param vo
	 * @throws SiccException
	 */
	public void en_insert(SYSProgramVO vo) throws SiccException;

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method en_update
	 * @param vo
	 * @return
	 */
	public int en_update(SYSProgramVO vo);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method check_en_language
	 * @param vo
	 * @return
	 */
	public int check_en_language(SYSProgramVO vo);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method check_duplication_language
	 * @param vo
	 * @return
	 */
	public int check_duplication_language(SYSProgramVO vo);
	
	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method delete_list
	 * @param vo
	 * @return
	 */
	public List<String> delete_list(SYSProgramVO vo);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method delete_lang
	 * @param vo
	 */
	public void delete_lang(SYSProgramVO vo);

	/**
	 * Description 
	 *
	 * @Version : 1.0
	 * @Method delete_lang_0
	 * @param string
	 */
	public void delete_lang_0(String string);
}
