<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
	
<div class="contents_wrap_01 contents_support_01">
		<div class="contents_top">
			<div class="con_title"><spring:message code="svm.title.application" /> </div>
			<ul class="con_location">
				<li><spring:message code="svm.title.home"/></li>
				<li><spring:message code="svm.title.application" /></li>
			</ul>
		</div>
		
		<div class="contents">
<!-- ▼contents▼ -->
<form:form commandName="svmVolVo" name="svmVolVo" id="svmVolVo" autocomplete="off" enctype="multipart/form-data" >
<%-- 			<form:hidden path="cmd"/> --%>
			<form:hidden path="kind" />
			<form:hidden path="save_tab_cd" />
			<form:hidden path="regi_no" />
			<form:hidden path="ad_no" />
			<form:hidden path="email" />
			<input type="hidden" name="lang" value="${lang}" />
			<input type="hidden" id="moveTo" name="moveTo" />
	<!-- ▼contents▼ -->

<ul class="step_02">
	<li class=""><spring:message code="svm.title.basic_information" /></li>
	<li class="on"><spring:message code="svm.title.upload_photo" /></li>
	<li class=""><spring:message code="svm.title.games_information" /></li>
	<li class=""><spring:message code="svm.title.finish_registeration" /></li>
</ul>


<!--▼table_write-->


<div class="con_title_01 con_title_01_add">
	<spring:message code='svm.header.photo_face'/>
	<div class="explain_support_01">
		Input field with symbol (<span class="must_01" style="width:13px;"></span>) is required.
	</div>
</div>

<div class="table_write table_write_support_01">

	<div>
		<dl>
			<dt class="cell_01">
				<strong>
					<spring:message code='svm.header.photo_upload'/><span class="must_01"></span>
					<br>
					<em>
						<spring:message code="svm.info.msg.provide_photo"/>
					</em>
				</strong>
			</dt>
			<dd class="">
				<strong>
					<div class="upload_01" style="width:350px;">
						<input type="file" id="facePhoto" name="facePhoto" class="mandatory" accept=".jpg"><label for="facePhoto" title="Upload" ></label>
					</div>
					<span class="txt_01" style="padding:0 0 0 10px;"><spring:message code="svm.info.file_type_max" arguments="JPG;4;" argumentSeparator=";"/>
				</strong>
			</dd>
		</dl>
	</div>

</div>


<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code='svm.header.photo_body'/>
	<div class="explain_support_01">
		<spring:message code="svm.header.input_field_required" />
	</div>
</div>

<div class="table_write table_write_support_01">

	<div>
		<dl>
			<dt class="cell_01">
				<strong>
					<spring:message code="svm.header.photo_upload"/><span class="must_01"></span>
					<br>
					<em>
						<spring:message code="svm.info.msg.provide_photo"/>
					</em>
				</strong>
			</dt>
			<dd class="">
				<strong>
					<div class="upload_01" style="width:350px;">
						<input type="file" id="bodyPhoto" name="bodyPhoto" class="mandatory" accept=".jpg"><label for="bodyPhoto" title="Upload"></label>
					</div>
					<span class="txt_01" style="padding:0 0 0 10px;"><spring:message code="svm.info.file_type_max" arguments="JPG;4;" argumentSeparator=";"/></span>
				</strong>
			</dd>
		</dl>
	</div>

</div>
			
<!--▲table_write-->

<div class="btn_area_01 btn_support_01" style="margin:30px 0 10px 0;">
	<div class="btn_center">
		<a class="btn_01 prev_icon" onClick="btnPre('${svmVolVo.regi_no}');"><spring:message code="svm.button.previous" /></a>
		<a id="btn_save" class="btn_02" onclick="btnSave('${svmVolVo.regi_no}');"><spring:message code="svm.button.save" /></a>
		<a id="btn_next" class="btn_03 next_icon" onClick="btnNext('${svmVolVo.regi_no}');"><spring:message code="svm.button.next" /></a>
		
	</div>
</div>


</form:form>
<!-- ▲contents▲ -->


			
		</div>

