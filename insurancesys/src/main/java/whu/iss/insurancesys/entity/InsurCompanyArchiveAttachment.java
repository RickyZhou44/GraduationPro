package whu.iss.insurancesys.entity;

import java.util.Date;

public class InsurCompanyArchiveAttachment {
    private Integer attachmentNo;

    private Integer companyArchiveNo;

    private String attachment;

    private Date attacValidStarttime;

    private Date attacVaildEndtime;

    public Integer getAttachmentNo() {
        return attachmentNo;
    }

    public void setAttachmentNo(Integer attachmentNo) {
        this.attachmentNo = attachmentNo;
    }

    public Integer getCompanyArchiveNo() {
        return companyArchiveNo;
    }

    public void setCompanyArchiveNo(Integer companyArchiveNo) {
        this.companyArchiveNo = companyArchiveNo;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public Date getAttacValidStarttime() {
        return attacValidStarttime;
    }

    public void setAttacValidStarttime(Date attacValidStarttime) {
        this.attacValidStarttime = attacValidStarttime;
    }

    public Date getAttacVaildEndtime() {
        return attacVaildEndtime;
    }

    public void setAttacVaildEndtime(Date attacVaildEndtime) {
        this.attacVaildEndtime = attacVaildEndtime;
    }
}