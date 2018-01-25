<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<!doctype html>
<html lang="<%=lang %>">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title><spring:message code="error.messsage.404.title"/></title>

<link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css/jquery-ui.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css/jquery.mCustomScrollbar.css"/>" type="text/css" />

<script type="text/javascript" src="<c:url value="/js/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common_pub.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easing.1.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.mCustomScrollbar.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.mousewheel.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>

<!--[if lt IE 9]>
<script type="text/javascript" src="../js/html5.js"></script>
<link rel="stylesheet" href="../css/ie8_style.css" type="text/css" />
<![endif]-->
<!--[if lte IE 7]>
	<p>
	    사용하고 계신 브라우저는 Internet Explore 7 이하입니다.<br />
	    <strong>2018평창 Rate Card 시스템 홈페이지는 Internet Explore 8 이상에서 최적화 되어 있습니다.</strong> 웹 브라우저를 <a href="http://www.microsoft.com/korea/ie">업그레이드</a> 해 보세요.<br />
	    다른 최신 브라우저를 사용해 보셔도 좋습니다!
        <a href="http://www.google.com/chrome?hl=ko">chrome</a>,
	    <a href="http://www.mozilla.or.kr/ko/Firefox/">fireFox</a>,
	    <a href="http://kr.opera.com/download/">opera</a>,
	    <a href="http://www.apple.com/kr/safari/">Safari</a>	    
	</p>
	<![endif]-->
<script type="text/javascript">
//<![CDATA[
	function goBack(){
		location.href='<%=contextPath%>';
	}
	function goHome(){
		location.href = '<%=contextLangPath%>/svm/main';
	}
//]]>
</script>
</head>
<body>
<form name="errorFrm" method="POST">
	<input type="hidden" id="cmd" name="cmd" value="${cmd}" />
	<input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}" /> 

	<div class="wrapper_01">
		<div class="error_page_wrap">
			<a onclick="javascript:{goMain();}" class="logo">Jakarta Palembang 2018</a>
			<div class="error_page_in">

				<strong>
					<spring:message code="error.messsage.404.title"/>
				</strong>

				<span>
					<spring:message code="error.messsage.404.body"/>
				</span>
				
			</div>
		</div>
		
		<div class="btn_area_02">
			<a href="#void" onclick="javascript:{goHome();};"  class="btn_02">Home</a>
			<a href="#void" onclick="javascript:{goBack();};"  class="btn_01">Prev</a>
		</div>
	</div>

</form>
</body>
</html>