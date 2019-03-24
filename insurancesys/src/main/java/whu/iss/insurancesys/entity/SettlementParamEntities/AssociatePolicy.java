package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/24
 */
//用于存储客户关联保单
public class AssociatePolicy {
    private String insurer_name;
    private String policy_no;
    private String name;
    private Date valid_date_since;
    private String insurance_cname;
    private double premium;
    private String insured_id;
    private String code;
    private String common_year;

    public String getInsurer_name() {
        return insurer_name;
    }

    public void setInsurer_name(String insurer_name) {
        this.insurer_name = insurer_name;
    }

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getValid_date_since() {
        return valid_date_since;
    }

    public void setValid_date_since(Date valid_date_since) {
        this.valid_date_since = valid_date_since;
    }

    public String getInsurance_cname() {
        return insurance_cname;
    }

    public void setInsurance_cname(String insurance_cname) {
        this.insurance_cname = insurance_cname;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getInsured_id() {
        return insured_id;
    }

    public void setInsured_id(String insured_id) {
        this.insured_id = insured_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCommon_year() {
        return common_year;
    }

    public void setCommon_year(String common_year) {
        this.common_year = common_year;
    }
}
