<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
<form:form name='frm'>
	<div class="contents_wrap_01">
			<div class="contents_top">
				<div class="con_title">dddd</div>
				<ul class="con_location">
					<li>a</li>
					<li>b</li>
					<li>c</li>
				</ul>
			</div>
		<div class="contents">
			<form:form commandName="svmVolVo" name="svmVolVo" id="svmVolVo"  method="post" enctype="multipart/form-data">
			<form:hidden path="cmd"/>
			<form:hidden path="kind" />
			<form:hidden path="duplicate_check_yn" />
			<form:hidden path="search_discipline_cd" />
			<form:hidden path="search_ctry_cd" />
			<form:hidden path="search_ctry_cd_fg" />
			<form:hidden path="search_ad_no" />
			<form:hidden path="search_status_fg" />
			<form:hidden path="search_recu_sec" />
			<form:hidden path="search_local_nm" />
			<form:hidden path="search_group_nm" />
			<form:hidden path="search_dept_target_yn" />
			<form:hidden path="search_dept_cd" />
			<form:hidden path="search_avail_location_cd" />
			<form:hidden path="search_prefer_job_cd" />
			<form:hidden path="search_lang_cd" />
			<form:hidden path="search_avail_work_cd" />
			<form:hidden path="search_online_yn" />
			<form:hidden path="search_prefer_job_cd2" />
			<form:hidden path="search_lang_lvl_cd" />
			<form:hidden path="search_sports_cd" />
			<form:hidden path="search_venue_cd" />
			<form:hidden path="search_gender" />
			<form:hidden path="search_foreign_yn" />
			<form:hidden path="search_bank_acc_no_yn" />
			<form:hidden path="search_photo_yn" />
			<form:hidden path="search_aimag_yn" />
			<form:hidden path="search_mobile_no" />
			<form:hidden path="search_orderby" />
			 
			<form:hidden path="search_ad_no_to" />
			<form:hidden path="search_comp_yn" />
			<form:hidden path="search_educ_no" />
			<form:hidden path="search_alloc_yn" />
			<form:hidden path="search_educ_fg" />
			<form:hidden path="search_ceremony_yn" />
			<form:hidden path="search_educ_fg_yn" />
			<form:hidden path="link_page" />
			 
			<!-- 필요한 값 체크  -->
			<select name="dept_cd" id="dept_cd" class="select_01" style="width:230px;" title="">
			</select>
			<select name="discipline_cd" id="discipline_cd" class="select_01" style="width:230px;" title="">
			</select>
			<select name="venue_cd" id="venue_cd" class="select_01" style="width:230px;" title="">
			</select>
			<div name="gender" id="gender" style="width:230px;" title="">
			</div>
			<select name="ctry_cd_fg" id="ctry_cd_fg" class="select_01" style="width:230px;" title="">
			</select>
			<select name="ctry_cd" id="ctry_cd" class="select_01" style="width:230px;" title="">
			</select>
			
			<input type="radio" id="chk_gender_01" class="radio_01" name="chk_gender" value="M" checked><label>Male</label>
			<input type="radio" id="chk_gender_02" class="radio_01" name="chk_gender" value="W" ><label>Female</label>
			
			<dt class="cell_03">
									<strong><spring:message code="svm.header.photo"/><span class="must_01"></span></strong>
								</dt>
								<dd class="">
									<strong>
										<div class="upload_01" style="width:260px;">
<!-- 											<input type="file" id="u_01"><label for="u_01" title="upload">upload</label> -->
											<input type="file" id="file_photo" name="file_photo" onchange="javascript:{onChangeSelectFile(this);};" ><label for="file_photo" title="upload">upload</label>
										</div>
										<span class="txt_02">100~2048Kb</span>
										<div class="photoTool">
											<a href="#link" class="btn_icon_03" onClick="funDownloadImage('photo');">forder</a>
											<a href="#link" class="btn_icon_04" onClick="funDeleteImage('photo');">trash</a>
										</div>
									</strong>
								</dd>
								<dd class="">
							<strong>
								<div class="upload_01" style="width:260px;">
									<input type="file" id="file_passport" name="file_passport" onchange="javascript:{onChangeSelectFile(this);};" ><label for="file_passport" title="upload">upload</label>
								</div>
								<span class="txt_02">100~2048Kb</span>
								<a href="#link" class="btn_icon_02 passportTool" onClick="funOpenPassportLayerPopup();" >add</a>
								<a href="#link" class="btn_icon_03 passportTool" onClick="funDownloadImage('passport');">forder</a>
								<a href="#link" class="btn_icon_04 passportTool" onClick="funDeleteImage('passport');">trash</a>
							</strong>
						</dd>
			<!-- START  기존 	Application.jsp  양식 폼 -->
			
			</form:form>

				</div>
			</div>
			
</form:form>



