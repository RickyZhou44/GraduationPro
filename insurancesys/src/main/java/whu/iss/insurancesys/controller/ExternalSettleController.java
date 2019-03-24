package whu.iss.insurancesys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.SettlementParamEntities.ExternSettlementParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.ExternalSettleData;
import whu.iss.insurancesys.entity.SettlementParamEntities.SettlementEditDate;
import whu.iss.insurancesys.service.ExternalSettlementService;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/22
 */
//此控制器用于处理外部计算板块
@RestController
public class ExternalSettleController {
    @Autowired
    private ExternalSettlementService externalSettlementService;
    @RequestMapping("externalSettle")
    //public Object externalSettlement(@RequestParam("date")Date date, HttpSession session){
    public Object externalSettlement(HttpSession session) throws ParseException {
        ResultInfo resultInfo=new ResultInfo();
        //测试一下该service的编写
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        String date1="2017-1";
            Date date=simpleDateFormat.parse(date1);
            ExternalSettleData externalSettleData=externalSettlementService.getExternalSData(date,"否");
            List<ExternSettlementParam>list=externalSettleData.getExternSettlementParams();
            //这里将list存到session中去，后面的逐笔核算提供数据支持
            session.setAttribute("lists",list);
            resultInfo.setResult(true);
            resultInfo.setData(externalSettleData);
        return resultInfo;
    }
    @RequestMapping("editSettle/{policy}")
    public Object edit(@PathVariable("policy")String policy,HttpSession session){
        ResultInfo resultInfo=new ResultInfo();
        //从session中获得list，并根据url中传过来的policy参数从中获取数据
        List<ExternSettlementParam>list= (List<ExternSettlementParam>) session.getAttribute("lists");
        ExternSettlementParam externSettlementParam=null;
        for (ExternSettlementParam e:list){
            if(policy.equals(e.getPolicy_no())){
                //将这里查询到的e传引用给
                externSettlementParam=e;
                //如果找到一个匹配的直接退出循环
                break;
            }
        }
        //判断externSettlementParam是否是null，如果为null则返回失败的结果
        if(externSettlementParam==null){
            resultInfo.setResult(false);
            resultInfo.setReason("所提供的保单编号不正确");
        }else {
            SettlementEditDate settlementEditDate=externalSettlementService.getSettlementEditData(externSettlementParam);
            resultInfo.setData(settlementEditDate);
            resultInfo.setResult(true);
        }
       return resultInfo;
    }

}
