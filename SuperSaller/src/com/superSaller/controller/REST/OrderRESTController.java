package com.superSaller.controller.REST;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.checkout.OrderProcess;
import com.superSaller.beans.checkout.entities.Order;
import com.superSaller.beans.checkout.entities.ViewSideGood;
import com.superSaller.dao.OrderDAO;

@RestController
@RequestMapping("/order")
public class OrderRESTController {

	@Resource(name = "orderDAO")
	private OrderDAO orderDAO;

	@Resource(name = "orderProcess")
	private OrderProcess orderProcess;

	@RequestMapping(value = "/{uuid}", method = RequestMethod.POST)
	public List<Order> fuzzyQueryOrders(@PathVariable("uuid") String id) {
		return orderDAO.fuzzyQueryOrders(id);
	}

	@RequestMapping(value = "/good/add/{orderid}/{quantity}", method = RequestMethod.PUT)
	public List<ViewSideGood> addGoodToOrder(@RequestBody ViewSideGood good, @PathVariable("orderid") String orderID,
			@PathVariable("quantity") double quantity) {
		good.setSaledDate(LocalDateTime.now());
		good.setSaledPrice(good.getGoodPrice());
		good.setOrderID(orderID);
		good.setSum(quantity);
		List<ViewSideGood> viewSideGoods = orderProcess.addGoodAndMatch(good);
		return viewSideGoods;
	}

	@RequestMapping(value = "/good/delete", method = RequestMethod.DELETE)
	public List<ViewSideGood> removeFromOrder(@RequestBody ViewSideGood good) {
		return orderProcess.removeGoodAndMatch(good);
	}
}
