package whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities;

import java.util.Date;

/**
 * 个人绩效预警查核结果返回
 */
public class PersonalPerformanceWarningQueryResult {
    private String name;
    private long employeeNo;
    private String branch;
    private String department;
    private String rank;
    private Date contractStartTime;
    private Date rankValid;
    private String introducerName;
    private String relationship;
    private CarInsuranceCheckDetail carInsuranceCheckDetail;
    private LifeInsuranceCheckDetail lifeInsuranceCheckDetail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public Date getRankValid() {
        return rankValid;
    }

    public void setRankValid(Date rankValid) {
        this.rankValid = rankValid;
    }

    public String getIntroducerName() {
        return introducerName;
    }

    public void setIntroducerName(String introducerName) {
        this.introducerName = introducerName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

}
