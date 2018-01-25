<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript" src="/js/common.js"></script>
<div class="contents_wrap_01 contents_support_01">
		<div class="contents_top">
			<div class="con_title"><spring:message code="svm.header.contact_us"/></div>
			<ul class="con_location">
				<li><spring:message code="svm.title.home"/></li>
				<li><spring:message code="svm.header.contact_us"/></li>
			</ul>
		</div>
<c:if test="${lang != 'in' }">	
<!-- ▼contents▼ -->

<div class="contactus_contents">


<!--▼table_write-->


	<div class="contactus_title_01">
		<strong>
			CONTACT US
		</strong>
		<span>
			<font style="font-size: 20px;">volunteer@asiangames2018.id</font><br/><br/>
			If you have any queries, please do not hesitate to send us a message.
			<br/>We will reply your email as soon as possible.
		</span>
		
		Indonesia Asian Games Organizing Committee (INASGOC) does not collect any money from or ask for compensation 
		in whatsoever form payable by any applicant in respect of the conduct of recruitment activities. Any of such 
		acts shall be fraud perpetrated by irresponsible party(ies) and being done for its(their) own benefits. Indonesia 
		Asian Games Organizing Committee (INASGOC) shall be released fully from any liabilities for and not be responsible 
		towards any losses and/or damages suffered by those being victims of the fraudulent acts or likewise misusing name and/or 
		any identity of or belongs to Indonesia Asian Games Organizing Committee (INASGOC). Indonesia Asian Games Organizing Committee (INASGOC) 
		will work together with authorized institution(s) in order to ensure these matters are treated properly pursuant to applicable law.
		
		<br>
		<br>

		It is strongly advised to keep exercising all precautious measures to avoid any possible thing for occur, such that falling of 
		the victims of any fraudulent acts and therefore, disseminate this precaution notification to the relatives and friends.

	</div>



				
<!--▲table_write-->



	<div class="btn_area_01 btn_support_01 btn_support_01_add" style="margin:30px 0 10px 0;">
		<div class="btn_center">
			<a href="mailto:volunteer@asiangames2018.id" class="btn_02 btn_02_add"><spring:message code='svm.button.send_mail'/></a>
		</div>
	</div>





</div>


<!-- ▲contents▲ -->
</c:if>
<c:if test="${lang == 'in' }">	
<!-- ▼contents▼ -->

<div class="contactus_contents">



<!--▼table_write-->

	<div class="contactus_title_01">
		<strong>
			Hubungi kami
		</strong>
		<span>
			<font style="font-size: 20px;">volunteer@asiangames2018.id</font><br/><br/>
			Jika anda memiliki pertanyaan, jangan ragu untuk mengirimkan pesan.<br/> Kami akan menjawab email anda sesegera mungkin.
		</span>
		
		Panitia Nasional Penyelenggaraan Asian Games XVIII Tahun 2018 (Indonesia Asian Games Organizing Committee - INASGOC) tidak meminta uang dari atau 
		kompensasi dalam bentuk apapun untuk dibayar oleh pendaftar sehubungan dengan pelaksanaan kegiatan rekrutmen. Tindakan-tindakan tersebut adalah penipuan yang 
		dilakukan oleh pihak(-pihak) yang tidak bertanggung jawab untuk manfaat bagi kepentingannya sendiri. Panitia Nasional Penyelenggaraan Asian Games XVIII Tahun 2018 
		(Indonesia Asian Games Organizing Committee - INASGOC) dibebaskan sepenuhnya dari pertanggungjawaban untuk dan tidak bertanggung jawab atas segala kehilangan dan/atau 
		kerugian yang diderita oleh korban dari tindakan penipuan atau sejenisnya, yang menyalahgunakan nama dari dan/atau identitas apapun milik Panitia Nasional Penyelenggaraan Asian 
		Games XVIII Tahun 2018 (Indonesia Asian Games Organizing Committee - INASGOC). Panitia Nasional Penyelenggaraan Asian Games XVIII Tahun 2018 (Indonesia Asian Games Organizing Committee - INASGOC) 
		akan bekerja bersama dengan pihak-(pihak) yang berwenang dalam rangka memastikan hal-hal ini ditangani dengan sebagaimana mestinya berdasarkan hukum yang berlaku.
		
		<br>
		<br>
		
		Sangat disarankan untuk selalu menjalankan seluruh tindakan pencegahan agar terhindar dari kemungkinan terjadinya, demikian sehingga timbul korban, tindakan penipuan dan karenanya, 
		menyebarluaskan pemberitahuan tindakan pencegahan ini kepada segenap anggota keluarga dan relasi.
 

	</div>




				
<!--▲table_write-->



	<div class="btn_area_01 btn_support_01 btn_support_01_add" style="margin:30px 0 10px 0;">
		<div class="btn_center">
<%-- 			<a href="mailto:volunteer@asiangames2018.id" class="btn_02 btn_02_add"><spring:message code='svm.button.send_mail'/></a> --%>
			<a href="mailto:volunteer@asiangames2018.id" target="_top" class="btn_02 btn_02_add"><spring:message code='svm.button.send_mail'/></a>
		</div>
	</div>





</div>



<!-- ▲contents▲ -->
</c:if>
