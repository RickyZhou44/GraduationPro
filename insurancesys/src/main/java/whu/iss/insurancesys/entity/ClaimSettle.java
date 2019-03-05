package whu.iss.insurancesys.entity;


public class ClaimSettle {

  private String claimNo;
  private double settleAmount;
  private long isInvoice;
  private String invoiceNo;
  private double invoiceAmount;
  private java.sql.Timestamp payDate;
  private double payAmount;
  private String note;


  public String getClaimNo() {
    return claimNo;
  }

  public void setClaimNo(String claimNo) {
    this.claimNo = claimNo;
  }


  public double getSettleAmount() {
    return settleAmount;
  }

  public void setSettleAmount(double settleAmount) {
    this.settleAmount = settleAmount;
  }


  public long getIsInvoice() {
    return isInvoice;
  }

  public void setIsInvoice(long isInvoice) {
    this.isInvoice = isInvoice;
  }


  public String getInvoiceNo() {
    return invoiceNo;
  }

  public void setInvoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
  }


  public double getInvoiceAmount() {
    return invoiceAmount;
  }

  public void setInvoiceAmount(double invoiceAmount) {
    this.invoiceAmount = invoiceAmount;
  }


  public java.sql.Timestamp getPayDate() {
    return payDate;
  }

  public void setPayDate(java.sql.Timestamp payDate) {
    this.payDate = payDate;
  }


  public double getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(double payAmount) {
    this.payAmount = payAmount;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}
