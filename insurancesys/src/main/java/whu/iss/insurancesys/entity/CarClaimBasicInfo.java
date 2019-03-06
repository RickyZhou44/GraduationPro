package whu.iss.insurancesys.entity;

import java.util.Date;

public class CarClaimBasicInfo {
    private String claimNo;

    private String policyNo;

    private String insurCompanyName;

    private String reportId;

    private Date reportDate;

    private String taskType;

    private String surveyLocation;

    private String surveyPersonName;

    private Boolean isSettled;

    private String licensePlateNo;

    private String bilingOfficerName;

    private String insuredName;

    private String riskProcess;

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo == null ? null : claimNo.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getInsurCompanyName() {
        return insurCompanyName;
    }

    public void setInsurCompanyName(String insurCompanyName) {
        this.insurCompanyName = insurCompanyName == null ? null : insurCompanyName.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getSurveyLocation() {
        return surveyLocation;
    }

    public void setSurveyLocation(String surveyLocation) {
        this.surveyLocation = surveyLocation == null ? null : surveyLocation.trim();
    }

    public String getSurveyPersonName() {
        return surveyPersonName;
    }

    public void setSurveyPersonName(String surveyPersonName) {
        this.surveyPersonName = surveyPersonName == null ? null : surveyPersonName.trim();
    }

    public Boolean getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(Boolean isSettled) {
        this.isSettled = isSettled;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo == null ? null : licensePlateNo.trim();
    }

    public String getBilingOfficerName() {
        return bilingOfficerName;
    }

    public void setBilingOfficerName(String bilingOfficerName) {
        this.bilingOfficerName = bilingOfficerName == null ? null : bilingOfficerName.trim();
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    public String getRiskProcess() {
        return riskProcess;
    }

    public void setRiskProcess(String riskProcess) {
        this.riskProcess = riskProcess == null ? null : riskProcess.trim();
    }
}