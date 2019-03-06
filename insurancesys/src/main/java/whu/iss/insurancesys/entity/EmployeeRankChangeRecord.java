package whu.iss.insurancesys.entity;

import java.util.Date;

public class EmployeeRankChangeRecord {
    private Integer rankChangeNo;

    private Integer employeeNo;

    private String changeReason;

    private String branchName;

    private String departmentName;

    private String rankName;

    private Date rankEffectiveStarttime;

    private Date rankEffectiveEndtime;

    private String introducerName;

    private String relationshipSuperiorName;

    private String administratorName;

    private String administrator2Name;

    private String note;

    public Integer getRankChangeNo() {
        return rankChangeNo;
    }

    public void setRankChangeNo(Integer rankChangeNo) {
        this.rankChangeNo = rankChangeNo;
    }

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason == null ? null : changeReason.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public Date getRankEffectiveStarttime() {
        return rankEffectiveStarttime;
    }

    public void setRankEffectiveStarttime(Date rankEffectiveStarttime) {
        this.rankEffectiveStarttime = rankEffectiveStarttime;
    }

    public Date getRankEffectiveEndtime() {
        return rankEffectiveEndtime;
    }

    public void setRankEffectiveEndtime(Date rankEffectiveEndtime) {
        this.rankEffectiveEndtime = rankEffectiveEndtime;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}