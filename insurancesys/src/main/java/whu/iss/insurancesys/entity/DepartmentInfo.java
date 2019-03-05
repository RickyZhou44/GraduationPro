package whu.iss.insurancesys.entity;


public class DepartmentInfo {

  private long deptId;
  private String cname;
  private String sname;
  private long branchId;


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public long getBranchId() {
    return branchId;
  }

  public void setBranchId(long branchId) {
    this.branchId = branchId;
  }

}
