package whu.iss.insurancesys.entity;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/28
 */
public class MailData {
    private String reciever;
    private String content;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
