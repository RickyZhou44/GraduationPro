package whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities;

/**
 * 用于计算车险的Fyc
 */
public class CarInsuranceFyc {
    private String policyNo;
    private double premium;
    private double commissionRateIn;
    private double commissionRateOut;

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getCommissionRateIn() {
        return commissionRateIn;
    }

    public void setCommissionRateIn(double commissionRateIn) {
        this.commissionRateIn = commissionRateIn;
    }

    public double getCommissionRateOut() {
        return commissionRateOut;
    }

    public void setCommissionRateOut(double commissionRateOut) {
        this.commissionRateOut = commissionRateOut;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}
