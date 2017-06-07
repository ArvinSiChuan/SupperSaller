package com.superSaller.controller.REST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.persons.entities.CashSideEmployee;
import com.superSaller.dao.CashSideEmployeeDAO;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:38
 */
@RestController
@RequestMapping("/admin")
public class AdminRESTController {
	@Resource(name = "cashSideEmDAO")
	private CashSideEmployeeDAO dao;

	@RequestMapping(value = "/em/{emid}", method = RequestMethod.POST)
	public CashSideEmployee getCashSideEmployee(@PathVariable(value = "emid") String emid) {
		return dao.queryEmployeeByID(emid);
	}

	@RequestMapping(value = "/em/all", method = RequestMethod.POST)
	public List<CashSideEmployee> getAllEm() {
		return dao.queryAllEm();
	}

	@RequestMapping(value = "/em/{emid}", method = RequestMethod.DELETE)
	public Map<String, Boolean> deleteEmByID(@PathVariable("emid") String emID) {
		Map<String, Boolean> status = new HashMap<String, Boolean>();
		status.put("status", dao.deleteEm(emID));
		return status;
	}
}