package whu.iss.insurancesys.entity;


public class LifePolicyContract {

  private long contractNo;
  private long employeeNo;
  private String policyNo;


  public long getContractNo() {
    return contractNo;
  }

  public void setContractNo(long contractNo) {
    this.contractNo = contractNo;
  }


  public long getEmployeeNo() {
    return employeeNo;
  }

  public void setEmployeeNo(long employeeNo) {
    this.employeeNo = employeeNo;
  }


  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }

}
