package whu.iss.insurancesys.entity;

import java.util.Date;

public class EmployeeUnitRank {
    private Integer employNo;

    private String branchName;

    private String department;

    private String currentRank;

    private String serviceType;

    private String introducerName;

    private String relationshipSuperiorName;

    private String administratorName;

    private String administrator2Name;

    private Date entryTime;

    private String contractNumber;

    private Date contractStarttime;

    private Date contractEndtime;

    public Integer getEmployNo() {
        return employNo;
    }

    public void setEmployNo(Integer employNo) {
        this.employNo = employNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(String currentRank) {
        this.currentRank = currentRank == null ? null : currentRank.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getIntroducerName() {
        return introducerName;
    }

    public void setIntroducerName(String introducerName) {
        this.introducerName = introducerName == null ? null : introducerName.trim();
    }

    public String getRelationshipSuperiorName() {
        return relationshipSuperiorName;
    }

    public void setRelationshipSuperiorName(String relationshipSuperiorName) {
        this.relationshipSuperiorName = relationshipSuperiorName == null ? null : relationshipSuperiorName.trim();
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName == null ? null : administratorName.trim();
    }

    public String getAdministrator2Name() {
        return administrator2Name;
    }

    public void setAdministrator2Name(String administrator2Name) {
        this.administrator2Name = administrator2Name == null ? null : administrator2Name.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public Date getContractStarttime() {
        return contractStarttime;
    }

    public void setContractStarttime(Date contractStarttime) {
        this.contractStarttime = contractStarttime;
    }

    public Date getContractEndtime() {
        return contractEndtime;
    }

    public void setContractEndtime(Date contractEndtime) {
        this.contractEndtime = contractEndtime;
    }
}