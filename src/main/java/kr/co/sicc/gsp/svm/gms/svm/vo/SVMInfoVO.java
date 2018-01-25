package kr.co.sicc.gsp.svm.gms.svm.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

/**
 * <pre>	
 * com.gms.svm.vo
 * SVMInfoVO.java
 * Description 	:
 * ???öå ?ûê?õêÎ¥âÏÇ¨ Ïß??õê?Ñú VO
 * History     	:
 * </pre>
 *
 * @author	 	: gypark
 * @Date	 	: 2017.08.16
 * @Version 	: 1.0
 *
 */

@SuppressWarnings("serial")
public class SVMInfoVO extends SiccGenericVO {
	private String ad_no = "";
	private String area = "";
	private String info_seq = "";
	private String use_yn = "";
	private String level_cd = "";
	private String level_nm = "";
	private String name_txt = "";
	private String name_cd = "";
	private String name_nm = "";
	private String duration = "";
	private String description = "";
	private String check_cd = "";
	private String check_nm = "";
	private String certi_nm = "";
	private String skill_cd = "";
	private String skill_nm = "";
	private String certi_fg = "";
	private String assign_group_id = "";
	private List<MultipartFile> skillPhoto = new ArrayList<>();
	
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public List<MultipartFile> getSkillPhoto() {
		return skillPhoto;
	}
	public void setSkillPhoto(List<MultipartFile> skillPhoto) {
		this.skillPhoto = skillPhoto;
	}
	public String getCerti_fg() {
		return certi_fg;
	}
	public void setCerti_fg(String certi_fg) {
		this.certi_fg = certi_fg;
	}
	public String getName_nm() {
		return name_nm;
	}
	public void setName_nm(String name_nm) {
		this.name_nm = name_nm;
	}
	public String getLevel_nm() {
		return level_nm;
	}
	public void setLevel_nm(String level_nm) {
		this.level_nm = level_nm;
	}
	public String getSkill_nm() {
		return skill_nm;
	}
	public void setSkill_nm(String skill_nm) {
		this.skill_nm = skill_nm;
	}
	public String getCheck_nm() {
		return check_nm;
	}
	public void setCheck_nm(String check_nm) {
		this.check_nm = check_nm;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getInfo_seq() {
		return info_seq;
	}
	public void setInfo_seq(String info_seq) {
		this.info_seq = info_seq;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getLevel_cd() {
		return level_cd;
	}
	public void setLevel_cd(String level_cd) {
		this.level_cd = level_cd;
	}
	public String getName_txt() {
		return name_txt;
	}
	public void setName_txt(String name_txt) {
		this.name_txt = name_txt;
	}
	public String getName_cd() {
		return name_cd;
	}
	public void setName_cd(String name_cd) {
		this.name_cd = name_cd;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCheck_cd() {
		return check_cd;
	}
	public void setCheck_cd(String check_cd) {
		this.check_cd = check_cd;
	}
	public String getCerti_nm() {
		return certi_nm;
	}
	public void setCerti_nm(String certi_nm) {
		this.certi_nm = certi_nm;
	}
	public String getSkill_cd() {
		return skill_cd;
	}
	public void setSkill_cd(String skill_cd) {
		this.skill_cd = skill_cd;
	}
	public String getAssign_group_id() {
		return assign_group_id;
	}
	public void setAssign_group_id(String assign_group_id) {
		this.assign_group_id = assign_group_id;
	}
	
}
