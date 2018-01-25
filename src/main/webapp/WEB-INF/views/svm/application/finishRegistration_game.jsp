<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ include file="/WEB-INF/views/svm/application/submitLayerPopup.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
	
<% pageContext.setAttribute("enter","\n"); %>
<% pageContext.setAttribute("brTag","<br/>"); %>
<% pageContext.setAttribute("brTag2","\"<br/>\""); %>
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
<form:form commandName="svmVolVo" name="svmVolVo" id="svmVolVo" autocomplete="off" enctype="multipart/form-data">
<%-- 			<form:hidden path="cmd"/> --%>
			<form:hidden path="kind" />
			<input type="hidden" name="moveTo" />
			<form:hidden path="regi_no" />
			<form:hidden path="email" />
			<form:hidden path="save_tab_cd" />
			<form:hidden path="ad_no" />
						
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
		<li class=""><a href="#link" onclick="moveTab('finishInfo_basic');"><spring:message code="svm.title.basic_information" /></a></li>
		<li class="on"><a href="#link" onclick="moveTab('finishInfo_game');"><spring:message code="svm.title.games_information" /></a></li>
		<li class=""><a href="#link" onclick="moveTab('finishInfo_photo');"><spring:message code="svm.title.photo_profile" /></a></li>
	</ul>
</div>

<!--▼table_write-->

<div class="con_title_01 con_title_01_add" style="margin-top:30px;">
	<spring:message code="svm.header.work_location" />
</div>

<div class="table_write table_write_support_01 table_write_support_02">

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.selected_location" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:forEach items="${svmVolVo.areaList}" var="item">
						<c:if test="${item.area == 'lc' }">
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
					<spring:message code="svm.header.preferred_work_duration" />
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value="${svmVolVo.avail_work_nm}"/> 
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.description_of_preferred_work_duration" />  
				</strong>
			</dt>
			<dd class="">
				<strong>
					<c:out value="${svmVolVo.avail_work_desc}"/> 
				</strong>
			</dd>
		</dl>
	</div>
</div>




<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.header.language_skill_upper" />
</div>

<div class="table_write table_write_support_01 table_write_support_02">
	<c:set var="ord" value="1" />
	<c:forEach items="${svmVolVo.areaList}" var="item" varStatus="status">
		<c:if test="${item.area == 'ls' }">
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.form.lang_nm" /> <c:out value="${ord}" />
						<c:set var="ord" value="${ord + 1}" />
					</strong>
				</dt>
				<dd class="">
					<strong>
							<span><spring:message code="svm.form.skill" /> : <c:out value='${item.skill_nm}'/></span>
							<span><spring:message code="svm.header.level" /> : <c:out value='${item.level_nm}'/></span>
							<c:if test="${item.skill_cd eq '99'}">
								<span><spring:message code="svm.header.name" /> : <c:out value='${item.name_txt}'/></span>
							</c:if>
					</strong>
				</dd>
			</dl>
		</div>
		</c:if>
	</c:forEach>
</div>




<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.header.additional_skill" />
</div>

<div class="table_write table_write_support_01 table_write_support_02">
	<c:set var="ord" value="1" />
	<c:forEach items="${svmVolVo.areaList}" var="item" varStatus="status">
		<c:if test="${item.area == 'as' }">					
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code="svm.form.skill" /> <c:out value="${ord}" />
					</strong>
				</dt>
				
				<dd class="cell_merge merge_add">
					<div style="display:block;">
						<dl>
							<dt style="display:none;"></dt>
							<dd class="">
								<strong>
									<span><spring:message code="svm.header.name" /> : <c:out value='${item.name_txt}'/> </span>
								</strong>
							</dd>
						</dl>
						<dl>
							<dt style="display:none;"></dt>
							<dd class="">
								<strong>
									<span><spring:message code="svm.header.upload_certificates" /> : 
										<a  target="_blank" title="<c:out value='${item.certi_nm}'/>" onclick="javascript:{funDownload('skillPhoto' + '${ord}' , '${item.certi_nm}');};" style="cursor: pointer;" >
											<img src="/images/icon_down_01.png" alt="download">
											<em><c:out value='${item.certi_nm}'/></em>
										</a>
									</span>
								</strong>
							</dd>
						</dl>
						<dl>
							<dt style="display:none;"></dt>
							<dd class="">
								<strong>
									<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.description" /> : </span>
										<div style="margin-top:5px;" id="as_desc${ord}">
										</div>
									 	<script>
										 	replaceBr('<c:out value="${item.description}" escapeXml="true" />','as_desc${ord}');
									 	</script>
								</strong>
							</dd>
						</dl>
					</div>
				</dd>
			</dl>
		</div>
		<c:set var="ord" value="${ord + 1}" />
		</c:if>
	</c:forEach>
