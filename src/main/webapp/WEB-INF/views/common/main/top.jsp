<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="sicc_menu" />

<form name="frmsub" method="get" action="#">
</form>
<!-- header -->
<div class="wrapper_01">
	<div class="top_wrap">
		<div class="top_gnb">
			<a class="logo" onclick="javascript:{goMain();}">Jakarta Palembang 2018 Sport Entries System</a>
			<div class="top_right">
				<dl class="user_info">
					<c:set var="systemCd" value="<%=system_cd%>" />
<%-- 					<c:set var="groupId" value="<%=user.getUserGroupId()%>" /> --%>
					
					<li><a href="#void" onclick="javascript:{alert('준비중');};">User Info</a></li>
					
					<c:choose>
						<c:when test="${ isLogin == false }">
							<li><a onclick="javascript:{login();};"><spring:message code='button.login' /></a></li>
						</c:when>
						<c:otherwise>
							<li><a onclick="javascript:{logout();};"><spring:message code='button.logout' /></a></li>
						</c:otherwise>
					</c:choose>
					
					<c:set var="lang_flag" value="<%=lang%>"/>
					<li <c:if test="${lang_flag == 'en'}">class="on"</c:if>><a href="javascript:;" onclick="javascript:{changeLang('en');};">EN</a></li> 
					<li <c:if test="${lang_flag == 'in'}">class="on"</c:if>><a href="javascript:;" onclick="javascript:{changeLang('in');};" >IN</a></li>
					
				</dl>
			</div>
		</div>

		<div class="top_menu_wrap">
			<div class="top_menu" style="display:none;">
<!-- 			<div class="top_menu"> -->
				<ul>
					<c:set var="prevLevel" value="0" />
					<c:forEach var="i" items="${sicc_menu}" varStatus="cnt">
						<c:choose>
							<c:when test="${prevLevel == '0' && i.SUB_MENU_YN == 'N' }">
								<c:if test="${i.POPUP_YN != 'Y'}">
									<li><a onclick="javascript:{goMenu('<spring:url value="${i.CONTROL_URL}"/>')};">${i.MENU_NM}</a></li>
								</c:if>
								<c:if test="${i.POPUP_YN == 'Y'}">
									<li><a onclick="javascript:{goMenuPopup('<spring:url value="${i.CONTROL_URL}"/>')};">${i.MENU_NM}</a></li>
								</c:if>
							</c:when>
							<c:when test="${prevLevel == '1' && i.SUB_MENU_YN == 'N' && i.MENU_LVL == '0' }">
									</ul>
								</li>
								<c:if test="${i.POPUP_YN != 'Y'}">
									<li><a onclick="javascript:{goMenu('<spring:url value="${i.CONTROL_URL}"/>')};">${i.MENU_NM}</a></li>
								</c:if>
								<c:if test="${i.POPUP_YN == 'Y'}">
									<li><a onclick="javascript:{goMenuPopup('<spring:url value="${i.CONTROL_URL}"/>')};">${i.MENU_NM}</a></li>
								</c:if>
							</c:when>
							<c:when	test="${prevLevel == '0' && i.SUB_MENU_YN == 'Y' && i.MENU_LVL == '0' }">
								<li><a>${i.MENU_NM}</a>
									<ul class="txt_01">
							</c:when>
							<c:when	test="${prevLevel == '0' && i.SUB_MENU_YN == 'Y' && i.MENU_LVL == '1' }">
								<li><a onclick="javascript:{goMenu('<spring:url value="${i.CONTROL_URL}"/>')};">${i.MENU_NM}</a></li>
							</c:when>
							<c:when	test="${prevLevel == '1' && i.SUB_MENU_YN == 'Y' && i.MENU_LVL == '0' }">
									</ul>
								</li>
								<li><a><span>${i.MENU_NM}</span></a>
								<ul class="txt_01">
							</c:when>
							<c:when test="${prevLevel == '1' && i.SUB_MENU_YN == 'Y' }">
								<li><a onclick="javascript:{goMenu('<spring:url value="${i.CONTROL_URL}"/>')};">${i.MENU_NM}</a></li>
							</c:when>
							<c:when	test="${fn:length(sicc_menu) == (cnt.index+1) && i.MENU_LVL == 1}">
								</ul>
								</li>
							</c:when>
						</c:choose>

						<c:set var="prevLevel" value="${i.MENU_LVL}" />
					</c:forEach>

				</ul>
			</div>
		</div>

	</div>
</div>


<!--// header -->

<script type="text/javascript">
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
		var input = document.createElement('input');
		input.setAttribute('type', 'hidden');
		input.setAttribute('name', 'lang');
		input.setAttribute('value', lang);
		frm.appendChild(input);
		
		frm.action = '/changeLocale';
		frm.submit();
	}
	
	function login(){
		location.href = '<c:url value="/login"/>';
	}
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
		if(url.indexOf('/view/') < 0 && !<%=isLogin%> && !confirm('<spring:message code="message.confirm.login"/>')){
			return false;
		}
		
		document.frmsub.action = '<%=contextPath%>/<%=lang%>/' + url;
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
	//]]>
</script>