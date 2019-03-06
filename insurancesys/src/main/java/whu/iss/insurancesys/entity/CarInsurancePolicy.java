package whu.iss.insurancesys.entity;

import java.util.Date;

public class CarInsurancePolicy {
    private String policyNo;

    private String policyType;

    private String otherNo;

    private String insurerCarName;

    private Date checkInDate;

    private Date startInsuranceDate;

    private String policyState;

    private String bilingOfficerName;

    private Date bilingDate;

    private Date payDateCar;

    private String payWay;

    private String checkCommissionStatus;

    private String checkDistributionStatus;

    private String policyHolderCarId;

    private String insuredCarId;

    private String businessName;

    private String businessPhone;

    private String businessAccount;

    private String memo;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType == null ? null : policyType.trim();
    }

    public String getOtherNo() {
        return otherNo;
    }

    public void setOtherNo(String otherNo) {
        this.otherNo = otherNo == null ? null : otherNo.trim();
    }

    public String getInsurerCarName() {
        return insurerCarName;
    }

    public void setInsurerCarName(String insurerCarName) {
        this.insurerCarName = insurerCarName == null ? null : insurerCarName.trim();
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getStartInsuranceDate() {
        return startInsuranceDate;
    }

    public void setStartInsuranceDate(Date startInsuranceDate) {
        this.startInsuranceDate = startInsuranceDate;
    }

    public String getPolicyState() {
        return policyState;
    }

    public void setPolicyState(String policyState) {
        this.policyState = policyState == null ? null : policyState.trim();
    }

    public String getBilingOfficerName() {
        return bilingOfficerName;
    }

    public void setBilingOfficerName(String bilingOfficerName) {
        this.bilingOfficerName = bilingOfficerName == null ? null : bilingOfficerName.trim();
    }

    public Date getBilingDate() {
        return bilingDate;
    }

    public void setBilingDate(Date bilingDate) {
        this.bilingDate = bilingDate;
    }

    public Date getPayDateCar() {
        return payDateCar;
    }

    public void setPayDateCar(Date payDateCar) {
        this.payDateCar = payDateCar;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getCheckCommissionStatus() {
        return checkCommissionStatus;
    }

    public void setCheckCommissionStatus(String checkCommissionStatus) {
        this.checkCommissionStatus = checkCommissionStatus == null ? null : checkCommissionStatus.trim();
    }

    public String getCheckDistributionStatus() {
        return checkDistributionStatus;
    }

    public void setCheckDistributionStatus(String checkDistributionStatus) {
        this.checkDistributionStatus = checkDistributionStatus == null ? null : checkDistributionStatus.trim();
    }

    public String getPolicyHolderCarId() {
        return policyHolderCarId;
    }

    public void setPolicyHolderCarId(String policyHolderCarId) {
        this.policyHolderCarId = policyHolderCarId == null ? null : policyHolderCarId.trim();
    }

    public String getInsuredCarId() {
        return insuredCarId;
    }

    public void setInsuredCarId(String insuredCarId) {
        this.insuredCarId = insuredCarId == null ? null : insuredCarId.trim();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone == null ? null : businessPhone.trim();
    }

    public String getBusinessAccount() {
        return businessAccount;
    }

    public void setBusinessAccount(String businessAccount) {
        this.businessAccount = businessAccount == null ? null : businessAccount.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}