<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<form:form commandName="sysGroupVo" name="sysGroupVo" method="get"> 
<form:hidden path="cmd"/>
<form:hidden path="page"/>
<form:hidden path="p_group_id"/>
<form:hidden path="group_system_cd"/>
<form:hidden path="search_system_cd"/>
<form:hidden path="p_search_system_cd"/>
<form:hidden path="p1_search_system_cd" />
<form:hidden path="p_search_group_id"/> 
<form:hidden path="p1_search_group_id"/> 



	<div class="contents_wrap_01">
		<div class="contents_top">
			<div class="con_title">그룹 관리</div>
			<ul class="con_location">
				<li>Home</li>
				<li>그룹 관리</li>
			</ul>
		</div>
		<div id="contents">
			<!-- ▼contents▼ -->
			<div class="search_area_01" style="margin:0 0 20px 0;">
				<select class="select_01" style="width:200px;" id="sel_system_cd" name="sel_system_cd" onchange="javascript:{setValue('search_system_cd', this.value);};" ></select>
	
				<a href="#void" onclick="javascript:{funSearch()}" class="btn_004">Search</a>
			</div>

			<table class="table_list_01 chk_01">
				<colgroup>
					<col width="42px">
					<col width="100px">
					<col width="150px">
					<col width="">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" id="c_00" class="checkbox_01" name="checkAll"><label></label></th>
						<th><spring:message code="sys.program.header.number"/></th>
						<th><spring:message code="sys.group.header.system"/></th>
						<th><spring:message code="sys.group.header.group_id"/></th>
						<th><spring:message code="sys.group.header.group_nm"/></th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="data" items="${sysGroupVo.list}" varStatus="status">
							<tr onclick="javascript:{funEdit('${data.GROUP_ID}');}">
								<td><input type="checkbox" class="checkbox_01"  name="checkOne" id="chk${status.count}" value="${data.GROUP_ID}"><label for="chk${status.count}"> </label></td>
								<td><c:out value="${data.RN}"/></td>
								<td><c:out value="${data.SYSTEM_CD }"/></td>
								<td><c:out value="${data.GROUP_ID }"/></td>
								<td><c:out value="${data.GROUP_NM }"/></td>
							</tr>
						</c:forEach>
						
						<c:if test="${sysGroupVo.list.size() eq 0 }">
							<tr>
								<td colspan="5">
									<span>There is no data.</span>
								</td>
							</tr>
						</c:if>
					</tbody>				
				</table>
				
				<c:if test="${sysGroupVo.list.size() ne 0 }">
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
	$(document).ready(function(){
		init();
	});
 	
	function init(){
		var result = ${sysGroupVo.result};
		Combo({
			data:result,
			code_find:'SYSTEM_CD',			// foreach/ option value 값
			name:'sel_system_cd', 			//$('select[name='+name_ref+']');
			selectCond:'search_system_cd',   //$('input[name='+selectCond_ref+']');
			blankCond: 'All Systems...'
		});
		
// 	 	if('${sysGroupVo.search_system_cd}' == null || '${sysGroupVo.search_system_cd}' == ""){
// 			document.sysGroupVo.search_system_cd.value = document.sysGroupVo.sel_system_cd[0].value;
// 		}  
	} 
	
	function funSearch(page){
		var frm = document.sysGroupVo;
		var url = '<%=contextLangPath%>/sys/group/list';
		frm.page.value = page;
		location.href = getQueryStringUrl(frm, url);
	}
	
	function funNew(){
		var frm = document.sysGroupVo;
		var url = '<%=contextLangPath%>/sys/group/input';
		frm.cmd.value = 'input';
		location.href = getQueryStringUrl(frm, url);
	}
	
	function funEdit(group_id){
		var frm = document.sysGroupVo;
		var url = '<%=contextLangPath%>/sys/group/edit';
		var key = ['p_group_id'];
		frm.cmd.value = 'edit';
		frm.p_group_id.value = group_id;
		location.href = getQueryStringUrl(frm, url, key);
	}

	function funDelete(){
		if(confirm('<spring:message code="confirm.delete"/>')){
			var frm = document.sysGroupVo;
			frm.action = '<%=contextLangPath%>/sys/group/delete';
			frm.cmd.value = 'delete';
			
			var item;
			for (var i = 0; i < frm.elements.length; i++) {
				var e = frm.elements[i];
				if ((e.name != 'checkbox') && (e.type == 'checkbox') && e.checked) {
					item = document.createElement('input');
					item.setAttribute('name', 'hd_group_id');
					item.setAttribute('type', 'hidden');
					item.value=e.value;
					frm.appendChild(item);
				}
			}
			frm.submit();
		}
	}
//]]>
</script>
