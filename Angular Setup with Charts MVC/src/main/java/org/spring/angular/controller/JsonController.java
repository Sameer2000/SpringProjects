package org.spring.angular.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.spring.angular.model.Sales;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

	
	@RequestMapping(value="/sales", method = RequestMethod.GET)
	public List<Sales> getSales(HttpServletResponse response) throws IOException{
		List<Sales> sales = new ArrayList<>();
		Sales montlySale = new Sales();
		montlySale.setAmount(25000);
		Sales onlineSale = new Sales();
		onlineSale.setAmount(120000);
		Sales targetSale = new Sales();
		targetSale.setAmount(100000);
		sales.add(targetSale);
		sales.add(montlySale);
		sales.add(onlineSale);
		return sales;
	}
	
}
