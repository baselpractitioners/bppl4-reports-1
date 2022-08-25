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

	public List<Object> get_CR6() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR6").forEach(res::add);
		return res;
	}

	// intermediate function to get values
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
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
		for(int i =0;i<res.size();i++)
		{
			if(res.get(i)==null)
				res.set(i,0.0);
		}
		res.add(res.get(0) + res.get(1) - res.get(2) - res.get(3) + res.get(4));

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

	public void updateTableCR6(Integer row, Integer col, String value) {
		reports_template_repository.updateCR6(row, col, value);
	}
}
