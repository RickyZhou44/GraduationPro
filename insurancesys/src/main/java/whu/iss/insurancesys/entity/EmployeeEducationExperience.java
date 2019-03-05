package whu.iss.insurancesys.entity;


public class EmployeeEducationExperience {

  private long employeeNo;
  private String graduatedSchool;
  private String professionalTitle;
  private java.sql.Timestamp studyBeginTime;
  private java.sql.Timestamp studyEndTime;
  private String attachment;
  private String note;


  public long getEmployeeNo() {
    return employeeNo;
  }

  public void setEmployeeNo(long employeeNo) {
    this.employeeNo = employeeNo;
  }


  public String getGraduatedSchool() {
    return graduatedSchool;
  }

  public void setGraduatedSchool(String graduatedSchool) {
    this.graduatedSchool = graduatedSchool;
  }


  public String getProfessionalTitle() {
    return professionalTitle;
  }

  public void setProfessionalTitle(String professionalTitle) {
    this.professionalTitle = professionalTitle;
  }


  public java.sql.Timestamp getStudyBeginTime() {
    return studyBeginTime;
  }

  public void setStudyBeginTime(java.sql.Timestamp studyBeginTime) {
    this.studyBeginTime = studyBeginTime;
  }


  public java.sql.Timestamp getStudyEndTime() {
    return studyEndTime;
  }

  public void setStudyEndTime(java.sql.Timestamp studyEndTime) {
    this.studyEndTime = studyEndTime;
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
