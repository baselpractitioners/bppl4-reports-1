package com.bppl.SACCR_Reporting.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TEMP_CR")
@Data
public class TEMP_CR {
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
	public double getUNSECURED_AMT() {
		return UNSECURED_AMT;
	}

	public void setUNSECURED_AMT(double uNSECURED_AMT) {
		UNSECURED_AMT = uNSECURED_AMT;
	}

	public double getSECURED_AMT() {
		return SECURED_AMT;
	}

	public void setSECURED_AMT(double sECURED_AMT) {
		SECURED_AMT = sECURED_AMT;
	}

	public String getCRM_TYPE() {
		return CRM_TYPE;
	}

	public void setCRM_TYPE(String cRM_TYPE) {
		CRM_TYPE = cRM_TYPE;
	}

	public String getBASEL_EXPOSURE_CLASS_CD() {
		return BASEL_EXPOSURE_CLASS_CD;
	}

	public void setBASEL_EXPOSURE_CLASS_CD(String bASEL_EXPOSURE_CLASS_CD) {
		BASEL_EXPOSURE_CLASS_CD = bASEL_EXPOSURE_CLASS_CD;
	}

	public double getEAD_DRAWN_AMT() {
		return EAD_DRAWN_AMT;
	}

	public void setEAD_DRAWN_AMT(double eAD_DRAWN_AMT) {
		EAD_DRAWN_AMT = eAD_DRAWN_AMT;
	}

	public double getEAD_UNDRAWN_AMT() {
		return EAD_UNDRAWN_AMT;
	}

	public void setEAD_UNDRAWN_AMT(double eAD_UNDRAWN_AMT) {
		EAD_UNDRAWN_AMT = eAD_UNDRAWN_AMT;
	}

	public double getPOST_CCF_CRM_EXPOSURE_AMT() {
		return POST_CCF_CRM_EXPOSURE_AMT;
	}

	public void setPOST_CCF_CRM_EXPOSURE_AMT(double pOST_CCF_CRM_EXPOSURE_AMT) {
		POST_CCF_CRM_EXPOSURE_AMT = pOST_CCF_CRM_EXPOSURE_AMT;
	}

	public double getPOST_CRM_RWA_AMT() {
		return POST_CRM_RWA_AMT;
	}

	public void setPOST_CRM_RWA_AMT(double pOST_CRM_RWA_AMT) {
		POST_CRM_RWA_AMT = pOST_CRM_RWA_AMT;
	}

	public double getEXPOSURE_AMT() {
		return EXPOSURE_AMT;
	}

	public void setEXPOSURE_AMT(double eXPOSURE_AMT) {
		EXPOSURE_AMT = eXPOSURE_AMT;
	}

	public double getRWA_DENSITY() {
		return RWA_DENSITY;
	}

	public void setRWA_DENSITY(double rWA_DENSITY) {
		RWA_DENSITY = rWA_DENSITY;
	}

	public double getPOST_CRM_RISK_WEIGHT() {
		return POST_CRM_RISK_WEIGHT;
	}

	public void setPOST_CRM_RISK_WEIGHT(double pOST_CRM_RISK_WEIGHT) {
		POST_CRM_RISK_WEIGHT = pOST_CRM_RISK_WEIGHT;
	}

	public double getPD_FINAL() {
		return PD_FINAL;
	}

	public void setPD_FINAL(double pD_FINAL) {
		PD_FINAL = pD_FINAL;
	}

	public double getIRB_GROSS_EAD() {
		return IRB_GROSS_EAD;
	}

	public void setIRB_GROSS_EAD(double iRB_GROSS_EAD) {
		IRB_GROSS_EAD = iRB_GROSS_EAD;
	}

	public double getIRB_ON_BAL_EAD() {
		return IRB_ON_BAL_EAD;
	}

	public void setIRB_ON_BAL_EAD(double iRB_ON_BAL_EAD) {
		IRB_ON_BAL_EAD = iRB_ON_BAL_EAD;
	}

