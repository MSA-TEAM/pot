<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%
	String modal = String.valueOf(request.getParameter("modal_id"));
	String zipcode = String.valueOf(request.getParameter("zipcode_panel_id"));
	String basic = String.valueOf(request.getParameter("basic_panel_id"));
%>
<input type="hidden" name="province_<%=modal%>">
<input type="hidden" name="city_<%=modal%>">

<div id="<%=modal%>" class="modal">
	<div class="modal-dim">&nbsp;</div>
	<!-- Modal content -->
	<div class="modal-content pop-wrap">
		<div class="modal-header" tabindex="-1">
			<p class="title"><spring:message code="cfs.title.address_srch"/></p>
			<a href="javascript:void(0);" class="close" tabindex="2"><i class="icon-close2"></i><span>레이어팝업 닫기</span></a>
		</div>
		<div class="modal-body find-address-wrap">
			<ul class="tab-type3">
				<li id="type_st_<%=modal%>" class="on"><a href="#zipcodeTab1" onClick="showTab(this, 'pop-tab-con');cleanElement_<%=modal%>();return false;"><spring:message code="cfs.header.st_address"/></a></li>
				<li id="type_ad_<%=modal%>"><a href="#zipcodeTab2" onClick="showTab(this, 'pop-tab-con');cleanElement_<%=modal%>();return false;">지번주소</a></li>
				<li id="type_bd_<%=modal%>"><a href="#zipcodeTab3" onClick="showTab(this, 'pop-tab-con');cleanElement_<%=modal%>();return false;">건물명</a></li>
			</ul>
<!-- 			도로명 주소 -->
	        <div id="zipcodeTab1" class="pop-tab-con">
	        	<div class="pop-dot-box">
					<p class="pop-dot-txt">검색방법 : 시/도 및 시/군/구 선택 후 도로명(~로, ~길)과 건물번호 입력 <span class="pop-txt-mobile">작성하시기 바랍니다.</span> </p>
					<p class="dot-des">예) 을지로5길 26 <strong class="pop-essential" title="다음">다음</strong> 서울특별시 + 중구 + 을지로5길 <strong>(도로명)</strong> + 26 <strong>(건물번호)</strong> 입력 후 검색</p>
				</div>

				<div class="table-wrap">
					<div class="table-form">
						<div class="row">
	                        <div class="cell-title"> <label for="tab1_sel_province_<%=modal%>"><spring:message code="cfs.header.province"/></label> </div>
	                        <div class="cell-content">
	                            <span class="selB full">
	                                <select name="tab1_sel_province_<%=modal%>" id="tab1_sel_province_<%=modal%>">
	                                </select>
	                            </span>
	                            <div class="validation-text"><spring:message code="cfs.addr.message.select_province"/></div><!--D : 필수입력 항목에 공통 적용 / SB참고-->
	                        </div>
						</div>
						<div class="row">
	                        <div class="cell-title"> <label for="tab1_sel_city_<%=modal%>"><spring:message code="cfs.header.city"/></label> </div>
	                        <div class="cell-content">
	                            <span class="selB full">
	                                <select name="tab1_sel_city_<%=modal%>" id="tab1_sel_city_<%=modal%>">
	                                </select>
	                            </span>
	                            <div class="validation-text"><spring:message code="cfs.addr.message.select_city"/></div>
							</div>
						</div>
						<div class="row">
	                        <div class="cell-title"> <label for="tab1_st_nm_<%=modal%>"><spring:message code="cfs.header.st_nm"/></label> </div>
	                        <div class="cell-content">
	                            <input class="inptB full" type="text" name="tab1_st_nm_<%=modal%>" id="tab1_st_nm_<%=modal%>" value="" placeholder="예) 을지로5길" title="도로명 입력">
	                        </div>
						</div>
						<div class="row">
	                        <div class="cell-title"> <label for="tab1_bldg_no_<%=modal%>"><spring:message code="cfs.header.bldg_no"/></label> </div>
	                        <div class="cell-content">
	                            <input class="inptB full" type="text" name="tab1_bldg_no_<%=modal%>" id="tab1_bldg_no_<%=modal%>" value="" placeholder="예) 26" title="건물번호 입력">
	                        </div>
						</div>
					</div>
				</div>

				<div class="btn-wrap mobile-one"><!-- mobile-one, mobile-two, mobile-three -->
					<div class="btn-inner-wrap">
						<a href="javascript:;" id="tab1_search_bt_<%=modal%>">
							<div class="btn-blue"><spring:message code="button.search"/></div>
						</a>
					</div>
				</div>

				<div class="pop-adress-list" id="tab1_list_<%=modal%>">
				</div>
	        </div>
