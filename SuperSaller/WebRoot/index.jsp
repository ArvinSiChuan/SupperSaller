<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>User Panel</title>
		<link rel="stylesheet" href="./css/main.css" />
		<script src="./js/jquery.min.js"></script>
		<script src="./js/utils.js"></script>
	</head>

	<body>
		<header style="text-align: center;">
			<div style="margin-top: 3em;">
				<h2>
					已登录的用户：<security:authentication property="name" />
				</h2>
				<form action="./auth/logout/" method="post">
					<security:csrfInput/>
					<input type="submit" class="alt small" value="注销登录" />
				</form>
			</div>
		</header>
		<section id="main" class="main" style="width: 30%;margin:2.5em auto;">
			<div class="flex flex-2" >
				<security:authorize access="hasRole('CASHIER')">
					<div>
						<a href="./cashier/start" class="button" style="width: 200px;height: 200px;">
							<br />
							<ruby style="font-size: x-large;">收银侧<rt>Cashier Side</rt></ruby>
						</a>
					</div>
				</security:authorize>
				<security:authorize access="hasRole('ADMIN')">
					<div>
						<a href="./admin/" class="button" style="width: 200px;height: 200px;">
							<br />
							<ruby style="font-size: x-large;">管理侧<rt>Admin Side</rt></ruby>
						</a>
					</div>
				</security:authorize>

			</div>
			
		</section>
	</body>

</html>