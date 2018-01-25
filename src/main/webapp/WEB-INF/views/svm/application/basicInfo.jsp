<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>

<div class="contents_wrap_01 contents_support_01">
		<div class="contents_top">
			<div class="con_title"><spring:message code="svm.title.application" /> </div>
			<ul class="con_location">
				<li><spring:message code="svm.title.home"/></li>
				<li><spring:message code="svm.title.application" /></li>
			</ul>
		</div>
		
		<div class="contents">
<!-- ▼contents▼ -->
<form:form commandName="svmVolVo" name="svmVolVo" id="svmVolVo" autocomplete="off" enctype="multipart/form-data" acceptCharset="UTF-8" method="POST">
<%-- 			<form:hidden path="cmd"/> --%>
			<form:hidden path="kind" />
			<form:hidden path="save_tab_cd" />
			<form:hidden path="regi_no" />
			<form:hidden path="ad_no" />
			<input type="hidden" name="lang" value="${lang}" />
			<input type="hidden" id="moveTo" name="moveTo" />
			<input type="hidden" id="hid_clone">
			<input type="hidden" id="del_photo_fg" name="del_photo_fg" />

	<!-- ▼contents▼ -->

<ul class="step_02">
	<li class="on"><spring:message code="svm.title.basic_information" /></li>
	<li class=""><spring:message code="svm.title.upload_photo" /></li>
	<li class=""><spring:message code="svm.title.games_information" /></li>
	<li class=""><spring:message code="svm.title.finish_registeration" /> </li>
</ul>





<!--▼table_write-->


	<div class="con_title_01 con_title_01_add">
		<spring:message code="svm.header.basicInfo"/>
		<div class="explain_support_01">
<!-- 			Input field with symbol (<span class="must_01" style="width:13px;"></span>) is required. -->
			<spring:message code="svm.header.input_field_required"/>
		</div>
	</div>
	
	<div class="table_write table_write_support_01">

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.group_name"/></strong>
			</dt>
			<dd class="">
				<strong>
					<form:input path="group_nm" maxlength="50" type="text" class="input_01" style="width:584px;"   />
				</strong>
			</dd>
		</dl>
	</div>

	<div >
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.finishinfo.basic.type_volunteer"/>
					<span class="must_01"></span>
					<br>
					<em>
						<spring:message code="svm.info.select_workforce"/>
					</em>
				</strong>
			</dt>
			<dd class=""  id="tovDivArea" >
				<strong>
					<output name="tov" id="tov"></output>
				</strong>
			</dd>
		</dl>
	</div>


	<div >
		<dl>
			<dt class="cell_01" style="width:278px;" >
				<strong>
					<spring:message code="svm.header.prefered_division"/><span class="must_01"></span>
					<br>
					<em><spring:message code="svm.info.over_select_pre_div"/></em>
				</strong>
			</dt>
			<dd class="pd_div"  id="pdDivArea" >
				<strong>
					<output name="pd" id="pd"></output>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.name"/><span class="must_01"></span><em><spring:message code="svm.info.enter.passport"/></em></strong>
			</dt>
			<dd class="">
				<strong>
					<form:input path="given_nm"  type="text" class="input_01 mandatory" style="width:290px;"   placeholder="First Name" maxlength="100" onkeyup="fnEnterName(this);" onblur="fnTrim($(this));fnUpperCase(this);"/>
					<form:input path="family_nm" type="text" class="input_01 mandatory" style="width:290px;"   placeholder="Last Name" maxlength="100" onkeyup="fnEnterName(this);" onblur="fnTrim($(this));fnUpperCase(this);"/>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.nickname"/><span class="must_01"></span></strong>
			</dt>
			<dd class="">
				<strong>
					<form:input path="nickname" type="text" class="input_01 mandatory" style="width:584px;"   maxlength="100" onblur="fnTrim($(this));"></form:input>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.birth"/><span class="must_01"></span>
					<br>
<%-- 					<em><spring:message code="svm.info.minimum_age"/></em> --%>
					<em>(DD/MM/YYYY)</em>
				</strong>
			</dt>
			<dd class="">
				<strong>
					<form:input path="birth_date" type="text" class="input_01" style="width:584px;" value="${SVMUserVO.birth_date }" readonly="true"></form:input>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.gender"/><span class="must_01"></span></strong>
			</dt>
			<dd class="radio_div">
				<strong>
					<output name="gender" id="gender" title=""></output>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div class="radio_div">
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.finishinfo.basic.married"/><span class="must_01"></span></strong>
			</dt>
			<dd class="radio_div">
				<strong>
					<output name="married_cd" id="married" title=""></output>
<!-- 					<input type="radio" id="r02_01" class="radio_01" style="width:80px;" name="r_02"><label>Single</label> -->
<!-- 					<input type="radio" id="r02_02" class="radio_01" style="width:80px;" name="r_02" checked><label>Marital</label> -->
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.finishinfo.basic.blood_type"/><span class="must_01"></span></strong>
			</dt>
			<dd class="">
				<strong>
					<form:select path="blood_type_cd" class="select_01 mandatory" style="width:300px;cursor: pointer;" title=""></form:select>
					<input type="hidden" name="blood_cd" id="blood_cd">
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.nationality"/><span class="must_01"></span></strong>
			</dt>
			<dd class="radio_div">
				<strong>
					<output name="ctry_cd_fg" id="ctry_cd_fg" title=""></output> 
<!-- 					<input type="radio" id="r03_01" class="radio_01" style="width:80px;" name="r_03" checked><label>Local</label> -->
<!-- 					<input type="radio" id="r03_02" class="radio_01" style="width:80px;" name="r_03"><label>Foreigner</label> -->
				</strong>
			</dd>
		</dl>
	</div>
	
	<spring:message code="svm.header.address_details" var="addr_details_prop"/>
	<!-- ▼Local 선택 시-->
	<ul class="localOrForeigner" id="localView" class="" style="display:none;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.ktpNumber"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<form:input type="text" class="input_01" style="width:584px;"   path="ktp_no" onkeyup="onlyNum(this);" maxlength="16" onblur="fnTrim($(this));" />
						</strong>
					</dd>
				</dl>
			</div>
		
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.addr"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<div style="display:inline-block; width:289px;">
								<span class="txt_01" style="padding:0 0 4px 0; display:block;"><spring:message code="svm.finishinfo.basic.province"/></span>
	<!-- 							<select class="select_01" style="width:289px;" title=""> -->
	<!-- 								<option value="">option</option> -->
	<!-- 							</select> -->
								<form:select path="provinsi_cd" class="select_01" style="width:289px; cursor: pointer;" title="" onchange="changeAddr($(this));"></form:select>
								<input type="hidden" name="hid_provinsi_cd" id="hid_provinsi_cd">
							</div>
							
							<div style="display:inline-block; width:289px;">
								<span class="txt_01" style="padding:0 0 4px 0; display:block;"><spring:message code="svm.header.city"/></span>
								<form:select path="city_cd" class="select_01" style="width:289px; cursor: pointer;" title="addrCity" onchange="changeAddr($(this));" disabled="true"></form:select>
								<input type="hidden" name="hid_city_cd" id="hid_city_cd">
							</div>
							
							<br>
							
							<div style="display:inline-block; width:289px;">
								<span class="txt_01" style="padding:14px 0 4px 0; display:block;"><spring:message code="svm.finishinfo.basic.district"/></span>
									<form:select path="district_cd" class="select_01" style="width:289px; cursor: pointer;" title="addrDistrict" onchange="changeAddr($(this));" disabled="true"></form:select>
								<input type="hidden" name="hid_district_cd" id="hid_district_cd">
							</div>
							
							<div style="display:inline-block; width:289px;">
								<span class="txt_01" style="padding:14px 0 4px 0; display:block;"><spring:message code="svm.finishinfo.basic.village"/></span>
								<form:select path="village_cd" class="select_01" style="width:289px;" title="addrVillage" onchange="changeAddr($(this));" disabled="true"></form:select>
								<input type="hidden" name="hid_village_cd" id="hid_village_cd">
							</div>
							
							<div>
								<span class="txt_01" style="padding:14px 0 4px 0; display:block;"><spring:message code="svm.header.address_details"/></span>  
								<form:textarea path="address_dtl"  class="textarea_01 mandatory" style="width:860px; height:80px;"  title='${addr_details_prop }' placeholder="" onkeyup="fnMaxLength(this,4000);"></form:textarea>
							</div>
						</strong>
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	<!-- ▲Local 선택 시-->

	<!-- ▼Foreigner 선택 시-->
	<ul class="localOrForeigner" id="foreignerView" class="" style="display:none;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.passportNo"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<form:input path="passport_no" type="text" maxlength="20" class="input_01 mandatory" style="width:584px;"    onkeyup="fnEnterPassport(this);" ></form:input>
						</strong>
					</dd>
				</dl>
			</div>
		
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.info.upload_passport"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<div class="upload_01" style="width:350px;">
								<input type="file" id="file_passport" name="file_passport" class="mandatory" ><label for="file_passport" title="Upload"></label>
								
							</div>
							<span class="txt_01" style="padding:0 0 0 10px;"><spring:message code="svm.info.file_type_max" arguments="PDF,JPG,JPEG,PNG;4;" argumentSeparator=";"/></span>
						</strong>
					</dd>
				</dl>
			</div>
			
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.addr"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<div style="display:inline-block; width:289px;">
								<span class="txt_01" style="padding:0 0 4px 0; display:block;"><spring:message code="svm.header.nationality.country"/></span>
								<output name="country" id="country"></output>
								<form:select  path="ctry_cd" class="select_01 mandatory"  style="width:289px;" >
								</form:select>
								<input type="hidden" name="hid_ctry_cd" id="hid_ctry_cd">
							</div>
							
							<div style="display:inline-block; width:289px;">
								<span class="txt_01" style="padding:0 0 4px 0; display:block;"><spring:message code="svm.header.city"/></span>
								<form:input path="foreign_city" maxlength="100" class="input_01 mandatory" style="width:289px;" title="" onblur="fnTrim($(this));" ></form:input>
							</div>
							
							<div>
								<span class="txt_01" style="padding:14px 0 4px 0; display:block;"><spring:message code="svm.header.address_details"/></span> 
								<textarea name="address" id="address" class="textarea_01 mandatory" style="width:860px; height:80px;"  title='${addr_details_prop }' placeholder="" onkeyup="fnMaxLength(this,4000);">${svmVolVo.address }</textarea>
							</div>
						</strong>
						</dd>
					</dl>
				</div>
			</li>
	</ul>
	<!-- ▲Foreigner 선택 시-->
	
	<ul>
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.postcode"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<form:input type="text" class="input_01 mandatory" style="width:584px;"   onkeyup="onlyNum(this);" path="postcode" maxlength="20" />
						</strong>
					</dd>
				</dl>
			</div>
	
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.mobile_number"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<select class="select_01 mandatory" style="width:197px;" id="nationality_cd" name="nationality_cd" title=""></select>
							<input type="hidden" name="hid_nationality_cd" id="hid_nationality_cd">
							<form:input path="mobile_no" type="text" class="input_01 mandatory" onkeyup="fnEnterMobile(this);" style="width:384px;" maxlength="20"/>
						</strong>
					</dd>
				</dl>
			</div>
			
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.whatsapp_number"/></strong>
					</dt>
					<dd class="">
						<strong>
							<form:input type="text" class="input_01 mandatory" style="width:584px;"   onkeyup="fnEnterMobile(this);" path="whats_no" maxlength="20" />
						</strong>
					</dd>
				</dl>
			</div>
			
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.email"/></strong>
					</dt>
					<dd class="">
						<strong>
							<form:input type="text" class="input_01" value="${svmVolVo.email}" style="width:584px;" readonly="true" path="email" />
						</strong>
					</dd>
				</dl>
			</div>
			
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.occupation_or_university"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
						<output id="occu_or_univ_cd" name="occu_or_univ_cd"></output>
						</strong>
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	
	<!-- ▼General 선택 시-->
	<ul class="occuOrUviView" id="generalView" style="display:none;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.occupation"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<form:select id="occu_cd" name="occu_cd" path="occu_cd" class="select_01"></form:select>
							<input type="hidden" name="hid_occu_cd" id="hid_occu_cd">
						</strong>
					</dd>
				</dl>
			</div>
		
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.organization_name"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<input type="text" class="input_01 occu_or_univ_nm" style="width:584px;"   maxlength="100" onblur="fnTrim($(this));"/>
						</strong>
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	<!-- ▲General 선택 시-->





	<!-- ▼University 선택 시-->
	<ul class="occuOrUviView" id="universityView" style="display:none;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.university_nm"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<input type="text" class="input_01 occu_or_univ_nm" style="width:584px;"   maxlength="100" onblur="fnTrim($(this));"/>
						</strong>
					</dd>
				</dl>
			</div>
			
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.occupation_or_university.major"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<form:select path="occu_or_univ_major_cd" id="occu_or_univ_major_cd" name="occu_or_univ_major_cd" class="select_01"></form:select>
							<input type="hidden" id="hid_occu_or_univ_major_cd" name="hid_occu_or_univ_major_cd"/>
						</strong>
					</dd>
				</dl>
			</div>
			
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.occupation_or_university.status_major"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<form:select path="occu_or_univ_st_major_cd" class="select_01"></form:select>
							<input type="hidden" id="hid_occu_or_univ_st_major_cd" name="hid_occu_or_univ_st_major_cd"/>
						</strong>
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	<!-- ▲University 선택 시-->


	<!-- ▼High School 선택 시-->
	<ul class="occuOrUviView" id="highschoolView" style="display:none;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong><spring:message code="svm.header.occupation_or_university.school_name"/><span class="must_01"></span></strong>
					</dt>
					<dd class="">
						<strong>
							<input type="text" class="input_01 occu_or_univ_nm" style="width:584px;"   maxlength="100" onblur="fnTrim($(this));"/>
						</strong>
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	<!-- ▲High School 선택 시-->
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.for_uniform_purpose"/><span class="must_01"></span></strong>
			</dt>
			<dd class="">
				<strong>
					<input type="hidden" id="hid_uni_shirts_cd" name="hid_uni_shirts_cd"/>
					<input type="hidden" id="hid_uni_waist_cd" name="hid_uni_waist_cd"/>
					<input type="hidden" id="hid_uni_shoes_cd" name="hid_uni_shoes_cd"/>
					
					<span class="txt_01" style="padding:0 8px 0 16px;"><spring:message code="svm.header.uniform.shirt"/><span class="must_01"></span></span>
					<form:select path="uni_shirts_cd" class="select_01 mandatory" style="width:160px;" title="">
					</form:select>
					
					<span class="txt_01" style="padding:0 8px 0 20px;"><spring:message code="svm.header.uniform.waist"/><span class="must_01"></span></span>
					<form:select path="uni_waist_cd" class="select_01 mandatory" style="width:160px;" title="">
					</form:select>
					
					<span class="txt_01" style="padding:0 8px 0 20px;"><spring:message code="svm.header.uniform.shoes"/><span class="must_01"></span></span>
					<form:select path="uni_shoes_cd" class="select_01 mandatory" style="width:160px;" title="">
					</form:select>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.finishinfo.basic.height_weight"/><span class="must_01"></span></strong>
			</dt>
			<dd class="">
				<strong>
					<span class="txt_01" style="padding:0 8px 0 0;"><spring:message code="svm.header.height"/><span class="must_01"></span></span>
					<form:input path="height" type="text" class="input_01 mandatory" style="width:190px; text-align:right;" maxlength="5" onblur="blurWeight($(this));"/> <spring:message code="svm.finishinfo.basic.height_cm"/>
					
					<span class="txt_01" style="padding:0 8px 0 17px;"><spring:message code="svm.header.weight"/><span class="must_01"></span></span>
					<form:input path="weight" type="text"  class="input_01 mandatory" style="width:190px; text-align:right;" maxlength="5" onblur="blurWeight($(this));"/> <spring:message code="svm.finishinfo.basic.weight_kg"/> 
				</strong>
			</dd>
		</dl>
	</div>
	
