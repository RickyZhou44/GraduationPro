package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/17
 * 此类用于传输继续率保费的数据封装
 * 主要用于个人纬度的查询
 */
public class ContinueRateParam {
    private String unit=null;//单位
    private String rank=null;//职级
    private String idNum=null;//员工编号
    private String name=null;//姓名
    private double preReceivable=0.0;//应收保费
    private double paidPremium=0.0;//实收保费
    private double rate=0.0;
    private List<PersonPolicyDetail> details;//各个订单保费记录

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public ContinueRateParam() {
        unit=null;
        rank=null;
        idNum=null;
        name=null;
        preReceivable=0;
        paidPremium=0;
        details = new ArrayList<>();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addDetail(Map<String, PersonPolicyDetail> map){
        this.details.addAll(map.values());
    }

    public List<PersonPolicyDetail> getDetails(){
        return this.details;
    }
}