<script>
	$(document).ready(function(){
		
		init();
				
		// 화면 상태
		chkUserStatus();
		// 버튼 이벤트
		btnEvent();
		
		formSetting();
	});
	
	function chkUserStatus(){
		var frm = document.svmVolvo;
		if("${isRegistered}" == "true") alert("true");
	};
	
	function init(){
		//isMainCss(location.pathname);
	};
		
	function formSetting(){
		
		$('[for=facePhoto]').text("<c:out value='${svmVolVo.facePhoto_nm}'/>");
		$('[for=bodyPhoto]').text("<c:out value='${svmVolVo.bodyPhoto_nm}'/>");

	};
	
	
	function btnEvent(){

	}
	
	function contentVisible(selector){				
	}
	
	function btnSave(regi_no){
		if (!confirm('<spring:message code="svm.info.msg.is_save_application"/>')){
			return false;	// 종료
		}
		
		if(bindEventHandler()){
			var frm = document.svmVolVo;
			frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/update';
			frm.moveTo.value = 'save'
			frm.save_tab_cd.value = 'uploadPhoto'
			$("#btn_save").attr('onclick','javascript:;');
			$("#btn_next").attr('onclick','javascript:;');
			frm.submit();
		}
	}
	
	function btnNext(regi_no){
		if (!confirm('<spring:message code="svm.info.msg.is_save_next"/>')){
			return false;	// 종료
		}
		
		if(bindEventHandler()){
			var frm = document.svmVolVo;
			frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/update';
			frm.moveTo.value = 'next'
			frm.save_tab_cd.value = 'uploadPhoto'
			$("#btn_save").attr('onclick','javascript:;');
			$("#btn_next").attr('onclick','javascript:;');
			frm.submit();
		}
	}

	function btnPre(regi_no){
// 		if (!confirm('<spring:message code="svm.info.msg.is_save_pre"/>')){
// 			return false;	// 종료
// 		}
// 		if(bindEventHandler()){
			var frm = document.svmVolVo;
			frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/previous';
			frm.moveTo.value = 'pre'
			frm.save_tab_cd.value = 'uploadPhoto'
			frm.submit();
// 		}
	}
	
	// 해당 form 필수값 및 유효성 체크
	function bindEventHandler() {
		if( $("#facePhoto").val() == "" && $("label[for=facePhoto]").text().trim() == "" ){
			alert('<spring:message code="svm.message.upload_face"/>');
			$("#facePhoto").get(0).focus();
			return false;
		}
		if( $("#bodyPhoto").val() == "" && $("label[for=bodyPhoto]").text().trim() == "" ){
			alert('<spring:message code="svm.message.upload_body"/>');
			$("#bodyPhoto").get(0).focus();
			return false;
		}
		if( !validationUpload($("#facePhoto"))){
			$("#facePhoto").get(0).focus();
			return false;
		}
		if( !validationUpload($("#bodyPhoto"))){
			$("#bodyPhoto").get(0).focus();
			return false;
		}
		return true;
	}
	
	function onchageDate(name) {
		var optDay = "";
		// year, month, day SelectBox찾기
		selectYear = document.getElementById(name + "_year");
		selectMonth = document.getElementById(name + "_month");
		selectDay = document.getElementById(name + "_day");

		// 현재 년도와 월 구하기
		year = selectYear.options[selectYear.selectedIndex].value;
		month = selectMonth.options[selectMonth.selectedIndex].value;

		tmpDate = new Date(year, month, 0);

		selectedIndex = selectDay.selectedIndex;

		for(i = selectDay.length-1; i >= 0; i--) {
			selectDay.options[i] = null;
		}

		selectDay.options[0] = new Option('', '');

		for(i = 1; i <= tmpDate.getDate(); i++) {
			if(i >= 1 && i < 10) {
				optDay = "0" + i;
			} else {
				optDay = i;
			}
			selectDay.options[i] = new Option(optDay, optDay);
		}

		if(selectedIndex <= tmpDate.getDate()) {
			selectDay.options[selectedIndex].selected = true;
		} else {
			selectDay.options[tmpDate.getDate()-1].selected = true;
		} 
		funDrawCal();
	}
	
	

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
  			ad_no : frm.ad_no.value,
  			photo_fg: frm.poto_fg.value,
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


function validationUpload(obj){
	var isUploadValid = true;
	var uploadMsg = '';
	if($(obj)[0].value != ""){
		if($(obj)[0].files[0].size == 0){
			uploadMsg = '<spring:message code="svm.message.check_file_size"/>';
			isUploadValid = false;
		}
		if($(obj)[0].files[0].size > 4000000){
			uploadMsg = '<spring:message code="svm.message.check_file_size"/>';
			isUploadValid = false;
		}
		if($(obj)[0].files[0].type != "image/jpeg"){
			uploadMsg = '<spring:message code="message.alert.unsupport_file"/>';
			isUploadValid = false;
		}
	}
	if(!isUploadValid) alert(uploadMsg);
	return isUploadValid;
}
</script>
