package com.bppl.SACCR_Reporting.controllers;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bppl.SACCR_Reporting.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.bppl.SACCR_Reporting.service.ReportingService;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reporting")
public class ReportingController {
	
	@Autowired
	private ReportingService reportingService;


	// team 1 changes
	@GetMapping("/CR1")
	public List<Object> get_CR1() {
	
		List<Object> res = reportingService.get_CR1();
		return res;
	}
	
	// update values is reports_template table
	@GetMapping("/updateCR1")
	public void updateCR1() {
		
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		
		List<Double> resLoan = new ArrayList<Double>();
		List<Double> resDebt = new ArrayList<Double>();
		List<Double> resOffBalance = new ArrayList<Double>();
		resLoan = reportingService.get_loans();
		resDebt = reportingService.get_debt();
		resOffBalance = reportingService.get_off_balance();

		for(Integer i = 0; i < resLoan.size(); i++)
		{
			reportingService.updateTableCR1(14, 4 + i, f.format(resLoan.get(i)));
			reportingService.updateTableCR1(15, 4 + i, f.format(resDebt.get(i)));
			reportingService.updateTableCR1(16, 4 + i, f.format(resOffBalance.get(i)));
			reportingService.updateTableCR1(17, 4 + i, f.format(resLoan.get(i) + resDebt.get(i) + resOffBalance.get(i)));
		};
	}
		
}
