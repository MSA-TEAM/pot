<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="/js/common.js"></script>

<style>
	div.table_write .cell_01{width:171px;}
	div.table_write .cell_02{}
</style>
	
<div class="contents_wrap_01 contents_support_01">
	<div class="contents_top">
		<div class="con_title"><spring:message code='svm.title.forgot_password'/></div>
		<ul class="con_location">
			<li><spring:message code="svm.title.home"/></li>
			<li><spring:message code='svm.title.forgot_password'/></li>
		</ul>
	</div>
	
	<!-- ▼contents▼ -->


		
<div class="password_contents">

	<div class="pasword_title_01">
		<spring:message code="svm.message.info.email_sent_pwd_chng"/>
	</div>

	<div class="con_title_02 con_title_02_add_01">
		Email was sent to <a href="#link" style="pointer-events: none;">${email }</a> account for password change.<br>
		You can change the password through your account email.<br>
		
		<div style="height:20px;"></div>
		
	</div>



	<div class="btn_area_01" style="margin:10px 0 0px 0;">
		<div class="btn_left">
			<a href="/logoutSVM" class="btn_round_add_001 btn_home"><spring:message code="svm.button.go_back_home"/></a>
		</div>
	</div>


</div>

</div>

<!-- ▲contents▲ -->


<script>
	$(document).ready(function(){
	
	});
</script>
