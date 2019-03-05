package whu.iss.insurancesys.entity;


public class LifeInsurancePayRecord {

  private String policyNo;
  private java.sql.Timestamp checkInDate;
  private java.sql.Timestamp validDateSince;
  private java.sql.Timestamp issueDate;
  private java.sql.Timestamp payDate;


  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }


  public java.sql.Timestamp getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(java.sql.Timestamp checkInDate) {
    this.checkInDate = checkInDate;
  }


  public java.sql.Timestamp getValidDateSince() {
    return validDateSince;
  }

  public void setValidDateSince(java.sql.Timestamp validDateSince) {
    this.validDateSince = validDateSince;
  }


  public java.sql.Timestamp getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(java.sql.Timestamp issueDate) {
    this.issueDate = issueDate;
  }


  public java.sql.Timestamp getPayDate() {
    return payDate;
  }

  public void setPayDate(java.sql.Timestamp payDate) {
    this.payDate = payDate;
  }

}