<script>
$(document).ready(function(){
	//radio value setting
	//값세팅 대상 radio 값 가져온 후 공통 function 호출하여 세팅
	//setRadioCheckValue(radioName, value)
	var gender ='<c:out value="${svmVolVo.gender}"/>';
	setRadioCheckValue('gender', gender);
	
	// radio change 이벤트
	$("input[name=gender]").change(function(){
		var value = $(this).val();
		$("#gender").val($(this).val());
	});
	
	
	var result = ${svmVolVo.result};
	Combo({
		data		: result,
		code_find	: 'DEPT_CD', //serviceImpl 값
		name		: 'dept_cd', //셋팅해줄 셀렉터
		selectCond	: 'search_dept_cd', //VO
		blankCond	: ''
	}); 
	Combo2({
		data		: result,
		code_find	: 'DISCIPLINE_CD',
		name		: 'discipline_cd', 
		selectCond	: 'search_discipline_cd', 
		blankCond	: ''
	}); 
	
	Combo({
		data		: result,
		code_find	: 'VENUE_CD',
		name		: 'venue_cd', 
		selectCond	: 'search_venue_cd', 
		blankCond	: ''
	}); 
	
	Radio({
		data		: result,
		code_find	: 'GENDER',
		name		: 'gender', 
		selectCond	: 'search_gender', 
		blankCond	: '',
		area		: 'gender',
		styleClass	: 'radio_01'
	}); 
	
	Combo({
		data		: result,
		code_find	: 'CTRY_CD_FG',
		name		: 'ctry_cd_fg', 
		selectCond	: 'search_ctry_cd_fg', 
		blankCond	: ''
	}); 
	
	Combo({
		data		: result,
		code_find	: 'CTRY_CD',
		name		: 'ctry_cd', 
		selectCond	: 'search_ctry_cd', 
		blankCond	: ''
	}); 
	
	
// 	SubCombo2({
// 		data		: result,
// 		code_find	: 'FUNCTION_CD',
// 		name		: 'sel_search_function_cd',
// 		selectCond	: 'search_function_cd',
// 		base_target	: 'sel_search_category_cd',
// 		follower	: 'CODE_IDX1',
// 		blankCond 	: 'All..'
// 	});
	
// 	SubComboToOrg({
// 		data		: result,
// 		code_find	: 'ORG_CD',
// 		name		: 'sel_search_org_cd',
// 		selectCond	: 'search_org_cd',
// 		base_target	: 'sel_search_category_cd',
// 		follower	: 'CATEGORY_CD',
// 		blankCond 	: 'All..'
// 	});
	
// 	Combo({
// 		data		: result,
// 		code_find	: 'CTRY_CD',
// 		name		: 'sel_search_ctry_cd',
// 		selectCond	: 'search_ctry_cd',
// 		blankCond	: 'All..'
// 	});
	
// 	Combo({
// 		data		: result,
// 		code_find	: 'SPORTS_CD',
// 		name		: 'sel_search_sport1_cd',
// 		selectCond	: 'search_sport1_cd',
// 		blankCond	: 'All..'
// 	});
	
// 	Combo({
// 		data		: result,
// 		code_find	: 'ONLINE_STATUS_FG',
// 		name		: 'sel_search_status_fg',
// 		selectCond	: 'search_status_fg',
// 		blankCond	: 'All..'
// 	}); 
	
});

// function Radio(map){
// 	var data = map.data; 
// 	var name = map.name;
// 	var code_find = map.code_find; 
// 	var selectCond_ref = map.selectCond;
// 	var blankCond = map.blankCond;
// 	var area = map.area;
// 	var lang = map.lang;
// 	var styleClass = map.styleClass;
	
// //	data = convertJsonType(data);
    
//     area = document.getElementById(area);
    
//     lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
    
//     var selectCond = $('input[name='+selectCond_ref+']');
    
//     if(undefined != blankCond && '' != blankCond){
//     	if('' == selectCond.val()){
//     		area.innerHTML = '<input type="radio" name="'+name+'" value="" id="'+ name +'_0"  class="'+ styleClass +'" onclick="setValue(\''+selectCond_ref+'\', this.value);" checked><label>'+blankCond+'</label>';
//     	}else{
//     		area.innerHTML = '<input type="radio" name="'+name+'" value="" id="'+ name +'_0" class="'+ styleClass +'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label>'+blankCond+'</label>';
//     	}
//     }
    
