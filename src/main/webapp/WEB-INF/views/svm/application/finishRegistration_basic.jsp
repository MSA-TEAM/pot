<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ include file="/WEB-INF/views/svm/application/submitLayerPopup.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
	
<% pageContext.setAttribute("enter","\n"); %>
<% pageContext.setAttribute("enter2","\r\n"); %>

<div class="contents_wrap_01 contents_support_01">
		<div class="contents_top">
			<div class="con_title"><spring:message code="svm.title.application" /></div>
			<ul class="con_location">
				<li><spring:message code="svm.title.home"/></li>
				<li><spring:message code="svm.title.application" /></li>
			</ul>
		</div>
		<div class="contents">
<!-- ▼contents▼ -->
<form:form commandName="svmVolVo" name="svmVolVo" id="svmVolVo" autocomplete="off" enctype="multipart/form-data">
<%-- 			<form:hidden path="cmd"/> --%>
			<form:hidden path="kind" />
			<input type="hidden" name="moveTo" />
			<form:hidden path="regi_no" />
			<form:hidden path="ad_no" />
			<form:hidden path="email" />
			<form:hidden path="save_tab_cd" />
			
			<form:hidden path="photo_fg" />
			<form:hidden path="downFile_nm" />			
						
	<!-- ▼contents▼ -->

<ul class="step_02">
	<li class=""><spring:message code="svm.title.basic_information" /></li>
	<li class=""><spring:message code="svm.title.upload_photo" /></li>
	<li class=""><spring:message code="svm.title.games_information" /></li>
	<li class="on"><spring:message code="svm.title.finish_registeration" /></li>
</ul>

<div class="tab_02">
	<ul>
		<li class="on"><a href="#link" onclick="moveTab('finishInfo_basic');"><spring:message code="svm.title.basic_information" /></a></li>
		<li class=""><a href="#link" onclick="moveTab('finishInfo_game');"><spring:message code="svm.title.games_information" /></a></li>
		<li class=""><a href="#link" onclick="moveTab('finishInfo_photo');"><spring:message code="svm.title.photo_profile" /></a></li>
	</ul>
</div>

<!--▼table_write-->

<div class="con_title_01 con_title_01_add" style="margin-top:30px;">
	<spring:message code="svm.header.basicInfo" />
</div>

