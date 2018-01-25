<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
	
<% pageContext.setAttribute("enter","\n"); %>
<%pageContext.setAttribute("crlf", "<"); %>
<%pageContext.setAttribute("crlf2", "\""); %>
<%pageContext.setAttribute("crlf3", "/script'"); %>
<%pageContext.setAttribute("crlf3", "</script>"); %>
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
<form:form commandName="svmVolVo" name="svmVolVo" id="svmVolVo" autocomplete="off" enctype="multipart/form-data" >
			<form:hidden path="kind" />
			<form:hidden path="save_tab_cd" />
			<form:hidden path="regi_no" />
			<form:hidden path="ad_no" />
			<form:hidden path="email" />
			<input type="hidden" name="lang" value="${lang}" />
			<input type="hidden" id="moveTo" name="moveTo" />
			<input type="hidden" id="hid_clone">
	<!-- ▼contents▼ -->

<ul class="step_02">
	<li ><spring:message code="svm.title.basic_information" /></li>
	<li ><spring:message code="svm.title.upload_photo" /></li>
	<li class="on"><spring:message code="svm.title.games_information" /></li>
	<li ><spring:message code="svm.title.finish_registeration" /></li>
</ul>


<!--▼table_write-->

<div class="con_title_01 con_title_01_add">
	<spring:message code="svm.header.work_location"/>
	<div class="explain_support_01">
		<spring:message code="svm.header.input_field_required" arguments="( * )" />
	</div>
</div>

<div class="table_write table_write_support_01">

	<div >
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.selected_location" /><span class="must_01"></span>
				</strong>
			</dt>
			<dd class="sel_loc_div" id="selLocDivArea">
				<strong>
					<output id="avail_location_cd" name="avail_location_cd" title=""></output>
<!-- 					<input type="checkbox" id="c01_01" class="checkbox_01" style="width:80px;" name=""><label>Jakarta</label> -->
<!-- 					<input type="checkbox" id="c01_02" class="checkbox_01" name=""><label>Palembang</label> -->
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.preferred_work_duration"/>
				</strong>
			</dt>
			<dd >
				<strong>
					<form:select path="avail_work_cd" class="select_01" style="width:300px" title="">
					</form:select>
					<input type="hidden" name="hid_avail_work_cd" id="hid_avail_work_cd">
				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.header.description_of_preferred_work_duration" var="description_of_preferred_work_duration_prop"/>
					${description_of_preferred_work_duration_prop }
				</strong>
			</dt>
			<dd >
				<strong>
					<textarea id="avail_work_desc" name="avail_work_desc" title="${description_of_preferred_work_duration_prop }" class="textarea_01" style="width:860px; height:80px;" placeholder="" onkeyup="fnMaxLength(this,4000);countChar(this,'counter',4000);"><c:out value="${svmVolVo.avail_work_desc}"/></textarea>
					
					<div style="text-align:right; padding:2px 20px 0 0;"><output id="counter">4000</output> <spring:message code='svm.header.characters_remaining'/></div>
				</strong>
			</dd>
		</dl>
	</div>
	
</div>


<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.header.language_skill_upper"/><div class="explain_support_01"><spring:message code="svm.header.input_field_required"/></div>
</div>

<div class="table_write table_write_support_01" id="langSkillDiv">

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.form.lang_nm"/> <strong class="langText" > 1 </strong>
				</strong>
			</dt>
			<dd >
				<strong>
					<input type="checkbox" id="lang_use_yn" class="checkbox_02 lang_use_yn" name="use_yn" value="Y" checked><label for="lang_use_yn"><span></span></label>
					<div style="display:inline-block;">
						<!-- ▼Language 1 checked 시-->
						<div style="display:block;" class="langSkillView">
							<span class="txt_01" style="padding:0 8px 0 20px;"><spring:message code="svm.form.skill"/><span class="must_01"></span></span>
							<form:select path="skill_cd" class="select_01" style="width:180px" title="" onchange="fnLangChange(this);"></form:select>
							<input type="hidden" name="hid_skill_cd">					
							<span class="txt_01" style="padding:0 8px 0 20px;"><spring:message code="svm.header.level"/><span class="must_01"></span></span>
							<form:select path="level_cd" class="select_01" style="width:180px" title=""></form:select>
							<input type="hidden" name="hid_level_cd">
							<output class="lang_nm_div" style="display:none;">
							<span class="txt_01" style="padding:0 8px 0 20px; font-size: 16px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
							<input type="text" class="input_01" name="lang_name_txt" id="lang_name_txt" style="width:180px;" value="" maxlength="100" onkeyup="fnEnterName(this);">
							</output> 
						</div>
						<!-- ▲Language 1 checked 시-->
					</div>

				</strong>
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.form.lang_nm"/> <strong class="langText" > 2 </strong>
				</strong>
			</dt>
			<dd >
				<strong>
					<input type="checkbox" id="lang_use_yn2" class="checkbox_02 lang_use_yn" name="use_yn" ><label for="lang_use_yn2"><span></span></label>
					
					<div style="display:inline-block;" >
						<!-- ▼Language 2 unchecked 시-->
						<div style="display:none;" class="langSkillView">
							<span class="txt_01" style="padding:0 8px 0 20px;"><spring:message code="svm.form.skill"/><span class="must_01"></span></span>
							<select id="skill_cd2" name="skill_cd" class="select_01" style="width:180px" title="" onchange="fnLangChange(this);" ></select>
							<input type="hidden" name="hid_skill_cd">					
							<span class="txt_01" style="padding:0 8px 0 20px;"><spring:message code="svm.header.level"/><span class="must_01"></span></span>
							<select id="level_cd2" class="select_01" name="level_cd" style="width:180px" title=""></select>
							<input type="hidden" name="hid_level_cd">
							<output class="lang_nm_div" style="display:none;">
							<span class="txt_01" style="padding:0 8px 0 20px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
							<input type="text" class="input_01" name="lang_name_txt" id="lang_name_txt2" style="width:180px;" value="" maxlength="100" onkeyup="fnEnterName(this);">
							</output>
						</div>
						<!-- ▲Language 2 unchecked 시-->
					</div>
				</strong>
			</dd>
		</dl>
	</div>

</div>

<!-- <div style="display:none"> -->
<!-- 	<dl id="fileDiv"> -->
<!-- 		<dt style="display:none;"></dt> -->
<!-- 		<dd> -->
<!-- 			<strong> -->
<%-- 				<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.upload_certificates"/><span class="must_01"></span></span> --%>
<!-- 				<div class="upload_01" style="width:300px;"> -->
<!-- 					<input type="file" id="originFile"><label for="originFile" title="Upload"></label> -->
<!-- 				</div> -->
<%-- 				<span class="txt_01" style="padding:0 0 0 10px;"><spring:message code="svm.info.file_type_max" arguments="JPG,PNG;4;" argumentSeparator=";"/></span> --%>
<!-- 			</strong> -->
<!-- 		</dd> -->
<!-- 	</dl> -->
<!-- </div> -->

<div class="con_title_01 con_title_01_add" style="margin-top:40px;">
	<spring:message code="svm.header.additional_skill" />
	<div class="explain_support_01">
		<spring:message code="svm.header.input_field_required" arguments="( * )" /> 
	</div>
</div>

