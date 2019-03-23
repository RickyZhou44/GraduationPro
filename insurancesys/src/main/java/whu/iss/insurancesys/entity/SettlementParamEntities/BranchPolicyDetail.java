package whu.iss.insurancesys.entity.SettlementParamEntities;

/*
 * @Author SeanShe
 * @Date 3/23/2019 20:55
 * Notes:
 * */

import lombok.Data;

import java.util.Date;

@Data
public class BranchPolicyDetail {

    String policy_no;
    String policy_type;
    Date valid_date_since;
    String name;
    double account;
    String period;
    Date cash_date;
    Date pay_date;
    private double preReceivable = 0.0;//应收保费
    private double paidPremium = 0.0;//实收保费

    public void addPaidPremium(double d){

        this.paidPremium += d;

    }

}
