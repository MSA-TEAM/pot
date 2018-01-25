<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/resources/css/styleLogin.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>
    <div id="login_wrap">

    <div class="container">
        <div class="title">
            <h1 class="logo">평창동계올림픽 로고</h1>
            <h2><span class="em">GMS</span> (Game Management System)</h2>
            <p>통합관리시스템</p>
        </div><!-- // title -->

        <!-- login_con -->
        <div class="login_con">

            <div class="overF">
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
                        <div>
${securityExceptionMsg}
                        </div>		
            </div><!-- // overF -->
        </div><!-- // login_con -->

    </div><!-- // container -->

        <div id="footer" class="footer_simple">
            <p>2018평창동계올림픽대회 및 장애인동계올림픽 조직위원회</p>
            <p class="copyright">Copyright by The PyeongChang Organizing Committee for the 2018 Olympic & Paralympic Winter Games </p>
        </div>
    </div><!-- // login_wrap -->
</body>
</html>
