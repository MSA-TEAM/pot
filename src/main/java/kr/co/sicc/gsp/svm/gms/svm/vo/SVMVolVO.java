package kr.co.sicc.gsp.svm.gms.svm.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.sicc.gsp.svm.sicc.common.vo.SiccGenericVO;

/**
 * <pre>	
 * com.gms.svm.vo
 * SVMVolVO.java
 * Description 	:
 * ???öå ?ûê?õêÎ¥âÏÇ¨ Ïß??õê?Ñú VO
 * History     	:
 * </pre>
 *
 * @author	 	: gypark
 * @Date	 	: 2017.07.14
 * @Version 	: 1.0
 *
 */

@SuppressWarnings("serial")
public class SVMVolVO extends SiccGenericVO {
	private String[] hd_regi_no;
	
	private String lang = "";
	
	// search 
    private String search_fg = "";

    private String kind = "";
    
    private String area_cd = "";
    
    private List<SVMInfoVO> areaList = new ArrayList<SVMInfoVO>();
    
    private String[] tov;
    private String[] pd;
    private String[] oee;
    private String[] ls;
    private String[] as;
    
    private String regi_no;
    private String ad_seq;
    
    private String search_ctry_cd_fg;
    private String search_ktp_no = "";
    private String search_local_nm = "";
	private String search_avail_location_cd = "";
	private String search_recu_sec = "";
	private String search_prefer_job_cd = "";
	private String search_prefer_job_cd2 = "";
	private String search_lang_cd = "";
	private String search_lang_lvl_cd = "";
	private String search_avail_work_cd = "";
	private String search_dept_cd = "";
	private String search_group_nm = "";
	private String search_sports_cd = "";
	private String search_discipline_cd = "";
	private String search_venue_cd = "";
	private String search_gender = "";
	private String search_foreign_yn = "";
	private String search_bank_acc_no_yn = "";
	private String search_photo_yn = "";
	private String search_aimag_yn = "";
	private String search_mobile_no = "";
	private String search_orderby = "";
	
    private String search_id_no = "";
    private String search_regi_no = "";
    private String search_name = "";
    private String search_family_nm = "";
    private String search_given_nm = "";
    private String search_passport_no = "";
    private String search_birth_dt = "";
    private String search_registered_dt = "";
    private String search_approved_dt = "";
    private String search_status_fg = "";
    private String search_issue_type = "";
    private String search_active_type = "";
    private String search_card_type = "";
    private String search_ctry_cd = "";
    private String search_ctry_cd_nm = "";
    private String search_category_type = "";
    private String search_category_type_nm = "";
    private String search_category_cd = "";
    private String search_category_cd_nm = "";
    private String search_function_cd = "";
    private String search_function_cd_nm = "";
    private String search_org_cd = "";
    private String search_org_cd_nm = "";
    private String search_sub_org_cd = "";
    private String search_sub_org_cd_nm = "";
    private String search_order = "";
    private String search_barcode_yn = "";
    
    private String nickname = "";
    private String married_cd = "";
    private String married_nm = "";
    private String blood_type_cd = "";
    private String foreign_city = "";
    private String city_cd = "";
    private String city_nm = "";
    private String provinsi_cd = "";
    private String district_cd = "";
    private String village_cd = "";
    private String provinsi_nm = "";
    private String district_nm = "";
    private String village_nm = "";
    private String ktp_no = "";

    private String facebook_nm = "";
    private String twitter_nm = "";
    private String line_nm = "";
    private String hobby = "";
    private String aspiration = "";
    private String motto = "";
    private String reason = "";
    private String sd_schl_year = "";
    private String sd_schl_nm = "";
    private String smp_schl_year = "";
    private String smp_schl_nm = "";
    private String sma_schl_year = "";
    private String sma_schl_nm = "";
    private String university_year = "";
    private String university_faculty = "";
    private String university_university = "";
    private String post_grad_year = "";
    private String post_grad_faculty = "";
    private String post_grad_university = "";
    private String doctoral_year = "";
    private String doctoral_faculty = "";
    private String doctoral_university = "";
    private String prnts_mother_nm = "";
    private String prnts_father_nm = "";
    private String emer_phone = "";
    private String emer_rel_cd = "";
    private String emer_rel_nm = "";
    private String prefer_duration_cd = "";
    private String avail_work_desc = "";
    private String whats_no = "";
    private String occu_or_univ_cd = "";
    private String occu_or_univ_cd_nm = "";
    private String occu_or_univ_nm = "";
    private String occu_or_univ_st_major_cd = "";
    private String occu_or_univ_st_major_nm = "";
    private String occu_or_univ_major_cd = "";
    private String occu_or_univ_major_nm = "";
    private String postcode = "";
    private String nationality = "";
    private String nationality_cd = "";
    private String nationality_nm = "";
    private String nationality_mobile = "";
    private String university_lvl_yn = "";

    private String skill_cd = "";
    private String skill_nm = "";
    private String level_cd = "";
    private String level_nm = "";
    private String name_txt = "";
    private String name_cd = "";
    private String duration = "";
    private String description = "";
    private String check_cd = "";
    private String certi_nm = "";
    private String use_yn = "";
    
    
    private String height = "";
    private String weight = "";
    
    private String user_org_cd = "";
    private String workforce_yn = "";
    private String family_yn = "";
    
	private String file_group_no = "";
	private String photoImg = "";
    private String passportImg = "";
    private String fileType = "";
    private String imageNm = "";
    private String online_delete_fg = "";
    
    private String facePhoto_nm = "";
    private String bodyPhoto_nm = "";
    private String passportFile_nm = "";
    private String skillFile_nm = "";
    private String downFile_nm = "";
    
    private String save_tab_cd = "";
    		
    /**
     * photo
     */ 
    //private FormFile file = null;
    private String file_nm = "";
    private String passFile_nm = "";
    
    // Volunteer application info
    private String password = "";
    
    private String ad_no = "";
	private String local_nm1 = "";
	private String local_nm2 = "";
	private String family_nm = "";
	private String given_nm = "";
	private String id_number1 = "";
	private String id_number2 = "";
	private String birth_date = "";
	private String gender = "";
	private String gender_nm = "";
	private String ctry_cd = "";
	private String passport_no = "";
	private String tel_no_1 = "";
	private String tel_no_2 = "";
	private String tel_no_3 = "";
	private String mobile_no_1 = "";
	private String mobile_no_2 = "";
	private String mobile_no_3 = "";
	private String email = "";
	private String bank_cd = "";
	private String bank_acc_no = "";
	private String zipcode = "";
	private String address = "";
	private String address_dtl = "";
	private String recu_sec = "";
	private String occu_cd = "";
	private String etc_occu_nm = "";
	private String comp_nm = "";
	private String univ_cd = "";
	private String school_nm = "";
	private String univ_dept_nm = "";
	private String prefer_job1_cd = "";
	private String prefer_job1_spec_yn = "";
	private String prefer_job1_spec_nm = "";
	private String prefer_job1_license_yn = "";
	private String prefer_job1_license_nm = "";
	private String prefer_job2_cd = "";
	private String prefer_job2_spec_yn = "";
	private String prefer_job2_spec_nm = "";
	private String prefer_job2_license_yn = "";
	private String prefer_job2_license_nm = "";
	private String lang1_cd = "";
	private String lang1_etc = "";
	private String lang1_lvl_cd = "";
	private String lang1_ctry_cd = "";
	private String lang1_residence = "";
	private String lang2_cd = "";
	private String lang2_etc = "";
	private String lang2_lvl_cd = "";
	private String lang2_ctry_cd = "";
	private String lang2_residence = "";
	private String lang3_cd = "";
	private String lang3_etc = "";
	private String lang3_lvl_cd = "";
	private String lang3_ctry_cd = "";
	private String lang3_residence = "";
	private String avail_work_cd = "";
	private String avail_work_nm = "";
	private String event1_nm = "";
	private String event1_activity = "";
	private String event1_activity_mm = "";
	private String event1_activity_dd = "";
	private String event2_nm = "";
	private String event2_activity = "";
	private String event2_activity_mm = "";
	private String event2_activity_dd = "";
	private String event3_nm = "";
	private String event3_activity = "";
	private String event3_activity_mm = "";
	private String event3_activity_dd = "";
	private String uni_shirts_cd = "";
	private String uni_shirts_nm = "";
	private String uni_waist_cd = "";
	private String uni_waist_nm = "";
	private String uni_cap_cd = "";
	private String uni_shoes_cd = "";
	private String uni_shoes_nm = "";
	private String remark = "";
	private String dept_target_yn = "";
	private String dept_cd = "";
	private String group_cd = "";
	private String sports_cd = "";
	private String discipline_cd = "";
	private String venue_cd = "";

//	private String pre_id_number1 = "";
//	private String pre_id_number2 = "";

