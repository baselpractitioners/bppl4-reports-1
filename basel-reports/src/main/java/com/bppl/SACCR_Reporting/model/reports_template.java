package com.bppl.SACCR_Reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "reports_template")
@Data
public class reports_template {
	
	// all doubles are Numbers(23, 5) in sql
	
	@Id
	private int Id;
	private String Regulation;
	private String ReportCategory;
	private String ReportSubCategory;
	@Column(name = "ReportName")
	private String reportName;
	private String ReportSection;
	private String ReportSubSection;
	private int RowNumber;
	private int ColumnNumber;
	private String CellValue;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getRegulation() {
		return Regulation;
	}
	public void setRegulation(String regulation) {
		Regulation = regulation;
	}
	public String getReportCategory() {
		return ReportCategory;
	}
	public void setReportCategory(String reportCategory) {
		ReportCategory = reportCategory;
	}
	public String getReportSubCategory() {
		return ReportSubCategory;
	}
	public void setReportSubCategory(String reportSubCategory) {
		ReportSubCategory = reportSubCategory;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportSection() {
		return ReportSection;
	}
	public void setReportSection(String reportSection) {
		ReportSection = reportSection;
	}
	public String getReportSubSection() {
		return ReportSubSection;
	}
	public void setReportSubSection(String reportSubSection) {
		ReportSubSection = reportSubSection;
	}
	public int getRowNumber() {
		return RowNumber;
	}
	public void setRowNumber(int rowNumber) {
		RowNumber = rowNumber;
	}
	public int getColumnNumber() {
		return ColumnNumber;
	}
	public void setColumnNumber(int columnNumber) {
		ColumnNumber = columnNumber;
	}
	public String getCellValue() {
		return CellValue;
	}
	public void setCellValue(String cellValue) {
		CellValue = cellValue;
	}
	

}