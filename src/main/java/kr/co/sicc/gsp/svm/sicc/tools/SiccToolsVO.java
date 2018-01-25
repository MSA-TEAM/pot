package kr.co.sicc.gsp.svm.sicc.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.sicc.gsp.svm.sicc.common.vo.BaseVO;

@SuppressWarnings("serial")
public abstract class SiccToolsVO implements BaseVO{
	protected String cp_cd = "";
	protected List<Map<String, String>> condition = new ArrayList<>();
	
	protected String result = "";
	protected String code_find = "";
	protected String order = "";
	protected String etcCond = "";
	protected String etc_cond1 = "";
	protected String etc_cond2 = "";
	protected String etc_cond3 = "";
	protected String etc_cond4 = "";
	protected String etc_cond5 = "";
	protected String etc_cond6 = "";
    
	protected String code_idx1 = "";
	protected String code_idx2 = "";
	protected String code_idx3 = "";
	protected String code_idx4 = "";
	protected String code_idx5 = "";
    
	protected String lang = "";
	protected String system_cd = "";
	protected boolean success = true;
	protected String msg = "";
	protected String msgShowType = "";
	protected String ad_no = "";

	public SiccToolsVO(){}
    
	public SiccToolsVO(String system_cd){
    	this.system_cd = system_cd;
    }
	
	public SiccToolsVO(String system_cd, String order){
    	this.system_cd = system_cd;
    	this.order = order;
    }
	
	public SiccToolsVO(String system_cd, String code_find, String order){
    	this.system_cd = system_cd;
    	this.code_find = code_find;
    	this.order = order;
    }
	
	public SiccToolsVO(String system_cd, String code_find, String order, String ... etc_cond){
    	this.system_cd = system_cd;
    	this.code_find = code_find;
    	this.order = order;
    	
    	for(int i = 0 ; i < etc_cond.length ; i++){
    		if(i == 0){
    			this.etc_cond1 = etc_cond[i];
    		}else if(i == 1){
    			this.etc_cond2 = etc_cond[i];
    		}else if(i == 2){
    			this.etc_cond3 = etc_cond[i];
    		}else if(i == 3){
    			this.etc_cond4 = etc_cond[i];
    		}else if(i == 4){
    			this.etc_cond5 = etc_cond[i];
    		}else if(i == 5){
    			this.etc_cond6 = etc_cond[i];
    		}else {
    			break;
    		}
    	}
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

	public String getCode_find() {
		return code_find;
	}
	public void setCode_find(String code_find) {
		this.code_find = code_find;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	public String getEtc_cond1() {
		return etc_cond1;
	}

	public void setEtc_cond1(String etc_cond1) {
		this.etc_cond1 = etc_cond1;
	}

	public String getEtc_cond2() {
		return etc_cond2;
	}

	public void setEtc_cond2(String etc_cond2) {
		this.etc_cond2 = etc_cond2;
	}

	public String getEtc_cond3() {
		return etc_cond3;
	}

	public void setEtc_cond3(String etc_cond3) {
		this.etc_cond3 = etc_cond3;
	}

	public String getEtc_cond4() {
		return etc_cond4;
	}

	public void setEtc_cond4(String etc_cond4) {
		this.etc_cond4 = etc_cond4;
	}

	public String getEtc_cond5() {
		return etc_cond5;
	}

	public void setEtc_cond5(String etc_cond5) {
		this.etc_cond5 = etc_cond5;
	}

	public String getEtc_cond6() {
		return etc_cond6;
	}

	public void setEtc_cond6(String etc_cond6) {
		this.etc_cond6 = etc_cond6;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String getCode_idx1() {
		return code_idx1;
	}

	public void setCode_idx1(String code_idx1) {
		this.code_idx1 = code_idx1;
	}

	public String getCode_idx2() {
		return code_idx2;
	}

	public void setCode_idx2(String code_idx2) {
		this.code_idx2 = code_idx2;
	}

	public String getCode_idx3() {
		return code_idx3;
	}

	public void setCode_idx3(String code_idx3) {
		this.code_idx3 = code_idx3;
	}

	public String getCode_idx4() {
		return code_idx4;
	}

	public void setCode_idx4(String code_idx4) {
		this.code_idx4 = code_idx4;
	}

	public String getCode_idx5() {
		return code_idx5;
	}

	public void setCode_idx5(String code_idx5) {
		this.code_idx5 = code_idx5;
	}
	
	public String getCp_cd() {
		return cp_cd;
	}

	public void setCp_cd(String cp_cd) {
		this.cp_cd = cp_cd;
	}

	public List<Map<String, String>> getCondition() {
		return condition;
	}

	public void setCondition(List<Map<String, String>> condition) {
		this.condition = condition;
	}

	public String getSystem_cd() {
		return system_cd;
	}

	public void setSystem_cd(String system_cd) {
		this.system_cd = system_cd;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getMsgShowType() {
		return msgShowType;
	}

	public void setMsgShowType(String msgShowType) {
		this.msgShowType = msgShowType;
	}

	public String getEtcCond() {
		return etcCond;
	}

	public void setEtcCond(String etcCond) {
		this.etcCond = etcCond;
	}
	
	public String getAd_no() {
		return ad_no;
	}

	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}

	
}