	// Ôßè‚ë∏Ï§?, ËπÇÎãø?¨ÔøΩÔø?
	private String local_nm = ""; 		// local_nm1 + local_nm2
	private String eng_nm = ""; 		// family_nm + given_nm
	private String ctry_nm = ""; 		// ctry_cd => nm
	private String tel_no = ""; 		// tel_no1 + tel_no2 + tel_no3
	private String mobile_no = ""; 		// mobile_no1 + mobile_no2 + mobile_no3
	private String bank_nm = ""; 		// bank_cd => nm
	private String recu_sec_nm = ""; 	// recu_sec => nm
	private String occu_nm = ""; 		// occu_cd => nm
	private String univ_nm = ""; 		// univ_cd => nm
	private String prefer_job1_nm = ""; // prefer_job1_cd => nm
	private String prefer_job2_nm = ""; // prefer_job2_cd => nm
	private String lang1_nm = ""; 		// lang1_cd => nm
	private String lang1_lvl_nm = ""; 	// lang1_lvl_cd => nm
	private String lang1_ctry_nm = ""; 	// lang1_ctry_cd => nm
	private String lang2_nm = ""; 		// lang2_cd => nm
	private String lang2_lvl_nm = ""; 	// lang2_lvl_cd => nm
	private String lang2_ctry_nm = ""; 	// lang2_ctry_cd => nm
	private String lang3_nm = ""; 		// lang3_cd => nm
	private String lang3_lvl_nm = ""; 	// lang3_lvl_cd => nm
	private String lang3_ctry_nm = ""; 	// lang3_ctry_cd => nm
	private String dept_nm = ""; 		// dept_cd => nm
	private String group_nm = ""; 		// group_cd => nm


	private String link_page = "";   
    // ?†Ñ?ôîÎ©¥Ï†ë Ï°∞ÌöåÏ°∞Í±¥
    private String search_regi_no_to = "";
	private String search_comp_yn = ""; 
    // ?Üå?ñëÍµêÏú° Ï°∞ÌöåÏ°∞Í±¥  
	private String search_educ_no = ""; 
	private String search_alloc_yn = ""; 
	private String search_educ_fg = ""; 
	private String search_ceremony_yn = ""; 
	private String search_educ_fg_yn = ""; 

	private String email_id = "";
	private String email_vendor = "";
	private String etc_school_nm = "";
	private String univ_stat = "";
	private String univ_stat_nm = "";
	private String any_job_yn = "";
	private String avail_location_cd = "";
	private String avail_location_nm = "";
	private List<Object> dataList = new ArrayList<Object>();
	private String ctry_cd_fg = "";
	private String ctry_cd_fg_nm = "";
	private String search_dept_target_yn = "";
	private String email_sel = "";
	private String online_yn = "";
	private String search_online_yn = "";
	private String photo_flag = "";
	private String str_regi_no = "";
	private String duplicate_check_yn = "";
	private String org_cd = "";
	private String etc_org_nm = "";
    
    
	// system flag
    private String system_cd = "";
    private String status_fg = "";
    private String entry_yn = "";
    
    // previous data
    private String pre_category_cd = "";
    private String pre_org_cd = "";
    private String pre_function_cd = "";
    private String pre_card_type = "";
    private String pre_family_nm = "";
    private String pre_given_nm = "";
    private String pre_eng_nm2 = "";
    private String pre_eng_nm3 = "";
    private String pre_eng_nm4 = "";
    private String pre_local_family_nm = "";
    private String pre_local_given_nm = "";
    private String pre_prefer_family_nm = "";
    private String pre_prefer_given_nm = "";
    private String pre_gender = "";
    private String pre_birth_dt = "";
    private String pre_born_ctry_cd = "";
    private String pre_passport_ctry_cd = "";
    private String pre_passport_no = "";
    private String pre_passport_expiry_dt = "";
    private String pre_working_area1_cd = "";
    private String pre_working_area2_cd = "";
    private String pre_working_area3_cd = "";
    private String pre_working_area4_cd = "";
    private String pre_working_area5_cd = "";
    private String pre_working_area6_cd = "";
    private String pre_sport1_cd = "";
    private String pre_sport2_cd = "";
    private String pre_sport3_cd = "";
    private String pre_access_area_cd = "";
    private String pre_access_area_nm = "";
    private String pre_status_fg = "";
    
    // list
    private List<Object> tovList = new ArrayList<Object>();
    private List<Object> pdList = new ArrayList<Object>();
    private List<Object> lsList = new ArrayList<Object>();
    private List<Object> adList = new ArrayList<Object>();
    private List<Object> areaTypeList = new ArrayList<Object>();
    private List<Object> countryNoList = new ArrayList<Object>();
    private List<Object> accessAreaList = new ArrayList<Object>();
    
    // 
    private String[] chk_ad_no = null;
    private String[] chk_approve_yn = null;
    private String[] chk = null;
    private String[] chk_status = null;   
	private String[] del_photo_fg_arry = null;
    
    private String photo_fg = "";
    private String del_photo_fg = "";
    
    private String facephoto = "";
    private String bodyphoto = "";
    