<div class="table_write table_write_support_01" id="addSkillDiv">
	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.form.skill" /><strong class="langText" > 1 </strong>
				</strong>
			</dt>
			
			<dd class="cell_merge merge_add">
				<dl>
					<dt style="display:none;"></dt>
					<dd>
						<strong>
							<input type="checkbox" id="add_use_yn" class="checkbox_02 add_use_yn" name="use_yn" value="Y" checked><label for="add_use_yn"><span></span></label>
						</strong>
					</dd>
				</dl>
				
				<!-- ▼Skill 1 checked 시-->
				<div style="display:block;" class="addSkillView">
					<dl>
						<dt style="display:none;"></dt>
						<dd >
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
								<input type="text" name="name_txt" class="input_01" style="width:500px;" maxlength="100" onkeyup="fnEnterName(this);" />
							</strong>
						</dd>
					</dl>
					<dl>
						<dt style="display:none;"></dt>
						<dd class="addFileDiv">
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.upload_certificates" /><span class="must_01"></span></span>
								<div class="upload_01" style="width:300px;">
									<input type="file" id="add_skill_file" name="skillPhoto"><label for="add_skill_file" title="Upload"></label>
									<input type="hidden" name="certi_nm">
									<input type="hidden" name="certi_fg">
								</div>
								<span class="txt_01" style="padding:0 0 0 10px;"><spring:message code="svm.info.file_type_max" arguments="JPG,PNG;4;" argumentSeparator=";"/></span>
							</strong>
						</dd>
					</dl>
					<dl>
						<dt style="display:none;"></dt>
						<dd >
							<strong>
							<spring:message code="svm.header.description" var="description_prop"/>
								<span class="txt_01" style="padding:0 8px 0 0px;">${description_prop}<span class="must_01"></span></span>
								<form:textarea path="description" class="textarea_01" title="${description_prop}" style="width:740px; height:80px; vertical-align:middle;"  placeholder="" onkeyup="fnMaxLength(this,4000);" ></form:textarea>
							</strong>
						</dd>
					</dl>
				</div>
				<!-- ▲Skill 1 checked 시-->
				
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.form.skill" /><strong class="langText" > 2 </strong>
				</strong>
			</dt>
			
			<dd class="cell_merge merge_add">
				<dl>
					<dt style="display:none;"></dt>
					<dd >
						<strong>
							<input type="checkbox" id="add_use_yn2" class="checkbox_02 add_use_yn" name="use_yn" value="Y" ><label for="add_use_yn2"><span></span></label>
						</strong>
					</dd>
				</dl>
				
<!-- 				▼Skill 2 unchecked 시 -->
				<div style="display:none;" class="addSkillView">
					<dl>
						<dt style="display:none;"></dt>
						<dd >
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
								<input type="text" class="input_01" name="name_txt" style="width:500px;" value="" maxlength="100" onkeyup="fnEnterName(this);">
							</strong>
						</dd>
					</dl>
					<dl>
						<dt style="display:none;"></dt>
						<dd class="addFileDiv">
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.upload_certificates" /><span class="must_01"></span></span>
								<div class="upload_01" style="width:300px;">
									<input type="file" id="add_skill_file2" name="skillPhoto"><label for="add_skill_file2" title="Upload"></label>
									<input type="hidden" name="certi_nm">
									<input type="hidden" name="certi_fg">
								</div>
								<span class="txt_01" style="padding:0 0 0 10px;"><spring:message code="svm.info.file_type_max" arguments="JPG,PNG;4;" argumentSeparator=";"/></span>
							</strong>
						</dd>
					</dl>
					<dl>
						<dt style="display:none;"></dt>
						<dd >
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.description" /><span class="must_01"></span></span>
								<textarea class="textarea_01" id="description2" name="description"  title="${description_prop}"  style="width:760px; height:80px; vertical-align:middle;" name=""  placeholder="" onkeyup="fnMaxLength(this,4000);"></textarea>
							</strong>
						</dd>
					</dl>
				</div>
<!-- 				▲Skill 2 unchecked 시 -->
				
			</dd>
		</dl>
	</div>

	<div>
		<dl>
			<dt class="cell_01" style="width:278px;">
				<strong>
					<spring:message code="svm.form.skill" /><strong class="langText" > 3 </strong>
				</strong>
			</dt>
			
			<dd class="cell_merge merge_add">
				<dl>
					<dt style="display:none;"></dt>
					<dd >
						<strong>
							<input type="checkbox" id="add_use_yn3" class="checkbox_02 add_use_yn" name="use_yn" value="Y" ><label for="add_use_yn3"><span></span></label>
						</strong>
					</dd>
				</dl>
				
				<div style="display:none;"  class="addSkillView">
					<dl>
						<dt style="display:none;"></dt>
						<dd >
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
								<input type="text" class="input_01" name="name_txt" id="name_txt3" style="width:500px;" value="" maxlength="100" onkeyup="fnEnterName(this);">
							</strong>
						</dd>
					</dl>
					<dl>
						<dt style="display:none;"></dt>
						<dd class="addFileDiv">
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.upload_certificates" /><span class="must_01"></span></span>
								<div class="upload_01" style="width:300px;">
									<input type="file" id="add_skill_file3" name="skillPhoto"><label for="add_skill_file3" title="Upload"></label>
										<input type="hidden" name="certi_nm">
										<input type="hidden" name="certi_fg">
								</div>
								<span class="txt_01" style="padding:0 0 0 10px;"><spring:message code="svm.info.file_type_max" arguments="JPG,PNG;4;" argumentSeparator=";"/></span>
							</strong>
						</dd>
					</dl>
					<dl>
						<dt style="display:none;"></dt>
						<dd >
							<strong>
								<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.description" /><span class="must_01"></span></span>
								<textarea class="textarea_01" id="description3"  title="${description_prop}" name="description" style="width:760px; height:80px; vertical-align:middle;" name=""  placeholder="" onkeyup="fnMaxLength(this,4000);"></textarea>
							</strong>
						</dd>
					</dl>
				</div>
				
			</dd>
		</dl>
	</div>

</div>




<div class="con_title_01 con_title_01_add" style="margin-top:40px;" >
	<spring:message code="svm.header.sport_event_experience" />
	<div class="explain_support_01"><spring:message code="svm.header.input_field_required"/></div>
</div>

<div class="table_write table_write_support_01" id="sportEvntDiv">

	<ul class="add_row" style="display:block;">
		<li>
			<div>
				<dl>
					<dt style="display:none;"></dt>
					<dt class="cell_01" style="width:278px;">
						<strong>
							<spring:message code="svm.form.experience" /> <strong class="langText" > 1 </strong>
						</strong>
					</dt>
					
					<dd class="cell_merge merge_add">
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<input type="checkbox" id="sport_exp_use_yn" class="checkbox_02 sport_exp_use_yn" name="use_yn" value="Y" checked><label for="sport_exp_use_yn"><span></span></label>
								</strong>
							</dd>
						</dl>
						
						<!-- ▼Experience 1 checked 시-->
						<div style="display:block;" class="sportDtlView">
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 55px 0 0px;"><spring:message code="svm.header.level" /><span class="must_01"></span></span>
										<select class="select_01" id="sport_level_cd" name="level_cd" style="width:500px" title="" onchange="changeExperience($(this));">
										</select>
										<input type="hidden" name="hid_sport_level_cd">
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 47px 0 0px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
										<select class="select_01" id="name_cd" name="name_cd" style="width:500px" title="">
										</select>
										<input type="hidden" name="hid_name_cd">
										<input type="hidden" name="hid_sport_nm_cd">
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 26px 0 0px;"><spring:message code="svm.form.duration" /><span class="must_01"></span></span>
										<input type="text" class="input_01" id="duration" name="duration" style="width:500px;" value="" placeholder="days" maxlength="4" onkeyup="onlyNum2(this);">
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.description" /><span class="must_01"></span></span>
										<textarea class="textarea_01" id="sport_desc" title="${description_prop}" style="width:760px; height:80px; vertical-align:middle;" name="description"  placeholder="" onkeyup="fnMaxLength(this,4000);"></textarea>
									</strong>
								</dd>
							</dl>
						</div>
						<!-- ▲Experience 1 checked 시-->
						
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	
	<!-- ▼add more▼-->
	<ul class="add_row" style="display:block;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong>
							<spring:message code="svm.form.experience" /> <strong class="langText" > 2 </strong>
						</strong>
					</dt>
					
					<dd class="cell_merge merge_add">
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<input type="checkbox" id="sport_exp_use_yn2" class="checkbox_02 sport_exp_use_yn" name="use_yn" value="Y"><label for="sport_exp_use_yn2"><span></span></label>
								</strong>
							</dd>
						</dl>
						
						<!-- ▼Experience 2 checked 시-->
					<div style="display:none;" class="sportDtlView">
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<span class="txt_01" style="padding:0 55px 0 0px;"><spring:message code="svm.header.level" /><span class="must_01"></span></span>
									<select class="select_01" id="sport_level_cd2" name="level_cd" style="width:500px" title="" onchange="changeExperience($(this));">
									</select>
								</strong>
							</dd>
						</dl>
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<span class="txt_01" style="padding:0 47px 0 0px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
									<select class="select_01" id="name_cd2" name="name_cd" style="width:500px" title="">
									</select>
								</strong>
							</dd>
						</dl>
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<span class="txt_01" style="padding:0 26px 0 0px;"><spring:message code="svm.form.duration" /><span class="must_01"></span></span>
									<input type="text" class="input_01" id="duration2" name="duration" style="width:500px;" value="" placeholder="days" onkeyup="onlyNum2(this);" maxlength="4" >
								</strong>
							</dd>
						</dl>
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.description" /><span class="must_01"></span></span>
									<textarea class="textarea_01" id="sport_desc2" title="${description_prop}"  style="width:760px; height:80px; vertical-align:middle;" name="description"  placeholder="" onkeyup="fnMaxLength(this,4000);"></textarea>
								</strong>
							</dd>
						</dl>
					</div>
					<!-- ▲Experience 1 checked 시-->
						
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	<!-- ▲add more▲-->

