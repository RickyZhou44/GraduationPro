package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/18
 */
//此类用于分支机构的查询纬度数据封装
public class ContinueRateBranchParam {
    private Date date;
    private String unit;
    private double preReceivable;//应收保费
    private double paidPremium;//实收保费
    private double rate;
    private List<BranchPolicyDetail> details = new ArrayList<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<BranchPolicyDetail> getDetails() {
        return details;
    }

    public void addDetail(Map<String, BranchPolicyDetail> map){
        this.details.addAll(map.values());
    }
}
