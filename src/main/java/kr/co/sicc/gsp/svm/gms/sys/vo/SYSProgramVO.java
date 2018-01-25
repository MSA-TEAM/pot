package kr.co.sicc.gsp.svm.gms.sys.vo;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

@SuppressWarnings("serial")
public class SYSProgramVO extends SiccGenericVO{
	
	private String[] menu_ord_list = null;
	
	private String[] hd_order_list = null;
	private String[] hd_granted_group_id = null;
	
	private String p_menu_id = "";
	private String p_menu_lvl = "";
	private String p_menu_ord = "";
	private String p_menu_lang = "";
	private String menu_lang = "";
	private String system_cd = "";
	private String menu_lvl = "";
	private String menu_nm = "";
	private String menu_nm1 = "";
	private String access_priv = "";
	private String control_id = "";
	private String control_kind = "";
	private String control_url = "";
	private String use_yn = "";
	private String popup_yn = "";
	private String disable_yn = "";
	private String menu_id = "";
	private String sub_ord = "";
	private String menu_nm2 = "";
	private String menu_ord = "";
	private String group_id = "";
	private String granted_group_id = "";
	private String group_system_cd = "";
	private String search_system_cd = "";
	private String search_accesspriv_cd = "";
	
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getGranted_group_id() {
		return granted_group_id;
	}
	public void setGranted_group_id(String granted_group_id) {
		this.granted_group_id = granted_group_id;
	}
	public String getGroup_system_cd() {
		return group_system_cd;
	}
	public void setGroup_system_cd(String group_system_cd) {
		this.group_system_cd = group_system_cd;
	}
	public String[] getMenu_ord_list() {
		return menu_ord_list;
	}
	public void setMenu_ord_list(String[] menu_ord_list) {
		this.menu_ord_list = menu_ord_list;
	}
	public String getP_menu_id() {
		return p_menu_id;
	}
	public void setP_menu_id(String p_menu_id) {
		this.p_menu_id = p_menu_id;
	}
	public String getP_menu_lvl() {
		return p_menu_lvl;
	}
	public void setP_menu_lvl(String p_menu_lvl) {
		this.p_menu_lvl = p_menu_lvl;
	}
	public String getSystem_cd() {
		return system_cd;
	}
	public void setSystem_cd(String system_cd) {
		this.system_cd = system_cd;
	}
	public String getMenu_lvl() {
		return menu_lvl;
	}
	public void setMenu_lvl(String menu_lvl) {
		this.menu_lvl = menu_lvl;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getMenu_nm1() {
		return menu_nm1;
	}
	public void setMenu_nm1(String menu_nm1) {
		this.menu_nm1 = menu_nm1;
	}
	public String getAccess_priv() {
		return access_priv;
	}
	public void setAccess_priv(String access_priv) {
		this.access_priv = access_priv;
	}
	public String getControl_id() {
		return control_id;
	}
	public void setControl_id(String control_id) {
		this.control_id = control_id;
	}
	public String getControl_kind() {
		return control_kind;
	}
	public void setControl_kind(String control_kind) {
		this.control_kind = control_kind;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getSub_ord() {
		return sub_ord;
	}
	public void setSub_ord(String sub_ord) {
		this.sub_ord = sub_ord;
	}
	public String getMenu_nm2() {
		return menu_nm2;
	}
	public void setMenu_nm2(String menu_nm2) {
		this.menu_nm2 = menu_nm2;
	}
	public String getMenu_ord() {
		return menu_ord;
	}
	public void setMenu_ord(String menu_ord) {
		this.menu_ord = menu_ord;
	}
	public String getSearch_system_cd() {
		return search_system_cd;
	}
	public void setSearch_system_cd(String search_system_cd) {
		this.search_system_cd = search_system_cd;
	}
	public String getSearch_accesspriv_cd() {
		return search_accesspriv_cd;
	}
	public void setSearch_accesspriv_cd(String search_accesspriv_cd) {
		this.search_accesspriv_cd = search_accesspriv_cd;
	}
	public String getControl_url() {
		return control_url;
	}
	public void setControl_url(String control_url) {
		this.control_url = control_url;
	}
	public String getP_menu_ord() {
		return p_menu_ord;
	}
	public void setP_menu_ord(String p_menu_ord) {
		this.p_menu_ord = p_menu_ord;
	}
	public String[] getHd_order_list() {
		return hd_order_list;
	}
	public void setHd_order_list(String[] hd_order_list) {
		this.hd_order_list = hd_order_list;
	}
	public String[] getHd_granted_group_id() {
		return hd_granted_group_id;
	}
	public void setHd_granted_group_id(String[] hd_granted_group_id) {
		this.hd_granted_group_id = hd_granted_group_id;
	}
	public String getP_menu_lang() {
		return p_menu_lang;
	}
	public void setP_menu_lang(String p_menu_lang) {
		this.p_menu_lang = p_menu_lang;
	}
	public String getMenu_lang() {
		return menu_lang;
	}
	public void setMenu_lang(String menu_lang) {
		this.menu_lang = menu_lang;
	}
	public String getPopup_yn() {
		return popup_yn;
	}
	public void setPopup_yn(String popup_yn) {
		this.popup_yn = popup_yn;
	}
	public String getDisable_yn() {
		return disable_yn;
	}
	public void setDisable_yn(String disable_yn) {
		this.disable_yn = disable_yn;
	}

}
