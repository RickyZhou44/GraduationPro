package whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities;

/**
 * 用于计算车险的Fyc
 */
public class CarInsuranceFyc {
    private double premium;
    private int commissionRateIn;
    private int commissionRateOut;

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public int getCommissionRateIn() {
        return commissionRateIn;
    }

    public void setCommissionRateIn(int commissionRateIn) {
        this.commissionRateIn = commissionRateIn;
    }

    public int getCommissionRateOut() {
        return commissionRateOut;
    }

    public void setCommissionRateOut(int commissionRateOut) {
        this.commissionRateOut = commissionRateOut;
    }
}