	public double getIRB_CCF() {
		return IRB_CCF;
	}

	public void setIRB_CCF(double iRB_CCF) {
		IRB_CCF = iRB_CCF;
	}

	public double getIRB_OFF_BAL_EAD() {
		return IRB_OFF_BAL_EAD;
	}

	public void setIRB_OFF_BAL_EAD(double iRB_OFF_BAL_EAD) {
		IRB_OFF_BAL_EAD = iRB_OFF_BAL_EAD;
	}

	public double getIRB_OFF_BAL_EAD_POST_CCF() {
		return IRB_OFF_BAL_EAD_POST_CCF;
	}

	public void setIRB_OFF_BAL_EAD_POST_CCF(double iRB_OFF_BAL_EAD_POST_CCF) {
		IRB_OFF_BAL_EAD_POST_CCF = iRB_OFF_BAL_EAD_POST_CCF;
	}

	public double getIRB_NET_EAD() {
		return IRB_NET_EAD;
	}

	public void setIRB_NET_EAD(double iRB_NET_EAD) {
		IRB_NET_EAD = iRB_NET_EAD;
	}

	public double getIRB_MAT() {
		return IRB_MAT;
	}

	public void setIRB_MAT(double iRB_MAT) {
		IRB_MAT = iRB_MAT;
	}

	public double getRWA_IRB() {
		return RWA_IRB;
	}

	public void setRWA_IRB(double rWA_IRB) {
		RWA_IRB = rWA_IRB;
	}

	public double getEXP_LOSS_IRB() {
		return EXP_LOSS_IRB;
	}

	public void setEXP_LOSS_IRB(double eXP_LOSS_IRB) {
		EXP_LOSS_IRB = eXP_LOSS_IRB;
	}

	public double getRWA_DENSITY_IRB() {
		return RWA_DENSITY_IRB;
	}

	public void setRWA_DENSITY_IRB(double rWA_DENSITY_IRB) {
		RWA_DENSITY_IRB = rWA_DENSITY_IRB;
	}

	public double getFIRB_GROSS_EAD() {
		return FIRB_GROSS_EAD;
	}

	public void setFIRB_GROSS_EAD(double fIRB_GROSS_EAD) {
		FIRB_GROSS_EAD = fIRB_GROSS_EAD;
	}

	public double getFIRB_ON_BAL_EAD() {
		return FIRB_ON_BAL_EAD;
	}

	public void setFIRB_ON_BAL_EAD(double fIRB_ON_BAL_EAD) {
		FIRB_ON_BAL_EAD = fIRB_ON_BAL_EAD;
	}

	public double getFIRB_OFF_BAL_EAD() {
		return FIRB_OFF_BAL_EAD;
	}

	public void setFIRB_OFF_BAL_EAD(double fIRB_OFF_BAL_EAD) {
		FIRB_OFF_BAL_EAD = fIRB_OFF_BAL_EAD;
	}

	public double getFIRB_OFF_BAL_EAD_POST_CCF() {
		return FIRB_OFF_BAL_EAD_POST_CCF;
	}

	public void setFIRB_OFF_BAL_EAD_POST_CCF(double fIRB_OFF_BAL_EAD_POST_CCF) {
		FIRB_OFF_BAL_EAD_POST_CCF = fIRB_OFF_BAL_EAD_POST_CCF;
	}

	public double getFIRB_CCF() {
		return FIRB_CCF;
	}

	public void setFIRB_CCF(double fIRB_CCF) {
		FIRB_CCF = fIRB_CCF;
	}

	public double getFIRB_NET_EAD() {
		return FIRB_NET_EAD;
	}

	public void setFIRB_NET_EAD(double fIRB_NET_EAD) {
		FIRB_NET_EAD = fIRB_NET_EAD;
	}

	public double getFIRB_MAT() {
		return FIRB_MAT;
	}

	public void setFIRB_MAT(double fIRB_MAT) {
		FIRB_MAT = fIRB_MAT;
	}

