package com.bppl.SACCR_Reporting.repository;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// tables required
import com.bppl.SACCR_Reporting.model.reports_template;

public interface reports_templateRepository extends CrudRepository<reports_template, Integer>{

	@Transactional
	@Modifying
	@Query("update reports_template set CellValue = ?3 where ReportName = 'CR1' and RowNumber = ?1 and ColumnNumber = ?2")
	void updateCR1(Integer row, Integer col, String value);
	
	@Query("select RowNumber, ColumnNumber, CellValue from reports_template where ReportName = ?1")
	List<Object> findByReportName(String ReportName);
	
	@Transactional
	@Modifying
	@Query("update reports_template set CellValue = ?3 where ReportName = 'CR2' and RowNumber = ?1 and ColumnNumber = ?2")
	void updateCR2(Integer row, Integer col, String value);

	@Transactional
	@Modifying
	@Query("update reports_template set CellValue = ?3 where ReportName = 'CR3' and RowNumber = ?1 and ColumnNumber = ?2")
	void updateCR3(Integer row, Integer col, String value);
	
	@Transactional
	@Modifying
	@Query("update reports_template set CellValue = ?3 where ReportName = 'CR5' and RowNumber = ?1 and ColumnNumber = ?2")
	void updateCR5(Integer row, Integer col, String value);

	@Transactional
	@Modifying
	@Query("update reports_template set CellValue = ?3 where ReportName = 'CR6' and RowNumber = ?1 and ColumnNumber = ?2")
	void updateCR6(Integer row, Integer col, String value);

}

