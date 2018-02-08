package kr.co.sicc.gsp.svm.gms.common.interceptor;

import kr.co.sicc.gsp.svm.sicc.common.vo.BaseVO;

/**
 * <pre>
 * com.gms.svm.dao
 * BasicInfoDAO.java
 * Description : Tenant 관련 정보들 
 *
 * History     :
 * </pre>
 *
 * @author         : pmj
 * @Date         : 2018. 02. 02.
 * @Version : 1.0
 *
 */

@SuppressWarnings("serial")
public class BasicInfo implements BaseVO {

	String tenant_id; 
	String cp_cd;         
	String cp_nm;        
	String file_path_nm;  
	String img_file_nm; 
	String service_url_addr;
	String service_cd;
	String service_start_dt;
	String service_end_dt;
	
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getCp_cd() {
		return cp_cd;
	}
	public void setCp_cd(String cp_cd) {
		this.cp_cd = cp_cd;
	}
	public String getCp_nm() {
		return cp_nm;
	}
	public void setCp_nm(String cp_nm) {
		this.cp_nm = cp_nm;
	}
	public String getFile_path_nm() {
		return file_path_nm;
	}
	public void setFile_path_nm(String file_path_nm) {
		this.file_path_nm = file_path_nm;
	}
	public String getImg_file_nm() {
		return img_file_nm;
	}
	public void setImg_file_nm(String img_file_nm) {
		this.img_file_nm = img_file_nm;
	}
	public String getService_url_addr() {
		return service_url_addr;
	}
	public void setService_url_addr(String service_url_addr) {
		this.service_url_addr = service_url_addr;
	}
	public String getService_cd() {
		return service_cd;
	}
	public void setService_cd(String service_cd) {
		this.service_cd = service_cd;
	}
	public String getService_start_dt() {
		return service_start_dt;
	}
	public void setService_start_dt(String service_start_dt) {
		this.service_start_dt = service_start_dt;
	}
	public String getService_end_dt() {
		return service_end_dt;
	}
	public void setService_end_dt(String service_end_dt) {
		this.service_end_dt = service_end_dt;
	}  
	
    
}
