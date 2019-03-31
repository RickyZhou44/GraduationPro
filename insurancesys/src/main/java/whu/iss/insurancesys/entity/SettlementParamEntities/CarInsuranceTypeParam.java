package whu.iss.insurancesys.entity.SettlementParamEntities;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/27
 */
public class CarInsuranceTypeParam {
    private String policy_no;
    private double premium;
    private String insur_type_name;
    private double commission_rate_in;
    private double commission_rate_out;

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getInsur_type_name() {
        return insur_type_name;
    }

    public void setInsur_type_name(String insur_type_name) {
        this.insur_type_name = insur_type_name;
    }

    public double getCommission_rate_in() {
        return commission_rate_in;
    }

    public void setCommission_rate_in(double commission_rate_in) {
        this.commission_rate_in = commission_rate_in;
    }

    public double getCommission_rate_out() {
        return commission_rate_out;
    }

    public void setCommission_rate_out(double commission_rate_out) {
        this.commission_rate_out = commission_rate_out;
    }
}
