package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/26
 */
public class AttachmentInfo {
    private int id;
    private String record_content;
    private String record_type;
    private Date valid_date_start;
    private Date valid_date_end;
    private String other;
    private String attachment;
    private String certf_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecord_content() {
        return record_content;
    }

    public void setRecord_content(String record_content) {
        this.record_content = record_content;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public Date getValid_date_start() {
        return valid_date_start;
    }

    public void setValid_date_start(Date valid_date_start) {
        this.valid_date_start = valid_date_start;
    }

    public Date getValid_date_end() {
        return valid_date_end;
    }

    public void setValid_date_end(Date valid_date_end) {
        this.valid_date_end = valid_date_end;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getCertf_id() {
        return certf_id;
    }

    public void setCertf_id(String certf_id) {
        this.certf_id = certf_id;
    }
}
