<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<form:form commandName="sysUserVo" name="sysUserVo" method="post">
<form:hidden path="cmd"/>
<form:hidden path="page"/>
<form:hidden path="p_user_id"/>
<form:hidden path="group_id"/>
<form:hidden path="search_system_cd"/>
<form:hidden path="search_use_yn"/>
<form:hidden path="search_user_id"/>
<form:hidden path="search_user_group"/>
<form:hidden path="search_user_nm"/>
<form:hidden path="search_order"/>
<form:hidden path="search_group_system_cd"/>
<form:hidden path="search_group_id"/>
<form:hidden path="search_granted_group_id"/>
<form:hidden path="system_cd"/>
<form:hidden path="use_yn"/>
<form:hidden path="group_system_cd"/>
<form:hidden path="assign_group_id"/>
<form:hidden path="user_group"/>
<form:hidden path="granted_group_id"/>
<form:hidden path="priv_system_cd"/>
<form:hidden path="authority"/>
<form:hidden path="pre_group_id"/>

<div class="contents_wrap_01">
		<div class="contents_top">
			<div class="con_title">사용자 등록/수정</div>
			<ul class="con_location">
				<li>Home</li>
				<li>사용자 관리</li>
				<li>사용자 등록/수정</li>
			</ul>
		</div>
		<div id="contents">
			<style>
				div.table_write .cell_01{width:168px;}
				div.table_write .cell_02{width:423px;}
				div.table_write .cell_03{width:168px;}
				div.table_write .cell_04{}
			</style>
			
			<!--▽table_write-->
			<div class="table_write">
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for="country"><span class="must_01"></span><spring:message code="sys.user.header.system"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<select class="select_01" id="sel_system_cd" name="sel_system_cd" onchange="javascript:{setValue('system_cd', this.value);}"></select>
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.user.header.user_id"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<form:input path="user_id" cssClass="input_01"/>					
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.user.header.new_password"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<form:password path="password" cssClass="input_01"/>		
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.user.header.confirm_password"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<form:password path="password_confirm" cssClass="input_01"/>
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.user.header.user_nm"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<form:input path="user_nm" cssClass="input_01"/>
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.user.header.use_yn"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<input type="checkbox" class="checkbox_01" id="chk_use_yn" name="chk_use_yn" onclick="javascript:{funChkEvent();}"> <label for="chk_use_yn">Y/N</label>
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.user.header.login_fail_cnt"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<form:input path="login_fail_cnt" cssClass="input_01"/>
							</strong>
						</dd>
					</dl>
				</div>

				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.user.header.group_id"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>		
								<span class="txt_02" style="padding-right:6px;">System</span>
								<select class="select_01" style="width:330px;" id="sel_group_system_cd" name="sel_group_system_cd" disabled onchange="javascript:{setValue('group_system_cd', this.value);};" ></select>
									<span class="txt_02" style="padding-left:214px;">Selected Group</span>								
							</strong>
							<strong>
								<select class="multi_select_01" style="height:144px;" id="sel_group_id" name="sel_group_id" multiple="multiple" onchange="javascript:{setValue('group_id', this.value);};" ></select>				

								<ul class="arrows_btn_01" style="vertical-align:middle;">
									<li><a onclick="javascript:{funGrantAll();}">전체 왼쪽으로 이동</a></li>
									<li><a onclick="javascript:{funGrant();}">오른족에서 왼쪽으로</a></li>
									<li><a onclick="javascript:{funRevoke();}">왼쪽에서 오른쪽으로</a></li>
									<li><a onclick="javascript:{funRevokeAll();}">전체 오른쪽으로 이동</a></li>
								</ul>

								<select class="multi_select_01" style="height:144px;"id="sel_granted_group_id" name="sel_granted_group_id" multiple="multiple" onchange="javascript:{setValue('granted_group_id', this.value);};" ></select>
							</strong>
						</dd>
					</dl>
				</div>	
			</div>

			<div class="btn_area_01" style="margin:20px 0 0 0;">
				<div class="btn_left">
					<a class="btn_02" onclick="javascript:{funClose();}">닫기</a>
				</div>
				<div class="btn_right">
					<a class="btn_02" onclick="javascript:{funSave();}">저장</a>
				</div>
			</div>
			
		</div><!-- // contents -->
		
	</div>
			