</div>




<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.header.sport_event_experience" />
</div>

<div class="table_write table_write_support_01 table_write_support_02">
	<c:set var="ord" value="1" />
	<c:forEach items="${svmVolVo.areaList}" var="item" varStatus="status" >
		<c:if test="${item.area == 'see' }">
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong>
							<spring:message code="svm.form.experience" /> <c:out value="${ord}" />
						</strong>
					</dt>
					
					<dd class="cell_merge merge_add">
						<div style="display:block;">
							<dl>
								<dt style="display:none;"></dt>
								<dd class="">
									<strong>
										<span><spring:message code="svm.header.level" /> : <c:out value='${item.level_nm}'/></span>
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd class="">
									<strong>
										<span><spring:message code="svm.form.attendance.name" /> : <c:out value='${item.name_nm}'/></span>
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd class="">
									<strong>
										<span><spring:message code="svm.form.duration" /> : <c:out value='${item.duration}'/></span>
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd class="">
									<strong>
										<span class="txt_01" style="padding:0 8px 0 0px;">
											<spring:message code="svm.header.description" /> :
										</span>
										<div style="margin-top:5px;" id="see_desc${ord}">
										</div>
									 	<script>
										 	replaceBr('<c:out value="${item.description}" escapeXml="true" />','see_desc${ord}');
									 	</script>
										<c:set var="ord" value="${ord + 1}" />
									</strong>
								</dd>
							</dl>
						</div>
					</dd>
				</dl>
			</div>
		</c:if>
	</c:forEach>
</div>




<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.header.other_event_experience" />
</div>

<div class="table_write table_write_support_01 table_write_support_02">
	<c:set var="ord" value="1" />
	<c:forEach items="${svmVolVo.areaList}" var="item" varStatus="status">
		<c:if test="${item.area == 'oee' }">
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong>
							<spring:message code="svm.form.experience" /> <c:out value="${ord}" />
						</strong>
					</dt>
					
					<dd class="cell_merge merge_add">
						<div style="display:block;">
							<dl>
								<dt style="display:none;"></dt>
								<dd class="">
									<strong>
										<span><spring:message code="svm.header.level" /> : <c:out value='${item.level_nm}'/></span>
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd class="">
									<strong>
										<span><spring:message code="svm.form.attendance.name" /> : <c:out value='${item.name_txt}'/></span>
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd class="">
									<strong>
										<span class="txt_01" style="padding:0 8px 0 0px;">
											<spring:message code="svm.header.description" /> : 
										</span>
										<div style="margin-top:5px;" id="oee_desc${ord}">
										</div>
									 	<script>
										 	replaceBr('<c:out value="${item.description}" escapeXml="true" />','oee_desc${ord}');
									 	</script>
									 	<c:set var="ord" value="${ord + 1}" />
									</strong>
								</dd>
							</dl>
						</div>
					</dd>
				</dl>
			</div>
		</c:if>
	</c:forEach>
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

//Download Image (photo, passport) 
function funDownload(photo_fg, photo_nm){
	var frm = document.svmVolVo;
	frm.photo_fg.value = photo_fg;
	frm.downFile_nm.value = photo_nm;
	frm.action = '<%=contextLangPath%>/svm/application/downloadImage';
	frm.submit();
}

function btnEdit(regi_no){
	var frm = document.svmVolVo;
	frm.action = '<%=contextLangPath%>/svm/application/gameInfo';
	frm.moveTo.value = 'gameInfo';
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