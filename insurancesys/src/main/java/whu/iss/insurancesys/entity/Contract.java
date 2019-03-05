package whu.iss.insurancesys.entity;


public class Contract {

  private long id;
  private String name;
  private String sex;
  private String rank;
  private String phone;
  private String email;
  private String description;
  private long branchId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getBranchId() {
    return branchId;
  }

  public void setBranchId(long branchId) {
    this.branchId = branchId;
  }

}
