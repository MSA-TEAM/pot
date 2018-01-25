<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="/js/common.js"></script>

<form:form commandName="svmUserVo" name="svmUserVo" id="svmUserVo" autocomplete="off" >	
<div class="contents_wrap_01 contents_support_01">
	<div class="contents_top">
		<div class="con_title"><spring:message code='svm.title.forgot_password'/></div>
		<ul class="con_location">
			<li><spring:message code="svm.title.home"/></li>
			<li><spring:message code='svm.title.forgot_password'/></li>
		</ul>
	</div>
	<!-- ▼contents▼ -->
	<div class="contents">
		<div class="password_contents">
		
			<!--▼table_write-->
			<div class="pasword_title_01">
				<spring:message code='svm.info.msg.forgot_password'/>
			</div>
		
			<div class="con_title_02 con_title_02_add">
				<spring:message code="svm.info.msg.already_register" arguments="/login;Login Here;" argumentSeparator=";"/>
			</div>
			<div class="table_write table_write_support_01 table_write_support_01_add">
				<div>
					<dl>
						<dt style="display:none;"></dt>
						<dd class="">
							<strong>
								<div class="email_input">
									<span><spring:message code="svm.header.email"/></span>
									<input type="text" class="input_01" name="email" style="width:577px;" value="" placeholder="ex) aaa@gmail.com" id="email" onkeyup="btnKeyEvent();"/> 
									<input type="text" style="display: none;"/>
<%-- 									<form:input path="email" class="input_01" style="width:577px;" value="" placeholder="ex) aaa@gmail.com" id="email" /> --%>
								</div>
							</strong>
						</dd>
					</dl>
				</div>
			</div>
			<!--▲table_write-->
	
			<!--<ul class="error_wrap" style="display:block;">
					<li>※ Email error!</li>
				</ul> -->

			<div class="btn_area_01 btn_support_01 btn_support_01_add" style="margin:30px 0 10px 0;">
				<div class="btn_center">
					<a class="btn_02" onClick="sendMail()" id="btn_send" style="cursor: pointer;" ><spring:message code='svm.button.reset_password'/></a>
				</div>
			</div>

			<div class="btn_area_01" style="margin:10px 0 0px 0;">
				<div class="btn_left">
					<a href="/login" class="btn_round_add_001 btn_home" style="cursor: pointer;" ><spring:message code='svm.button.go_back_home'/></a>
				</div>
			</div>
		</div>
	</div>
</div>

</form:form>
<!-- ▲contents▲ -->

<script>
	$(document).ready(function(){
	
	});
	
	
	function goMenuWithParam(url,param){
				document.svmUserVo.action = '<%=contextPath%>/<%=lang%>/' + url;
				var inputEmail = document.createElement('input');
				inputEmail.setAttribute('type', 'hidden');     
				inputEmail.setAttribute('name', param);       
				inputEmail.setAttribute('value', $("#"+param).val()); 
				document.svmUserVo.appendChild(inputEmail);                   
				if(document.svmUserVo.lang == undefined || document.svmUserVo.lang == ''){
					var input = document.createElement('input');
					input.setAttribute('type', 'hidden');
					input.setAttribute('name', 'lang');
					input.setAttribute('value', '<%=lang%>');
					document.svmUserVo.appendChild(input);
				}else{
					document.svmUserVo.lang.value = '<%=lang%>';
				}
				document.svmUserVo.submit();
	}
	
	var flag = true;
	function sendMail(){
		if(flag){
			flag = false;
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			var email = $("#email").val();
			if(email.trim() != "" || email == null ){
				if(exptext.test(email)){
					 sendRequest({
				  		action: '<%=contextPath%>/mail/forgotPw',
				  		params:{
				  			email : email
				  		},
				  		callbackFunc:function(resData){
				  			if(resData.success){
				  				//alert("<spring:message code='svm.info.msg.send_temp_pw'/>");
				  				//location.href='/login';
				  				goMenuWithParam('svm/forgotPwAfter');
				  			}else {
				  				if("NFM" == resData.msg){
				  					alert("<spring:message code='svm.info.msg.no_regi_email'/>");	
				  				}else if("EA" == resData.msg){
				  					alert("<spring:message code='svm.message.info_resend_email'/>");
				  				}else {
				  					alert(resData.msg);
				  				}				  				
							  	flag = true;
				  			}
				  		}
				  	});			 	
				}else {
					$("#email").val("");
					flag = true;
					alert("<spring:message code='svm.info.msg.enter_correctly_email'/>");
				}
			}else {
				flag = true;
				alert("<spring:message code='svm.message.mandatory_email'/>");
			}
		}
	}
	
	
function btnKeyEvent() {
      if (window.event.keyCode == 13) {
    	  sendMail();
      }
	}
</script>
