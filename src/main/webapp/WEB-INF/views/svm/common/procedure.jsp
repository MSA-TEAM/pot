<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="/js/common.js"></script>

<div class="contents_wrap_01 contents_support_01">
		<div class="contents_top">
			<div class="con_title"><spring:message code="svm.header.procedure"/></div>
			<ul class="con_location">
				<li><spring:message code="svm.title.home"/></li>
				<li><spring:message code="svm.header.procedure"/></li>
			</ul>
		</div>
		<div class="contents">

<c:if test="${lang != 'in' }">

<!-- ▼contents▼ -->

<div class="intro_title_01">Registration Procedure</div>




<div class="intro_explain_box_01" style=" margin-top:24px; padding-bottom:40px;">
	
	
	<ul class="intro_list_02">
		<li>
			<strong>01</strong>
			Registration<br>Online
		</li>
		<li>
			<strong>02</strong>
			Selection
		</li>
		<li>
			<strong>03</strong>
			Screening Document<br>(Accreditation)
		</li>
		<li>
			<strong>04</strong>
			Interview and Psychotest<br>(for those who pass<br>the screening)
		</li>
		<li>
			<strong>05</strong>
			Congrats You Be<br>a Volunteer!<br>Volunteer Placement
		</li>
	</ul>

	<div class="intro_list_03">
		<dl>
			<dt>01</dt>
			<dd>
				<strong>Registration Online</strong>
				Registration Volunteer is open to the public. One of the requirements: volunteers who wish to participate<br>
				in the 18th Asian Games Jakarta Palembang 2018 must be at least 18 years of age.
			</dd>
		</dl>
		<dl>
			<dt>02</dt>
			<dd>
				<strong>Selection</strong>
				The Applicants run the selection process by considering basic information and game information.<br> 
				The Applicants who pass the selection stage will be process through a screening document.
			</dd>
		</dl>
		<dl>
			<dt>03</dt>
			<dd>
				<strong>Screening Document</strong>
				Applicants applying will be processed at the accreditation department,<br>
				this process requires hard copy personal document attachments.
			</dd>
		</dl>
		<dl>
			<dt>04</dt>
			<dd>
				<strong>Interview and Psychotest</strong>
				Testing to determine analytical skills and personal traits. The tests include English tests, interviews,<br>
				and psychotest. Those who successfully pass will be enrolled in the volunteer programme.
			</dd>
		</dl>
		<dl>
			<dt>05</dt>
			<dd>
				<strong>Congrats You Be a Volunteer! Volunteer Placement</strong>
				Congrats you have become volunteer. Volunteers will be place<br>
				in the department according to selection and test.
			</dd>
		</dl>
	</div>




</div>



<!-- ▲contents▲ -->
</c:if>

<c:if test="${lang == 'in' }">
<!-- ▼contents▼ -->
	<div class="intro_title_01">Prosedur Registrasi</div>

<div class="intro_explain_box_01" style=" margin-top:24px; padding-bottom:40px;">
	
	
	<ul class="intro_list_02">
		<li>
			<strong>01</strong>
			Pendaftaran<br>Online
		</li>
		<li>
			<strong>02</strong>
			Penyeleksian<br>lewat sistem
		</li>
		<li>
			<strong>03</strong>
			Screening dokumen<br>(akreditasi)
		</li>
		<li>
			<strong>04</strong>
			Interview dan<br>Psikotest (bagi yang<br>lolos screening)
		</li>
		<li>
			<strong>05</strong>
			Selamat Anda Menjadi<br>Volunteer! dan<br>Penempatan<br>Volunteer
		</li>
	</ul>




	<div class="intro_list_03">
		<dl>
			<dt>01</dt>
			<dd>
				<strong>Pendaftaran Online</strong>
				Registration Volunteer is open to the public. One of the requirements: volunteers who wish to participate<br>
				in the 18th Asian Games Jakarta Palembang 2018 must be at least 18 years of age.
			</dd>
		</dl>
		<dl>
			<dt>02</dt>
			<dd>
				<strong>Penyeleksian lewat sistem</strong>
				The Applicants run the selection process by considering basic information and game information.<br> 
				The Applicants who pass the selection stage will be process through a screening document.
			</dd>
		</dl>
		<dl>
			<dt>03</dt>
			<dd>
				<strong>Screening dokumen</strong>
				Applicants applying will be processed at the accreditation department,<br>
				this process requires hard copy personal document attachments.
			</dd>
		</dl>
		<dl>
			<dt>04</dt>
			<dd>
				<strong>Interview dan Psikotest</strong>
				Testing to determine analytical skills and personal traits. The tests include English tests, interviews,<br>
				and psychotest. Those who successfully pass will be enrolled in the volunteer programme.
			</dd>
		</dl>
		<dl>
			<dt>05</dt>
			<dd>
				<strong>Selamat Anda Menjadi Volunteer! dan Penempatan Volunteer</strong>
				Congrats you have become volunteer. Volunteers will be place<br>
				in the department according to selection and test.
			</dd>
		</dl>
	</div>




</div>
<!-- ▲contents▲ -->
	
</c:if>

</div>


