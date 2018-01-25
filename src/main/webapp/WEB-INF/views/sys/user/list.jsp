<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<form:form commandName="sysUserVo" name="sysUserVo" method="post">
<form:hidden path="cmd"/>
<form:hidden path="page"/>
<form:hidden path="p_user_id"/>
<form:hidden path="p_system_cd"/>
<form:hidden path="search_system_cd"/>
<form:hidden path="search_group_id"/>
<form:hidden path="search_user_nm"/>

	<div class="contents_wrap_01">
		<div class="contents_top">
			<div class="con_title">사용자 리스트</div>
			<ul class="con_location">
				<li>Home</li>
				<li>사용자 리스트</li>
			</ul>
		</div>
		<div id="contents">
			<!-- ▼contents▼ -->
			<div class="search_area_01" style="margin:0 0 20px 0;">
				<select class="select_01" style="width:200px;" id="sel_system_cd" name="sel_system_cd" onchange="javascript:{setValue('search_system_cd', this.value);};" ></select>
				<select class="select_01" style="width:200px;" id="sel_group_id" name="sel_group_id" onchange="javascript:{setValue('search_group_id', this.value);};" ></select>
				<form:input path="search_user_id" cssClass="input_01" style="width:200px;"  placeholder="USER ID"/>
				<a href="#void" onclick="javascript:{funSearch(1)}" class="btn_004">Search</a>
			</div>

			<table class="table_list_01 chk_01">
				<colgroup>
					<col width="42px">
					<col width="100px">
					<col width="150px">
					<col width="">
					<col width="">
					<col width="100px">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" id="c_00" class="checkbox_01" name="checkAll"><label></label></th>
						<th><spring:message code="sys.user.header.number"/></th>
						<th>System</th>
						<th><spring:message code="sys.user.header.user_id"/></th>
						<th><spring:message code="sys.user.header.user_nm"/></th>
						<th><spring:message code="sys.user.header.use_yn"/></th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="data" items="${sysUserVo.list}" varStatus="status">
							<tr onclick="javascript:{funEdit('${data.USER_ID}', '${data.SYSTEM_CD}');}">
								<form:hidden path="hd_user_id" value="${data.USER_ID}"/>
								<form:hidden path="hd_user_nm" value="${data.USER_NM}"/>
								<form:hidden path="hd_system_cd" value="${data.SYSTEM_CD}"/>
								
								
								<td><input type="checkbox" class="checkbox_01"  id="chk${status.count}" name="checkOne" value="${status.count-1}"><label for="chk${status.count}"> </label></td>
								<td><c:out value="${data.RN}"/></td>
								<td><c:out value="${data.SYSTEM_CD }"/></td>
								<td><c:out value="${data.USER_ID }"/></td>
								<td ><c:out value="${data.USER_NM }"/></td>
								<td><c:out value="${data.USE_YN }"/></td>
							</tr>
						</c:forEach>
						
						<c:if test="${sysUserVo.list.size() eq 0 }">
							<tr>
								<td colspan="5">
									<span>There is no data.</span>
								</td>
							</tr>
						</c:if>
					</tbody>				
				</table>
				
				<c:if test="${sysUserVo.list.size() ne 0 }">
					<jsp:include page="/WEB-INF/views/common/page/page.jsp"/>
				</c:if>
				
				<div class="btn_area_01">
					<div class="btn_right">
						<a id="btnAdd" class="btn_02" onclick="javascript:{funNew();}">등록</a>
						<a id="btnDel" class="btn_01" onclick="javascript:{funDelete();}">삭제</a>
					</div>
				</div>
					
			</div><!-- // contents -->
		
		</div>
</form:form>
<script type="text/javascript">
//<![CDATA[

// 	var list = new Grid();
	
	$(document).ready(function(){
// 		gridInit();
		init();
		
// 		funChange();
		
// 		$('#search_bt').click(function(){
// 			var frm = document.sysUserVo;
			
// 			// search_granted_group_id
// 			if(frm.sel_granted_group_id.length != 0) {
// 				var item;
// 				var elem = document.getElementById("search_granted_group_id");
				
// 				var array = new Array();
// 				$("select[name='sel_granted_group_id'] option").each(function(index){
// 					array.push($(this).val());
// 				});
// 				elem.value = array;
// 			}
			
// 			list.draw(true);
// 		});
		
// 		$('#delete_bt').click(function(){
// 			funDelete();
// 		});
		
// 		$('#new_bt').click(function(){
// 			funNew();
// 		});
	});
	
	function funSearch(page){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/user/list';
		frm.page.value = page;
		frm.submit();
	}
	
	function funChkEvent(){
		if(this.checked){
			this.checked = false;
		}else{
			this.checked = true;
		}
    }
	
	function init(){
		var result = ${sysUserVo.result};
		
		Combo({
			data:result,
			code_find:'SYSTEM_CD',
			name:'sel_system_cd',
			selectCond:'search_system_cd',
			blankCond: 'All Systems'
		});
		
		Combo({
			data: result,
			code_find: 'GROUP_LIST',	
			name: 'sel_group_id',
			selectCond: 'search_group_id',
			blankCond: 'All Group'
		});
		
// 		Combo({
// 			data: result,
// 			code_find: 'GRANTED_GROUP_LIST',
// 			name: 'sel_granted_group_id',
// 			selectCond: 'search_granted_group_id'
// 		});
	}
	
	function funNew(){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/user/input';
		frm.cmd.value = 'input';
		frm.submit();
	}
	
	function funEdit(user_id, system_cd){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/user/edit';
		frm.p_user_id.value = user_id;
		frm.p_system_cd.value = system_cd;
		frm.cmd.value = 'edit';
		frm.submit();
	}
	
	function funChk(){
	}
	
	function funDelete(){
		if(confirm('<spring:message code="confirm.delete"/>')){
			var frm = document.sysUserVo;
			frm.action = '<%=contextLangPath%>/sys/user/delete';
			frm.cmd.value = 'delete';
			
			var item;
			for (var i = 0; i < frm.elements.length; i++) {
				var e = frm.elements[i];
				if ((e.name != 'checkbox') && (e.type == 'checkbox') && e.checked) {
					item = document.createElement('input');
					item.setAttribute('name', 'chk');
					item.setAttribute('type', 'hidden');
					item.value=e.value;
					frm.appendChild(item);
				}
			}
			
			frm.submit();
		}
// 		list.deleteGrid({
<%-- 			url:'<%=contextLangPath%>/sys/users/delete', --%>
// 			chk:'chk',
// 			params:['hd_user_id','hd_user_nm','hd_system_cd'],
// 			confirm_msg:'delete?',
// 			uncheck_msg:'select delete item'
// 		});
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
    			callbackFunc : 'funDisplayGroupID'
    		});
    	});
	}
	
	function funDisplayGroupID(obj){
		$("#sel_group_id").children('option').remove();
		Combo({
			data: obj,
			code_find: 'GROUP_LIST',	
			name: 'sel_group_id',
			selectCond: 'search_group_id'
		});
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
