package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.MailData;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
public interface LoginRegisterService {
    public void sendEmail(MailData data);
    public boolean registerIf(String email, String code, Date date);
}
