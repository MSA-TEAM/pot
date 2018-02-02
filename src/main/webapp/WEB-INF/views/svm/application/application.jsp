<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>

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
<div class="tab_01">
	<ul>
		<li class="on" id="tab_register"><em><spring:message code="svm.tab.RegisterApplication"/></em></li>
		<li class="" onclick="location.href='/login'" id="tab_modify"><em><spring:message code="svm.tab.ModifyApplication"/></em></li>
	</ul>
</div>

<form:form commandName="svmUserVo" name="svmUserVo" id="svmUserVo" autocomplete="off" >
			<form:hidden path="cmd"/>
			<form:hidden path="kind" />
			<form:hidden path="birth_date" />
			<form:hidden path="duplicate_check_yn" />
			<form:hidden path="email_id_auth_yn" />
			<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
			
<!--▼ form_register table_write-->
<div class="tab_01_contents ">

<div class="con_title_02">
	<spring:message code="svm.info.already_register"/>
	<a href="#link" onclick="location.href='/login'" class="btn_0003"><spring:message code="svm.button.login" /></a>
</div>

<div class="table_write table_write_support_01 table_write_support_01_add">

	<div>
		<dl>
			<dt class="cell_01">
				<strong><spring:message code="svm.header.date_of_birth"/><br>(DD/MM/YYYY)</strong>
			</dt>
			<dd class="">
				<strong>
					<span name="dateOfBirth" id="dateOfBirth_id"></span>
					<br/>
					<br/>
					<span>
						<span class='must_01'></span>&nbsp;&nbsp;<spring:message code='svm.info.minimum_age'/>
					</span>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01">
				<strong><spring:message code="svm.header.email"/></strong>
			</dt>
			<dd class="">
				<strong>
					<form:input path="email_id"  type="text" class="input_01" style="width:577px;" value="" placeholder="ex) aaa@gmail.com" maxlength="60"/>
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01">
				<strong><spring:message code="svm.header.password"/></strong>
			</dt>
			<dd class="">
				<strong>
					<form:password path="password" name="password" id="regist_password" class="input_01" style=" width:287px;" value="" placeholder="Password" maxlength="16"/>
					<form:password path="password_confirm" name="password_confirm" id="regist_password_confirm" class="input_01" style=" width:287px;" value="" placeholder="Confirm Password" onkeyup="enterkey();" maxlength="16"/>
				</strong>
			</dd>
		</dl>
	</div>

</div>
				
<!--▲table_write-->



<ul class="error_wrap" style="display:block;">
	<li><spring:message code="svm.info.dont_forget_email"/></li>
</ul>


<div class="btn_area_01 btn_support_01 btn_support_01_add" style="margin:30px 0 10px 0;">
	<div class="btn_center">
		<a href="#void" class="btn_02" onclick="funRegi();"><spring:message code="svm.button.register"/></a>
	</div>
</div>


</div>

</form:form>

<!-- ▲contents▲ -->


			
		</div>

