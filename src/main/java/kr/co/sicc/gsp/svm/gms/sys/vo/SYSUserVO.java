package kr.co.sicc.gsp.svm.gms.sys.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;
import kr.co.sicc.gsp.svm.sicc.util.GMSBindingUtil;
import kr.co.sicc.gsp.svm.sicc.util.GMSStringUtil;

@SuppressWarnings("serial")
public class SYSUserVO extends SiccGenericVO {
	
	private List<Map<String, Object>> list_priv = new ArrayList<Map<String, Object>>();
	private List<Map<String, Object>> list_auth = new ArrayList<Map<String, Object>>();
	private List<Map<String, Object>> list_granted_priv = new ArrayList<Map<String, Object>>();
	
	private String search_system_cd = "";
	private String search_use_yn = "";
	private String search_user_id = "";
	private String search_user_group = "";
	private String search_user_nm = "";
	private String search_order = "";
	private String search_group_system_cd = "";
	private String search_group_id = "";
	
	private String save_tab_cd = "";
	
	private String[] chk = null;
	private String[] hd_user_id = null;
	private String[] hd_user_nm = null;
	private String[] hd_system_cd = null;
	private String[] search_granted_group_id = null;
	private String[] granted_group_id = null;
	private String[] chk_granted_authority = null;
	private String[] chk_group_authority = null;
	
	private String p_user_id = "";
	private String p_system_cd = "";
	private String system_cd = "";
	private String user_id = "";
	private String password = "";
	private String old_password = "";
	private String password_confirm = "";
	private String user_nm = "";
	private String dept_cd = "";
	private String venue_cd = "";
	private String work_area_cd = "";
	private String corps_cd = "";
	private String part_cd = "";
	private String use_yn = "";
	private String change_pwd_yn = "";
	private String login_fail_cnt = "";
	private String user_group = "";
	private String group_id = "";
	private String user_idx1 = "";
	private String user_idx2 = "";
	private String user_idx3 = "";
	private String user_idx4 = "";
	private String user_idx5 = "";
	private String assign_group_id = "";
	private String group_system_cd = "";
	private String priv_system_cd = "";
	private String authority = "";
	private String access_priv = "";
	private String pre_group_id = "";
	private String status = "";
	private String revision_history = "";
	
	// 암호화
	private String newPassword = "";
	private String saltBase64 = "";
	
