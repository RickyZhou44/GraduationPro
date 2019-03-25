package whu.iss.insurancesys.entity;

import java.util.Date;

/**
 * 动态晋升考核管理查询返回信息
 */
public class DynamicPromotionQueryResult {

    private String state;
    private long num;
    private String name;
    private String work;
    private Date startDate;
    private Date endDate;
    private String tableBranch;
    private String tableDept;
    private Date tableMonth;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTableBranch() {
        return tableBranch;
    }

    public void setTableBranch(String tableBranch) {
        this.tableBranch = tableBranch;
    }

    public String getTableDept() {
        return tableDept;
    }

    public void setTableDept(String tableDept) {
        this.tableDept = tableDept;
    }

    public Date getTableMonth() {
        return tableMonth;
    }

    public void setTableMonth(Date tableMonth) {
        this.tableMonth = tableMonth;
    }

}
