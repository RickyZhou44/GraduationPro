package whu.iss.insurancesys.service;

import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.MailData;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
public interface LoginRegisterService {
    public void sendEmail(MailData data);
    public ResultInfo login(String user, String password);
    public boolean registerIf(String email, String code, Date date);
    public void addAccount(String user,String email,String password,Date date);
}
