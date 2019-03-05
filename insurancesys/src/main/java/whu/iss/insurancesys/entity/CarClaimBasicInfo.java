package whu.iss.insurancesys.entity;


public class CarClaimBasicInfo {

  private String claimNo;
  private String policyNo;
  private String insurCompanyName;
  private String reportId;
  private java.sql.Timestamp reportDate;
  private String taskType;
  private String surveyLocation;
  private String surveyPersonName;
  private long isSettled;
  private String licensePlateNo;
  private String bilingOfficerName;
  private String insuredName;
  private String riskProcess;


  public String getClaimNo() {
    return claimNo;
  }

  public void setClaimNo(String claimNo) {
    this.claimNo = claimNo;
  }


  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }


  public String getInsurCompanyName() {
    return insurCompanyName;
  }

  public void setInsurCompanyName(String insurCompanyName) {
    this.insurCompanyName = insurCompanyName;
  }


  public String getReportId() {
    return reportId;
  }

  public void setReportId(String reportId) {
    this.reportId = reportId;
  }


  public java.sql.Timestamp getReportDate() {
    return reportDate;
  }

  public void setReportDate(java.sql.Timestamp reportDate) {
    this.reportDate = reportDate;
  }


  public String getTaskType() {
    return taskType;
  }

  public void setTaskType(String taskType) {
    this.taskType = taskType;
  }


  public String getSurveyLocation() {
    return surveyLocation;
  }

  public void setSurveyLocation(String surveyLocation) {
    this.surveyLocation = surveyLocation;
  }


  public String getSurveyPersonName() {
    return surveyPersonName;
  }

  public void setSurveyPersonName(String surveyPersonName) {
    this.surveyPersonName = surveyPersonName;
  }


  public long getIsSettled() {
    return isSettled;
  }

  public void setIsSettled(long isSettled) {
    this.isSettled = isSettled;
  }


  public String getLicensePlateNo() {
    return licensePlateNo;
  }

  public void setLicensePlateNo(String licensePlateNo) {
    this.licensePlateNo = licensePlateNo;
  }


  public String getBilingOfficerName() {
    return bilingOfficerName;
  }

  public void setBilingOfficerName(String bilingOfficerName) {
    this.bilingOfficerName = bilingOfficerName;
  }


  public String getInsuredName() {
    return insuredName;
  }

  public void setInsuredName(String insuredName) {
    this.insuredName = insuredName;
  }


  public String getRiskProcess() {
    return riskProcess;
  }

  public void setRiskProcess(String riskProcess) {
    this.riskProcess = riskProcess;
  }

}
