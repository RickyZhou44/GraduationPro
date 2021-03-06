package whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities;

import java.util.Date;
import java.util.List;

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
    private Date baseMonth;
    private String period;
    private List<CarInsuranceCheckDetail> carInsuranceCheckDetails;
    private List<LifeInsuranceCheckDetail> lifeInsuranceCheckDetails;

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

    public List<CarInsuranceCheckDetail> getCarInsuranceCheckDetails() {
        return carInsuranceCheckDetails;
    }

    public void setCarInsuranceCheckDetails(List<CarInsuranceCheckDetail> carInsuranceCheckDetails) {
        this.carInsuranceCheckDetails = carInsuranceCheckDetails;
    }

    public List<LifeInsuranceCheckDetail> getLifeInsuranceCheckDetails() {
        return lifeInsuranceCheckDetails;
    }

    public void setLifeInsuranceCheckDetails(List<LifeInsuranceCheckDetail> lifeInsuranceCheckDetails) {
        this.lifeInsuranceCheckDetails = lifeInsuranceCheckDetails;
    }

    public Date getBaseMonth() {
        return baseMonth;
    }

    public void setBaseMonth(Date baseMonth) {
        this.baseMonth = baseMonth;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