</form:form>
<script type="text/javascript">
//<![CDATA[
           
    $(document).ready(function(){
    	var frm = document.sysUserVo;
    	
    	$("#login_fail_cnt").prop('readonly', true);
    	
    	if(frm.cmd.value == 'edit') {
    		$("#user_id").prop('readonly', true);
    	} else {
    		$("#chk_use_yn").prop('checked', true);
    		$('#use_yn').val('Y');
    	}
    	
    	isValidCheck();
    	init();
//     	funChange();
    });
    
    function init(){
		var result = ${sysUserVo.result};
		
		Combo({
			data:result,
			code_find:'SYSTEM_CD',
			name:'sel_system_cd',
			selectCond:'system_cd',
			blankCond: ''
		});
		
		
		Combo({
			data: result,
			code_find: 'GROUP_LIST',	
			name: 'sel_user_group',
			selectCond: 'user_group',
			blankCond: ''
		});
		
		Combo({
			data:result,
			code_find: 'SYSTEM_CD',
			name: 'sel_group_system_cd',
			selectCond: 'group_system_cd',
			blankCond: ''
		});
		
		Combo({
			data: result,
			code_find: 'GROUP_LIST',	
			name: 'sel_group_id',
			selectCond: 'group_id'
		});
		
		if('input'!= document.sysUserVo.cmd.value){
			Combo({
				data: result,
				code_find: 'GRANTED_GROUP_LIST',
				name: 'sel_granted_group_id',
				selectCond: 'granted_group_id'
			});
		}
	}
    
//     function funSave(){
//     	var frm = document.sysUserVo;
//     	var url = '';
    	
