package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/23
 */
public class ExternalSettleEntity {
    private Date validate_date_start;//生效日期
    private Date pay_date;//支付日期
    private double premium;//保费
    private String policy_no;//保单号
    private String check_commission_status;//核佣状态
    private String policy_type;//保单状态
    private String agent_type;//承揽状态
    private String period;//年期交次
    private String employee_no;//员工编号
    private String chinese_name;//中文名字
    private String insurer_name;//保险公司名字

    public String getInsurer_name() {
        return insurer_name;
    }

    public void setInsurer_name(String insurer_name) {
        this.insurer_name = insurer_name;
    }

    public Date getValidate_date_start() {
        return validate_date_start;
    }

    public void setValidate_date_start(Date validate_date_start) {
        this.validate_date_start = validate_date_start;
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

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public String getCheck_commission_status() {
        return check_commission_status;
    }

    public void setCheck_commission_status(String check_commission_status) {
        this.check_commission_status = check_commission_status;
    }

    public String getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public String getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getChinese_name() {
        return chinese_name;
    }

    public void setChinese_name(String chinese_name) {
        this.chinese_name = chinese_name;
    }
}
