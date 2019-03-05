package whu.iss.insurancesys.entity;


public class InsurCompanyArchiveAttachment {

  private long attachmentNo;
  private long companyArchiveNo;
  private String attachment;
  private java.sql.Timestamp attacValidStarttime;
  private java.sql.Timestamp attacVaildEndtime;


  public long getAttachmentNo() {
    return attachmentNo;
  }

  public void setAttachmentNo(long attachmentNo) {
    this.attachmentNo = attachmentNo;
  }


  public long getCompanyArchiveNo() {
    return companyArchiveNo;
  }

  public void setCompanyArchiveNo(long companyArchiveNo) {
    this.companyArchiveNo = companyArchiveNo;
  }


  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }


  public java.sql.Timestamp getAttacValidStarttime() {
    return attacValidStarttime;
  }

  public void setAttacValidStarttime(java.sql.Timestamp attacValidStarttime) {
    this.attacValidStarttime = attacValidStarttime;
  }


  public java.sql.Timestamp getAttacVaildEndtime() {
    return attacVaildEndtime;
  }

  public void setAttacVaildEndtime(java.sql.Timestamp attacVaildEndtime) {
    this.attacVaildEndtime = attacVaildEndtime;
  }

}
