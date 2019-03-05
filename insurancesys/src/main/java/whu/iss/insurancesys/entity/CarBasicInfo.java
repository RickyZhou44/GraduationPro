package whu.iss.insurancesys.entity;


public class CarBasicInfo {

  private String licensePlateNo;
  private String braandModel;
  private String engineNo;
  private String frameNo;
  private String vehicleType;
  private String vehicleModel;
  private long seatNumber;
  private long tonNumber;
  private long vehicleDisplacement;
  private long power;
  private java.sql.Date registrationDate;
  private long averageMileage;
  private String ownerName;
  private String carInsurMessage;
  private double vehiclePrice;
  private long accidentNumber;
  private long isImport;


  public String getLicensePlateNo() {
    return licensePlateNo;
  }

  public void setLicensePlateNo(String licensePlateNo) {
    this.licensePlateNo = licensePlateNo;
  }


  public String getBraandModel() {
    return braandModel;
  }

  public void setBraandModel(String braandModel) {
    this.braandModel = braandModel;
  }


  public String getEngineNo() {
    return engineNo;
  }

  public void setEngineNo(String engineNo) {
    this.engineNo = engineNo;
  }


  public String getFrameNo() {
    return frameNo;
  }

  public void setFrameNo(String frameNo) {
    this.frameNo = frameNo;
  }


  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }


  public String getVehicleModel() {
    return vehicleModel;
  }

  public void setVehicleModel(String vehicleModel) {
    this.vehicleModel = vehicleModel;
  }


  public long getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(long seatNumber) {
    this.seatNumber = seatNumber;
  }


  public long getTonNumber() {
    return tonNumber;
  }

  public void setTonNumber(long tonNumber) {
    this.tonNumber = tonNumber;
  }


  public long getVehicleDisplacement() {
    return vehicleDisplacement;
  }

  public void setVehicleDisplacement(long vehicleDisplacement) {
    this.vehicleDisplacement = vehicleDisplacement;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public java.sql.Date getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(java.sql.Date registrationDate) {
    this.registrationDate = registrationDate;
  }


  public long getAverageMileage() {
    return averageMileage;
  }

  public void setAverageMileage(long averageMileage) {
    this.averageMileage = averageMileage;
  }


  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }


  public String getCarInsurMessage() {
    return carInsurMessage;
  }

  public void setCarInsurMessage(String carInsurMessage) {
    this.carInsurMessage = carInsurMessage;
  }


  public double getVehiclePrice() {
    return vehiclePrice;
  }

  public void setVehiclePrice(double vehiclePrice) {
    this.vehiclePrice = vehiclePrice;
  }


  public long getAccidentNumber() {
    return accidentNumber;
  }

  public void setAccidentNumber(long accidentNumber) {
    this.accidentNumber = accidentNumber;
  }


  public long getIsImport() {
    return isImport;
  }

  public void setIsImport(long isImport) {
    this.isImport = isImport;
  }

}
