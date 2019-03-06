package whu.iss.insurancesys.entity;

import java.util.Date;

public class EmployeeArchineInfo {
    private Integer employeeNo;

    private String archiveName;

    private String contectNumber;

    private Date validityStarttime;

    private Date validityEndtime;

    private String attachment;

    private String note;

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName == null ? null : archiveName.trim();
    }

    public String getContectNumber() {
        return contectNumber;
    }

    public void setContectNumber(String contectNumber) {
        this.contectNumber = contectNumber == null ? null : contectNumber.trim();
    }

    public Date getValidityStarttime() {
        return validityStarttime;
    }

    public void setValidityStarttime(Date validityStarttime) {
        this.validityStarttime = validityStarttime;
    }

    public Date getValidityEndtime() {
        return validityEndtime;
    }

    public void setValidityEndtime(Date validityEndtime) {
        this.validityEndtime = validityEndtime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}