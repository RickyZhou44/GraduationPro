package whu.iss.insurancesys.entity;


public class InsurCompanyBranchRelated {

  private long comBranId;
  private long companyId;
  private long branchId;


  public long getComBranId() {
    return comBranId;
  }

  public void setComBranId(long comBranId) {
    this.comBranId = comBranId;
  }


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }


  public long getBranchId() {
    return branchId;
  }

  public void setBranchId(long branchId) {
    this.branchId = branchId;
  }

}
