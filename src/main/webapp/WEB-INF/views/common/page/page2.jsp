<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<form:hidden path="total_cnt"/>
<form:hidden path="limit"/>
<div class="paging-navi only-pc">
	<c:choose>
		<c:when test="${pageSet2.page != 1}">
			<a href="javascript:;" onclick="gopage2('${pageSet2.total_cnt}',${pageSet2.page},'first')"><i class="icon-front"></i><span>처음 페이지</span></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;"><i class="icon-front"></i><span>처음 페이지</span></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageSet2.page / 10 > 1}">
			<a href="javascript:;" onclick="goPage('${pageSet2.total_cnt}',${pageSet2.page},'prev')"><i class="icon-prev"></i><span>이전 페이지</span></a>		
		</c:when>
		<c:otherwise>
			<a href="javascript:;"><i class="icon-prev"></i><span>이전 페이지</span></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageSet2.total_cnt > 0}">
			<c:forEach begin="${pageSet2.page_interval_st}" end="${pageSet2.page_interval_ed}" var="data" varStatus="status">
				<c:choose>
					<c:when test="${data == pageSet2.page}">
						<a href="javascript:;" class="active">${status.index}</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:;" onclick="goPage('${pageSet2.total_cnt}','${pageSet2.page}', ${status.index});">${status.index}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<a href="javascript:;" class="active">1</a>
		</c:otherwise>
	</c:choose>
	<fmt:parseNumber var="end_page" integerOnly="true" value="${(pageSet2.total_cnt/pageSet2.limit + ((pageSet2.total_cnt%pageSet2.limit) == 0 ? 0 : 1))}"/>
	<c:choose>
		<c:when test="${pageSet2.page_interval_ed%pageSet2.interval == 0 &&  end_page > pageSet2.page_interval_ed}">
			<a href="javascript:;" onclick="goPage('${pageSet2.total_cnt}',${pageSet2.page},'next')"><i class="icon-next"></i><span>다음 페이지</span></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;"><i class="icon-next"></i><span>다음 페이지</span></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageSet2.page < end_page}">
			<a href="javascript:;" onclick="goPage('${pageSet2.total_cnt}',${pageSet2.page},'last')"><i class="icon-last"></i><span>마지막 페이지</span></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;"><i class="icon-last"></i><span>마지막 페이지</span></a>
		</c:otherwise>
	</c:choose>
</div>
<div class="paging-navi only-mobile">
	<c:choose>
		<c:when test="${pageSet2.page != 1}">
			<a href="javascript:;" onclick="goPageMobile('${pageSet2.total_cnt}',${pageSet2.page},'first')"><i class="icon-front"></i><span>처음 페이지</span></a>
			<a href="javascript:;" onclick="goPageMobile('${pageSet2.total_cnt}',${pageSet2.page},'prev')"><i class="icon-prev"></i><span>이전 페이지</span></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;"><i class="icon-front"></i><span>처음 페이지</span></a>
			<a href="javascript:;"><i class="icon-prev"></i><span>이전 페이지</span></a>
		</c:otherwise>
	</c:choose>
	<strong class="active"><fmt:formatNumber value="${pageSet2.page}" type="number"/> </strong>
	<span>/</span><span>${end_page}</span>
	<c:choose>
		<c:when test="${end_page > pageSet2.page}">
			<a href="javascript:;" onclick="goPageMobile('${pageSet2.total_cnt}',${pageSet2.page},'next')"><i class="icon-next"></i><span>다음 페이지</span></a>
			<a href="javascript:;" onclick="goPageMobile('${pageSet2.total_cnt}',${pageSet2.page},'last')"><i class="icon-last"></i><span>마지막 페이지</span></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:;"><i class="icon-next"></i><span>다음 페이지</span></a>
			<a href="javascript:;"><i class="icon-last"></i><span>마지막 페이지</span></a>
		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript">
//<![CDATA[
	function goPage(total_cnt, currentPage, page){
		var interval = '${pageSet2.interval}';
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