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

	@GetMapping("/CR6")
	public List<Object> get_CR6() {

		List<Object> res = reportingService.get_CR6();
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
		for (Integer i = 0; i < resLoan.size(); i++) {
			reportingService.updateTableCR1(14, 4 + i, f.format(resLoan.get(i)));
			reportingService.updateTableCR1(15, 4 + i, f.format(resDebt.get(i)));
			reportingService.updateTableCR1(16, 4 + i, f.format(resOffBalance.get(i)));
			reportingService.updateTableCR1(17, 4 + i,
					f.format(resLoan.get(i) + resDebt.get(i) + resOffBalance.get(i)));
		}
		;
	}

	@PostMapping("/updateCR6")
	public void updateCR6() {
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		List<Double> Original = new ArrayList<Double>();
		List<Double> Off_balance_sheet = new ArrayList<Double>();
		List<Double> Average_CCF = new ArrayList<Double>();
		List<Double> EAD = new ArrayList<Double>();
		List<Double> Number_Of_Obilogors = new ArrayList<Double>();
		List<Double> Average_PD = new ArrayList<Double>();
		List<Double> Average_maturity = new ArrayList<Double>();
		List<Double> RWA = new ArrayList<Double>();
		List<Double> RWA_density = new ArrayList<Double>();
		List<Double> Loss = new ArrayList<Double>();
		List<Double> Provisions = new ArrayList<Double>();
		List<Double> Average_LGD = new ArrayList<Double>();
		List<Double> PortfolioX = new ArrayList<Double>();
		Original = reportingService.get_org();
		Off_balance_sheet = reportingService.get_off();
		Average_CCF = reportingService.avg_ccf();
		EAD = reportingService.ead();
		Number_Of_Obilogors = reportingService.obligators();
		Average_LGD=reportingService.LGD();
		Average_PD = reportingService.avg_PD();
		Average_maturity = reportingService.maturiry();
		RWA = reportingService.rwa();
		RWA_density = reportingService.rwa_density();
		Loss = reportingService.loss();
		Provisions = reportingService.provisions();
		for(int i =0;i<Original.size();i++)
		{
			if(Original.get(i)==null)
				Original.set(i,0.0);
		}
		for(int i =0;i<Off_balance_sheet.size();i++)
		{
			if(Off_balance_sheet.get(i)==null)
				Off_balance_sheet.set(i,0.0);
		}
		for(int i =0;i<Average_CCF.size();i++)
		{
			if(Average_CCF.get(i)==null)
				Average_CCF.set(i,0.0);
		}
		for(int i =0;i<EAD.size();i++)
		{
			if(EAD.get(i)==null)
				EAD.set(i,0.0);
		}
		for(int i =0;i<Number_Of_Obilogors.size();i++)
		{
			if(Number_Of_Obilogors.get(i)==null)
				Number_Of_Obilogors.set(i,0.0);
		}
		for(int i =0;i<Average_PD.size();i++)
		{
			if(Average_PD.get(i)==null)
				Average_PD.set(i,0.0);
		}
		for(int i =0;i<Average_maturity.size();i++)
		{
			if(Average_maturity.get(i)==null)
				Average_maturity.set(i,0.0);
		}
		for(int i =0;i<Average_LGD.size();i++)
		{
			if(Average_LGD.get(i)==null)
				Average_LGD.set(i,0.0);
		}
		for(int i =0;i<RWA.size();i++)
		{
			if(RWA.get(i)==null)
				RWA.set(i,0.0);
		}
		for(int i =0;i<RWA_density.size();i++)
		{
			if(RWA_density.get(i)==null)
				RWA_density.set(i,0.0);
		}
		for(int i =0;i<Loss.size();i++)
		{
			if(Loss.get(i)==null)
				Loss.set(i,0.0);
		}
		for(int i =0;i<Provisions.size();i++)
		{
			if(Provisions.get(i)==null)
				Provisions.set(i,0.0);
		}
		Double sum = 0.0;
		for(Integer i = 0; i < Original.size(); i++)
		{
			sum += Original.get(i) + Off_balance_sheet.get(i) + Average_CCF.get(i) + EAD.get(i) +Number_Of_Obilogors.get(i)+
			Average_PD.get(i) + Average_maturity.get(i) + RWA.get(i) + RWA_density.get(i) + Loss.get(i);
			PortfolioX.add(sum);
		}
		PortfolioX.add(Provisions.get(0)+Provisions.get(1));
		for(Integer i = 0; i < Original.size(); i++)
		{
			reportingService.updateTableCR6(15, 4 + i , String.valueOf(PortfolioX.get(i) /sum * 100) + "%");
			reportingService.updateTableCR6(16 + i, 4 , f.format(Original.get(i)));
			reportingService.updateTableCR6(16 + i, 5 , f.format(Off_balance_sheet.get(i)));
			reportingService.updateTableCR6(16 + i, 6 , f.format(Average_CCF.get(i)));
			reportingService.updateTableCR6(16 + i, 7 , f.format(EAD.get(i) ));
			reportingService.updateTableCR6(16 + i, 8 , f.format(Average_PD.get(i)));
			reportingService.updateTableCR6(16 + i, 9 , f.format(Number_Of_Obilogors.get(i)));
			reportingService.updateTableCR6(16 + i, 10 , f.format(Average_LGD.get(i)));
			reportingService.updateTableCR6(16 + i, 11 , f.format(Average_maturity.get(i) ));
			reportingService.updateTableCR6(16 + i, 12 , f.format(RWA.get(i)));
			reportingService.updateTableCR6(16 + i, 13 , f.format(RWA_density.get(i)));
			reportingService.updateTableCR6(16 + i, 14 , f.format(Loss.get(i)));
			if(i==Original.size()-1)
				reportingService.updateTableCR6(16 + i, 15 , f.format(Provisions.get(0)));
		};
	}

	// update values in reports_template [intermediary table] table for report - cr2
	@PostMapping("/updateCR2")
	public void updateCR2() {
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);

		List<Double> res = new ArrayList<Double>();

		res = reportingService.calc_cr2();

		for (Integer i = 0; i < res.size(); i++) {
			reportingService.updateTableCR2(13 + i, 4, f.format(res.get(i)));
		}
		;
	}
}
