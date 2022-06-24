package com.bppl.SACCR_Reporting.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// tables required
import com.bppl.SACCR_Reporting.model.reports_template;

public interface reports_templateRepository extends CrudRepository<reports_template, Integer>{
	// all queries needed 
	@Transactional
	@Modifying
	@Query("update reports_template set CellValue = ?3 where ReportName = 'CR1' and RowNumber = ?1 and ColumnNumber = ?2")
	void updateCR1(Integer row, Integer col, String value);
	
	@Query("select RowNumber, ColumnNumber, CellValue from reports_template where ReportName = ?1")
	List<Object> findByReportName(String ReportName);	

}
