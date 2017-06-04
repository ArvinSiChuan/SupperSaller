<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<security:csrfMetaTags />
		<title>Cashier Checkout</title>
		<link rel="stylesheet" href="../css/main.css" />
		<script src="../js/jquery.min.js"></script>
		<script src="../js/utils.js"></script>
		<script src="../js/bindEvents.js"></script>
		<script src="../js/getGoods.js"></script>
		<script src="../js/addGoods.js"></script>
	</head>

	<body>
		<section id="main" class="wrapper" style="width: 70%;">
			<header class="inner" style="text-align: left;margin-left: 2.2em;">
				<h2 style="color: #000000;">结算</h2>
				<h1>
				已登录的用户：
				<security:authentication property="name" />
			</h1>
				<form action="../auth/logout/" method="post">
					<security:csrfInput />
					<input class=" alt small" type="submit" value="注销登陆" />
					<security:authorize access="hasRole('ADMIN')">
						<a class="button alt small" href="../">返回主菜单</a>
					</security:authorize>
				</form>
			</header>
			<div id="goodListDiv" style="margin-left: 2.2em;margin-top: 1em;">
				<table id="goodListTable" class="table-wrapper">
					<thead>
						<tr>
							<th>商品号</th>
							<th>商品名称/规格</th>
							<th>品牌/所属品类</th>
							<th>数量</th>
							<th>单价原价</th>
							<th>优惠后单价</th>
							<th>优惠金额</th>
							<th>小计</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>test1</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>test2</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr name="seperator">
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
						</tr>
						<tr>
							<td>test3</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr name="seperator">
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
							<td>————————</td>
						</tr>
					</tbody>
					<tfoot>
						<tr id="addNewGood">
							<td name="newGood"><input name="newGood" type="text" pattern="[0-9]*" placeholder="商品数字号" /> <input name="history" type="hidden" />
								<div name="possibleGoods" style="width: 100%;">
									<a href="#newGood" class="button small fit" onclick="foucusNewGoodBox();">☝填写商品代码</a>
								</div>
							</td>
							<td name="goodName"></td>
							<td name="goodBrand"></td>
							<td name="goodNums"><input name="goodNumAdd" class="small fit" type="button" value=" + " /> <input name="goodNums" type="number" min="1" value="1" style="width: 100%;margin-bottom: 0.7em;" /> <input name="goodNumRemove" class="small fit" type="button" value=" - " />
							</td>
							<td name="originalPrice"></td>
							<td name="discountedPrice"></td>
							<td name="discountMoney"></td>
							<td name="subTotal"></td>
							<td name="comments"></td>
							<td>
								<input id="addToGoodListBtn" type="button" class="fit" style="background: green;" value="添加商品" />
								<input id="beginPaymentBtn" type="button" class="fit" style="background: gold;" value="支付订单" disabled="disabled"/>
								<input id="cancelOrderBtn" type="button" class="fit" style="background: red;" value="取消订单" disabled="disabled"/>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</section>
	</body>

</html>