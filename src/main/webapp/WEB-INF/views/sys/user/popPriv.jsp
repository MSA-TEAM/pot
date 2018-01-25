<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
</head>
<form:form commandName="sysUserVo" name="sysUserVo" method="post">
<form:hidden path="cmd"/>
<form:hidden path="priv_system_cd"/>
<form:hidden path="system_cd"/>
<form:hidden path="p_user_id"/>
<form:hidden path="user_nm"/>
	<div id="sicc_message"></div>
	<div id="data_area">
		<table id="table" width="100%" class="b_table">
			<tr>
				<td width="30%" class="header"><spring:message code="sys.user.header.access_priv"/></td>
				<td class="header_endlist">
					<select class="item" id="sel_priv_system_cd" name="sel_priv_system_cd" onchange="javascript:{setValue('priv_system_cd', this.value); };" ></select>
				</td>
			</tr>
		</table>
		<table id="d_table" style="width:100%;" class="a_table">
			<thead>
				<tr>
					<td id="rn" width="6%"><spring:message code="sys.user.header.number"/></td>
					<td id="system_cd" width="8%"><spring:message code="sys.user.header.system"/></td>
					<td id="access_priv_nm" width="24%"><spring:message code="sys.user.header.access_priv_nm"/></td>
					<td id="commit_priv" ><spring:message code="sys.user.header.commit_priv"/></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list_priv" items="${sysUserVo.list_priv}" varStatus="status" >
				<tr>
					<td><c:out value="${status.count }"></c:out></td>
					<td><c:out value="${list_priv.SYSTEM_CD }"></c:out></td>
					<td><c:out value="${list_priv.ACCESS_NM }"></c:out></td>
					<td>
						<c:forEach var="list_auth" items="${sysUserVo.list_auth}">
							<input type="checkbox" name="chk_group_authority" id="chk_group_authority" value="${list_priv.SYSTEM_CD}/${list_priv.ACCESS_PRIV}/${list_auth.MINOR_CD}" 
									onclick="javascript:{funClickAuth('${list_priv.SYSTEM_CD}/${list_priv.ACCESS_PRIV}/', '${list_auth.MINOR_CD}', this.checked);};" />
							<c:out value="${list_auth.CODE_NM2 }"></c:out>&nbsp;&nbsp;
						</c:forEach>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="button_area" class="right">
		<span id="new_bt" class="button" onclick="javascript:{funAddPriv();};"><spring:message code="sys.user.header.add_priv"/></span>
		<span id="new_bt" class="button_g" onclick="javascript:{funClose();};"><spring:message code="button.close"/></span>
	</div>
</form:form>
<script type="text/javascript">
//<![CDATA[
           
    $(document).ready(function(){
    	var frm = document.sysUserVo;
    	init();
    	
    	funChange();
    });
    
    function init(){
		var result = '${sysUserVo.result}';
		
		Combo({
			data:result,
			code_find: 'SYSTEM_CD',
			name: 'sel_priv_system_cd',
			selectCond: 'priv_system_cd',
			blankCond: ''
		});
    }
    
    function funChange(){
		var frm = document.sysUserVo;
		// priv_system_cd
		$("#sel_priv_system_cd").change(function(){
			frm.action = '<%=contextLangPath%>/sys/users/user';
			frm.cmd.value = 'list_priv';
			frm.submit();
		});
	}
    
    function funAddPriv(){
		var frm = document.sysUserVo;
		frm.action = '<%=contextLangPath%>/sys/users/user';
		frm.cmd.value = 'insert_priv';
		frm.submit();
	}
    
    function funClose(){
		self.close();
	}
    
    function funClickAuth(sys_priv, auth, checked_yn){
		if(auth == 0) {
			$('input:checkbox[name="chk_group_authority"]').each(function(){
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
	
//]]>
</script>
</html>
