package whu.iss.insurancesys.entity.FeeRateEntities;

/*
 * @Author SeanShe
 * @Date 3/21/2019 15:50
 * Notes:
 * */

import java.util.Date;

public class CarInsuranceTypePlus {

    private Integer carInsurId;

    private String insurCompanyName;

    private String insurTypeName;

    private Double insurAmount;

    private Double premium;

    private Date insurStarttime;

    private Date insurEndtime;

    private Integer commissionRateIn;

    private Integer commissionRateOut;

    private String vehicleType;

    private String branchName;

    public Integer getCarInsurId() {
        return carInsurId;
    }

    public void setCarInsurId(Integer carInsurId) {
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

    public Double getInsurAmount() {
        return insurAmount;
    }

    public void setInsurAmount(Double insurAmount) {
        this.insurAmount = insurAmount;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Date getInsurStarttime() {
        return insurStarttime;
    }

    public void setInsurStarttime(Date insurStarttime) {
        this.insurStarttime = insurStarttime;
    }

    public Date getInsurEndtime() {
        return insurEndtime;
    }

    public void setInsurEndtime(Date insurEndtime) {
        this.insurEndtime = insurEndtime;
    }

    public Integer getCommissionRateIn() {
        return commissionRateIn;
    }

    public void setCommissionRateIn(Integer commissionRateIn) {
        this.commissionRateIn = commissionRateIn;
    }

    public Integer getCommissionRateOut() {
        return commissionRateOut;
    }

    public void setCommissionRateOut(Integer commissionRateOut) {
        this.commissionRateOut = commissionRateOut;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
