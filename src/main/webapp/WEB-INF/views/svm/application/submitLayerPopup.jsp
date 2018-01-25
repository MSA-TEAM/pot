<script>

function btnBeforeSubmit(){
	toggleLayer($('.layer_01'), 'on');
}

</script>

<!--
	ex)
	<div class="pop_wrap_01 layer_01 pop_move dim_close">
	
	**** class명 기능 ****
	1. pop_wrap_01 : 기본
	2. layer_01    : 팝업레이어 이름( toggleLayer의 첫번째 엘리먼트와 일치).
	3. pop_move    : 팝업 Move
	4. dim_close   : 배경 누를때 닫김
	
-->

<!-- 팝업레이어 1 -->
<!-- <div class="pop_wrap_01 layer_01 pop_move dim_close"> -->
<div class="pop_wrap_01 layer_01 pop_move">
	<div class="pop_top">
		<h1><spring:message code="svm.title.terms_conditions"/></h1>
		<a href="javascript:void(0);" class="close_01" onClick="toggleLayer($('.layer_01'), 'off');">close</a>
	</div>
	<div class="pop_contents">
		<div class="pop_in_con_01">
			Thank you for visiting INASGOC'S website. INASGOC reserves the right to change these guidelines and disclaimers at any time. Using this website you agree that each visit you make to the website shall be subject to the current guidelines of the terms.<br/><br/>
			All content on this website is owned and controlled by INASGOC. The contents or materials of this website pages, including but not limited to text, graphics, and icons are protected by copyright, trademark, or other intellectual property rights, and are owned and controlled by INASGOC (and its licensees and licencors) name, trademark, service marks, and trade name.<br/><br/>
			You may download a temporary copy of this materials and print a copy of the materials for your own personal use only (non-commercial purpose) to print, copy, reproduce, disassemble, transmit, distribute, republish, upload, download, post, store, display in public, alter or modify any content from this website without any prior written consent from INASGOC.<br><br/>
			You may not use this website to make speculative, false or fraudulent data. You may not use any devices, including any software or routine, which interferes with normal operation of this site or take any action that imposes an unreasonable load on INASGOC'S servers or other computer equipment, or other computer equipment and internet service providers.<br><br/>
			INASGOC will not be liable for any direct, indirect, consequential losses and/or damage an impact of accessing any sites that are operated by third parties outside INASGOC.<br><br/>
			Any communication, including any ideas, inventions, or concepts you’ve sent to the website or otherwise to INASGOC directly by electronic mail, with the exception of personally identifiable information shall be treated as non-confidential, and INASGOC shall be free to reproduce, publish or otherwise use them in any way for any purpose including developing, manufacturing and/or marketing of the event, and in such circumstances you are not entitled to any reward or compensation from INASGOC. INASGOC reserve the right whenever necessary to disclose your personal information within our own offices, authorized agents, government/security agencies, or the providers of such services.<br><br/>
<!-- 			any sites that are operated by third parties outside INASGOC.<br> -->
<!-- 			Any communication, including any ideas, inventions, or concepts you’ve sent to the website or otherwise to INASGOC directly by electronic mail, with the exception of personally identifiable information shall be treated as non-confidential, and INASGOC shall be free to reproduc -->
<!-- 			e, publish or otherwise use them in any way for any purpose including developing, manufacturing and/or marketing of the event, and in such circumstances you are not entitled to any reward or compensation from INASGOC. INASGOC reserve the right whenever necessary to disclose your personal information within our own offices, authorized agents, government/security agencies, or the providers of such services.<br><br/> -->
		</div>
		
		<div style="text-align:left;margin:20px 0px 0px 26px;">
			<input type="checkbox" id="accept_yn" class="checkbox_01" name=""><label><spring:message code="svm.message.submit_accept"/></label>
		</div>


		<div class="btn_area_01" style="margin:20px 26px 26px 0;">
			<div class="btn_right">
				<a href="javascript:void(0);" class="btn_01" onClick="toggleLayer($('.layer_01'), 'off');"><spring:message code="svm.button.cancel"/></a>
				<a href="javascript:void(0);" class="btn_02" onClick="btnSave();"><spring:message code="svm.button.submit"/></a>
			</div>

		</div>


	</div>
</div>


