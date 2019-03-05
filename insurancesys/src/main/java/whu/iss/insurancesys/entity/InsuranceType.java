package whu.iss.insurancesys.entity;

public class InsuranceType {

  private long insurId;
  private String insurerName;
  private String insuranceCname;
  private String insuranceSname;
  private String code;
  private String type;
  private double account;
  private String unit;
  private double premium;
  private String period;
  private String policyNo;


  public long getInsurId() {
    return insurId;
  }

  public void setInsurId(long insurId) {
    this.insurId = insurId;
  }


  public String getInsurerName() {
    return insurerName;
  }

  public void setInsurerName(String insurerName) {
    this.insurerName = insurerName;
  }


  public String getInsuranceCname() {
    return insuranceCname;
  }

  public void setInsuranceCname(String insuranceCname) {
    this.insuranceCname = insuranceCname;
  }


  public String getInsuranceSname() {
    return insuranceSname;
  }

  public void setInsuranceSname(String insuranceSname) {
    this.insuranceSname = insuranceSname;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public double getAccount() {
    return account;
  }

  public void setAccount(double account) {
    this.account = account;
  }


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  public double getPremium() {
    return premium;
  }

  public void setPremium(double premium) {
    this.premium = premium;
  }


  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }


  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }

}