</div>






<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.header.social"/>
	<div class="explain_support_01">
		<spring:message code="svm.header.input_field_required"/>
	</div>
</div>


<div class="table_write table_write_support_01">
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.social_media"/>
					<br>
					<em>
						<spring:message code="svm.header.username"/>
					</em>
				</strong>
			</dt>
			<dd class="">
				<strong>
					<div style="display:inline-block; width:290px;">
						<span class="txt_01" style="padding:0 0 4px 0; display:block;"><spring:message code="svm.header.facebook"/></span>
						<form:input path="facebook_nm" type="text" class="input_01" style="width:270px;" placeholder="username" maxlength="100"/>
					</div>
					
					<div style="display:inline-block; width:290px;">
						<span class="txt_01" style="padding:0 0 4px 0; display:block;"><spring:message code="svm.header.twitter"/></span>
						<form:input path="twitter_nm" type="text" class="input_01" style="width:270px;" placeholder="username" maxlength="100"/>
					</div>

					<div style="display:inline-block; width:290px;">
						<span class="txt_01" style="padding:0 0 4px 0; display:block;"><spring:message code="svm.header.line"/></span>
						<form:input path="line_nm" class="input_01" style="width:270px;" placeholder="username" maxlength="100"/>
					</div>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.hobby_aspiration"/><span class="must_01"></span>
				</strong>
			</dt>
			<dd class="">
				<strong>
					<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.hobby"/><span class="must_01"></span></span>
					<form:input path="hobby" class="input_01 mandatory" style="width:270px;"   maxlength="100"/>
					
					<span class="txt_01" style="padding:0 8px 0 16px;"><spring:message code="svm.header.aspiration"/><span class="must_01"></span></span>
					<form:input path="aspiration" class="input_01 mandatory" style="width:270px;"   maxlength="100"/>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.motto"/></strong>
			</dt>
			<dd class="">
				<strong><spring:message code="svm.header.motto" var="motto_prop"/>
					<textarea id="motto" name="motto" class="textarea_01" style="width:860px; height:80px;"  title='${motto_prop }' placeholder="" onkeyup="fnMaxLength(this,4000);countChar(this,'counter2',4000);" >${svmVolVo.motto}</textarea>
					<div style="text-align:right; padding:2px 20px 0 0;"><output id="counter2">4000</output> <spring:message code='svm.header.characters_remaining'/></div>
				</strong>
			</dd>
		</dl>
	</div>
	
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong><spring:message code="svm.header.reason_to_join_volunteer"/></strong>
			</dt>
			<dd class="">
				<strong> 
					<spring:message code="svm.header.reason_to_join_volunteer" var="reson_to_join_prop"/>
					<form:textarea path="reason" class="textarea_01 mandatory" onkeyup="fnMaxLength(this,4000);countChar(this,'counter',4000);" style="width:860px; height:80px;" 
					 title="${reson_to_join_prop }" placeholder='' ></form:textarea>
					<div style="text-align:right; padding:2px 20px 0 0;"><output id="counter">4000</output> <spring:message code='svm.header.characters_remaining'/></div>
				</strong>
			</dd>
		</dl>
	</div>
	</div>
	
	
				
	<!--▲table_write-->
	
	
	
	
	
	<div class="con_title_01 con_title_01_add" style="margin-top:40px; padding-bottom:6px; border-bottom:2px solid #d63140;">
		<spring:message code='svm.finishinfo.basic.title_education'/>
		<div class="explain_support_01">
			<spring:message code='svm.header.input_field_required'/>
		</div>
	</div>
	
	
	<div class="con_title_03" style="margin-top:30px;">
		<spring:message code='svm.header.school_level'/>
	</div>
	<table class="table_list_01 no_hover table_list_support_01_add in_table_01">
		<colgroup>
			<col style="width:270px;">
			<col style="width:160px;">
			<col style="">
		</colgroup>
		<thead>
			<tr>
				<th><spring:message code='svm.header.level'/></th>
				<th><spring:message code='svm.header.year'/><em style="font-weight:400; display:block; margin-top:3px; font-size:11px; line-height:15px;"><spring:message code="svm.info.exercise_yyyy"/></em></th>
				<th><spring:message code='svm.header.school_name'/></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="left"><spring:message code='svm.header.sd_or_equals'/><span class="must_01"></span></td>
				<td><form:input path="sd_schl_year" type="text" class="input_01"   maxlength="4" onkeyup="onlyNum2(this);" onblur="fnEnterYear(this);"/></td>
				<td><form:input path="sd_schl_nm" type="text" class="input_01"   maxlength="100"/></td>
			</tr>
			<tr>
				<td class="left"><spring:message code='svm.header.smp_or_equals'/><span class="must_01"></span></td>
				<td><form:input path="smp_schl_year" type="text" class="input_01"   maxlength="4" onkeyup="onlyNum2(this);" onblur="fnEnterYear(this);"/></td>
				<td><form:input path="smp_schl_nm" type="text" class="input_01"   maxlength="100" /></td>
			</tr>
			<tr>
				<td class="left"><spring:message code='svm.header.sma_or_equals'/><span class="must_01"></span></td>
				<td><form:input path="sma_schl_year" type="text" class="input_01"   maxlength="4" onkeyup="onlyNum2(this);" onblur="fnEnterYear(this);"/></td>
				<td><form:input path="sma_schl_nm" type="text" class="input_01"   maxlength="100"/></td>
			</tr>
		</tbody>
	</table>
	
	
	<div class="con_title_03" style="margin-top:30px;">
		<spring:message code='svm.header.university_level'/> <em>(<spring:message code='svm.header.is_university_level' />
		<input type="hidden" name="university_lvl_yn" id="hid_university_lvl_yn" value="N"/>
		<input type="checkbox" name="university_lvl_yn" id="university_lvl_yn" value="Y" class="checkbox_02" checked="checked" />
		<label for="university_lvl_yn"><span></span></label> )</em>
	</div>
	
	<!-- ▼LEVEL checked 시-->
	<div class="isUniverLvlView" style="display:block;">
		<table class="table_list_01 no_hover table_list_support_01_add in_table_01">
			<colgroup>
				<col style="width:270px;">
				<col style="width:160px;">
				<col style="width:350px;">
				<col style="">
			</colgroup>
			<thead>
				<tr>
					<th><spring:message code='svm.header.level'/></th>
					<th><spring:message code='svm.header.year'/><em style="font-weight:400; display:block; margin-top:3px; font-size:11px; line-height:15px;"><spring:message code="svm.info.exercise_yyyy"/></em></th>
					<th><spring:message code='svm.header.faculty'/></th>
					<th><spring:message code='svm.header.university'/></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="left"><spring:message code='svm.header.university_or_equals'/></td>
					<td><form:input path="university_year" type="text" class="input_01"   maxlength="4" onkeyup="onlyNum2(this);" onblur="fnEnterYear(this);"/></td>
					<td><form:input path="university_faculty" type="text" class="input_01"   maxlength="100"/></td>
					<td><form:input path="university_university" type="text" class="input_01"   maxlength="100"/></td>
				</tr>
				<tr>
					<td class="left"><spring:message code='svm.header.post_or_equals'/></td>
					<td><form:input path="post_grad_year" type="text" class="input_01"   maxlength="4" onkeyup="onlyNum2(this);" onblur="fnEnterYear(this);"/></td>
					<td><form:input path="post_grad_faculty" type="text" class="input_01"   maxlength="100"/></td>
					<td><form:input path="post_grad_university" type="text" class="input_01"   maxlength="100"/></td>
				</tr>
				<tr>
					<td class="left"><spring:message code='svm.header.doctoral_or_equals'/></td>
					<td><form:input path="doctoral_year" type="text" class="input_01"   maxlength="4" onkeyup="onlyNum2(this);" onblur="fnEnterYear(this);"/></td>
					<td><form:input path="doctoral_faculty" type="text" class="input_01"   maxlength="100"/></td>
					<td><form:input path="doctoral_university" type="text" class="input_01"   maxlength="100"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- ▲LEVEL checked 시-->
	
	
	
	
	<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
		<spring:message code='svm.header.others_information'/>
		<div class="explain_support_01">
			<spring:message code="svm.header.input_field_required"/>
		</div>
	</div>
	
	
	<div class="table_write table_write_support_01">
	
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code='svm.header.parents_upper'/>
					</strong>
				</dt>
				<dd class="">
					<strong>
						<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code='svm.header.mothers'/></span>
						<form:input path="prnts_mother_nm" type="text" class="input_01" style="width:270px;" maxlength="100" onkeyup="fnEnterName(this);" onblur="fnTrim($(this));fnUpperCase(this);"/>
						
						<span class="txt_01" style="padding:0 8px 0 30px;"><spring:message code='svm.header.fathers'/></span>
						<form:input path="prnts_father_nm" type="text" class="input_01" style="width:270px;" maxlength="100" onkeyup="fnEnterName(this);" onblur="fnTrim($(this));fnUpperCase(this);"/>
					</strong>
				</dd>
			</dl>
		</div>
	
		<div>
			<dl>
				<dt class="cell_01" style="width:278px;">
					<strong>
						<spring:message code='svm.header.emergency_upper'/><span class="must_01"></span>
					</strong>
				</dt>
				<dd class="">
					<strong>
						<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code='svm.header.phone_upper'/><span class="must_01"></span></span>
						<form:input path="emer_phone" type="text" class="input_01" style="width:270px;" onkeyup="fnEnterMobile(this);"   maxlength="20"/>
						
						<span class="txt_01" style="padding:0 8px 0 15px;"><spring:message code='svm.header.relation_upper'/><span class="must_01"></span></span>
						<form:select path="emer_rel_cd" class="select_01" style="width:270px;" title="" >
						</form:select>
						<input type="hidden" name="hid_emer_rel_cd" id="hid_emer_rel_cd">
					</strong>
				</dd>
			</dl>
		</div>
	</div>
	
	
	<div class="btn_area_01 btn_support_01" style="margin:30px 0 10px 0;">
		<div class="btn_center">
			<a class="btn_02" id="btn_save" onclick="btnSave('${svmVolVo.regi_no}');"><spring:message code="svm.button.save" /></a>
			<a class="btn_03 next_icon" id="btn_next" onClick="btnNext('${svmVolVo.regi_no}');"><spring:message code="svm.button.next" /></a>
		</div>
	</div>
