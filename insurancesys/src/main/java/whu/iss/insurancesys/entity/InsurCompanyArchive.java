package whu.iss.insurancesys.entity;

public class InsurCompanyArchive {
    private Integer companyArchiveNo;

    private String companyArchiveName;

    private String note;

    public Integer getCompanyArchiveNo() {
        return companyArchiveNo;
    }

    public void setCompanyArchiveNo(Integer companyArchiveNo) {
        this.companyArchiveNo = companyArchiveNo;
    }

    public String getCompanyArchiveName() {
        return companyArchiveName;
    }

    public void setCompanyArchiveName(String companyArchiveName) {
        this.companyArchiveName = companyArchiveName == null ? null : companyArchiveName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}