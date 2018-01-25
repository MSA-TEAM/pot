<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<form:form commandName="sysProgramVo" name="sysProgramVo" method="post">
<form:hidden path="cmd"/>
<form:hidden path="page"/>
<form:hidden path="p_menu_id"/>
<form:hidden path="p_menu_lvl"/>
<form:hidden path="p_menu_ord"/>
<form:hidden path="search_system_cd"/>
<form:hidden path="menu_id"/>
<form:hidden path="menu_lvl"/>
<form:hidden path="menu_ord"/>
<form:hidden path="sub_ord"/>
<form:hidden path="access_priv"/>
<form:hidden path="system_cd"/>


	<div class="contents_wrap_01">
		<div class="contents_top">
			<div class="con_title">프로그램 리스트</div>
			<ul class="con_location">
				<li>Home</li>
				<li>프로그램 리스트</li>
			</ul>
		</div>
		<div id="contents">
			<!-- ▼contents▼ -->
			<div class="search_area_01" style="margin:0 0 20px 0;">
				<select class="select_01" style="width:200px;" id="sel_system_cd" name="sel_system_cd" onchange="javascript:{setValue('search_system_cd', this.value);};" ></select>
	
				<a href="#void" onclick="javascript:{funSearch()}" class="btn_004">Search</a>
			</div>

			<table class="table_list_01">
				<colgroup>
					<col width="100px">
					<col width="300px">
					<col width="100px">
					<col width="">
					<col width="70px">
					<col width="85px">
					<col width="85px">
				</colgroup>
				<thead>
					<tr>
						<th><spring:message code="sys.program.header.number"/></th>
						<th><spring:message code="sys.program.header.menu_nm"/></th>
						<th><spring:message code="sys.program.header.menu_lvl"/></th>
						<th><spring:message code="sys.program.header.control"/></th>
						<th><spring:message code="sys.program.header.use"/></th>
						<th>
							<c:if test="${sysProgramVo.cmd == 'list'}">
<!-- 								<button type="reset" class="btn-white-s" onclick="javascript:{funNew('new', 'new');}"><span>등록</span></button> -->
								<a onclick="javascript:{funNew('new', 'new');}" class="btn_02">등록</a>
								
							</c:if>
						</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${sysProgramVo.list}" varStatus="status">
						<tr>
							<a>
								<td onclick="javascript:{funEdit('${data.MENU_ID}', '${data.MENU_LVL}', '${data.MENU_ORD}');}"><c:out value="${data.RN}"/></td>
								<td class="left" onclick="javascript:{funEdit('${data.MENU_ID}', '${data.MENU_LVL}', '${data.MENU_ORD}');}">
									<c:if test="${data.MENU_LVL != 0}">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</c:if>
									<c:out value="${data.MENU_NM }"/>
								</td>
								<td onclick="javascript:{funEdit('${data.MENU_ID}', '${data.MENU_LVL}', '${data.MENU_ORD}');}"><c:out value="${data.MENU_LVL }"/></td>
								<td class="left" onclick="javascript:{funEdit('${data.MENU_ID}', '${data.MENU_LVL}', '${data.MENU_ORD}');}"><c:out value="${data.CONTROL_URL }"/></td>
								<td onclick="javascript:{funEdit('${data.MENU_ID}', '${data.MENU_LVL}', '${data.MENU_ORD}');}"><c:out value="${data.USE_YN }"/></td>
							</a>
							<c:choose>
								<c:when test="${data.MENU_LVL != 0}">
									<td></td>
									<td><a onclick="javascript:{funDelete('${data.MENU_ID}','${data.MENU_LVL}','${data.MENU_ORD}');}" class="btn_01">삭제</a></td>
								</c:when>
								<c:otherwise>
									<td><a onclick="javascript:{funNew('${data.MENU_LVL}','${data.MENU_ORD}', '${data.MENU_ID}');}"}" class="btn_02">등록</a></td>
									<td><a onclick="javascript:{funDelete('${data.MENU_ID}','${data.MENU_LVL}','${data.MENU_ORD}');}" class="btn_01">삭제</a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
					
					<c:if test="${sysProgramVo.list.size() eq 0 }">
						<tr>
							<td colspan="7">
								<span>There is no data.</span>
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>

		</div><!-- // contents -->
		
	</div>

