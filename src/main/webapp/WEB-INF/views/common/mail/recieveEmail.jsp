<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
	
<style>
div.table_write .cell_01{width:171px;}
div.table_write .cell_02{}
.tab_01 li:NOT(.on){cursor: pointer;}
.select_01{width: 190px;}
</style>

<div class="contents_wrap_01 contents_support_01">
		<div class="contents_top">
			<div class="con_title"><spring:message code='svm.title.application'/></div>
			<ul class="con_location">
				<li><spring:message code='svm.title.home'/></li>
				<li><spring:message code='svm.title.application'/></li>
			</ul>
		</div>
<!-- ▼contents▼ -->
<div class="verify_contents">

	<c:if test="${authYn == 'Y'}"> 
		<div class="verify_title_01">
			<spring:message code="svm.message.success.email_auth"/>
		</div>
	
		<div class="verify_address no_bg">
			<span>
				<em>${email}</em>
				<spring:message code="svm.message.success.email_auth_info"/><br>
				<spring:message code="svm.message.continue_register"/><br>
				<spring:message code="svm.message.move_nextPage" arguments="10"/>
	
			</span>
			<div class="btn_area_01 btn_support_01 btn_support_01_add" style="margin:30px 0 0px 0;">
				<div class="btn_center">
					<a href="/login" class="btn_02"><spring:message code="button.confirm"/></a>
				</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${authYn != 'Y'}"> 
		<div class="verify_title_01">
			<spring:message code="svm.message.failed.email_auth"/>
		</div>
	
		<div class="verify_address no_bg">
			<span>
				[ <spring:message code='svm.message.failed.email_auth_reason'/> ]<br/><br/>
				<spring:message code='svm.message.failed.email_auth_info'/><br/>
				
	
			</span>
		</div>
		
		<div class="btn_area_01" style="margin:10px 0 0px 0;">
				<div class="btn_left">
					<a href="#void" class="btn_round_add_001 btn_home" style="cursor: pointer;" onclick="goMenu('svm/application/application');"><spring:message code='svm.button.go_back_home'/></a>
				</div>
			</div>
	</c:if>


<!-- 	<div class="btn_area_01" style="margin:30px 0 0px 0;"> -->
<!-- 		<div class="btn_left"> -->
<%-- 			<a href="#void" class="btn_round_add_001 btn_home"><spring:message code="svm.button.go_to_login"/></a> --%>
<!-- 		</div> -->
<!-- 	</div> -->




</div>

<!-- ▲contents▲ -->

</body>
</html>

<script>
$(document).ready(function(){
	
	if("${authYn}" == "W"){
		alert('잘못된 경로');
	}
	if("${resend}" == "true"){
		alert("발송완료");
	}
	if("${authYn}" == "Y"){
		setTimeout(function(){
			location.href= '/login';
		},10000);
	}
	
});

</script>