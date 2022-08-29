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
	
	// all data needed to fill report CR10 [row, col, val]
	public List<Object> get_CR2() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR2").forEach(res::add);
		return res;
	}
	
	//all data required to fill CR3	[row, col, val]
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
	
	// intermediate function to get values
	public List<Double> get_debt()
	{
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
	
	public List<Double> get_off_balance()
	{
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
	
	public List<Double> get_loans()
	{
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
	
	public List<Double> calc_cr2()
	{
		List<Double> res = new ArrayList<Double>();
		
		res.add(CR10_repository.DefaultedExpenditurePrevPeriod());
		res.add(CR10_repository.DefaultedExpenditureCurPeriod());
		res.add(CR10_repository.RetToNonDefaulted());
		res.add(CR10_repository.AmountWriteOff());
		res.add(CR10_repository.OtherChanges());
		res.add(res.get(0) + res.get(1) - res.get(2) - res.get(3) + res.get(4));
		
		return res;
	}
	
	//functions to get values related to CR3
	public List<Double> getLoans()
	{
		List<Double> res = new ArrayList<Double>();
		
		res.add(CR10_repository.LoansExposuresUnsecured());
		res.add(CR10_repository.LoansExposuresSecured());
		res.add(CR10_repository.LoansExposuresSecuredCollateral());
		res.add(CR10_repository.LoansExposuresSecuredFinancialGuarantees());
		res.add(CR10_repository.LoansExposuresSecuredCreditDerivatives());
		
		return res;
	}
	
	public List<Double> getDebtSecurities()
	{
		List<Double> res = new ArrayList<Double>();
		
		res.add(CR10_repository.DebtSecuritiesExposuresUnsecured());
		res.add(CR10_repository.DebtSecuritiesExposuresSecured());
		res.add(CR10_repository.DebtSecuritiesExposuresSecuredCollateral());
		res.add(CR10_repository.DebtSecuritiesExposuresSecuredFinancialGuarantees());
		res.add(CR10_repository.DebtSecuritiesExposuresSecuredCreditDerivatives());
		
		return res;
	}
	
	public List<Double> getOfWhichDefaulted()
	{
		List<Double> res = new ArrayList<Double>();
		
		res.add(CR10_repository.OfDefaultedExposuresUnsecured());
		res.add(CR10_repository.OfDefaultedExposuresSecured());
		res.add(CR10_repository.OfDefaultedExposuresSecuredCollaterals());
		res.add(CR10_repository.OfDefaultedExposuresSecuredFinancialGuarantees());
		res.add(CR10_repository.OfDefaultedExposuresSecuredCreditDerivatives());
		
		return res;
	}
	
	//functions to get values related to CR5
	public List<Double> get_Sovereigns()
	{
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
	
	public List<Double> get_NonCentralGov()
	{
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
	
	public List<Double> get_MultilateralDevBanks()
	{
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
	
	public List<Double> get_Banks()
	{
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
	
	public List<Double> get_SecurityFirms()
	{
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
	
	public List<Double> get_Corporates()
	{
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
	
	public List<Double> get_RegulatoryRetailPortfolio()
	{
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
	
	public List<Double> get_SecByResidentialProperty()
	{
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
	
	public List<Double> get_SecByCommercialRealEstate()
	{
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
	
	public List<Double> get_Equity()
	{
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
	
	public List<Double> get_PastDueLoans()
	{
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
	
	public List<Double> get_HigherRisk()
	{
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
	
	public List<Double> get_OtherAssets()
	{
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
	

	public List<Double> calc_cr5()
	{
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

	
	
	// updates reports_template table with updated aggregates CR1
	public void updateTableCR1(Integer row, Integer col, String value)
	{
		reports_template_repository.updateCR1(row, col, value);
	}
	
	// updates reports_template table with updated aggregates CR1
	public void updateTableCR2(Integer row, Integer col, String value)
	{
		reports_template_repository.updateCR2(row, col, value);
	}
	
	public void updateTableCR3(Integer row, Integer col, String value)
	{
		reports_template_repository.updateCR3(row, col, value);
	}
	
	public void updateTableCR5(Integer row, Integer col, String value)
	{
		reports_template_repository.updateCR5(row, col, value);
	}
}