</div>

<!-- <div style="border-top:1px solid #363636; position:relative; top:-1px;"></div> -->




<div class="btn_area_01" style="margin:10px 0 0px 0;">
	<div class="btn_right">
		<a onclick='drawHtml("sportEvntDiv");' class="btn_round_add_001"><spring:message code="svm.button.add_more" /></a>
	</div>
</div>



<div class="con_title_01 con_title_01_add" style="margin-top:40px;" >
	<spring:message code="svm.header.other_event_experience" />
	<div class="explain_support_01"><spring:message code="svm.header.input_field_required"/></div>
</div>

<div class="table_write table_write_support_01" id="etcEvntDiv">
	<ul class="add_row" style="display:block;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong>
							<spring:message code="svm.form.experience" /> <strong class="langText" > 1 </strong>
						</strong>
					</dt>
					
					<dd class="cell_merge merge_add">
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<input type="checkbox" id="etc_exp_use_yn" class="checkbox_02 etc_exp_use_yn" name="use_yn" value="Y" checked><label for="etc_exp_use_yn"><span></span></label>
								</strong>
							</dd>
						</dl>
						
						<!-- ▼Experience 1 checked 시-->
						<div style="display:block;" class="etcDtlView">
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 55px 0 0px;"><spring:message code="svm.header.level" /><span class="must_01"></span></span>
										<select class="select_01" style="width:500px" title="" id="etc_level_cd" name="level_cd">
										</select>
										<input type="hidden" name="hid_etc_level_cd">
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 47px 0 0px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
										<input type="text" id="name_txt" name="name_txt" class="input_01" style="width:500px;" value="" maxlength="100" onkeyup="fnEnterName(this);">
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.description" /><span class="must_01"></span></span>
										<textarea class="textarea_01" title="${description_prop}" style="width:760px; height:80px; vertical-align:middle;" id="etc_desc" name="description" placeholder="" onkeyup="fnMaxLength(this,4000);"></textarea>
										
									</strong>
								</dd>
							</dl>
						</div>
						<!-- ▲Experience 1 checked 시-->
						
					</dd>
				</dl>
			</div>
		</li>
	</ul>
	
	<ul class="add_row" style="display:block;">
		<li>
			<div>
				<dl>
					<dt class="cell_01" style="width:278px;">
						<strong>
							<spring:message code="svm.form.experience" /> <strong class="langText" > 2 </strong>
						</strong>
					</dt>
					
					<dd class="cell_merge merge_add">
						<dl>
							<dt style="display:none;"></dt>
							<dd >
								<strong>
									<input type="checkbox" id="etc_exp_use_yn2" class="checkbox_02 etc_exp_use_yn" name="use_yn" value="Y"><label for="etc_exp_use_yn2"><span></span></label>
								</strong>
							</dd>
						</dl>
						
						<!-- ▼Experience 2 checked 시-->
						<div style="display:none;" class="etcDtlView">
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 55px 0 0px;"><spring:message code="svm.header.level" /><span class="must_01"></span></span>
										<select class="select_01" style="width:500px" title="" id="etc_level_cd2" name="level_cd" >
										</select>
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 47px 0 0px;"><spring:message code="svm.header.name" /><span class="must_01"></span></span>
										<input type="text" class="input_01" name="name_txt" style="width:500px;" value="" maxlength="100" onkeyup="fnEnterName(this);" >
									</strong>
								</dd>
							</dl>
							<dl>
								<dt style="display:none;"></dt>
								<dd >
									<strong>
										<span class="txt_01" style="padding:0 8px 0 0px;"><spring:message code="svm.header.description" /><span class="must_01"></span></span>
										<textarea class="textarea_01" id="etc_desc2" style="width:760px; height:80px; vertical-align:middle;" name="description" title="${description_prop}" onkeyup="fnMaxLength(this,4000);" placeholder="" ></textarea>
									</strong>
								</dd>
							</dl>
						</div>
						<!-- ▲Experience 2 checked 시-->
						
					</dd>
				</dl>
			</div>
		</li>
	</ul>	

</div>

<!-- <div style="border-top:1px solid #363636; position:relative; top:-1px;"></div> -->




<div class="btn_area_01" style="margin:10px 0 0px 0;">
	<div class="btn_right">
		<a onclick='drawHtml("etcEvntDiv");' class="btn_round_add_001"><spring:message code="svm.button.add_more" /></a>
	</div>
</div>

<!--▲table_write-->



<div class="btn_area_01 btn_support_01" style="margin:30px 0 10px 0;">
	<div class="btn_center">
		<a class="btn_01 prev_icon" id="btn_pre" onClick="btnPre('${svmVolVo.regi_no}');"><spring:message code="svm.button.previous" /></a>
		<a class="btn_02" id="btn_save" onclick="btnSave('${svmVolVo.regi_no}');"><spring:message code="svm.button.save" /></a>
		<a class="btn_03 next_icon" id="btn_next" onClick="btnNext('${svmVolVo.regi_no}');"><spring:message code="svm.button.next" /></a>
	</div>
</div>
<hr>
</form:form>
<!-- ▲contents▲ -->
			
		</div>

