package whu.iss.insurancesys.entity;


public class EmployeeUnitRank {

  private long employNo;
  private String branchName;
  private String department;
  private String currentRank;
  private String serviceType;
  private String introducerName;
  private String relationshipSuperiorName;
  private String administratorName;
  private String administrator2Name;
  private java.sql.Timestamp entryTime;
  private String contractNumber;
  private java.sql.Timestamp contractStarttime;
  private java.sql.Timestamp contractEndtime;


  public long getEmployNo() {
    return employNo;
  }

  public void setEmployNo(long employNo) {
    this.employNo = employNo;
  }


  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  public String getCurrentRank() {
    return currentRank;
  }

  public void setCurrentRank(String currentRank) {
    this.currentRank = currentRank;
  }


  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
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


  public java.sql.Timestamp getEntryTime() {
    return entryTime;
  }

  public void setEntryTime(java.sql.Timestamp entryTime) {
    this.entryTime = entryTime;
  }


  public String getContractNumber() {
    return contractNumber;
  }

  public void setContractNumber(String contractNumber) {
    this.contractNumber = contractNumber;
  }


  public java.sql.Timestamp getContractStarttime() {
    return contractStarttime;
  }

  public void setContractStarttime(java.sql.Timestamp contractStarttime) {
    this.contractStarttime = contractStarttime;
  }


  public java.sql.Timestamp getContractEndtime() {
    return contractEndtime;
  }

  public void setContractEndtime(java.sql.Timestamp contractEndtime) {
    this.contractEndtime = contractEndtime;
  }

}