	public double getEFF_LGD() {
		return EFF_LGD;
	}

	public void setEFF_LGD(double eFF_LGD) {
		EFF_LGD = eFF_LGD;
	}

	public double getRWA_FIRB() {
		return RWA_FIRB;
	}

	public void setRWA_FIRB(double rWA_FIRB) {
		RWA_FIRB = rWA_FIRB;
	}

	public double getRWA_DENSITY_FIRB() {
		return RWA_DENSITY_FIRB;
	}

	public void setRWA_DENSITY_FIRB(double rWA_DENSITY_FIRB) {
		RWA_DENSITY_FIRB = rWA_DENSITY_FIRB;
	}

	public double getEXP_LOSS_FIRB() {
		return EXP_LOSS_FIRB;
	}

	public void setEXP_LOSS_FIRB(double eXP_LOSS_FIRB) {
		EXP_LOSS_FIRB = eXP_LOSS_FIRB;
	}

	public String getRW_METHOD() {
		return RW_METHOD;
	}

	public void setRW_METHOD(String rW_METHOD) {
		RW_METHOD = rW_METHOD;
	}

	public String getINT_EXT_RAT_MPG() {
		return INT_EXT_RAT_MPG;
	}

	public void setINT_EXT_RAT_MPG(String iNT_EXT_RAT_MPG) {
		INT_EXT_RAT_MPG = iNT_EXT_RAT_MPG;
	}

	public String getPD_RANGE() {
		return PD_RANGE;
	}

	public void setPD_RANGE(String pD_RANGE) {
		PD_RANGE = pD_RANGE;
	}

	public double getNO_DF_OBG_PAST_PER() {
		return NO_DF_OBG_PAST_PER;
	}

	public void setNO_DF_OBG_PAST_PER(double nO_DF_OBG_PAST_PER) {
		NO_DF_OBG_PAST_PER = nO_DF_OBG_PAST_PER;
	}

	public double getNO_PARTY_CD_PAST_PER() {
		return NO_PARTY_CD_PAST_PER;
	}

	public void setNO_PARTY_CD_PAST_PER(double nO_PARTY_CD_PAST_PER) {
		NO_PARTY_CD_PAST_PER = nO_PARTY_CD_PAST_PER;
	}

	// all doubles are (23, 5)
	@Id
	private int Id;
	@Column(name="BATCH_ID")
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
	private double UNSECURED_AMT;
	private double SECURED_AMT;
	private String CRM_TYPE;
	private String BASEL_EXPOSURE_CLASS_CD;
	private double EAD_DRAWN_AMT;
	private double EAD_UNDRAWN_AMT;
	private double POST_CCF_CRM_EXPOSURE_AMT;
	private double POST_CRM_RWA_AMT;
	private double EXPOSURE_AMT;
	private double RWA_DENSITY;
	private double POST_CRM_RISK_WEIGHT;
	private double PD_FINAL;
	private double IRB_GROSS_EAD;
	private double IRB_ON_BAL_EAD;
	private double IRB_CCF;
	private double IRB_OFF_BAL_EAD;
	private double IRB_OFF_BAL_EAD_POST_CCF;
	private double IRB_NET_EAD;
	private double IRB_MAT;
	private double RWA_IRB;
	private double EXP_LOSS_IRB;
	private double RWA_DENSITY_IRB;
	private double FIRB_GROSS_EAD;
	private double FIRB_ON_BAL_EAD;
	private double FIRB_OFF_BAL_EAD;
	private double FIRB_OFF_BAL_EAD_POST_CCF;
	private double FIRB_CCF;
	private double FIRB_NET_EAD;
	private double FIRB_MAT;
	private double EFF_LGD;
	private double RWA_FIRB;
	private double RWA_DENSITY_FIRB;
	private double EXP_LOSS_FIRB;
	private String RW_METHOD;
	private String INT_EXT_RAT_MPG;
	private String PD_RANGE;
	private double NO_DF_OBG_PAST_PER;
	private double NO_PARTY_CD_PAST_PER;
}