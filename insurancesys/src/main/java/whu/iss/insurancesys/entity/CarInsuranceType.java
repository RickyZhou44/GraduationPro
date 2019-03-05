package whu.iss.insurancesys.entity;


public class CarInsuranceType {

  private long carInsurId;
  private String insurCompanyName;
  private String insurTypeName;
  private double insurAmount;
  private double premium;
  private java.sql.Timestamp insurStarttime;
  private java.sql.Timestamp insurEndtime;
  private long commissionRateIn;
  private long commissionRateOut;


  public long getCarInsurId() {
    return carInsurId;
  }

  public void setCarInsurId(long carInsurId) {
    this.carInsurId = carInsurId;
  }


  public String getInsurCompanyName() {
    return insurCompanyName;
  }

  public void setInsurCompanyName(String insurCompanyName) {
    this.insurCompanyName = insurCompanyName;
  }


  public String getInsurTypeName() {
    return insurTypeName;
  }

  public void setInsurTypeName(String insurTypeName) {
    this.insurTypeName = insurTypeName;
  }


  public double getInsurAmount() {
    return insurAmount;
  }

  public void setInsurAmount(double insurAmount) {
    this.insurAmount = insurAmount;
  }


  public double getPremium() {
    return premium;
  }

  public void setPremium(double premium) {
    this.premium = premium;
  }


  public java.sql.Timestamp getInsurStarttime() {
    return insurStarttime;
  }

  public void setInsurStarttime(java.sql.Timestamp insurStarttime) {
    this.insurStarttime = insurStarttime;
  }


  public java.sql.Timestamp getInsurEndtime() {
    return insurEndtime;
  }

  public void setInsurEndtime(java.sql.Timestamp insurEndtime) {
    this.insurEndtime = insurEndtime;
  }


  public long getCommissionRateIn() {
    return commissionRateIn;
  }

  public void setCommissionRateIn(long commissionRateIn) {
    this.commissionRateIn = commissionRateIn;
  }


  public long getCommissionRateOut() {
    return commissionRateOut;
  }

  public void setCommissionRateOut(long commissionRateOut) {
    this.commissionRateOut = commissionRateOut;
  }

}
