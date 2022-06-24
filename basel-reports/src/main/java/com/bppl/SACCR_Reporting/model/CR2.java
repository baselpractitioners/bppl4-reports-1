package com.bppl.SACCR_Reporting.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CR2")
@Data
public class CR2 {
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBATCHID() {
		return BATCHID;
	}
	public void setBATCHID(String bATCHID) {
		BATCHID = bATCHID;
	}
	public Date getPROCESS_DT() {
		return PROCESS_DT;
	}
	public void setPROCESS_DT(Date pROCESS_DT) {
		PROCESS_DT = pROCESS_DT;
	}
	public String getACCT_NUM() {
		return ACCT_NUM;
	}
	public void setACCT_NUM(String aCCT_NUM) {
		ACCT_NUM = aCCT_NUM;
	}
	public String getPARTY_CD() {
		return PARTY_CD;
	}
	public void setPARTY_CD(String pARTY_CD) {
		PARTY_CD = pARTY_CD;
	}
	public String getPARTY_NAME() {
		return PARTY_NAME;
	}
	public void setPARTY_NAME(String pARTY_NAME) {
		PARTY_NAME = pARTY_NAME;
	}
	public String getPARTY_TYPE_CD() {
		return PARTY_TYPE_CD;
	}
	public void setPARTY_TYPE_CD(String pARTY_TYPE_CD) {
		PARTY_TYPE_CD = pARTY_TYPE_CD;
	}
	public String getPARTY_TYPE_DESC() {
		return PARTY_TYPE_DESC;
	}
	public void setPARTY_TYPE_DESC(String pARTY_TYPE_DESC) {
		PARTY_TYPE_DESC = pARTY_TYPE_DESC;
	}
	public String getECL_ACCT_FLAG() {
		return ECL_ACCT_FLAG;
	}
	public void setECL_ACCT_FLAG(String eCL_ACCT_FLAG) {
		ECL_ACCT_FLAG = eCL_ACCT_FLAG;
	}
	public String getON_OFF_BAL_IND() {
		return ON_OFF_BAL_IND;
	}
	public void setON_OFF_BAL_IND(String oN_OFF_BAL_IND) {
		ON_OFF_BAL_IND = oN_OFF_BAL_IND;
	}
	public String getSTD_PRODUCT_TYPE_CD() {
		return STD_PRODUCT_TYPE_CD;
	}
	public void setSTD_PRODUCT_TYPE_CD(String sTD_PRODUCT_TYPE_CD) {
		STD_PRODUCT_TYPE_CD = sTD_PRODUCT_TYPE_CD;
	}
	public String getSTD_PRODUCT_TYPE_DESC() {
		return STD_PRODUCT_TYPE_DESC;
	}
	public void setSTD_PRODUCT_TYPE_DESC(String sTD_PRODUCT_TYPE_DESC) {
		STD_PRODUCT_TYPE_DESC = sTD_PRODUCT_TYPE_DESC;
	}
	public double getEOP_BALANCE_AMT() {
		return EOP_BALANCE_AMT;
	}
	public void setEOP_BALANCE_AMT(double eOP_BALANCE_AMT) {
		EOP_BALANCE_AMT = eOP_BALANCE_AMT;
	}
	public String getLOAN_COMMIT_IND() {
		return LOAN_COMMIT_IND;
	}
	public void setLOAN_COMMIT_IND(String lOAN_COMMIT_IND) {
		LOAN_COMMIT_IND = lOAN_COMMIT_IND;
	}
	public double getTOT_WRITE_OFF_AMT() {
		return TOT_WRITE_OFF_AMT;
	}
	public void setTOT_WRITE_OFF_AMT(double tOT_WRITE_OFF_AMT) {
		TOT_WRITE_OFF_AMT = tOT_WRITE_OFF_AMT;
	}
	public String getACCT_PASTDUE_FLAG() {
		return ACCT_PASTDUE_FLAG;
	}
	public void setACCT_PASTDUE_FLAG(String aCCT_PASTDUE_FLAG) {
		ACCT_PASTDUE_FLAG = aCCT_PASTDUE_FLAG;
	}
	public double getSEC_AMT_PAST_DUE_LOAN() {
		return SEC_AMT_PAST_DUE_LOAN;
	}
	public void setSEC_AMT_PAST_DUE_LOAN(double sEC_AMT_PAST_DUE_LOAN) {
		SEC_AMT_PAST_DUE_LOAN = sEC_AMT_PAST_DUE_LOAN;
	}
	public double getUNSEC_AMT_PAST_DUE_LOAN() {
		return UNSEC_AMT_PAST_DUE_LOAN;
	}
	public void setUNSEC_AMT_PAST_DUE_LOAN(double uNSEC_AMT_PAST_DUE_LOAN) {
		UNSEC_AMT_PAST_DUE_LOAN = uNSEC_AMT_PAST_DUE_LOAN;
	}
	public String getIMPAIRMENT_FLAG() {
		return IMPAIRMENT_FLAG;
	}
	public void setIMPAIRMENT_FLAG(String iMPAIRMENT_FLAG) {
		IMPAIRMENT_FLAG = iMPAIRMENT_FLAG;
	}
	public String getACCT_FRAMEWORK_CD() {
		return ACCT_FRAMEWORK_CD;
	}
	public void setACCT_FRAMEWORK_CD(String aCCT_FRAMEWORK_CD) {
		ACCT_FRAMEWORK_CD = aCCT_FRAMEWORK_CD;
	}
	public double getSPECIFIC_PROVISION_AMT() {
		return SPECIFIC_PROVISION_AMT;
	}
	public void setSPECIFIC_PROVISION_AMT(double sPECIFIC_PROVISION_AMT) {
		SPECIFIC_PROVISION_AMT = sPECIFIC_PROVISION_AMT;
	}
	public double getCOLLECTIVE_PROVISION_AMT() {
		return COLLECTIVE_PROVISION_AMT;
	}
	public void setCOLLECTIVE_PROVISION_AMT(double cOLLECTIVE_PROVISION_AMT) {
		COLLECTIVE_PROVISION_AMT = cOLLECTIVE_PROVISION_AMT;
	}
	public double getOTH_PROVISION_AMT() {
		return OTH_PROVISION_AMT;
	}
	public void setOTH_PROVISION_AMT(double oTH_PROVISION_AMT) {
		OTH_PROVISION_AMT = oTH_PROVISION_AMT;
	}
	public double getNET_CARRYING_VALUE() {
		return NET_CARRYING_VALUE;
	}
	public void setNET_CARRYING_VALUE(double nET_CARRYING_VALUE) {
		NET_CARRYING_VALUE = nET_CARRYING_VALUE;
	}
	public Date getREP_DT() {
		return REP_DT;
	}
	public void setREP_DT(Date rEP_DT) {
		REP_DT = rEP_DT;
	}
	public Date getLST_REP_DT() {
		return LST_REP_DT;
	}
	public void setLST_REP_DT(Date lST_REP_DT) {
		LST_REP_DT = lST_REP_DT;
	}
	public Date getDEFAULT_DT() {
		return DEFAULT_DT;
	}
	public void setDEFAULT_DT(Date dEFAULT_DT) {
		DEFAULT_DT = dEFAULT_DT;
	}
	public Date getRET_TO_NDEFAULT_DT() {
		return RET_TO_NDEFAULT_DT;
	}
	public void setRET_TO_NDEFAULT_DT(Date rET_TO_NDEFAULT_DT) {
		RET_TO_NDEFAULT_DT = rET_TO_NDEFAULT_DT;
	}
	public double getDEF_EXP_PAST_PRD() {
		return DEF_EXP_PAST_PRD;
	}
	public void setDEF_EXP_PAST_PRD(double dEF_EXP_PAST_PRD) {
		DEF_EXP_PAST_PRD = dEF_EXP_PAST_PRD;
	}
	public double getDEF_EXP_CUR_PRD() {
		return DEF_EXP_CUR_PRD;
	}
	public void setDEF_EXP_CUR_PRD(double dEF_EXP_CUR_PRD) {
		DEF_EXP_CUR_PRD = dEF_EXP_CUR_PRD;
	}
	public double getRET_NDEFAULT_EXP_CURR_PER() {
		return RET_NDEFAULT_EXP_CURR_PER;
	}
	public void setRET_NDEFAULT_EXP_CURR_PER(double rET_NDEFAULT_EXP_CURR_PER) {
		RET_NDEFAULT_EXP_CURR_PER = rET_NDEFAULT_EXP_CURR_PER;
	}
	// all doubles are (23, 5)
	@Id
	private int Id;
	@Column(name = "BATCH_ID")
	private String BATCHID;
	private Date PROCESS_DT;
	private String ACCT_NUM;
	private String PARTY_CD;
	private String PARTY_NAME;
	private String PARTY_TYPE_CD;
	private String PARTY_TYPE_DESC;
	private String ECL_ACCT_FLAG;
	private String ON_OFF_BAL_IND;
	private String STD_PRODUCT_TYPE_CD;
	private String STD_PRODUCT_TYPE_DESC;
	private double EOP_BALANCE_AMT;
	private String LOAN_COMMIT_IND;
	private double TOT_WRITE_OFF_AMT;
	private String ACCT_PASTDUE_FLAG;
	private double SEC_AMT_PAST_DUE_LOAN;
	private double UNSEC_AMT_PAST_DUE_LOAN;
	private String IMPAIRMENT_FLAG;
	private String ACCT_FRAMEWORK_CD;
	private double SPECIFIC_PROVISION_AMT;
	private double COLLECTIVE_PROVISION_AMT;
	private double OTH_PROVISION_AMT;
	private double NET_CARRYING_VALUE;
	private Date REP_DT;
	private Date LST_REP_DT;
	private Date DEFAULT_DT;
	private Date RET_TO_NDEFAULT_DT;
	private double DEF_EXP_PAST_PRD;
	private double DEF_EXP_CUR_PRD;
	private double RET_NDEFAULT_EXP_CURR_PER;

}