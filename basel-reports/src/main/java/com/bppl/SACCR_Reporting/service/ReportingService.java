package com.bppl.SACCR_Reporting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bppl.SACCR_Reporting.model.CR2;
import com.bppl.SACCR_Reporting.model.reports_template;
import com.bppl.SACCR_Reporting.repository.CR2Repository;
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
	CR2Repository cr2_repository;

	@Autowired
	reports_templateRepository reports_template_repository;


	

	public List<Object> get_CR1() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR1").forEach(res::add);
		return res;
	}
	
	public List<Object> get_CR2() {
		List<Object> res = new ArrayList<Object>();
		reports_template_repository.findByReportName("CR2").forEach(res::add);
		return res;
	}
	
	public List<Double> get_debt()
	{
		List<Double> res = new ArrayList<Double>();

		res.add(cr2_repository.DebtDefalutedExposure());
		res.add(cr2_repository.DebtNotDefalutedExposure());
		res.add(cr2_repository.DebtAllowances());
		res.add(cr2_repository.DebtAllocatedSpecific());
		res.add(cr2_repository.DebtAllocatedGeneral());
		res.add(0.0);
		res.add(res.get(0) + res.get(1) - res.get(2));
		
		return res;
		
	}
	
	public List<Double> get_off_balance()
	{
		List<Double> res = new ArrayList<Double>();

		res.add(cr2_repository.OffBalanceDefaultedExposure());
		res.add(cr2_repository.OffBalanceNotDefaultedExposure());
		res.add(cr2_repository.OffBalanceAllowances());
		res.add(cr2_repository.OffBalanceAllocatedSpecific());
		res.add(cr2_repository.OffBalanceAllocatedGeneral());
		res.add(0.0);
		res.add(res.get(0) + res.get(1) - res.get(2));
		
		return res;
		
	}
	
	public List<Double> get_loans()
	{
		List<Double> res = new ArrayList<Double>();
		
		res.add(cr2_repository.LoansDefaultedExposure());
		res.add(cr2_repository.LoansNotDefaultedExposure()); 
		res.add(cr2_repository.LoansAllowances());
		res.add(cr2_repository.LoansAllocatedSpecific());
		res.add(cr2_repository.LoansAllocatedGeneral());
		res.add(0.0);
		res.add(res.get(0) + res.get(1) - res.get(2));
	
		return res;
	}
	
	public List<Double> calc_cr2()
	{
		List<Double> res = new ArrayList<Double>();
		
		res.add(cr2_repository.DefaultedExpenditurePrevPeriod());
		res.add(cr2_repository.DefaultedExpenditureCurPeriod());
		res.add(cr2_repository.RetToNonDefaulted());
		res.add(cr2_repository.AmountWriteOff());
		res.add(cr2_repository.OtherChanges());
		res.add(res.get(0) + res.get(1) - res.get(2) - res.get(3) + res.get(4));
		
		return res;
	}
	
	public void updateTableCR1(Integer row, Integer col, String value)
	{
		reports_template_repository.updateCR1(row, col, value);
	}
	
	public void updateTableCR2(Integer row, Integer col, String value)
	{
		reports_template_repository.updateCR2(row, col, value);
	}
}
