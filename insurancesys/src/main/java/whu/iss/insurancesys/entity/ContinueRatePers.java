package whu.iss.insurancesys.entity;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/17 0017.
 */
public class ContinueRatePers {
    private String unit;//单位
    private String rank;//职级
    private String idNum;//员工编号
    private String name;
    private double preReceivable;//应收保费
    private double paidPremimu;//实收保费
    private double rateR13;

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

    public double getPaidPremimu() {
        return paidPremimu;
    }

    public void setPaidPremimu(double paidPremimu) {
        this.paidPremimu = paidPremimu;
    }

    public double getRateR13() {
        return rateR13;
    }

    public void setRateR13(double rateR13) {
        this.rateR13 = rateR13;
    }
}
