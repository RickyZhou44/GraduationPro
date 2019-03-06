package whu.iss.insurancesys.entity;

import java.util.Date;

public class EmployeeTrainingRecord {
    private Integer employeeNo;

    private String courseName;

    private String trainingContent;

    private String attachment;

    private Date trainingStarttime;

    private Date trainingEndtime;

    private String note;

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getTrainingContent() {
        return trainingContent;
    }

    public void setTrainingContent(String trainingContent) {
        this.trainingContent = trainingContent == null ? null : trainingContent.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public Date getTrainingStarttime() {
        return trainingStarttime;
    }

    public void setTrainingStarttime(Date trainingStarttime) {
        this.trainingStarttime = trainingStarttime;
    }

    public Date getTrainingEndtime() {
        return trainingEndtime;
    }

    public void setTrainingEndtime(Date trainingEndtime) {
        this.trainingEndtime = trainingEndtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}