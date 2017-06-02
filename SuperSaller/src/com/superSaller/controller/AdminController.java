package com.superSaller.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.persons.entities.CashSideEmployee;
import com.superSaller.dao.CashSideEmployeeDAOImpl;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:38
 */
@RestController
@RequestMapping("/em")
public class AdminController {
	@Resource(name = "cashSideEmDAO")
	private CashSideEmployeeDAOImpl dao;

	@RequestMapping(value = "/{emid}", method = RequestMethod.GET)
	public CashSideEmployee getCashSideEmployee(@PathVariable(value = "emid") String emid) {
		return dao.queryEmployeeByID(emid);
	}
}