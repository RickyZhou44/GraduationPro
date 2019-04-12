package whu.iss.insurancesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.LoginRegisterDaos.LoginRegisterDao;
import whu.iss.insurancesys.dao.SettlementParamDaos.SettlementDao;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.LoginRegisterEntities.Account;
import whu.iss.insurancesys.entity.LoginRegisterEntities.VerifiCode;
import whu.iss.insurancesys.entity.MailData;
import whu.iss.insurancesys.service.LoginRegisterService;
import whu.iss.insurancesys.util.EmailUtil;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private SettlementDao settlementDao;
    @Autowired
    private LoginRegisterDao loginRegisterDao;
    @Override
    public void sendEmail(MailData data) {
        settlementDao.insertVertification(data.getReciever(),data.getDate(),data.getContent());
        System.out.println("插入验证码数据成功");
        emailUtil.send(data);
    }

    @Override
    public ResultInfo login(String user, String password) {
        ResultInfo resultInfo=new ResultInfo();
        List<Account>accounts=loginRegisterDao.getAccounts();
        for (Account account:accounts){
            //判断其输入的用户名是否邮箱
            if(user.equals(account.getUsername())||user.equals(account.getEmail())){
                if(password.equals(account.getPassword())){
                    resultInfo.setResult(true);
                    return resultInfo;
                }
                else {
                    resultInfo.setResult(false);
                    resultInfo.setReason("密码错误");
                    return resultInfo;
                }
            }
        }
        resultInfo.setResult(false);
        resultInfo.setReason("账号或者邮箱不存在");
        return resultInfo;
    }

    @Override
    public boolean registerIf(String email,String code,Date d) {
        MailData mailData=recentCode(email);
        Date date=mailData.getDate();
        long now=date.getTime();
        long time=0;
//        如果date为空表示之前的数据处理有问题
        if (date == null) {
        return false;
        }
        else {
            time=d.getTime();
//            如果两者的毫秒数在60000ms以内则比较code
            if((time-now)<=60000){
                if(code.equals(mailData.getContent())){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }

    @Override
    public void addAccount(String user, String email, String password,Date date) {
        loginRegisterDao.addAccount(user,user,email,password,date);
    }

    private MailData recentCode(String email) {
        List<VerifiCode>verifiCodes=settlementDao.getverifi(email);
        MailData mailData=new MailData();
        mailData.setReciever(email);
        Date recentDate=null;
        String recentCode=null;
        for (VerifiCode v:verifiCodes){
            //如果recentDate为空，或者recentDate比当前的date日期更接近现在
            if(recentDate==null||recentDate.compareTo(v.getDate())==1){
                recentDate=v.getDate();
                recentCode=v.getCode();
            }
        }
        mailData.setDate(recentDate);
        mailData.setContent(recentCode);
        return mailData;
    }
    public static void main(String[]args){
        Date date=new Date();
        long time=date.getTime();
//        Date date1=new Date();
//        int time1=date1.ge
        System.out.println(time);
    }
}