</form:form>
<!-- ▲contents▲ -->

		</div>

<script>
	$(document).ready(function(){
		
		init();
		// 화면 상태
		//chkUserStatus();
		// 버튼 이벤트
		btnEvent();
		
		formSetting();
		radioStyle();
	});
	
	function chkUserStatus(){
		var frm = document.svmVolVo;
		if("${isRegistered}" == "true") alert("true");
	};
	
	var areaList = new Array();
	function formSetting(){
		
		<c:forEach items="${svmVolVo.areaList}" var="info">
			var json = new Object();
			json.area = "${info.area}".trim();
			json.check_cd = "${info.check_cd}".trim(); 
			json.certi_nm = "${info.certi_nm}".trim();
			areaList.push(json);
		</c:forEach>
		
		for(var i=0; i<areaList.length; i++){
			var selector = "";
			
			if(areaList[i].area == 'pd' || areaList[i].area == 'tov'){
				selector = $('input[name=' + areaList[i].area + '][value=' + areaList[i].check_cd + ']');
				if(selector.size()!=0) selector.prop("checked",true);
			}
		}
		
		
		$("#passport_no").val("<c:out value='${svmVolVo.passport_no}'/>");
		
		$('label[for=file_passport]').text("<c:out value='${svmVolVo.passportFile_nm}'/>");

		$("#blood_type_cd").val("<c:out value='${svmVolVo.blood_type_cd}'/>");
		
		$("select[name=nationality_cd]").val("<c:out value='${svmVolVo.nationality_cd}'/>");
		
		$("select[name=occu_cd]").val("<c:out value='${svmVolVo.occu_cd}'/>".trim());

		$("select[id=ctry_cd]").val("<c:out value='${svmVolVo.ctry_cd}'/>");

		$("select[id=occu_or_univ_major_cd]").val("<c:out value='${svmVolVo.occu_or_univ_major_cd}'/>".trim());
		
		$("select[id=occu_or_univ_st_major_cd]").val("<c:out value='${svmVolVo.occu_or_univ_st_major_cd}'/>".trim());
		
		
		if("<c:out value='${svmVolVo.provinsi_cd}'/>" != "" && '<c:out value="${svmVolVo.ctry_cd_fg}"/>' == "L"){
			//$("select[id=provinsi_cd]").val("<c:out value='${svmVolVo.provinsi_cd}'/>").trigger('change');
			$("select[id=provinsi_cd]").val("<c:out value='${svmVolVo.provinsi_cd}'/>");
			$("select[id=city_cd]").val("<c:out value='${svmVolVo.city_cd}'/>");
			if("<c:out value='${svmVolVo.city_cd}'/>".trim() == ""){
				$("select[id=city_cd]").val('').prop('disabled',true);
			}else{
				$("select[id=city_cd]").prop('disabled',false);
			}
			$("select[id=district_cd]").val("<c:out value='${svmVolVo.district_cd}'/>");
			if("<c:out value='${svmVolVo.district_cd}'/>".trim() == ""){
				$("select[id=district_cd]").val('').prop('disabled',true);
			}else{
				$("select[id=district_cd]").prop('disabled',false);
			}
			$("select[id=village_cd]").val("<c:out value='${svmVolVo.village_cd}'/>");
			if("<c:out value='${svmVolVo.village_cd}'/>".trim() == ""){
				$("select[id=village_cd]").val('').prop('disabled',true);
			}else{
				$("select[id=village_cd]").prop('disabled',false);
			}
		}
		
		$("select[id=emer_rel_cd]").val("<c:out value='${svmVolVo.emer_rel_cd}'/>");

		$("#uni_shirts_cd").val("<c:out value='${svmVolVo.uni_shirts_cd}'/>");
		
		$("#uni_waist_cd").val("<c:out value='${svmVolVo.uni_waist_cd}'/>");
		
		$("#uni_shoes_cd").val("<c:out value='${svmVolVo.uni_shoes_cd}'/>");
		
		if($('input[name=married_cd][value="<c:out value="${svmVolVo.married_cd}"/>"]').size()!=0)
			$('input[name=married_cd][value="<c:out value="${svmVolVo.married_cd}"/>"]').prop('checked',true).trigger('change');
		
		if($('input[name=gender][value="<c:out value="${svmVolVo.gender}"/>"]').size()!=0)
			$('input[name=gender][value="<c:out value="${svmVolVo.gender}"/>"]').prop('checked',true).trigger('change');
		
		if($('input[name=ctry_cd_fg][value="<c:out value="${svmVolVo.ctry_cd_fg}"/>"]').size()!=0)
			$('input[name=ctry_cd_fg][value="<c:out value="${svmVolVo.ctry_cd_fg}"/>"]').prop('checked',true).trigger('change');
		
		if($('input[name=occu_or_univ_cd][value="<c:out value="${svmVolVo.occu_or_univ_cd}"/>"]').size()!=0){
			$('input[name=occu_or_univ_cd][value="<c:out value="${svmVolVo.occu_or_univ_cd}"/>"]').prop('checked',true).trigger('change');
			$("[name=occu_or_univ_nm]").val("<c:out value='${svmVolVo.occu_or_univ_nm}'/>");
		}
		
		if($("#motto").val().trim() == ""){
			$("#motto").val('');
			countChar($("#motto"),'counter2',4000);
		}
		if($("#reason").val().trim() == ""){
			$("#reason").val('');
			countChar($("#reason"),'counter',4000);
		}
		
		var frm = document.svmVolVo;
		
		if("<c:out value='${svmVolVo.university_lvl_yn}'/>".trim() == 'Y'){
			$("#university_lvl_yn").prop('checked',true).trigger('change');
		}else if("<c:out value='${svmVolVo.university_lvl_yn}'/>".trim() == 'N'){
			$("#university_lvl_yn").prop('checked',false).trigger('change');
		}
		
		if($("#university_lvl_yn").is(":checked")){
			$("#hid_university_lvl_yn").prop('disabled',true);
			$("#university_lvl_yn").prop('name','university_lvl_yn');
			//$("#university_lvl_yn").prop('checked',false);
			
		}else{
			$("#hid_university_lvl_yn").prop('disabled',false);
			$("#university_lvl_yn").removeAttr('name');
			//$("#university_lvl_yn").prop('checked',true);
		}
		
		
	};
	
	function init(){
		//$(".top_btn a").text('Go back Home');
				
		countChar($("#reason"),'counter',4000);
		countChar($("#motto"),'counter2',4000);
		
		//isMainCss(location.pathname);
		
		var result = ${svmVolVo.result};

		Combo({
			data		: result,
			code_find	: 'RELATION_CD',
			name		: 'emer_rel_cd', 
			selectCond	: 'hid_emer_rel_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		}); 
		
		Combo({
			data		: result,
			code_find	: 'PROVINCE_CD',
			name		: 'provinsi_cd', 
			selectCond	: 'hid_provinsi_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		}); 
		if("<c:out value='${svmVolVo.ctry_cd_fg}'/>" == "L"){
			Combo({
				data		: result,
				code_find	: 'DISTRICT_CD',
				name		: 'district_cd', 
				selectCond	: 'hid_district_cd', 
				blankCond	: ''
			}); 
			Combo({
				data		: result,
				code_find	: 'CITY_CD',
				name		: 'city_cd', 
				selectCond	: 'hid_city_cd', 
				blankCond	: ''
			}); 
			Combo({
				data		: result,
				code_find	: 'VILLAGE_CD',
				name		: 'village_cd', 
				selectCond	: 'hid_village_cd', 
				blankCond	: ''
			}); 
		}
		
		Combo({
			data		: result,
			code_find	: 'UNIV_STAT',
			name		: 'occu_or_univ_st_major_cd', 
			selectCond	: 'hid_occu_or_univ_st_major_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		}); 
		
		Combo({
			data		: result,
			code_find	: 'OCCU_OR_UNIV_MAJOR_CD',
			name		: 'occu_or_univ_major_cd', 
			selectCond	: 'hid_occu_or_univ_major_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		}); 

		Combo({
			data		: result,
			code_find	: 'BLOOD_CD',
			name		: 'blood_type_cd', 
			selectCond	: 'blood_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		}); 
		Check({
			data		: result,
			code_find	: 'TOV',
			name		: 'tov', 
			selectCond	: 'tov', 
			area		: 'tov',
			styleClass	: 'checkbox_01',
			lang		: '${lang}'
		}); 

		Check({
			data		: result,
			code_find	: 'PD',
			name		: 'pd', 
			selectCond	: 'pd', 
			area		: 'pd',
			styleClass	: 'checkbox_01',
			lang		: '${lang}'
		}); 
		
		Radio({
			data		: result,
			code_find	: 'GENDER',
			name		: 'gender', 
			selectCond	: 'search_gender', 
			area		: 'gender',
			styleClass	: 'radio_01',
			lang		: '${lang}'
		}); 
		
		Radio({
			data		: result,
			code_find	: 'OCCU_OR_UNIV_CD',
			name		: 'occu_or_univ_cd', 
			selectCond	: 'occu_or_univ_cd', 
			area		: 'occu_or_univ_cd',
			styleClass	: 'radio_01',
			lang		: '${lang}'
		}); 

		Combo({
			data		: result,
			code_find	: 'OCCU_CD',
			name		: 'occu_cd', 
			selectCond	: 'hid_occu_cd', 
			blankCond	: 'Select an option',
			area		: 'occu_cd',
			styleClass	: 'radio_01',
			lang		: '${lang}'
		}); 
		
		Radio({
			data		: result,
			code_find	: 'CTRY_CD_FG',
			name		: 'ctry_cd_fg', 
			selectCond	: 'search_ctry_cd_fg', 
			area		: 'ctry_cd_fg',
			styleClass	: 'radio_01',
			lang		: '${lang}'
		}); 
	
		Radio({
			data		: result,
			code_find	: 'MARRIED',
			name		: 'married_cd', 
			selectCond	: 'married_nm', 
			area		: 'married',
			styleClass	: 'radio_01',
			lang		: '${lang}'
		}); 
		
		Combo({
			data		: result,
			code_find	: 'UNI_SHIRTS_CD',
			name		: 'uni_shirts_cd', 
			selectCond	: 'hid_uni_shirts_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		});
		Combo({
			data		: result,
			code_find	: 'UNI_SHOES_CD',
			name		: 'uni_shoes_cd', 
			selectCond	: 'hid_uni_shoes_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		});
		
		Combo({
			data		: result,
			code_find	: 'UNI_WAIST_CD',
			name		: 'uni_waist_cd', 
			selectCond	: 'hid_uni_waist_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		});
		Combo({
			data		: result,
			code_find	: 'CTRY_CD',
			name		: 'ctry_cd', 
			selectCond	: 'hid_ctry_cd', 
			blankCond	: 'Select an option',
			lang		: '${lang}'
		}); 
		Combo2({
			data		: result,
			code_find	: 'CTRY_CD',
			name		: 'nationality_cd', 
			selectCond	: 'hid_nationality_cd', 
			blankCond	: 'Select an option',
			flag		: '+',
			lang		: '${lang}'
		}); 
	};
		
	var ncount = 0;
	function btnSave(regi_no){
		if (!confirm('<spring:message code="svm.info.msg.is_save_application"/>')){
			return false;	// 종료
		}
		
		if(!validateBasic()){
			return false;
		}
		
		bindEventHandler();
		
		var validChk = $('#svmVolVo').valid();
		if(!validChk){
			return false;	
		}
		
		if($("#university_lvl_yn").is(":checked")) $("#university_lvl_yn").prop('name',"university_lvl_yn");
		
		var birth_date_format = $("#birth_date").val().replace(/[^0-9]/g,'');
		$("#birth_date").val(birth_date_format.substring(4,8)+birth_date_format.substring(2,4) + birth_date_format.substring(0,2));
		
		$("[name^=university_]").each(function(){$(this).val() == "" ? $(this).val(" ") : $(this).val($(this).val()); });
		$("[name^=post_grad_]").each(function(){$(this).val() == "" ? $(this).val(" ") : $(this).val($(this).val()); });
		$("[name^=doctoral_]").each(function(){$(this).val() == "" ? $(this).val(" ") : $(this).val($(this).val()); });
		
		if($("[name=university_lvl_yn]:checked").length != 1){
			$("input[type=text][name^=university_]").each(function(){ $(this).val(" "); });
			$("input[type=text][name^=post_grad_]").each(function(){ $(this).val(" "); });
			$("input[type=text][name^=doctoral_]").each(function(){ $(this).val(" "); });		
		}
		
		var checkedNation = $("[type=radio][name=ctry_cd_fg]:checked").val();
		if(checkedNation == "L"){
	    	$("#localView").show();
	    	$("#foreignerView").find('input[type=text],textarea').val(' ');
	    	$("#foreignerView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');
	    	});
	    }
	    else if(checkedNation == "F"){
	    	$("#foreignerView").show();
	    	$("#localView").find('input[type=text],textarea').val(' ');
	    	$("#localView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');
	    	});
	    }
		
		var checkedOccu = $("[type=radio][name=occu_or_univ_cd]:checked").val();
		if(checkedOccu == "G" ){
	    	$("#generalView").find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
	    	$("#universityView,#highschoolView").find('input[type=text]').val(' ');
	    	$("#universityView,#highschoolView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');	    		
	    	});
	    	$("#generalView").find('select,input').prop('disabled',false);
	    } else if(checkedOccu == "U"){
	    	$("#universityView").find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
	    	$("#generalView,#highschoolView").find('input').val(' ');
	    	$("#generalView,#highschoolView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');	    		
	    	});
	    	$("#universityView").find('select,input').prop('disabled',false);
	    }
	    else if(checkedOccu == "H"){
	    	$("#highschoolView").find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
	    	$("#universityView,#generalView").find('input[type=text]').val(' ');
	    	$("#universityView,#generalView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');	    		
	    	});
	    	$("#highschoolView").find('select,input').prop('disabled',false);
	    }
		if($("#motto").val() == ""){
			$("#motto").val(' ');			
		}
		if($("#reason").val() == ""){
			$("#reason").val(' ');
		}
		
		ncount = 0;
		var frm = document.svmVolVo;
		$("[name=occu_or_univ_nm]").each(function(){
			if($(this).val().trim() == "") $(this).removeAttr('name');
		});
		if($("#file_passport").val().trim() == ""){
			$("#file_passport").prop('disabled',true);
		}
		$('[name=pd]:checked').each(function(i){
				this.name = "areaList[" + ncount + "].check_cd";
				$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("pd"));
				//ncount++;
				ncount = $("[name^=areaList]").length / 2;
		}); 
		$('[name=tov]:checked').each(function(i){
				this.name = "areaList[" + ncount + "].check_cd";
				$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("tov"));
				//ncount++;
				ncount = $("[name^=areaList]").length / 2; 
		});
		if(frm.ad_no.value != "") 
			frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/update';
		else
			frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/insert';
		frm.moveTo.value = 'save'
		frm.save_tab_cd.value = 'basicInfo'
		
		$("#btn_save").attr('onclick','javascript:;');
		$("#btn_next").attr('onclick','javascript:;');
		frm.submit();
	}
	
	function btnNext(regi_no){
		
		if (!confirm('<spring:message code="svm.info.msg.is_save_next"/>')){
			return false;	// 종료
		}
		
		if(!validateBasic()){
			return false;
		}
		
		bindEventHandler();
		
		var validChk = $('#svmVolVo').valid();
		if(!validChk){
			return false;	
		}
		
		if($("#university_lvl_yn").is(":checked")) $("#university_lvl_yn").prop('name',"university_lvl_yn");
		
		var birth_date_format = $("#birth_date").val().replace(/[^0-9]/g,'');
		$("#birth_date").val(birth_date_format.substring(4,8)+birth_date_format.substring(2,4) + birth_date_format.substring(0,2));
		
		$("[name^=university_]").each(function(){$(this).val() == "" ? $(this).val(" ") : $(this).val($(this).val()); });
		$("[name^=post_grad_]").each(function(){$(this).val() == "" ? $(this).val(" ") : $(this).val($(this).val()); });
		$("[name^=doctoral_]").each(function(){$(this).val() == "" ? $(this).val(" ") : $(this).val($(this).val()); });
		
		if($("[name=university_lvl_yn]:checked").length != 1){
			$("input[type=text][name^=university_]").each(function(){ $(this).val(" "); });
			$("input[type=text][name^=post_grad_]").each(function(){ $(this).val(" "); });
			$("input[type=text][name^=doctoral_]").each(function(){ $(this).val(" "); });		
		}
		
		var checkedNation = $("[type=radio][name=ctry_cd_fg]:checked").val();
		if(checkedNation == "L"){
	    	$("#localView").show();
	    	$("#foreignerView").find('input[type=text]').val(' ');
	    	$("#foreignerView").find('select').val(' ');
	    }
	    else if(checkedNation == "F"){
	    	$("#foreignerView").show();
	    	$("#localView").find('input[type=text],textarea').val(' ');
	    	$("#localView").find('select').val(' ');
	    }
		
		var checkedOccu = $("[type=radio][name=occu_or_univ_cd]:checked").val();
		if(checkedOccu == "G" ){
	    	$("#generalView").find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
	    	$("#universityView,#highschoolView").find('input[type=text]').val(' ');
	    	$("#universityView,#highschoolView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');	    		
	    	});
	    	$("#generalView").find('select,input').prop('disabled',false);
	    } else if(checkedOccu == "U"){
	    	$("#universityView").find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
	    	$("#generalView,#highschoolView").find('input').val(' ');
	    	$("#generalView,#highschoolView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');	    		
	    	});
	    	$("#universityView").find('select,input').prop('disabled',false);
	    }
	    else if(checkedOccu == "H"){
	    	$("#highschoolView").find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
	    	$("#universityView,#generalView").find('input[type=text]').val(' ');
	    	$("#universityView,#generalView").find('select').each(function(){
	    		$(this).replaceWith('<input type="text" name="' + this.name + '" id="' + this.id + '" value=" ">');	    		
	    	});
	    	$("#highschoolView").find('select,input').prop('disabled',false);
	    }
		
		if($("#motto").val() == ""){
			$("#motto").val(' ');			
		}
		if($("#reason").val() == ""){
			$("#reason").val(' ');
		}
		
		ncount = 0;
		var frm = document.svmVolVo;
		$("[name=occu_or_univ_nm]").each(function(){
			if($(this).val().trim() == "") $(this).removeAttr('name');
		});
		if($("#file_passport").val().trim() == ""){
			$("#file_passport").prop('disabled',true);
		}
		$('[name=pd]:checked').each(function(i){
				this.name = "areaList[" + ncount + "].check_cd";
				$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("pd"));
				//ncount++;
				ncount = $("[name^=areaList]").length / 2;
		}); 
		$('[name=tov]:checked').each(function(i){
				this.name = "areaList[" + ncount + "].check_cd";
				$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("tov"));
				//ncount++;
				ncount = $("[name^=areaList]").length / 2;
		});
		
		if(frm.ad_no.value != "") 
			frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/update';
		else
			frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/insert';
		frm.moveTo.value = 'next'
		frm.save_tab_cd.value = 'basicInfo'
		$("#btn_save").attr('onclick','javascript:;');
		$("#btn_next").attr('onclick','javascript:;');
		frm.submit();
	}
	
	function funDrawCal(){
		$("#dateOfBirth_day option:first").text("Date");
		$("#dateOfBirth_month option:first").text("Month");
		$("#dateOfBirth_year option:first").text("Year");
		
		$("#dateOfBirth_day,#dateOfBirth_month,#dateOfBirth_year").find('option:eq(0)').hide();
	};
	
// 	function funSetCommonCode(){
// 		createDateSelectBox('dateOfBirth',-10);
// 	}
	
	function btnEvent(){
		$('input[name=height],input[name=weight]').inputmask('numeric', {
            radixPoint: '.',
            integerDigits: 3,
            rightAlign: true,
            digits: 1,
            digitsOptional: true,
            autoUnmask: true,
            autoGroup: true,
     		allowPlus: false,
     		allowMinus: false
        });
		
		$('[name^=tov][type=checkbox]').on('click',function(){
			if($("[name^=tov][type=checkbox][value='04']").prop('checked') == true ){
				if($('[name^=tov][type=checkbox]:not([value=04]):checked').length > 0){
					alert('<spring:message code="svm.info.select_workforce"/>');
					return false;
				}
			}
			if(this.value == '04' && (this.checked == true)){
				if($('[name^=tov][type=checkbox]:not([value=04]):checked').length > 1){
					$("[name^=tov][type=checkbox]:not([value=04])").prop("checked",false);				
					alert('<spring:message code="svm.info.select_workforce"/>');
				}
			}
		});
		
		$('[name^=pd][type=checkbox]').on('click',function(){
			if($('[name^=pd]:checked').length > 4){
				alert('<spring:message code="svm.info.over_select_pre_div"/>');
				return false;
			}
		});
		
		$('[name=ctry_cd_fg]').change(function(){
			if(this.checked == true){
				contentVisible(this);
			}
		});
		$('[name=occu_or_univ_cd]').change(function(){
			if(this.checked == true){
				contentVisible(this);
			}
		});
		$("#university_lvl_yn").change(function(){
			if(this.checked == false){
				$(".isUniverLvlView").hide();
				$("#hid_university_lvl_yn").attr('disabled',false);
				$(".isUniverLvlView").find('input').val(' ');
			}
			else{
				$(".isUniverLvlView").show();
				$("#hid_university_lvl_yn").attr('disabled',true);
			}
		});
		
	}
	
	function contentVisible(selector){				
		switch (selector.name) {
			case "ctry_cd_fg"  :
										$(".localOrForeigner").hide();
									    if(selector.value == "L"){
									    	$("#localView").show();
									    	$("#foreignerView").find('select,input,textarea').val('');
									    	$("#file_passport").val('').next('label').text('');
									    	$("#del_photo_fg").val("passport");
									    }
									    else if(selector.value == "F"){
									    	$("#foreignerView").show();
									    	$("#localView").find('select,input,textarea').val('');
									    	$("#provinsi_cd").val($("#provinsi_cd").find("option:first").val()).trigger('change');
									    	$("#del_photo_fg").val("");
									    }
										break;
			case "occu_or_univ_cd"  :
										$(".occuOrUviView").hide().find('.occu_or_univ_nm').removeAttr('name');
									    if(selector.value == "G"){
									    	$("#universityView,#highschoolView").find('input').val(' ');
									    	$("#universityView,#highschoolView").find('select').each(function(){
									    		$(this).val($(this).find("option:eq(0)").val()).trigger('change');
									    	});
									    	$("#generalView").show().find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
									    	$("#generalView").find('select,input').prop('disabled',false);
									    }
									    else if(selector.value == "U"){
									    	$("#generalView,#highschoolView").find('input').val(' ');
									    	$("#generalView,#highschoolView").find('select').each(function(){
									    		$(this).val($(this).find("option:eq(0)").val()).trigger('change');
									    	});
									    	$("#universityView").show().find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
									    	$("#universityView").find('select,input').prop('disabled',false);
									    }
									    else if(selector.value == "H"){
									    	$("#universityView,#generalView").find('input').val(' ');
									    	$("#universityView,#generalView").find('select').each(function(){
									    		$(this).val($(this).find("option:eq(0)").val()).trigger('change');
									    	});
									    	$("#highschoolView").show().find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
									    	$("#highschoolView").find('select,input').prop('disabled',false);
									    }
										break;
			default   : break;
// 		$('.tab_01 li.on').removeClass();
// 		$(selector).addClass('on');
		}
	}
	
	// 해당 form 필수값 및 유효성 체크
	function bindEventHandler() {
			
		 	$.validator.addMethod(
			        'email', function (value, element) {
			        	var isValid = false;
			        	if(verifyemail(value)){
			        		isValid = true;
			        	}
			        	return isValid;
			        }, '<spring:message code="svm.info.msg.enter_correctly_email"/>'
			 );
			$.validator.addMethod(
			        'isCorrectPassword', function (value, element) {
			        	var isValid = false;
			        	if(value.length > 10) isValid = true;
			        	return isValid;
			        }, '<spring:message code="sys.user.message.input_password_type"/>'
			 );
			$.validator.addMethod(
			        'isConfirmPassword', function (value, element) {
			        	var isValid = false;
						return value == $("#regist_password").val();
			        }, '<spring:message code="sys.user.message.mismatch_password"/>'
			 );
			$.validator.addMethod(
			        'isSelectDate', function (value, element) {
			        	var isValid = false;
						return "" != value;
			        }, '<spring:message code="svm.message.msg_select_date"/>'
			 );
			$.validator.addMethod(
			        'isSelectMonth', function (value, element) {
			        	var isValid = false;
						return "" != value;
			        }, '<spring:message code="svm.message.msg_select_month"/>'
			 );
			$.validator.addMethod(
			        'isSelectYear', function (value, element) {
			        	var isValid = false;
						return "" != value;
			        }, '<spring:message code="svm.message.msg_select_year"/>'
			 );
		 	
			$('#svmVolvo').validate({
				onfocusout: false,
				rules: {
					email		: { required: true , email:true },
					password		: { required: true , isCorrectPassword : true , },
					password_confirm: { required: true, isCorrectPassword : true , isConfirmPassword : true },
					dateOfBirth_day : {required : true , isSelectDate : true },
					dateOfBirth_month : {required : true , isSelectMonth : true },
					dateOfBirth_year : {required : true , isSelectYear : true }
				}, messages: {
					email: {
						required	:  '<spring:message code="svm.message.mandatory_email" />',
					},
					password: {
						required	:  '<spring:message code="sys.user.message.input_password" />',
						minlength	:  10
					},
					password_confirm: {
						required	:  '<spring:message code="sys.user.message.input_password" />',
						minlength	:  10
					},
					dateOfBirth_day: {
						required	:  '<spring:message code="svm.message.msg_select_date" />'
					},
					dateOfBirth_month: {
						required	:  '<spring:message code="svm.message.msg_select_month" />'
					},
					dateOfBirth_year: {
						required	:  '<spring:message code="svm.message.msg_select_year" />'
					},
				
				}, errorPlacement: function(error, element) {
					// do nothing
				}, invalidHandler: function(form, validator) {
					 var errors = validator.numberOfInvalids();
			         if (errors) {
			             alert(validator.errorList[0].message);
			             validator.errorList[0].element.focus();
			         }   
				}, submitHandler: function (form) {
					alert('submitHandler');
		        }
			});
	 	
	}
	
	function onchageDate(name) {
		var optDay = "";
		// year, month, day SelectBox찾기
		selectYear = document.getElementById(name + "_year");
		selectMonth = document.getElementById(name + "_month");
		selectDay = document.getElementById(name + "_day");

		// 현재 년도와 월 구하기
		year = selectYear.options[selectYear.selectedIndex].value;
		month = selectMonth.options[selectMonth.selectedIndex].value;

		tmpDate = new Date(year, month, 0);

		selectedIndex = selectDay.selectedIndex;

		for(i = selectDay.length-1; i >= 0; i--) {
			selectDay.options[i] = null;
		}

		selectDay.options[0] = new Option('', '');

		for(i = 1; i <= tmpDate.getDate(); i++) {
			if(i >= 1 && i < 10) {
				optDay = "0" + i;
			} else {
				optDay = i;
			}
			selectDay.options[i] = new Option(optDay, optDay);
		}

		if(selectedIndex <= tmpDate.getDate()) {
			selectDay.options[selectedIndex].selected = true;
		} else {
			selectDay.options[tmpDate.getDate()-1].selected = true;
		} 
		funDrawCal();
	}
	
	

function radioStyle(){
	$('.radio_01, .checkbox_01').each(function(){
		var label_style = $(this).attr('style');
		var id_name = $(this).attr('id');
		var title_name = $(this).attr('title');
		var label_name = $(this).next('label').text();
		
		if(label_style == undefined){
			label_style = '';
		}
		if(title_name == undefined){
			title_name = '';
		}
		$(this).next('label').replaceWith('<label for=' + id_name + ' style="'+ label_style +'" title="'+ title_name +'"><span></span>' + label_name + '</label>');
	});
}

function onChangeSelectFile(obj) {
	// UUID 생성
	var uuid = getUUID();
	//var fileSize = getFileSize(obj);
	var fileSize = obj.size;

	var fileSizeLimit = 1024 * 1024 * 300;
//		var fileCntLimit = 5;
//		var fileCnt = $('input[name=addFile]').size();
	
	var regExp = /^.*\.(jpg|png|jpeg)$/i;
	var pattern = new RegExp(regExp);
	var result = pattern.test(obj.files[0].name);
	
	if( !result ){
		alert('<spring:message code="message.alert.unsupport_file"/>');
		return false;
	}
	if(fileSizeLimit < fileSize){
		alert('<spring:message code="svm.message.check_file_size"/>');
		return false;
	}
}

function getFileSize( fileObj ){
	var nBytes = 0,
	oFiles = fileObj.files;
	nFiles = oFiles.length;
	
	for (var nFileId = 0; nFileId < nFiles; nFileId++) {
		nBytes += oFiles[nFileId].size;
	}
	return nBytes;
}


function funOpenPassportLayerPopup(){
	// layer popup 
	toggleLayer($('.layer_01'), 'on');
}

function funOpenAgreeLayerPopup(){
	// layer popup 
	toggleLayer($('.layer_02'), 'on');
}

// Download Image (photo, passport) 
function funDownloadImage(imageNm){
	var frm = document.svmVolVo;
	frm.imageNm.value = imageNm;
	frm.action = '<%=contextLangPath%>/svm/application/downloadImage';
	frm.submit();
}

// Delete Image (photo, passport)
function funDeleteImage(imageNm){
	var frm = document.svmVolVo;
	
	if (!confirm('<spring:message code="message.alert.delete"/>')){
		return false;	// 종료
	} 
	
	// ajax
	sendRequest({
  		action: '<%=contextLangPath%>/svm/applicationImage/deleteImage',
  		params:{
  			ad_no 	: frm.ad_no.value,
  			imageNm : imageNm
  		},
  		callbackFunc:function(resData){
  			alert('<spring:message code="svm.message.success.deleteImage"/>');
  			
  			if(imageNm == 'passport'){
  				$(".passportTool").hide();
  				frm.passphoto_yn.value = 'N';
  			} else if(imageNm == 'photo'){
  				$("#photoImg").attr("src", "");
  				$(".photoTool").hide();
  				frm.photo_yn.value = 'N';
  			}
  		}
  	});
}

function validationUpload(obj){
	var isUploadValid = true;
	var uploadMsg = '';
	if($(obj)[0].files.length != 0){
		if($(obj)[0].files[0].size == 0){
			uploadMsg = '<spring:message code="svm.message.check_file_size"/>';
			isUploadValid = false;
		}
		if($(obj)[0].files[0].size > 4000000){
			uploadMsg = '<spring:message code="svm.message.check_file_size"/>';
			isUploadValid = false;
		}
		if(!($(obj)[0].files[0].type == 'image/jpeg' || $(obj)[0].files[0].type == 'image/png' || $(obj)[0].files[0].type == 'application/pdf')){
			uploadMsg = '<spring:message code="message.alert.unsupport_file"/>';
			isUploadValid = false;
		}
	}
	if(!isUploadValid) alert(uploadMsg);
	return isUploadValid;
}

function validateBasic(){
	// custom validation 정의
	if($("#group_nm").val().length > 50){
		alert('<spring:message code="svm.header.group_name"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>');
		$("#group_nm").focus();
		return false;
	}
	if( $("[name=tov]:checked").length < 1 ){
		alert('<spring:message code="svm.message.wrong_select_tov"/>');
		$("#tovDivArea").attr('tabIndex','-1');
		$("#tovDivArea").focus();
		setTimeout(function(){
			$("#tovDivArea").removeAttr('tabIndex');
		},1500);
		return false;
	}
	if( $("[name=tov][value=04]").is(":checked") && $("[name=tov]:checked").length != 1 ){
		alert('<spring:message code="svm.message.select_multiple_workforce"/>');
		$("#tovDivArea").attr('tabIndex','-1');
		$("#tovDivArea").focus();
		setTimeout(function(){
			$("#tovDivArea").removeAttr('tabIndex');
		},1500);
		return false;
	}
	if( $("[name=pd]:checked").length > 4 || $("[name=pd]:checked").length < 2 ){
		alert('<spring:message code="svm.message.wrong_select_pd"/>');
		$("#pdDivArea").attr('tabIndex','-1');
		$("#pdDivArea").focus();
		setTimeout(function(){
			$("#pdDivArea").removeAttr('tabIndex');
		},1500);
		return false;
	}

	if( $("#given_nm").val() == "" ){
		alert('<spring:message code="svm.message.head_please_enter"/>' + ' <spring:message code="svm.header.givenNm"/>');
		$("#given_nm").focus();
		return false;
	}
	
	if( $("#given_nm").val().length >  100 ){
		alert('<spring:message code="svm.header.givenNm"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>');
		$("#given_nm").focus();
		return false;
	}
	
	if( $("#family_nm").val() == "" ){
		alert('<spring:message code="svm.message.head_please_enter"/>' + ' <spring:message code="svm.header.family_name"/>');
		$("#family_nm").focus();
		return false;
	}
	
	if( $("#family_nm").val().length >  100 ){
		alert('<spring:message code="svm.header.family_name"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>');
		$("#family_nm").focus();
		return false;
	}
	
	if( $("#nickname").val().length >  100 ){
		alert('<spring:message code="svm.header.nickname"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>');
		$("#nickname").focus();
		return false;
	}
	if( $("#nickname").val() == "" ){
		alert('<spring:message code="svm.message.head_please_enter"/>' + ' <spring:message code="svm.header.nickname"/>');
		$("#nickname").focus();
		return false;
	}
	
	if($("[type=radio][name=gender]:checked").length != 1 ){
		alert('<spring:message code="svm.message.no_select_gender"/>');
		return false;
	}
	if($("[type=radio][name=married_cd]:checked").length != 1 ){
		alert('<spring:message code="svm.message.no_select_married"/>');
		return false;
	}
	if($("select[name=blood_type_cd]").val() == "" ){
		setTimeout(function(){
			$("#blood_type_cd").get(0).focus(alert('<spring:message code="svm.message.no_select_blood"/>'));
		},1);
		return false;
	}
	var msg = '';
	if($("[type=radio][name=ctry_cd_fg]:checked").length != 1 ){
		alert('<spring:message code="svm.message.no_select_nationality"/>');
		$("#ctry_cd_fg1").focus();
		return false;
	}
	//Foreigner
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#passport_no").val() == ""){
		msg = '<spring:message code="svm.message.no_input_passport"/>';
		alert(msg);
		$("#passport_no").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#passport_no").val().length > 20 ){
		msg = '<spring:message code="svm.header.nationality.passport_no"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("#passport_no").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#file_passport").val() == "" && $("label[for=file_passport]").text().trim() == ""){
		msg = '<spring:message code="svm.message.no_upload_passport"/>';
		alert(msg);
		 $("#file_passport").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && !validationUpload($("#file_passport"))){
		$("#file_passport").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#ctry_cd").val() == "" ){
		msg = '<spring:message code="svm.message.no_select_ctry_cd"/>';
		alert(msg);
		$("#ctry_cd").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#foreign_city").val().trim() == "" ){
		msg = '<spring:message code="svm.message.no_input_city"/>';
		alert(msg);
		$("#foreign_city").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#foreign_city").val().length > 100 ){
		msg = '<spring:message code="svm.header.city"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("#foreign_city").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#address").val().trim() == "" ){
		msg = '<spring:message code="svm.message.no_input_address_dtl"/>';
		alert(msg);
		$("#address").focus();
		return false;
	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F' && $("#address").val().length > 4000 ){
		msg = '<spring:message code="svm.header.address_details"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("#address").focus();
		return false;
	}
	
	//Local
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("#ktp_no").val() == ""){                                                               
		msg = '<spring:message code="svm.message.head_please_enter"/>' + ' <spring:message code="svm.header.ktpNumber"/>';
		alert(msg);
		$("#ktp_no").focus();
		return false;
	}                                                                                           
	                                                                                           
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("#ktp_no").val().length > 16){                                                               
		msg = '<spring:message code="svm.message.limit_max_ktp" arguments="16"/>';
		alert(msg);
		$("#ktp_no").focus();
		return false;
	}                                                                                           
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("#provinsi_cd").val() == "" ){                                                            
		msg = '<spring:message code="svm.message.no_select_provinsi"/>';
		alert(msg);
		$("#provinsi_cd").focus();
		return false;
	}
	//TODO :test  
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'F'){
		$("#provinsi_cd").val('').trigger('change');
		$("#city_cd").val();
	}
	//
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("[title^=addr]").not(':disabled').length > 0 ){
		msg = '';
		var focusObj = '';
		$("[title^=addr]").not(':disabled').each(function(){
			if($(this).val() == ""){
				switch(this.id){ 
				  case 'city_cd'     :    msg = '<spring:message code="svm.message.no_select_city"/>'; 	 	focusObj = this.id; break;
				  case 'district_cd' :    msg = '<spring:message code="svm.message.no_select_district"/>';  focusObj = this.id; break;
				  case 'village_cd'  :    msg = '<spring:message code="svm.message.no_select_village"/>';      focusObj = this.id; break;
				default				 : 	  break;
				}
				return;
			}  
		});
		if(msg != ''){
			$("#"+focusObj).focus();
			alert(msg);
			return false;
		}
	}
