<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>  
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../../css/main.css" />
	</head>

	<body>

		<section id="main" class="wrapper" style="width: 25em;margin: auto;">
			<header>
				<h2>登录</h2>
				<h3>商场促销系统</h3>
			</header>
			<div id="loginformDiv" style="margin:auto;"  style="width: 25em;">
				<form name="loginform" id="loginform" action="../../auth/login/" method="post">
					<security:csrfInput/>
					
					<div class="6u 12u$(small)">
						<input type="text" name="username" id="name" placeholder="工号/邮箱" required="required" pattern="([A-z]*)|([0-9]*)" title="请输入工号或邮箱" />
					</div>

					<div class="6u$ 12u$(small)" >
						<input type="password" name="password" id="pass" placeholder="口令" required="required" title="请输入口令" />
					</div>

					<a id="fogetPass" href="#">忘记密码</a>

					<div class="12u$">
						<input type="submit" name="submit" id="submit" value="登录" />
					</div>
				</form>
			</div>
		</section>
	</body>

</html>