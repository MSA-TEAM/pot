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
			<div class="con_title">Application</div>
			<ul class="con_location">
				<li>Home</li>
				<li>Application</li>
			</ul>
		</div>
		<div class="contents">





<!-- ▼contents▼ -->


<div class="verify_contents">


	<div class="verify_title_01">
		<spring:message code="svm.message.info_resend_email"/><br>
		<em><spring:message code="svm.message.info_resend_email_help"/></em>
	</div>


<form:form commandName="svmUserVo" name="svmUserVo" id="svmUserVo" autocomplete="off" >
	<form:hidden path="email" />
	<input type="hidden" name="isRegistered" />
	<div class="verify_address">
		<span>${userVo.email}</span>
		<div class="btn_area_01 btn_support_01 btn_support_01_add" style="margin:20px 0 0px 0;">
			<div class="btn_center">
				<a href="#void" onclick="resend();" class="btn_02"><spring:message code="svm.button.resend_email"/></a>
			</div>
		</div>
	</div>
				

	
	<div class="info_wrap">
		<spring:message code="svm.message.after_resend"/><br>
		<spring:message code="svm.message.help_check_email"/>
	</div>




	<div class="btn_area_01" style="margin:10px 0 0px 0;">
		<div class="btn_left">
			<a href="/login" class="btn_round_add_001 btn_home"><spring:message code="svm.button.go_to_login"/></a>
		</div>
	</div>
</form:form>



</div>



<!-- ▲contents▲ -->

</body>
</html>


<script>
$(document).ready(function(){
	
	if("${msg}" != "" ){
		alert("${msg}");
	}
	if("${authYn}" == "NS"){
		alert('<spring:message code="login.notlogon"/>');
		location.href="/login";
	}
	if("${authYn}" == "W"){
		//alert('잘못된 경로');
	}
	//if("${isRegistered}" == "true"){
	if("${isLogin}" != "true"){
		if("${resend}" == "true"){
			alert('<spring:message code="svm.info.msg.send_auth_mail"/>');
		}
	}
});

function resend(){
	var frm = document.svmUserVo;
	var url = '<%=contextLangPath%>/user/resendEmail';
	
	if('${userVo.email}' != '' ){
		frm.email.value= '${userVo.email}';
		frm.isRegistered.value= 'false';
	}
	if("${authYn}" == "N"){
		url = '/mail/handlerEmail';
	}	
	
	frm.action = url;

	// 유효성 체크 완료하고 저장 확인
	if (!confirm('<spring:message code="svm.message.is.resend"/>')){
		return false;	
	}
	
	$(svmUserVo)[0].submit();
}

</script>