// 	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("#city_cd").val() == "" ){
// 		msg = '<spring:message code="svm.message.no_select_city"/>';
// 		alert(msg);
// 		$("#city_cd").focus();
// 		return false;
// 	}
// 	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("#district_cd").val() == "" ){
// 		msg = '<spring:message code="svm.message.no_select_district"/>';
// 		alert(msg);
// 		$("#district_cd").focus();
// 		return false;
// 	}
// 	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("#village_cd").val() == "" ){
// 		msg = '<spring:message code="svm.message.no_select_city"/>';
// 		alert(msg);
// 		$("#village_cd").focus();
// 		return false;
// 	}
	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && $("#address_dtl").val() == "" ){
		msg = '<spring:message code="svm.message.no_input_address_dtl"/>';
		alert(msg);
		$("#address_dtl").focus();
		return false;
	}

	if($("[type=radio][name=ctry_cd_fg]:checked").val() == 'L' && !$("#address_dtl").val().length > 4000 ){
		msg = '<spring:message code="svm.header.address_details"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$$("#address_dtl").focus();
		return false;
	}
	
	if($("select[name=nationality_cd]").val() == ""){
		msg = '<spring:message code="svm.message.no_select_nationality_cd"/>';
		alert(msg);
		$("select[name=nationality_cd]").focus();
		return false;
	}
	if($("#postcode").val() == "" ){
		alert('<spring:message code="svm.message.no_input_postcode"/>');
		$("#postcode").focus();
		return false;
	}
	if($("#postcode").val().length > 20 ){
		alert('<spring:message code="svm.header.postcode"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>');
		$("#postcode").focus();
		return false;
	}
	if($("#mobile_no").val() == ""){
		msg = '<spring:message code="svm.message.no_input_mobile_no"/>';
		alert(msg);
		$("#mobile_no").focus();
		return false;
	}
	if($("#mobile_no").val().length > 20 ){
		msg = '<spring:message code="svm.header.mobile_number"/>' +' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("#mobile_no").focus();
		return false;
	}
