package whu.iss.insurancesys.entity;

public class SettleAccountParam {

  private long insurId;
  private long year;
  private double rate;
  private java.sql.Timestamp payDateStart;
  private java.sql.Timestamp payDateEnd;
  private java.sql.Timestamp validateDateStart;
  private java.sql.Timestamp validateDateEnd;


  public long getInsurId() {
    return insurId;
  }

  public void setInsurId(long insurId) {
    this.insurId = insurId;
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }


  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }


  public java.sql.Timestamp getPayDateStart() {
    return payDateStart;
  }

  public void setPayDateStart(java.sql.Timestamp payDateStart) {
    this.payDateStart = payDateStart;
  }


  public java.sql.Timestamp getPayDateEnd() {
    return payDateEnd;
  }

  public void setPayDateEnd(java.sql.Timestamp payDateEnd) {
    this.payDateEnd = payDateEnd;
  }


  public java.sql.Timestamp getValidateDateStart() {
    return validateDateStart;
  }

  public void setValidateDateStart(java.sql.Timestamp validateDateStart) {
    this.validateDateStart = validateDateStart;
  }


  public java.sql.Timestamp getValidateDateEnd() {
    return validateDateEnd;
  }

  public void setValidateDateEnd(java.sql.Timestamp validateDateEnd) {
    this.validateDateEnd = validateDateEnd;
  }

}