<!-- 	        지번주소 -->
	        <div id="zipcodeTab2" class="pop-tab-con" style="display:none;">
	        	<div class="pop-dot-box">
					<p class="pop-dot-txt">검색방법 : 시/도 및 시/군/구 선택 후 도로명(~로, ~길)과 건물번호 입력 <span class="pop-txt-mobile">작성하시기 바랍니다.</span> </p>
					<p class="dot-des">예) 저동2가 <strong class="pop-essential" title="다음">다음</strong> 서울특별시 + 중구 + 저동2가 <strong>(읍/면/동)</strong> + 100 <strong>(번지)</strong> 입력 후 검색</p>
				</div>

				<div class="table-wrap">
					<div class="table-form">
						<div class="row">
	                        <div class="cell-title"> <label for="tab2_sel_province_<%=modal%>"><spring:message code="cfs.header.province"/></label> </div>
	                        <div class="cell-content">
	                            <span class="selB full">
	                                <select name="tab2_sel_province_<%=modal%>" id="tab2_sel_province_<%=modal%>">
	                                </select>
	                            </span>
	                            <div class="validation-text"><spring:message code="cfs.addr.message.select_province"/></div>
	                        </div>
						</div>
						<div class="row">
	                        <div class="cell-title"> <label for="tab2_sel_city_<%=modal%>"><spring:message code="cfs.header.city"/></label> </div>
	                        <div class="cell-content">
	                            <span class="selB full">
	                                <select name="tab2_sel_city_<%=modal%>" id="tab2_sel_city_<%=modal%>">
	                                </select>
	                            </span>
	                            <div class="validation-text"><spring:message code="cfs.addr.message.select_city"/></div>
							</div>
						</div>
						<div class="row">
	                        <div class="cell-title"> <label for="tab2_dong_nm_<%=modal%>">읍/면/동</label> </div>
	                        <div class="cell-content">
	                            <input class="inptB full" type="text" name="tab2_dong_nm_<%=modal%>" id="tab2_dong_nm_<%=modal%>" value="" placeholder="예) 저동2가" title="읍/면/동 입력">
	                        </div>
						</div>
						<div class="row">
	                        <div class="cell-title"> <label for="tab2_addr_no_<%=modal%>">번지</label> </div>
	                        <div class="cell-content">
	                            <input class="inptB full" type="text" name="tab2_addr_no_<%=modal%>" id="tab2_addr_no_<%=modal%>" value="" placeholder="예) 26" title="번지 입력">
	                        </div>
						</div>
					</div>
				</div>

				<div class="btn-wrap mobile-one"><!-- mobile-one, mobile-two, mobile-three -->
					<div class="btn-inner-wrap">
						<a href="javascript:;" id="tab2_search_bt_<%=modal%>">
							<div class="btn-blue"><spring:message code="button.search"/></div>
						</a>
					</div>
				</div>

				<div class="pop-adress-list" id="tab2_list_<%=modal%>">
				</div>
	        </div>
