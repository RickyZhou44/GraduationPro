package whu.iss.insurancesys.entity;


public class EmployeeWorkHistory {

  private long employeeNo;
  private String branchName;
  private String rankName;
  private java.sql.Timestamp workStarttime;
  private java.sql.Timestamp workEndtime;
  private String rankContent;
  private String attachment;
  private String note;


  public long getEmployeeNo() {
    return employeeNo;
  }

  public void setEmployeeNo(long employeeNo) {
    this.employeeNo = employeeNo;
  }


  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }


  public String getRankName() {
    return rankName;
  }

  public void setRankName(String rankName) {
    this.rankName = rankName;
  }


  public java.sql.Timestamp getWorkStarttime() {
    return workStarttime;
  }

  public void setWorkStarttime(java.sql.Timestamp workStarttime) {
    this.workStarttime = workStarttime;
  }


  public java.sql.Timestamp getWorkEndtime() {
    return workEndtime;
  }

  public void setWorkEndtime(java.sql.Timestamp workEndtime) {
    this.workEndtime = workEndtime;
  }


  public String getRankContent() {
    return rankContent;
  }

  public void setRankContent(String rankContent) {
    this.rankContent = rankContent;
  }


  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}
