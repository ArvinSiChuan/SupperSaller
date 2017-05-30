<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>  
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>Cashier Checkout</title>
		<link rel="stylesheet" href="../assets/css/main.css" />
		<script src="../assets/js/jquery.min.js"></script>
		<script src="../assets/js/utils.js"></script>
		<script src="../assets/js/checkout.js"></script>
	</head>

	<body>
		<section id="main" class="wrapper">
			<header class="inner" style="text-align: left;">
				<h2 style="color: #000000;">结算</h2>
			</header>
			<div id="goodListDiv" style="padding-left: 5em;padding-right: 5em;">
				<table id="goodListTable">
					<tr>
						<th>商品号</th>
						<th>商品名称</th>
						<th>品牌</th>
						<th>数量</th>
						<th>单价原价</th>
						<th>优惠后单价</th>
						<th>优惠金额</th>
						<th>小计</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
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
					<tr id="seperator">
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
					<tr id="seperator">
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
						<td><input id="newGood" type="text" pattern="[0-9]*" placeholder="商品数字号" /></td>
						<td id="goodName"></td>
						<td id="goodBrand"></td>
						<td>
							<input id="goodNumAdd" type="button" value=" + " />
							<input id="goodNums"  type="number" min="1" value="1" style="width: 2.5em;" />
							<input id="goodNumRemove" type="button" value=" - " />
						</td>
						<td id="originalPrice"></td>
						<td id="discountedPrice"></td>
						<td id="discountMoney"></td>
						<td id="subTotal"></td>
						<td id="comments"></td>
						<td><input id="addToGoodListBtn" type="button" value="添加" /></td>
					</tr>
				</table>
			</div>
		</section>
	</body>

</html>