<script>
	$(document).ready(function(){
		
		init();
				
		// 화면 상태
		chkUserStatus();
		// 버튼 이벤트
		btnEvent();
		// 해당 form 필수값 및 유효성 체크
		bindEventHandler();
	
		formSetting();
		radioStyle();
	});
	
	function chkUserStatus(){
		var frm = document.svmVolvo;
		if("${isRegistered}" == "true") alert("true");
	};
	
	function init(){
		
		countChar($("#avail_work_desc"),'counter',4000);
		

		var result = ${svmVolVo.result};
		langOptList = result.LANG_CD;
		
		Check({
			data		: result,
			code_find	: 'AVAIL_LOCATION_CD',
			name		: 'avail_location_cd', 
			selectCond	: 'avail_location_cd', 
			blankCond	: '',
			area		: 'avail_location_cd', 
			styleClass	: 'checkbox_01'
		});
		
		Combo({
			data		: result,
			code_find	: 'AVAIL_WORK_CD',
			name		: 'avail_work_cd', 
			selectCond	: 'hid_avail_work_cd', 
			blankCond	: 'Select an option'
		}); 
		
		Combo({
			data		: result,
			code_find	: 'LANG_CD',
			name		: 'skill_cd', 
			selectCond	: 'hid_skill_cd', 
			blankCond	: 'Select an option'
		}); 
		
		Combo({
			data		: result,
			code_find	: 'LANG_LVL_CD',
			name		: 'level_cd', 
			selectCond	: 'hid_level_cd', 
			blankCond	: 'Select an option'
		}); 
		
		Combo1({
			data		: result,
			code_find	: 'SPORT_EXP_LVL',
			id			: 'sport_level_cd', 
			selectCond	: 'hid_sport_level_cd', 
			blankCond	: 'Select an option'
		}); 
// 		Combo1({
// 			data		: result,
// 			code_find	: 'SPORT_EXP_NM',
// 			id			: 'name_cd', 
// 			selectCond	: 'hid_sport_nm_cd', 
// 			blankCond	: 'Select an option'
// 		}); 
		Combo1({
			data		: result,
			code_find	: 'ETC_EXP_LVL',
			id			: 'etc_level_cd', 
			selectCond	: 'hid_etc_level_cd', 
			blankCond	: 'Select an option'
		}); 
		
		
	};
		
	var areaList = new Array();
	function formSetting(){
		<c:forEach items="${svmVolVo.areaList}" var="info">
			var json = new Object();
			json.area = "${info.area}".trim();
			json.check_cd = "${info.check_cd}".trim(); 
			json.use_yn = "${info.use_yn}".trim(); 
			json.skill_cd = "${info.skill_cd}".trim(); 
			json.level_cd = "${info.level_cd}".trim(); 
			json.name_txt = "${info.name_txt}".trim(); 
			json.duration = "${info.duration}".trim(); 
			json.name_cd = "${info.name_cd}".trim(); 
			json.certi_nm = "${info.certi_nm}".trim(); 
			json.certi_fg = "${info.certi_fg}".trim(); 
			json.description = "${info.description}"; 
			areaList.push(json);
		</c:forEach>
		
		var lc  = 0;
		var ls  = 0;
		var see = 0;
		var oee = 0;
		var as  = 0;
		
		var desc = '';
		for(var i=0; i<areaList.length; i++){
			var selector = "";
			if(areaList[i].area == 'lc'){
				$("[type=checkbox][name=avail_location_cd][value=" + areaList[i].check_cd + "]").prop('checked',true);
			} 
			if(areaList[i].area == 'ls'){
				selector = $("#langSkillDiv").children(":eq(" + ls + ")");
				if(areaList[i].use_yn == 'Y'){
					if(!selector.find('[name=use_yn]').is(":checked")) selector.find('[name=use_yn]').trigger('click');
					//if(!selector.find('[type=text][name^=lang_name_txt]').val().trim() == "") selector.find('.lang_nm_div').show();
					if(areaList[i].skill_cd == "99") selector.find('.lang_nm_div').show();
				}
				selector.find("select[name^=skill_cd]").val(areaList[i].skill_cd).end()
						.find("select[name^=level_cd]").val(areaList[i].level_cd).end()
						.find('[type=text][name^=lang_name_txt]').val(areaList[i].name_txt).end();
				ls++;
			} 
			if(areaList[i].area == 'as'){
				selector = $("#addSkillDiv").children(":eq(" + as + ")");
				if(areaList[i].use_yn == 'Y'){
					if(!selector.find('[name=use_yn]').is(":checked")) selector.find('[name=use_yn]').trigger('click');
				}
				desc = areaList[i].description.replace(/\&lt\;br\/&gt\;|\<br\/>/g,'\n');
				selector.find("[name^=name_txt]").val(areaList[i].name_txt).end()
						.find('label[for^=add_skill_file]').text(areaList[i].certi_nm).end()
						.find('[name^=certi_fg]').val(areaList[i].certi_fg).end()
						//.find("[name^=description]").val(areaList[i].description).end();
						.find("[name^=description]").val(desc).end();
				as++;
				desc = '';
			}
			if(areaList[i].area == 'see'){
				if(see >= 2){
					drawHtml("sportEvntDiv");
				}
				
				selector = $("#sportEvntDiv").children(":eq(" + see + ")");
				if(areaList[i].use_yn == 'Y'){
					if(!selector.find('[name=use_yn]').is(":checked")) selector.find('[name=use_yn]').trigger('click');
				}
				desc = areaList[i].description.replace(/\&lt\;br\/&gt\;|\<br\/>/g,'\n').replace(/&#x27;/gi,'\'').replace(/&lt;/gi,'<').replace(/&gt;/gi,'>').replace(/&quot;/gi,'\"');
				selector.find("[name^=level_cd]").val(areaList[i].level_cd).end()
						.find("[name^=hid_name_cd]").val(areaList[i].name_cd).end()
						//.find("[name^=name_cd]").val(areaList[i].name_cd).end()
						.find("[name^=duration]").val(areaList[i].duration).end()
						.find("[name^=description]").val(desc).end();
						//.find("[name^=description]").val(areaList[i].description).end();
				
				changeExperience(selector.find("[name^=level_cd]"),areaList[i].name_cd,selector.find("[name^=name_cd]").prop('id'));

				see++;
			}
			if(areaList[i].area == 'oee'){
				if(oee >= 2){
					drawHtml("etcEvntDiv");
				}
				
				selector = $("#etcEvntDiv").children(":eq(" + oee + ")");
				if(areaList[i].use_yn == 'Y'){
					if(!selector.find('[name=use_yn]').is(":checked")) selector.find('[name=use_yn]').trigger('click');
				}else{
					if(selector.find('[name=use_yn]').is(":checked")) selector.find('[name=use_yn]').trigger('click');					
				}
				desc = areaList[i].description.replace(/\&lt\;br\/&gt\;|\<br\/>/g,'\n');
				selector.find("[name^=level_cd]").val(areaList[i].level_cd).end()
						.find("[name^=name_txt]").val(areaList[i].name_txt).end()
						.find("[name^=description]").val(desc).end();
						//.find("[name^=description]").val(areaList[i].description).end();
				oee++;
			}
			
		}
		
		if( see == 0 ) $("#sportEvntDiv").children(":eq(" + see + ")").find('[name=use_yn]').trigger('click');
		if( oee == 0 ) $("#etcEvntDiv").children(":eq(" + oee + ")").find('[name=use_yn]').trigger('click');
		if( as == 0 ) $("#addSkillDiv").children(":eq(" + as + ")").find('[name=use_yn]').trigger('click');
		if( ls == 0 ) $("#langSkillDiv").children(":eq(" + ls + ")").find('[name=use_yn]').trigger('click');
		
		$("#avail_work_cd").val("<c:out value='${svmVolVo.avail_work_cd}'/>".trim());

		countChar($("#avail_work_desc"),'counter',4000);
		
		if($('input[name=avail_location_cd][value="<c:out value="${svmVolVo.avail_location_cd}"/>"]').size()!=0)
			$('input[name=avail_location_cd][value="<c:out value="${svmVolVo.avail_location_cd}"/>"]').prop('checked',true).trigger('change');
		
		
		
// 		var frm = document.svmVolVo;
		
// 		if("<c:out value='${svmVolVo.university_lvl_yn}'/>".trim() == 'Y')
// 			$("#university_lvl_yn").prop('checked',true).trigger('change');
		
// 		if($("#university_lvl_yn").is(":checked")){
// 			$("#hid_university_lvl_yn").prop('disabled',true);
// 			$("#university_lvl_yn").prop('name','university_lvl_yn');
// 			//$("#university_lvl_yn").prop('checked',false);
			
// 		}else{
// 			$("#hid_university_lvl_yn").prop('disabled',false);
// 			$("#university_lvl_yn").prop('name','');
// 			//$("#university_lvl_yn").prop('checked',true);
// 		}
		
	};
	
	function funDrawCal(){
		$("#dateOfBirth_day option:first").text("Date");
		$("#dateOfBirth_month option:first").text("Month");
		$("#dateOfBirth_year option:first").text("Year");
		
		$("#dateOfBirth_day,#dateOfBirth_month,#dateOfBirth_year").find('option:eq(0)').hide();
	};
	
// 	function funSetCommonCode(){
// 		createDateSelectBox('dateOfBirth',-10);
// 	}
	
	var langOptList = new Array();
	function btnEvent(){
		
		/** LANGUAGE SKILL FIELD **/	
		$(".lang_use_yn").on('click',function(){			
			if(this.checked == false){
				$(this).closest("dd").find('.langSkillView').hide();
				$(this).closest("dd").find('.langSkillView').find('.lang_nm_div').hide();
				$(this).closest("dd").find('.langSkillView').find('input[type=text]').val('');
				$(this).closest("dd").find('.langSkillView').find('select').each(function(){
				$(this).val($(this).find("option:eq(0)").val()).trigger('change');
				});
			}else{
				$(this).closest("dd").find('.langSkillView').show();
			}
		});
		
		/** ADD SKILL FIELD **/
		$(".add_use_yn").on('click',function(){
			if(this.checked == false){
				createHidden($(this).closest(".merge_add").find('.addSkillView').find('[name=certi_fg]').val());
				$(this).closest(".merge_add").find('.addSkillView').hide();
				$(this).closest(".merge_add").find('.addSkillView').find('input[type=text],textarea').val('');
				$(this).closest(".merge_add").find('.addSkillView').find('input[type=file]').val('').next('label').text('');
			}
			else{
				$(this).closest(".merge_add").find('.addSkillView').show();
				//deleteHidden($(this).closest(".merge_add").find('.addSkillView').find('[name=certi_fg]').val());
			}
		});
		
		/** SPORT EVENT EXPERIENCE FIELD **/
		$(".sport_exp_use_yn").on('click',function(){
			if(this.checked == false){
				$(this).closest(".merge_add").find('.sportDtlView').hide();
				$(this).closest(".merge_add").find('.sportDtlView').find('input[type=text],textarea').val('');
				$(this).closest(".merge_add").find('.sportDtlView').find('select').each(function(){
					$(this).val($(this).find("option:eq(0)").val()).trigger('change');
				});
			}
			else{
				$(this).closest(".merge_add").find('.sportDtlView').show();
			}
		});
		
		/** OTHER EVENT EXPERIENCE FIELD **/
		$(".etc_exp_use_yn").on('click',function(){
			if(this.checked == false){
				$(this).closest(".merge_add").find('.etcDtlView').hide();
				$(this).closest(".merge_add").find('.etcDtlView').find('input[type=text],textarea').val('');
				$(this).closest(".merge_add").find('.etcDtlView').find('select').each(function(){
					$(this).val($(this).find("option:eq(0)").val()).trigger('change');
				});
			}
			else{
				$(this).closest(".merge_add").find('.etcDtlView').show();
			}
		});
		
	}
	
	function removeHtml(divId,chkDiv){
		var total = chkDiv.parent().children().length;
		
		switch (divId) {
		case "langSkillDiv"  :
								$("#"+divId).children().each(function(i){
									if(chkDiv[0] == this){
										console.log('find!') ;
										chkDiv.remove();  
										for( var k=i; k < total; k++){
											$("#"+divId).children().children().eq(k).find('.langText').text((k*1+1)).end()
											.find('[id^=skill_cd]').prop("id","skill_cd"+(k*1+1)).end()
											.find('[id^=level_cd]').prop("id","level_cd"+(k*1+1)).end()
											//.find('.langSkillView').hide().end()
											.find(":checkbox").prop("id","lang_use_yn"+(k*1+1)).end()
											.find("label").prop('for',"lang_use_yn"+(k*1+1)).end();
										}
									}
								})
								break;
		case "addSkillDiv"  :
								$("#"+divId).children().each(function(i){
									if(chkDiv[0] == this){
										console.log('find!') ;
										chkDiv.remove();  
										for( var k=i; k < total; k++){
											$("#"+divId).children().children().eq(k).find('.langText').text((k*1+1)).end()
									    	 .find(":checkbox").prop("id","add_use_yn"+(k*1+1)).end()
									    	 .find("label").not("[title=Upload]").prop('for',"add_use_yn"+(k*1+1)).end().end()
									    	 .find('.addFileDiv')
									    	 .replaceWith(fileDiv.children().clone(true).find('label').prop('for','add_skill_file'+(k*1+1)).end()
									    												.find('input[type=file]').prop("id","add_skill_file"+(k*1+1)).end()
									    												).end();
										}
									}
								})
								break;
		case "sportEvntDiv"  :
								$("#"+divId).children().each(function(i){
									if(chkDiv[0] == this){
										console.log('find!') ;
										chkDiv.remove();  
										for( var k=i; k < total; k++){
											$("#"+divId).children().children().eq(k).find('.langText').text((k*1+1)).end()
									    	 .find('[id^=name_cd]').prop("id","name_cd"+(k*1+1)).end()
											 .find('[id^=sport_level_cd]').prop("id","sport_level_cd"+(k*1+1)).end()
									    	 .find("input[type=text]").prop("id","duration"+(k*1+1)).end()
									    	 .find('textarea').prop("id","sport_desc"+(k*1+1)).end()
									    	 .find(":checkbox").prop("id","sport_exp_use_yn"+(k*1+1)).end()
									    	 .find("label").prop('for',"sport_exp_use_yn"+(k*1+1)).end();
										}
									}
								})
								break;
		case "etcEvntDiv"  :
								$("#"+divId).children().each(function(i){
									if(chkDiv[0] == this){
										console.log('find!') ;
										chkDiv.remove();  
										for( var k=i; k < total; k++){
											$("#"+divId).children().children().eq(k).find('.langText').text((k*1+1)).end()
									    	 .find('[id^=etc_level_cd]').prop("id","etc_level_cd"+(k*1+1)).end()
											 .find('[id^=name_txt]').prop("id","name_txt"+(k*1+1)).end()
											 .find('textarea').prop("id","etc_desc"+(k*1+1)).end()
									    	 .find(":checkbox").prop("id","etc_exp_use_yn"+(k*1+1)).end()
									    	 .find("label").prop('for',"etc_exp_use_yn"+(k*1+1)).end();
										}
									}
								})
								break;
		default   : break;
		}
			
	}
	
	var fileDiv = $("#fileDiv");
	function drawHtml(divId){
		var strHtml = "";
		var currLen = $("#"+divId).children().length;
		var nextLen = $("#"+divId).children().length + 1;
		//var nextLen = parseInt($('input[id^="lang_use_yn"]:last').prop("id").match(/\d+/g),10) + 1
		var clone = $("#"+divId).children(":eq(0)").clone(true); 
		switch (divId) {
			case "langSkillDiv"  :
								    clone.find('.langText').text(nextLen).end()
								    	 .find('.langSkillView').hide().end()
								    	 .find('[id^=skill_cd]').prop("id","skill_cd"+nextLen).end()
										 .find('[id^=level_cd]').prop("id","level_cd"+nextLen).end()
								    	 .find("select").val("").end()
								    	 .find(":checkbox").attr("checked", false).prop("id","lang_use_yn"+nextLen).end()
								    	 .find("label").prop('for',"lang_use_yn"+nextLen).end();
								    
									break;
			case "addSkillDiv"  :
								    clone.find('.langText').text(nextLen).end()
								    	 .find('.addSkillView').hide().end()
								    	 .find('input[type=text]').val("").end()
								    	 .find('textarea').val('').end()
								    	 .find(":checkbox").attr("checked", false).prop("id","add_use_yn"+nextLen).end()
								    	 .find("label").not("[title=Upload]").prop('for',"add_use_yn"+nextLen).end().end()
								    	 .find('.addFileDiv').replaceWith(fileDiv.clone(true).children().find('label').prop('for','add_skill_file'+nextLen).end()
								    																	.find('input[type=file]').prop("id","add_skill_file"+nextLen).end() 
								    																	.find('input[type=file]').prop("name","skillPhoto").end() 
								    																	.find('input[type=file]').prop("disabled",true).end() 
								    																	).end();
								    
									break;
			case "sportEvntDiv"  :
								    clone.find('.langText').text(nextLen).end()
								    	 .find('.sportDtlView').hide().end()
								    	 .find('[id^=name_cd]').prop("id","name_cd"+nextLen).val('').end()
										 .find('[id^=sport_level_cd]').prop("id","sport_level_cd"+nextLen).val('').end()
								    	 .find("select").val("").end()
								    	 .find("input[type=text]").val("").prop("id","duration"+nextLen).end()
								    	 .find('textarea').val('').prop("id","sport_desc"+nextLen).end()
								    	 .find(":checkbox").attr("checked", false).prop("id","sport_exp_use_yn"+nextLen).end()
								    	 .find("label").prop('for',"sport_exp_use_yn"+nextLen).end();
								    
									break;
			case "etcEvntDiv"  :
								    clone.find('.langText').text(nextLen).end()
								    	 .find('.etcDtlView').hide().end()
								    	 .find('[id^=etc_level_cd]').prop("id","etc_level_cd"+nextLen).end()
										 .find('[id^=name_txt]').prop("id","name_txt"+nextLen).val('').end()
										 .find('textarea').prop("id","etc_desc"+nextLen).val('').end()
								    	 .find("select").val("").end()
								    	 .find(":checkbox").attr("checked", false).prop("id","etc_exp_use_yn"+nextLen).end()
								    	 .find("label").prop('for',"etc_exp_use_yn"+nextLen).end();
								    
									break;
			default   : break;
		}
 		$("#"+divId).append(clone);
// 		btnEvent();
	}
	
	
	function contentVisible(selector){				
		switch (selector.name) {
			case "occu_or_univ_cd"  :
										$(".occuOrUviView").hide().find('.occu_or_univ_nm').prop('name','');
									    if(selector.value == "G") $("#generalView").show().find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
									    else if(selector.value == "U") $("#universityView").show().find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
									    else if(selector.value == "H") $("#highschoolView").show().find('.occu_or_univ_nm').prop('name','occu_or_univ_nm');
									    console.log(selector);
										break;
			default   : break;
		}
	}
	
	
	
	// 해당 form 필수값 및 유효성 체크
	function bindEventHandler(flag) {
			
		if(flag == "signIn"){
			//TODO : 중복검사 추가해야함  
			$('#svmVolvo').validate({
				onfocusout: false,
				rules: {
					id		: { required: true },
					pw		: { required: true }
				}, messages: {
					id: {
						required	:  '<spring:message code="login.empty.id" />',
					},
					pw: {
						required	:  '<spring:message code="login.empty.password" />',
						minlength	:  10
					}
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
		} else {
			// custom validation 정의
		 	$.validator.addMethod(
			        'email', function (value, element) {
			        	var isValid = false;
			        	if(verifyemail(value)){
			        		isValid = true;
			        	}
			        	return isValid;
			        	
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="svm.info.msg.enter_correctly_email"/>'
			 );
			$.validator.addMethod(
			        'isCorrectPassword', function (value, element) {
			        	var isValid = false;
			        	if(value.length > 10) isValid = true;
//	 		        	alert('isCorrectPassword : ' + isValid);
			        	return isValid;
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="sys.user.message.input_password_type"/>'
			 );
			$.validator.addMethod(
			        'isConfirmPassword', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return value == $("#regist_password").val();
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="sys.user.message.mismatch_password"/>'
			 );
			$.validator.addMethod(
			        'isSelectDate', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return "" != value;
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="svm.message.msg_select_date"/>'
			 );
			$.validator.addMethod(
			        'isSelectMonth', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return "" != value;
			            //return (value.substring(0, 1) == 0) ? true : false;
			        }, '<spring:message code="svm.message.msg_select_month"/>'
			 );
			$.validator.addMethod(
			        'isSelectYear', function (value, element) {
			        	var isValid = false;
//	 		        	alert('confirm_password validateion! : '  + isValid);
						return "" != value;
			            //return (value.substring(0, 1) == 0) ? true : false;
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
		
		//console.log(label_style);
		if(label_style == undefined){
			label_style = '';
		}
		if(title_name == undefined){
			title_name = '';
		}
		$(this).next('label').replaceWith('<label for=' + id_name + ' style="'+ label_style +'" title="'+ title_name +'"><span></span>' + label_name + '</label>');
	});
}

//close
function funClose() {
	var frm = document.svmVolVo;
	var url = '<%=contextLangPath%>/svm/application/list';
	frm.cmd.value = 'list';
	location.href = getQueryStringUrl(frm, url);
}
 
var ncount = 0;
var fileCnt = 0;
function btnSave(regi_no){
	if (!confirm('<spring:message code="svm.info.msg.is_save_application"/>')){
		return false;	// 종료
	}	
	
	if(!validateGameInfo()) return false;
	
	ncount = 0;
	fileCnt = 0;
	var frm = document.svmVolVo;
	
	$(frm).find('[type=file]').each(function(){
		if($(this).val() == ""){
			$(this).prop('disabled',true); 
			$(this).prop('name',''); 
			$(this).prop('id',''); 
		}
	});
	
	$("[id^=avail_location_cd]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("lc"));
		$(this).prop('name','areaList[' + ncount + '].check_cd');
						   
		ncount++;
	});
	$("[id^=lang_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("ls"));
		$(this).closest('div').find('[name^=skill_cd]').prop('name','areaList[' + ncount + '].skill_cd').end()
						   .find('[name^=level_cd]').prop('name','areaList[' + ncount + '].level_cd').end()
						   .find('[name^=lang_name_txt]').prop('name','areaList[' + ncount + '].name_txt').end();
		ncount++;
	});
	
	$("[id^=add_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("as"));
		//var file_nm = $(this).closest('div').find('[type=file]').val().split('\\').pop();
		var file_nm = $(this).closest('div').find('[type=file]').next('label').text();
		$(this).closest('div').find('[type=file]').prop('name','skillPhoto[' + fileCnt + ']').end()
 		//$(this).closest('div').find('[type=file]').prop('name','skillPhoto').end()
							  .find('[name^=name_txt]').prop('name','areaList[' + ncount + '].name_txt').end()
							  .find('[name^=certi_nm]').val(file_nm).end()
							  .find('[name^=certi_nm]').prop('name','areaList[' + ncount + '].certi_nm').end()
							  .find('[name^=description]').prop('name','areaList[' + ncount + '].description').end();
							  // upload certificates 추가
		fileCnt++;
	    ncount++;
	});

	$("[id^=sport_exp_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("see"));
		$(this).closest('div').find('[id^=sport_level_cd]').prop('name','areaList[' + ncount + '].level_cd').end()
							  .find('[id^=name_cd]').prop('name','areaList[' + ncount + '].name_cd').end()
							  .find('[id^=duration]').prop('name','areaList[' + ncount + '].duration').end()
							  .find('[id^=sport_desc]').prop('name','areaList[' + ncount + '].description').end();
		ncount++;
	});
	
	$("[id^=etc_exp_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("oee"));
		$(this).closest('div').find('[id^=etc_level_cd]').prop('name','areaList[' + ncount + '].level_cd').end()
							  .find('[name=name_txt]').prop('name','areaList[' + ncount + '].name_txt').end()
							  .find('[id^=etc_desc]').prop('name','areaList[' + ncount + '].description').end();
		ncount++;
	});
	
	if($('#avail_work_desc').val().trim() == ""){
			$("#avail_work_desc").val(" ");	    		
	}
	if($("#avail_work_cd").val() == "" ) {
		$("#avail_work_cd").replaceWith('<input type="text" name="' + $("#avail_work_cd")[0].name + '" id="' + $("#avail_work_cd")[0].id + '" value=" ">');
	}
	
	textAreaRestrict();	
	frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/update';
	frm.moveTo.value = 'save'
	frm.save_tab_cd.value = 'gameInfo'
	$("#btn_save").attr('onclick','javascript:;');
	$("#btn_next").attr('onclick','javascript:;');
	frm.submit();
}

function btnPre(regi_no){
	var frm = document.svmVolVo;
	frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/previous';
	frm.moveTo.value = 'pre'
	frm.save_tab_cd.value = 'gameInfo'
	$("#btn_save").attr('onclick','javascript:;');
	$("#btn_next").attr('onclick','javascript:;');
	frm.submit();
}

function btnNext(regi_no){
		
	if (!confirm('<spring:message code="svm.info.msg.is_save_application"/>')){
		return false;	// 종료
	}	
	
	if(!validateGameInfo()) return false;
	
	ncount = 0;
	fileCnt = 0;
	var frm = document.svmVolVo;
	
	$(frm).find('[type=file]').each(function(){
		if($(this).val() == ""){
			$(this).prop('disabled',true); 
			$(this).prop('name',''); 
			$(this).prop('id',''); 
		}
	});
	
	$("[id^=avail_location_cd]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("lc"));
		$(this).prop('name','areaList[' + ncount + '].check_cd');
						   
		ncount++;
	});
	$("[id^=lang_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("ls"));
		$(this).closest('div').find('[name^=skill_cd]').prop('name','areaList[' + ncount + '].skill_cd').end()
						   .find('[name^=level_cd]').prop('name','areaList[' + ncount + '].level_cd').end()
						   .find('[name^=lang_name_txt]').prop('name','areaList[' + ncount + '].name_txt').end();
		ncount++;
	});
	
	$("[id^=add_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("as"));
		//var file_nm = $(this).closest('div').find('[type=file]').val().split('\\').pop();
		var file_nm = $(this).closest('div').find('[type=file]').next('label').text();
		$(this).closest('div').find('[type=file]').prop('name','skillPhoto[' + fileCnt + ']').end()
 		//$(this).closest('div').find('[type=file]').prop('name','skillPhoto').end()
							  .find('[name^=name_txt]').prop('name','areaList[' + ncount + '].name_txt').end()
							  .find('[name^=certi_nm]').val(file_nm).end()
							  .find('[name^=certi_nm]').prop('name','areaList[' + ncount + '].certi_nm').end()
							  .find('[name^=description]').prop('name','areaList[' + ncount + '].description').end();
							  // upload certificates 추가
		fileCnt++;
	    ncount++;
	});

	$("[id^=sport_exp_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("see"));
		$(this).closest('div').find('[id^=sport_level_cd]').prop('name','areaList[' + ncount + '].level_cd').end()
							  .find('[id^=name_cd]').prop('name','areaList[' + ncount + '].name_cd').end()
							  .find('[id^=duration]').prop('name','areaList[' + ncount + '].duration').end()
							  .find('[id^=sport_desc]').prop('name','areaList[' + ncount + '].description').end();
		ncount++;
	});
	
	$("[id^=etc_exp_use_yn]:checked").each(function(i){
		this.name = "areaList[" + ncount + "].use_yn";
		this.value = 'Y';
		$(this).append($("#hid_clone").clone().prop("name","areaList[" + ncount + "].area").val("oee"));
		$(this).closest('div').find('[id^=etc_level_cd]').prop('name','areaList[' + ncount + '].level_cd').end()
							  .find('[name=name_txt]').prop('name','areaList[' + ncount + '].name_txt').end()
							  .find('[id^=etc_desc]').prop('name','areaList[' + ncount + '].description').end();
		ncount++;
	});
	
	if($('#avail_work_desc').val().trim() == ""){
			$("#avail_work_desc").val(" ");	    		
	}
	if($("#avail_work_cd").val() == "" ) {
		$("#avail_work_cd").replaceWith('<input type="text" name="' + $("#avail_work_cd")[0].name + '" id="' + $("#avail_work_cd")[0].id + '" value=" ">');
	}

	textAreaRestrict();
	frm.action = '<%=contextLangPath%>/svm/application/applicationRegister/update';
	frm.moveTo.value = 'next';
	frm.save_tab_cd.value = 'gameInfo';
	$("#btn_save").attr('onclick','javascript:;');
	$("#btn_next").attr('onclick','javascript:;');
	frm.submit();
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
  			ad_no	: frm.ad_no.value,
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

