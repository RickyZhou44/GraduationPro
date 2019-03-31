package whu.iss.insurancesys.entity.FeeRateEntities;

/*
 * @Author SeanShe
 * @Date 3/25/2019 14:00
 * Notes:
 * */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsurTypeInfoPlus {

    private int insurId;

    private String company;

    private String insuranceCname;

    private String insuranceSname;

    private String code;

    private String mainOrVice;

    private String paramType;

    private String insuranceType;

    private java.util.Date startSaleTime;

    private java.util.Date stopSaleTime;

    private String remark;

    private String commonYear;

    private String feeRateParam;

    private List<Double> rates;

    public InsurTypeInfoPlus(InsuranceTypeInfo insuranceTypeInfo, String feeRateParam){
        this.insurId = insuranceTypeInfo.getInsurId();
        this.company = insuranceTypeInfo.getCompany();
        this.insuranceCname = insuranceTypeInfo.getInsuranceCname();
        this.insuranceSname = insuranceTypeInfo.getInsuranceSname();
        this.code = insuranceTypeInfo.getCode();
        this.mainOrVice = insuranceTypeInfo.getMainOrVice();
        this.paramType = insuranceTypeInfo.getParamType();
        this.insuranceType = insuranceTypeInfo.getInsuranceType();
        this.startSaleTime = insuranceTypeInfo.getStartSaleTime();
        this.stopSaleTime = insuranceTypeInfo.getStopSaleTime();
        this.remark = insuranceTypeInfo.getRemark();
        this.commonYear = insuranceTypeInfo.getCommonYear();
        this.feeRateParam = feeRateParam;
        rates = new ArrayList<>();
    }

    public int getInsurId() {
        return insurId;
    }

    public void setInsurId(int insurId) {
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

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
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
        this.remark = remark;
    }

    public String getCommonYear() {
        return commonYear;
    }

    public void setCommonYear(String commonYear) {
        this.commonYear = commonYear;
    }

    public String getFeeRateParam() {
        return feeRateParam;
    }

    public void setFeeRateParam(String feeRateParam) {
        this.feeRateParam = feeRateParam;
    }

    public List<Double> getRates() {
        return rates;
    }

    public void addRate(double rate) {
        this.rates.add(rate);
    }
}