	public String getSave_tab_cd() {
		return save_tab_cd;
	}
	public void setSave_tab_cd(String save_tab_cd) {
		this.save_tab_cd = save_tab_cd;
	}
	public List<Map<String, Object>> getList_priv() {
		return list_priv;
	}
	public void setList_priv(List<Map<String, Object>> list_priv) {
		this.list_priv = list_priv;
	}
	public List<Map<String, Object>> getList_auth() {
		return list_auth;
	}
	public void setList_auth(List<Map<String, Object>> list_auth) {
		this.list_auth = list_auth;
	}
	public List<Map<String, Object>> getList_granted_priv() {
		return list_granted_priv;
	}
	public void setList_granted_priv(List<Map<String, Object>> list_granted_priv) {
		this.list_granted_priv = list_granted_priv;
	}
	public String getSearch_system_cd() {
		return search_system_cd;
	}
	public void setSearch_system_cd(String search_system_cd) {
		this.search_system_cd = search_system_cd;
	}
	public String getSearch_use_yn() {
		return search_use_yn;
	}
	public void setSearch_use_yn(String search_use_yn) {
		this.search_use_yn = search_use_yn;
	}
	public String getSearch_user_id() {
		return search_user_id;
	}
	public void setSearch_user_id(String search_user_id) {
		this.search_user_id = search_user_id;
	}
	public String getSearch_user_group() {
		return search_user_group;
	}
	public void setSearch_user_group(String search_user_group) {
		this.search_user_group = search_user_group;
	}
	public String getSearch_user_nm() {
		return search_user_nm;
	}
	public void setSearch_user_nm(String search_user_nm) {
		this.search_user_nm = search_user_nm;
	}
	public String getSearch_order() {
		return search_order;
	}
	public void setSearch_order(String search_order) {
		this.search_order = search_order;
	}
	public String getSearch_group_system_cd() {
		return search_group_system_cd;
	}
	public void setSearch_group_system_cd(String search_group_system_cd) {
		this.search_group_system_cd = search_group_system_cd;
	}
	public String getSearch_group_id() {
		return search_group_id;
	}
	public void setSearch_group_id(String search_group_id) {
		this.search_group_id = search_group_id;
	}
	public String[] getHd_user_id() {
		return hd_user_id;
	}
	public void setHd_user_id(String[] hd_user_id) {
		this.hd_user_id = hd_user_id;
	}
	public String[] getHd_user_nm() {
		return hd_user_nm;
	}
	public void setHd_user_nm(String[] hd_user_nm) {
		this.hd_user_nm = hd_user_nm;
	}
	public String[] getHd_system_cd() {
		return hd_system_cd;
	}
	public void setHd_system_cd(String[] hd_system_cd) {
		this.hd_system_cd = hd_system_cd;
	}
	public String[] getSearch_granted_group_id() {
		return search_granted_group_id;
	}
	public void setSearch_granted_group_id(String[] search_granted_group_id) {
		this.search_granted_group_id = search_granted_group_id;
	}
	public String[] getGranted_group_id() {
		return granted_group_id;
	}
	public void setGranted_group_id(String[] granted_group_id) {
		this.granted_group_id = granted_group_id;
	}
	public String[] getChk_granted_authority() {
		return chk_granted_authority;
	}
	public void setChk_granted_authority(String[] chk_granted_authority) {
		this.chk_granted_authority = chk_granted_authority;
	}
	public String[] getChk_group_authority() {
		return chk_group_authority;
	}
	public void setChk_group_authority(String[] chk_group_authority) {
		this.chk_group_authority = chk_group_authority;
	}
	public String getP_user_id() {
		return p_user_id;
	}
	public void setP_user_id(String p_user_id) {
		this.p_user_id = p_user_id;
	}
	public String getSystem_cd() {
		return system_cd;
	}
	public void setSystem_cd(String system_cd) {
		this.system_cd = system_cd;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getPassword_confirm() {
		return password_confirm;
	}
	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getVenue_cd() {
		return venue_cd;
	}
	public void setVenue_cd(String venue_cd) {
		this.venue_cd = venue_cd;
	}
	public String getWork_area_cd() {
		return work_area_cd;
	}
	public void setWork_area_cd(String work_area_cd) {
		this.work_area_cd = work_area_cd;
	}
	public String getCorps_cd() {
		return corps_cd;
	}
	public void setCorps_cd(String corps_cd) {
		this.corps_cd = corps_cd;
	}
	public String getPart_cd() {
		return part_cd;
	}
	public void setPart_cd(String part_cd) {
		this.part_cd = part_cd;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getChange_pwd_yn() {
		return change_pwd_yn;
	}
	public void setChange_pwd_yn(String change_pwd_yn) {
		this.change_pwd_yn = change_pwd_yn;
	}
	public String getLogin_fail_cnt() {
		return login_fail_cnt;
	}
	public void setLogin_fail_cnt(String login_fail_cnt) {
		this.login_fail_cnt = login_fail_cnt;
	}
	public String getUser_group() {
		return user_group;
	}
	public void setUser_group(String user_group) {
		this.user_group = user_group;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getUser_idx1() {
		return user_idx1;
	}
	public void setUser_idx1(String user_idx1) {
		this.user_idx1 = user_idx1;
	}
	public String getUser_idx2() {
		return user_idx2;
	}
	public void setUser_idx2(String user_idx2) {
		this.user_idx2 = user_idx2;
	}
	public String getUser_idx3() {
		return user_idx3;
	}
	public void setUser_idx3(String user_idx3) {
		this.user_idx3 = user_idx3;
	}
	public String getUser_idx4() {
		return user_idx4;
	}
	public void setUser_idx4(String user_idx4) {
		this.user_idx4 = user_idx4;
	}
	public String getUser_idx5() {
		return user_idx5;
	}
	public void setUser_idx5(String user_idx5) {
		this.user_idx5 = user_idx5;
	}
	public String getAssign_group_id() {
		return assign_group_id;
	}
	public void setAssign_group_id(String assign_group_id) {
		this.assign_group_id = assign_group_id;
	}
	public String getGroup_system_cd() {
		return group_system_cd;
	}
	public void setGroup_system_cd(String group_system_cd) {
		this.group_system_cd = group_system_cd;
	}
	public String getPriv_system_cd() {
		return priv_system_cd;
	}
	public void setPriv_system_cd(String priv_system_cd) {
		this.priv_system_cd = priv_system_cd;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getAccess_priv() {
		return access_priv;
	}
	public void setAccess_priv(String access_priv) {
		this.access_priv = access_priv;
	}
	public String getPre_group_id() {
		return pre_group_id;
	}
	public void setPre_group_id(String pre_group_id) {
		this.pre_group_id = pre_group_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRevision_history() {
		return revision_history;
	}
	public void setRevision_history(String revision_history) {
		this.revision_history = revision_history;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getSaltBase64() {
		return saltBase64;
	}
	public void setSaltBase64(String saltBase64) {
		this.saltBase64 = saltBase64;
	}
	public String[] getChk() {
		return chk;
	}
	public void setChk(String[] chk) {
		this.chk = chk;
	}
	public String getP_system_cd() {
		return p_system_cd;
	}
	public void setP_system_cd(String p_system_cd) {
		this.p_system_cd = p_system_cd;
	}
	
}
