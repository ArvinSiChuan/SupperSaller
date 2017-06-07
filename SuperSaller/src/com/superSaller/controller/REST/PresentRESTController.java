package com.superSaller.controller.REST;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.checkout.entities.Present;
import com.superSaller.dao.PresentDAO;

@RestController
@RequestMapping("/present")
public class PresentRESTController {

	@Resource(name = "presentDAO")
	private PresentDAO presentDAO;

	public List<Present> getAllPresent() {
		return null;
	}
}
