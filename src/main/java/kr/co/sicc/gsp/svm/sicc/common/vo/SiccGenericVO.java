package kr.co.sicc.gsp.svm.sicc.common.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public abstract class SiccGenericVO implements BaseVO{
	protected List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
	protected String cp_cd = "";
	protected String system_cp_cd = "";
	protected String user_cp_cd = "";
	protected String lang = "";
	protected String system_cd = "";
	protected boolean success = true;
	protected String msg = "";
	protected String msgShowType = "";
	protected String errType = "";
	
	protected String result = "";
	
	private transient PageVO pageVo = new PageVO();
	
	protected transient int page = 0;
	protected transient int page_st = 0;
	protected transient int page_ed = 0;
	
	protected transient String username = "";
	protected transient String user_ip = "";
	protected transient String user_group_id = "";
	
	protected transient String control_id = "";
	protected transient String control_kind = "";
	protected transient String cmd = "";
	
	protected transient String url = "";
	protected transient String error_url = "";

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getSystem_cd() {
		return system_cd;
	}

	public void setSystem_cd(String system_cd) {
		this.system_cd = system_cd;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgShowType() {
		return msgShowType;
	}

	public void setMsgShowType(String msgShowType) {
		this.msgShowType = msgShowType;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUser_ip() {
		return user_ip;
	}


	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	
	public String getUser_group_id() {
		return user_group_id;
	}

	public void setUser_group_id(String user_group_id) {
		this.user_group_id = user_group_id;
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

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	public void pageInit(){
		this.setPage_st(((pageVo.getPage()-1) * pageVo.getLimit()) + 1);
		this.setPage_ed((pageVo.getPage() * pageVo.getLimit()) + 1);
	}

	public int getPage_st() {
		return page_st;
	}

	public void setPage_st(int page_st) {
		this.page_st = page_st;
	}

	public int getPage_ed() {
		return page_ed;
	}

	public void setPage_ed(int page_ed) {
		this.page_ed = page_ed;
	}

	public String getErrType() {
		return errType;
	}

	public void setErrType(String errType) {
		this.errType = errType;
	}

	public String getCp_cd() {
		return cp_cd;
	}

	public void setCp_cd(String cp_cd) {
		this.cp_cd = cp_cd;
	}
	
	public String getSystem_cp_cd() {
		return system_cp_cd;
	}

	public void setSystem_cp_cd(String system_cp_cd) {
		this.system_cp_cd = system_cp_cd;
	}

	public String getUser_cp_cd() {
		return user_cp_cd;
	}

	public void setUser_cp_cd(String user_cp_cd) {
		this.user_cp_cd = user_cp_cd;
	}

	public String getError_url() {
		return error_url;
	}

	public void setError_url(String error_url) {
		this.error_url = error_url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setForwardUrl(String url){
		this.url = url;
		this.error_url = url;
	}
	
	public void setForwardUrl(String url, String error_url){
		this.url = url;
		this.error_url = error_url;
	}
	
	public void setRedirectUrl(String url, String error_url, String lang){
		this.url = "redirect:/"+lang+url;
		
		this.error_url = "redirect:/"+lang+error_url;
	}
	public void setRedirectUrl(String url, String lang){
		this.url = "redirect:/"+lang+url;
		this.error_url = "redirect:/"+lang+url;
	}
	
	public String getUrl(){
		return this.url;			
	}
	
	public String getErrorUrl(){
		return this.error_url;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	public int getInterval() {
		return pageVo.getInterval();
	}

	public void setInterval(int interval) {
		pageVo.setInterval(interval);
	}
	
	public int getTotal_cnt() {
		return pageVo.getTotal_cnt();
	}

	public void setTotal_cnt(int total_cnt) {
		pageVo.setTotal_cnt(total_cnt);
	}
	
	public int getLimit() {
		return pageVo.getLimit();
	}

	public void setLimit(int limit) {
		pageVo.setLimit(limit);
	}

	public int getPage() {
		return pageVo.getPage();
	}

	public void setPage(int page) {
		pageVo.setPage(page);
	}
	
	public PageVO getPageVo(){
		return pageVo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