<div class="table_write table_write_support_01 table_write_support_02">

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.registration_no" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.regi_no}'/>
<!-- 					<img src="../images/bar_code.jpg" alt="bar code"> -->
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.group_nm" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.group_nm}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.type_volunteer" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:forEach items="${svmVolVo.areaList}" var="item">
						<c:if test="${item.area == 'tov' }">
							<span>${item.check_nm}</span>
						</c:if>
					</c:forEach>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.preferred_division" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:forEach items="${svmVolVo.areaList}" var="item">
						<c:if test="${item.area == 'pd' }">
							<span>${item.check_nm}</span>
						</c:if>
					</c:forEach>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.name" />	
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.given_nm}'/> &nbsp; 
					<c:out value='${svmVolVo.family_nm}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.nickname" />	
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.nickname}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.birth" />	
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${SVMUserVO.birth_date }'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.gender" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.gender_nm}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.married" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.married_nm}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.blood_type" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.blood_type_cd}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.nationality" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.ctry_cd_fg_nm}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<c:if test="${svmVolVo.ctry_cd_fg == 'F' }">
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.passportNo" />
					</strong>
				</dt>
				<dd class="">
					<strong>
						<c:out value='${svmVolVo.passport_no}'/>
					</strong>
				</dd>
			</dl>
		</div>
	
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.finishinfo.basic.passport_file" />
					</strong>
				</dt>
				<dd class="">
					<strong>
						<c:if test="${svmVolVo.passportFile_nm != '' }">
							<a target="_blank" title="<c:out value='${svmVolVo.passportFile_nm}'/>" onclick="javascript:{funDownload('passport', '${svmVolVo.passportFile_nm}');};" style="cursor: pointer;" >
								<img src="/images/icon_down_01.png" alt="download">
								<em><c:out value='${svmVolVo.passportFile_nm}'/></em>
							</a>
						</c:if>
					</strong>
				</dd>
			</dl>
		</div>	
	</c:if>
	
	<c:if test="${svmVolVo.ctry_cd_fg == 'L' }">
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.ktpNumber" />
					</strong>
				</dt>
				<dd class="">
					<strong>
						<c:out value='${svmVolVo.ktp_no}'/>
					</strong>
				</dd>
			</dl>
		</div>
	</c:if>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.addr" />
				</strong>
			</dt>
			<dd class="">
				<strong>
				<c:choose>
					<c:when test="${svmVolVo.ctry_cd_fg == 'L' }">
						<span><spring:message code="svm.finishinfo.basic.province" /> : <c:out value='${svmVolVo.provinsi_nm}'/></span><br/>
						<span><spring:message code="svm.finishinfo.basic.city" /> : <c:out value='${svmVolVo.city_nm}'/></span><br/>
						<span><spring:message code="svm.finishinfo.basic.district" /> : <c:out value='${svmVolVo.district_nm}'/></span><br/>
						<span><spring:message code="svm.finishinfo.basic.village" /> : <c:out value='${svmVolVo.village_nm}'/></span><br/>
						<br>
						<c:out value='${svmVolVo.address_dtl}'/>
					</c:when>
					<c:when test="${svmVolVo.ctry_cd_fg == 'F' }">
						<span><spring:message code="svm.finishinfo.basic.country" /> : <c:out value='${svmVolVo.ctry_nm}'/></span><br/>
						<span><spring:message code="svm.finishinfo.basic.city" /> : <c:out value='${svmVolVo.foreign_city}'/></span><br/>
						<br>
						<c:out value='${svmVolVo.address}'/>
					</c:when>
				</c:choose>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.postcode" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.postcode}'/>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.mobile_number" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					(<c:out value='${svmVolVo.nationality_cd}'/>)&nbsp;<c:if test="${svmVolVo.nationality_mobile ne ''}">+</c:if><c:out value='${svmVolVo.nationality_mobile}'/>&nbsp;&nbsp;<c:out value='${svmVolVo.mobile_no}'/>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.whatsapp_number" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value="${svmVolVo.whats_no}"/>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.email" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.email}'/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.occupation_or_university" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value='${svmVolVo.occu_or_univ_cd_nm}'/>
				</strong>
			</dd>
		</dl>
	</div>	
	<c:if test="${svmVolVo.occu_or_univ_cd == 'G' }">
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.occupation" />
					</strong>
				</dt>
				<dd class="">
					<strong>
						<c:out value='${svmVolVo.occu_nm}'/>
					</strong>
				</dd>
			</dl>
		</div>
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.organization_name" />
					</strong>
				</dt>
				<dd class="">
					<strong>
							<c:out value='${svmVolVo.occu_or_univ_nm}'/>
					</strong>
				</dd>
			</dl>
		</div>
	</c:if>
	<c:if test="${svmVolVo.occu_or_univ_cd == 'U' }">
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.university_nm" />
					</strong>
				</dt>
				<dd class="">
					<strong>
							<c:out value='${svmVolVo.occu_or_univ_nm}'/>
					</strong>
				</dd>
			</dl>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.occupation_or_university.major" />
					</strong>
				</dt>
				<dd class="">
					<strong>
							<c:out value='${svmVolVo.occu_or_univ_major_nm}'/>
					</strong>
				</dd>
			</dl>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.occupation_or_university.status_major" />
					</strong>
				</dt>
				<dd class="">
					<strong>
						<c:out value='${svmVolVo.occu_or_univ_st_major_nm}'/> 
					</strong>
				</dd>
			</dl>
		</div>
	</c:if>
	<c:if test="${svmVolVo.occu_or_univ_cd == 'H' }">
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.header.occupation_or_university.school_name" />
					</strong>
				</dt>
				<dd class="">
					<strong>
							<c:out value='${svmVolVo.occu_or_univ_nm}'/>
					</strong>
				</dd>
			</dl>
		</div>
	</c:if>
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.for_uniform_purpose" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<span><spring:message code="svm.header.uniform.shirt" /> : <c:out value='${svmVolVo.uni_shirts_nm}'/></span>
					<span><spring:message code="svm.header.uniform.waist" /> : <c:out value='${svmVolVo.uni_waist_nm}'/></span>
					<span><spring:message code="svm.header.uniform.shoes" /> : <c:out value='${svmVolVo.uni_shoes_nm}'/></span>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.height_weight" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<span><spring:message code="svm.header.height" /> : <c:out value='${svmVolVo.height}'/><spring:message code="svm.finishinfo.basic.height_cm" /></span>
					<span><spring:message code="svm.header.weight" /> : <c:out value='${svmVolVo.weight}'/><spring:message code="svm.finishinfo.basic.weight_kg" /> </span>
				</strong>
			</dd>
		</dl>
	</div>
	
</div>

</div>

<div class="con_title_01 con_title_01_add" style="margin-top:30px;">
	<spring:message code="svm.header.social" />
</div>

<div class="table_write table_write_support_01 table_write_support_02">

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.social_media" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<div><spring:message code="svm.header.facebook" /> : <c:out value='${svmVolVo.facebook_nm}'/></div>
					<div><spring:message code="svm.header.twitter" /> : <c:out value='${svmVolVo.twitter_nm}'/></div>
					<div><spring:message code="svm.header.line" /> : <c:out value='${svmVolVo.line_nm}'/></div>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.hobby_aspiration" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<span><spring:message code="svm.header.hobby" /> : <c:out value='${svmVolVo.hobby}'/></span>
					<span><spring:message code="svm.header.aspiration" /> : <c:out value='${svmVolVo.aspiration}'/></span>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.motto" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value="${svmVolVo.motto}" />
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.reason_to_join_volunteer" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value="${svmVolVo.reason}" />
				</strong>
			</dd>
		</dl>
	</div>

