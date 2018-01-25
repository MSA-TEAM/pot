<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<form:form commandName="sysProgramVo" name="sysProgramVo" method="post">
<form:hidden path="cmd"/>
<form:hidden path="page"/>
<form:hidden path="use_yn"/>
<form:hidden path="popup_yn"/>
<form:hidden path="disable_yn"/>
<form:hidden path="p_menu_id"/>
<form:hidden path="p_menu_lvl"/>
<form:hidden path="p_menu_ord"/>
<form:hidden path="access_priv"/>
<form:hidden path="menu_id"/>
<form:hidden path="group_id"/>
<form:hidden path="granted_group_id"/>
<form:hidden path="group_system_cd"/>
<form:hidden path="menu_ord"/>
<form:hidden path="menu_ord_list"/>
<form:hidden path="search_system_cd"/>

	<div class="contents_wrap_01">
		<div class="contents_top">
			<div class="con_title">프로그램 등록/수정</div>
			<ul class="con_location">
				<li>Home</li>
				<li>프로그램 관리</li>
				<li>프로그램 등록/수정</li>
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
								<c:choose>
									<c:when test="${sysProgramVo.cmd == 'input' && sysProgramVo.p_menu_lvl == 'new'}">
										<select class="select_01" id="sel_system_cd" name="sel_system_cd" onchange="javascript:{setValue('system_cd', this.value);}"></select>
										<form:hidden path="system_cd"/>
									</c:when>
									<c:otherwise>
										<form:input path="system_cd" cssClass="input_01" readonly="true"/>
									</c:otherwise>
								</c:choose>	
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.program.header.menu_lvl"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<form:input path="menu_lvl" cssClass="input_01" readonly="true"/>
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.program.header.menu_nm"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<form:input path="menu_nm" cssClass="input_01"/>
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.program.header.menu_nm"/>(영문)</label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<form:input path="menu_nm1" cssClass="input_01"/>
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.program.header.control_id"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<form:input path="control_url" cssClass="input_01"/>
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
								<label for=""><spring:message code="sys.user.header.popup_yn"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<input type="checkbox" class="checkbox_01" id="chk_popup_yn" name="chk_popup_yn" onclick="javascript:{funChkEvent();}"> <label for="chk_popup_yn">Y/N</label>						
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for="">비활성 Y/N</label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<input type="checkbox" class="checkbox_01" id="chk_disable_yn" name="chk_disable_yn" onclick="javascript:{funChkEvent();}"> <label for="chk_disable_yn">Y/N</label>						
							</strong>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.program.header.menu_ord"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>					
								<select class="multi_select_01" style="width:500px; height:200px;"id="sel_menu_ord_list" name="sel_menu_ord_list" multiple="multiple"></select>
								</select>					
							
								<ul class="arrows_btn_02" style="vertical-align:middle;">
									<li><a href="javascript:{UP();}">위로 이동</a></li>
									<li><a href="javascript:{DOWN();}">아래로 이동</a></li>
								</ul>
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
								<select class="select_01" style="width:330px;" id="sel_group_system_cd" name="sel_group_system_cd" onchange="javascript:{setValue('group_system_cd', this.value);};" ></select>
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

								<select class="multi_select_01" style="height:144px;" id="sel_granted_group_id" name="sel_granted_group_id" multiple="multiple" onchange="javascript:{setValue('granted_group_id', this.value);};" ></select>
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
    	init();
    	isValidCheck();
    });
    
    function addOption(obj, value, text){
    	$("select[name='"+obj+"']").append("<option value='" + value + "' selected>" + text + "</option> ");
    }
    
    function init(){
    	var result = ${sysProgramVo.result};
    	
    	var frm = document.sysProgramVo;
    	
    	Combo({
			data:result,
			code_find:'MENU_LIST',
			name:'sel_menu_ord_list',
			selectCond:'menu_ord_list'
		});
    	
    	Combo({
			data:result,
			code_find:'SYSTEM_CD',
			name:'sel_group_system_cd',
			selectCond:'group_system_cd',
			blankCond:'All Systems...'
		});
    	
		SubCombo({
			data:result,
			code_find:'PROGRAM_GROUP_LIST',
			name:'sel_group_id',
			selectCond:'group_id',
			base_target:'sel_group_system_cd',
			follower:'CODE_IDX1'
		});
		
		if('input' != frm.cmd.value){
			Combo({
				data:result,
				code_find:'GRANTED_PROGRAM_GROUP_LIST',
				name:'sel_granted_group_id',
				selectCond:'granted_group_id'
			});			
		}else{
			$('#chk_use_yn').prop('checked', true);
    		$('#use_yn').val('Y');
		}
		
		
		if('input' == frm.cmd.value && 'new' == frm.p_menu_lvl.value){
    		frm.menu_lvl.value = 0;
    		addOption('sel_menu_ord_list', 'new', 'Level 0 Menu');
    		
    		Combo({
    			data:result,
    			code_find:'SYSTEM_CD',
    			name:'sel_system_cd',
    			selectCond:'system_cd',
    			blankCond:''
    		});
    	}else if('input' == frm.cmd.value && 'new' != frm.p_menu_lvl.value){
    		frm.menu_lvl.value = 1;
    		addOption('sel_menu_ord_list', 'new', 'Level 1 Menu');
    	}
			
	
// 		if('${sysProgramVo.access_priv}' == '' || '${sysProgramVo.access_priv}' == null)
// 		{
// 			document.sysProgramVo.sel_accesspriv_cd[0].selected = true;
// 			document.sysProgramVo.access_priv.value = document.sysProgramVo.sel_accesspriv_cd[0].value; 	
// 		}
	}
    
    function isValidCheck(){
    	if($('#use_yn').val()=='Y'){
    		$('#chk_use_yn').prop('checked', true);
    	}else{
    		$('#chk_use_yn').prop('checked', false);
    	}
    	if($('#popup_yn').val()=='Y'){
    		$('#chk_popup_yn').prop('checked', true);
    	}else{
    		$('#chk_popup_yn').prop('checked', false);
    	}
    	if($('#disable_yn').val()=='Y'){
    		$('#chk_disable_yn').prop('checked', true);
    	}else{
    		$('#chk_disable_yn').prop('checked', false);
    	}
    }
    
    function funChkEvent(){
    	if($('#chk_use_yn').prop('checked')){
    		$('#chk_use_yn').prop('checked', true);
    		$('#use_yn').val('Y');
    	}else{
    		$('#chk_use_yn').prop('checked', false);
    		$('#use_yn').val('');
    	}
    	if($('#chk_popup_yn').prop('checked')){
    		$('#chk_popup_yn').prop('checked', true);
    		$('#popup_yn').val('Y');
    	}else{
    		$('#chk_popup_yn').prop('checked', false);
    		$('#popup_yn').val('');
    	}
    	if($('#chk_disable_yn').prop('checked')){
    		$('#chk_disable_yn').prop('checked', true);
    		$('#disable_yn').val('Y');
    	}else{
    		$('#chk_disable_yn').prop('checked', false);
    		$('#disable_yn').val('');
    	}
    }
    
    function funSave(){
    	var frm = document.sysProgramVo;
    	var url;
    	
    	if (frm.menu_nm.value == "") {
	        alert("<spring:message code='sys.program.message.input_menu'/>");
	        frm.menu_nm.focus();
	        return false;
	    }
	      
	    if (frm.menu_nm1.value == "") {
	    	alert("<spring:message code='sys.program.message.input_menu_en'/>");
	    	frm.menu_nm1.focus();
	    	return false;
	    }
	    
	    if (frm.control_url.value == "") {
	    	alert("<spring:message code='sys.program.message.input_control_url'/>");
	    	frm.control_url.focus();
	    	return false;
	    }
    	
    	if('input' == frm.cmd.value){
    		url = 'insert';
    	}else{
    		url = 'update';
    	}
    	
    	frm.action = '<%=contextLangPath%>/sys/program/'+url;
    	frm.cmd.value = url;
    	
    	// menu_ord_list
		if(frm.sel_menu_ord_list.length != 0) {
			var item;
				
			$("select[name='sel_menu_ord_list'] option").each(function(index){
				item = document.createElement('input');
				item.setAttribute('name', 'hd_order_list');
				item.setAttribute('type', 'hidden');
				item.value=$(this).val();
				frm.appendChild(item);
			});
		}
    	
		// granted_group_id
		if(frm.sel_granted_group_id.length != 0) {
			var item;
				
			$("select[name='sel_granted_group_id'] option").each(function(index){
				item = document.createElement('input');
				item.setAttribute('name', 'hd_granted_group_id');
				item.setAttribute('type', 'hidden');
				item.value=$(this).val();
				frm.appendChild(item);
			});
		}
		
		
		frm.submit();
    }
    
	function funUpdate(_param1,_param2){
		var frm = sysProgramVo;
	      
	      if (frm.menu_nm.value == "") {
	        alert("<spring:message code='sys.program.message.input_menu'/>");
	        frm.menu_nm.focus();
	        return false;
	      }
	      
	      if (frm.menu_nm1.value == "") {
		        alert("<spring:message code='sys.program.message.input_menu_en'/>");
		        frm.menu_nm1.focus();
		        return false;
		      }
	      
	      if (_param2 != "0") {
	        if (frm.control_id.value == "") {
	          alert("<spring:message code='sys.program.message.input_control_url'/>");
	          frm.control_id.focus();
	          return false;
	        } else if (frm.control_kind.value == "") {
	          alert("<spring:message code='sys.program.message.input_cmd'/>");
	          frm.control_kind.focus();
	          return false;
	        }
	      } 

		$('#use_yn').val();
		if('input' == frm.cmd.value){
			if (confirm("<spring:message code='sys.message.confirm.save'/>")) {
				for (var i = 0; i < frm.menu_ord_list.length; i++) {
	                frm.menu_ord_list[i].selected = true;
	            }
				frm.cmd.value = 'insert';
				
				detailController({
					url:'<%=contextLangPath%>/sys/programs/program/'+frm.cmd.value,
					form: frm,
					keySet:{'p_menu_id':'menu_id'}
				}); 
				frm.submit();
			} 
		}else{
			if (confirm("<spring:message code='sys.message.confirm.modify'/>")) {
				for (var i = 0; i < frm.menu_ord_list.length; i++) {
					frm.menu_ord_list[i].selected = true;
	            }
				frm.cmd.value = 'update';
				
				detailController({
					url:'<%=contextLangPath%>/sys/programs/program/'+frm.cmd.value,
					form: frm,
					keySet:{'p_menu_id':'menu_id'}
				}); 
				frm.submit();
			} 
		}

	}
	
	function funClose() {
		var frm = document.sysProgramVo;
		frm.action = '<%=contextLangPath%>/sys/program/list';
		frm.cmd.value = 'list';
		frm.submit();
	}
	
	 
	function UP() {
		var frm = document.sysProgramVo;
		var value = frm.sel_menu_ord_list.value;
		var index = funSelectICheck(frm.sel_menu_ord_list);
		if (index == 0) {
			alert("top!");
			return false;
		}
		var temp1 = frm.sel_menu_ord_list.options[index - 1].text;
		frm.sel_menu_ord_list.options[index - 1].text = frm.sel_menu_ord_list.options[index].text;
		frm.sel_menu_ord_list.options[index].text = temp1;

		var temp2 = frm.sel_menu_ord_list.options[index - 1].value;
		frm.sel_menu_ord_list.options[index - 1].value = frm.sel_menu_ord_list.options[index].value;
		frm.sel_menu_ord_list.options[index].value = temp2;

		frm.sel_menu_ord_list.options[index].selected = false;
		frm.sel_menu_ord_list.options[index - 1].selected = true;
	}

	
	function DOWN() {
		var frm = document.sysProgramVo;
		var value = frm.sel_menu_ord_list.value;
		var index = funSelectICheck(frm.sel_menu_ord_list);
		if (index == frm.sel_menu_ord_list.options.length - 1) {
			alert("bottom!");
			return false;
		}
		var temp1 = frm.sel_menu_ord_list.options[index + 1].text;
		frm.sel_menu_ord_list.options[index + 1].text = frm.sel_menu_ord_list.options[index].text;
		frm.sel_menu_ord_list.options[index].text = temp1;

		var temp2 = frm.sel_menu_ord_list.options[index + 1].value;
		frm.sel_menu_ord_list.options[index + 1].value = frm.sel_menu_ord_list.options[index].value;
		frm.sel_menu_ord_list.options[index].value = temp2;

		frm.sel_menu_ord_list.options[index].selected = false;
		frm.sel_menu_ord_list.options[index + 1].selected = true;
	}

	// Select Check
	function funSelectICheck(sel) {
		for (var i = 0; i < sel.options.length; i++) {
			if (sel.options[i].selected == true) {
				return i;
			}
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
//]]>
</script>