    public String[] getDel_photo_fg_arry() {
		return del_photo_fg_arry;
	}
	public void setDel_photo_fg_arry(String[] del_photo_fg_arry) {
		this.del_photo_fg_arry = del_photo_fg_arry;
	}
	public String getDel_photo_fg() {
		return del_photo_fg;
	}
	public void setDel_photo_fg(String del_photo_fg) {
		this.del_photo_fg = del_photo_fg;
	}
	public String getOccu_or_univ_st_major_nm() {
		return occu_or_univ_st_major_nm;
	}
	public void setOccu_or_univ_st_major_nm(String occu_or_univ_st_major_nm) {
		this.occu_or_univ_st_major_nm = occu_or_univ_st_major_nm;
	}
	public String getOccu_or_univ_major_nm() {
		return occu_or_univ_major_nm;
	}
	public void setOccu_or_univ_major_nm(String occu_or_univ_major_nm) {
		this.occu_or_univ_major_nm = occu_or_univ_major_nm;
	}
	public String getNationality_mobile() {
		return nationality_mobile;
	}
	public void setNationality_mobile(String nationality_mobile) {
		this.nationality_mobile = nationality_mobile;
	}
	public String getSkill_nm() {
		return skill_nm;
	}
	public void setSkill_nm(String skill_nm) {
		this.skill_nm = skill_nm;
	}
	public String getLevel_nm() {
		return level_nm;
	}
	public void setLevel_nm(String level_nm) {
		this.level_nm = level_nm;
	}
	public String[] getHd_regi_no() {
		return hd_regi_no;
	}
	public String getOccu_or_univ_cd_nm() {
		return occu_or_univ_cd_nm;
	}
	public void setOccu_or_univ_cd_nm(String occu_or_univ_cd_nm) {
		this.occu_or_univ_cd_nm = occu_or_univ_cd_nm;
	}
	public String getAvail_location_nm() {
		return avail_location_nm;
	}
	public void setAvail_location_nm(String avail_location_nm) {
		this.avail_location_nm = avail_location_nm;
	}
	public String getEmer_rel_nm() {
		return emer_rel_nm;
	}
	public void setEmer_rel_nm(String emer_rel_nm) {
		this.emer_rel_nm = emer_rel_nm;
	}
	public String getNationality_nm() {
		return nationality_nm;
	}
	public void setNationality_nm(String nationality_nm) {
		this.nationality_nm = nationality_nm;
	}
	public String getMarried_nm() {
		return married_nm;
	}
	public void setMarried_nm(String married_nm) {
		this.married_nm = married_nm;
	}
	public String getCity_nm() {
		return city_nm;
	}
	public void setCity_nm(String city_nm) {
		this.city_nm = city_nm;
	}
	public String getProvinsi_nm() {
		return provinsi_nm;
	}
	public void setProvinsi_nm(String provinsi_nm) {
		this.provinsi_nm = provinsi_nm;
	}
	public String getDistrict_nm() {
		return district_nm;
	}
	public void setDistrict_nm(String district_nm) {
		this.district_nm = district_nm;
	}
	public String getVillage_nm() {
		return village_nm;
	}
	public void setVillage_nm(String village_nm) {
		this.village_nm = village_nm;
	}
	public String getAvail_work_nm() {
		return avail_work_nm;
	}
	public void setAvail_work_nm(String avail_work_nm) {
		this.avail_work_nm = avail_work_nm;
	}
	public String getUni_shirts_nm() {
		return uni_shirts_nm;
	}
	public void setUni_shirts_nm(String uni_shirts_nm) {
		this.uni_shirts_nm = uni_shirts_nm;
	}
	public String getUni_waist_nm() {
		return uni_waist_nm;
	}
	public void setUni_waist_nm(String uni_waist_nm) {
		this.uni_waist_nm = uni_waist_nm;
	}
	public String getUni_shoes_nm() {
		return uni_shoes_nm;
	}
	public void setUni_shoes_nm(String uni_shoes_nm) {
		this.uni_shoes_nm = uni_shoes_nm;
	}
	public String getUniv_stat_nm() {
		return univ_stat_nm;
	}
	public void setUniv_stat_nm(String univ_stat_nm) {
		this.univ_stat_nm = univ_stat_nm;
	}
	public String getCtry_cd_fg_nm() {
		return ctry_cd_fg_nm;
	}
	public void setCtry_cd_fg_nm(String ctry_cd_fg_nm) {
		this.ctry_cd_fg_nm = ctry_cd_fg_nm;
	}
	public String getGender_nm() {
		return gender_nm;
	}
	public void setGender_nm(String gender_nm) {
		this.gender_nm = gender_nm;
	}
	public String getPassportFile_nm() {
		return passportFile_nm;
	}
	public void setPassportFile_nm(String passportFile_nm) {
		this.passportFile_nm = passportFile_nm;
	}
	public String getFacePhoto_nm() {
		return facePhoto_nm;
	}
	public void setFacePhoto_nm(String facePhoto_nm) {
		this.facePhoto_nm = facePhoto_nm;
	}
	public String getBodyPhoto_nm() {
		return bodyPhoto_nm;
	}
	public void setBodyPhoto_nm(String bodyPhoto_nm) {
		this.bodyPhoto_nm = bodyPhoto_nm;
	}
	public void setHd_regi_no(String[] hd_regi_no) {
		this.hd_regi_no = hd_regi_no;
	}
	public String getSearch_fg() {
		return search_fg;
	}
	public void setSearch_fg(String search_fg) {
		this.search_fg = search_fg;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getArea_cd() {
		return area_cd;
	}
	public void setArea_cd(String area_cd) {
		this.area_cd = area_cd;
	}
	public List<SVMInfoVO> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<SVMInfoVO> areaList) {
		this.areaList = areaList;
	}
	public String[] getTov() {
		return tov;
	}
	public void setTov(String[] tov) {
		if(tov == null){
			this.tov = new String[0];
		}else{
			this.tov = Arrays.copyOf(tov, tov.length);
		}
	}
	public String[] getPd() {
		return pd;
	}
	public void setPd(String[] pd) {
		if(pd == null){
			this.pd = new String[0];
		}else{
			this.pd = Arrays.copyOf(pd, pd.length);
		}
	}
	public String[] getOee() {
		return oee;
	}
	public void setOee(String[] oee) {
		if(oee == null){
			this.oee = new String[0];
		}else{
			this.oee = Arrays.copyOf(oee, oee.length);
		}
	}
	public String[] getLs() {
		return ls;
	}
	public void setLs(String[] ls) {
		if(ls == null){
			this.ls = new String[0];
		}else{
			this.ls = Arrays.copyOf(ls, ls.length);
		}
	}
	public String[] getAs() {
		return as;
	}
	public void setAs(String[] as) {
		if(as == null){
			this.as = new String[0];
		}else{
			this.as = Arrays.copyOf(as, as.length);
		}
	}
	public String getRegi_no() {
		return regi_no;
	}
	public void setRegi_no(String regi_no) {
		this.regi_no = regi_no;
	}
	public String getAd_seq() {
		return ad_seq;
	}
	public void setAd_seq(String ad_seq) {
		this.ad_seq = ad_seq;
	}
	public String getSearch_ctry_cd_fg() {
		return search_ctry_cd_fg;
	}
	public void setSearch_ctry_cd_fg(String search_ctry_cd_fg) {
		this.search_ctry_cd_fg = search_ctry_cd_fg;
	}
	public String getSearch_ktp_no() {
		return search_ktp_no;
	}
	public void setSearch_ktp_no(String search_ktp_no) {
		this.search_ktp_no = search_ktp_no;
	}
	public String getSearch_local_nm() {
		return search_local_nm;
	}
	public void setSearch_local_nm(String search_local_nm) {
		this.search_local_nm = search_local_nm;
	}
	public String getSearch_avail_location_cd() {
		return search_avail_location_cd;
	}
	public void setSearch_avail_location_cd(String search_avail_location_cd) {
		this.search_avail_location_cd = search_avail_location_cd;
	}
	public String getSearch_recu_sec() {
		return search_recu_sec;
	}
	public void setSearch_recu_sec(String search_recu_sec) {
		this.search_recu_sec = search_recu_sec;
	}
	public String getSearch_prefer_job_cd() {
		return search_prefer_job_cd;
	}
	public void setSearch_prefer_job_cd(String search_prefer_job_cd) {
		this.search_prefer_job_cd = search_prefer_job_cd;
	}
	public String getSearch_prefer_job_cd2() {
		return search_prefer_job_cd2;
	}
	public void setSearch_prefer_job_cd2(String search_prefer_job_cd2) {
		this.search_prefer_job_cd2 = search_prefer_job_cd2;
	}
	public String getSearch_lang_cd() {
		return search_lang_cd;
	}
	public void setSearch_lang_cd(String search_lang_cd) {
		this.search_lang_cd = search_lang_cd;
	}
	public String getSearch_lang_lvl_cd() {
		return search_lang_lvl_cd;
	}
	public void setSearch_lang_lvl_cd(String search_lang_lvl_cd) {
		this.search_lang_lvl_cd = search_lang_lvl_cd;
	}
	public String getSearch_avail_work_cd() {
		return search_avail_work_cd;
	}
	public void setSearch_avail_work_cd(String search_avail_work_cd) {
		this.search_avail_work_cd = search_avail_work_cd;
	}
	public String getSearch_dept_cd() {
		return search_dept_cd;
	}
	public void setSearch_dept_cd(String search_dept_cd) {
		this.search_dept_cd = search_dept_cd;
	}
	public String getSearch_group_nm() {
		return search_group_nm;
	}
	public void setSearch_group_nm(String search_group_nm) {
		this.search_group_nm = search_group_nm;
	}
	public String getSearch_sports_cd() {
		return search_sports_cd;
	}
	public void setSearch_sports_cd(String search_sports_cd) {
		this.search_sports_cd = search_sports_cd;
	}
	public String getSearch_discipline_cd() {
		return search_discipline_cd;
	}
	public void setSearch_discipline_cd(String search_discipline_cd) {
		this.search_discipline_cd = search_discipline_cd;
	}
	public String getSearch_venue_cd() {
		return search_venue_cd;
	}
	public void setSearch_venue_cd(String search_venue_cd) {
		this.search_venue_cd = search_venue_cd;
	}
	public String getSearch_gender() {
		return search_gender;
	}
	public void setSearch_gender(String search_gender) {
		this.search_gender = search_gender;
	}
	public String getSearch_foreign_yn() {
		return search_foreign_yn;
	}
	public void setSearch_foreign_yn(String search_foreign_yn) {
		this.search_foreign_yn = search_foreign_yn;
	}
	public String getSearch_bank_acc_no_yn() {
		return search_bank_acc_no_yn;
	}
	public void setSearch_bank_acc_no_yn(String search_bank_acc_no_yn) {
		this.search_bank_acc_no_yn = search_bank_acc_no_yn;
	}
	public String getSearch_photo_yn() {
		return search_photo_yn;
	}
	public void setSearch_photo_yn(String search_photo_yn) {
		this.search_photo_yn = search_photo_yn;
	}
	public String getSearch_aimag_yn() {
		return search_aimag_yn;
	}
	public void setSearch_aimag_yn(String search_aimag_yn) {
		this.search_aimag_yn = search_aimag_yn;
	}
	public String getSearch_mobile_no() {
		return search_mobile_no;
	}
	public void setSearch_mobile_no(String search_mobile_no) {
		this.search_mobile_no = search_mobile_no;
	}
	public String getSearch_orderby() {
		return search_orderby;
	}
	public void setSearch_orderby(String search_orderby) {
		this.search_orderby = search_orderby;
	}
	public String getSearch_id_no() {
		return search_id_no;
	}
	public void setSearch_id_no(String search_id_no) {
		this.search_id_no = search_id_no;
	}
	public String getSearch_regi_no() {
		return search_regi_no;
	}
	public void setSearch_regi_no(String search_regi_no) {
		this.search_regi_no = search_regi_no;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public String getSearch_family_nm() {
		return search_family_nm;
	}
	public void setSearch_family_nm(String search_family_nm) {
		this.search_family_nm = search_family_nm;
	}
	public String getSearch_given_nm() {
		return search_given_nm;
	}
	public void setSearch_given_nm(String search_given_nm) {
		this.search_given_nm = search_given_nm;
	}
	public String getSearch_passport_no() {
		return search_passport_no;
	}
	public void setSearch_passport_no(String search_passport_no) {
		this.search_passport_no = search_passport_no;
	}
	public String getSearch_birth_dt() {
		return search_birth_dt;
	}
	public void setSearch_birth_dt(String search_birth_dt) {
		this.search_birth_dt = search_birth_dt;
	}
	public String getSearch_registered_dt() {
		return search_registered_dt;
	}
	public void setSearch_registered_dt(String search_registered_dt) {
		this.search_registered_dt = search_registered_dt;
	}
	public String getSearch_approved_dt() {
		return search_approved_dt;
	}
	public void setSearch_approved_dt(String search_approved_dt) {
		this.search_approved_dt = search_approved_dt;
	}
	public String getSearch_status_fg() {
		return search_status_fg;
	}
	public void setSearch_status_fg(String search_status_fg) {
		this.search_status_fg = search_status_fg;
	}
	public String getSearch_issue_type() {
		return search_issue_type;
	}
	public void setSearch_issue_type(String search_issue_type) {
		this.search_issue_type = search_issue_type;
	}
	public String getSearch_active_type() {
		return search_active_type;
	}
	public void setSearch_active_type(String search_active_type) {
		this.search_active_type = search_active_type;
	}
	public String getSearch_card_type() {
		return search_card_type;
	}
	public void setSearch_card_type(String search_card_type) {
		this.search_card_type = search_card_type;
	}
	public String getSearch_ctry_cd() {
		return search_ctry_cd;
	}
	public void setSearch_ctry_cd(String search_ctry_cd) {
		this.search_ctry_cd = search_ctry_cd;
	}
	public String getSearch_ctry_cd_nm() {
		return search_ctry_cd_nm;
	}
	public void setSearch_ctry_cd_nm(String search_ctry_cd_nm) {
		this.search_ctry_cd_nm = search_ctry_cd_nm;
	}
	public String getSearch_category_type() {
		return search_category_type;
	}
	public void setSearch_category_type(String search_category_type) {
		this.search_category_type = search_category_type;
	}
	public String getSearch_category_type_nm() {
		return search_category_type_nm;
	}
	public void setSearch_category_type_nm(String search_category_type_nm) {
		this.search_category_type_nm = search_category_type_nm;
	}
	public String getSearch_category_cd() {
		return search_category_cd;
	}
	public void setSearch_category_cd(String search_category_cd) {
		this.search_category_cd = search_category_cd;
	}
	public String getSearch_category_cd_nm() {
		return search_category_cd_nm;
	}
	public void setSearch_category_cd_nm(String search_category_cd_nm) {
		this.search_category_cd_nm = search_category_cd_nm;
	}
	public String getSearch_function_cd() {
		return search_function_cd;
	}
	public void setSearch_function_cd(String search_function_cd) {
		this.search_function_cd = search_function_cd;
	}
	public String getSearch_function_cd_nm() {
		return search_function_cd_nm;
	}
	public void setSearch_function_cd_nm(String search_function_cd_nm) {
		this.search_function_cd_nm = search_function_cd_nm;
	}
	public String getSearch_org_cd() {
		return search_org_cd;
	}
	public void setSearch_org_cd(String search_org_cd) {
		this.search_org_cd = search_org_cd;
	}
	public String getSearch_org_cd_nm() {
		return search_org_cd_nm;
	}
	public void setSearch_org_cd_nm(String search_org_cd_nm) {
		this.search_org_cd_nm = search_org_cd_nm;
	}
	public String getSearch_sub_org_cd() {
		return search_sub_org_cd;
	}
	public void setSearch_sub_org_cd(String search_sub_org_cd) {
		this.search_sub_org_cd = search_sub_org_cd;
	}
	public String getSearch_sub_org_cd_nm() {
		return search_sub_org_cd_nm;
	}
	public void setSearch_sub_org_cd_nm(String search_sub_org_cd_nm) {
		this.search_sub_org_cd_nm = search_sub_org_cd_nm;
	}
	public String getSearch_order() {
		return search_order;
	}
	public void setSearch_order(String search_order) {
		this.search_order = search_order;
	}
	public String getSearch_barcode_yn() {
		return search_barcode_yn;
	}
	public void setSearch_barcode_yn(String search_barcode_yn) {
		this.search_barcode_yn = search_barcode_yn;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMarried_cd() {
		return married_cd;
	}
	public void setMarried_cd(String married_cd) {
		this.married_cd = married_cd;
	}
	public String getBlood_type_cd() {
		return blood_type_cd;
	}
	public void setBlood_type_cd(String blood_type_cd) {
		this.blood_type_cd = blood_type_cd;
	}
	public String getForeign_city() {
		return foreign_city;
	}
	public void setForeign_city(String foreign_city) {
		this.foreign_city = foreign_city;
	}
	public String getCity_cd() {
		return city_cd;
	}
	public void setCity_cd(String city_cd) {
		this.city_cd = city_cd;
	}
	public String getProvinsi_cd() {
		return provinsi_cd;
	}
	public void setProvinsi_cd(String provinsi_cd) {
		this.provinsi_cd = provinsi_cd;
	}
	public String getDistrict_cd() {
		return district_cd;
	}
	public void setDistrict_cd(String district_cd) {
		this.district_cd = district_cd;
	}
	public String getVillage_cd() {
		return village_cd;
	}
	public void setVillage_cd(String village_cd) {
		this.village_cd = village_cd;
	}
	public String getKtp_no() {
		return ktp_no;
	}
	public void setKtp_no(String ktp_no) {
		this.ktp_no = ktp_no;
	}
	public String getFacebook_nm() {
		return facebook_nm;
	}
	public void setFacebook_nm(String facebook_nm) {
		this.facebook_nm = facebook_nm;
	}
	public String getTwitter_nm() {
		return twitter_nm;
	}
	public void setTwitter_nm(String twitter_nm) {
		this.twitter_nm = twitter_nm;
	}
	public String getLine_nm() {
		return line_nm;
	}
	public void setLine_nm(String line_nm) {
		this.line_nm = line_nm;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getAspiration() {
		return aspiration;
	}
	public void setAspiration(String aspiration) {
		this.aspiration = aspiration;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSd_schl_year() {
		return sd_schl_year;
	}
	public void setSd_schl_year(String sd_schl_year) {
		this.sd_schl_year = sd_schl_year;
	}
	public String getSd_schl_nm() {
		return sd_schl_nm;
	}
	public void setSd_schl_nm(String sd_schl_nm) {
		this.sd_schl_nm = sd_schl_nm;
	}
	public String getSmp_schl_year() {
		return smp_schl_year;
	}
	public void setSmp_schl_year(String smp_schl_year) {
		this.smp_schl_year = smp_schl_year;
	}
	public String getSmp_schl_nm() {
		return smp_schl_nm;
	}
	public void setSmp_schl_nm(String smp_schl_nm) {
		this.smp_schl_nm = smp_schl_nm;
	}
	public String getSma_schl_year() {
		return sma_schl_year;
	}
	public void setSma_schl_year(String sma_schl_year) {
		this.sma_schl_year = sma_schl_year;
	}
	public String getSma_schl_nm() {
		return sma_schl_nm;
	}
	public void setSma_schl_nm(String sma_schl_nm) {
		this.sma_schl_nm = sma_schl_nm;
	}
	public String getUniversity_year() {
		return university_year;
	}
	public void setUniversity_year(String university_year) {
		this.university_year = university_year;
	}
	public String getUniversity_faculty() {
		return university_faculty;
	}
	public void setUniversity_faculty(String university_faculty) {
		this.university_faculty = university_faculty;
	}
	public String getUniversity_university() {
		return university_university;
	}
	public void setUniversity_university(String university_university) {
		this.university_university = university_university;
	}
	public String getPost_grad_year() {
		return post_grad_year;
	}
	public void setPost_grad_year(String post_grad_year) {
		this.post_grad_year = post_grad_year;
	}
	public String getPost_grad_faculty() {
		return post_grad_faculty;
	}
	public void setPost_grad_faculty(String post_grad_faculty) {
		this.post_grad_faculty = post_grad_faculty;
	}
	public String getPost_grad_university() {
		return post_grad_university;
	}
	public void setPost_grad_university(String post_grad_university) {
		this.post_grad_university = post_grad_university;
	}
	public String getDoctoral_year() {
		return doctoral_year;
	}
	public void setDoctoral_year(String doctoral_year) {
		this.doctoral_year = doctoral_year;
	}
	public String getDoctoral_faculty() {
		return doctoral_faculty;
	}
	public void setDoctoral_faculty(String doctoral_faculty) {
		this.doctoral_faculty = doctoral_faculty;
	}
	public String getDoctoral_university() {
		return doctoral_university;
	}
	public void setDoctoral_university(String doctoral_university) {
		this.doctoral_university = doctoral_university;
	}
	public String getPrnts_mother_nm() {
		return prnts_mother_nm;
	}
	public void setPrnts_mother_nm(String prnts_mother_nm) {
		this.prnts_mother_nm = prnts_mother_nm;
	}
	public String getPrnts_father_nm() {
		return prnts_father_nm;
	}
	public void setPrnts_father_nm(String prnts_father_nm) {
		this.prnts_father_nm = prnts_father_nm;
	}
	public String getEmer_phone() {
		return emer_phone;
	}
	public void setEmer_phone(String emer_phone) {
		this.emer_phone = emer_phone;
	}
	public String getEmer_rel_cd() {
		return emer_rel_cd;
	}
	public void setEmer_rel_cd(String emer_rel_cd) {
		this.emer_rel_cd = emer_rel_cd;
	}
	public String getPrefer_duration_cd() {
		return prefer_duration_cd;
	}
	public void setPrefer_duration_cd(String prefer_duration_cd) {
		this.prefer_duration_cd = prefer_duration_cd;
	}
	public String getAvail_work_desc() {
		return avail_work_desc;
	}
	public void setAvail_work_desc(String avail_work_desc) {
		this.avail_work_desc = avail_work_desc;
	}
	public String getWhats_no() {
		return whats_no;
	}
	public void setWhats_no(String whats_no) {
		this.whats_no = whats_no;
	}
	public String getOccu_or_univ_cd() {
		return occu_or_univ_cd;
	}
	public void setOccu_or_univ_cd(String occu_or_univ_cd) {
		this.occu_or_univ_cd = occu_or_univ_cd;
	}
	public String getOccu_or_univ_nm() {
		return occu_or_univ_nm;
	}
	public void setOccu_or_univ_nm(String occu_or_univ_nm) {
		this.occu_or_univ_nm = occu_or_univ_nm;
	}
	public String getOccu_or_univ_st_major_cd() {
		return occu_or_univ_st_major_cd;
	}
	public void setOccu_or_univ_st_major_cd(String occu_or_univ_st_major_cd) {
		this.occu_or_univ_st_major_cd = occu_or_univ_st_major_cd;
	}
	public String getOccu_or_univ_major_cd() {
		return occu_or_univ_major_cd;
	}
	public void setOccu_or_univ_major_cd(String occu_or_univ_major_cd) {
		this.occu_or_univ_major_cd = occu_or_univ_major_cd;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNationality_cd() {
		return nationality_cd;
	}
	public void setNationality_cd(String nationality_cd) {
		this.nationality_cd = nationality_cd;
	}
	public String getUniversity_lvl_yn() {
		return university_lvl_yn;
	}
	public void setUniversity_lvl_yn(String university_lvl_yn) {
		this.university_lvl_yn = university_lvl_yn;
	}
	public String getSkill_cd() {
		return skill_cd;
	}
	public void setSkill_cd(String skill_cd) {
		this.skill_cd = skill_cd;
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
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getUser_org_cd() {
		return user_org_cd;
	}
	public void setUser_org_cd(String user_org_cd) {
		this.user_org_cd = user_org_cd;
	}
	public String getWorkforce_yn() {
		return workforce_yn;
	}
	public void setWorkforce_yn(String workforce_yn) {
		this.workforce_yn = workforce_yn;
	}
	public String getFamily_yn() {
		return family_yn;
	}
	public void setFamily_yn(String family_yn) {
		this.family_yn = family_yn;
	}
	public String getFile_group_no() {
		return file_group_no;
	}
	public void setFile_group_no(String file_group_no) {
		this.file_group_no = file_group_no;
	}
	public String getPhotoImg() {
		return photoImg;
	}
	public void setPhotoImg(String photoImg) {
		this.photoImg = photoImg;
	}
	public String getPassportImg() {
		return passportImg;
	}
	public void setPassportImg(String passportImg) {
		this.passportImg = passportImg;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getImageNm() {
		return imageNm;
	}
	public void setImageNm(String imageNm) {
		this.imageNm = imageNm;
	}
	public String getOnline_delete_fg() {
		return online_delete_fg;
	}
	public void setOnline_delete_fg(String online_delete_fg) {
		this.online_delete_fg = online_delete_fg;
	}
	public String getSave_tab_cd() {
		return save_tab_cd;
	}
	public void setSave_tab_cd(String save_tab_cd) {
		this.save_tab_cd = save_tab_cd;
	}
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	public String getPassFile_nm() {
		return passFile_nm;
	}
	public void setPassFile_nm(String passFile_nm) {
		this.passFile_nm = passFile_nm;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public String getLocal_nm1() {
		return local_nm1;
	}
	public void setLocal_nm1(String local_nm1) {
		this.local_nm1 = local_nm1;
	}
	public String getLocal_nm2() {
		return local_nm2;
	}
	public void setLocal_nm2(String local_nm2) {
		this.local_nm2 = local_nm2;
	}
	public String getFamily_nm() {
		return family_nm;
	}
	public void setFamily_nm(String family_nm) {
		this.family_nm = family_nm;
	}
	public String getGiven_nm() {
		return given_nm;
	}
	public void setGiven_nm(String given_nm) {
		this.given_nm = given_nm;
	}
	public String getId_number1() {
		return id_number1;
	}
	public void setId_number1(String id_number1) {
		this.id_number1 = id_number1;
	}
	public String getId_number2() {
		return id_number2;
	}
	public void setId_number2(String id_number2) {
		this.id_number2 = id_number2;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCtry_cd() {
		return ctry_cd;
	}
	public void setCtry_cd(String ctry_cd) {
		this.ctry_cd = ctry_cd;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public String getTel_no_1() {
		return tel_no_1;
	}
	public void setTel_no_1(String tel_no_1) {
		this.tel_no_1 = tel_no_1;
	}
	public String getTel_no_2() {
		return tel_no_2;
	}
	public void setTel_no_2(String tel_no_2) {
		this.tel_no_2 = tel_no_2;
	}
	public String getTel_no_3() {
		return tel_no_3;
	}
	public void setTel_no_3(String tel_no_3) {
		this.tel_no_3 = tel_no_3;
	}
	public String getMobile_no_1() {
		return mobile_no_1;
	}
	public void setMobile_no_1(String mobile_no_1) {
		this.mobile_no_1 = mobile_no_1;
	}
	public String getMobile_no_2() {
		return mobile_no_2;
	}
	public void setMobile_no_2(String mobile_no_2) {
		this.mobile_no_2 = mobile_no_2;
	}
	public String getMobile_no_3() {
		return mobile_no_3;
	}
	public void setMobile_no_3(String mobile_no_3) {
		this.mobile_no_3 = mobile_no_3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBank_cd() {
		return bank_cd;
	}
	public void setBank_cd(String bank_cd) {
		this.bank_cd = bank_cd;
	}
	public String getBank_acc_no() {
		return bank_acc_no;
	}
	public void setBank_acc_no(String bank_acc_no) {
		this.bank_acc_no = bank_acc_no;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_dtl() {
		return address_dtl;
	}
	public void setAddress_dtl(String address_dtl) {
		this.address_dtl = address_dtl;
	}
	public String getRecu_sec() {
		return recu_sec;
	}
	public void setRecu_sec(String recu_sec) {
		this.recu_sec = recu_sec;
	}
	public String getOccu_cd() {
		return occu_cd;
	}
	public void setOccu_cd(String occu_cd) {
		this.occu_cd = occu_cd;
	}
	public String getEtc_occu_nm() {
		return etc_occu_nm;
	}
	public void setEtc_occu_nm(String etc_occu_nm) {
		this.etc_occu_nm = etc_occu_nm;
	}
	public String getComp_nm() {
		return comp_nm;
	}
	public void setComp_nm(String comp_nm) {
		this.comp_nm = comp_nm;
	}
	public String getUniv_cd() {
		return univ_cd;
	}
	public void setUniv_cd(String univ_cd) {
		this.univ_cd = univ_cd;
	}
	public String getSchool_nm() {
		return school_nm;
	}
	public void setSchool_nm(String school_nm) {
		this.school_nm = school_nm;
	}
	public String getUniv_dept_nm() {
		return univ_dept_nm;
	}
	public void setUniv_dept_nm(String univ_dept_nm) {
		this.univ_dept_nm = univ_dept_nm;
	}
	public String getPrefer_job1_cd() {
		return prefer_job1_cd;
	}
	public void setPrefer_job1_cd(String prefer_job1_cd) {
		this.prefer_job1_cd = prefer_job1_cd;
	}
	public String getPrefer_job1_spec_yn() {
		return prefer_job1_spec_yn;
	}
	public void setPrefer_job1_spec_yn(String prefer_job1_spec_yn) {
		this.prefer_job1_spec_yn = prefer_job1_spec_yn;
	}
	public String getPrefer_job1_spec_nm() {
		return prefer_job1_spec_nm;
	}
	public void setPrefer_job1_spec_nm(String prefer_job1_spec_nm) {
		this.prefer_job1_spec_nm = prefer_job1_spec_nm;
	}
	public String getPrefer_job1_license_yn() {
		return prefer_job1_license_yn;
	}
	public void setPrefer_job1_license_yn(String prefer_job1_license_yn) {
		this.prefer_job1_license_yn = prefer_job1_license_yn;
	}
	public String getPrefer_job1_license_nm() {
		return prefer_job1_license_nm;
	}
	public void setPrefer_job1_license_nm(String prefer_job1_license_nm) {
		this.prefer_job1_license_nm = prefer_job1_license_nm;
	}
	public String getPrefer_job2_cd() {
		return prefer_job2_cd;
	}
	public void setPrefer_job2_cd(String prefer_job2_cd) {
		this.prefer_job2_cd = prefer_job2_cd;
	}
	public String getPrefer_job2_spec_yn() {
		return prefer_job2_spec_yn;
	}
	public void setPrefer_job2_spec_yn(String prefer_job2_spec_yn) {
		this.prefer_job2_spec_yn = prefer_job2_spec_yn;
	}
	public String getPrefer_job2_spec_nm() {
		return prefer_job2_spec_nm;
	}
	public void setPrefer_job2_spec_nm(String prefer_job2_spec_nm) {
		this.prefer_job2_spec_nm = prefer_job2_spec_nm;
	}
	public String getPrefer_job2_license_yn() {
		return prefer_job2_license_yn;
	}
	public void setPrefer_job2_license_yn(String prefer_job2_license_yn) {
		this.prefer_job2_license_yn = prefer_job2_license_yn;
	}
	public String getPrefer_job2_license_nm() {
		return prefer_job2_license_nm;
	}
	public void setPrefer_job2_license_nm(String prefer_job2_license_nm) {
		this.prefer_job2_license_nm = prefer_job2_license_nm;
	}
	public String getLang1_cd() {
		return lang1_cd;
	}
	public void setLang1_cd(String lang1_cd) {
		this.lang1_cd = lang1_cd;
	}
	public String getLang1_etc() {
		return lang1_etc;
	}
	public void setLang1_etc(String lang1_etc) {
		this.lang1_etc = lang1_etc;
	}
	public String getLang1_lvl_cd() {
		return lang1_lvl_cd;
	}
	public void setLang1_lvl_cd(String lang1_lvl_cd) {
		this.lang1_lvl_cd = lang1_lvl_cd;
	}
	public String getLang1_ctry_cd() {
		return lang1_ctry_cd;
	}
	public void setLang1_ctry_cd(String lang1_ctry_cd) {
		this.lang1_ctry_cd = lang1_ctry_cd;
	}
	public String getLang1_residence() {
		return lang1_residence;
	}
	public void setLang1_residence(String lang1_residence) {
		this.lang1_residence = lang1_residence;
	}
	public String getLang2_cd() {
		return lang2_cd;
	}
	public void setLang2_cd(String lang2_cd) {
		this.lang2_cd = lang2_cd;
	}
	public String getLang2_etc() {
		return lang2_etc;
	}
	public void setLang2_etc(String lang2_etc) {
		this.lang2_etc = lang2_etc;
	}
	public String getLang2_lvl_cd() {
		return lang2_lvl_cd;
	}
	public void setLang2_lvl_cd(String lang2_lvl_cd) {
		this.lang2_lvl_cd = lang2_lvl_cd;
	}
	public String getLang2_ctry_cd() {
		return lang2_ctry_cd;
	}
	public void setLang2_ctry_cd(String lang2_ctry_cd) {
		this.lang2_ctry_cd = lang2_ctry_cd;
	}
	public String getLang2_residence() {
		return lang2_residence;
	}
	public void setLang2_residence(String lang2_residence) {
		this.lang2_residence = lang2_residence;
	}
	public String getLang3_cd() {
		return lang3_cd;
	}
	public void setLang3_cd(String lang3_cd) {
		this.lang3_cd = lang3_cd;
	}
	public String getLang3_etc() {
		return lang3_etc;
	}
	public void setLang3_etc(String lang3_etc) {
		this.lang3_etc = lang3_etc;
	}
	public String getLang3_lvl_cd() {
		return lang3_lvl_cd;
	}
	public void setLang3_lvl_cd(String lang3_lvl_cd) {
		this.lang3_lvl_cd = lang3_lvl_cd;
	}
	public String getLang3_ctry_cd() {
		return lang3_ctry_cd;
	}
	public void setLang3_ctry_cd(String lang3_ctry_cd) {
		this.lang3_ctry_cd = lang3_ctry_cd;
	}
	public String getLang3_residence() {
		return lang3_residence;
	}
	public void setLang3_residence(String lang3_residence) {
		this.lang3_residence = lang3_residence;
	}
	public String getAvail_work_cd() {
		return avail_work_cd;
	}
	public void setAvail_work_cd(String avail_work_cd) {
		this.avail_work_cd = avail_work_cd;
	}
	public String getEvent1_nm() {
		return event1_nm;
	}
	public void setEvent1_nm(String event1_nm) {
		this.event1_nm = event1_nm;
	}
	public String getEvent1_activity() {
		return event1_activity;
	}
	public void setEvent1_activity(String event1_activity) {
		this.event1_activity = event1_activity;
	}
	public String getEvent1_activity_mm() {
		return event1_activity_mm;
	}
	public void setEvent1_activity_mm(String event1_activity_mm) {
		this.event1_activity_mm = event1_activity_mm;
	}
	public String getEvent1_activity_dd() {
		return event1_activity_dd;
	}
	public void setEvent1_activity_dd(String event1_activity_dd) {
		this.event1_activity_dd = event1_activity_dd;
	}
	public String getEvent2_nm() {
		return event2_nm;
	}
	public void setEvent2_nm(String event2_nm) {
		this.event2_nm = event2_nm;
	}
	public String getEvent2_activity() {
		return event2_activity;
	}
	public void setEvent2_activity(String event2_activity) {
		this.event2_activity = event2_activity;
	}
	public String getEvent2_activity_mm() {
		return event2_activity_mm;
	}
	public void setEvent2_activity_mm(String event2_activity_mm) {
		this.event2_activity_mm = event2_activity_mm;
	}
	public String getEvent2_activity_dd() {
		return event2_activity_dd;
	}
	public void setEvent2_activity_dd(String event2_activity_dd) {
		this.event2_activity_dd = event2_activity_dd;
	}
	public String getEvent3_nm() {
		return event3_nm;
	}
	public void setEvent3_nm(String event3_nm) {
		this.event3_nm = event3_nm;
	}
	public String getEvent3_activity() {
		return event3_activity;
	}
	public void setEvent3_activity(String event3_activity) {
		this.event3_activity = event3_activity;
	}
	public String getEvent3_activity_mm() {
		return event3_activity_mm;
	}
	public void setEvent3_activity_mm(String event3_activity_mm) {
		this.event3_activity_mm = event3_activity_mm;
	}
	public String getEvent3_activity_dd() {
		return event3_activity_dd;
	}
	public void setEvent3_activity_dd(String event3_activity_dd) {
		this.event3_activity_dd = event3_activity_dd;
	}
	public String getUni_shirts_cd() {
		return uni_shirts_cd;
	}
	public void setUni_shirts_cd(String uni_shirts_cd) {
		this.uni_shirts_cd = uni_shirts_cd;
	}
	public String getUni_waist_cd() {
		return uni_waist_cd;
	}
	public void setUni_waist_cd(String uni_waist_cd) {
		this.uni_waist_cd = uni_waist_cd;
	}
	public String getUni_cap_cd() {
		return uni_cap_cd;
	}
	public void setUni_cap_cd(String uni_cap_cd) {
		this.uni_cap_cd = uni_cap_cd;
	}
	public String getUni_shoes_cd() {
		return uni_shoes_cd;
	}
	public void setUni_shoes_cd(String uni_shoes_cd) {
		this.uni_shoes_cd = uni_shoes_cd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDept_target_yn() {
		return dept_target_yn;
	}
	public void setDept_target_yn(String dept_target_yn) {
		this.dept_target_yn = dept_target_yn;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getGroup_cd() {
		return group_cd;
	}
	public void setGroup_cd(String group_cd) {
		this.group_cd = group_cd;
	}
	public String getSports_cd() {
		return sports_cd;
	}
	public void setSports_cd(String sports_cd) {
		this.sports_cd = sports_cd;
	}
	public String getDiscipline_cd() {
		return discipline_cd;
	}
	public void setDiscipline_cd(String discipline_cd) {
		this.discipline_cd = discipline_cd;
	}
	public String getVenue_cd() {
		return venue_cd;
	}
	public void setVenue_cd(String venue_cd) {
		this.venue_cd = venue_cd;
	}
	public String getLocal_nm() {
		return local_nm;
	}
	public void setLocal_nm(String local_nm) {
		this.local_nm = local_nm;
	}
	public String getEng_nm() {
		return eng_nm;
	}
	public void setEng_nm(String eng_nm) {
		this.eng_nm = eng_nm;
	}
	public String getCtry_nm() {
		return ctry_nm;
	}
	public void setCtry_nm(String ctry_nm) {
		this.ctry_nm = ctry_nm;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getBank_nm() {
		return bank_nm;
	}
	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}
	public String getRecu_sec_nm() {
		return recu_sec_nm;
	}
	public void setRecu_sec_nm(String recu_sec_nm) {
		this.recu_sec_nm = recu_sec_nm;
	}
	public String getOccu_nm() {
		return occu_nm;
	}
	public void setOccu_nm(String occu_nm) {
		this.occu_nm = occu_nm;
	}
	public String getUniv_nm() {
		return univ_nm;
	}
	public void setUniv_nm(String univ_nm) {
		this.univ_nm = univ_nm;
	}
	public String getPrefer_job1_nm() {
		return prefer_job1_nm;
	}
	public void setPrefer_job1_nm(String prefer_job1_nm) {
		this.prefer_job1_nm = prefer_job1_nm;
	}
	public String getPrefer_job2_nm() {
		return prefer_job2_nm;
	}
	public void setPrefer_job2_nm(String prefer_job2_nm) {
		this.prefer_job2_nm = prefer_job2_nm;
	}
	public String getLang1_nm() {
		return lang1_nm;
	}
	public void setLang1_nm(String lang1_nm) {
		this.lang1_nm = lang1_nm;
	}
	public String getLang1_lvl_nm() {
		return lang1_lvl_nm;
	}
	public void setLang1_lvl_nm(String lang1_lvl_nm) {
		this.lang1_lvl_nm = lang1_lvl_nm;
	}
	public String getLang1_ctry_nm() {
		return lang1_ctry_nm;
	}
	public void setLang1_ctry_nm(String lang1_ctry_nm) {
		this.lang1_ctry_nm = lang1_ctry_nm;
	}
	public String getLang2_nm() {
		return lang2_nm;
	}
	public void setLang2_nm(String lang2_nm) {
		this.lang2_nm = lang2_nm;
	}
	public String getLang2_lvl_nm() {
		return lang2_lvl_nm;
	}
	public void setLang2_lvl_nm(String lang2_lvl_nm) {
		this.lang2_lvl_nm = lang2_lvl_nm;
	}
	public String getLang2_ctry_nm() {
		return lang2_ctry_nm;
	}
	public void setLang2_ctry_nm(String lang2_ctry_nm) {
		this.lang2_ctry_nm = lang2_ctry_nm;
	}
	public String getLang3_nm() {
		return lang3_nm;
	}
	public void setLang3_nm(String lang3_nm) {
		this.lang3_nm = lang3_nm;
	}
	public String getLang3_lvl_nm() {
		return lang3_lvl_nm;
	}
	public void setLang3_lvl_nm(String lang3_lvl_nm) {
		this.lang3_lvl_nm = lang3_lvl_nm;
	}
	public String getLang3_ctry_nm() {
		return lang3_ctry_nm;
	}
	public void setLang3_ctry_nm(String lang3_ctry_nm) {
		this.lang3_ctry_nm = lang3_ctry_nm;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getGroup_nm() {
		return group_nm;
	}
	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}
	public String getLink_page() {
		return link_page;
	}
	public void setLink_page(String link_page) {
		this.link_page = link_page;
	}
	public String getSearch_regi_no_to() {
		return search_regi_no_to;
	}
	public void setSearch_regi_no_to(String search_regi_no_to) {
		this.search_regi_no_to = search_regi_no_to;
	}
	public String getSearch_comp_yn() {
		return search_comp_yn;
	}
	public void setSearch_comp_yn(String search_comp_yn) {
		this.search_comp_yn = search_comp_yn;
	}
	public String getSearch_educ_no() {
		return search_educ_no;
	}
	public void setSearch_educ_no(String search_educ_no) {
		this.search_educ_no = search_educ_no;
	}
	public String getSearch_alloc_yn() {
		return search_alloc_yn;
	}
	public void setSearch_alloc_yn(String search_alloc_yn) {
		this.search_alloc_yn = search_alloc_yn;
	}
	public String getSearch_educ_fg() {
		return search_educ_fg;
	}
	public void setSearch_educ_fg(String search_educ_fg) {
		this.search_educ_fg = search_educ_fg;
	}
	public String getSearch_ceremony_yn() {
		return search_ceremony_yn;
	}
	public void setSearch_ceremony_yn(String search_ceremony_yn) {
		this.search_ceremony_yn = search_ceremony_yn;
	}
	public String getSearch_educ_fg_yn() {
		return search_educ_fg_yn;
	}
	public void setSearch_educ_fg_yn(String search_educ_fg_yn) {
		this.search_educ_fg_yn = search_educ_fg_yn;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getEmail_vendor() {
		return email_vendor;
	}
	public void setEmail_vendor(String email_vendor) {
		this.email_vendor = email_vendor;
	}
	public String getEtc_school_nm() {
		return etc_school_nm;
	}
	public void setEtc_school_nm(String etc_school_nm) {
		this.etc_school_nm = etc_school_nm;
	}
	public String getUniv_stat() {
		return univ_stat;
	}
	public void setUniv_stat(String univ_stat) {
		this.univ_stat = univ_stat;
	}
	public String getAny_job_yn() {
		return any_job_yn;
	}
	public void setAny_job_yn(String any_job_yn) {
		this.any_job_yn = any_job_yn;
	}
	public String getAvail_location_cd() {
		return avail_location_cd;
	}
	public void setAvail_location_cd(String avail_location_cd) {
		this.avail_location_cd = avail_location_cd;
	}
	public List<Object> getDataList() {
		return dataList;
	}
	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
	public String getCtry_cd_fg() {
		return ctry_cd_fg;
	}
	public void setCtry_cd_fg(String ctry_cd_fg) {
		this.ctry_cd_fg = ctry_cd_fg;
	}
	public String getSearch_dept_target_yn() {
		return search_dept_target_yn;
	}
	public void setSearch_dept_target_yn(String search_dept_target_yn) {
		this.search_dept_target_yn = search_dept_target_yn;
	}
	public String getEmail_sel() {
		return email_sel;
	}
	public void setEmail_sel(String email_sel) {
		this.email_sel = email_sel;
	}
	public String getOnline_yn() {
		return online_yn;
	}
	public void setOnline_yn(String online_yn) {
		this.online_yn = online_yn;
	}
	public String getSearch_online_yn() {
		return search_online_yn;
	}
	public void setSearch_online_yn(String search_online_yn) {
		this.search_online_yn = search_online_yn;
	}
	public String getPhoto_flag() {
		return photo_flag;
	}
	public void setPhoto_flag(String photo_flag) {
		this.photo_flag = photo_flag;
	}
	public String getStr_regi_no() {
		return str_regi_no;
	}
	public void setStr_regi_no(String str_regi_no) {
		this.str_regi_no = str_regi_no;
	}
	public String getDuplicate_check_yn() {
		return duplicate_check_yn;
	}
	public void setDuplicate_check_yn(String duplicate_check_yn) {
		this.duplicate_check_yn = duplicate_check_yn;
	}
	public String getOrg_cd() {
		return org_cd;
	}
	public void setOrg_cd(String org_cd) {
		this.org_cd = org_cd;
	}
	public String getEtc_org_nm() {
		return etc_org_nm;
	}
	public void setEtc_org_nm(String etc_org_nm) {
		this.etc_org_nm = etc_org_nm;
	}
	public String getSystem_cd() {
		return system_cd;
	}
	public void setSystem_cd(String system_cd) {
		this.system_cd = system_cd;
	}
	public String getStatus_fg() {
		return status_fg;
	}
	public void setStatus_fg(String status_fg) {
		this.status_fg = status_fg;
	}
	public String getEntry_yn() {
		return entry_yn;
	}
	public void setEntry_yn(String entry_yn) {
		this.entry_yn = entry_yn;
	}
	public String getPre_category_cd() {
		return pre_category_cd;
	}
	public void setPre_category_cd(String pre_category_cd) {
		this.pre_category_cd = pre_category_cd;
	}
	public String getPre_org_cd() {
		return pre_org_cd;
	}
	public void setPre_org_cd(String pre_org_cd) {
		this.pre_org_cd = pre_org_cd;
	}
	public String getPre_function_cd() {
		return pre_function_cd;
	}
	public void setPre_function_cd(String pre_function_cd) {
		this.pre_function_cd = pre_function_cd;
	}
	public String getPre_card_type() {
		return pre_card_type;
	}
	public void setPre_card_type(String pre_card_type) {
		this.pre_card_type = pre_card_type;
	}
	public String getPre_family_nm() {
		return pre_family_nm;
	}
	public void setPre_family_nm(String pre_family_nm) {
		this.pre_family_nm = pre_family_nm;
	}
	public String getPre_given_nm() {
		return pre_given_nm;
	}
	public void setPre_given_nm(String pre_given_nm) {
		this.pre_given_nm = pre_given_nm;
	}
	public String getPre_eng_nm2() {
		return pre_eng_nm2;
	}
	public void setPre_eng_nm2(String pre_eng_nm2) {
		this.pre_eng_nm2 = pre_eng_nm2;
	}
	public String getPre_eng_nm3() {
		return pre_eng_nm3;
	}
	public void setPre_eng_nm3(String pre_eng_nm3) {
		this.pre_eng_nm3 = pre_eng_nm3;
	}
	public String getPre_eng_nm4() {
		return pre_eng_nm4;
	}
	public void setPre_eng_nm4(String pre_eng_nm4) {
		this.pre_eng_nm4 = pre_eng_nm4;
	}
	public String getPre_local_family_nm() {
		return pre_local_family_nm;
	}
	public void setPre_local_family_nm(String pre_local_family_nm) {
		this.pre_local_family_nm = pre_local_family_nm;
	}
	public String getPre_local_given_nm() {
		return pre_local_given_nm;
	}
	public void setPre_local_given_nm(String pre_local_given_nm) {
		this.pre_local_given_nm = pre_local_given_nm;
	}
	public String getPre_prefer_family_nm() {
		return pre_prefer_family_nm;
	}
	public void setPre_prefer_family_nm(String pre_prefer_family_nm) {
		this.pre_prefer_family_nm = pre_prefer_family_nm;
	}
	public String getPre_prefer_given_nm() {
		return pre_prefer_given_nm;
	}
	public void setPre_prefer_given_nm(String pre_prefer_given_nm) {
		this.pre_prefer_given_nm = pre_prefer_given_nm;
	}
	public String getPre_gender() {
		return pre_gender;
	}
	public void setPre_gender(String pre_gender) {
		this.pre_gender = pre_gender;
	}
	public String getPre_birth_dt() {
		return pre_birth_dt;
	}
	public void setPre_birth_dt(String pre_birth_dt) {
		this.pre_birth_dt = pre_birth_dt;
	}
	public String getPre_born_ctry_cd() {
		return pre_born_ctry_cd;
	}
	public void setPre_born_ctry_cd(String pre_born_ctry_cd) {
		this.pre_born_ctry_cd = pre_born_ctry_cd;
	}
	public String getPre_passport_ctry_cd() {
		return pre_passport_ctry_cd;
	}
	public void setPre_passport_ctry_cd(String pre_passport_ctry_cd) {
		this.pre_passport_ctry_cd = pre_passport_ctry_cd;
	}
	public String getPre_passport_no() {
		return pre_passport_no;
	}
	public void setPre_passport_no(String pre_passport_no) {
		this.pre_passport_no = pre_passport_no;
	}
	public String getPre_passport_expiry_dt() {
		return pre_passport_expiry_dt;
	}
	public void setPre_passport_expiry_dt(String pre_passport_expiry_dt) {
		this.pre_passport_expiry_dt = pre_passport_expiry_dt;
	}
	public String getPre_working_area1_cd() {
		return pre_working_area1_cd;
	}
	public void setPre_working_area1_cd(String pre_working_area1_cd) {
		this.pre_working_area1_cd = pre_working_area1_cd;
	}
	public String getPre_working_area2_cd() {
		return pre_working_area2_cd;
	}
	public void setPre_working_area2_cd(String pre_working_area2_cd) {
		this.pre_working_area2_cd = pre_working_area2_cd;
	}
	public String getPre_working_area3_cd() {
		return pre_working_area3_cd;
	}
	public void setPre_working_area3_cd(String pre_working_area3_cd) {
		this.pre_working_area3_cd = pre_working_area3_cd;
	}
	public String getPre_working_area4_cd() {
		return pre_working_area4_cd;
	}
	public void setPre_working_area4_cd(String pre_working_area4_cd) {
		this.pre_working_area4_cd = pre_working_area4_cd;
	}
	public String getPre_working_area5_cd() {
		return pre_working_area5_cd;
	}
	public void setPre_working_area5_cd(String pre_working_area5_cd) {
		this.pre_working_area5_cd = pre_working_area5_cd;
	}
	public String getPre_working_area6_cd() {
		return pre_working_area6_cd;
	}
	public void setPre_working_area6_cd(String pre_working_area6_cd) {
		this.pre_working_area6_cd = pre_working_area6_cd;
	}
	public String getPre_sport1_cd() {
		return pre_sport1_cd;
	}
	public void setPre_sport1_cd(String pre_sport1_cd) {
		this.pre_sport1_cd = pre_sport1_cd;
	}
	public String getPre_sport2_cd() {
		return pre_sport2_cd;
	}
	public void setPre_sport2_cd(String pre_sport2_cd) {
		this.pre_sport2_cd = pre_sport2_cd;
	}
	public String getPre_sport3_cd() {
		return pre_sport3_cd;
	}
	public void setPre_sport3_cd(String pre_sport3_cd) {
		this.pre_sport3_cd = pre_sport3_cd;
	}
	public String getPre_access_area_cd() {
		return pre_access_area_cd;
	}
	public void setPre_access_area_cd(String pre_access_area_cd) {
		this.pre_access_area_cd = pre_access_area_cd;
	}
	public String getPre_access_area_nm() {
		return pre_access_area_nm;
	}
	public void setPre_access_area_nm(String pre_access_area_nm) {
		this.pre_access_area_nm = pre_access_area_nm;
	}
	public String getPre_status_fg() {
		return pre_status_fg;
	}
	public void setPre_status_fg(String pre_status_fg) {
		this.pre_status_fg = pre_status_fg;
	}
	public List<Object> getTovList() {
		return tovList;
	}
	public void setTovList(List<Object> tovList) {
		this.tovList = tovList;
	}
	public List<Object> getPdList() {
		return pdList;
	}
	public void setPdList(List<Object> pdList) {
		this.pdList = pdList;
	}
	public List<Object> getLsList() {
		return lsList;
	}
	public void setLsList(List<Object> lsList) {
		this.lsList = lsList;
	}
	public List<Object> getAdList() {
		return adList;
	}
	public void setAdList(List<Object> adList) {
		this.adList = adList;
	}
	public List<Object> getAreaTypeList() {
		return areaTypeList;
	}
	public void setAreaTypeList(List<Object> areaTypeList) {
		this.areaTypeList = areaTypeList;
	}
	public List<Object> getCountryNoList() {
		return countryNoList;
	}
	public void setCountryNoList(List<Object> countryNoList) {
		this.countryNoList = countryNoList;
	}
	public List<Object> getAccessAreaList() {
		return accessAreaList;
	}
	public void setAccessAreaList(List<Object> accessAreaList) {
		this.accessAreaList = accessAreaList;
	}
	public String[] getChk_ad_no() {
		return chk_ad_no;
	}
	public void setChk_ad_no(String[] chk_ad_no) {
		if(chk_ad_no == null){
			this.chk_ad_no = new String[0];
		}else{
			this.chk_ad_no = Arrays.copyOf(chk_ad_no, chk_ad_no.length);
		}
	}
	public String[] getChk_approve_yn() {
		return chk_approve_yn;
	}
	public void setChk_approve_yn(String[] chk_approve_yn) {
		if(chk_approve_yn == null){
			this.chk_approve_yn = new String[0];
		}else{
			this.chk_approve_yn = Arrays.copyOf(chk_approve_yn, chk_approve_yn.length);
		}
	}
	public String[] getChk() {
		return chk;
	}
	public void setChk(String[] chk) {
		if(chk == null){
			this.chk = new String[0];
		}else{
			this.chk = Arrays.copyOf(chk, chk.length);
		}
	}
	public String[] getChk_status() {
		return chk_status;
	}
	public void setChk_status(String[] chk_status) {
		if(chk_status == null){
			this.chk_status = new String[0];
		}else{
			this.chk_status = Arrays.copyOf(chk_status, chk_status.length);
		}
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getPhoto_fg() {
		return photo_fg;
	}
	public void setPhoto_fg(String photo_fg) {
		this.photo_fg = photo_fg;
	}
	public String getFacephoto() {
		return facephoto;
	}
	public void setFacephoto(String facephoto) {
		this.facephoto = facephoto;
	}
	public String getBodyphoto() {
		return bodyphoto;
	}
	public void setBodyphoto(String bodyphoto) {
		this.bodyphoto = bodyphoto;
	}
	public String getSkillFile_nm() {
		return skillFile_nm;
	}
	public void setSkillFile_nm(String skillFile_nm) {
		this.skillFile_nm = skillFile_nm;
	}
	public String getDownFile_nm() {
		return downFile_nm;
	}
	public void setDownFile_nm(String downFile_nm) {
		this.downFile_nm = downFile_nm;
	}
}
