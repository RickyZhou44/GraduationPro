package whu.iss.insurancesys.entity.SettlementParamEntities;

/*
 * @Author SeanShe
 * @Date 3/23/2019 20:05
 * Notes:
 * */

import lombok.Data;

@Data
public class PersonPolicyDetail {

    private String policyNo;//订单号
    private double preReceivable=0.0;//应收保费
    private double paidPremium=0.0;//实收保费

    public PersonPolicyDetail(String policyNo){

        this.policyNo = policyNo;
        this.paidPremium = 0;
        this.preReceivable = 0;

    }

    public void addPaidPremium(double d){

        this.paidPremium += d;

    }

}
