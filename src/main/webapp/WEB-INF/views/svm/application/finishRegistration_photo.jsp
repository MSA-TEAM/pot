<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ include file="/WEB-INF/views/svm/application/submitLayerPopup.jsp"%>
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
<form:form commandName="svmVolVo" name="svmVolVo" id="svmVolVo"  autocomplete="off" enctype="multipart/form-data">
<%-- 			<form:hidden path="cmd"/> --%>
			<form:hidden path="kind" />
			<form:hidden path="save_tab_cd" />
			<form:hidden path="ad_no" />
			<form:hidden path="email" />
			<input type="hidden" name="moveTo" />

<!-- ▼contents▼ -->

<ul class="step_02">
	<li class=""><spring:message code="svm.title.basic_information" /></li>
	<li class=""><spring:message code="svm.title.upload_photo" /></li>
	<li class=""><spring:message code="svm.title.games_information" /></li>
	<li class="on"><spring:message code="svm.title.finish_registeration" /></li>
</ul>


<div class="tab_02">
	<ul>
		<li class=""><a href="#link" onclick="moveTab('finishInfo_basic');"><spring:message code="svm.title.basic_information" /></a></li>
		<li class=""><a href="#link" onclick="moveTab('finishInfo_game');"><spring:message code="svm.title.games_information" /></a></li>
		<li class="on"><a href="#link" onclick="moveTab('finishInfo_photo');"><spring:message code="svm.title.photo_profile" /></a></li>
	</ul>
</div>


<!--▼table_write-->

<div class="con_title_01 con_title_01_add" style="margin-top:30px;">
	<spring:message code="svm.title.upload_photo_upper" />    
</div>

<div class="table_write table_write_support_01 table_write_support_02">

	<div>
		<dl>
			<dt style="display:none;"></dt>
			<dd class="">
				<strong>
					<div class="photo_01">
						<div class="photo_face">
							<span>
								<spring:message code="svm.finishinfo.photo.face" />    
							</span>
							<img src="${svmVolVo.facephoto}" alt="face">
						</div>
						
						<div class="photo_body">
							<span>
								<spring:message code="svm.finishinfo.photo.body" />
							</span>
							<img src="${svmVolVo.bodyphoto}" alt="full body">
						</div>
					</div>
				</strong>
			</dd>
		</dl>
	</div>
	
	
</div>

<c:if test="${SVMUserVO.submit_yn == 'N' }">
	<div class="btn_area_01 btn_support_01" style="margin:30px 0 10px 0;">
		<div class="btn_center">
				<a href="#void" class="btn_03" onclick="btnEdit();"><spring:message code="svm.button.edit" /></a>
				<a href="#void" class="btn_02 btn_02_add" onclick="btnBeforeSubmit();"><spring:message code="svm.button.submit" /></a>
		</div>
	</div>
</c:if>

<c:if test="${SVMUserVO.submit_yn == 'Y' }">
<%-- 			<a href="/logoutSVM" class="btn_03" ><spring:message code="svm.button.go_back_home" /></a> --%>
	<div class="intro_explain_box_01_01">
	    Thank you for registering, you will be contacted if you were qualified.<br/>
		Terima kasih telah mendaftar, Anda akan dihubungi jika anda lolos untuk tahap selanjutnya.
	</div>
</c:if>
<!--▲table_write-->
</form:form>
<!-- ▲contents▲ -->

<script>
$(document).ready(function(){
});

function moveTab(tabNm){
	var frm = document.svmVolVo;
	frm.action = '<%=contextPath%>/<%=lang%>/svm/application/' + tabNm; 
	frm.moveTo.value = tabNm;
	frm.submit();
}

function btnEdit(regi_no){
	var frm = document.svmVolVo;
	frm.action = '<%=contextLangPath%>/svm/application/uploadPhoto';
	frm.moveTo.value = 'uploadPhoto';
	//frm.save_tab_cd.value = 'basicInfo'
	frm.submit();
}
// function btnEdit(regi_no){
// 	var frm = document.svmVolVo;
<%-- 	frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/move'; --%>
// 	frm.moveTo.value = 'photoInfo';
// 	//frm.save_tab_cd.value = 'basicInfo'
// 	frm.submit();
// }

function btnSave(regi_no){
	if($("#accept_yn").is(":checked") != true){
		alert('<spring:message code="svm.message.no_accept"/>');
		$(".popup_dim").remove();
		return false;
	}
		
	if (!confirm('<spring:message code="svm.info.msg.is_final_regist"/>')){
		return false;	// 종료
	}

	var frm = document.svmVolVo;
	frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/register';
	frm.moveTo.value = 'register'
	frm.save_tab_cd.value = 'finishInfo_basic';
	frm.submit();
}

</script>