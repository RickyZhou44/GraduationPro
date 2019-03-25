package whu.iss.insurancesys.entity.SettlementParamEntities;

/*
 * @Author SeanShe
 * @Date 3/23/2019 20:55
 * Notes:
 * */

import java.util.Date;

public class PolicyDetail {

    private String policy_no;
    private String policy_type;
    private Date valid_date_since;
    private String name;
    private double account;
    private String period;
    private Date cash_date;
    private Date pay_date;
    private double preReceivable = 0.0;//应收保费
    private double paidPremium = 0.0;//实收保费

    public void addPaidPremium(double d){

        this.paidPremium += d;

    }

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public String getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public Date getValid_date_since() {
        return valid_date_since;
    }

    public void setValid_date_since(Date valid_date_since) {
        this.valid_date_since = valid_date_since;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Date getCash_date() {
        return cash_date;
    }

    public void setCash_date(Date cash_date) {
        this.cash_date = cash_date;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public double getPreReceivable() {
        return preReceivable;
    }

    public void setPreReceivable(double preReceivable) {
        this.preReceivable = preReceivable;
    }

    public double getPaidPremium() {
        return paidPremium;
    }

    public void setPaidPremium(double paidPremium) {
        this.paidPremium = paidPremium;
    }
    
}
