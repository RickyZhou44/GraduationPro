package whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities;

/**
 * 用于计算寿险的fyc
 */
public class LifeInsuranceFyc {
    private double premium;
    private String period;

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
