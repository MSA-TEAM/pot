<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="/js/common.js"></script>

<form:form commandName="userVo" name="userVo" method="post">
	<div class="contents_wrap_01 contents_support_01">
		<div class="contents_top">
			<div class="con_title"><spring:message code="svm.title.change_password"/></div>
			<ul class="con_location">
				<li><spring:message code="svm.title.home"/></li>
				<li><spring:message code="svm.title.change_password"/></li>
			</ul>
		</div>
		<div class="contents">
			<!-- ▼contents▼ -->
			<div class="password_contents">
				<!--▼table_write-->
				<div class="table_write table_write_support_01 table_write_support_01_add" style="margin-top:30px;">
					<div>
						<dl>
							<dt class="cell_01">
								<strong><spring:message code="svm.header.email"/></strong>
							</dt>
							<dd class="">
								<strong>
									<input type="text" class="input_01" name="req_email" id="req_email" style=" width:577px;" value="${email }" <c:if test="${ email != '' && email != null }"> readonly="readonly" </c:if> placeholder='<spring:message code="svm.header.email"/>' title='<spring:message code="svm.header.email"/>'>
								</strong>
							</dd>
						</dl>
					</div>
					<div>
						<dl>
							<dt class="cell_01">
								<strong><spring:message code="svm.header.old_password"/></strong>
							</dt>
							<dd class="">
								<strong>
									<input type="password" class="input_01" name="old_password" id="req_old_password" style=" width:577px;" value="" placeholder="<spring:message code="svm.header.old_password"/>" title='<spring:message code="svm.header.old_password"/>'>
								</strong>
							</dd>
						</dl>
					</div>
				
					<div>
						<dl>
							<dt class="cell_01">
								<strong><spring:message code="svm.header.new_password"/></strong>
							</dt>
							<dd class="">
								<strong>
									<input type="password" class="input_01" name="password" id="req_password" style=" width:577px;" value="" placeholder='<spring:message code="svm.header.new_password"/>' title='<spring:message code="svm.header.new_password"/>'>
								</strong>
							</dd>
						</dl>
					</div>
				
					<div>
						<dl>
							<dt class="cell_01">
								<strong><spring:message code="svm.header.confirm_password"/></strong>
							</dt>
							<dd class="">
								<strong>
									<input type="password" class="input_01" name="password_confirm" id="req_password_confirm" style=" width:577px;" value="" placeholder='<spring:message code="svm.header.confirm_password"/>' title='<spring:message code="svm.header.confirm_password"/>'>
								</strong>
							</dd>
						</dl>
					</div>
				</div>
				<!--▲table_write-->
	
				<!-- <ul class="error_wrap" style="display:block;">
					<li>※ Password error!</li>
				</ul> -->
	
				<div class="btn_area_01 btn_support_01 btn_support_01_add" style="margin:30px 0 10px 0;">
					<div class="btn_center">
						<a class="btn_02" onClick="fn_change();" style="cursor: pointer;"><spring:message code="svm.button.save"/></a>
					</div>
				</div>
	
				<div class="btn_area_01" style="margin:10px 0 0px 0;">
					<div class="btn_left">
						<a href="/logoutSVM" class="btn_round_add_001 btn_home"><spring:message code="svm.button.go_back_home"/></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ▲contents▲ -->
</form:form>

<script>
	$(document).ready(function(){
		if('${msg}' != '' ){
			alert('${msg}');
		}
	});
	
	function fn_change(){
		if(vaildation()){
			 sendRequest({
		  		action: '<%=contextPath%>/svm/user/chngPw',
		  		params:{
		  			email : $("#req_email").val(),
		  			old_password : $("#req_old_password").val(),
		  			password : $("#req_password").val(),
		  			password_confirm : $("#req_password_confirm").val(),
		  		},
		  		callbackFunc:function(resData){
		  			if(resData.success){
		  				//alert("<spring:message code='svm.info.msg.send_temp_pw'/>");
		  				alert("<spring:message code='svm.message.success.change_password'/>");
		  				location.href='/login';
		  			}else {
		  				if("PWD" == resData.msg){
		  					alert("<spring:message code='svm.message.check_old_password'/>");	
		  				}else if("EM" == resData.msg){
		  					alert("<spring:message code='svm.info.msg.no_regi_email'/>");
		  				}else if("EA" == resData.msg){
		  					alert("<spring:message code='svm.message.info_resend_email'/>");
		  				}else{
		  					alert(resData.msg);
		  				}				  				
		  			}
		  		}
		  	});
		}
	}
	
	var alertFlag = false;
	function vaildation(){
		var flag = true;
		var result = false;
		$("input[id^=req_]").each(function(idx) {
			if($(this).val()== "" && alertFlag == false) {
				alert("<spring:message code='svm.message.head_please_enter'/> " + $(this).attr("title"));
				flag = false;
				$(this).focus();
				alertFlag = true;
				return;
			}
		});
		alertFlag = false;
		
		if(flag){
		    var regType1 = /^[A-Za-z0-9!@#$%^&() ~=`{}".']*$/;
			var regType =/^[a-z]/i;
		    
			if(!verifyemail($("#req_email").val())){
				alert('<spring:message code="svm.info.msg.enter_correctly_email"/>');
				$("#req_email").focus();
				return false;
			}else if(!regType.test($("#req_password").val())){
		    	alert('<spring:message code="sys.user.message.input_pw_first_word"/>');
		    	$("#req_password").focus();
			} else if ($("#req_password").val().search(/[*+,/:;<=>?[\]|]/g) != -1){
		    	alert('<spring:message code="sys.user.message.input_special_character_password"/>');
		    	$("#req_password").focus();
			}
			else if(!regType1.test($("#req_password").val())){
		    	alert('<spring:message code="sys.user.message.input_password_type"/>');
		    	$("#req_password").focus();
			}
		    
			else if($("#req_password").val() == $("#req_password_confirm").val()){
					if( ($("#req_password").val().length > 7) && ($("#req_password_confirm").val().length > 7)){
						if($("#req_password").val() != $("#req_old_password").val()){
							result = true;	
						}else {
							alert("<spring:message code='sys.user.message.input_other_password'/>");		
						}
					}else {
						alert("<spring:message code='svm.message.input_password_length' arguments='8'/>");
					}
				}else {
					alert("<spring:message code='svm.message.check_password_change' />");
				}
				
				if(!result){
					$("#req_password").val("");
					$("#req_password_confirm").val("");
					$("#req_password").focus();
				}
			}
		
			return result;
	}
</script>