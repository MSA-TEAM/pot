<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<!doctype html>
<html lang="<%=lang %>">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title><spring:message code="error.messsage.404.title"/></title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/responsive.css'/>" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/errorWeb.css'/>" type="text/css"/>
<script type="text/javascript" src="<c:url value='/js/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.bxslider.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/common-pub.js'/>"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../js/html5.js"></script>
<link rel="stylesheet" href="../css/ie8_style.css" type="text/css" />
<![endif]-->
<!--[if lte IE 7]>
	<p>
        <a href="http://www.google.com/chrome?hl=ko">chrome</a>,
	    <a href="http://www.mozilla.or.kr/ko/Firefox/">fireFox</a>,
	    <a href="http://kr.opera.com/download/">opera</a>,
	    <a href="http://www.apple.com/kr/safari/">Safari</a>	    
	</p>
	<![endif]-->
<script type="text/javascript">
//<![CDATA[
	function goBack(){
		location.href='${_request_url}';
	}
	function goFirst(){
// 		var frm = document.errorFrm;
// 		frm.action='/';
// 		frm.submit();
		location.href = '<%=contextLangPath%>/svm/main';
	}
//]]>
</script>
</head>

<form name="errorFrm" method="POST">
	<input type="hidden" id="cmd" name="cmd" value="${cmd}" />
	<input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}" /> 

	<div class="wrapper_01">
		<div class="error_page_wrap">
			<div class="error_page_in">

				<strong>
					<spring:message code="error.message.xss_request"/>
				</strong>

				<span>
<%-- 					<spring:message code="error.messsage.404.body"/> --%>
				</span>
				
			</div>
		</div>
		<div class="btn_area_02">
<!-- 			<a href="#void" onclick="javascript:{goHome();};"  class="btn_02">Home</a> -->
<!-- 			<a href="#void" onclick="javascript:{goBack();};"  class="btn_01">Prev</a> -->
			<a href="javascript:;" onclick="javascript:{goFirst();};"  class="btn_01"><spring:message code="error.button.first_page"/></a>
			<a href="javascript:;" onclick="javascript:{goBack();};"  class="btn_02"><spring:message code="error.button.prev"/></a>
		</div>
	</div>

</form>

	</html>