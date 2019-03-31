package whu.iss.insurancesys.entity.LoginRegisterEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
public class VerifiCode {
    private String code;
    private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
