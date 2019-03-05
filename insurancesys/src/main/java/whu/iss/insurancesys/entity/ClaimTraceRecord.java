package whu.iss.insurancesys.entity;


public class ClaimTraceRecord {

  private String claimNo;
  private String insurCompanyName;
  private java.sql.Timestamp traceTime;
  private String claimStatus;
  private String processPersonName;
  private double performanceExpenditure;
  private double estimatedCost;
  private long isInvoice;
  private String processing;
  private String attachment;


  public String getClaimNo() {
    return claimNo;
  }

  public void setClaimNo(String claimNo) {
    this.claimNo = claimNo;
  }


  public String getInsurCompanyName() {
    return insurCompanyName;
  }

  public void setInsurCompanyName(String insurCompanyName) {
    this.insurCompanyName = insurCompanyName;
  }


  public java.sql.Timestamp getTraceTime() {
    return traceTime;
  }

  public void setTraceTime(java.sql.Timestamp traceTime) {
    this.traceTime = traceTime;
  }


  public String getClaimStatus() {
    return claimStatus;
  }

  public void setClaimStatus(String claimStatus) {
    this.claimStatus = claimStatus;
  }


  public String getProcessPersonName() {
    return processPersonName;
  }

  public void setProcessPersonName(String processPersonName) {
    this.processPersonName = processPersonName;
  }


  public double getPerformanceExpenditure() {
    return performanceExpenditure;
  }

  public void setPerformanceExpenditure(double performanceExpenditure) {
    this.performanceExpenditure = performanceExpenditure;
  }


  public double getEstimatedCost() {
    return estimatedCost;
  }

  public void setEstimatedCost(double estimatedCost) {
    this.estimatedCost = estimatedCost;
  }


  public long getIsInvoice() {
    return isInvoice;
  }

  public void setIsInvoice(long isInvoice) {
    this.isInvoice = isInvoice;
  }


  public String getProcessing() {
    return processing;
  }

  public void setProcessing(String processing) {
    this.processing = processing;
  }


  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }

}
