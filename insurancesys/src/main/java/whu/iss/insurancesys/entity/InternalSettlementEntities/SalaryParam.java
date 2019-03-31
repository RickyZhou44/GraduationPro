package whu.iss.insurancesys.entity.InternalSettlementEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
public class SalaryParam {
    private String contractor;//代理人
    private String branch;//分支机构
    private Date valid_date_start;//计佣起
    private Date valid_date_end;//计佣结束
    private double payPremium;//支项佣金

    public double getPayPremium() {
        return payPremium;
    }

    public void setPayPremium(double payPremium) {
        this.payPremium = payPremium;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Date getValid_date_start() {
        return valid_date_start;
    }

    public void setValid_date_start(Date valid_date_start) {
        this.valid_date_start = valid_date_start;
    }

    public Date getValid_date_end() {
        return valid_date_end;
    }

    public void setValid_date_end(Date valid_date_end) {
        this.valid_date_end = valid_date_end;
    }
}