// 	if($("#whats_no").val() == ""){
// 		msg = '<spring:message code="svm.message.no_input_whats_no"/>';
// 		alert(msg);
// 		$("#whats_no").focus();
// 		return false;
// 	}
	if($("#whats_no").val().length > 20){
		msg = '<spring:message code="svm.header.whatsapp_number"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("#whats_no").focus();
		return false;
	}
	if($("select[name=nationality_cd]").val() == "" ){
		alert('<spring:message code="svm.message.no_select_nationality"/>');
		$("select[name=nationality_cd]").focus();
		return false;
	}
	if($("[type=radio][name=occu_or_univ_cd]:checked").length != 1 ){
		alert('<spring:message code="svm.message.no_select_occu_or_univ"/>');
		return false;
	}
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'G' && $("#occu_cd").val() == ""){                                                               
		msg = '<spring:message code="svm.message.no_select_occu_cd"/>';
		alert(msg);
		$("#occu_cd").focus();
		return false;
	}                                                                                           
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'G' && $("[name=occu_or_univ_nm]").val() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_organ_nm"/>';
		alert(msg);
		$("[name=occu_or_univ_nm]").get(0).focus();
		return false;
	}                                                                                           
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'G' && $("[name=occu_or_univ_nm]").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.occupation_or_university"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("[name=occu_or_univ_nm]").focus();
		return false;
	}                                                                                           
		
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'U' && $("[name=occu_or_univ_nm]").val() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_univ_nm"/>';
		alert(msg);
		$("[name=occu_or_univ_nm]").focus();
		return false;
	}                                                                                           
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'U' && $("[name=occu_or_univ_nm]").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.occupation_or_university"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("[name=occu_or_univ_nm]").focus();
		return false;
	}                                                                                           
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'U' && $("#occu_or_univ_major_cd").val() == ""){                                                               
		msg = '<spring:message code="svm.message.no_select_occu_or_univ_major_cd"/>';
		alert(msg);
		$("#occu_or_univ_major_cd").focus();
		return false;
	}                                                                                           
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'U' && $("#occu_or_univ_st_major_cd").val() == ""){                                                               
		msg = '<spring:message code="svm.message.no_select_occu_or_univ_st_major_cd"/>';
		alert(msg);
		$("#occu_or_univ_st_major_cd").focus();
		return false;
	}                                                                                           
	
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'H' && $("[name=occu_or_univ_nm]").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_school_nm"/>';                              
		alert(msg);
		$("[name=occu_or_univ_nm]").focus();
		return false;
	}    
	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'H' && $("[name=occu_or_univ_nm]").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.occupation_or_university"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("[name=occu_or_univ_nm]").focus();
		return false;
	}    
	
	if($("#uni_shirts_cd").val() == "" ){                                                               
		msg = '<spring:message code="svm.message.head_please_select"/>' + ' <spring:message code="svm.header.uniform.shirt"/>';                          
		alert(msg);
		$("#uni_shirts_cd").focus();
		return false;
	}
	if($("#uni_waist_cd").val() == "" ){                                                               
		msg = '<spring:message code="svm.message.head_please_select"/>' + ' <spring:message code="svm.header.uniform.waist"/>';                            
		alert(msg);
		$("#uni_waist_cd").focus();
		return false;
	}
	if($("#uni_shoes_cd").val() == "" ){                                                               
		msg = '<spring:message code="svm.message.head_please_select"/>' + ' <spring:message code="svm.header.uniform.shoes"/>';
		alert(msg);
		$("#uni_shoes_cd").focus();
		return false;
	}
	
	if($("#height").val() == "" ){                                                               
		msg = '<spring:message code="svm.message.head_please_enter"/>' + ' <spring:message code="svm.header.height"/>';
		alert(msg);
		$("#height").focus();
		return false;
	}
	if($("#weight").val() == "" ){                                                               
		msg = '<spring:message code="svm.message.head_please_enter"/>' + ' <spring:message code="svm.header.weight"/>';
		alert(msg);
		$("#weight").focus();
		return false;
	}
	
	if($("#hobby").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.hobby"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                             
		alert(msg);
		$("#hobby").focus();
		return false;
	}    
	if($("#hobby").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_hobby"/>';                              
		alert(msg);
		$("#hobby").focus();
		return false;
	}    
	if($("#aspiration").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_aspiration"/>';
		alert(msg);
		$("#aspiration").focus();
		return false;
	}    
	if($("#aspiration").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.aspiration"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#aspiration").focus();
		return false;
	}
	if($("#facebook_nm").val().length > 100) {
		msg = '<spring:message code="svm.header.facebook"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#facebook_nm").focus();
		return false;
	}
	if($("#twitter_nm").val().length > 100) {
		msg = '<spring:message code="svm.header.twitter"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#twitter_nm").focus();
		return false;
	}
	if($("#line_nm").val().length > 100) {
		msg = '<spring:message code="svm.header.line"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#line_nm").focus();
		return false;
	}
	if($("#hobby").val().length > 100) {
		msg = '<spring:message code="svm.header.hobby"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#hobby").focus();
		return false;
	}
	if($("#aspiration").val().length > 100) {
		msg = '<spring:message code="svm.header.aspiration"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#aspiration").focus();
		return false;
	}
	if($("#motto").val().length > 4000) {
		msg = '<spring:message code="svm.header.motto"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#motto").focus();
		return false;
	}
	if($("#reason").val().length > 4000) {
		msg = '<spring:message code="svm.header.reason_to_join_volunteer"/> ' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#reason").focus();
		return false;
	}
	
	if($("#sd_schl_year").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_sd_year"/>';                              
		alert(msg);
		selFocus = false;
		$("#sd_schl_year").focus();
		return false;
	}    
	if($("#smp_schl_year").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_smp_year"/>';                              
		alert(msg);
		selFocus = false;
		$("#smp_schl_year").focus();
		return false;
	}    
	if($("#sma_schl_year").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_sma_year"/>';                              
		alert(msg);
		selFocus = false;
		$("#sma_schl_year").focus();
		return false;
	}  
	if($("#sd_schl_year").val().trim().length != 4 ){                                                               
		msg = '<spring:message code="svm.message.miss_match_year"/>' + ' <spring:message code="svm.header.sd_or_equals"/>';
		alert(msg);
		selFocus = false;
		$("#sd_schl_year").focus();
		return false;
	}    
	if($("#smp_schl_year").val().trim().length != 4){                                                               
		msg = '<spring:message code="svm.message.miss_match_year"/>' + ' <spring:message code="svm.header.smp_or_equals"/>';                              
		alert(msg);
		selFocus = false;
		$("#smp_schl_year").focus();
		return false;
	}    
	if($("#sma_schl_year").val().trim().length != 4){                                                               
		msg = '<spring:message code="svm.message.miss_match_year"/>' + ' <spring:message code="svm.header.sma_or_equals"/>';
		alert(msg);
		selFocus = false;
		$("#sma_schl_year").focus();
		return false;
	}  
	if($("#sd_schl_nm").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_sd_nm"/>';                              
		alert(msg);
		$("#sd_schl_nm").focus();
		return false;
	}    
	if($("#smp_schl_nm").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_smp_nm"/>';                              
		alert(msg);
		$("#smp_schl_nm").focus();
		return false;
	}    
	if($("#sma_schl_nm").val().trim() == ""){                                                               
		msg = '<spring:message code="svm.message.no_input_sma_nm"/>';                              
		alert(msg);
		$("#sma_schl_nm").focus();
		return false;
	}  
	if($("#sd_schl_nm").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.sd_or_equals"/>' + ' <spring:message code="svm.header.school_name"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#sd_schl_nm").focus();
		return false;
	}    
	if($("#smp_schl_nm").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.smp_or_equals"/>' + ' <spring:message code="svm.header.school_name"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#smp_schl_nm").focus();
		return false;
	}    
	if($("#sma_schl_nm").val().length > 100){                                                               
		msg = '<spring:message code="svm.header.sma_or_equals"/>' + ' <spring:message code="svm.header.school_name"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';                              
		alert(msg);
		$("#sma_schl_nm").focus();
		return false;
	}  
	
