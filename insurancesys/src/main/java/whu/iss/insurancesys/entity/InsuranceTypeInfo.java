package whu.iss.insurancesys.entity;


public class InsuranceTypeInfo {

  private long insurId;
  private String company;
  private String insuranceCname;
  private String insuranceSname;
  private String code;
  private String mainOrVice;
  private String praramType;
  private String insuranceType;
  private java.sql.Timestamp startSaleTime;
  private java.sql.Timestamp stopSaleTime;
  private String remark;
  private String commonYear;


  public long getInsurId() {
    return insurId;
  }

  public void setInsurId(long insurId) {
    this.insurId = insurId;
  }


  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
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


  public String getMainOrVice() {
    return mainOrVice;
  }

  public void setMainOrVice(String mainOrVice) {
    this.mainOrVice = mainOrVice;
  }


  public String getPraramType() {
    return praramType;
  }

  public void setPraramType(String praramType) {
    this.praramType = praramType;
  }


  public String getInsuranceType() {
    return insuranceType;
  }

  public void setInsuranceType(String insuranceType) {
    this.insuranceType = insuranceType;
  }


  public java.sql.Timestamp getStartSaleTime() {
    return startSaleTime;
  }

  public void setStartSaleTime(java.sql.Timestamp startSaleTime) {
    this.startSaleTime = startSaleTime;
  }


  public java.sql.Timestamp getStopSaleTime() {
    return stopSaleTime;
  }

  public void setStopSaleTime(java.sql.Timestamp stopSaleTime) {
    this.stopSaleTime = stopSaleTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getCommonYear() {
    return commonYear;
  }

  public void setCommonYear(String commonYear) {
    this.commonYear = commonYear;
  }

}
