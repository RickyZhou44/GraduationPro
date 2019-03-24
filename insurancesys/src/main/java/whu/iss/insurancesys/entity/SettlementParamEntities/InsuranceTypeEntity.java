package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/23
 */
public class InsuranceTypeEntity {
    private String insurance_cname;//保险名字
    private String period;//年期交次
    private String common_year;//常用年期
    private double premium;//保费
    private String main_or_vice;//主约或附约
    private String policy_no;//保单号码
    private String unit;//单位
    private int year;//第几年
    private double rate;//费率
    private Date pay_date_start;//交费年起
    private Date validate_date_start;//计基开始日期

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getPay_date_start() {
        return pay_date_start;
    }

    public void setPay_date_start(Date pay_date_start) {
        this.pay_date_start = pay_date_start;
    }

    public Date getValidate_date_start() {
        return validate_date_start;
    }

    public void setValidate_date_start(Date validate_date_start) {
        this.validate_date_start = validate_date_start;
    }

    public String getInsurance_cname() {
        return insurance_cname;
    }

    public void setInsurance_cname(String insurance_cname) {
        this.insurance_cname = insurance_cname;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCommon_year() {
        return common_year;
    }

    public void setCommon_year(String common_year) {
        this.common_year = common_year;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getMain_or_vice() {
        return main_or_vice;
    }

    public void setMain_or_vice(String main_or_vice) {
        this.main_or_vice = main_or_vice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
