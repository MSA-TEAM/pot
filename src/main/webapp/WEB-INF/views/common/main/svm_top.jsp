<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<form name="frmsub" method="get" action="#">
</form>
<!-- header -->
<body>
<div class="wrapper_01">
	<div class="top_wrap top_support_01">
		<div class="top_gnb" >
			<a href="#void" onclick="goMenu('svm/main');" class="logo"><spring:message code="svm.title.jakarta"/></a>
			<ul class="change_lang">
				<c:set var="lang_flag" value="<%=lang%>"/> 
					<li <c:if test="${lang == 'in'}">class="on"</c:if>><a href="javascript:;" onclick="javascript:{changeLang('in');};" >INA</a></li>
					<li <c:if test="${lang == 'en'}">class="on"</c:if>><a href="javascript:;" onclick="javascript:{changeLang('en');};">ENG</a></li>
			</ul>

			<ul class="top_support_menu">
				<li class="m1"><a href="#void" onclick="goMenu('svm/main');" ><spring:message code="svm.menu.home"/></a></li>
				<li class="m2"><a href="#void" onclick="goMenu('svm/about');"><spring:message code="svm.menu.about"/></a></li>
<%-- 				<li class="m3"><a href="#void" onclick="goMenu('svm/procedure');"><spring:message code="svm.menu.procedure"/></a></li> --%>
				<li class="m4"><a href="#void" onclick="goMenu('svm/volunteer');"><spring:message code="svm.menu.volunteer"/></a></li>
				<li class="m5"><a href="#void" onclick="goMenu('svm/contact');"><spring:message code="svm.menu.contact_us"/></a></li>
			</ul>

			<div class="top_btn">
				<output id="txt_go_register" style="display:none;">
					<a href="#void" onclick="funApplication();" class="visual_btn"><spring:message code="svm.button.click_register"/></a>
				</output>
				<output id="txt_go_home" style="display:none;">
					<a href="/login" class="visual_btn"><spring:message code='svm.button.go_back_home'/></a>
				</output>
			</div>
		</div>

		<form:form name='frm'>
			<div class="main_btn_01">
				<a href="#void" onclick="funApplication();" class="btn_01"><spring:message code='svm.button.click_register'/></a>
			</div>
		</form:form>

<script>
isMainCss(location.pathname);

$(document).ready(function(){
	
	
	var menuUrl = location.pathname.split('/svm/').pop();
	var seq = -1;
// 	switch(menuUrl){
// 		case "main" 	 : seq = 0; break;			
// 		case "about" 	 : seq = 1; break;			
// 		case "procedure" : seq = 2; break;			
// 		case "volunteer" : seq = 3; break;			
// 		case "contact" 	 : seq = 4; break;			
// 	}
	switch(menuUrl){
		case "main" 	 : seq = 0; break;			
		case "about" 	 : seq = 1; break;			
		case "volunteer" : seq = 2; break;			
		case "contact" 	 : seq = 3; break;			
	}
	console.log(menuUrl);
	console.log(seq);
	$(".top_support_menu li.on").removeClass('on');
	if(seq != -1) $(".top_support_menu li").eq(seq).addClass('on');		
	
	// 2018 for SaaS
	$(".logo").css({"background":"url(<%=logoImage%>)", 'background-repeat' : 'no-repeat', 'background-position':'center center'});
		
});

<!--// header -->
//<![CDATA[
      function changeLang(lang){
		var frm;
		for(i=0;i<document.forms.length;i++){
			if(document.forms[i].name.toLowerCase().indexOf("vo") > -1){
				frm = document.forms[i];
				break;
			}
		}
		if(undefined == frm){
			frm = document.frmsub;
		}
		var input = '';
		if(frm.lang == undefined || frm.lang == ''){
			input = document.createElement('input');
			input.setAttribute('type', 'hidden');
			input.setAttribute('name', 'lang');
			input.setAttribute('value', lang);
			frm.appendChild(input);
		}else{
			frm.lang.value = lang;
		}
		
		frm.action = '/changeLocale';
		frm.submit();
	}
	
// 	function login(){
// 		location.href = '<c:url value="/login"/>';
// 	}
    function logout() {
        if (confirm('<spring:message code="message.confirm.logout"/>')) {
        	// kimjw SSO
			location.href = '<%=logoutUrl%>';
            //location.href = '<c:url value="/logout"/>';
        }
    }
	function goMain(){
		document.frmsub.action = '/';
		document.frmsub.submit();
	}
	
	function goMenu(url){
<%-- 		if(url.indexOf('/view/') < 0 && !<%=isLogin%> && !confirm('<spring:message code="message.confirm.login"/>')){ --%>
// 			return false;
// 		}
		document.frmsub.action = '<%=contextPath%>/<%=lang%>/' + url;
		//document.frmsub.action = '<%=contextPath%>/' + '${lang}' + '/' + url;
		
		if(document.frmsub.lang == undefined || document.frmsub.lang == ''){
			var input = document.createElement('input');
			input.setAttribute('type', 'hidden');
			input.setAttribute('name', 'lang');
			input.setAttribute('value', '<%=lang%>');
			frm.appendChild(input);
		}else{
			frm.lang.value = '<%=lang%>';
		}
		
		document.frmsub.submit();
	}
	
	function goUserMenu(url){
		
		var frm;
		for(i=0;i<document.forms.length;i++){
			if(document.forms[i].name.toLowerCase().indexOf("vo") > -1){
				frm = document.forms[i];
				break;
			}
		}
		if(undefined == frm){
			frm = document.frmsub;
		}
		
		frm.action =  '<%=contextPath%>/<%=lang%>/' + url;
		frm.submit();

	}
	
	function goPopup(url){
		var popup = window.open(url, '_blank');	
	}
	
	function goMenuPopup(url){
		if(url.indexOf('/view/') < 0 && !<%=isLogin%> && !confirm('<spring:message code="message.confirm.login"/>')){
			return false;
		}
		
		var popup = window.open('<%=contextPath%>/<%=lang%>/' + url, '_blank');

	}
	
	$(function() {
		$(".header .gnb-wrap .gnb > li").mouseenter(function() {
			$(".header .gnb-wrap .gnb-2depth").hide();
			$(this).find('ul').stop().slideDown(200);
			$(".header .gnb-wrap .gnb > li").removeClass('active');
			$(this).addClass('active');
		});

		$(".header .gnb-wrap .gnb > li").mouseleave(function() {
			$(".header .gnb-wrap .gnb-2depth").hide();
			$(".header .gnb-wrap .gnb > li").removeClass('active');
		});
	})
	
	//application
	function funApplication(){
		var frm = document.frm;
		var url = '<%=contextLangPath%>/svm/application/application';
		frm.action = url;
		location.href = getQueryStringUrl(frm, url);
	}

	//]]>
</script>