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
		<script src="../js/checkout/bindEventsAndUtils.js"></script>
		<script src="../js/checkout/getGoods.js"></script>
		<script src="../js/checkout/addGoods.js"></script>
	</head>

	<body style="text-align: center;">
		<header style="text-align: left;margin:2em auto; width: 90%;">
			<h2 style="color: #000000;font-size: xx-large;">结算</h2>
			<h1>
				已登录的用户：
				<security:authentication property="name" />
			</h1>
			<input id="logOut" class=" alt small" type="button" value="注销登陆" />
			<security:authorize access="hasRole('ADMIN')">
				<a class="button alt small" href="../">返回主菜单</a>
			</security:authorize>

		</header>

		<div id="goodListDiv" style="margin:auto;width: 90%;">
			<table id="goodListTable" class="fit">
				<thead>
					<tr>
						<th>商品号</th>
						<th>商品名称/规格</th>
						<th>品牌/所属品类</th>
						<th>单价原价</th>
						<th>优惠后单价</th>
						<th>优惠金额</th>
						<th>小计</th>
						<th>备注</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody style="text-align: left;">
					<tr>
						<td colspan="10" style="text-align:center;color: gold;font-weight: bold;font-size: xx-large;">
							还未添加商品<br />
							<input type="button" style="background-color:gold ;" value="读取未完成的订单" />
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr id="addNewGood" style="font-weight:bold;text-align: left;vertical-align: middle;">
						<td name="newGood"><input name="newGood" type="text" pattern="[0-9]*" placeholder="商品数字号" /> <input name="history" type="hidden" />
							<div name="possibleGoods" style="width: 100%;">
								<a href="#newGood" class="button small fit" onclick="foucusNewGoodBox();">☝填写商品代码</a>
							</div>
						</td>
						<td name="goodName"></td>
						<td name="goodBrand"></td>
						<td name="originalPrice" style="font-size: x-large;"></td>
						<td name="discountedPrice" style="font-size: x-large;"></td>
						<td name="discountMoney"></td>
						<td name="subTotal" style="font-size: x-large;font-weight:bold;"></td>
						<td name="comments"></td>
						<td name="goodNums">
							<input name="goodNumAdd" class="small fit" type="button" value=" + " />
							<input name="goodNums" type="number" min="1" value="1" style="width: 100%;margin-bottom: 0.7em;" />
							<input name="goodNumRemove" class="small fit" type="button" value=" - " />
						</td>
						<td>
							<input id="addToGoodListBtn" type="button" class="fit" style="background: green;" value="添加商品" disabled="disabled" />
							<input id="beginPaymentBtn" type="button" class="fit" style="background: gold;" value="支付订单" disabled="disabled" />
							<input id="cancelOrderBtn" type="button" class="fit" style="background: red;" value="取消订单" disabled="disabled" />
						</td>
					</tr>
				</tfoot>
			</table>
		</div>

	</body>

</html>