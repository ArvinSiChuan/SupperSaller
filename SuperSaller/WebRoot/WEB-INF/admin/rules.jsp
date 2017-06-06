<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8" />
		<security:csrfMetaTags/>
		<title>促销规则管理</title>
		<link rel="stylesheet" href="..	/css/main.css" />
		<script src="../js/jquery.min.js"></script>
		<script src="../js/utils.js"></script>
		<script src="../js/admin/rule.js"></script>
	</head>

	<body style="text-align: center;">
		<header style="text-align: left;margin:2em auto; width: 90%;">
			<h2 style="color: #000000;font-size: xx-large;">规则编辑</h2>
			<h1>
				已登录的用户：<span id="username"><security:authentication property="name" /></span>
			</h1>
			<input id="logOut" class=" alt small" type="button" value="注销登陆" />
			<security:authorize access="hasRole('ADMIN')">
				<a class="button alt small" href="../">返回主菜单</a>
			</security:authorize>
			<input id="refresh" type="button" class="button small " style="background-color: green;" value="刷新列表" />

		</header>

			<table id="rules" class="fit" style="font-weight: bold;">
				<thead>
					<tr>
						<td name="ruleName">促销规则名</td>
						<td name="ruleType" style='padding-left: 30px;padding-right: 30px;'>类型</td>
						<td name="ruleConditionValue">成立值</td>
						<td name="discountRate">折扣率(0-100)</td>
						<td name="freeMoney">满减金额</td>
						<td name="specialMoney">特价</td>
						<td name="startDate">开始日期</td>
						<td name="endDate">结束日期</td>
						<td name="startMin">24小时周期开始时刻</td>
						<td name="endMin">24小时结束时刻</td>
						<td name="operation">操作</td>
					</tr>
				</thead>
				<tbody></tbody>
				<tfoot>
					<tr>
						<td>规则管理说明</td>
	
						<td colspan="10" style="text-align: center;vertical-align: middle;">使用说明</td>
					</tr>
				</tfoot>
			</table>


	</body>

</html>