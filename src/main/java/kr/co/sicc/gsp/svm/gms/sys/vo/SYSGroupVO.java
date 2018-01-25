package kr.co.sicc.gsp.svm.gms.sys.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

@SuppressWarnings("serial")
public class SYSGroupVO extends SiccGenericVO{
	
	private List<Map<String, Object>> editlist = new ArrayList<Map<String, Object>>();
	private List<Map<String, Object>> inputlist = new ArrayList<Map<String, Object>>();
	
	
	public List<Map<String, Object>> getInputlist() {
		return inputlist;
	}
	public void setInputlist(List<Map<String, Object>> inputlist) {
		this.inputlist = inputlist;
	}
	private String search_system_cd = "";
	private String search_priv_system_cd = "";
	private String search_group_id = "";
	private String search_group_nm = "";
	public String getP_group_id() {
		return p_group_id;
	}
	public void setP_group_id(String p_group_id) {
		this.p_group_id = p_group_id;
	}
	private String search_dept_nm = "";
	private String pageno="";
	private String p_search_system_cd="";
	private String p2_search_system_cd="";
	private String p_search_group_id="";
	private String p1_search_group_id="";
	private String p2_search_group_id="";
	public String getP_search_group_id() {
		return p_search_group_id;
	}
	public void setP_search_group_id(String p_search_group_id) {
		this.p_search_group_id = p_search_group_id;
	}
	public String getP1_search_group_id() {
		return p1_search_group_id;
	}
	public void setP1_search_group_id(String p1_search_group_id) {
		this.p1_search_group_id = p1_search_group_id;
	}
	private String p1_search_system_cd="";
	
	public String getP2_search_system_cd() {
		return p2_search_system_cd;
	}
	public String getP1_search_system_cd() {
		return p1_search_system_cd;
	}
	public String getP2_search_group_id() {
		return p2_search_group_id;
	}
	public void setP2_search_group_id(String p2_search_group_id) {
		this.p2_search_group_id = p2_search_group_id;
	}
	public void setP1_search_system_cd(String p1_search_system_cd) {
		this.p1_search_system_cd = p1_search_system_cd;
	}
	public void setP2_search_system_cd(String p2_search_system_cd) {
		this.p2_search_system_cd = p2_search_system_cd;
	}
	private String p_group_id="";
	private String search_order = "";
	private String group_id_prefix = null;
	private String group_id = null;

	private String group_nm = null;
	private String dept_nm = null;
	private String search_system_no = "";
	private String search_access_nm = "";
	private String edittotal_cnt = "";
	private String inputtotal_cnt = "";
	
	public String getInputtotal_cnt() {
		return inputtotal_cnt;
	}
	public void setInputtotal_cnt(String inputtotal_cnt) {
		this.inputtotal_cnt = inputtotal_cnt;
	}
	private String[] chk = null;
	private String[] chk_granted_id = null;
    private String[] chk_group_id = null;
    public String[] getChk_granted_id() {
		return chk_granted_id;
	}
	public void setChk_granted_id(String[] chk_granted_id) {
		this.chk_granted_id = chk_granted_id;
	}
	private String[] granted_system_cd = null;
    private String[] granted_access_priv = null;
    private String[] granted_authority = null;
    private String[] group_system_cd = null;
    private String group_access_priv = null;
    private String group_authority = null;
    private String[] p_group_authority = null;
	private String[] hd_system_cd = null;
	private String[] hd_group_id = null;
	
	
    
    private List group_list = null;
    private List granted_privilege_list = new ArrayList();
    private List group_privilege_list = new ArrayList();
 
	public String getP_search_system_cd() {
		return p_search_system_cd;
	}
	public void setP_search_system_cd(String p_search_system_cd) {
		this.p_search_system_cd = p_search_system_cd;
	}
	
