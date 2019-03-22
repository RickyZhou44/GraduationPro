package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.sql.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/18
 */
//此类用于计算员工及机构
public class PreReceivableParam {
    private String chinese_name;
    private String policy_no;
    private String employee_no;
    private double premium;
    private String period;
    private String current_rank;
    private String branch_name;
    private Date pay_date;
    private Date valid_date_since;

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public String getChinese_name() {
        return chinese_name;
    }

    public void setChinese_name(String chinese_name) {
        this.chinese_name = chinese_name;
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

    public String getCurrent_rank() {
        return current_rank;
    }

    public void setCurrent_rank(String current_rank) {
        this.current_rank = current_rank;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public Date getValid_date_since() {
        return valid_date_since;
    }

    public void setValid_date_since(Date valid_date_since) {
        this.valid_date_since = valid_date_since;
    }
}