// 	if($("[type=radio][name=occu_or_univ_cd]:checked").val() == 'H' && $("[name=occu_or_univ_nm]").val().trim() == ""){                                                               
// 		msg = '<spring:message code="svm.message.no_input_school_nm"/>';                              
// 		alert(msg);
// 		$("[name=occu_or_univ_nm]").focus();
// 		return false;
// 	}    
	 
	if($("[id=university_lvl_yn]:checked").length == 1){
		var yearCnt = 0; 
		var line1 = 0;
		var line2 = 0;
		var line3 = 0;
		var isEscape = false; 
		var emptyObjList = new Array();
		var unMatchObjList = new Array();
		var msgList = new Array();
		
		$("input[type=text][name^=university_]").each(function(i){
			if($(this).val().trim() == ""){
				if($(this)[0] == $("input[type=text][name^=university_university]")[0]){ line1++; emptyInput = $(this); emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_university_university"/>'; msgList.push(msg);		 return; } 
				if($(this)[0] == $("input[type=text][name^=university_faculty]")[0]){ line1++; emptyInput = $(this); emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_university_faculty"/>'; msgList.push(msg); return; } 
				if($(this)[0] == $("input[type=text][name^=university_year]")[0]){ yearCnt++; line1++; emptyObjList.push($(this));   
					msg = '<spring:message code="svm.message.no_input_university_year"/>'; msgList.push(msg); return; }
			}else{
				if($(this)[0] == $("input[type=text][name^=university_year]")[0] && $(this).val().length != 4){
					msg = '<spring:message code="svm.message.miss_match_year"/>' + ' <spring:message code="svm.header.university_or_equals"/>';
					msgList.push(msg);
					selFocus = false;
					unMatchObjList.push($(this));
					return;
				}
			}
		});
		
		if(unMatchObjList.length > 0 ){
			alert(msgList[0]); unMatchObjList[0].get(0).focus(); return false;
		}
		if(!(line1 == 0 || line1 == 3)){
			alert(msgList[0]); emptyObjList[0].get(0).focus(); return false;
		}
		
		emptyObjList = [];
		unMatchObjList = [];
		msgList = [];
		$("input[type=text][name^=post_grad_]").each(function(i){
			if($(this).val().trim() == ""){
				if($(this)[0] == $("input[type=text][name^=post_grad_university]")[0]){ line2++; emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_post_grad_university"/>'; msgList.push(msg); return; }
				if($(this)[0] == $("input[type=text][name^=post_grad_faculty]")[0]){ line2++; emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_post_grad_faculty"/>'; msgList.push(msg); return; } 
				if($(this)[0] == $("input[type=text][name^=post_grad_year]")[0]){ line2++;	yearCnt++; emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_post_grad_year"/>'; msgList.push(msg); return; }
			} else {
				if($(this)[0] == $("input[type=text][name^=post_grad_year]")[0] && $(this).val().length != 4){
					msg = '<spring:message code="svm.message.miss_match_year"/>' + ' <spring:message code="svm.header.post_or_equals"/>';
					msgList.push(msg);
					selFocus = false;
					unMatchObjList.push($(this));
					return;
				}
			}
		});
		
		if(unMatchObjList.length > 0 ){
			alert(msgList[0]); unMatchObjList[0].get(0).focus(); return false;
		}
		if(!(line2 == 0 || line2 == 3)){
			alert(msgList[0]); emptyObjList[0].get(0).focus(); return false;
		}
		
		emptyObjList = [];
		unMatchObjList = [];
		msgList = [];
		$("input[type=text][name^=doctoral_]").each(function(){
			if($(this).val().trim() == ""){
				if($(this)[0] == $("input[type=text][name^=doctoral_university]")[0]){ line3++; emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_doctoral_university"/>'; msgList.push(msg); return; }
				if($(this)[0] == $("input[type=text][name^=doctoral_faculty]")[0]){ line3++; emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_doctoral_faculty"/>'; msgList.push(msg); return; }
				if($(this)[0] == $("input[type=text][name^=doctoral_year]")[0]){ yearCnt++; line3++; emptyObjList.push($(this));
					msg = '<spring:message code="svm.message.no_input_doctoral_year"/>'; msgList.push(msg); return; }
			} else {
				if($(this)[0] == $("input[type=text][name^=doctoral_year]")[0] && $(this).val().length != 4){
					msg = '<spring:message code="svm.message.miss_match_year"/>' + ' <spring:message code="svm.header.doctoral_or_equals"/>';
					msgList.push(msg);
					selFocus = false;
					unMatchObjList.push($(this));
					return;
				}
			}
		});
		
		if(unMatchObjList.length > 0 ){
			alert(msg); unMatchObjList[0].get(0).focus(); return false;
		}
		if(!(line3 == 0 || line3 == 3)){
			alert(msgList[0]); emptyObjList[0].get(0).focus(); return false;
		}
		
		if( yearCnt == '3'){
			//년도 선택 alert
			alert('<spring:message code="svm.message.no_input_university_year"/>');
			//$("#university_year").focus();
			return false;
		}
	}
	
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#university_year").val().length != 4 ){                                                 
// 		msg = ' <spring:message code="svm.header.university_or_equals"/>' + ' <spring:message code="svm.header.faculty"/> <spring:message code="svm.message.over_length" arguments=" "/>';
// 		alert(msg);
// 		$("#university_year").focus();
// 		return false;
// 	}                                                                                      
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#post_grad_year").val().length != 4 ){                                                  
// 		msg = ' <spring:message code="svm.header.post_or_equals"/>' + ' <spring:message code="svm.header.faculty"/> <spring:message code="svm.message.over_length" arguments=" "/>';
// 		alert(msg);
// 		$("#post_grad_year").focus();
// 		return false;
// 	}                                                                                      
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#doctoral_year").val().length != 4 ){                                                   
// 		msg = ' <spring:message code="svm.header.doctoral_or_equals"/>' + ' <spring:message code="svm.header.faculty"/> <spring:message code="svm.message.over_length" arguments=" "/>';
// 		alert(msg);
// 		$("#doctoral_year").focus();
// 		return false;
// 	}
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#university_university").val() == ""){                                       
// 		msg = '<spring:message code="svm.message.no_input_doctoral_university"/>';                      
// 		alert(msg);
// 		$("#university_university").focus();
// 		return false;                                                                                   
// 	}                                                                                                   
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#post_grad_university").val() == ""){                                        
// 		msg = '<spring:message code="svm.message.no_input_post_grad_university"/>';                     
// 		alert(msg);                                                                                     
// 		$("#post_grad_university").focus();
// 		return false;       
// 	}                                                                                                   
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#doctoral_university").val() == ""){                                         
// 		msg = '<spring:message code="svm.message.no_input_doctoral_university"/>';
// 		alert(msg);
// 		$("#doctoral_university").focus();
// 		return false;
// 	}
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#university_university").val().length > 100){                                                 
// 		msg = ' <spring:message code="svm.header.doctoral_or_equals"/>' + ' <spring:message code="svm.header.university"/> <spring:message code="svm.message.over_length" arguments=" "/>';
// 		alert(msg);
// 		$("#university_university").focus();
// 		return false;
// 	}                                                                                      
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#post_grad_university").val().length > 100){                                                  
// 		msg = ' <spring:message code="svm.header.doctoral_or_equals"/>' + ' <spring:message code="svm.header.university"/> <spring:message code="svm.message.over_length" arguments=" "/>';
// 		alert(msg);
// 		$("#post_grad_university").focus();
// 		return false;
// 	}                                                                                      
// 	if($("[name=university_lvl_yn]:checked").length == 1 && $("#doctoral_university").val().length > 100){                                                   
// 		msg = ' <spring:message code="svm.header.doctoral_or_equals"/>' + ' <spring:message code="svm.header.university"/> <spring:message code="svm.message.over_length" arguments=" "/>';
// 		alert(msg);
// 		$("#doctoral_university").focus();
// 		return false;
// 	}
	//
	
	if( $("#prnts_mother_nm").val().length > 100 ){                                                               
		msg = "<spring:message code='svm.header.mothers'/> " + " <spring:message code='svm.message.over_length' arguments=' '/>";  
		alert(msg);
		$("#prnts_mother_nm").focus();
		return false;
	}                                                                                           
	if( $("#prnts_father_nm").val().length > 100 ){                                                               
		msg = "<spring:message code='svm.header.fathers'/> " + " <spring:message code='svm.message.over_length' arguments=' '/>";   
		alert(msg);
		$("#prnts_father_nm").focus();
		return false;
	}                                                                                           
	if( $("#emer_phone").val() == "" ){                                                               
		msg = '<spring:message code="svm.message.no_input_emer_phone"/>';
		alert(msg);
		$("#emer_phone").focus();
		return false;
	}                                                                                           
	if( $("#emer_phone").val().lenghth > 20 ){                                                               
		msg = '<spring:message code="svm.header.emergency"/>' + ' <spring:message code="svm.header.phone"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
		alert(msg);
		$("#emer_phone").focus();
		return false;
	}                                                                                           
	if( $("#emer_rel_cd").val() == "" ){                                                               
		msg = '<spring:message code="svm.message.no_select_emer_rel_cd"/>';
		alert(msg);
		$("#emer_rel_cd").focus();
		return false;
	}    
	return true;
}

function changeAddr(obj){
	var addr_nm = obj[0].name;  
	var target_id =  "";
	var addr_cd = obj[0].value;
	var addrArry = "";
	var addrObj = "";
	var optionsHtml = "";
	
	if('' != addr_cd){
		sendRequest({
	  		action: '/svm/changeAddr',
	  		params:{
	  			 flag 		: obj[0].name 
	  			,code_value : obj[0].value
	  		},
	  		callbackFunc:function(resData){
	  			if(resData.success){
	  				addrObj = JSON.parse(resData.result);
	  				switch (addr_nm) {
	  				case "provinsi_cd"	: 
	  									  addrArry = addrObj.CITY_CD;
	  									  target_id = 'city_cd';
	  									  break;
	  				case "city_cd" 		: 
	  									  addrArry = addrObj.DISTRICT_CD;
	  									  target_id = 'district_cd';
	  									  break;
	  				case "district_cd"  : 
	  									  addrArry = addrObj.VILLAGE_CD;
	  									  target_id = 'village_cd';
	  									  break;
	 				default				: 
	 									  break;
	  				}
	 				
  					switch (addr_nm) {    
  					case "provinsi_cd"	: $("#city_cd").children('option').remove();     $("#city_cd").prop('disabled',true);
  					case "city_cd" 		: $("#district_cd").children('option').remove(); $("#district_cd").prop('disabled',true);
  					case "district_cd"  : $("#village_cd").children('option').remove();  $("#village_cd").prop('disabled',true);
  					default				:break; 
  										  
  					}
  					
	  				if(addrArry.length == 0 ){
	  					$("#"+target_id).prop('disabled',true);
	  					//optionsHtml += '<option value=""> </option>';
	  				}
	  				else{
	  					$("#"+target_id).prop('disabled',false);
	  					optionsHtml += '<option value="">Select an option</option>';
	  				}
	  				
	  				for(var i=0; i<addrArry.length; i++){
	  					optionsHtml += '<option value="' + addrArry[i].MINOR_CD + '">' + addrArry[i].CODE_NM1 + '</option>'; 
	  				}
	  				$("#"+target_id).children('option').remove();
	  				$("#"+target_id).append(optionsHtml);
	  				
	  				if("<c:out value='${svmVolVo.city_cd}'/>".trim() != "" && $("#city_cd").val().trim() == "" ){
	  					$("select[id=city_cd]").val("<c:out value='${svmVolVo.city_cd}'/>").trigger('change');
	  				}
	  				if("<c:out value='${svmVolVo.district_cd}'/>".trim() != "" && $("#district_cd").val().trim() == "" ){
	  					$("select[id=district_cd]").val("<c:out value='${svmVolVo.district_cd}'/>").trigger('change');
	  				}
	  				if("<c:out value='${svmVolVo.village_cd}'/>".trim() != "" && $("#village_cd").val().trim() == "" ){
	  					$("select[id=village_cd]").val("<c:out value='${svmVolVo.village_cd}'/>");
	  				}
	  				
	  			}else {
	 				console.log(resData);
	  			}
	  		}
	  	});
	} else {
		// value == empty
		switch (addr_nm) {    
		case "provinsi_cd"	: $("#city_cd").children('option').remove();     $("#city_cd").prop('disabled',true);
		case "city_cd" 		: $("#district_cd").children('option').remove(); $("#district_cd").prop('disabled',true);
		case "district_cd"  : $("#village_cd").children('option').remove();  $("#village_cd").prop('disabled',true);
		default				:break; 
							  
		}
	}
	
}

function formatWeight(obj){
	if( obj.value.length > 2 ){
		var removeDot = $(obj).val().replace(/\./g,'');
		if(obj.value.length == 3){
			obj.value = removeDot.substring(0,removeDot.length) + '.0'; 
		}else{
			obj.value = removeDot.substring(0,removeDot.length-1) + '.' + removeDot.substring(removeDot.length-1,removeDot.length);
		}
	}
}

function fnEnterWeight(obj){
	var inputVal = $(obj).val();
    var regType1 = /^[0-9|.]*$/;
    console.log("out " + event.keyCode);
    if(!regType1.test($(obj).val())){
    	console.log(event.keyCode);
        if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 ) return;
	    $(obj).val($(obj).val().replace(event.key,'').trim());
    }
    $(obj).val($(obj).val().replace(/(^0+)/,''));
}

function fnMaxLength(obj,size){
	if(obj.value.length > size){
		alert('[' + obj.title + ']' + ' <spring:message code="svm.message.over_length" arguments=" "/>');
		obj.value = obj.value.substring(0,size);
	}
}

var selFocus = true;
function fnEnterYear(obj,size){
	if(selFocus){
		if(obj.value.length != 4 && $(obj).val().trim().length > 0){
			alert('<spring:message code="svm.info.msg.enter_correctly_date"/> ex) YYYY ');
			//obj.select();
			//obj.focus();
			selFocus = false;
		}
	}else{
		selFocus= true;
	}
}

function fnEnterPassport(obj){
   if (!(event.keyCode >=37 && event.keyCode<=40)) {
    var inputVal = $(obj).val();
	//alert('<spring:message code="svm.info.can_input_passport"/>');
    $(obj).val(inputVal.replace(/[^a-z0-9]/gi,'').trim());
    $(obj).focus();
   }
}


function fnEnterMobile(obj){
    var inputVal = $(obj).val();
    var regType1 = /^[0-9|(|)|-|-|+]*$/;
//     $(obj).val(inputVal.replace( /^[0-9|(|)|-]*$/,''));
//     if(!regType1.test($(obj).val())){
// 	    $(obj).val($(obj).val().replace(event.key,''));
//     }
	if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 ) return;
	$(obj).val($(obj).val().replace(/[^0-9|(|)|\-|+]/g,''));
}

function fnPreventNm(e){
	var code = e.keyCode;
	console.log(code);
	 if ((90 >= k && k >= 65) // a ~ z
	            || (111 >= k && k >= 106) // keypad operator
	            || (192 >= k && k >= 186) // -,=./;
	            || (222 >= k && k >= 219) // ']\[
	            || k == 32 // space bar
	            || k == 59 // FF ;
	            || k == 61 // FF =
	            || k == 173 // FF -
	            ) { 
	        e.preventDefault();
	    }
}

function fnEnterName(obj){
    var inputVal = $(obj).val();
	if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 ) return;
	$(obj).val($(obj).val().replace(/[0-9|(|)|\-|+|\]|\[|\{|}|<|>|?|~!@|`|\\|#$%^&*-=+_\'\"]/g,''));
}

function fnUpperCase(obj){
	$(obj).val($(obj).val().toUpperCase());
}

function blurWeight(obj){
	if($(obj).val() == '0'){
		$(obj).val('');
	}
}

</script>