//     	if('edit' == frm.cmd.value){
<%--     		url = '<%=contextLangPath%>/sys/user/update'; --%>
//     		frm.cmd.value = 'update'; 
//     	}else{
<%--     		url = '<%=contextLangPath%>/sys/user/insert'; --%>
//     		frm.p_user_id.value = frm.user_id.value;
//     		frm.cmd.value = 'insert';
//     	}
// 		frm.action = url;
// 		frm.submit();
//     }
    
	function funSearch(){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/user/list';
		frm.cmd.value = 'list';
		frm.submit();
    }
    
    function isValidCheck(){
    	var frm = document.sysUserVo;
    	// user_id
//     	if(frm.cmd.value == "edit") {
//     		$("#user_id").attr("class", "input_readonly");
//     		$("#user_id").attr("readonly", true);
//     	}

    	// use_yn
    	if($('#use_yn').val()=='Y') {
    		$('#chk_use_yn').prop('checked', true);
    	} else {
    		$('#chk_use_yn').prop('checked', false);
    	}
    	
    	// change_pwd_yn
//     	if($('#change_pwd_yn').val()=='Y') {
//     		$('#chk_change_pwd_yn').prop('checked', true);
//     	} else {
//     		$('#chk_change_pwd_yn').prop('checked', false);
//     	}
    }
    
    function funChkEvent(){
    	// chk_use_yn
    	if($('#chk_use_yn').prop('checked')) {
    		$('#chk_use_yn').prop('checked', true);
    		$('#use_yn').val('Y');
    	} else {
    		$('#chk_use_yn').prop('checked', false);
    		$('#use_yn').val('N');
    	}
    }
    
    function funChkUserId(){
    	var frm = document.sysUserVo;
    	var user_id = frm.user_id.value;
    	
    	if(frm.cmd.value == "input") {
    		if(frm.user_id.value == "") {
    			return false;
    		} else if(user_id.length < 6 || user_id > 20) {
   				alert("<spring:message code='sys.user.message.input_userid_length'/>");
   				frm.user_id.focus();
   				return false;
    		}
    		
	        sendRequest({
				action 		: '<%=contextLangPath%>/sys/tools/tool',
				kind 		: '',
				content 	: 'SYS',
				code_find 	: 'CHK_USER_ID',
				order 		: '',
				etcCond 	: " AND USER_ID = '" + frm.user_id.value + "' ",
				callbackFunc : 'funChkUserIdResult'
			});
    	} 
    }
    
    // checking result ad no
    function funChkUserIdResult(obj){
    	var frm = document.sysUserVo;
        if (obj > 0) {
        	alert("<spring:message code='sys.user.message.id_already_exists'/>");
        	frm.user_id.value = '';
        	frm.user_id.focus();
        } else {
        	frm.password.focus();
        }
    }
    
	function funSave(){
		var frm = document.sysUserVo;
		
		if(!confirm('<spring:message code="message.alert.save"/>')){
			return;
		}
		
		if('edit' != frm.cmd.value) {
			frm.cmd.value = 'insert';
			// system_cd
			if(frm.system_cd.value == '') {
				alert("<spring:message code='sys.user.message.input_system_cd'/>");  
				frm.sel_system_cd.focus();
				return;
			}
			// user_id
			if(frm.user_nm.value == '') {
				alert("<spring:message code='sys.user.message.input_user_nm'/>");  
				frm.user_nm.focus();
				return;
			}
			// user_nm
			if(frm.user_nm.value == '') {
				alert("<spring:message code='sys.user.message.input_userid'/>");  
				frm.user_id.focus();
				return;
			}
			// password
			if(frm.password.value == '') {
				alert("<spring:message code='sys.user.message.input_password'/>");  
				frm.password.focus();
				return;
			} else if(frm.password.length < 6) {
				alert("<spring:message code='sys.user.message.input_password_length'/>");  
				frm.password.focus();
				return;
			}
		} else {
			frm.cmd.value = 'update';
			// user_nm
			if(frm.user_nm.value == '') {
				alert("<spring:message code='sys.user.message.input_userid'/>");  
				frm.user_id.focus();
				return;
			}
			// password
			if(frm.password.value != '' && frm.password.length < 6) {
				alert("<spring:message code='sys.user.message.input_password_length'/>");  
				frm.password.focus();
				return;
			} 
		}
		
		frm.action = '<%=contextLangPath%>/sys/user/'+frm.cmd.value;
		
		// password_confirm
		if(frm.password_confirm.value != frm.password.value) {
			alert("<spring:message code='sys.user.message.mismatch_password'/>");  
			frm.password_confirm.focus();
			return;
		}
		// user_id vs. password
		if(frm.user_id.value != '' && frm.password.value != '') {
			if(frm.user_id.value == frm.password.value) {
				alert("<spring:message code='sys.user.message.same_id_pw'/>");  
				frm.password_confirm.focus();
				return;
			}
		}
		// user_nm
		if(frm.user_nm.value == '') {
			alert("<spring:message code='sys.user.message.input_user_nm'/>");
			frm.user_nm.focus();
			return;
		}
		
		// granted_group_id
		if(frm.sel_granted_group_id.length != 0) {
			var item;
			var elem = document.getElementById("granted_group_id");
			elem.parentNode.removeChild(elem);
				
			$("select[name='sel_granted_group_id'] option").each(function(index){
				item = document.createElement('input');
				item.setAttribute('name', 'granted_group_id');
				item.setAttribute('type', 'hidden');
				item.value=$(this).val();
				frm.appendChild(item);
			});
		}
		
		frm.submit();
	}
	
	function funNew(){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/users/user';
		frm.cmd.value = "input";
		frm.submit();
	}
	
	function funUpdatePriv(){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/users/user';
		frm.cmd.value = 'update_priv';
		frm.submit();
	}
	
	function funClose(){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/user/list';
		frm.cmd.value = 'list';
		frm.submit();
	}
	
	function funChange(){
		var frm = document.sysUserVo;
		
		// group_system_cd
		$("#sel_group_system_cd").change(function(){
			var not_group_id = "";
			if(frm.sel_granted_group_id.length > 0) {
				for(var i=0; i<frm.sel_granted_group_id.length; i++) {
					not_group_id += "'" + frm.sel_granted_group_id[i].value + "',";
				}
				not_group_id = not_group_id.substring(0, not_group_id.length-1);
			} else {
				not_group_id = "''";
			}

			sendRequest({
    			action 		: '<%=contextLangPath%>/sys/tools/tool',
    			kind 		: '',
    			content 	: 'SYS',
    			code_find 	: 'GROUP_LIST',
    			order 		: '',
    			etcCond 	: " AND SYSTEM_CD = '" + $(this).val() + "' AND GROUP_ID NOT IN (" + not_group_id + ") ",
    			callbackFunc : 'funDisplayGroupId'
    		});
    	});
	}
	
	function funDisplayGroupId(obj){
		$("#sel_group_id").children('option').remove();
		Combo({
			data: obj,
			code_find: 'GROUP_LIST',	
			name: 'sel_group_id',
			selectCond: 'group_id'
		});
	}
	
	function funClickAuth(sys_priv, auth, checked_yn){
		if(auth == 0) {
			$('input:checkbox[name="chk_granted_authority"]').each(function(){
				var sys_priv_auth = $(this).val();
				var result 		= sys_priv_auth.indexOf(sys_priv, 0);
				var result_auth = sys_priv_auth.lastIndexOf("0");
				
				// 같은 권한
				if(result != -1) {	
					if(checked_yn == true) {	
						// 권한 0이 아닐 때
						if(result_auth == -1) {
							$(this).attr("disabled", true);
		 					$(this).attr("checked", false);
						} 
					} else {
						$(this).attr("disabled", false);
					}
				}
			});
		} 
	}
	
	function funGrant(){
		if($("select[name='sel_group_id']").val() == null || $("select[name='sel_group_id']").val() == '') {
			alert("<spring:message code='sys.user.message.no_group_to_grant'/>");
	        return false;
		}
		
		$("select[name='sel_group_id'] option").each(function(index){
			if($(this).prop("selected")) {
				$("select[name='sel_granted_group_id']").append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option> ");
				$(this).remove();
			}			
		});
	}
	
	function funGrantAll(){
		$("select[name='sel_group_id'] option").each(function(index){
			$("select[name='sel_granted_group_id']").append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option> ");
		});
		$("select[name='sel_group_id'] option").remove();
	}
		
	function funRevoke(){
		if($("select[name='sel_granted_group_id']").val() == null || $("select[name='sel_granted_group_id']").val() == '') {
			alert("<spring:message code='sys.user.message.no_group_to_revoke'/>");
	        return false;
		}
		
		$("select[name='sel_granted_group_id'] option").each(function(index){
			if($(this).prop("selected")) {
				$("select[name='sel_group_id']").append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option> ");	
				$(this).remove();
			}
		});
	}
	
	function funRevokeAll(){
		$("select[name='sel_granted_group_id'] option").each(function(index){
			$("select[name='sel_group_id']").append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option> ")
		});
		$("select[name='sel_granted_group_id'] option").remove();
	}
	
	function isValidNum(event) {
		if (event) {
			var charCode = (event.which) ? event.which : event.keyCode;
			if (charCode != 190 && charCode > 31 && (charCode < 48 || charCode > 57) &&  (charCode < 96 || charCode > 105) && 
		       (charCode < 37 || charCode > 40) && charCode != 110 && charCode != 8 && charCode != 46 )
		       return false;
		}
		return true;
	}
	
	function funPopUpPriv(){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/users/user';
		frm.cmd.value = "list_priv";
		window.open('', 'list_priv', 'width=1000, height=400, menubar=no, statusbar=no, scrollbars=yes');
		frm.target = "list_priv";
		frm.method = "post";
		frm.submit();
		//target reset
		frm.target = "";
	}
	
//]]>
</script>
