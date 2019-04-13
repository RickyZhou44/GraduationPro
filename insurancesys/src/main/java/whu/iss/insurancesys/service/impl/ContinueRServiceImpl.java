package whu.iss.insurancesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.SettlementParamDaos.PreReceivableDao;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.SettlementParamEntities.*;
import whu.iss.insurancesys.service.ContinueRService;
import whu.iss.insurancesys.util.RickUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/4/14
 */
@Service
public class ContinueRServiceImpl implements ContinueRService {
    @Autowired
    private PreReceivableDao preReceivableDao;
    private Date date;
    private Date current;
    //    param表示查询类型为R13，R25，R37
//    type表示查询的纬度1-个人 2-单位
    @Override
    public ResultInfo getResult(Date current,int param,int type) {
        ResultInfo resultInfo=new ResultInfo();
        this.current=current;
        List<PaidPremiumParam> paidPremiumParams=preReceivableDao.queryPaid();
        List<PreReceivableParam> preReceivableParams=preReceivableDao.queryAll();
        List<PayRecoredParam> payRecoredParams=preReceivableDao.getPayRecored();
        this.date=valuateDate(current,param);
        //用于存储个人纬度的查询数据
        List<ContinueRateParam>listPerson=new ArrayList<>();
        //用于存储单位纬度的查询数据
        List<ContinueRateBranchParam>listUnit=new ArrayList<>();
        //如果date返回为null，则数据处理失败，返回resultInfo并将result置于false
        if(date==null){
            resultInfo.setResult(false);
            return resultInfo;
        }
        else {
            //个人纬度的查询
            if(type==1){
                listPerson=perDivission(paidPremiumParams,preReceivableParams,payRecoredParams);
                resultInfo.setResult(true);
                resultInfo.setData(listPerson);
                resultInfo.setReason("person");
                return resultInfo;
            }
            //单位纬度查询
            else if(type==2){
                listUnit=unitDiv(paidPremiumParams,preReceivableParams,payRecoredParams);
                resultInfo.setResult(true);
                resultInfo.setData(listUnit);
                resultInfo.setReason("unit");
                return resultInfo;
            }
            else {
                resultInfo.setResult(false);
                return resultInfo;
            }
        }
    }
    //   此方法用于计算指定月之前param月的具体日期
    private Date valuateDate(Date current,int param){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        String currentDate=simpleDateFormat.format(current);
        int year =Integer.parseInt(currentDate.substring(0,4));
        int month=Integer.parseInt(currentDate.substring(5));
        int diff=param-month;
        int yDiff=diff/12+1;
        int mDiff=diff%12;
        year-=yDiff;
        month=12-mDiff;
        String now=year+"-"+month;
        try {
            return simpleDateFormat.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //此法用于生成返回前端的个人纬度的数据
    private List<ContinueRateParam> perDivission(List<PaidPremiumParam> paidPremiumParams,List<PreReceivableParam> preReceivableParams,List<PayRecoredParam>payRecoredParams){
        List<ContinueRateParam>list=new ArrayList<>();
        List<String>employeeNos=preReceivableDao.employeeNo();
        double paid=0.0;
        double premium=0.0;
        double rate=0.0;
        for (String employee:employeeNos) {
            //初始化paid和premium
            paid=0.0;
            premium=0.0;
//创建传往前端的一行数据
            ContinueRateParam continueRateParam=new ContinueRateParam();
            continueRateParam.setDate(current);
            continueRateParam.setIdNum(employee);
            String policyNo=null;
            String policyNo2=null;
            //首先计算实际收到的保费
            for(PaidPremiumParam p:paidPremiumParams){
                if(employee.equals(p.getEmployee_no())){
                    for(PayRecoredParam pr:payRecoredParams){
                        policyNo= RickUtil.removeEsc(p.getPolicy_no());
                        policyNo2=RickUtil.removeEsc(pr.getPolicy_no());
                        if(policyNo.equals(policyNo2)){
                            if(date.compareTo(pr.getPay_date())<=0&&pr.getPay_date().compareTo(current)==-1){
                                paid+=p.getPremium();
                            }
                        }
                    }
                }
            }
            continueRateParam.setPaidPremium(paid);
            //其次计算应收保费
            for(PreReceivableParam p:preReceivableParams){
                if(employee.equals(p.getEmployee_no())){
                    if(continueRateParam.getName()==null){
                        continueRateParam.setName(p.getChinese_name());
                        continueRateParam.setRank(p.getCurrent_rank());
                        continueRateParam.setUnit(p.getBranch_name());
                    }
                    //判断这支保险是否已经生效
                    if((date.compareTo(p.getValid_date_since())>=0)||(date.compareTo(p.getValid_date_since())==-1&&current.compareTo(p.getValid_date_since())==1)) {
                        //首先计算这支保险的交费年期
                        //首先获得这个
                        String period = RickUtil.yearTimesFormat(p.getPeriod());
                        int year = Integer.parseInt(period.substring(0, 2));
                        int times = Integer.parseInt(period.substring(2));
                        int duration = 12 * year / times;
                        Date payDate = p.getPay_date();
                        while (current.compareTo(payDate) == 1) {
                            if (date.compareTo(payDate) <= 0) {
                                premium += p.getPremium();
                            }
                            payDate = addDate(payDate, duration);
                        }

                    }

                }
            }
            continueRateParam.setPreReceivable(premium);
            rate=paid/premium;
            continueRateParam.setRate(rate*100);
            list.add(continueRateParam);
        }
        return list;
    }

    //此方法用于生成分支纬度的数据
    private List<ContinueRateBranchParam> unitDiv(List<PaidPremiumParam> paidPremiumParams,List<PreReceivableParam> preReceivableParams,List<PayRecoredParam>payRecoredParams){
        List<String>branchName=preReceivableDao.branchName();
        List<ContinueRateBranchParam>list=new ArrayList<>();
        double paid=0.0;
        double premium=0.0;
        double rate=0.0;
        for (String name:branchName){
            //一个分支机构创建一个对象
            ContinueRateBranchParam continueRateBranchParam=new ContinueRateBranchParam();
            //初始化应收和实收保费
            paid=0.0;
            premium=0.0;
            continueRateBranchParam.setDate(current);
            continueRateBranchParam.setUnit(name);
            //首先计算实收保费
            for(PaidPremiumParam p:paidPremiumParams){
                if(name.equals(p.getBranch_name())){
//                    if(date.compareTo(p.getPay_date())<=0&&p.getPay_date().compareTo(current)==-1){
//                        paid+=p.getPremium();
//                    }
                    for (PayRecoredParam pr:payRecoredParams){
                        if(p.getPolicy_no().equals(pr.getPolicy_no())){
                            if(date.compareTo(pr.getPay_date())<=0&&pr.getPay_date().compareTo(current)==-1){
                                paid+=p.getPremium();
                            }
                        }
                    }
                }
            }
            continueRateBranchParam.setPaidPremium(paid);
            //计算应收保费
            for (PreReceivableParam p:preReceivableParams){
                if(name.equals(p.getBranch_name())){
                    if((date.compareTo(p.getValid_date_since())>=0)||(date.compareTo(p.getValid_date_since())==-1&&current.compareTo(p.getValid_date_since())==1)){
                        //首先计算这支保险的交费年期
                        String period=RickUtil.yearTimesFormat(p.getPeriod());
                        int year=Integer.parseInt(period.substring(0,2));
                        int times=Integer.parseInt(period.substring(2));
                        int duration=12*year/times;
                        Date payDate=p.getPay_date();
                        while (current.compareTo(payDate)==1){
                            if(date.compareTo(payDate)<=0){
                                premium+=p.getPremium();
                            }
                            payDate=addDate(payDate,duration);
                        }
                    }
                }
            }
            rate=paid/premium;
            continueRateBranchParam.setPreReceivable(premium);
            continueRateBranchParam.setRate(rate*100);
            list.add(continueRateBranchParam);

        }
        return list;
    }

    //计算出需要交费的日期
    private Date addDate(Date date,int dur){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        String dates=simpleDateFormat.format(date);
        String time=null;
        Date date1=null;
        int year=Integer.parseInt(dates.substring(0,4));
        int month=Integer.parseInt(dates.substring(5));
        month+=dur;
        if(month<=12){
            time=""+year+"-"+month;
        }
        else {
            year=year+month/12;
            month=month%12;
            time=""+year+"-"+month;
        }
        try {
            date1=simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }


}
