<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<form:hidden path="total_cnt"/>
<form:hidden path="limit"/>
<div class="pasing_01">
	<span class="total_number">
		Total <strong>${pageSet.total_cnt}</strong>
	</span>
	
	<c:choose>
		<c:when test="${pageSet.page != 1}">
			<a href="javascript:;" class="first" onclick="goPage('${pageSet.total_cnt}',${pageSet.page},'first')">first</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;" class="first">first</a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageSet.page / 10 > 1}">
			<a href="javascript:;" class="prev" onclick="goPage('${pageSet.total_cnt}',${pageSet.page},'prev')">prev</a>		
		</c:when>
		<c:otherwise>
			<a href="javascript:;" class="prev">prev</a>
		</c:otherwise>
	</c:choose>
		<span>
		<c:choose>

			<c:when test="${pageSet.total_cnt > 0}">
				<c:forEach begin="${pageSet.page_interval_st}" end="${pageSet.page_interval_ed}" var="data" varStatus="status">
					<c:choose>
						<c:when test="${data == pageSet.page}">
							<a href="javascript:;" class="on">${status.index}</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:;" class="" onclick="goPage('${pageSet.total_cnt}','${pageSet.page}', ${status.index});">${status.index}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<a href="javascript:;" class="on">1</a>
			</c:otherwise>
		</c:choose>
		</span>
	<fmt:parseNumber var="end_page" integerOnly="true" value="${(pageSet.total_cnt/pageSet.limit + ((pageSet.total_cnt%pageSet.limit) == 0 ? 0 : 1))}"/>
	<c:choose>
		<c:when test="${pageSet.page_interval_ed%pageSet.interval == 0 &&  end_page > pageSet.page_interval_ed}">
			<a href="javascript:;" class="next" onclick="goPage('${pageSet.total_cnt}',${pageSet.page},'next')">next</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;" class="next">next</a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageSet.page < end_page}">
			<a href="javascript:;" class="last" onclick="goPage('${pageSet.total_cnt}',${pageSet.page},'last')">last</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;" class="last" >last</a>
		</c:otherwise>
	</c:choose>
</div>

<!-- <div class="paging-navi only-mobile"> -->
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${pageSet.page != 1}"> --%>
<%-- 			<a href="javascript:;"  class="first" onclick="goPageMobile('${pageSet.total_cnt}',${pageSet.page},'first')">first</a> --%>
<%-- 			<a href="javascript:;" class="prev" onclick="goPageMobile('${pageSet.total_cnt}',${pageSet.page},'prev')">prev</a> --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<!-- 			<a href="javascript:;"  class="first">first</a> -->
<!-- 			<a href="javascript:;" class="prev">prev</a> -->
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
<%-- 	<strong class="on"><fmt:formatNumber value="${pageSet.page}" type="number"/> </strong> --%>
<%-- 	<span>/</span><span>${end_page}</span> --%>
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${end_page > pageSet.page}"> --%>
<%-- 			<a href="javascript:;" class="next" onclick="goPageMobile('${pageSet.total_cnt}',${pageSet.page},'next')">next</a> --%>
<%-- 			<a href="javascript:;" class="last" onclick="goPageMobile('${pageSet.total_cnt}',${pageSet.page},'last')">last</a> --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<!-- 			<a href="javascript:;" class="next">next</a> -->
<!-- 			<a href="javascript:;" class="last">last</a> -->
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
<!-- </div> -->
<script type="text/javascript">
//<![CDATA[
	function goPage(total_cnt, currentPage, page){
		var interval = '${pageSet.interval}';
		var limit = $('#limit').val();
		if(page == 'first'){
			page = 1;
		}else if(page == 'prev'){
			page = ((Math.ceil(currentPage*1.0/interval)-1)*interval)-(interval*1-1);
		}else if(page == 'next'){
			page = ((Math.ceil(currentPage*1.0/interval)-1)*interval)+(interval*1+1);
		}else if(page == 'last'){
			page = Math.ceil(total_cnt*1.0/limit);//(Math.ceil(total_cnt*1.0/10)-(Math.ceil(total_cnt*1.0/10)%10))+1;
		}
		funSearch(page);
	}
	
	function goPageMobile(total_cnt, currentPage, page){
		var limit = $('#limit').val();
		if(page == 'first'){
			page = 1;
		}else if(page == 'prev'){
			page = currentPage - 1;
		}else if(page == 'next'){
			page = currentPage + 1;
		}else if(page == 'last'){
			page = Math.ceil(total_cnt*1.0/limit);
		}
		funSearch(page);
	}
//]]>
</script>