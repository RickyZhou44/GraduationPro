package whu.iss.insurancesys.entity;

import java.util.Date;

public class InsuranceTypeInfo {
    private Integer insurId;

    private String company;

    private String insuranceCname;

    private String insuranceSname;

    private String code;

    private String mainOrVice;

    private String praramType;

    private String insuranceType;

    private Date startSaleTime;

    private Date stopSaleTime;

    private String remark;

    private String commonYear;

    public Integer getInsurId() {
        return insurId;
    }

    public void setInsurId(Integer insurId) {
        this.insurId = insurId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getInsuranceCname() {
        return insuranceCname;
    }

    public void setInsuranceCname(String insuranceCname) {
        this.insuranceCname = insuranceCname == null ? null : insuranceCname.trim();
    }

    public String getInsuranceSname() {
        return insuranceSname;
    }

    public void setInsuranceSname(String insuranceSname) {
        this.insuranceSname = insuranceSname == null ? null : insuranceSname.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMainOrVice() {
        return mainOrVice;
    }

    public void setMainOrVice(String mainOrVice) {
        this.mainOrVice = mainOrVice == null ? null : mainOrVice.trim();
    }

    public String getPraramType() {
        return praramType;
    }

    public void setPraramType(String praramType) {
        this.praramType = praramType == null ? null : praramType.trim();
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public Date getStartSaleTime() {
        return startSaleTime;
    }

    public void setStartSaleTime(Date startSaleTime) {
        this.startSaleTime = startSaleTime;
    }

    public Date getStopSaleTime() {
        return stopSaleTime;
    }

    public void setStopSaleTime(Date stopSaleTime) {
        this.stopSaleTime = stopSaleTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCommonYear() {
        return commonYear;
    }

    public void setCommonYear(String commonYear) {
        this.commonYear = commonYear == null ? null : commonYear.trim();
    }
}