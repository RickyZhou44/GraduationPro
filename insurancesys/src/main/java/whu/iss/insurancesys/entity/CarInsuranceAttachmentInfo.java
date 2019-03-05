package whu.iss.insurancesys.entity;


public class CarInsuranceAttachmentInfo {

  private long attachId;
  private String policyNo;
  private long attachNo;
  private String attachClass;
  private String recordField;
  private String fieldContent;
  private java.sql.Timestamp vaildStarttime;
  private java.sql.Timestamp vaildEndtime;
  private String attchment;
  private String attachmentFormat;
  private String attachmentSize;
  private String attachmentExplain;
  private java.sql.Timestamp attachmentFianlUpdatetime;


  public long getAttachId() {
    return attachId;
  }

  public void setAttachId(long attachId) {
    this.attachId = attachId;
  }


  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }


  public long getAttachNo() {
    return attachNo;
  }

  public void setAttachNo(long attachNo) {
    this.attachNo = attachNo;
  }


  public String getAttachClass() {
    return attachClass;
  }

  public void setAttachClass(String attachClass) {
    this.attachClass = attachClass;
  }


  public String getRecordField() {
    return recordField;
  }

  public void setRecordField(String recordField) {
    this.recordField = recordField;
  }


  public String getFieldContent() {
    return fieldContent;
  }

  public void setFieldContent(String fieldContent) {
    this.fieldContent = fieldContent;
  }


  public java.sql.Timestamp getVaildStarttime() {
    return vaildStarttime;
  }

  public void setVaildStarttime(java.sql.Timestamp vaildStarttime) {
    this.vaildStarttime = vaildStarttime;
  }


  public java.sql.Timestamp getVaildEndtime() {
    return vaildEndtime;
  }

  public void setVaildEndtime(java.sql.Timestamp vaildEndtime) {
    this.vaildEndtime = vaildEndtime;
  }


  public String getAttchment() {
    return attchment;
  }

  public void setAttchment(String attchment) {
    this.attchment = attchment;
  }


  public String getAttachmentFormat() {
    return attachmentFormat;
  }

  public void setAttachmentFormat(String attachmentFormat) {
    this.attachmentFormat = attachmentFormat;
  }


  public String getAttachmentSize() {
    return attachmentSize;
  }

  public void setAttachmentSize(String attachmentSize) {
    this.attachmentSize = attachmentSize;
  }


  public String getAttachmentExplain() {
    return attachmentExplain;
  }

  public void setAttachmentExplain(String attachmentExplain) {
    this.attachmentExplain = attachmentExplain;
  }


  public java.sql.Timestamp getAttachmentFianlUpdatetime() {
    return attachmentFianlUpdatetime;
  }

  public void setAttachmentFianlUpdatetime(java.sql.Timestamp attachmentFianlUpdatetime) {
    this.attachmentFianlUpdatetime = attachmentFianlUpdatetime;
  }

}
