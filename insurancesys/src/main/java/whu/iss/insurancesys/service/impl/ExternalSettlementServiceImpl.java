package whu.iss.insurancesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.SettlementParamDaos.SettlementDao;
import whu.iss.insurancesys.entity.InsuranceType;
import whu.iss.insurancesys.entity.InsuranceTypeParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.*;
import whu.iss.insurancesys.service.ExternalSettlementService;
import whu.iss.insurancesys.util.RickUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/22
 */
//此类主要用于处理外部结算的业务逻辑
@Service
public class ExternalSettlementServiceImpl implements ExternalSettlementService {
    @Autowired
    private SettlementDao settlementDao;
    @Override
    public ExternalSettleData getExternalSData(Date date,String check) {
        List<ExternalSettleEntity>externalSettleEntities=settlementDao.getExternalData();
        List<InsuranceTypeEntity>insuranceTypeEntities=settlementDao.getInsuranceData();
        List<ExternSettlementParam>ep=new ArrayList<>();
        //整个查询的结果
        double totalPremium=0.0;
        double premium=0.0;
        double stdPremium=0.0;
        double fyc=0.0;
        double mainPre=0.0;
        double vicePre=0.0;
        for(ExternalSettleEntity e:externalSettleEntities){
            //初始化相关参数
            premium=0.0;
            stdPremium=0.0;
            fyc=0.0;
            mainPre=0.0;
            vicePre=0.0;
            //判断这个险种是否属于指定的计基开始
            if(e.getCheck_commission_status().equals(check)&&e.getValidate_date_start().compareTo(date)>=0){
                ExternSettlementParam externSettlementParam=new ExternSettlementParam();
                externSettlementParam.setValidateDate(date);
                externSettlementParam.setPaidDate(e.getPay_date());
                externSettlementParam.setPreMonth(date);
                externSettlementParam.setNum("");
                externSettlementParam.setOccurMonth(date);
                externSettlementParam.setAccountState("正常");
                externSettlementParam.setBalanceMonth(date);
                externSettlementParam.setCheck(check);
                externSettlementParam.setInsurCom(e.getInsurer_name());
                externSettlementParam.setContractor(e.getChinese_name());
                externSettlementParam.setIdNum(e.getEmployee_no());
                externSettlementParam.setPolicy_no(e.getPolicy_no());
                externSettlementParam.setPolicyState(e.getPolicy_type());
                externSettlementParam.setConstractState(e.getAgent_type());
                List<InsuranceParam>list=getMainAndVice(insuranceTypeEntities,e.getPolicy_no());
                //计算相关佣金
                for(InsuranceParam l:list){
                    premium+=l.getPremium();
                    stdPremium+=l.getExStdPremium();
                    fyc+=l.getFfyc();
                    switch (l.getMainVType()){
                        case "主约":
                            mainPre+=l.getPremium();
                            break;
                        case "附约":
                            vicePre+=l.getPremium();
                            break;
                    }
                }
                totalPremium+=premium;
                externSettlementParam.setInsuranceParams(list);
                externSettlementParam.setTotalPremium(String.valueOf(premium));
                externSettlementParam.setStdPremium(String.valueOf(stdPremium));
                externSettlementParam.setMainPremium(mainPre);
                externSettlementParam.setAttachPremium(vicePre);
                ep.add(externSettlementParam);
            }


        }
        ExternalSettleData externalSettleData=new ExternalSettleData();
        externalSettleData.setExternSettlementParams(ep);
        externalSettleData.setTotalPremium(totalPremium);
        return externalSettleData;
    }

    @Override
    public SettlementEditDate getSettlementEditData(ExternSettlementParam e) {
        SettlementEditDate settlementEditDate=new SettlementEditDate();
        //首先获得投保人信息
        Insured insured=settlementDao.getInsured(e.getPolicy_no());
        settlementEditDate.setClientId(insured.getPolicy_holder_id());
        settlementEditDate.setClientName(insured.getName());
        settlementEditDate.setJijiDate(e.getValidateDate());//计基年月
        settlementEditDate.setCheckStatus("正常");//核发状态
        settlementEditDate.setCheckCommission(e.getCheck());//核佣状态
        settlementEditDate.setAccountStates(e.getAccountState());//账目状态
        settlementEditDate.setBalanceDate(e.getBalanceMonth());//平衡月
        settlementEditDate.setInsuranceName(e.getInsurCom());//保险公司名字
        settlementEditDate.setPolicyNo(e.getPolicy_no());//保险单号
        settlementEditDate.setAttachNo("");//相关单号
        settlementEditDate.setPayType("契撤解约");//交费型别
        settlementEditDate.setCheckDate(e.getPaidDate());
        String period=RickUtil.yearTimesFormat(insured.getPeriod());
        int year=Integer.parseInt(period.substring(0,2));
        int times=Integer.parseInt(period.substring(2));
        settlementEditDate.setYear(year);
        settlementEditDate.setTimes(times);
        settlementEditDate.setPayf(insured.getPay_way()+"/"+insured.getPay_mode());
        settlementEditDate.setPayDate(e.getPaidDate());//交费日期
        settlementEditDate.setHuizhiDate(null);//回执日期
        settlementEditDate.setInsuranceParams(e.getInsuranceParams());
        settlementEditDate.setTotalPremium(Double.parseDouble(e.getTotalPremium()));//保费
        settlementEditDate.setFirstyearP(e.getfPre());//首年
        settlementEditDate.setSale(e.getSale());//服务
        settlementEditDate.setFfyc(e.getSfyc());//首佣fyc
        settlementEditDate.setIntStdPremium(e.getInterStdPre());//内部标准保费
        settlementEditDate.setStdPremium(Double.parseDouble(e.getStdPremium()));//标保
        settlementEditDate.setSecondYear(e.getSecondYear());//续年
        settlementEditDate.setSevice(e.getService());//服务
        settlementEditDate.setSecondFyc(e.getXfyc());//续年fyc
        settlementEditDate.setCfyc(e.getCaiYCFY());//cfyc
        settlementEditDate.setAgentType(insured.getAgent_type());//承揽型别
        settlementEditDate.setContractorName(e.getContractor());//承揽人姓名
        settlementEditDate.setContractorNum(e.getIdNum());//承揽人编号
        return settlementEditDate;
    }

    //获得指定保单的主约附约明细
    private List<InsuranceParam>getMainAndVice(List<InsuranceTypeEntity>insuranceTypeEntities,String policy_no){
        List<InsuranceParam>list=new ArrayList<>();
        for(InsuranceTypeEntity i:insuranceTypeEntities){
            //这里做一些字符串处理防止出现'/r'
            String p= RickUtil.removeEsc(i.getPolicy_no());
            policy_no=RickUtil.removeEsc(policy_no);
            if(p.equals(policy_no)){
                InsuranceParam insuranceParam=new InsuranceParam();
                insuranceParam.setInsuranceName(i.getInsurance_cname());
                insuranceParam.setYearTimes(RickUtil.yearTimesFormat(i.getPeriod()));
                insuranceParam.setPayYear(i.getCommon_year());
                insuranceParam.setPremium(i.getPremium());
                insuranceParam.setMainVType(i.getMain_or_vice());
                //计算标准保费
                insuranceParam.setExStdPremium(i.getPremium()*i.getRate());
                insuranceParam.setFfyc(i.getPremium()*0.1);
                list.add(insuranceParam);
            }
        }
        return list;
    }
}