</div>


			
<!--▲table_write-->



<div class="con_title_01 con_title_01_add" style="margin-top:40px; padding-bottom:6px; border-bottom:2px solid #d63140;">
	<spring:message code="svm.finishinfo.basic.title_education" />
</div>


<div class="con_title_03" style="margin-top:30px;">
	<spring:message code="svm.header.school_level" />
</div>
<table class="table_list_01 no_hover table_list_support_01_add in_table_01">
	<colgroup>
		<col style="width:270px;">
		<col style="width:160px;">
		<col>
	</colgroup>
	<thead>
		<tr>
			<th><spring:message code="svm.header.level" /></th>
			<th><spring:message code="svm.header.year" /></th>
			<th><spring:message code="svm.header.occupation_or_university.school_name" /></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="left"><spring:message code="svm.header.sd_or_equals" /></td>
			<td><c:out value='${svmVolVo.sd_schl_year}'/></td>
			<td class="left"><c:out value='${svmVolVo.sd_schl_nm}'/></td>
		</tr>
		<tr>
			<td class="left"><spring:message code="svm.header.smp_or_equals" /></td>
			<td><c:out value='${svmVolVo.smp_schl_year}'/></td>
			<td class="left"><c:out value='${svmVolVo.smp_schl_nm}'/></td>
		</tr>
		<tr>
			<td class="left"><spring:message code="svm.header.sma_or_equals" /></td>
			<td><c:out value='${svmVolVo.sma_schl_year}'/></td>
			<td class="left"><c:out value='${svmVolVo.sma_schl_nm}'/></td>
		</tr>
	</tbody>
</table>

<c:if test="${svmVolVo.university_lvl_yn == 'Y'}">

<div class="con_title_03" style="margin-top:30px;">
	<spring:message code="svm.header.university_level" />
</div>

<table class="table_list_01 no_hover table_list_support_01_add in_table_01">
	<colgroup>
		<col style="width:270px;">
		<col style="width:160px;">
		<col style="width:350px;">
		<col>
	</colgroup>
	<thead>
		<tr>
			<th><spring:message code="svm.header.level" /></th>
			<th><spring:message code="svm.header.year" /></th>
			<th><spring:message code="svm.header.faculty" /></th>
			<th><spring:message code="svm.header.university" /></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="left"><spring:message code="svm.header.university_or_equals" /></td>
			<td><c:out value='${svmVolVo.university_year}'/></td>
			<td class="left"><c:out value='${svmVolVo.university_faculty}'/></td>
			<td class="left"><c:out value='${svmVolVo.university_university}'/></td>
		</tr>
		<tr>
			<td class="left"><spring:message code="svm.header.post_or_equals" /></td>
			<td><c:out value='${svmVolVo.post_grad_year}'/></td>
			<td class="left"><c:out value='${svmVolVo.post_grad_faculty}'/></td>
			<td class="left"><c:out value='${svmVolVo.post_grad_university}'/></td>
		</tr>
		<tr>
			<td class="left"><spring:message code="svm.header.doctoral_or_equals" /></td>
			<td><c:out value='${svmVolVo.doctoral_year}'/></td>
			<td class="left"><c:out value='${svmVolVo.doctoral_faculty}'/></td>
			<td class="left"><c:out value='${svmVolVo.doctoral_university}'/></td>
		</tr>
	</tbody>
</table>

</c:if>


<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.finishinfo.basic.title_other" />
</div>


<div class="table_write table_write_support_01 table_write_support_02">

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.parents_upper" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<span><spring:message code="svm.header.mothers" /> : <c:out value='${svmVolVo.prnts_mother_nm}'/></span>
					<span><spring:message code="svm.header.fathers" /> : <c:out value='${svmVolVo.prnts_father_nm}'/></span>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.emergency" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<span><spring:message code="svm.finishinfo.basic.emergency_phone" /> : <c:out value='${svmVolVo.emer_phone}'/></span>
					<span><spring:message code="svm.finishinfo.basic.emergency_relation" /> : <c:out value='${svmVolVo.emer_rel_nm}'/></span>
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

// Download Image (photo, passport) 
function funDownload(photo_fg, photo_nm){
	var frm = document.svmVolVo;
	frm.photo_fg.value = photo_fg;
	frm.downFile_nm.value = photo_nm;
	frm.action = '<%=contextLangPath%>/svm/application/downloadImage';
	frm.submit();
}

function btnEdit(regi_no){
	var frm = document.svmVolVo;
	frm.action = '<%=contextLangPath%>/svm/application/basicInfo';
	frm.moveTo.value = 'basicInfo';
	//frm.save_tab_cd.value = 'basicInfo'
	frm.submit();
}

function btnSave(regi_no){
	if($("#accept_yn").is(":checked") != true){
		alert('<spring:message code="svm.message.no_accept"/>');
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