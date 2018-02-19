<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.servlet.i18n.SessionLocaleResolver"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="kr.co.sicc.gsp.svm.gms.common.interceptor.BasicInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// 2018 for SaaS
	List<BasicInfo> basicList = (ArrayList)session.getAttribute("BasicInfoList");
	String logoImage = "";
	for(BasicInfo info:basicList) {
		logoImage = info.getFile_path_nm() + "/" + info.getImg_file_nm();
// 		System.out.println("### info.getTenant_id() : " + info.getTenant_id());
// 		System.out.println("### info.getService_url_addr() : " + info.getService_url_addr());
// 		System.out.println("### info.getFile_path_nm() : " + info.getFile_path_nm() + "/" + info.getImg_file_nm());
	}	
	 
	// 2018 for SaaS	
%>
<!doctype html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8">
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/>
<title>GMS</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<link href="/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />

<script src="/js/jquery-2.1.4.min.js"></script>
<script src="/js/jquery-ui.js"></script>
<script src="/js/jquery.mCustomScrollbar.js"></script>
<script src="/js/jquery.mousewheel.min.js"></script>
<script src="/js/jquery.easing.1.3.js"></script>
<script src="/js/common.js"></script>

<script> 
	$(document).ready(function() {		
		var list_size = <%=basicList.size()%>; 
		//var menu_len = $(".main_menu").find("li").length;
		$(".main_menu").find("li").hide();
		
		for(var i=0; i < list_size; i++){
			$(".main_menu").find("li").eq(i).show();
		}
		
		// 2018 for SaaS
		$(".logo").css({"background":"url(<%=logoImage%>)", 'background-repeat' : 'no-repeat', 'background-position':'center center'});
		
	});  
</script>
</head>

<body>
<!-- ver.AG2018 -->
<body>
<div class="wrapper_01">
	<div class="top_wrap">
		<div class="top_gnb">
			<span class="logo">SaaS for Sports 2018</span>
<!-- 			<span class="logo">Jakarta Palembang 2018</span> -->
			<div class="top_right">
			</div>
		</div>
	</div>	
	<hr>	
	<div class="main_wrap_bg">
		<div class="main_wrap_in">
			<div class="main_wrap_01">
<!-- 				<div class="main_title"> -->
<!-- 					<img src="/images/main_txt_01.png" alt="18TH ASIAN GAMES Jakarta Palembang 2018"> -->
<!-- 				</div> -->
				
				<c:set var="basicList" value="<%=basicList%>"></c:set>
				<ul class="main_menu">		
					<c:forEach items="${basicList}" var="item" varStatus="status">		
						<li class="m_0${status.index+1}" ><a href="http://${item.getService_url_addr()}">${item.getSystem_cd()} Management</a></li>
					</c:forEach>
<!-- 					<li class="m_01" ><a href="#void" id="10180">Accreditation Management</a></li> -->
<!-- 					<li class="m_02" ><a href="#void" id="11280">Staff, Volunteer Management </a></li> -->
<!-- 					<li class="m_03" ><a href="#void" id="11080">Transportation Management</a></li> -->
<!-- 					<li class="m_04" ><a href="#void" id="10780">Medical Incident Tracking</a></li> -->
<!-- 					<li class="m_05" ><a href="#void" id="10280">Arrival and Departure Management </a></li> -->
<!-- 					<li class="m_06" ><a href="#void" id="10880">Protocol Management</a></li> -->
										
<!-- 					<li class="m_07" ><a href="#void" id="10380">Athletes Service Management </a></li> -->
<!-- 					<li class="m_08" ><a href="#void" id="10980">Security Tracking and Incident Management</a></li> -->
<!-- 					<li class="m_09" ><a href="#void" id="11380">Uniform Management </a></li> -->
<!-- 					<li class="m_10" ><a href="#void" id="MNL">Space, Material &amp; Logistic</a></li> -->
<!-- 					<li class="m_11" ><a href="#void" id="10680">Help Desk</a></li> -->
<!-- 					<li class="m_12" ><a href="#void" id="10480">Deployment Management </a></li> -->
				</ul>

			</div>
		</div>
	</div>
</div>
</body>
</html>