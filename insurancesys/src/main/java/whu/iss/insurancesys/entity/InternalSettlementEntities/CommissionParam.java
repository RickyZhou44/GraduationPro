package whu.iss.insurancesys.entity.InternalSettlementEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
public class CommissionParam {
    private String branch;//分支机构
    private Date dateStart;//计佣开始
    private Date dateEnd;//计佣结束

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
