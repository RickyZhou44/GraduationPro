package whu.iss.insurancesys.entity;

import java.util.Date;

public class LifeInsurancePayRecord {
    private String policyNo;

    private Date checkInDate;

    private Date validDateSince;

    private Date issueDate;

    private Date payDate;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
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
}