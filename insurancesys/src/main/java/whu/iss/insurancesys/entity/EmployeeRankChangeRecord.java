package whu.iss.insurancesys.entity;

public class EmployeeRankChangeRecord {

  private long rankChangeNo;
  private long employeeNo;
  private String changeReason;
  private String branchName;
  private String departmentName;
  private String rankName;
  private java.sql.Timestamp rankEffectiveStarttime;
  private java.sql.Timestamp rankEffectiveEndtime;
  private String introducerName;
  private String relationshipSuperiorName;
  private String administratorName;
  private String administrator2Name;
  private String note;


  public long getRankChangeNo() {
    return rankChangeNo;
  }

  public void setRankChangeNo(long rankChangeNo) {
    this.rankChangeNo = rankChangeNo;
  }


  public long getEmployeeNo() {
    return employeeNo;
  }

  public void setEmployeeNo(long employeeNo) {
    this.employeeNo = employeeNo;
  }


  public String getChangeReason() {
    return changeReason;
  }

  public void setChangeReason(String changeReason) {
    this.changeReason = changeReason;
  }


  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }


  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }


  public String getRankName() {
    return rankName;
  }

  public void setRankName(String rankName) {
    this.rankName = rankName;
  }


  public java.sql.Timestamp getRankEffectiveStarttime() {
    return rankEffectiveStarttime;
  }

  public void setRankEffectiveStarttime(java.sql.Timestamp rankEffectiveStarttime) {
    this.rankEffectiveStarttime = rankEffectiveStarttime;
  }


  public java.sql.Timestamp getRankEffectiveEndtime() {
    return rankEffectiveEndtime;
  }

  public void setRankEffectiveEndtime(java.sql.Timestamp rankEffectiveEndtime) {
    this.rankEffectiveEndtime = rankEffectiveEndtime;
  }


  public String getIntroducerName() {
    return introducerName;
  }

  public void setIntroducerName(String introducerName) {
    this.introducerName = introducerName;
  }


  public String getRelationshipSuperiorName() {
    return relationshipSuperiorName;
  }

  public void setRelationshipSuperiorName(String relationshipSuperiorName) {
    this.relationshipSuperiorName = relationshipSuperiorName;
  }


  public String getAdministratorName() {
    return administratorName;
  }

  public void setAdministratorName(String administratorName) {
    this.administratorName = administratorName;
  }


  public String getAdministrator2Name() {
    return administrator2Name;
  }

  public void setAdministrator2Name(String administrator2Name) {
    this.administrator2Name = administrator2Name;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}
