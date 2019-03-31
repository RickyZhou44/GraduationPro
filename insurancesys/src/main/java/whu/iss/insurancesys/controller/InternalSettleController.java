package whu.iss.insurancesys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.ExcelData;
import whu.iss.insurancesys.entity.InternalSettlementEntities.CommisionData;
import whu.iss.insurancesys.entity.InternalSettlementEntities.CommissionParam;
import whu.iss.insurancesys.entity.InternalSettlementEntities.PolicyDetail;
import whu.iss.insurancesys.entity.InternalSettlementEntities.SalaryParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.CarInsuranceParam;
import whu.iss.insurancesys.service.ExternalSettlementService;
import whu.iss.insurancesys.service.InternalSettlementService;
import whu.iss.insurancesys.util.ExcelUtil;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/27
 */
@RestController
public class InternalSettleController {
    @Autowired
    private ExternalSettlementService externalSettlementService;
    @Autowired
    private InternalSettlementService internalSettlementService;
    @RequestMapping("carautoSettle")
    public Object carSettle(HttpSession session, @RequestParam("dateStart") Date dateStart, @RequestParam("dateEnd")Date dateEnd,@RequestParam("branch")String branch){
        ResultInfo resultInfo=new ResultInfo();
        //从之前service中已经封装好的方法进行操作
        List<CarInsuranceParam>list=externalSettlementService.getCarInsuranceParam();
        List<PolicyDetail>policyDetails=new ArrayList<>();
        List<SalaryParam>salaryParams=new ArrayList<>();
        CommisionData commisionData=new CommisionData();
        if(list==null){
            resultInfo.setResult(false);
            return resultInfo;
        }
        else {
            for (CarInsuranceParam c:list){
                if(c.getBranch().equals(branch)&&c.getValidDate().compareTo(dateStart)>=0&&c.getValidDate().compareTo(dateEnd)<=0){
                    PolicyDetail policyDetail=new PolicyDetail();
                    SalaryParam salaryParam=new SalaryParam();
                    //赋值薪资明细
                    salaryParam.setBranch(c.getBranch());
                    salaryParam.setContractor(c.getContractorName());
                    salaryParam.setPayPremium(c.getJiaoqiangPremium()*c.getExpenditureJiaoqiangRate()+c.getBusinessPremium()*c.getExpenditureBusinessRate());
                    salaryParam.setValid_date_start(c.getValidDate());
                    salaryParam.setValid_date_end(dateEnd);
                    salaryParams.add(salaryParam);
                    //赋值订单详细
                    policyDetail.setCompanyName(c.getCompanyName());
                    policyDetail.setPolicyNo(c.getPolicyNo());
                    policyDetail.setValidDate(c.getValidDate());
                    policyDetail.setJiaoqiangPremium(c.getJiaoqiangPremium());
                    policyDetail.setBusinessPremium(c.getBusinessPremium());
                    policyDetail.setExtendBusiness(c.getExpenditureBusinessRate());
                    policyDetail.setJiaoqiangPremium(c.getJiaoqiangPremium());
                    policyDetail.setExtendJiaoqiang(c.getExpenditureJiaoqiangRate());
                    policyDetails.add(policyDetail);
                }
            }
        }
        commisionData.setPolicyDetails(policyDetails);
        commisionData.setSalaryParams(salaryParams);
        resultInfo.setData(commisionData);
        //将相关的数据存如session中方便后面的excel的导入导出
        //命名的重复用于覆盖之前的消息从而得到我们想要的数据
        session.setAttribute("salary",salaryParams);
        session.setAttribute("policy",policyDetails);
        resultInfo.setResult(true);
        return resultInfo;
    }
    @RequestMapping("commissionrecord")
    public Object commission(){
        ResultInfo resultInfo=new ResultInfo();
        List<CommissionParam>commissionParams=internalSettlementService.getCommissionRecords();
        resultInfo.setData(commissionParams);
        return resultInfo;
    }
    @RequestMapping("calculate")
    public Object calculate(@RequestParam("branch")String branch,@RequestParam("startDate")Date start,@RequestParam("endDate")Date end){
        ResultInfo resultInfo=new ResultInfo();

        //处理相关的查询
        List<CarInsuranceParam>list=externalSettlementService.getCarInsuranceParam();
        //如果获得的list为空则表示没有数据可供演算
        if(list==null){
            resultInfo.setResult(false);
            return resultInfo;
        }
        else {
            //检查list中的对象有没有日期符合计佣范围的
            for (CarInsuranceParam c:list){
                //这里使用短路判断
                if(c.getBranch().equals(branch)&&c.getValidDate().compareTo(start)>=0&&c.getValidDate().compareTo(end)<=0){
                    resultInfo.setResult(true);
                    //插入查询的记录
                    internalSettlementService.insertCommisionDate(branch,start,end);
                    return resultInfo;
                }
            }
        }
        resultInfo.setResult(false);
        return resultInfo;
    }

    @RequestMapping("exportSalary")
    public Object exportSalary(HttpSession session,@RequestParam("path")String path){
        ResultInfo resultInfo=new ResultInfo();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String[]head={"代理人","分支机构","计佣起","计佣结束","支项佣金"};
        ExcelData excelData=new ExcelData();
        excelData.setHead(head);
        excelData.setFilename(path);
        List<SalaryParam>salaryParams= (List<SalaryParam>) session.getAttribute("salary");
        List<String[]>data=new ArrayList<>();
        for (SalaryParam s:salaryParams){
            String[]ss=new String[head.length];
//            for (int i=0;i<ss.length;i++){
//                ss[i]=s.getContractor();
//            }
            ss[0]=s.getContractor();
            ss[1]=s.getBranch();
            ss[2]=sdf.format(s.getValid_date_start());
            ss[3]=sdf.format(s.getValid_date_end());
            ss[4]=String.valueOf(s.getPayPremium());
        }
        excelData.setData(data);
        ExcelUtil.exportExcel(excelData);
        return resultInfo;
    }

    @RequestMapping("exportPolicy")
    public Object exportPolicy(HttpSession session,@RequestParam("path")String path){
        ResultInfo resultInfo=new ResultInfo();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String[]head={"保险公司","保单号码","受理日期","交强保费","支项(交强)","商业保费","支项(商业)"};
        ExcelData excelData=new ExcelData();
        List<PolicyDetail>policyDetails= (List<PolicyDetail>) session.getAttribute("policy");
        List<String[]>data=new ArrayList<>();
        for(PolicyDetail p:policyDetails){
            String[]ss=new String[head.length];
            ss[0]=p.getCompanyName();
            ss[1]=p.getPolicyNo();
            ss[2]=sdf.format(p.getValidDate());
            ss[3]=String.valueOf(p.getJiaoqiangPremium());
            ss[4]=String.valueOf(p.getExtendJiaoqiang());
            ss[5]=String.valueOf(p.getBusinessPremium());
            ss[6]=String.valueOf(p.getExtendBusiness());
        }
        excelData.setHead(head);
        excelData.setFilename(path);
        excelData.setData(data);
        ExcelUtil.exportExcel(excelData);
        resultInfo.setResult(true);
        return resultInfo;
    }
}