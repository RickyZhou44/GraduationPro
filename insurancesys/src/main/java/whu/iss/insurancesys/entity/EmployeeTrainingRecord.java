package whu.iss.insurancesys.entity;


public class EmployeeTrainingRecord {

  private long employeeNo;
  private String courseName;
  private String trainingContent;
  private String attachment;
  private java.sql.Timestamp trainingStarttime;
  private java.sql.Timestamp trainingEndtime;
  private String note;


  public long getEmployeeNo() {
    return employeeNo;
  }

  public void setEmployeeNo(long employeeNo) {
    this.employeeNo = employeeNo;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public String getTrainingContent() {
    return trainingContent;
  }

  public void setTrainingContent(String trainingContent) {
    this.trainingContent = trainingContent;
  }


  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }


  public java.sql.Timestamp getTrainingStarttime() {
    return trainingStarttime;
  }

  public void setTrainingStarttime(java.sql.Timestamp trainingStarttime) {
    this.trainingStarttime = trainingStarttime;
  }


  public java.sql.Timestamp getTrainingEndtime() {
    return trainingEndtime;
  }

  public void setTrainingEndtime(java.sql.Timestamp trainingEndtime) {
    this.trainingEndtime = trainingEndtime;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}
