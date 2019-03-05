package whu.iss.insurancesys.entity;


public class InsurCompanyArchive {

  private long companyArchiveNo;
  private String companyArchiveName;
  private String note;


  public long getCompanyArchiveNo() {
    return companyArchiveNo;
  }

  public void setCompanyArchiveNo(long companyArchiveNo) {
    this.companyArchiveNo = companyArchiveNo;
  }


  public String getCompanyArchiveName() {
    return companyArchiveName;
  }

  public void setCompanyArchiveName(String companyArchiveName) {
    this.companyArchiveName = companyArchiveName;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}