function validateGameInfo(){
	// custom validation 정의
	var isValid = true;
	var selObj = '';
	var msg= '';
	if($("[name=avail_location_cd]:checked").length == 0 ){
		alert('<spring:message code="svm.message.no_select_location"/>');
		$("#selLocDivArea").attr('tabIndex','-1');
		$("#selLocDivArea").focus();
		setTimeout(function(){
			$("#selLocDivArea").removeAttr('tabIndex');
		},1500);
		return false;
	}
	
	$("[id^=lang_use_yn]:checked").each(function(){
		console.log($(this).closest('div').find('.langSkillView'));
		$(this).closest('div').find('.langSkillView')
						      .find('select,input[type=text]').each(function(){
						      if($(this).val().trim() == ""){
						    	  	if(($(this).prop('name') == 'lang_name_txt' && $(this).parent('output').parent().find('[name^=skill_cd]').val() != "99") ){
						    	  		if($(this).val() == ""){
						    	  			//do Nothing
						    	  		}
						    	  	}else{
							    		msg = '<spring:message code="svm.info.msg.enter_mandatory"/>';
							    		$(this).get(0).focus();
							    		isValid = false;
							    		return false;
						    	  	}
						      }
						   });
		return isValid;
	})
	
	if(msg != ''){
		alert(msg);
	}
	if(isValid == false) return false;
	
	if( $('[name=skill_cd]:eq(0)').val() != "99" && ($('[name=skill_cd]:eq(0)').val() == $('[id=lang_use_yn2]:checked').closest('div').find('[name=skill_cd]').val()) ){
		alert('<spring:message code="svm.message.lang_skill_duplicate"/>');
		$('[name=skill_cd]:eq(1)').get(0).focus();
		return false;
	}
	// ADDITIONAL SKILL
	$("[id^=add_use_yn]:checked").each(function(){
		console.log($(this).closest('div').find('.addSkillView'));
		$(this).closest('div').find('.addSkillView')
						      .find('input[type=file]').each(function(){
						    	if($(this).val().trim() == ""){
						    		if( $(this).next('label').text().trim() == "" ) {
							    		msg = '<spring:message code="svm.message.no_upload_certifi"/>';
							    		$(this).get(0).focus();
							    		isValid = false;
							    		return false;
									}
						    	}
					    		if( !validationUpload($(this))) {
					    			$(this).get(0).focus();
					    			isValid = false;
									return false;
								}
						      }).end()
							  .find('select,input[type=text],textarea').each(function(){
						    	if($(this).val().trim() == ""){
						    		msg = '<spring:message code="svm.info.msg.enter_mandatory"/>';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}else if($(this).prop('type') == 'textarea' && $(this).val().length > 4000 ){
						    		msg = '<spring:message code="svm.header.additional_skill"/>' + ' <spring:message code="svm.header.description"/>' + ' <spring:message code="svm.message.over_length" arguments="4000 character limit" />';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}
						      })
	})
    if(msg != ''){
		alert(msg);
		return false;
	}
    if(!isValid){
		return false;
	}
	
	//SPORT EVENT EXPERIENCE
	$("[id^=sport_exp_use_yn]:checked").each(function(){
		console.log($(this).closest('div').find('.sportDtlView'));
		$(this).closest('div').find('.sportDtlView')
							  .find('select,input[type=text],textarea').each(function(){
						    	if($(this).val().trim() == "" || $(this).val().trim() == null ){
						    		console.log($(this)[0]);
						    		msg = '<spring:message code="svm.info.msg.enter_mandatory"/>';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}else if($(this).prop('type') == 'textarea' && $(this).val().length > 4000 ){
						    		msg = '<spring:message code="svm.header.sport_event_experience"/>' + ' <spring:message code="svm.header.description"/>' + ' <spring:message code="svm.message.over_length" arguments="4000 character limit"/>';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}else if($(this).prop('type') == 'text' && $(this).val().length > 200 ){
						    		msg = '<spring:message code="svm.header.sport_event_experience"/>' + ' <spring:message code="svm.form.duration"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}
						      })
	})
    if(msg != ''){
		alert(msg);
		return false;
	}
	
	//OTHER EVENT EXPERIENCE
	$("[id^=etc_exp_use_yn]:checked").each(function(){
		console.log($(this).closest('div').find('.etcDtlView'));
		$(this).closest('div').find('.etcDtlView')
							  .find('select,input[type=text],textarea').each(function(){
						    	if($(this).val().trim() == "" || $(this).val().trim() == null ){
						    		console.log($(this)[0]);
						    		msg = '<spring:message code="svm.info.msg.enter_mandatory"/>';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}else if($(this).prop('type') == 'textarea' && $(this).val().length > 4000 ){
						    		msg = '<spring:message code="svm.header.other_event_experience"/>' + ' <spring:message code="svm.header.description"/>' + ' <spring:message code="svm.message.over_length" arguments="4000 character limit"/>';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}else if($(this).prop('type') == 'text' && $(this).val().length > 200 ){
						    		msg = '<spring:message code="svm.header.other_event_experience"/>' + ' <spring:message code="svm.header.name"/>' + ' <spring:message code="svm.message.over_length" arguments=" "/>';
						    		$(this).get(0).focus();
						    		isValid = false;
						    		return false;
						    	}
						      })
	})
    if(msg != ''){
		alert(msg);
		return false;
	} 
	
	return isValid;
}


function validationUpload(obj){
	var isUploadValid = true;
	if($(obj)[0].files.length != 0){
		if($(obj)[0].files[0].size == 0){
			alert('<spring:message code="svm.message.check_file_size"/>');
			isUploadValid = false;
		}
		if($(obj)[0].files[0].size > 4000000){
			console.log("upload type : " + $(obj)[0].files[0].type);			
			alert('<spring:message code="svm.message.check_file_size"/>');
			isUploadValid = false;
		}
		if(!($(obj)[0].files[0].type == 'image/jpeg' || $(obj)[0].files[0].type == 'image/png')){
			alert('<spring:message code="message.alert.unsupport_file"/>');
			isUploadValid = false;
		}
	}
	return isUploadValid;
}

/*
 * 단일 콤보박스
 */ 
function Combo1(map){
	var data = map.data;
    var code_find = map.code_find;
	var id_ref = map.id;
	var selectCond_ref = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
//	data = convertJsonType(data);

    id_ref = $('select[id^='+id_ref+']');
    selectCond_ref = $('input[name='+selectCond_ref+']');
    
    id_ref.children('option').remove();
    
    var name;
    var selectCond;
    
    lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
    
    for(var k=0 ; selectCond_ref.length>k ; k++){
		if(selectCond_ref.length > 1){
			name = id_ref.eq(k);
			selectCond = selectCond_ref.eq(k);
		}else{
			name = id_ref;
			selectCond = selectCond_ref;
		}
		
	    if(undefined != blankCond && '' != blankCond){
	    	name.append("<option value=''>"+blankCond+"</option>");
	    }else if('' == blankCond){
	    	name.append("<option value=''></option>");
	    }
	    $.each(data[code_find], function(i, obj){
	    	if(lang.indexOf('ko') > -1){
				name.append("<option value='"+obj.MINOR_CD+"'>"+obj.CODE_NM2+"</option>");
			}else{
				name.append("<option value='"+obj.MINOR_CD+"'>"+obj.CODE_NM1+"</option>");
			}
	        
			if(selectCond.val() == obj.MINOR_CD){
				if(undefined != blankCond && null != blankCond){
					name.children('option').eq(i+1).prop('selected', 'selected');             
			    }else{
			    	name.children('option').eq(i).prop('selected', 'selected');
			    }
			}
	    });
    }
}

function textAreaRestrict(){
	$("textarea[name^=areaList]").each(function(){
 		$(this).val($(this).val().replace(/^\r\n|\n|\r/gm,'<br/>'));
		$(this).val($(this).val().substring(0, 4000));
	});
}

function fnMaxLength(obj,size){
	if(obj.value.length > size){ 
		alert('[' + obj.title + ']' + ' <spring:message code="svm.message.over_length" arguments="4000 character limit" />');
		obj.value = obj.value.substring(0,size);
	}
}

function fnLangChange(obj){
	var selObj = $(obj);
	if(selObj.val() == "99") selObj.parent().find('output').show();
	else selObj.parent().find('output').hide().find('input').val(' ');
}

function changeExperience(obj,nextVal,nextTargetId){
	console.log(obj[0]);
	var lvl_nm = obj[0].name;  
	var target_obj = "";
	var lvl_cd = obj[0].value;
	var resArry = "";
	var resObj = "";
	var optionsHtml = "";
	
	target_obj = obj.closest('div').find('[name^=name_cd]');
	
	if('' != lvl_cd){
		sendRequest({
	  		action: '/svm/changeExperience',
	  		params:{
	  			 flag 		  : nextVal 
	  			,nextTargetId : nextTargetId
	  			,code_value   : obj[0].value
	  		},
	  		callbackFunc:function(resData){
	  			if(resData.success){
	  				console.log(resData);
	  				resObj = JSON.parse(resData.result);
  					resArry = resObj.SPORT_EXP_NM;
  					
	  				if(resArry.length == 0 ){
	  					target_obj.prop('disabled',true);
	  					optionsHtml += '<option value=""></option>'
	  				}
	  				else{
	  					target_obj.prop('disabled',false);
	  					optionsHtml += '<option value="">Select an option</option>'
	  				}
	  				
	  				for(var i=0; i<resArry.length; i++){
	  					optionsHtml += '<option value="' + resArry[i].MINOR_CD + '">' + resArry[i].CODE_NM1 + '</option>' 
	  				}
	  				target_obj.children('option').remove();
	  				target_obj.append(optionsHtml);
	  				
	  				if(resData.name_cd != "" ){
	  					$("#"+resData.search_fg).val(nextVal);
	  				}
	  				
	  			}else {
	 				console.log(resData);
	  			}
	  		}
	  	});
	} else {
		// value == empty
		target_obj.children('option').remove();  target_obj.prop('disabled',true);
							  
	}
	
}

function createHidden(value){
	var o_hidden = document.createElement("input");
	o_hidden.type = "hidden";
	o_hidden.name = "del_photo_fg_arry";
	o_hidden.value = value;
	document.svmVolVo.appendChild(o_hidden);
}

function deleteHidden(value){
	var obj = $("[name=del_photo_fg_arry][value=" + value + "]");
	if(obj[0] != "undefined") obj.remove();
}

function fnEnterName(obj){
    var inputVal = $(obj).val();
	if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 ) return;
	$(obj).val($(obj).val().replace(/[0-9|(|)|\-|+|\]|\[|\{|}|<|>|?|~!@|`|\\|#$%^&*-=+_\'\"]/g,''));
}
</script>
