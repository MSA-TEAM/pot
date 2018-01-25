<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<form id="loginForm" name="loginForm" method="post" autocomplete="off" action="loginProcess">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
	<input type="hidden" name="lang" value="${lang}" />
	<div id="skipNav">
		<a href="#contents">본문 바로가기</a>
	</div>
	<!-- wrap -->
	<div id="wrap-login">
		<!-- lang-wrap -->
		<div class="lang-wrap">
			<select name="sel_lang" id="sel_lang">
				<option value="en">EN</option>
				<option value="ko">KO</option>
			</select>
		</div>
		<!-- //lang-wrap -->
		<!-- contents-login -->
		<div id="contents-login">
			<div class="contents-inner">
				<div class="form-area">
					<h1>
						<a href="#"><img src="../images/common/logo.png" alt="PyeongChang2018" /></a>
						<a href="#"><img src="../images/common/logo02.png" alt="PyeongChang2018 PARALYMPIC GAMES" /></a>
					</h1>
					<h2 id="title_nm_en">Spectrum Order Portal</h2>
					<h2 id="title_nm_ko">주파수 신청 포털</h2>
					<div class="box-login">
						<fieldset>
							<p id="en_intro" style="font-size:18px;font-weight:bold;color:#999;">Spectrum Order Portal<br/>will open on 15th December 2016.</p>
							<p id="ko_intro" style="font-size:18px;font-weight:bold;color:#999;">스펙트럼 신청 포털은<br/>12월 15일 오픈 예정입니다.</p>
							<div>
								<input id="id" name="id" class="inpt" type="text" placeholder="EMAIL">
							</div>
							<div>
								<input id="pw" name="pw" class="inpt" type="password" placeholder="PASSWORD">
							</div>
							<!-- <div class="check-wrap">
								<span class="chk"><input type="checkbox" id="state" name="state"> <label for="state">Remember me</label></span>
							</div>
							<div class="find-sec">
								<span>I forgot my <a href="#" title="Search ID"><em>username</em></a> or <a href="#" title="Search Password"><em>password.</em></a></span>
							</div> -->

							<!-- D :: validation -->
							<div class="validation-text">
								<c:if test="${securityExceptionMsg ne null }">
									<i class="icon-care"></i>${securityExceptionMsg}
	 							</c:if>
 							</div>
 							<div class="find-sec2" id="ko_field">
								<span><a onclick="javascript:{funSPCjoin();};" >회원가입</a></span>
								<span><a onclick="javascript:{funSearchPW();};"><em>비밀번호 찾기</em></a></span>
							</div>
							<div class="find-sec2" id="en_field">
								<span><a onclick="javascript:{funSPCjoin();};" >Sign Up</a></span>
								<span><a onclick="javascript:{funSearchPW();};"><em>Find Password</em></a></span>
							</div>
							<div class="btn-wrap">
								<div class="btn-inner-wrap" id="btn_nm_en"><button class="btn-blue">Log in</button></div>
								<div class="btn-inner-wrap" id="btn_nm_ko"><button class="btn-blue">로그인</button></div>
							</div>
						</fieldset>
					</div>
				</div> 
				<div class="info-area" id="info-area_en">
					<div class="title">Welcome to<br/> the PyeongChang 2018</div>
					<div class="info">
						<p>
							Spectrum Order Portal will open on December 2016.
<!--                             Please login after applying for an account and getting approved in Spectrum Order Portal System<br /> for those who do not have an account.<br /> -->
<!--                             Spectrum Order Portal System login account has limitation on approval<br /> quantity by client groups, and needs to be discussed further with<br /> Spectrum Order Portal Manager.<br /> -->
						</p>
                        <p>
<!--                             Please refer to the attached file below for the user manual for Spectrum application.<br /> -->
<!--                             <a href="javascript:;" onclick="javascript:{funDown3();};">Radiofrequency Spectrum Management Plan</a><br /> -->
<!--                             <a href="javascript:;" onclick="javascript:{funDown1();};">User manual for Spectrum application</a><br /> -->
                        </p>
					</div>
				</div>
				<div class="info-area" id="info-area_ko">
					<div class="title">Welcome to<br/> the PyeongChang 2018</div>
					<div class="info">
						<p>
						    스펙트럼 신청 포털은 12월 오픈 예정입니다.
