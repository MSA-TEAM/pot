<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="<%=lang %>">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache" /> 
<meta http-equiv="Expires" content="0" /> 
<meta http-equiv="Pragma" content="no-cache" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title><spring:message code="gms.title" /></title>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css/jquery-ui.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/css/jquery.mCustomScrollbar.css"/>" type="text/css" />

<script type="text/javascript" src="<c:url value="/js/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/common_pub.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easing.1.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.mCustomScrollbar.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.mousewheel.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>


<script type="text/javascript">
// <![CDATA[
	function c(text){
		a=window.open('','','fullscreen');
		a.document.write('<title>Message</title><body bgcolor=#bfbfbf style=border:outset><input type=button onclick=self.close() value=닫기>'+text);
		a.resizeTo(200,200);
		a.moveTo(100,100);
	}
	
	$(window).load(function(){
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header, token);
		});
		
		if("${msg}" != null && "${msg}" != ""){
			setTimeout(function(){ 
				MessageHolder('${msg}', '${msgShowType}');
			}, 300);
		}
		setTitle();
	});
	
	function getQueryStringUrl(frm, url, keys){
		var queryString = url+'?';
		
		keys = keys || [];
						
		keys.push('cmd');
		keys.push('page');
		
		var list = frm.elements;
		var flag = 0;
		for(var i=0;i<list.length;i++){
			if(0 == list[i].name.indexOf('search_') && '' != list[i].value && 'undefined' != list[i].value && null != list[i].value){
				if(1 == flag)
					queryString+='&';
				queryString+=list[i].name+'='+list[i].value;					
				flag = 1;
			}else{
				keys.some(function(v){
					if(list[i].name == v && '' != list[i].value && 'undefined' != list[i].value && null != list[i].value){
						if(1 == flag)
							queryString+='&';
						queryString+=list[i].name+'='+list[i].value;
						flag = 1;
						return true;
					}
				});				
			}
		}
		return queryString;
	}
//]]>
</script>
</head>
<body>
	<tiles:insertAttribute name="body-content" />
</body>
</html>