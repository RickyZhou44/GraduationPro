package whu.iss.insurancesys.entity;

import java.util.Date;

public class EmployeeWorkHistory {
    private Integer employeeNo;

    private String branchName;

    private String rankName;

    private Date workStarttime;

    private Date workEndtime;

    private String rankContent;

    private String attachment;

    private String note;

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public Date getWorkStarttime() {
        return workStarttime;
    }

    public void setWorkStarttime(Date workStarttime) {
        this.workStarttime = workStarttime;
    }

    public Date getWorkEndtime() {
        return workEndtime;
    }

    public void setWorkEndtime(Date workEndtime) {
        this.workEndtime = workEndtime;
    }

    public String getRankContent() {
        return rankContent;
    }

    public void setRankContent(String rankContent) {
        this.rankContent = rankContent == null ? null : rankContent.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}