<!-- 							계정이 없으신 분은 주파수 신청 포털 시스템에서 회원가입을 하여 <br />승인 받은 후 로그인 하시기 바랍니다. <br /> -->
<!-- 							주파수 신청 포털 시스템 로그인 계정 신청은 클라이언트 그룹별로 <br /> -->
<!-- 							승인 수량에 제한이 있으니 클라이언트 그룹별 주파수 신청 포털 담당자와 협의하시기 바랍니다<br /> -->
						</p>
                        <p>
<!--                           	주파수 신청을 위한 사용자 매뉴얼은 아래 첨부된 파일을 참조하시기 바랍니다.<br />	 -->
<!--                             <a href="javascript:;" onclick="javascript:{funDown3();};">주파수 관리 계획</a><br /> -->
<!--                             <a href="javascript:;" onclick="javascript:{funDown2();};">사용자 매뉴얼</a><br /> -->
                        </p>
					</div>
				</div>
				
			</div>
	
			<!-- copyright -->
			<div id="copyright"> 
				© Copyright by The PyeongChang Organizing Committee for the 2018 Olympic &amp; Paralympic Winter Games<br/>
			</div>
			<!-- copyright -->
		</div>
		<!-- //contents-login -->
	</div>
</form>
<!--// wrap -->
<script type="text/javascript">
//<![CDATA[
    $(document).ready(function(){
    	var lang = $('#lang').val();
    	
    	if(undefined == lang || '' == lang){
    		lang = '<%=lang%>';
    	}
   		$('#sel_lang option[value='+lang+']').prop('selected', true);
    	
    	$('#sel_lang').change(function(){
    		changeLang($(this).val());
    	});
    	
    	if(lang == 'ko'){
    		$('#ko_intro').show();
    		$('#en_intro').hide();
    		$('#ko_field').show();
    		$('#en_field').hide();
    		$('#title_nm_en').hide();
    		$('#title_nm_ko').show();
    		$('#btn_nm_en').hide();
    		$('#btn_nm_ko').show();
    		$('#info-area_en').hide();
    		$('#info-area_ko').show();
    		
    		
    	}else if(lang == 'en'){
    		$('#ko_intro').hide();
    		$('#en_intro').show();
    		$('#ko_field').hide();
    		$('#en_field').show();
    		$('#title_nm_en').show();
    		$('#title_nm_ko').hide();
    		$('#btn_nm_en').show();
    		$('#btn_nm_ko').hide();
    		$('#info-area_en').show();
    		$('#info-area_ko').hide();
    	}
    	
    });
	function goMenu(url){
		if(url.indexOf('/view/') < 0 && !<%=isLogin%> && !confirm('<spring:message code="message.confirm.login"/>')){
			return false;
		}
		
		document.loginForm.action = '<%=contextPath%>/<%=lang%>/' + url;
		document.loginForm.submit();
	}
	
	function changeLang(lang){
		var frm = document.loginForm;
		frm.lang.value = lang;
		
		frm.action = '/changeLocale';
		frm.submit();
	}
	
	function funRatecardjoin(){
		
	}

	// 주파수 회원가입
	function funSPCjoin(){
		var frm = document.loginForm;
		frm.action = '<%=contextLangPath%>/spc/main/view/join_main';
		frm.submit();
		
	}
	// 주파수 비밀번호 찾기
	function funSearchPW(){
		var frm = document.loginForm;
		frm.action = '<%=contextLangPath%>/spc/main/view/search_password';
		frm.submit();
		
	}
	
 	function funDown1() {
 	    var popup = window.open('<%=contextLangPath%>/spc/main/view/manual', '_blank');
 	}
 	
 	function funDown2() {
 	    var popup = window.open('<%=contextLangPath%>/spc/main/view/manual2', '_blank');
 	}
 	
 	function funDown3() {
 	    var popup = window.open('<%=contextLangPath%>/spc/main/view/manual3', '_blank');
 	}
//]]>
</script>
