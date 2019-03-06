package whu.iss.insurancesys.entity;

import java.util.Date;

public class CarBasicInfo {
    private String licensePlateNo;

    private String braandModel;

    private String engineNo;

    private String frameNo;

    private String vehicleType;

    private String vehicleModel;

    private Integer seatNumber;

    private Integer tonNumber;

    private Integer vehicleDisplacement;

    private Integer power;

    private Date registrationDate;

    private Integer averageMileage;

    private String ownerName;

    private String carInsurMessage;

    private Double vehiclePrice;

    private Integer accidentNumber;

    private Boolean isImport;

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo == null ? null : licensePlateNo.trim();
    }

    public String getBraandModel() {
        return braandModel;
    }

    public void setBraandModel(String braandModel) {
        this.braandModel = braandModel == null ? null : braandModel.trim();
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo == null ? null : engineNo.trim();
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo == null ? null : frameNo.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel == null ? null : vehicleModel.trim();
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getTonNumber() {
        return tonNumber;
    }

    public void setTonNumber(Integer tonNumber) {
        this.tonNumber = tonNumber;
    }

    public Integer getVehicleDisplacement() {
        return vehicleDisplacement;
    }

    public void setVehicleDisplacement(Integer vehicleDisplacement) {
        this.vehicleDisplacement = vehicleDisplacement;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getAverageMileage() {
        return averageMileage;
    }

    public void setAverageMileage(Integer averageMileage) {
        this.averageMileage = averageMileage;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getCarInsurMessage() {
        return carInsurMessage;
    }

    public void setCarInsurMessage(String carInsurMessage) {
        this.carInsurMessage = carInsurMessage == null ? null : carInsurMessage.trim();
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Integer getAccidentNumber() {
        return accidentNumber;
    }

    public void setAccidentNumber(Integer accidentNumber) {
        this.accidentNumber = accidentNumber;
    }

    public Boolean getIsImport() {
        return isImport;
    }

    public void setIsImport(Boolean isImport) {
        this.isImport = isImport;
    }
}