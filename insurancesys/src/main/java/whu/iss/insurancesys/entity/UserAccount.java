package whu.iss.insurancesys.entity;


public class UserAccount {

  private long userNo;
  private String userType;
  private String username;
  private String userRealname;
  private String email;
  private String password;
  private java.sql.Timestamp starttime;
  private java.sql.Timestamp endtime;
  private String accountStatus;


  public long getUserNo() {
    return userNo;
  }

  public void setUserNo(long userNo) {
    this.userNo = userNo;
  }


  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getUserRealname() {
    return userRealname;
  }

  public void setUserRealname(String userRealname) {
    this.userRealname = userRealname;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public java.sql.Timestamp getStarttime() {
    return starttime;
  }

  public void setStarttime(java.sql.Timestamp starttime) {
    this.starttime = starttime;
  }


  public java.sql.Timestamp getEndtime() {
    return endtime;
  }

  public void setEndtime(java.sql.Timestamp endtime) {
    this.endtime = endtime;
  }


  public String getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
  }

}
