package whu.iss.insurancesys.entity;

import java.util.Date;

public class CarInsuranceAttachmentInfo {
    private Integer attachId;

    private String policyNo;

    private Integer attachNo;

    private String attachClass;

    private String recordField;

    private String fieldContent;

    private Date vaildStarttime;

    private Date vaildEndtime;

    private String attchment;

    private String attachmentFormat;

    private String attachmentSize;

    private Date attachmentFianlUpdatetime;

    private String attachmentExplain;

    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public Integer getAttachNo() {
        return attachNo;
    }

    public void setAttachNo(Integer attachNo) {
        this.attachNo = attachNo;
    }

    public String getAttachClass() {
        return attachClass;
    }

    public void setAttachClass(String attachClass) {
        this.attachClass = attachClass == null ? null : attachClass.trim();
    }

    public String getRecordField() {
        return recordField;
    }

    public void setRecordField(String recordField) {
        this.recordField = recordField == null ? null : recordField.trim();
    }

    public String getFieldContent() {
        return fieldContent;
    }

    public void setFieldContent(String fieldContent) {
        this.fieldContent = fieldContent == null ? null : fieldContent.trim();
    }

    public Date getVaildStarttime() {
        return vaildStarttime;
    }

    public void setVaildStarttime(Date vaildStarttime) {
        this.vaildStarttime = vaildStarttime;
    }

    public Date getVaildEndtime() {
        return vaildEndtime;
    }

    public void setVaildEndtime(Date vaildEndtime) {
        this.vaildEndtime = vaildEndtime;
    }

    public String getAttchment() {
        return attchment;
    }

    public void setAttchment(String attchment) {
        this.attchment = attchment == null ? null : attchment.trim();
    }

    public String getAttachmentFormat() {
        return attachmentFormat;
    }

    public void setAttachmentFormat(String attachmentFormat) {
        this.attachmentFormat = attachmentFormat == null ? null : attachmentFormat.trim();
    }

    public String getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(String attachmentSize) {
        this.attachmentSize = attachmentSize == null ? null : attachmentSize.trim();
    }

    public Date getAttachmentFianlUpdatetime() {
        return attachmentFianlUpdatetime;
    }

    public void setAttachmentFianlUpdatetime(Date attachmentFianlUpdatetime) {
        this.attachmentFianlUpdatetime = attachmentFianlUpdatetime;
    }

    public String getAttachmentExplain() {
        return attachmentExplain;
    }

    public void setAttachmentExplain(String attachmentExplain) {
        this.attachmentExplain = attachmentExplain == null ? null : attachmentExplain.trim();
    }
}