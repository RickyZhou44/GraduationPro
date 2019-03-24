package whu.iss.insurancesys.entity.SettlementParamEntities;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/20
 */
public class InsuranceParam {
    private String insuranceName;
    private String yearTimes;
    private String payYear;//缴费年期
    private double premium;//保费
    private double stdPremium;//标准保费
    private double firstYearPre;//首年
    private double secYearPre;//续年
    private double sale;//销售
    private double service;//服务
    private double ffyc;//首佣fyc
    private double sfyc;//续佣fyc
    private double exStdPremium;//内部标保
    private double fPremium;//财佣
    private String mainVType;

    public String getMainVType() {
        return mainVType;
    }

    public void setMainVType(String mainVType) {
        this.mainVType = mainVType;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getYearTimes() {
        return yearTimes;
    }

    public void setYearTimes(String yearTimes) {
        this.yearTimes = yearTimes;
    }

    public String getPayYear() {
        return payYear;
    }

    public void setPayYear(String payYear) {
        this.payYear = payYear;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getStdPremium() {
        return stdPremium;
    }

    public void setStdPremium(double stdPremium) {
        this.stdPremium = stdPremium;
    }

    public double getFirstYearPre() {
        return firstYearPre;
    }

    public void setFirstYearPre(double firstYearPre) {
        this.firstYearPre = firstYearPre;
    }

    public double getSecYearPre() {
        return secYearPre;
    }

    public void setSecYearPre(double secYearPre) {
        this.secYearPre = secYearPre;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getFfyc() {
        return ffyc;
    }

    public void setFfyc(double ffyc) {
        this.ffyc = ffyc;
    }

    public double getSfyc() {
        return sfyc;
    }

    public void setSfyc(double sfyc) {
        this.sfyc = sfyc;
    }

    public double getExStdPremium() {
        return exStdPremium;
    }

    public void setExStdPremium(double exStdPremium) {
        this.exStdPremium = exStdPremium;
    }

    public double getfPremium() {
        return fPremium;
    }

    public void setfPremium(double fPremium) {
        this.fPremium = fPremium;
    }
}