<!-- 	        건물명 -->
			<div id="zipcodeTab3" class="pop-tab-con" style="display:none;">
				<div class="pop-dot-box">
					<p class="pop-dot-txt">검색방법 : 건물명 일부 입력 <span class="pop-txt-mobile">작성하시기 바랍니다.</span> </p>
					<p class="dot-des">예) 씨티센터타워, 파인에비뉴</p>
				</div>

				<div class="table-wrap">
					<div class="table-form">
						<div class="row">
	                        <div class="cell-title"> <label for="tab3_sel_province_<%=modal%>"><spring:message code="cfs.header.province"/></label> </div>
	                        <div class="cell-content">
	                            <span class="selB full">
	                                <select name="tab3_sel_province_<%=modal%>" id="tab3_sel_province_<%=modal%>">
	                                </select>
	                            </span>
	                            <div class="validation-text"><spring:message code="cfs.addr.message.select_province"/></div><!--D : 필수입력 항목에 공통 적용 / SB참고-->
	                        </div>
						</div>
						<div class="row">
	                        <div class="cell-title"> <label for="tab3_sel_city_<%=modal%>"><spring:message code="cfs.header.city"/></label> </div>
	                        <div class="cell-content">
	                            <span class="selB full">
	                                <select name="tab3_sel_city_<%=modal%>" id="tab3_sel_city_<%=modal%>">
	                                </select>
	                            </span>
	                            <div class="validation-text"><spring:message code="cfs.addr.message.select_city"/></div>
							</div>
						</div>
						<div class="row">
							<div class="cell-title"> <label for="tab3_bldg_nm_<%=modal%>">건물명</label> </div>
							<div class="cell-content">
								<input class="inptB full" type="text" id="tab3_bldg_nm_<%=modal%>" name="tab3_bldg_nm_<%=modal%>" value="" placeholder="예) 씨티센터타워, 파인에비뉴" title="건물명 입력">
								<!-- [D] 미입력시 노출 -->
							</div>
						</div>
					</div>
				</div>

				<div class="btn-wrap mobile-one"><!-- mobile-one, mobile-two, mobile-three -->
					<div class="btn-inner-wrap">
						<a href="javascript:;" id="tab3_search_bt_<%=modal%>">
							<div class="btn-blue"><spring:message code="button.search"/></div>
						</a>
					</div>
				</div>

				<div class="pop-adress-list" id="tab3_list_<%=modal%>">
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
//<![CDATA[
	$(document).ready(function(){
		var me = this;
		var modal_id = '<%=modal%>';
		
		$('select[name="tab1_sel_province_'+modal_id+'"],select[name="tab2_sel_province_'+modal_id+'"],select[name="tab3_sel_province_'+modal_id+'"]').change(function(){
			$('input[name="province_'+modal_id+'"]').val($(this).children('option:selected').text());
		});
		$('select[name="tab1_sel_city_'+modal_id+'"],select[name="tab2_sel_city_'+modal_id+'"],select[name="tab3_sel_city_'+modal_id+'"]').change(function(){
			$('input[name="city_'+modal_id+'"]').val($(this).children('option:selected').text());
		});
		
		$('a[id="tab1_search_bt_'+modal_id+'"]').click(function(){
			searchAddress_<%=modal%>('st');
		});
		$('a[id="tab2_search_bt_'+modal_id+'"]').click(function(){
			searchAddress_<%=modal%>('ad');
		});
		$('a[id="tab3_search_bt_'+modal_id+'"]').click(function(){
			searchAddress_<%=modal%>('bd');
		});
		
		sendRequest({
			action:'/<%=lang%>/cmm/tools/tool',
			params:{
				condition:[{
					system_cd:'TCO',
					code_find:'PROVINCE_CD'
				},{
					system_cd:'TCO',
					code_find:'CITY_CD'
				}]
			},
			callbackFunc:toolsCallback_<%=modal%>,
			callbackParams:{
				opener : me
			}
		});
	});
	
	function toolsCallback_<%=modal%>(data, params){
		var me = params.opener;
		var modal_id = '<%=modal%>';
		
		Combo({
			data:data,
			code_find:'PROVINCE_CD',
			name:'tab1_sel_province_'+modal_id,
			selectCond:'province_'+modal_id,
			blankCond:'<spring:message code="header.all"/>'
		});
		
		SubCombo({
			data:data,
			code_find:'CITY_CD',
			name:'tab1_sel_city_'+modal_id,
			selectCond:'city_'+modal_id,
			blankCond:'<spring:message code="header.all"/>',
			base_target:'tab1_sel_province_'+modal_id,
			follower:'CODE_IDX1'
		});
		
		Combo({
			data:data,
			code_find:'PROVINCE_CD',
			name:'tab2_sel_province_'+modal_id,
			selectCond:'province_'+modal_id,
			blankCond:'<spring:message code="header.all"/>'
		});
		
		SubCombo({
			data:data,
			code_find:'CITY_CD',
			name:'tab2_sel_city_'+modal_id,
			selectCond:'city_'+modal_id,
			blankCond:'<spring:message code="header.all"/>',
			base_target:'tab2_sel_province_'+modal_id,
			follower:'CODE_IDX1'
		});
		
		Combo({
			data:data,
			code_find:'PROVINCE_CD',
			name:'tab3_sel_province_'+modal_id,
			selectCond:'province_'+modal_id,
			blankCond:'<spring:message code="header.all"/>'
		});
		
		SubCombo({
			data:data,
			code_find:'CITY_CD',
			name:'tab3_sel_city_'+modal_id,
			selectCond:'city_'+modal_id,
			blankCond:'<spring:message code="header.all"/>',
			base_target:'tab3_sel_province_'+modal_id,
			follower:'CODE_IDX1'
		});
	}
	
	function cleanElement_<%=modal%>(){
		var modal_id = '<%=modal%>';
		$('select[id="tab1_sel_province_'+modal_id+'"]').val('');
		$('select[id="tab1_sel_city_'+modal_id+'"]').val('');
		$('select[id="tab2_sel_province_'+modal_id+'"]').val('');
		$('select[id="tab2_sel_city_'+modal_id+'"]').val('');
		$('select[id="tab3_sel_province_'+modal_id+'"]').val('');
		$('select[id="tab3_sel_city_'+modal_id+'"]').val('');
		
		$('input[name="tab1_st_nm_'+modal_id+'"]').val('');
		$('input[name="tab1_bldg_no_'+modal_id+'"]').val('');
		
		$('input[name="tab2_dong_nm_'+modal_id+'"]').val('');
		$('input[name="tab2_addr_no_'+modal_id+'"]').val('');
		
		$('input[name="tab3_bldg_nm_'+modal_id+'"]').val('');
		
		$('input[name="province_'+modal_id+'"]').val('');
		$('input[name="city_'+modal_id+'"]').val('');
		$('div[id="tab1_list_'+modal_id+'"]').empty();
		$('div[id="tab2_list_'+modal_id+'"]').empty();
		$('div[id="tab3_list_'+modal_id+'"]').empty();
	}
	
	function searchAddress_<%=modal%>(type){
		var me = this;
		var modal_id = '<%=modal%>';
		var url = '';
		var params = {
				search_province : $('input[name="province_'+modal_id+'"]').val(),
				search_city : $('input[name="city_'+modal_id+'"]').val()
		}
		
		if('' == $('input[name="province_'+modal_id+'"]').val()){
			alert('<spring:message code="cfs.addr.message.select_province"/>');
			return false;
		}
		if('' == $('input[name="city_'+modal_id+'"]').val()){
			alert('<spring:message code="cfs.addr.message.select_city"/>');
			return false;
		}
		
		if('st' == type){
			params['search_st_nm'] = $('input[name="tab1_st_nm_'+modal_id+'"]').val();
			params['search_bldg_no'] = $('input[name="tab1_bldg_no_'+modal_id+'"]').val();
			url = '/cfs/addrsrch/data/stlist?firstUser';
			
			var bldg_no = $('input[name="tab1_bldg_no_'+modal_id+'"]').val();
			bldg_no = bldg_no.split('-');
			if(bldg_no.length > 1){
				params['bldg_major_no'] = bldg_no[0];
				params['bldg_minor_no'] = bldg_no[1];
			}else{
				params['bldg_major_no'] = bldg_no[0];
			}
			
			if(undefined == params['search_st_nm'] || '' == params['search_st_nm']){
				alert('<spring:message code="cfs.addr.message.input_st_nm"/>');
				return false;
			}
			
			if(undefined == params['bldg_major_no'] || '' == params['bldg_major_no']){
				alert('<spring:message code="cfs.addr.message.input_st_major"/>');
				return false;
			}
				
		}else if('ad' == type){
			params['search_dong'] = $('input[name="tab2_dong_nm_'+modal_id+'"]').val();
			params['search_address_no'] = $('input[name="tab2_addr_no_'+modal_id+'"]').val();
			url = '/cfs/addrsrch/data/addrlist?firstUser';
			
			var addr_no = $('input[name="tab2_addr_no_'+modal_id+'"]').val();
			addr_no = addr_no.split('-');
			if(addr_no.length > 1){
				params['address_major_no'] = addr_no[0];
				params['address_minor_no'] = addr_no[1];
			}else{
				params['address_major_no'] = addr_no[0];
			}
			
			if(undefined == params['search_dong'] || '' == params['search_dong']){
				alert('<spring:message code="cfs.addr.message.input_dong"/>');
				return false;
			}
			
			if(undefined == params['address_major_no'] || '' == params['address_major_no']){
				alert('<spring:message code="cfs.addr.message.input_addr_major"/>');
				return false;
			}
		}else if('bd' == type){
			params['search_bldg_nm'] = $('input[name="tab3_bldg_nm_'+modal_id+'"]').val();
			url = '/cfs/addrsrch/data/bldglist?firstUser';
			
			if(undefined == params['search_bldg_nm'] || '' == params['search_bldg_nm']){
				alert('<spring:message code="cfs.addr.message.input_bldg_nm"/>');
				return false;
			}
		}
		
		sendRequest({
			action:'/<%=lang%>'+url,
			params:params,
			callbackFunc:getAddressList_<%=modal%>,
			callbackParams:{
				opener : me,
				type : type
			}
		});
	}
	
	function getAddressList_<%=modal%>(data, params){
		var me = params.opener;
		var type = params.type;
		var list = data.list;
		var modal_id = '<%=modal%>';
		
		var list_div;
		
		if('st' == type){
			list_div=$('div[id="tab1_list_'+modal_id+'"]');
		}else if('ad' == type){
			list_div=$('div[id="tab2_list_'+modal_id+'"]');
		}else if('bd' == type){
			list_div=$('div[id="tab3_list_'+modal_id+'"]');
		}
		var data = '';
		list_div.empty();
		for(var i=0;i<list.length;i++){
			data = data.concat('<div class="adress-inner"><div class="adress-num"><span class="pop-only-mobile"><spring:message code="cfs.header.zipcode"/> : </span>');
			data = data.concat(list[i].ZIP);
			data = data.concat('</div>');
			data = data.concat('<div class="adress-con">');
			data = data.concat(list[i].ST_FULL_ADDRESS);
			data = data.concat('<p class="adress-des">[<spring:message code="cfs.header.address_no"/>]');
			data = data.concat(list[i].FULL_ADDRESS);
			data = data.concat('</p>');
			data = data.concat('<a href="javascript:;" title="<spring:message code="gms.combo.select"/>" ');
			data = data.concat('onClick="javascript:{setParentElement_<%=modal%>(\''+list[i].ZIP+'\',\''+list[i].ST_FULL_ADDRESS+'\');};"><spring:message code="gms.combo.select"/></a>');
			data = data.concat('</div></div>');
		}
		list_div.append(data);
	}
	
	function setParentElement_<%=modal%>(zip, basic){
		var modal_id = '<%=modal%>';
		var zip_ele = '<%=zipcode%>';
		var basic_ele = '<%=basic%>';
		
		$('input[id="'+zip_ele+'"]').val(zip);
		$('input[id="'+basic_ele+'"]').val(basic);
		
		cleanElement_<%=modal%>();
		
		closeModal('#'+modal_id);
	}
//]]>
</script>