</form:form>
<script type="text/javascript">
//<![CDATA[
	var list = new Grid();       
	
	$(document).ready(function(){
		var result = ${sysProgramVo.result};
		Combo({
			data:result,
			code_find:'SYSTEM_CD',
			name:'sel_system_cd',
			selectCond:'search_system_cd',
			blankCond: 'All'
		});
	});
	
	
	function funSearch(){
		var frm = document.sysProgramVo;
		if((null != frm.search_system_cd.value && '' != frm.search_system_cd.value) == false){
			alert('<spring:message code="sys.group.message.system_cd"/>')
			return false;
		}
    	frm.action = '<%=contextLangPath%>/sys/program/list';
    	frm.cmd.value="list";
    	frm.submit();
	}
	
	// new
    function funNewLevel0() {
    	var frm = document.sysProgramVo;
    	frm.action = '<%=contextLangPath%>/sys/programs/program';
    	frm.system_cd.value = frm.search_system_cd.value;
    	frm.access_priv.value = "";
    	frm.menu_id.value = "0";
    	frm.menu_lvl.value = "0";
    	frm.menu_ord.value = "0";
    	frm.sub_ord.value = "0";
    	frm.cmd.value="input";
    	frm.submit();
    }

	function goInsert(_param1, _param2){
		var frm = document.sysProgramVo;
		frm.action = '<%=contextLangPath%>/sys/programs/program';
		frm.system_cd.value = frm.search_system_cd.value;
		frm.menu_id.value = "0";
		frm.menu_lvl.value = "1";
		frm.menu_ord.value = _param1;
		frm.sub_ord.value = "0";
		frm.access_priv.value = _param2;
		frm.cmd.value = 'input';
		frm.submit(); 
	}
	
	function funNew(menu_lvl, menu_ord, menu_id){
		var frm = document.sysProgramVo;
		if((null != frm.search_system_cd.value && '' != frm.search_system_cd.value) == false){
			alert('<spring:message code="sys.group.message.system_cd"/>')
			return false;
		}
   		frm.action = '<%=contextLangPath%>/sys/program/input';
   		frm.p_menu_lvl.value = menu_lvl;
   		frm.p_menu_ord.value = menu_ord;
   		frm.p_menu_id.value = menu_id;
   		frm.system_cd.value = frm.search_system_cd.value;
   		frm.cmd.value = 'input';
   		frm.submit();
	}
	
	function funEdit(menu_id, menu_lvl, menu_ord){
		var frm = document.sysProgramVo;
   		frm.action = '<%=contextLangPath%>/sys/program/edit';
   		frm.p_menu_id.value = menu_id;
   		frm.p_menu_lvl.value = menu_lvl;
   		frm.p_menu_ord.value = menu_ord;
   		frm.cmd.value = 'edit';
   		frm.submit();
	}
	
	function funDelete(menu_id, menu_lvl, menu_ord){
		var frm = document.sysProgramVo;
		if((null != frm.search_system_cd.value && '' != frm.search_system_cd.value) == false){
			alert('<spring:message code="sys.group.message.system_cd"/>')
			return false;
		}
		
		if('0' == menu_lvl && !confirm('<spring:message code="sys.program.message.confirm.level0_delete"/>')){
			return;
		}

		if(confirm('<spring:message code="message.alert.delete"/>')){
			var frm = document.sysProgramVo;
	   		frm.action = '<%=contextLangPath%>/sys/program/delete';
	   		frm.p_menu_id.value = menu_id;
	   		frm.p_menu_lvl.value = menu_lvl;
	   		frm.p_menu_ord.value = menu_ord;
	   		frm.cmd.value = 'delete';
	   		frm.submit();
		}
	}
	
		
	function goDelete(_param1, _param2, _param3){
		var frm = document.sysProgramVo;
		frm.action = '<%=contextLangPath%>/sys/programs/program';
		frm.system_cd.value = frm.search_system_cd.value;
		frm.menu_id.value = _param1;
		frm.menu_lvl.value = _param2;
		frm.menu_ord.value = _param3;
		frm.cmd.value = 'delete';
		if (confirm("<spring:message code='sys.message.confirm.delete'/>")) {
			frm.submit(); 
	    }
		
	}
//]]>
</script>
