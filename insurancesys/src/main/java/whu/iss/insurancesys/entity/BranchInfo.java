package whu.iss.insurancesys.entity;


public class BranchInfo {

  private long branchId;
  private String type;
  private String code;
  private String cname;
  private String sname;
  private String authorityRestriction;
  private String bureau;
  private String description;
  private String phone;
  private String fax;
  private String email;
  private String adress;


  public long getBranchId() {
    return branchId;
  }

  public void setBranchId(long branchId) {
    this.branchId = branchId;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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


  public String getAuthorityRestriction() {
    return authorityRestriction;
  }

  public void setAuthorityRestriction(String authorityRestriction) {
    this.authorityRestriction = authorityRestriction;
  }


  public String getBureau() {
    return bureau;
  }

  public void setBureau(String bureau) {
    this.bureau = bureau;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

}
