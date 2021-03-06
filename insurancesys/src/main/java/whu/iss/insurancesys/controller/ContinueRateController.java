package whu.iss.insurancesys.controller;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.ExcelData;
import whu.iss.insurancesys.entity.SettlementParamEntities.ContinueRateBranchParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.ContinueRateParam;
import whu.iss.insurancesys.service.ContinueRService;
import whu.iss.insurancesys.service.ContinueRateService;
import whu.iss.insurancesys.util.ExcelUtil;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/17 0017.
 */
@CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
@RestController
@RequestMapping("/continue")
public class ContinueRateController {
    @Autowired
    ContinueRService continueRateService;
    //此处用于返回对继续率的重新组织
    @RequestMapping("/continueRate")
    public Object continueRate1(@RequestParam("date") Date date,@RequestParam("param") int param,@RequestParam("type")int type){
        ResultInfo resultInfo=  continueRateService.getResult(date,param,type);
        return resultInfo;
    }
//    此映射用于处理导出继续率查询的结果并存储到指定位置的excel文件
    @RequestMapping(value = "/exportExcel",method = RequestMethod.POST)
    public Object exportExcel(@RequestParam("heads")List<String>heads,@RequestParam("path") String path, HttpSession session){
//        public Object exportExcel(HttpSession session){
        int type= (int) session.getAttribute("continueType");
        ResultInfo resultInfo=new ResultInfo();
        ExcelData excelData=new ExcelData();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
//        String path="/Users/rickzhou/Desktop/data";
        excelData.setFilename(path);
//        String[] heads={"序号","继续率发生月份","单位","职级","应收继续保费","实收继续保费","R13"};
        String[]head=new String[heads.size()];
        int m=0;
        for (String s:heads){
            head[m]=s;
            m++;
        }
        excelData.setHead(head);
        List<String[]>data=new ArrayList<>();
        if(type==1){
            List<ContinueRateParam>continueRateParams= (ArrayList<ContinueRateParam>) session.getAttribute("continueData");
            int serialNo=1;
            for(ContinueRateParam c:continueRateParams){
                String [] d=new String[head.length];
                for (int i=0;i<head.length;i++){
                    switch (head[i]){
                        case "序号":
                            d[i]=String.valueOf(serialNo);
                            serialNo++;
                            break;
                        case "继续率发生月份":
                            d[i]=simpleDateFormat.format(c.getDate());
                            break;
                        case "单位":
                            d[i]=c.getUnit();
                            break;
                        case "职级":
                            d[i]=c.getRank();
                            break;
                        case "员工编号":
                            d[i]=c.getIdNum();
                            break;
                        case "姓名":
                            d[i]=c.getName();
                        case "应收继续保费":
                            d[i]=String.valueOf(c.getPreReceivable());
                            break;
                        case "实收继续保费":
                            d[i]=String.valueOf(c.getPaidPremium());
                            break;
                        case "R13":
                            d[i]=String.valueOf(c.getRate())+"%";
                            break;
                        case "R25":
                            d[i]=String.valueOf(c.getRate())+"%";
                            break;
                        case "R37":
                            d[i]=String.valueOf(c.getRate())+"%";
                            break;
                    }
                }
                data.add(d);
            }
            resultInfo.setResult(true);
            resultInfo.setReason("1 成功了");
        }
        else if(type==2) {
            List<ContinueRateBranchParam> continueRateBranchParams=(ArrayList<ContinueRateBranchParam>)session.getAttribute("continueData");
            int serialNo=1;
            for(ContinueRateBranchParam c:continueRateBranchParams){
                String [] d=new String[head.length];
                for (int i=0;i<head.length;i++){
                    switch (head[i]){
                        case "序号":
                            d[i]=String.valueOf(serialNo);
                            serialNo++;
                            break;
                        case "继续率发生月份":
                            d[i]=simpleDateFormat.format(c.getDate());
                            break;
                        case "单位":
                            d[i]=c.getUnit();
                            break;
                        case "应收继续保费":
                            d[i]=String.valueOf(c.getPreReceivable());
                            break;
                        case "实收继续保费":
                            d[i]=String.valueOf(c.getPaidPremium());
                            break;
                        case "R13":
                            d[i]=String.valueOf(c.getRate())+"%";
                            break;
                        case "R25":
                            d[i]=String.valueOf(c.getRate())+"%";
                            break;
                        case "R37":
                            d[i]=String.valueOf(c.getRate())+"%";
                            break;
                    }
                }
                data.add(d);
            }
            resultInfo.setResult(true);
            resultInfo.setReason("2 成功了");
        }
        else {
            resultInfo.setResult(false);
            resultInfo.setReason("type属于不能识别的值");
        }
        excelData.setData(data);
        ExcelUtil.exportExcel(excelData);
        return resultInfo;
    }
    //test
    @RequestMapping(value = "/testCon",method = RequestMethod.POST)
    public Object continueRate(@RequestParam("date") Date date,@RequestParam("param") int param,@RequestParam("type")int type,HttpSession session){
    //public Object continueRate(HttpSession session) throws ParseException {
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        ResultInfo resultInfo=null;
//        String dates="2019-1";
//        Date date=simpleDateFormat.parse(dates);
//            int param=13;
//            int type=1;
        resultInfo=continueRateService.getResult(date,param,type);
        //将type内容添加进session
        session.setAttribute("continueType",type);
        //这里将生成的继续率数据保存到session中以便后续要选择导出excel表的时候重新计算浪费性能
        session.setAttribute("continueData",resultInfo.getData());
        return resultInfo;

    }
    public static void main(String[]strings){
        return;
    }
}
