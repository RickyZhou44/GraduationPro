package whu.iss.insurancesys.entity;

public class LifeInsurancePolicy {

  private String policyNo;
  private String relatedNoType;
  private String relatedNoName;
  private java.sql.Timestamp checkInDate;
  private java.sql.Timestamp validDateSince;
  private java.sql.Timestamp issueDate;
  private java.sql.Timestamp payDate;
  private java.sql.Timestamp cashDate;
  private java.sql.Timestamp receiptBackTime;
  private String payMode;
  private String payWay;
  private String policyType;
  private String agentType;
  private String intermediaQualiCerti;
  private String policyHolderId;
  private String insuredId;


  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }


  public String getRelatedNoType() {
    return relatedNoType;
  }

  public void setRelatedNoType(String relatedNoType) {
    this.relatedNoType = relatedNoType;
  }


  public String getRelatedNoName() {
    return relatedNoName;
  }

  public void setRelatedNoName(String relatedNoName) {
    this.relatedNoName = relatedNoName;
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


  public java.sql.Timestamp getCashDate() {
    return cashDate;
  }

  public void setCashDate(java.sql.Timestamp cashDate) {
    this.cashDate = cashDate;
  }


  public java.sql.Timestamp getReceiptBackTime() {
    return receiptBackTime;
  }

  public void setReceiptBackTime(java.sql.Timestamp receiptBackTime) {
    this.receiptBackTime = receiptBackTime;
  }


  public String getPayMode() {
    return payMode;
  }

  public void setPayMode(String payMode) {
    this.payMode = payMode;
  }


  public String getPayWay() {
    return payWay;
  }

  public void setPayWay(String payWay) {
    this.payWay = payWay;
  }


  public String getPolicyType() {
    return policyType;
  }

  public void setPolicyType(String policyType) {
    this.policyType = policyType;
  }


  public String getAgentType() {
    return agentType;
  }

  public void setAgentType(String agentType) {
    this.agentType = agentType;
  }


  public String getIntermediaQualiCerti() {
    return intermediaQualiCerti;
  }

  public void setIntermediaQualiCerti(String intermediaQualiCerti) {
    this.intermediaQualiCerti = intermediaQualiCerti;
  }


  public String getPolicyHolderId() {
    return policyHolderId;
  }

  public void setPolicyHolderId(String policyHolderId) {
    this.policyHolderId = policyHolderId;
  }


  public String getInsuredId() {
    return insuredId;
  }

  public void setInsuredId(String insuredId) {
    this.insuredId = insuredId;
  }

}
