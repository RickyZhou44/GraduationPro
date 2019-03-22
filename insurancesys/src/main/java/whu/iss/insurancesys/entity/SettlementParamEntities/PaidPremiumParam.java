package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/18
 */
//此类用于计算员工及机构继续率实收保费
public class PaidPremiumParam {
    private String policy_no;
    private String employee_no;
    private Date pay_date;
    private double premium;
    private String branch_name;

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }
}
