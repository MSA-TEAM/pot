<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="<%=lang %>">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache" /> 
<meta http-equiv="Expires" content="0" /> 
<meta http-equiv="Pragma" content="no-cache" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title><spring:message code="gms.title" /></title>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css/jquery-ui.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css/jquery.mCustomScrollbar.css"/>" type="text/css" />

<script type="text/javascript" src="<c:url value="/js/common_pub.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easing.1.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.mCustomScrollbar.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.mousewheel.min.js"/>"></script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<form id="loginForm" name="loginForm" method="post" autocomplete="off" action="loginProcess">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
	<input type="hidden" name="lang" value="${lang}" />

	<div class="login_wrapper_01">
		<div class="login_wrap_in">
			<div class="login_wrap_01">
				<a href="../index.html" class="logo">Jakarta Palembang 2018</a>
				<div class="login_title">
					<img src="../images/login_txt_01.png" alt="Online Accreditation System">
				</div>
				
				<div class="login_form">
					<form name="" method="post">
						<input type="hidden" name="">
						<div class="login_txt">
							<img src="../images/login_txt_02.png" alt="MEMBER LOGIN">
						</div>
						<div class="login_id">
							<input id="id" name="id" class="inpt" type="text" placeholder="ID" title="ID">
						</div>
						<div class="login_pwd">
							<input type="password" class="inpt" id="pw" name="pw" placeholder="PASSWORD" title="PASSWORD">
						</div>
						<div class="login_btn">
							<a onclick="document.getElementById('loginForm').submit();">Login</a>
						</div>
					</form>
					<div class="error_wrap">
						<c:if test="${securityExceptionMsg ne null }">			
							<span class="error_01" style="display:block;">
								<i class="icon-care"></i>${securityExceptionMsg}
							</span>
		 				</c:if>
					</div>
				</div>
	
				<div class="footer">
					<div class="bottom_wrap">
						<cite>
							GMS SITE OF THE <strong>SSANGYONG INFORMATION &amp; COMMUNICATIONS</strong> CORP. COPYRIGHT 2018. ALL RIGHTS RESERVED.
						</cite>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</form>
<!--// wrap -->


<script type="text/javascript">
//<![CDATA[
	$(window).load(function(){
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header, token);
		});
		
		if("${msg}" != null && "${msg}" != ""){
			setTimeout(function(){ 
				MessageHolder('${msg}', '${msgShowType}');
			}, 300);
		}
	});
	
    $(document).ready(function(){
    	var lang = $('#lang').val();
    	
    	if(undefined == lang || '' == lang){
    		lang = '<%=lang%>';
    	}
   		$('#sel_lang option[value='+lang+']').prop('selected', true);
    	
    	$('#sel_lang').change(function(){
    		changeLang($(this).val());
    	});
    	
// 		$("#main-layer .close").on('click', function(){
// 			$("#main-layer").hide();
// 			return false;
// 		});
    });
	function goMenu(url){
		if(url.indexOf('/view/') < 0 && !<%=isLogin%> && !confirm('<spring:message code="message.confirm.login"/>')){
			return false;
		}
		
		var lang = '<%=lang%>';
		
		document.loginForm.action = '<%=contextPath%>/' + url;
		document.loginForm.submit();
	}
	
	function changeLang(lang){
		var frm = document.loginForm;
		frm.lang.value = lang;
		
		frm.action = '/changeLocale';
		frm.submit();
	}
//]]>
</script>