package whu.iss.insurancesys.entity;


public class DeptLeader {

  private long id;
  private String leader;
  private String leaderCode;
  private java.sql.Timestamp startDay;
  private java.sql.Timestamp endDay;
  private long deptId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }


  public String getLeaderCode() {
    return leaderCode;
  }

  public void setLeaderCode(String leaderCode) {
    this.leaderCode = leaderCode;
  }


  public java.sql.Timestamp getStartDay() {
    return startDay;
  }

  public void setStartDay(java.sql.Timestamp startDay) {
    this.startDay = startDay;
  }


  public java.sql.Timestamp getEndDay() {
    return endDay;
  }

  public void setEndDay(java.sql.Timestamp endDay) {
    this.endDay = endDay;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }

}
