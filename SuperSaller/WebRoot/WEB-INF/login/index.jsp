<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../../css/main.css" />
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script>
		$(document).ready(function() {
			$("#name").focus();
		});
	</script>
	</head>


	<body style="text-align: center;">

		<div style="margin:auto;width: 30em;padding: 8% 0 0;text-align: left;">
			<header>
				<h2 style="font-size: xx-large;">登录</h2>
				<h3>商场促销系统</h3>
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message != null}">
					<h4 style="color:red;">${SPRING_SECURITY_LAST_EXCEPTION.message}</h4>
				</c:if>
			</header>

			<div id="loginformDiv">
				<form name="loginform" id="loginform" action="../../auth/login/" method="post">
					<security:csrfInput/>
					<div class="6u 12u$(small)">
						<input type="text" name="username" id="name" placeholder="工号/邮箱" required="required" pattern="([A-z]*)|([0-9]*)" title="请输入工号或邮箱" />
					</div>

					<div class="6u$ 12u$(small)">
						<input type="password" name="password" id="pass" placeholder="口令" required="required" title="请输入口令" />
					</div>

					<a id="fogetPass" href="#">忘记密码</a>

					<div class="12u$">
						<input type="submit" name="submit" id="submit" value="登录" />
					</div>
				</form>
			</div>
		</div>
	</body>

</html>