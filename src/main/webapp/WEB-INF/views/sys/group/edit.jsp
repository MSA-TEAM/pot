<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form commandName="sysGroupVo" name="sysGroupVo" method="post">
<form:hidden path="cmd" />
<form:hidden path="page" />
<form:hidden path="p_group_id"/>
<!-- 새로 고침 시, 이전 페이지에서 보낸 데이터가 사라지므로 재정의 해줌(system_cd, group_id) -->
<form:hidden path="search_system_cd"/>
<form:hidden path="p_search_system_cd" />  
<form:hidden path="p_search_group_id" />
<form:hidden path="p1_search_system_cd" />



	<div class="contents_wrap_01">
		<div class="contents_top">
			<div class="con_title">그룹 등록/수정</div>
			<ul class="con_location">
				<li>Home</li>
				<li>그룹 관리</li>
				<li>그룹 등록/수정</li>
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
							<form:hidden path="system_cd"/>
						</dd>
					</dl>
				</div>
				
				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.group.header.group_id" /></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<form:input path="group_id" cssClass="input_01" readonly="true"/>
							</strong>
						</dd>
					</dl>
				</div>

				<div>
					<dl>
						<dt class="cell_01">
							<strong>
								<label for=""><span class="must_01"></span><spring:message code="sys.group.header.group_nm"/></label>
							</strong>
						</dt>
						<dd class="">
							<strong>
								<form:input path="group_nm" cssClass="input_01"/>
							</strong>
						</dd>
					</dl>
				</div>
			</div>
			<!--△table_write-->
			
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
    });
    
    function init(){
    	var frm = document.sysGroupVo;
		var result = ${sysGroupVo.result};
		
		Combo({
			data:result,
			code_find:'SYSTEM_CD',
			name:'sel_system_cd',
			selectCond:'system_cd',
			blankCond: ''
		});
		
		if('input' == frm.cmd.value){
			$('input[name="group_id"]').prop('readonly', false);
		}else{
			$('select[name="sel_system_cd"]').prop('disabled', true);
		}
	} 
    
   <%--  function funInsert(){
    	var frm = document.sysGroupVo;

         if (frm.search_group_id.value == '') {
             alert("<spring:message code="sys.group.message.group_id" />");
             frm.group_id.focus();
             return false;
         } else if (frm.group_nm.value == '') {
             alert("<spring:message code="sys.group.message.group_nm" />");
             frm.group_nm.focus();
             return false;
         }     	
    	
    	frm.cmd.value = 'insertAuthority';
		
		detailController({
			url:'<%=contextLangPath%>/sys/groups/group/'+frm.cmd.value,
			form: frm,
			keySet:{'search_system_cd':'system_cd',
					'search_group_id':'group_id'}
		});
		
		
		frm.submit();
    } --%>
    
    function selectAll(name) {
        var checkboxes = document.getElementsByClassName(name);
        
        if (checkboxes[0].checked == true) {
     		for(i=1; i<checkboxes.length; i++) {
     			checkboxes[i].checked = false;
     			checkboxes[i].disabled = true;
    		}
  	  	} else {
     		for(i=1; i<checkboxes.length; i++) {
     			checkboxes[i].disabled = false;
      		}
    	}
    }
    
    
    function funSave(){
    	var frm = document.sysGroupVo;
    	
    	if (frm.group_id.value == '') {
	        alert("<spring:message code="sys.group.message.group_id" />");
	        frm.group_id.focus();
	        return false;
	    } else if (frm.group_nm.value == '') {
	        alert("<spring:message code="sys.group.message.group_nm" />");
	        frm.group_nm.focus();
	        return false;
	    }   	
	    
		if(frm.cmd.value == 'input'){
			frm.cmd.value = 'insert';
		}else if(frm.cmd.value == 'edit'){
			frm.cmd.value = 'update';
		}
		frm.action = '<%=contextLangPath%>/sys/group/'+frm.cmd.value,
		frm.submit(); 
    }
    
	function funUpdate(){
		var frm = document.sysGroupVo;

		if (frm.group_id.value == '') {
	        alert("<spring:message code="sys.group.message.group_id" />");
	        frm.group_id.focus();
	        return false;
	    } else if (frm.group_nm.value == '') {
	        alert("<spring:message code="sys.group.message.group_nm" />");
	        frm.group_nm.focus();
	        return false;
	    }   	
	    
		if(frm.cmd.value == 'input'){
			frm.cmd.value = 'insert';
			
			detailController({
				url:'<%=contextLangPath%>/sys/groups/group/'+frm.cmd.value,
				form: frm,
				keySet:{'p_search_system_cd':'system_cd'}
			});
			
			frm.p_search_group_id.value=frm.system_cd.value+ '_'+ frm.group_id.value;
		
		}else if(frm.cmd.value == 'edit'){
			frm.cmd.value = 'update';
			
			detailController({
				url:'<%=contextLangPath%>/sys/groups/group/'+frm.cmd.value,
				form: frm,
				keySet:{'p_search_system_cd':'system_cd',
						'p_search_group_id':'group_id'
						} 
			});
		}
		
		frm.submit(); 
	}
	
	function funClose(){
		var frm = document.sysGroupVo;
		var key = ['p_group_id'];
		var url = '<%=contextLangPath%>/sys/group/list';
		location.href = getQueryStringUrl(frm, url, key);
	}
//]]>
</script>