<script>
	$(document).ready(function(){
		createDateSelectBox('dateOfBirth',67);

		// 해당 form 필수값 및 유효성 체크
		bindEventHandler();
		
		// 버튼 이벤트
		btnTabEvent();
		
		// 화면 상태
		chkUserStatus();
		
		init();
		
	});
	
	function chkUserStatus(){
		var frm = document.svmUserVo;
		//if("${isRegistered}" == "true") alert("true");
	};
	
	function init(){
		//isMainCss(location.pathname);
		funDrawCal();
	};
	
	function funDrawCal(){
		$("#dateOfBirth_day option:first").text("Date");
		$("#dateOfBirth_month option:first").text("Month");
		$("#dateOfBirth_year option:first").text("Year");
		
		$("#dateOfBirth_day,#dateOfBirth_month,#dateOfBirth_year").find('option:eq(0)').hide();
	};
	
	function funRegi(){
		var frm = document.svmUserVo;
		var url = '<%=contextLangPath%>/svm/user/insert';
		
		frm.password_confirm = $("#regist_password_confirm").val();
		frm.password = $("#regist_password").val();

		frm.birth_date.value = $("#dateOfBirth_year").val() + $("#dateOfBirth_month").val() + $("#dateOfBirth_day").val();
		
		frm.action = url;
		frm.cmd.value = 'insert';
		
		// 유효성 체크
		bindEventHandler('regist');
		var validChk = $('#svmUserVo').valid();
		if(!validChk){
			return false;	
		}
		if(!vaildation()) return false;
		
		// 유효성 체크 완료하고 저장 확인
		if (!confirm('<spring:message code="svm.info.msg.application_regist"/>')){
			return false;	
		}
		
		$(svmUserVo)[0].submit();
	}
	
	function funSignIn(){
		var frm = document.svmUserVo;
		var url = '/loginProcess';
		
		frm.action = url;
		
		// 유효성 체크
// 		var msg = passwordCheck($("#email").val(), $("#regist_password").val() , $("#regist_password_confirm").val(), $("#regist_password_confirm").val());
// 	    if(msg != ''){
// 	    alert(msg);
// 	    	return false;
// 	    }
	    
		bindEventHandler('signIn');
		var validChk = $('#svmUserVo').valid();
		if(!validChk){
			return false;	
		}
		
		// 유효성 체크 완료하고 저장 확인
// 		if (!confirm('<spring:message code="svm.info.msg.application_regist"/>')){
// 			return false;	
// 		}
		
// 		$(svmUserVo)[0].submit();
	}
	
	function funSetCommonCode(){
		createDateSelectBox('dateOfBirth',-10);
	}
	
	function btnTabEvent(){
// 		$('.tab_01 li').on('click',function(){
// 			if(this.className != 'on') tabContentVisible(this);
// 		});
	}
	
	function tabContentVisible(selector){
 		var sel_tab = $(selector).text();
		if(sel_tab == '<spring:message code="svm.tab.RegisterApplication"/>'){
			$('#svmUserVo').find('.tab_01_contents:eq(0)').show();
			$('#svmUserVo').find('.tab_01_contents:eq(1)').hide();
// 			$("#loginEmail").prop("name","");
// 			$("#loginPassword").prop("name","");
			$("#email").prop("name","email");
			$("#regist_password").prop("name","password");
		}
		else if(sel_tab == '<spring:message code="svm.tab.ModifyApplication"/>'){
			$('#svmUserVo').find('.tab_01_contents:eq(1)').show();
			$('#svmUserVo').find('.tab_01_contents:eq(0)').hide();
// 			$("#loginEmail").prop("name","email");
// 			$("#loginPassword").prop("name","password");
			$("#regist_password").prop("name","");
			$("#email").prop("name","");
		}
		$('.tab_01 li.on').removeClass();
		$(selector).addClass('on');
	}
	
	// 해당 form 필수값 및 유효성 체크
	function bindEventHandler(flag) {
			
		if(flag == "signIn"){
			//TODO : 중복검사 추가해야함  
			$('#svmUserVo').validate({
				onfocusout: false,
				rules: {
					id		: { required: true },
					pw		: { required: true }
				}, messages: {
					id: {
						required	:  '<spring:message code="login.empty.id" />',
					},
					pw: {
						required	:  '<spring:message code="login.empty.password" />',
						minlength	:  8
					}
				}, errorPlacement: function(error, element) {
					// do nothing
				}, invalidHandler: function(form, validator) {
					 var errors = validator.numberOfInvalids();
			         if (errors) {
			             alert(validator.errorList[0].message);
			             validator.errorList[0].element.focus();
			         }   
				}, submitHandler: function (form) {
					alert('submitHandler');
		        }
			});
		} else {
			// custom validation 정의
		 	$.validator.addMethod(
			        'email', function (value, element) {
			        	var isValid = false;
			        	if(verifyemail(value)){
			        		isValid = true;
			        	}
			        	return isValid;
			        	
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="svm.info.msg.enter_correctly_email"/>'
			 );
			$.validator.addMethod(
			        'isConfirmPassword', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return value == $("#regist_password").val();
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="sys.user.message.mismatch_password"/>'
			 );
			$.validator.addMethod(
			        'isSelectDate', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return "" != value;
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="svm.message.msg_select_date"/>'
			 );
			$.validator.addMethod(
			        'isSelectMonth', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return "" != value;
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="svm.message.msg_select_month"/>'
			 );
			$.validator.addMethod(
			        'isSelectYear', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return "" != value;
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="svm.message.msg_select_year"/>'
			 );
			$('#svmUserVo').validate({
				onfocusout: false,
				rules: {
					email		  : { required: true , email:true },
					password		  : { required: true , minlength : 8},
					password_confirm  : { required: true, isConfirmPassword : true , minlength : 8},
					dateOfBirth_day   : { required : true , isSelectDate : true },
					dateOfBirth_month : { required : true , isSelectMonth : true },
					dateOfBirth_year  : { required : true , isSelectYear : true }
				}, messages: {
					email: {
						required	:  '<spring:message code="svm.message.mandatory_email" />'
					},
					password: {
						required	:  '<spring:message code="sys.user.message.input_password" />',
						minlength	:  '<spring:message code="sys.user.message.input_password_length" />'
					},
					password_confirm: {
						required	:  '<spring:message code="svm.message.input_confirm_password" />',
						minlength	:  '<spring:message code="sys.user.message.input_password_length" />'
					},
					dateOfBirth_day: {
						required	:  '<spring:message code="svm.message.msg_select_date" />'
					},
					dateOfBirth_month: {
						required	:  '<spring:message code="svm.message.msg_select_month" />'
					},
					dateOfBirth_year: {
						required	:  '<spring:message code="svm.message.msg_select_year" />'
					},
				
				}, errorPlacement: function(error, element) {
					// do nothing
				}, invalidHandler: function(form, validator) {
					 var errors = validator.numberOfInvalids();
			         if (errors) {
			             alert(validator.errorList[0].message);
			             validator.errorList[0].element.focus();
			         }   
				}, submitHandler: function (form) {
					alert('submitHandler');
		        }
			});
		}
	 	
	}
	
	function onchageDate(name) {
		var optDay = "";
		// year, month, day SelectBox찾기
		selectYear = document.getElementById(name + "_year");
		selectMonth = document.getElementById(name + "_month");
		selectDay = document.getElementById(name + "_day");

		// 현재 년도와 월 구하기
		year = selectYear.options[selectYear.selectedIndex].value;
		month = selectMonth.options[selectMonth.selectedIndex].value;

		tmpDate = new Date(year, month, 0);

		selectedIndex = selectDay.selectedIndex;

		for(i = selectDay.length-1; i >= 0; i--) {
			selectDay.options[i] = null;
		}

		selectDay.options[0] = new Option('', '');

		for(i = 1; i <= tmpDate.getDate(); i++) {
			if(i >= 1 && i < 10) {
				optDay = "0" + i;
			} else {
				optDay = i;
			}
			selectDay.options[i] = new Option(optDay, optDay);
		}

		if(selectedIndex <= tmpDate.getDate()) {
			selectDay.options[selectedIndex].selected = true;
		} else {
			selectDay.options[tmpDate.getDate()].selected = true;
		} 
		funDrawCal();
	}
	
	function vaildation(){
		var flag = true;
		var result = true;
		var pw1 = $("#regist_password").val();
		var pw2 = $("#regist_password_confirm").val();
// 		if($("#dateOfBirth_year").val()+$("#dateOfBirth_month").val()+$("#dateOfBirth_day").val() > 19990830){
// 			alert('<spring:message code="svm.info.minimum_age"/>');
// 			return false;
// 		}
		if(pw1 != ""){
			var checkpwd = passwordCheck($("#email").val(), pw1, pw1 , pw2 );
			
			if(checkpwd != ''){
				switch(checkpwd){
					case  'mismatch_password' 				 : alert('<spring:message code="sys.user.message.mismatch_password"/>');                result = false; break;
					case  'input_password_length' 			 : alert('<spring:message code="sys.user.message.input_password_length"/>'); 			result = false; break;
					case  'input_pw_first_word' 			 : alert('<spring:message code="sys.user.message.input_pw_first_word"/>');   			result = false; break;
					case  'input_special_character_password' : alert('<spring:message code="sys.user.message.input_special_character_password"/>'); result = false; break;
					case  'input_password_type' 			 : alert('<spring:message code="sys.user.message.input_password_type"/>');   			result = false; break;
					default : break;
				}
				$("#regist_password").focus();
			}
		}
		return result;
	}
	
	function enterkey() {
        if (window.event.keyCode == 13) {
        	funRegi(); 
        }
	}
	
</script>

