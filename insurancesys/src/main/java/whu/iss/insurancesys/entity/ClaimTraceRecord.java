package whu.iss.insurancesys.entity;

import java.util.Date;

public class ClaimTraceRecord {
    private String claimNo;

    private String insurCompanyName;

    private Date traceTime;

    private String claimStatus;

    private String processPersonName;

    private Double performanceExpenditure;

    private Double estimatedCost;

    private Boolean isInvoice;

    private String attachment;

    private String processing;

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo == null ? null : claimNo.trim();
    }

    public String getInsurCompanyName() {
        return insurCompanyName;
    }

    public void setInsurCompanyName(String insurCompanyName) {
        this.insurCompanyName = insurCompanyName == null ? null : insurCompanyName.trim();
    }

    public Date getTraceTime() {
        return traceTime;
    }

    public void setTraceTime(Date traceTime) {
        this.traceTime = traceTime;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus == null ? null : claimStatus.trim();
    }

    public String getProcessPersonName() {
        return processPersonName;
    }

    public void setProcessPersonName(String processPersonName) {
        this.processPersonName = processPersonName == null ? null : processPersonName.trim();
    }

    public Double getPerformanceExpenditure() {
        return performanceExpenditure;
    }

    public void setPerformanceExpenditure(Double performanceExpenditure) {
        this.performanceExpenditure = performanceExpenditure;
    }

    public Double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Boolean getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Boolean isInvoice) {
        this.isInvoice = isInvoice;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing == null ? null : processing.trim();
    }
}