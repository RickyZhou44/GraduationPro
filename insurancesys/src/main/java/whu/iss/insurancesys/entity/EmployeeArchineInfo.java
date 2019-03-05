package whu.iss.insurancesys.entity;


public class EmployeeArchineInfo {

  private long employeeNo;
  private String archiveName;
  private String contectNumber;
  private java.sql.Timestamp validityStarttime;
  private java.sql.Timestamp validityEndtime;
  private String attachment;
  private String note;


  public long getEmployeeNo() {
    return employeeNo;
  }

  public void setEmployeeNo(long employeeNo) {
    this.employeeNo = employeeNo;
  }


  public String getArchiveName() {
    return archiveName;
  }

  public void setArchiveName(String archiveName) {
    this.archiveName = archiveName;
  }


  public String getContectNumber() {
    return contectNumber;
  }

  public void setContectNumber(String contectNumber) {
    this.contectNumber = contectNumber;
  }


  public java.sql.Timestamp getValidityStarttime() {
    return validityStarttime;
  }

  public void setValidityStarttime(java.sql.Timestamp validityStarttime) {
    this.validityStarttime = validityStarttime;
  }


  public java.sql.Timestamp getValidityEndtime() {
    return validityEndtime;
  }

  public void setValidityEndtime(java.sql.Timestamp validityEndtime) {
    this.validityEndtime = validityEndtime;
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
