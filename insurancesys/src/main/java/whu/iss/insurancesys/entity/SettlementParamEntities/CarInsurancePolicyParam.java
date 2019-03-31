package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/26
 */
//存储从数据库中提取出来的car_insurance_policy的数据
public class CarInsurancePolicyParam {
    private String policy_no;
    private String insurer_car_name;
    private Date biling_date;
    private Date start_insurance_date;
    private String policy_holder_car_id;
    private String insured_car_id;
    private String check_commission_status;
    private String check_distribution_status;

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public String getInsurer_car_name() {
        return insurer_car_name;
    }

    public void setInsurer_car_name(String insurer_car_name) {
        this.insurer_car_name = insurer_car_name;
    }

    public Date getBiling_date() {
        return biling_date;
    }

    public void setBiling_date(Date biling_date) {
        this.biling_date = biling_date;
    }

    public Date getStart_insurance_date() {
        return start_insurance_date;
    }

    public void setStart_insurance_date(Date start_insurance_date) {
        this.start_insurance_date = start_insurance_date;
    }

    public String getPolicy_holder_car_id() {
        return policy_holder_car_id;
    }

    public void setPolicy_holder_car_id(String policy_holder_car_id) {
        this.policy_holder_car_id = policy_holder_car_id;
    }

    public String getInsured_car_id() {
        return insured_car_id;
    }

    public void setInsured_car_id(String insured_car_id) {
        this.insured_car_id = insured_car_id;
    }

    public String getCheck_commission_status() {
        return check_commission_status;
    }

    public void setCheck_commission_status(String check_commission_status) {
        this.check_commission_status = check_commission_status;
    }

    public String getCheck_distribution_status() {
        return check_distribution_status;
    }

    public void setCheck_distribution_status(String check_distribution_status) {
        this.check_distribution_status = check_distribution_status;
    }
}
