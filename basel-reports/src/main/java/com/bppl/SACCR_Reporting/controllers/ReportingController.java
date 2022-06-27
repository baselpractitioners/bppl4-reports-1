package com.bppl.SACCR_Reporting.controllers;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bppl.SACCR_Reporting.service.ReportingService;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reports")
public class ReportingController {
	
	@Autowired
	private ReportingService reportingService;

	// SECTION 1 - get data to fill reports
	
	// Contains /reportname for each report
	@GetMapping("/CR1")
	public List<Object> get_CR1() {
	
		List<Object> res = reportingService.get_CR1();
		return res;
	}
	
	@GetMapping("/CR2")
	public List<Object> get_CR2() {
	
		List<Object> res = reportingService.get_CR2();
		return res;
	}
	
	// more reports will be added here with /reportname
	
	
	
	// SECTION 2 - update report data in intermediary table
	// update values in reports_template [intermediary table] table for report - cr1
	@PostMapping("/updateCR1")
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
	
	// update values in reports_template [intermediary table] table for report - cr2
	@PostMapping("/updateCR2")
	public void updateCR2() {
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		
		List<Double> res = new ArrayList<Double>();
		
		res = reportingService.calc_cr2();
		
		for(Integer i = 0; i < res.size(); i++)
		{
			reportingService.updateTableCR2(13 + i, 4, f.format(res.get(i)));
		};
	}
}