//     $.each(data[code_find], function(i, obj){
//         if(selectCond.val() == obj.minor_cd){
//     		if(lang.indexOf('ko') > -1){
//     			area.innerHTML += '<input type="radio" name="'+name+'" id="'+ name + '_' + (i*1+1) + '" class="'+ styleClass +'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);" checked><label> '+obj.CODE_NM2+'</label';
//     		}else{
//     			area.innerHTML += '<input type="radio" name="'+name+'" id="'+ name + '_' + (i*1+1) + '" class="'+ styleClass +'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);" checked><label>'+obj.CODE_NM1+'</label>';
//     		}
//         }else{
//     		if(lang.indexOf('ko') > -1){
//     			area.innerHTML += '<input type="radio" name="'+name+'" id="'+ name + '_' + (i*1+1) + '" class="'+ styleClass +'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label>'+obj.CODE_NM2+'</label>';
//     		}else{
//     			area.innerHTML += '<input type="radio" name="'+name+'" id="'+ name + '_' + (i*1+1) + '" class="'+ styleClass +'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label>'+obj.CODE_NM1+'</label>';
//     		}
//         }
        
//         if(undefined != blankCond && '' != blankCond){
//         	if((i != 0 && (i+2) % 5 == 0)){
//         		area.innerHTML += '<br/>';
//         	}
//         }else{
//         	if((i != 0 && (i+1) % 5 == 0)){
//         		area.innerHTML += '<br/>';
//         	}
//         }
//     });
    
// //     radioStyle();
// }

function radioStyle(){
	$('.radio_01, .checkbox_01').each(function(){
		var label_style = $(this).attr('style');
		var id_name = $(this).attr('id');
		var title_name = $(this).attr('title');
		var label_name = $(this).next('label').text();
		
		//console.log(label_style);
		if(label_style == undefined){
			label_style = '';
		}
		if(title_name == undefined){
			title_name = '';
		}
		$(this).next('label').replaceWith('<label for=' + id_name + ' style="'+ label_style +'" title="'+ title_name +'"><span></span>' + label_name + '</label>');
	});
}

//close
function funClose() {
	var frm = document.svmVolVo;
	var url = '<%=contextLangPath%>/svm/application/list';
	frm.cmd.value = 'list';
	location.href = getQueryStringUrl(frm, url);
}

// edit 
function funSave(){
	var frm = document.svmVolVo;
	var url = "";
	
	// 유효성 체크
// 	var retValid = $('#svmVolVo').valid();
// 	if(!retValid){
// 		return false;	
// 	}		
	
	// 유효성 체크 완료하고 저장 확인
	if (!confirm('<spring:message code="message.alert.save"/>')){
		return false;	
	}
	
	if(frm.cmd.value != 'edit'){
		url = '<%=contextLangPath%>/svm/applicationEdit/insert';
	} else {
		url = '<%=contextLangPath%>/svm/applicationEdit/update';
	}
	
	frm.action = url;
	frm.submit();
}

function onChangeSelectFile(obj) {
	// UUID 생성
	var uuid = getUUID();
	//var fileSize = getFileSize(obj);
	var fileSize = obj.size;

	var fileSizeLimit = 1024 * 1024 * 300;
//		var fileCntLimit = 5;
//		var fileCnt = $('input[name=addFile]').size();
	
	var regExp = /^.*\.(jpg|png|jpeg)$/i;
	var pattern = new RegExp(regExp);
	var result = pattern.test(obj.files[0].name);
	
	if( !result ){
		alert('<spring:message code="message.alert.unsupport_file"/>');
		return false;
	}
	if(fileSizeLimit < fileSize){
		alert('<spring:message code="svm.message.check_file_size"/>');
		return false;
	}
}

function getFileSize( fileObj ){
	var nBytes = 0,
	oFiles = fileObj.files;
	nFiles = oFiles.length;
	
	for (var nFileId = 0; nFileId < nFiles; nFileId++) {
		nBytes += oFiles[nFileId].size;
	}
	return nBytes;
}


function funOpenPassportLayerPopup(){
	// layer popup 
	toggleLayer($('.layer_01'), 'on');
}

function funOpenAgreeLayerPopup(){
	// layer popup 
	toggleLayer($('.layer_02'), 'on');
}

// Download Image (photo, passport) 
function funDownloadImage(imageNm){
	var frm = document.svmVolVo;
	frm.imageNm.value = imageNm;
	frm.action = '<%=contextLangPath%>/svm/application/downloadImage';
	frm.submit();
}

// Delete Image (photo, passport)
function funDeleteImage(imageNm){
	var frm = document.svmVolVo;
	
	if (!confirm('<spring:message code="message.alert.delete"/>')){
		return false;	// 종료
	} 
	
	// ajax
	sendRequest({
  		action: '<%=contextLangPath%>/svm/applicationImage/deleteImage',
  		params:{
  			ad_no 	: frm.ad_no.value,
  			imageNm : imageNm
  		},
  		callbackFunc:function(resData){
  			alert('<spring:message code="svm.message.success.deleteImage"/>');
  			
  			if(imageNm == 'passport'){
  				$(".passportTool").hide();
  				frm.passphoto_yn.value = 'N';
  			} else if(imageNm == 'photo'){
  				$("#photoImg").attr("src", "");
  				$(".photoTool").hide();
  				frm.photo_yn.value = 'N';
  			}
  		}
  	});
}

</script>
