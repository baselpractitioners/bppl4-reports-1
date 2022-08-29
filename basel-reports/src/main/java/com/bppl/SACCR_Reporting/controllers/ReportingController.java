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
	
	@GetMapping("/CR3")
	public List<Object> get_CR3() {
	
		List<Object> res = reportingService.get_CR3();
		return res;
	}
	
	@GetMapping("/CR5")
	public List<Object> get_CR5() {
	
		List<Object> res = reportingService.get_CR5();
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
	
	@PostMapping("/updateCR3")
	public void updateCR3() {
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		List<Double> resLoans = new ArrayList<Double>();
		List<Double> resDebtSecurities = new ArrayList<Double>();
		List<Double> resOfDefaulted = new ArrayList<Double>();
		resLoans = reportingService.getLoans();
		resDebtSecurities = reportingService.getDebtSecurities();
		resOfDefaulted = reportingService.getOfWhichDefaulted();
		for(Integer i = 0; i < resLoans.size(); i++)
		{
			reportingService.updateTableCR3(14, 4 + i, f.format(resLoans.get(i)));
			reportingService.updateTableCR3(15, 4 + i, f.format(resDebtSecurities.get(i)));
			reportingService.updateTableCR3(16, 4 + i, f.format(resLoans.get(i)+resDebtSecurities.get(i)));
			reportingService.updateTableCR3(17, 4 + i, f.format(resOfDefaulted.get(i)));
		};
	}
	
	@PostMapping("/updateCR5")
	public void updateCR5() {
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		List<Double> resSOV = new ArrayList<Double>();
		List<Double> resPSE = new ArrayList<Double>();
		List<Double> resMDB = new ArrayList<Double>();
		List<Double> resBank = new ArrayList<Double>();
		List<Double> resSEC_FIRMS = new ArrayList<Double>();
		List<Double> resCORP = new ArrayList<Double>();
		List<Double> resRET = new ArrayList<Double>();
		List<Double> resRRE = new ArrayList<Double>();
		List<Double> resCRE = new ArrayList<Double>();
		List<Double> resEQUITY = new ArrayList<Double>();
		List<Double> resPDL = new ArrayList<Double>();
		List<Double> resHRC = new ArrayList<Double>();
		List<Double> resOthers = new ArrayList<Double>();
		resSOV = reportingService.get_Sovereigns();
		resPSE = reportingService.get_NonCentralGov();
		resMDB = reportingService.get_MultilateralDevBanks();
		resBank = reportingService.get_Banks();
		resSEC_FIRMS = reportingService.get_SecurityFirms();
		resCORP = reportingService.get_Corporates();
		resRET = reportingService.get_RegulatoryRetailPortfolio();
		resRRE = reportingService.get_SecByResidentialProperty();
		resCRE = reportingService.get_SecByCommercialRealEstate();
		resEQUITY = reportingService.get_Equity();
		resPDL = reportingService.get_PastDueLoans();
		resHRC = reportingService.get_HigherRisk();
		resOthers = reportingService.get_OtherAssets();
		for (Integer i = 0; i<resSOV.size();i++)
		{
			if(resSOV.get(i)==null)
				resSOV.set(i,0.0);
			if(resPSE.get(i)==null)
				resPSE.set(i,0.0);
			if(resMDB.get(i)==null)
				resMDB.set(i,0.0);
			if(resBank.get(i)==null)
				resBank.set(i,0.0);
			if(resSEC_FIRMS.get(i)==null)
				resSEC_FIRMS.set(i,0.0);
			if(resCORP.get(i)==null)
				resCORP.set(i,0.0);
			if(resRET.get(i)==null)
				resRET.set(i,0.0);
			if(resRRE.get(i)==null)
				resRRE.set(i,0.0);
			if(resCRE.get(i)==null)
				resCRE.set(i,0.0);
			if(resEQUITY.get(i)==null)
				resEQUITY.set(i,0.0);
			if(resPDL.get(i)==null)
				resPDL.set(i,0.0);
			if(resHRC.get(i)==null)
				resHRC.set(i,0.0);
			if(resOthers.get(i)==null)
				resOthers.set(i,0.0);
		}
		for(Integer i = 0; i < resSOV.size(); i++)
		{
			reportingService.updateTableCR5(15, 4 + i, f.format(resSOV.get(i)));
			reportingService.updateTableCR5(16, 4 + i, f.format(resPSE.get(i)));
			reportingService.updateTableCR5(17, 4 + i, f.format(resMDB.get(i)));
			reportingService.updateTableCR5(18, 4 + i, f.format(resBank.get(i)));
			reportingService.updateTableCR5(19, 4 + i, f.format(resSEC_FIRMS.get(i)));
			reportingService.updateTableCR5(20, 4 + i, f.format(resCORP.get(i)));
			reportingService.updateTableCR5(21, 4 + i, f.format(resRET.get(i)));
			reportingService.updateTableCR5(22, 4 + i, f.format(resRRE.get(i)));
			reportingService.updateTableCR5(23, 4 + i, f.format(resCRE.get(i)));
			System.out.println("hellloooo");
			reportingService.updateTableCR5(24, 4 + i, f.format(resEQUITY.get(i)));
			reportingService.updateTableCR5(25, 4 + i, f.format(resPDL.get(i)));
			reportingService.updateTableCR5(26, 4 + i, f.format(resHRC.get(i)));
			reportingService.updateTableCR5(27, 4 + i, f.format(resOthers.get(i)));
			reportingService.updateTableCR5(28, 4 + i, f.format(resSOV.get(i) + resPSE.get(i) + resMDB.get(i) + resBank.get(i) + resSEC_FIRMS.get(i) + resCORP.get(i) + resRET.get(i) + resRRE.get(i) + resCRE.get(i) + resEQUITY.get(i) + resPDL.get(i) + resHRC.get(i) + resOthers.get(i)));
		};
	}

}
