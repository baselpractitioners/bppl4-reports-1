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

	@GetMapping("/CR6")
	public List<Object> get_CR6() {

		List<Object> res = reportingService.get_CR6();
		return res;
	}

	@GetMapping("/CR4")
	public List<Object> get_CR4() {

		List<Object> res = reportingService.get_CR4();
		return res;
	}

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
		Average_LGD = reportingService.LGD();
		Average_PD = reportingService.avg_PD();
		Average_maturity = reportingService.maturiry();
		RWA = reportingService.rwa();
		RWA_density = reportingService.rwa_density();
		Loss = reportingService.loss();
		Provisions = reportingService.provisions();
		for (int i = 0; i < Original.size(); i++) {
			if (Original.get(i) == null)
				Original.set(i, 0.0);
		}
		for (int i = 0; i < Off_balance_sheet.size(); i++) {
			if (Off_balance_sheet.get(i) == null)
				Off_balance_sheet.set(i, 0.0);
		}
		for (int i = 0; i < Average_CCF.size(); i++) {
			if (Average_CCF.get(i) == null)
				Average_CCF.set(i, 0.0);
		}
		for (int i = 0; i < EAD.size(); i++) {
			if (EAD.get(i) == null)
				EAD.set(i, 0.0);
		}
		for (int i = 0; i < Number_Of_Obilogors.size(); i++) {
			if (Number_Of_Obilogors.get(i) == null)
				Number_Of_Obilogors.set(i, 0.0);
		}
		for (int i = 0; i < Average_PD.size(); i++) {
			if (Average_PD.get(i) == null)
				Average_PD.set(i, 0.0);
		}
		for (int i = 0; i < Average_maturity.size(); i++) {
			if (Average_maturity.get(i) == null)
				Average_maturity.set(i, 0.0);
		}
		for (int i = 0; i < Average_LGD.size(); i++) {
			if (Average_LGD.get(i) == null)
				Average_LGD.set(i, 0.0);
		}
		for (int i = 0; i < RWA.size(); i++) {
			if (RWA.get(i) == null)
				RWA.set(i, 0.0);
		}
		for (int i = 0; i < RWA_density.size(); i++) {
			if (RWA_density.get(i) == null)
				RWA_density.set(i, 0.0);
		}
		for (int i = 0; i < Loss.size(); i++) {
			if (Loss.get(i) == null)
				Loss.set(i, 0.0);
		}
		for (int i = 0; i < Provisions.size(); i++) {
			if (Provisions.get(i) == null)
				Provisions.set(i, 0.0);
		}
		Double sum = 0.0;
		Double temp = 0.0;
		for (Integer i = 0; i < Original.size(); i++) {
			temp += Original.get(i) + Off_balance_sheet.get(i) + Average_CCF.get(i) + EAD.get(i)
					+ Number_Of_Obilogors.get(i) +
					Average_PD.get(i) + Average_maturity.get(i) + RWA.get(i) + RWA_density.get(i) + Loss.get(i);
			sum += temp;
			PortfolioX.add(temp);
		}
		PortfolioX.add(Provisions.get(0) + Provisions.get(1));
		for (Integer i = 0; i < Original.size(); i++) {
			reportingService.updateTableCR6(15, 4 + i, String.valueOf(PortfolioX.get(i) / sum * 100) + "%");
			reportingService.updateTableCR6(16 + i, 4, f.format(Original.get(i)));
			reportingService.updateTableCR6(16 + i, 5, f.format(Off_balance_sheet.get(i)));
			reportingService.updateTableCR6(16 + i, 6, f.format(Average_CCF.get(i)));
			reportingService.updateTableCR6(16 + i, 7, f.format(EAD.get(i)));
			reportingService.updateTableCR6(16 + i, 8, f.format(Average_PD.get(i)));
			reportingService.updateTableCR6(16 + i, 9, f.format(Number_Of_Obilogors.get(i)));
			reportingService.updateTableCR6(16 + i, 10, f.format(Average_LGD.get(i)));
			reportingService.updateTableCR6(16 + i, 11, f.format(Average_maturity.get(i)));
			reportingService.updateTableCR6(16 + i, 12, f.format(RWA.get(i)));
			reportingService.updateTableCR6(16 + i, 13, f.format(RWA_density.get(i)));
			reportingService.updateTableCR6(16 + i, 14, f.format(Loss.get(i)));
			if (i == Original.size() - 1)
				reportingService.updateTableCR6(16 + i, 15, f.format(Provisions.get(0)));
		}
		;
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
		for (Integer i = 0; i < resLoans.size(); i++) {
			reportingService.updateTableCR3(14, 4 + i, f.format(resLoans.get(i)));
			reportingService.updateTableCR3(15, 4 + i, f.format(resDebtSecurities.get(i)));
			reportingService.updateTableCR3(16, 4 + i, f.format(resLoans.get(i) + resDebtSecurities.get(i)));
			reportingService.updateTableCR3(17, 4 + i, f.format(resOfDefaulted.get(i)));
		}
		;
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
		for (Integer i = 0; i < resSOV.size(); i++) {
			if (resSOV.get(i) == null)
				resSOV.set(i, 0.0);
			if (resPSE.get(i) == null)
				resPSE.set(i, 0.0);
			if (resMDB.get(i) == null)
				resMDB.set(i, 0.0);
			if (resBank.get(i) == null)
				resBank.set(i, 0.0);
			if (resSEC_FIRMS.get(i) == null)
				resSEC_FIRMS.set(i, 0.0);
			if (resCORP.get(i) == null)
				resCORP.set(i, 0.0);
			if (resRET.get(i) == null)
				resRET.set(i, 0.0);
			if (resRRE.get(i) == null)
				resRRE.set(i, 0.0);
			if (resCRE.get(i) == null)
				resCRE.set(i, 0.0);
			if (resEQUITY.get(i) == null)
				resEQUITY.set(i, 0.0);
			if (resPDL.get(i) == null)
				resPDL.set(i, 0.0);
			if (resHRC.get(i) == null)
				resHRC.set(i, 0.0);
			if (resOthers.get(i) == null)
				resOthers.set(i, 0.0);
		}
		for (Integer i = 0; i < resSOV.size(); i++) {
			reportingService.updateTableCR5(15, 4 + i, f.format(resSOV.get(i)));
			reportingService.updateTableCR5(16, 4 + i, f.format(resPSE.get(i)));
			reportingService.updateTableCR5(17, 4 + i, f.format(resMDB.get(i)));
			reportingService.updateTableCR5(18, 4 + i, f.format(resBank.get(i)));
			reportingService.updateTableCR5(19, 4 + i, f.format(resSEC_FIRMS.get(i)));
			reportingService.updateTableCR5(20, 4 + i, f.format(resCORP.get(i)));
			reportingService.updateTableCR5(21, 4 + i, f.format(resRET.get(i)));
			reportingService.updateTableCR5(22, 4 + i, f.format(resRRE.get(i)));
			reportingService.updateTableCR5(23, 4 + i, f.format(resCRE.get(i)));
			reportingService.updateTableCR5(24, 4 + i, f.format(resEQUITY.get(i)));
			reportingService.updateTableCR5(25, 4 + i, f.format(resPDL.get(i)));
			reportingService.updateTableCR5(26, 4 + i, f.format(resHRC.get(i)));
			reportingService.updateTableCR5(27, 4 + i, f.format(resOthers.get(i)));
			reportingService.updateTableCR5(28, 4 + i,
					f.format(resSOV.get(i) + resPSE.get(i) + resMDB.get(i) + resBank.get(i) + resSEC_FIRMS.get(i)
							+ resCORP.get(i) + resRET.get(i) + resRRE.get(i) + resCRE.get(i) + resEQUITY.get(i)
							+ resPDL.get(i) + resHRC.get(i) + resOthers.get(i)));
		}
		;
	}

	@PostMapping("/updateCR4")
	public void updateCR4() {
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		List<Double> Sov = new ArrayList<Double>();
		List<Double> non_cen = new ArrayList<Double>();
		List<Double> multi = new ArrayList<Double>();
		List<Double> banks = new ArrayList<Double>();
		List<Double> sec_firms = new ArrayList<Double>();
		List<Double> corps = new ArrayList<Double>();
		List<Double> regRetPort = new ArrayList<Double>();
		List<Double> secResProp = new ArrayList<Double>();
		List<Double> resCommRealEst = new ArrayList<Double>();
		List<Double> resEquity = new ArrayList<Double>();
		List<Double> resPDL = new ArrayList<Double>();
		List<Double> resHRC = new ArrayList<Double>();
		List<Double> resOthers = new ArrayList<Double>();
		Sov = reportingService.get_SovereignsCentralBanks();
		non_cen = reportingService.get_NonCentralGovernment();
		multi = reportingService.get_MultilateralDev();
		banks = reportingService.get_banks();
		sec_firms = reportingService.get_securityFirms();
		corps = reportingService.get_corporates();
		regRetPort = reportingService.get_regulatoryretail();
		secResProp = reportingService.get_securedResProperty();
		resCommRealEst = reportingService.get_commercialRealEstate();
		resEquity = reportingService.get_equity();
		resPDL = reportingService.get_pastDueLoans();
		resHRC = reportingService.get_HighRiskCategories();
		resOthers = reportingService.get_otherAssets();
		for (Integer i = 0; i < Sov.size(); i++) {
			if (Sov.get(i) == null)
				Sov.set(i, 0.0);
			if (non_cen.get(i) == null)
				non_cen.set(i, 0.0);
			if (multi.get(i) == null)
				multi.set(i, 0.0);
			if (banks.get(i) == null)
				banks.set(i, 0.0);
			if (sec_firms.get(i) == null)
				sec_firms.set(i, 0.0);
			if (corps.get(i) == null)
				corps.set(i, 0.0);
			if (secResProp.get(i) == null)
				secResProp.set(i, 0.0);
			if (resCommRealEst.get(i) == null)
				resCommRealEst.set(i, 0.0);
			if (regRetPort.get(i) == null)
				regRetPort.set(i, 0.0);
			if (resEquity.get(i) == null)
				resEquity.set(i, 0.0);
			if (resPDL.get(i) == null)
				resPDL.set(i, 0.0);
			if (resHRC.get(i) == null)
				resHRC.set(i, 0.0);
			if (resOthers.get(i) == null)
				resOthers.set(i, 0.0);
		}
		for (Integer i = 0; i < Sov.size(); i++) {
			reportingService.updateTableCR4(14, 4 + i, f.format(Sov.get(i)));
			reportingService.updateTableCR4(15, 4 + i, f.format(non_cen.get(i)));
			reportingService.updateTableCR4(16, 4 + i, f.format(multi.get(i)));
			reportingService.updateTableCR4(17, 4 + i, f.format(banks.get(i)));
			reportingService.updateTableCR4(18, 4 + i, f.format(sec_firms.get(i)));
			reportingService.updateTableCR4(19, 4 + i, f.format(corps.get(i)));
			reportingService.updateTableCR4(20, 4 + i, f.format(regRetPort.get(i)));
			reportingService.updateTableCR4(21, 4 + i, f.format(secResProp.get(i)));
			reportingService.updateTableCR4(22, 4 + i, f.format(resCommRealEst.get(i)));
			reportingService.updateTableCR4(23, 4 + i, f.format(resEquity.get(i)));
			reportingService.updateTableCR4(24, 4 + i, f.format(resPDL.get(i)));
			reportingService.updateTableCR4(25, 4 + i, f.format(resHRC.get(i)));
			reportingService.updateTableCR4(26, 4 + i, f.format(resOthers.get(i)));
			reportingService.updateTableCR4(27, 4 + i,
					f.format(Sov.get(i) + non_cen.get(i) + multi.get(i) + banks.get(i) + sec_firms.get(i) + corps.get(i)
							+ regRetPort.get(i) + secResProp.get(i) + resCommRealEst.get(i) + resEquity.get(i)
							+ resPDL.get(i) + resHRC.get(i) + resOthers.get(i)));
		}
		;
	
		}

}
