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

	// CR4
	// 14d
	
}
