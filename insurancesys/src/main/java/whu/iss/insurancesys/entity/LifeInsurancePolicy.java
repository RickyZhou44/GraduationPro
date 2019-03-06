package whu.iss.insurancesys.entity;

import java.util.Date;

public class LifeInsurancePolicy {
    private String policyNo;

    private String relatedNoType;

    private String relatedNoName;

    private Date checkInDate;

    private Date validDateSince;

    private Date issueDate;

    private Date payDate;

    private Date cashDate;

    private Date receiptBackTime;

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
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getRelatedNoType() {
        return relatedNoType;
    }

    public void setRelatedNoType(String relatedNoType) {
        this.relatedNoType = relatedNoType == null ? null : relatedNoType.trim();
    }

    public String getRelatedNoName() {
        return relatedNoName;
    }

    public void setRelatedNoName(String relatedNoName) {
        this.relatedNoName = relatedNoName == null ? null : relatedNoName.trim();
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getValidDateSince() {
        return validDateSince;
    }

    public void setValidDateSince(Date validDateSince) {
        this.validDateSince = validDateSince;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getCashDate() {
        return cashDate;
    }

    public void setCashDate(Date cashDate) {
        this.cashDate = cashDate;
    }

    public Date getReceiptBackTime() {
        return receiptBackTime;
    }

    public void setReceiptBackTime(Date receiptBackTime) {
        this.receiptBackTime = receiptBackTime;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType == null ? null : policyType.trim();
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType == null ? null : agentType.trim();
    }

    public String getIntermediaQualiCerti() {
        return intermediaQualiCerti;
    }

    public void setIntermediaQualiCerti(String intermediaQualiCerti) {
        this.intermediaQualiCerti = intermediaQualiCerti == null ? null : intermediaQualiCerti.trim();
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        this.policyHolderId = policyHolderId == null ? null : policyHolderId.trim();
    }

    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId == null ? null : insuredId.trim();
    }
}