	public String[] getP_group_authority() {
		return p_group_authority;
	}
	public void setP_group_authority(String[] p_group_authority) {
		this.p_group_authority = p_group_authority;
	}
	
    
    public String getSearch_system_no() {
		return search_system_no;
	}
	public void setSearch_system_no(String search_system_no) {
		this.search_system_no = search_system_no;
	}
	public String getSearch_access_nm() {
		return search_access_nm;
	}
	public void setSearch_access_nm(String search_access_nm) {
		this.search_access_nm = search_access_nm;
	}
	public String getSearch_commit_priv() {
		return search_commit_priv;
	}
	public void setSearch_commit_priv(String search_commit_priv) {
		this.search_commit_priv = search_commit_priv;
	}
	private String search_commit_priv = "";
    
    
	public String getSearch_system_cd() {
		return search_system_cd;
	}
	public void setSearch_system_cd(String search_system_cd) {
		this.search_system_cd = search_system_cd;
	}
	public String getSearch_priv_system_cd() {
		return search_priv_system_cd;
	}
	public void setSearch_priv_system_cd(String search_priv_system_cd) {
		this.search_priv_system_cd = search_priv_system_cd;
	}
	public String getSearch_group_id() {
		return search_group_id;
	}
	public void setSearch_group_id(String search_group_id) {
		this.search_group_id = search_group_id;
	}
	public String getSearch_group_nm() {
		return search_group_nm;
	}
	public void setSearch_group_nm(String search_group_nm) {
		this.search_group_nm = search_group_nm;
	}
	public String getSearch_dept_nm() {
		return search_dept_nm;
	}
	public void setSearch_dept_nm(String search_dept_nm) {
		this.search_dept_nm = search_dept_nm;
	}
	public String getSearch_order() {
		return search_order;
	}
	public void setSearch_order(String search_order) {
		this.search_order = search_order;
	}
	public String[] getChk() {
		return chk;
	}
	public void setChk(String[] chk) {
		this.chk = chk;
	}
	public String[] getChk_group_id() {
		return chk_group_id;
	}
	public void setChk_group_id(String[] chk_group_id) {
		this.chk_group_id = chk_group_id;
	}
	public String[] getGranted_system_cd() {
		return granted_system_cd;
	}
	public void setGranted_system_cd(String[] granted_system_cd) {
		this.granted_system_cd = granted_system_cd;
	}
	public String[] getGranted_access_priv() {
		return granted_access_priv;
	}
	public void setGranted_access_priv(String[] granted_access_priv) {
		this.granted_access_priv = granted_access_priv;
	}
	public String[] getGranted_authority() {
		return granted_authority;
	}
	public void setGranted_authority(String[] granted_authority) {
		this.granted_authority = granted_authority;
	}
	public String[] getGroup_system_cd() {
		return group_system_cd;
	}
	public void setGroup_system_cd(String[] group_system_cd) {
		this.group_system_cd = group_system_cd;
	}
	public String getGroup_access_priv() {
		return group_access_priv;
	}
	public void setGroup_access_priv(String group_access_priv) {
		this.group_access_priv = group_access_priv;
	}
	public String getGroup_authority() {
		return group_authority;
	}
	public void setGroup_authority(String group_authority) {
		this.group_authority = group_authority;
	}
	public List getGroup_list() {
		return group_list;
	}
	public void setGroup_list(List group_list) {
		this.group_list = group_list;
	}
	public List getGranted_privilege_list() {
		return granted_privilege_list;
	}
	public void setGranted_privilege_list(List granted_privilege_list) {
		this.granted_privilege_list = granted_privilege_list;
	}
	public List getGroup_privilege_list() {
		return group_privilege_list;
	}
	public void setGroup_privilege_list(List group_privilege_list) {
		this.group_privilege_list = group_privilege_list;
	}
	public String getSystem_cd() {
		return system_cd;
	}
	public void setSystem_cd(String system_cd) {
		this.system_cd = system_cd;
	}
	public String getGroup_id_prefix() {
		return group_id_prefix;
	}
	public void setGroup_id_prefix(String group_id_prefix) {
		this.group_id_prefix = group_id_prefix;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getGroup_nm() {
		return group_nm;
	}
	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getPageno() {
		return pageno;
	}
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}
	public String[] getHd_system_cd() {
		return hd_system_cd;
	}
	public void setHd_system_cd(String[] hd_search_system_cd) {
		this.hd_system_cd = hd_search_system_cd;
	}
	public String[] getHd_group_id() {
		return hd_group_id;
	}
	public void setHd_group_id(String[] hd_search_group_id) {
		this.hd_group_id = hd_search_group_id;
	}
	
	public List<Map<String, Object>> getEditlist() {
		return editlist;
	}
	public void setEditlist(List<Map<String, Object>> editlist) {
		this.editlist = editlist;
	}

	public String getEdittotal_cnt() {
		return edittotal_cnt;
	}
	public void setEdittotal_cnt(String edittotal_cnt) {
		this.edittotal_cnt = edittotal_cnt;
	}
}
