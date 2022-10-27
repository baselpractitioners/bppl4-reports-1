package com.bppl.SACCR_Reporting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bppl.SACCR_Reporting.model.CR10;
import com.bppl.SACCR_Reporting.model.reports_template;
import com.bppl.SACCR_Reporting.repository.CR10Repository;
import com.bppl.SACCR_Reporting.repository.reports_templateRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ReportingService {

	@Autowired
	CR10Repository CR10_repository;

	@Autowired
	reports_templateRepository reports_template_repository;

	// all data needed to fill report CR1 [row, col, val]
	public List<Object> get_CR1() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR1").forEach(res::add);
		return res;
	}

	public List<Object> get_BatchID() {
		List<Object> res = new ArrayList<Object>();
		CR10_repository.get_all_batchIDs().forEach(res::add);
		return res;
	}

	// all data needed to fill report CR10 [row, col, val]
	public List<Object> get_CR2() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR2").forEach(res::add);
		return res;
	}

	public List<Object> get_CR3() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR3").forEach(res::add);
		return res;
	}

	public List<Object> get_CR5() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR5").forEach(res::add);
		return res;
	}

	public List<Object> get_CR6() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR6").forEach(res::add);
		return res;
	}

	public List<Object> get_CR4() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR4").forEach(res::add);
		return res;
	}

	public void insert_to_temp(ArrayList<String> IDs)
	{
		for (Integer i = 0; i < IDs.size(); i++) {
			CR10_repository.insert_to_Temp(IDs.get(i));
		}
	}

	public void delete_temp()
	{
		CR10_repository.delete_from_temp();
	}

	// intermediate function to get values
	// functions to get values related to CR3
	public List<Double> get_debt() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.DebtDefalutedExposure());
		res.add(CR10_repository.DebtNotDefalutedExposure());
		res.add(CR10_repository.DebtAllowances());
		res.add(CR10_repository.DebtAllocatedSpecific());
		res.add(CR10_repository.DebtAllocatedGeneral());
		res.add(0.0);
		res.add(res.get(0) + res.get(1) - res.get(2));

		return res;

	}

	public List<Double> get_off_balance() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.OffBalanceDefaultedExposure());
		res.add(CR10_repository.OffBalanceNotDefaultedExposure());
		res.add(CR10_repository.OffBalanceAllowances());
		res.add(CR10_repository.OffBalanceAllocatedSpecific());
		res.add(CR10_repository.OffBalanceAllocatedGeneral());
		res.add(0.0);
		res.add(res.get(0) + res.get(1) - res.get(2));

		return res;

	}

	public List<Double> get_loans() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.LoansDefaultedExposure());
		res.add(CR10_repository.LoansNotDefaultedExposure());
		res.add(CR10_repository.LoansAllowances());
		res.add(CR10_repository.LoansAllocatedSpecific());
		res.add(CR10_repository.LoansAllocatedGeneral());
		res.add(0.0);
		res.add(res.get(0) + res.get(1) - res.get(2));

		return res;
	}
	// functions to get values related to CR6

	public List<Double> get_org() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Org_1());
		res.add(CR10_repository.Org_2());
		res.add(CR10_repository.Org_3());
		res.add(CR10_repository.Org_4());
		res.add(CR10_repository.Org_5());
		res.add(CR10_repository.Org_6());
		res.add(CR10_repository.Org_7());
		res.add(CR10_repository.Org_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> get_off() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Off_1());
		res.add(CR10_repository.Off_2());
		res.add(CR10_repository.Off_3());
		res.add(CR10_repository.Off_4());
		res.add(CR10_repository.Off_5());
		res.add(CR10_repository.Off_6());
		res.add(CR10_repository.Off_7());
		res.add(CR10_repository.Off_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> avg_ccf() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.AvgCCF_1());
		res.add(CR10_repository.AvgCCF_2());
		res.add(CR10_repository.AvgCCF_3());
		res.add(CR10_repository.AvgCCF_4());
		res.add(CR10_repository.AvgCCF_5());
		res.add(CR10_repository.AvgCCF_6());
		res.add(CR10_repository.AvgCCF_7());
		res.add(CR10_repository.AvgCCF_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> ead() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.ead_1());
		res.add(CR10_repository.ead_2());
		res.add(CR10_repository.ead_3());
		res.add(CR10_repository.ead_4());
		res.add(CR10_repository.ead_5());
		res.add(CR10_repository.ead_6());
		res.add(CR10_repository.ead_7());
		res.add(CR10_repository.ead_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> avg_PD() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.avgPD_1());
		res.add(CR10_repository.avgPD_2());
		res.add(CR10_repository.avgPD_3());
		res.add(CR10_repository.avgPD_4());
		res.add(CR10_repository.avgPD_5());
		res.add(CR10_repository.avgPD_6());
		res.add(CR10_repository.avgPD_7());
		res.add(CR10_repository.avgPD_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> obligators() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.obl_1());
		res.add(CR10_repository.obl_2());
		res.add(CR10_repository.obl_3());
		res.add(CR10_repository.obl_4());
		res.add(CR10_repository.obl_5());
		res.add(CR10_repository.obl_6());
		res.add(CR10_repository.obl_7());
		res.add(CR10_repository.obl_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> LGD() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.lgd_1());
		res.add(CR10_repository.lgd_2());
		res.add(CR10_repository.lgd_3());
		res.add(CR10_repository.lgd_4());
		res.add(CR10_repository.lgd_5());
		res.add(CR10_repository.lgd_6());
		res.add(CR10_repository.lgd_7());
		res.add(CR10_repository.lgd_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> maturiry() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.avg_mat_1());
		res.add(CR10_repository.avg_mat_2());
		res.add(CR10_repository.avg_mat_3());
		res.add(CR10_repository.avg_mat_4());
		res.add(CR10_repository.avg_mat_5());
		res.add(CR10_repository.avg_mat_6());
		res.add(CR10_repository.avg_mat_7());
		res.add(CR10_repository.avg_mat_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> rwa() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.rwa_1());
		res.add(CR10_repository.rwa_2());
		res.add(CR10_repository.rwa_3());
		res.add(CR10_repository.rwa_4());
		res.add(CR10_repository.rwa_5());
		res.add(CR10_repository.rwa_6());
		res.add(CR10_repository.rwa_7());
		res.add(CR10_repository.rwa_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> rwa_density() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.rwa_den_1());
		res.add(CR10_repository.rwa_den_2());
		res.add(CR10_repository.rwa_den_3());
		res.add(CR10_repository.rwa_den_4());
		res.add(CR10_repository.rwa_den_5());
		res.add(CR10_repository.rwa_den_6());
		res.add(CR10_repository.rwa_den_7());
		res.add(CR10_repository.rwa_den_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> loss() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.loss_1());
		res.add(CR10_repository.loss_2());
		res.add(CR10_repository.loss_3());
		res.add(CR10_repository.loss_4());
		res.add(CR10_repository.loss_5());
		res.add(CR10_repository.loss_6());
		res.add(CR10_repository.loss_7());
		res.add(CR10_repository.loss_8());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) + res.get(2) + res.get(3) + res.get(4) + res.get(5) + res.get(6) + res.get(7));

		return res;
	}

	public List<Double> provisions() {
		List<Double> res = new ArrayList<Double>();
		res.add(CR10_repository.provisions_8());
		res.add(res.get(0));
		return res;
	}

	public List<Double> calc_cr2() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.DefaultedExpenditurePrevPeriod());
		res.add(CR10_repository.DefaultedExpenditureCurPeriod());
		res.add(CR10_repository.RetToNonDefaulted());
		res.add(CR10_repository.AmountWriteOff());
		res.add(CR10_repository.OtherChanges());
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i) == null)
				res.set(i, 0.0);
		}
		res.add(res.get(0) + res.get(1) - res.get(2) - res.get(3) + res.get(4));

		return res;
	}

	public List<Double> getLoans() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.LoansExposuresUnsecured());
		res.add(CR10_repository.LoansExposuresSecured());
		res.add(CR10_repository.LoansExposuresSecuredCollateral());
		res.add(CR10_repository.LoansExposuresSecuredFinancialGuarantees());
		res.add(CR10_repository.LoansExposuresSecuredCreditDerivatives());

		return res;
	}

	public List<Double> getDebtSecurities() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.DebtSecuritiesExposuresUnsecured());
		res.add(CR10_repository.DebtSecuritiesExposuresSecured());
		res.add(CR10_repository.DebtSecuritiesExposuresSecuredCollateral());
		res.add(CR10_repository.DebtSecuritiesExposuresSecuredFinancialGuarantees());
		res.add(CR10_repository.DebtSecuritiesExposuresSecuredCreditDerivatives());

		return res;
	}

	public List<Double> getOfWhichDefaulted() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.OfDefaultedExposuresUnsecured());
		res.add(CR10_repository.OfDefaultedExposuresSecured());
		res.add(CR10_repository.OfDefaultedExposuresSecuredCollaterals());
		res.add(CR10_repository.OfDefaultedExposuresSecuredFinancialGuarantees());
		res.add(CR10_repository.OfDefaultedExposuresSecuredCreditDerivatives());

		return res;
	}

	// functions to get values related to CR5
	public List<Double> get_Sovereigns() {
		List<Double> res = new ArrayList<Double>();
		System.out.println(CR10_repository.Sovereigs0());
		res.add(CR10_repository.Sovereigs0());
		res.add(CR10_repository.Sovereigs10());
		res.add(CR10_repository.Sovereigs20());
		res.add(CR10_repository.Sovereigs35());
		res.add(CR10_repository.Sovereigs50());
		res.add(CR10_repository.Sovereigs75());
		res.add(CR10_repository.Sovereigs100());
		res.add(CR10_repository.Sovereigs150());
		res.add(CR10_repository.SovereigsOthers());
		res.add(CR10_repository.SovereigsTotal());

		return res;

	}

	public List<Double> get_NonCentralGov() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.NonCentralGov0());
		res.add(CR10_repository.NonCentralGov10());
		res.add(CR10_repository.NonCentralGov20());
		res.add(CR10_repository.NonCentralGov35());
		res.add(CR10_repository.NonCentralGov50());
		res.add(CR10_repository.NonCentralGov75());
		res.add(CR10_repository.NonCentralGov100());
		res.add(CR10_repository.NonCentralGov150());
		res.add(CR10_repository.NonCentralGovOthers());
		res.add(CR10_repository.NonCentralGovTotal());

		return res;

	}

	public List<Double> get_MultilateralDevBanks() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.MultilateralDevBanks0());
		res.add(CR10_repository.MultilateralDevBanks10());
		res.add(CR10_repository.MultilateralDevBanks20());
		res.add(CR10_repository.MultilateralDevBanks35());
		res.add(CR10_repository.MultilateralDevBanks50());
		res.add(CR10_repository.MultilateralDevBanks75());
		res.add(CR10_repository.MultilateralDevBanks100());
		res.add(CR10_repository.MultilateralDevBanks150());
		res.add(CR10_repository.MultilateralDevBanksOthers());
		res.add(CR10_repository.MultilateralDevBanksTotal());

		return res;

	}

	public List<Double> get_Banks() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Banks0());
		res.add(CR10_repository.Banks10());
		res.add(CR10_repository.Banks20());
		res.add(CR10_repository.Banks35());
		res.add(CR10_repository.Banks50());
		res.add(CR10_repository.Banks75());
		res.add(CR10_repository.Banks100());
		res.add(CR10_repository.Banks150());
		res.add(CR10_repository.BanksOthers());
		res.add(CR10_repository.BanksTotal());

		return res;

	}

	public List<Double> get_SecurityFirms() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.SecurityFirms0());
		res.add(CR10_repository.SecurityFirms10());
		res.add(CR10_repository.SecurityFirms20());
		res.add(CR10_repository.SecurityFirms35());
		res.add(CR10_repository.SecurityFirms50());
		res.add(CR10_repository.SecurityFirms75());
		res.add(CR10_repository.SecurityFirms100());
		res.add(CR10_repository.SecurityFirms150());
		res.add(CR10_repository.SecurityFirmsOthers());
		res.add(CR10_repository.SecurityFirmsTotal());

		return res;

	}

	public List<Double> get_Corporates() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Corporates0());
		res.add(CR10_repository.Corporates10());
		res.add(CR10_repository.Corporates20());
		res.add(CR10_repository.Corporates35());
		res.add(CR10_repository.Corporates50());
		res.add(CR10_repository.Corporates75());
		res.add(CR10_repository.Corporates100());
		res.add(CR10_repository.Corporates150());
		res.add(CR10_repository.CorporatesOthers());
		res.add(CR10_repository.CorporatesTotal());

		return res;

	}

	public List<Double> get_RegulatoryRetailPortfolio() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.RegulatoryRetailPortfolio0());
		res.add(CR10_repository.RegulatoryRetailPortfolio10());
		res.add(CR10_repository.RegulatoryRetailPortfolio20());
		res.add(CR10_repository.RegulatoryRetailPortfolio35());
		res.add(CR10_repository.RegulatoryRetailPortfolio50());
		res.add(CR10_repository.RegulatoryRetailPortfolio75());
		res.add(CR10_repository.RegulatoryRetailPortfolio100());
		res.add(CR10_repository.RegulatoryRetailPortfolio150());
		res.add(CR10_repository.RegulatoryRetailPortfolioOthers());
		res.add(CR10_repository.RegulatoryRetailPortfolioTotal());

		return res;

	}

	public List<Double> get_SecByResidentialProperty() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.SecByResidentialProperty0());
		res.add(CR10_repository.SecByResidentialProperty10());
		res.add(CR10_repository.SecByResidentialProperty20());
		res.add(CR10_repository.SecByResidentialProperty35());
		res.add(CR10_repository.SecByResidentialProperty50());
		res.add(CR10_repository.SecByResidentialProperty75());
		res.add(CR10_repository.SecByResidentialProperty100());
		res.add(CR10_repository.SecByResidentialProperty150());
		res.add(CR10_repository.SecByResidentialPropertyOthers());
		res.add(CR10_repository.SecByResidentialPropertyTotal());

		return res;

	}

	public List<Double> get_SecByCommercialRealEstate() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.SecByCommercialRealEstate0());
		res.add(CR10_repository.SecByCommercialRealEstate10());
		res.add(CR10_repository.SecByCommercialRealEstate20());
		res.add(CR10_repository.SecByCommercialRealEstate35());
		res.add(CR10_repository.SecByCommercialRealEstate50());
		res.add(CR10_repository.SecByCommercialRealEstate75());
		res.add(CR10_repository.SecByCommercialRealEstate100());
		res.add(CR10_repository.SecByCommercialRealEstate150());
		res.add(CR10_repository.SecByCommercialRealEstateOthers());
		res.add(CR10_repository.SecByCommercialRealEstateTotal());

		return res;

	}

	public List<Double> get_Equity() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Equity0());
		res.add(CR10_repository.Equity10());
		res.add(CR10_repository.Equity20());
		res.add(CR10_repository.Equity35());
		res.add(CR10_repository.Equity50());
		res.add(CR10_repository.Equity75());
		res.add(CR10_repository.Equity100());
		res.add(CR10_repository.Equity150());
		res.add(CR10_repository.EquityOthers());
		res.add(CR10_repository.EquityTotal());

		return res;

	}

	public List<Double> get_PastDueLoans() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.PastDueLoans0());
		res.add(CR10_repository.PastDueLoans10());
		res.add(CR10_repository.PastDueLoans20());
		res.add(CR10_repository.PastDueLoans35());
		res.add(CR10_repository.PastDueLoans50());
		res.add(CR10_repository.PastDueLoans75());
		res.add(CR10_repository.PastDueLoans100());
		res.add(CR10_repository.PastDueLoans150());
		res.add(CR10_repository.PastDueLoansOthers());
		res.add(CR10_repository.PastDueLoansTotal());

		return res;

	}

	public List<Double> get_HigherRisk() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.HigherRisk0());
		res.add(CR10_repository.HigherRisk10());
		res.add(CR10_repository.HigherRisk20());
		res.add(CR10_repository.HigherRisk35());
		res.add(CR10_repository.HigherRisk50());
		res.add(CR10_repository.HigherRisk75());
		res.add(CR10_repository.HigherRisk100());
		res.add(CR10_repository.HigherRisk150());
		res.add(CR10_repository.HigherRiskOthers());
		res.add(CR10_repository.HigherRiskTotal());

		return res;

	}

	public List<Double> get_OtherAssets() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.OtherAssets0());
		res.add(CR10_repository.OtherAssets10());
		res.add(CR10_repository.OtherAssets20());
		res.add(CR10_repository.OtherAssets35());
		res.add(CR10_repository.OtherAssets50());
		res.add(CR10_repository.OtherAssets75());
		res.add(CR10_repository.OtherAssets100());
		res.add(CR10_repository.OtherAssets150());
		res.add(CR10_repository.OtherAssetsOthers());
		res.add(CR10_repository.OtherAssetsTotal());

		return res;

	}

	public List<Double> calc_cr5() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Total0());
		res.add(CR10_repository.Total10());
		res.add(CR10_repository.Total20());
		res.add(CR10_repository.Total35());
		res.add(CR10_repository.Total50());
		res.add(CR10_repository.Total75());
		res.add(CR10_repository.Total100());
		res.add(CR10_repository.Total150());
		res.add(CR10_repository.TotalOthers());
		res.add(CR10_repository.Total_Tot());

		return res;

	}

	// functions to get values related to CR4
	public List<Double> get_SovereignsCentralBanks() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.SOV_CRM_On());
		res.add(CR10_repository.SOV_CRM_Off());
		res.add(CR10_repository.SOV_CCF_On());
		res.add(CR10_repository.SOV_CCF_Off());
		res.add(CR10_repository.SOV_RWA());
		res.add(CR10_repository.SOV_RWA_Den());

		return res;

	}

	public List<Double> get_NonCentralGovernment() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Non_Cen_CCF_On());
		res.add(CR10_repository.Non_Cen_CCF_Off());
		res.add(CR10_repository.Non_Cen_CRM_Off());
		res.add(CR10_repository.Non_Cen_CCF_Off());
		res.add(CR10_repository.Non_Cen_CCF_Off());
		res.add(CR10_repository.Non_Cen_Den());

		return res;

	}

	public List<Double> get_MultilateralDev() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Multi_CRM_On());
		res.add(CR10_repository.Multi_CRM_Off());
		res.add(CR10_repository.Multi_CCF_On());
		res.add(CR10_repository.Multi_Off());
		res.add(CR10_repository.Multi_RWA());
		res.add(CR10_repository.Multi_Den());

		return res;

	}

	public List<Double> get_banks() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Banks_CRM_On());
		res.add(CR10_repository.Banks_CRM_Off());
		res.add(CR10_repository.Banks_CCF_On());
		res.add(CR10_repository.Banks_CCF_Off());
		res.add(CR10_repository.Banks_RWA());
		res.add(CR10_repository.Banks_Den());

		return res;

	}

	public List<Double> get_securityFirms() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Sec_Firms_CRM_On());
		res.add(CR10_repository.Sec_Firms_CRM_Off());
		res.add(CR10_repository.Sec_Firms_CCF_Off());
		res.add(CR10_repository.Sec_Firms_CCF_Off());
		res.add(CR10_repository.Sec_Firms_RWA());
		res.add(CR10_repository.Sec_Firms_Den());

		return res;

	}

	public List<Double> get_corporates() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Corps_CRM_On());
		res.add(CR10_repository.Corps_CRM_Off());
		res.add(CR10_repository.Corps_CCF_On());
		res.add(CR10_repository.Corps_CCF_Off());
		res.add(CR10_repository.Corps_RWA());
		res.add(CR10_repository.Corps_Den());

		return res;

	}

	public List<Double> get_regulatoryretail() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Reg_CRM_On());
		res.add(CR10_repository.Reg_CRM_Off());
		res.add(CR10_repository.Reg_CCF_On());
		res.add(CR10_repository.Reg_CCF_Off());
		res.add(CR10_repository.Reg_RWA());
		res.add(CR10_repository.Reg_Den());

		return res;

	}

	public List<Double> get_securedResProperty() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Res_CRM_On());
		res.add(CR10_repository.Res_CRM_Off());
		res.add(CR10_repository.Res_CCF_On());
		res.add(CR10_repository.sec_Res_Off());
		res.add(CR10_repository.sec_Res_RWA());
		res.add(CR10_repository.sec_Res_Den());

		return res;

	}

	public List<Double> get_commercialRealEstate() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Sec_Com_CRM_On());
		res.add(CR10_repository.Sec_ComCRMM_Off());
		res.add(CR10_repository.Sec_Com_CCF_On());
		res.add(CR10_repository.sec_Com_Off());
		res.add(CR10_repository.sec_Com_RWA());
		res.add(CR10_repository.sec_Com_Den());

		return res;

	}

	public List<Double> get_equity() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.eqi_CRM_On());
		res.add(CR10_repository.eqi_CRM_Off());
		res.add(CR10_repository.eqi_CCF_On());
		res.add(CR10_repository.eqi_Off());
		res.add(CR10_repository.eqi_RWA());
		res.add(CR10_repository.eqi_Den());

		return res;

	}

	public List<Double> get_pastDueLoans() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Past_due_CRM_On());
		res.add(CR10_repository.Past_due_CRM_Off());
		res.add(CR10_repository.Past_due_CCF_On());
		res.add(CR10_repository.past_due_Off());
		res.add(CR10_repository.past_due_RWA());
		res.add(CR10_repository.past_due_Den());

		return res;

	}

	public List<Double> get_HighRiskCategories() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.High_Risk_CRM_On());
		res.add(CR10_repository.High_Risk_CR_Off());
		res.add(CR10_repository.High_Risk_CCF_On());
		res.add(CR10_repository.high_risk_Off());
		res.add(CR10_repository.high_risk_RWA());
		res.add(CR10_repository.high_risk_Den());

		return res;

	}

	public List<Double> get_otherAssets() {
		List<Double> res = new ArrayList<Double>();

		res.add(CR10_repository.Others_CRM_On());
		res.add(CR10_repository.Others_CRM_Off());
		res.add(CR10_repository.Others_CCF_On());
		res.add(CR10_repository.other_Assets_Off());
		res.add(CR10_repository.other_Assets_RWA());
		res.add(CR10_repository.other_Assets_Den());

		return res;

	}

	// updates reports_template table with updated aggregates CR1
	public void updateTableCR1(Integer row, Integer col, String value) {
		reports_template_repository.updateCR1(row, col, value);
	}

	// updates reports_template table with updated aggregates CR1
	public void updateTableCR2(Integer row, Integer col, String value) {
		reports_template_repository.updateCR2(row, col, value);
	}

	public void updateTableCR3(Integer row, Integer col, String value) {
		reports_template_repository.updateCR3(row, col, value);
	}

	public void updateTableCR5(Integer row, Integer col, String value) {
		reports_template_repository.updateCR5(row, col, value);
	}

	public void updateTableCR6(Integer row, Integer col, String value) {
		reports_template_repository.updateCR6(row, col, value);
	}

	public void updateTableCR4(Integer row, Integer col, String value) {
		reports_template_repository.updateCR4(row, col, value);

	}

	public void updateTableCR9(Integer row, Integer col, String value) {
		reports_template_repository.updateCR9(row, col, value);

	}

}
