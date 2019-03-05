package whu.iss.insurancesys.entity;

public class ClientVehicle {

  private long id;
  private String certfId;
  private String licensePlateNo;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCertfId() {
    return certfId;
  }

  public void setCertfId(String certfId) {
    this.certfId = certfId;
  }


  public String getLicensePlateNo() {
    return licensePlateNo;
  }

  public void setLicensePlateNo(String licensePlateNo) {
    this.licensePlateNo = licensePlateNo;
  }

}
