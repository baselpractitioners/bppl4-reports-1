package com.bppl.SACCR_Reporting.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// tables required
import com.bppl.SACCR_Reporting.model.CR10;

public interface CR10Repository extends CrudRepository<CR10, Integer> {

	// All queries required to get aggregate values that are to be put into reports

	// CR1
	// 1a
	@Query("select sum(EOP_BALANCE_AMT) from CR10  where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME') and ACCT_PASTDUE_FLAG = 'Y'")
	Double LoansDefaultedExposure();

	// 1b
	@Query("select sum(EOP_BALANCE_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME') and ACCT_PASTDUE_FLAG = 'N'")
	Double LoansNotDefaultedExposure();

	// 1c
	@Query("select (sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) + sum(SPECIFIC_PROVISION_AMT) + sum(OTH_PROVISION_AMT)) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansAllowances();

	// 1d
	@Query("select sum(SPECIFIC_PROVISION_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansAllocatedSpecific();

	// 1e
	@Query("select (sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) + sum(OTH_PROVISION_AMT)) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansAllocatedGeneral();

	// 2a
	@Query("select sum(EOP_BALANCE_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'BOND' and ACCT_PASTDUE_FLAG = 'Y'")
	Double DebtDefalutedExposure();

	// 2b
	@Query("select sum(EOP_BALANCE_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'BOND' and ACCT_PASTDUE_FLAG = 'N'")
	Double DebtNotDefalutedExposure();

	// 2c
	@Query("select sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) +sum(SPECIFIC_PROVISION_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'BOND'")
	Double DebtAllowances();

	// 2d
	@Query("select sum(SPECIFIC_PROVISION_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'BOND' ")
	Double DebtAllocatedSpecific();

	// 2e
	@Query("select sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) +sum(OTH_PROVISION_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'BOND'")
	Double DebtAllocatedGeneral();

	// 3a
	@Query("select sum(EOP_BALANCE_AMT) from CR10 where ACCT_PASTDUE_FLAG = 'Y' and( STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM')")
	Double OffBalanceDefaultedExposure();

	// 3b
	@Query("select sum(EOP_BALANCE_AMT) from CR10 where ACCT_PASTDUE_FLAG = 'N' and( STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM')")
	Double OffBalanceNotDefaultedExposure();

	// 3c
	@Query("select sum(TOT_WRITE_OFF_AMT + COLLECTIVE_PROVISION_AMT + SPECIFIC_PROVISION_AMT + OTH_PROVISION_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM'")
	Double OffBalanceAllowances();

	// 3d
	@Query("select sum(SPECIFIC_PROVISION_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM'")
	Double OffBalanceAllocatedSpecific();

	// 3e
	@Query("select sum(TOT_WRITE_OFF_AMT + COLLECTIVE_PROVISION_AMT +  OTH_PROVISION_AMT) from CR10 where STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM'")
	Double OffBalanceAllocatedGeneral();

	// CR10
	// 13d
	@Query("select sum(DEF_EXP_PAST_PRD) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DefaultedExpenditurePrevPeriod();

	// 14d
	@Query("select sum(DEF_EXP_CUR_PRD) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DefaultedExpenditureCurPeriod();

	// 15d
	@Query("select sum(EOP_BALANCE_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND') and RET_TO_NDEFAULT_DT > LST_REP_DT")
	Double RetToNonDefaulted();

	// 16d
	@Query("select sum(TOT_WRITE_OFF_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double AmountWriteOff();

	// 17d
	@Query("select sum(OTH_PROVISION_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double OtherChanges();

	// CR3
	// 14d
	@Query("select sum(UNSECURED_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansExposuresUnsecured();

	// 14e
	@Query("select sum(SECURED_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansExposuresSecured();

	// 14f
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='COLLATERALS') and (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansExposuresSecuredCollateral();

	// 14g
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='FINANCIAL GUARANTEES') and (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansExposuresSecuredFinancialGuarantees();

	// 14h
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='CREDIT DERIVATIVES') and (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansExposuresSecuredCreditDerivatives();

	// 15d
	@Query("select sum(UNSECURED_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DebtSecuritiesExposuresUnsecured();

	// 15e
	@Query("select sum(SECURED_AMT) from CR10 where (STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DebtSecuritiesExposuresSecured();

	// 15f
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='COLLATERALS') and (STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DebtSecuritiesExposuresSecuredCollateral();

	// 15g
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='FINANCIAL GUARANTEES') and (STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DebtSecuritiesExposuresSecuredFinancialGuarantees();

	// 15h
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='CREDIT DERIVATIVES') and (STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DebtSecuritiesExposuresSecuredCreditDerivatives();

	// 17d
	@Query("select sum(UNSECURED_AMT) from CR10 where (ACCT_PASTDUE_FLAG='Y')")
	Double OfDefaultedExposuresUnsecured();

	// 17e
	@Query("select sum(SECURED_AMT) from CR10 where (ACCT_PASTDUE_FLAG='Y')")
	Double OfDefaultedExposuresSecured();

	// 17f
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='COLLATERALS') and (ACCT_PASTDUE_FLAG='Y')")
	Double OfDefaultedExposuresSecuredCollaterals();

	// 17g
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='FINANCIAL GUARANTEES') and (ACCT_PASTDUE_FLAG='Y')")
	Double OfDefaultedExposuresSecuredFinancialGuarantees();

	// 17h
	@Query("select sum(SECURED_AMT) from CR10 where (CRM_TYPE='CREDIT DERIVATIVES') and (ACCT_PASTDUE_FLAG='Y')")
	Double OfDefaultedExposuresSecuredCreditDerivatives();

	// CR5
	@Query("select sum (POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT<0) and (BASEL_EXPOSURE_CLASS_CD= 'SOV')")
	Double Sovereigs0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT<10)")
	Double Sovereigs10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT<20)")
	Double Sovereigs20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT<35)")
	Double Sovereigs35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT<50)")
	Double Sovereigs50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT<75)")
	Double Sovereigs75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT<100)")
	Double Sovereigs100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT<150)")
	Double Sovereigs150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double SovereigsOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV')")
	Double SovereigsTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<0)")
	Double NonCentralGov0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<10)")
	Double NonCentralGov10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<20)")
	Double NonCentralGov20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<35)")
	Double NonCentralGov35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<50)")
	Double NonCentralGov50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<75)")
	Double NonCentralGov75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<100)")
	Double NonCentralGov100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT<150)")
	Double NonCentralGov150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double NonCentralGovOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE')")
	Double NonCentralGovTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<0)")
	Double MultilateralDevBanks0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<10)")
	Double MultilateralDevBanks10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<20)")
	Double MultilateralDevBanks20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<35)")
	Double MultilateralDevBanks35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<50)")
	Double MultilateralDevBanks50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<75)")
	Double MultilateralDevBanks75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<100)")
	Double MultilateralDevBanks100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT<150)")
	Double MultilateralDevBanks150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double MultilateralDevBanksOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB')")
	Double MultilateralDevBanksTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<0)")
	Double Banks0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<10)")
	Double Banks10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<20)")
	Double Banks20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<35)")
	Double Banks35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<50)")
	Double Banks50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<75)")
	Double Banks75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<100)")
	Double Banks100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT<150)")
	Double Banks150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double BanksOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Bank')")
	Double BanksTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<0)")
	Double SecurityFirms0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<10)")
	Double SecurityFirms10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<20)")
	Double SecurityFirms20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<35)")
	Double SecurityFirms35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<50)")
	Double SecurityFirms50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<75)")
	Double SecurityFirms75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<100)")
	Double SecurityFirms100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT<150)")
	Double SecurityFirms150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double SecurityFirmsOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS')")
	Double SecurityFirmsTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<0)")
	Double Corporates0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<10)")
	Double Corporates10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<20)")
	Double Corporates20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<35)")
	Double Corporates35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<50)")
	Double Corporates50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<75)")
	Double Corporates75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<100)")
	Double Corporates100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT<150)")
	Double Corporates150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double CorporatesOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP')")
	Double CorporatesTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<0)")
	Double RegulatoryRetailPortfolio0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<10)")
	Double RegulatoryRetailPortfolio10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<20)")
	Double RegulatoryRetailPortfolio20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<35)")
	Double RegulatoryRetailPortfolio35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<50)")
	Double RegulatoryRetailPortfolio50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<75)")
	Double RegulatoryRetailPortfolio75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<100)")
	Double RegulatoryRetailPortfolio100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT<150)")
	Double RegulatoryRetailPortfolio150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double RegulatoryRetailPortfolioOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET')")
	Double RegulatoryRetailPortfolioTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<0)")
	Double SecByResidentialProperty0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<10)")
	Double SecByResidentialProperty10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<20)")
	Double SecByResidentialProperty20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<35)")
	Double SecByResidentialProperty35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<50)")
	Double SecByResidentialProperty50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<75)")
	Double SecByResidentialProperty75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<100)")
	Double SecByResidentialProperty100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT<150)")
	Double SecByResidentialProperty150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double SecByResidentialPropertyOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE')")
	Double SecByResidentialPropertyTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<0)")
	Double SecByCommercialRealEstate0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<10)")
	Double SecByCommercialRealEstate10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<20)")
	Double SecByCommercialRealEstate20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<35)")
	Double SecByCommercialRealEstate35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<50)")
	Double SecByCommercialRealEstate50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<75)")
	Double SecByCommercialRealEstate75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<100)")
	Double SecByCommercialRealEstate100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT<150)")
	Double SecByCommercialRealEstate150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double SecByCommercialRealEstateOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE')")
	Double SecByCommercialRealEstateTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<0)")
	Double Equity0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<10)")
	Double Equity10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<20)")
	Double Equity20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<35)")
	Double Equity35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<50)")
	Double Equity50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<75)")
	Double Equity75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<100)")
	Double Equity100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT<150)")
	Double Equity150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double EquityOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY')")
	Double EquityTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<0)")
	Double PastDueLoans0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<10)")
	Double PastDueLoans10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<20)")
	Double PastDueLoans20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<35)")
	Double PastDueLoans35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<50)")
	Double PastDueLoans50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<75)")
	Double PastDueLoans75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<100)")
	Double PastDueLoans100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT<150)")
	Double PastDueLoans150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT) and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double PastDueLoansOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT)")
	Double PastDueLoansTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<0)")
	Double HigherRisk0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<10)")
	Double HigherRisk10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<20)")
	Double HigherRisk20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<35)")
	Double HigherRisk35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<50)")
	Double HigherRisk50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<75)")
	Double HigherRisk75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<100)")
	Double HigherRisk100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT<150)")
	Double HigherRisk150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50) and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double HigherRiskOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT=1.50)")
	Double HigherRiskTotal();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<0)")
	Double OtherAssets0();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<10)")
	Double OtherAssets10();

	@Query("select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<20)")
	Double OtherAssets20();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<35)")
	Double OtherAssets35();

	@Query("select 0.25*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<50)")
	Double OtherAssets50();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<75)")
	Double OtherAssets75();

	@Query("select 0.15*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<100)")
	Double OtherAssets100();

	@Query("select 0.10*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT<150)")
	Double OtherAssets150();

	@Query(value = "select 0.05*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double OtherAssetsOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS')")
	Double OtherAssetsTotal();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<0)")
	Double Total0();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<10)")
	Double Total10();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<20)")
	Double Total20();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<35)")
	Double Total35();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<50)")
	Double Total50();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<75)")
	Double Total75();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<100)")
	Double Total100();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT<150)")
	Double Total150();

	@Query(value = "select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' ) and (POST_CRM_RISK_WEIGHT not in (POST_CRM_RISK_WEIGHT<0,POST_CRM_RISK_WEIGHT<10,POST_CRM_RISK_WEIGHT<20,POST_CRM_RISK_WEIGHT<35,POST_CRM_RISK_WEIGHT<50,POST_CRM_RISK_WEIGHT<75,POST_CRM_RISK_WEIGHT<100,POST_CRM_RISK_WEIGHT<150))", nativeQuery = true)
	Double TotalOthers();

	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.10*EOP_BALANCE_AMT OR POST_CRM_RISK_WEIGHT = 1.50 OR BASEL_EXPOSURE_CLASS_CD='SOP' OR BASEL_EXPOSURE_CLASS_CD='PSE' OR BASEL_EXPOSURE_CLASS_CD='MDB' OR BASEL_EXPOSURE_CLASS_CD='Bank' OR BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS' OR BASEL_EXPOSURE_CLASS_CD='CORP' OR BASEL_EXPOSURE_CLASS_CD='RET' OR BASEL_EXPOSURE_CLASS_CD='RRE' OR BASEL_EXPOSURE_CLASS_CD='CRE' OR BASEL_EXPOSURE_CLASS_CD='EQUITY' OR BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS' )")
	Double Total_Tot();

	// CR6
	// 16b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.0015")
	Double Off_1();

	// 17b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double Off_2();

	// 18b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double Off_3();

	// 19b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double Off_4();

	// 20b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double Off_5();

	// 21b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double Off_6();

	// 22b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double Off_7();

	// 23b
	@Query("select sum(IRB_OFF_BAL_EAD) from CR10 where PD_FINAL = 1")
	Double Off_8();

	// 16c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.0015")
	Double AvgCCF_1();

	// 17c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double AvgCCF_2();

	// 18c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double AvgCCF_3();

	// 19c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double AvgCCF_4();

	// 20c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double AvgCCF_5();

	// 21c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double AvgCCF_6();

	// 22c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double AvgCCF_7();

	// 23c
	@Query("select sum(IRB_OFF_BAL_EAD_POST_CCF/IRB_OFF_BAL_EAD) from CR10 where PD_FINAL = 1")
	Double AvgCCF_8();

	// 16a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL < 0.0015")
	Double Org_1();

	// 17a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double Org_2();

	// 18a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double Org_3();

	// 19a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double Org_4();

	// 20a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double Org_5();

	// 21a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double Org_6();

	// 22a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double Org_7();

	// 23a
	@Query("select sum(IRB_ON_BAL_EAD) from CR10 where PD_FINAL = 1")
	Double Org_8();

	// 16d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0015")
	Double ead_1();

	// 17d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double ead_2();

	// 18d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double ead_3();

	// 19d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double ead_4();

	// 20d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double ead_5();

	// 21d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double ead_6();

	// 22d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double ead_7();

	// 23d
	@Query("select sum(IRB_NET_EAD) from CR10 where PD_FINAL = 1")
	Double ead_8();

	// 16e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0015) from(select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0015 group by PARTY_CD ) as temp", nativeQuery = true)
	Double avgPD_1();

	// 17e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015) from(select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015 group by PARTY_CD ) temp", nativeQuery = true)
	Double avgPD_2();

	// 18e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025) from(select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025 group by PARTY_CD ) temp", nativeQuery = true)
	Double avgPD_3();

	// 19e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0075 AND PD_FINAL >= 0.005) from(select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0075 AND PD_FINAL >= 0.005 group by PARTY_CD ) temp", nativeQuery = true)
	Double avgPD_4();

	// 20e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075) from (select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075 group by PARTY_CD ) temp", nativeQuery = true)
	Double avgPD_5();

	// 21e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25) from(select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25 group by PARTY_CD ) temp", nativeQuery = true)
	Double avgPD_6();

	// 22e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1) from(select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1 group by PARTY_CD ) temp", nativeQuery = true)
	Double avgPD_7();

	// 23e
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL = 1) from(select (PD_FINAL * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL = 1 group by PARTY_CD ) temp", nativeQuery = true)
	Double avgPD_8();

	// 16f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL < 0.0015")
	Double obl_1();

	// 17f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double obl_2();

	// 18f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double obl_3();

	// 19f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double obl_4();

	// 20f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double obl_5();

	// 21f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double obl_6();

	// 22f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double obl_7();

	// 23f
	@Query("select count(distinct PARTY_CD) from CR10 where PD_FINAL = 1")
	Double obl_8();

	// 16g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0015) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0015 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_1();

	// 17g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_2();

	// 18g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_3();

	// 19g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_4();

	// 20g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_5();

	// 21g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_6();

	// 22g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_7();

	// 23g
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL = 1) from(select (Effective_LGD * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL = 1 group by PARTY_CD ) temp", nativeQuery = true)
	Double lgd_8();

	// 16h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0015) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0015 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_1();

	// 17h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_2();

	// 18h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_3();

	// 19h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_4();

	// 20h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_5();

	// 21h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_6();

	// 22h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_7();

	// 23h
	@Query(value = "Select Sum(temp.Calcu)/(select sum(IRB_NET_EAD) from CR10 where PD_FINAL = 1) from(select (IRB_MAT * IRB_NET_EAD ) Calcu from CR10 where PD_FINAL = 1 group by PARTY_CD ) temp", nativeQuery = true)
	Double avg_mat_8();

	// 16i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL < 0.0015")
	Double rwa_1();

	// 17i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double rwa_2();

	// 18i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double rwa_3();

	// 19i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double rwa_4();

	// 20i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double rwa_5();

	// 21i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double rwa_6();

	// 22i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double rwa_7();

	// 23i
	@Query("Select Sum(RWA_IRB) from CR10 where PD_FINAL = 1")
	Double rwa_8();

	// 16j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL < 0.0015")
	Double rwa_den_1();

	// 17j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double rwa_den_2();

	// 18j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double rwa_den_3();

	// 19j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double rwa_den_4();

	// 20j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double rwa_den_5();

	// 21j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double rwa_den_6();

	// 22j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double rwa_den_7();

	// 23j
	@Query("Select Sum(RWA_DENSITY_IRB) from CR10 where PD_FINAL = 1")
	Double rwa_den_8();

	// 16k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL < 0.0015")
	Double loss_1();

	// 17k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL < 0.0025 and PD_FINAL >=0.0015")
	Double loss_2();

	// 18k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL < 0.005 and PD_FINAL >=0.0025")
	Double loss_3();

	// 19k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL < 0.0075 and PD_FINAL >=0.005")
	Double loss_4();

	// 20k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL < 0.25 and PD_FINAL >=0.0075")
	Double loss_5();

	// 21k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL < 0.1 and PD_FINAL >=0.25")
	Double loss_6();

	// 22k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL < 1 and PD_FINAL >=0.1")
	Double loss_7();

	// 23k
	@Query("Select Sum(EXP_LOSS_IRB) from CR10 where PD_FINAL = 1")
	Double loss_8();

	// 23l
	@Query("Select sum(SPECIFIC_PROVISION_AMT+COLLECTIVE_PROVISION_AMT+ OTH_PROVISION_AMT) from CR10 where PD_FINAL = 1")
	Double provisions_8();

	// CR9
	// 16b
	// @Query("Select sum(SPECIFIC_PROVISION_AMT+COLLECTIVE_PROVISION_AMT+
	// OTH_PROVISION_AMT) from CR10 where PD_FINAL = 1")
	// Double provisions_8();

	// CR4
	// 14a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='SOV'")
	Double SOV_CRM_On();

	// 14b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (ON_OFF_BAL_IND='OFF')")
	Double SOV_CRM_Off();

	// 14c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SOV') and (ON_OFF_BAL_IND='ON')")
	Double SOV_CCF_On();

	// 15a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='PSE'")
	Double Non_Cen_CRM_On();

	// 15b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (ON_OFF_BAL_IND='OFF')")
	Double Non_Cen_CRM_Off();

	// 15c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='PSE') and (ON_OFF_BAL_IND='ON')")
	Double Non_Cen_CCF_On();

	// 16a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='MDB'")
	Double Multi_CRM_On();

	// 16b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (ON_OFF_BAL_IND='OFF')")
	Double Multi_CRM_Off();

	// 16c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='MDB') and (ON_OFF_BAL_IND='ON')")
	Double Multi_CCF_On();

	// 16a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='Banks'")
	Double Banks_CRM_On();

	// 16b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Banks') and (ON_OFF_BAL_IND='OFF')")
	Double Banks_CRM_Off();

	// 16c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='Banks') and (ON_OFF_BAL_IND='ON')")
	Double Banks_CCF_On();

	// 17a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS'")
	Double Sec_Firms_CRM_On();

	// 17b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (ON_OFF_BAL_IND='OFF')")
	Double Sec_Firms_CRM_Off();

	// 17c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='SEC_FIRMS') and (ON_OFF_BAL_IND='ON')")
	Double Sec_Firms_CCF_On();

	// 18a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='CORP'")
	Double Corps_CRM_On();

	// 18b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (ON_OFF_BAL_IND='OFF')")
	Double Corps_CRM_Off();

	// 18c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CORP') and (ON_OFF_BAL_IND='ON')")
	Double Corps_CCF_On();

	// 19a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='RET'")
	Double Reg_CRM_On();

	// 19b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (ON_OFF_BAL_IND='OFF')")
	Double Reg_CRM_Off();

	// 18c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RET') and (ON_OFF_BAL_IND='ON')")
	Double Reg_CCF_On();

	// 20a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='RRE'")
	Double Res_CRM_On();

	// 20b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (ON_OFF_BAL_IND='OFF')")
	Double Res_CRM_Off();

	// 20c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='RRE') and (ON_OFF_BAL_IND='ON')")
	Double Res_CCF_On();

	// 21a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='CRE'")
	Double Sec_Com_CRM_On();

	// 21b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (ON_OFF_BAL_IND='OFF')")
	Double Sec_ComCRMM_Off();

	// 21c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='CRE') and (ON_OFF_BAL_IND='ON')")
	Double Sec_Com_CCF_On();

	// 22a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='EQUITY'")
	Double eqi_CRM_On();

	// 22b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (ON_OFF_BAL_IND='OFF')")
	Double eqi_CRM_Off();

	// 22c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='EQUITY') and (ON_OFF_BAL_IND='ON')")
	Double eqi_CCF_On();

	// 23a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where DEF_EXP_CUR_PRD<=0.1*EOP_BALANCE_AMT")
	Double Past_due_CRM_On();

	// 23b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.1*EOP_BALANCE_AMT) and (ON_OFF_BAL_IND='OFF')")
	Double Past_due_CRM_Off();

	// 23c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (DEF_EXP_CUR_PRD<=0.1*EOP_BALANCE_AMT) and (ON_OFF_BAL_IND='ON')")
	Double Past_due_CCF_On();

	// 24a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where POST_CRM_RISK_WEIGHT = 1.5")
	Double High_Risk_CRM_On();

	// 24b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT = 1.5) and (ON_OFF_BAL_IND='OFF')")
	Double High_Risk_CR_Off();

	// 24c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (POST_CRM_RISK_WEIGHT = 1.5) and (ON_OFF_BAL_IND='ON')")
	Double High_Risk_CCF_On();

	// 25a
	@Query("Select sum(EAD_DRAWN_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS'")
	Double Others_CRM_On();

	// 25b
	@Query("Select 0.3*sum(EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (ON_OFF_BAL_IND='OFF')")
	Double Others_CRM_Off();

	// 25c
	@Query("Select 0.5*sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where (BASEL_EXPOSURE_CLASS_CD='OTHER ASSETS') and (ON_OFF_BAL_IND='ON')")
	Double Others_CCF_On();

	// 14d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'SOV'")
	Double SOV_CCF_Off();

	// 14e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'SOV'")
	Double SOV_RWA();

	// 14f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'SOV'")
	Double SOV_RWA_Den();

	// 16d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'MDB'")
	Double Multi_Off();

	// 16e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'MDB'")
	Double Multi_RWA();

	// 16f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'MDB'")
	Double Multi_Den();

	// 15d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'PSE'")
	Double Non_Cen_CCF_Off();

	// 15e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'PSE'")
	Double Non_Cen_RWA();

	// 15f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'PSE'")
	Double Non_Cen_Den();

	// 17d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'Bank'")
	Double Banks_CCF_Off();

	// 17e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'Bank'")
	Double Banks_RWA();

	// 17f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'Bank'")
	Double Banks_Den();

	// 18d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'SEC_FIRMS'")
	Double Corps_CCF_Off();

	// 18e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'SEC_FIRMS'")
	Double Corps_RWA();

	// 18f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'SEC_FIRMS'")
	Double Corps_Den();

	// 19d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'CORP'")
	Double Sec_Firms_CCF_Off();

	// 19e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'CORP'")
	Double Sec_Firms_RWA();

	// 19f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'CORP'")
	Double Sec_Firms_Den();

	// 20d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'RET'")
	Double Reg_CCF_Off();

	// 20e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'RET'")
	Double Reg_RWA();

	// 20f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'RET'")
	Double Reg_Den();

	// 21d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'RRE'")
	Double sec_Res_Off();

	// 21e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'RRE'")
	Double sec_Res_RWA();

	// 21f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'RRE'")
	Double sec_Res_Den();

	// 22d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'CRE'")
	Double sec_Com_Off();

	// 22e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'CRE'")
	Double sec_Com_RWA();

	// 22f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'CRE'")
	Double sec_Com_Den();

	// 23d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD= 'EQUITY'")
	Double eqi_Off();

	// 23e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'EQUITY'")
	Double eqi_RWA();

	// 23f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD= 'EQUITY'")
	Double eqi_Den();

	// 24d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and DEFAULT_DT > LST_REP_DT")
	Double past_due_Off();

	// 24e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where DEFAULT_DT > LST_REP_DT")
	Double past_due_RWA();

	// 24f
	@Query("select sum(RWA_DENSITY) from CR10 where DEFAULT_DT > LST_REP_DT")
	Double past_due_Den();

	// 25d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and POST_CRM_RISK_WEIGHT = 1.5")
	Double high_risk_Off();

	// 25e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where POST_CRM_RISK_WEIGHT = 1.5")
	Double high_risk_RWA();

	// 25f
	@Query("select sum(RWA_DENSITY) from CR10 where POST_CRM_RISK_WEIGHT = 1.5")
	Double high_risk_Den();

	// 26d
	@Query("select sum(POST_CCF_CRM_EXPOSURE_AMT) from CR10 where ON_OFF_BAL_IND = 'OFF' and BASEL_EXPOSURE_CLASS_CD = 'OTHER ASSETS'")
	Double other_Assets_Off();

	// 26e
	@Query("select sum(POST_CRM_RWA_AMT) from CR10 where BASEL_EXPOSURE_CLASS_CD = 'OTHER ASSETS'")
	Double other_Assets_RWA();

	// 26f
	@Query("select sum(RWA_DENSITY) from CR10 where BASEL_EXPOSURE_CLASS_CD = 'OTHER ASSETS'")
	Double other_Assets_Den();
}
