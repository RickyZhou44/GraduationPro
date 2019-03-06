package whu.iss.insurancesys.entity;

public class InsuranceType {
    private Integer insurId;

    private String insurerName;

    private String insuranceCname;

    private String insuranceSname;

    private String code;

    private String type;

    private Double account;

    private String unit;

    private Double premium;

    private String period;

    private String policyNo;

    public Integer getInsurId() {
        return insurId;
    }

    public void setInsurId(Integer insurId) {
        this.insurId = insurId;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName == null ? null : insurerName.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }
}