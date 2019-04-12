package whu.iss.insurancesys.controller;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.ExcelData;
import whu.iss.insurancesys.entity.SettlementParamEntities.*;
import whu.iss.insurancesys.service.ExternalSettlementService;
import whu.iss.insurancesys.util.ExcelUtil;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    @RequestMapping(value = "externalSettle",method = RequestMethod.POST)
    //public Object externalSettlement(@RequestParam("date")Date date, HttpSession session){
    public Object externalSettlement(@RequestParam("date")Date date,@RequestParam("check")String check, HttpSession session) {
        ResultInfo resultInfo=new ResultInfo();
        //测试一下该service的编写
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
//        String date1="2017-1";
//            Date date=simpleDateFormat.parse(date1);
            ExternalSettleData externalSettleData=externalSettlementService.getExternalSData(date,check);
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

    @RequestMapping("clientEdit/{id}")
    public Object clientEdit(@PathVariable("id")String id,HttpSession session){
        ClientEditData clientEditData=externalSettlementService.getClientInfo(id);
        ResultInfo resultInfo=new ResultInfo();
        //将clientid存入session中以便后面使用
        session.setAttribute("clientId",id);
        resultInfo.setResult(true);
        resultInfo.setData(clientEditData);
        return resultInfo;
    }

    //处理亲朋好友的增删改查
    @RequestMapping("removeRelation")
    public Object removeRelation(@RequestParam("aid")String aid,@RequestParam("bid")String bid){
        ResultInfo resultInfo=new ResultInfo();
        boolean result=externalSettlementService.removeRelationById(aid,bid);
        resultInfo.setResult(result);
        return resultInfo;
    }

    //添加好友的查询前奏
    @RequestMapping("inquire")
    public Object getClients(@RequestParam("name")String name,@RequestParam("id")String id){
        ResultInfo resultInfo =new ResultInfo();
        if(name==null&&id==null){
            resultInfo.setResult(false);
            resultInfo.setReason("传的参数都为null");
        }
//        如果id为空则使用name作为参数查询
        else if (id==null){
            resultInfo.setResult(true);
            List<ClientByName>clientByNames=externalSettlementService.getByName(name);
            resultInfo.setData(clientByNames);
        }
        //如果两者都不为空则使用证件号
        else {
            resultInfo.setResult(true);
            ClientByName clientByName=externalSettlementService.getById(id);
            resultInfo.setData(clientByName);
        }
        return resultInfo;
    }
    //添加到关系表中
    @RequestMapping("addRelation")
    public Object addRelation(@RequestParam("aid")String aid,@RequestParam("bid")String bid,@RequestParam("relation")String relation){
        ResultInfo resultInfo=new ResultInfo();
        externalSettlementService.addRelation(aid,bid,relation);
        resultInfo.setResult(true);
        return resultInfo;
    }

    //上传附件
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Object uploadAttachment(HttpSession session,@RequestParam("recordType")String recordType, @RequestParam("content")String content, @RequestParam("dateStart")Date start, @RequestParam("dateEnd")Date end, @RequestParam("other")String other, @RequestParam("pic")MultipartFile pic){
   // public Object uploadAttachment(@RequestParam("pic")MultipartFile pic){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setResult(true);
        String filepath=null;
        String clientid=null;
        String name=null;
        String parentPath=null;
        if(pic!=null){
            //获取文件原始文件名
            String originalFilename;
            originalFilename=pic.getOriginalFilename();
            clientid= (String) session.getAttribute("clientId");
            //String clientid="3001";
            //设置一个绝对路径参数
            String pathname="/Users/rickzhou/Desktop/"+clientid;
            parentPath=pathname;
            //文件名使用当前时间
            SimpleDateFormat std =new SimpleDateFormat("yyyyMMddHHmmssSSS");
            Calendar calendar=Calendar.getInstance();
            name=std.format(calendar.getTime())+originalFilename;

            File parent=new File(pathname);
            //检查这个以这个id命名的文件夹是否存在，如果不存在就创建他
            if(!parent.exists()&&!parent.isDirectory()){
                if(!parent.mkdir())
                    System.out.println("目录创建失败");
            }
            filepath=pathname+"/"+name;
            //在控制台输出绝对路径
            System.out.println("绝对路径："+filepath);
            File file=new File(filepath);
            try {
                pic.transferTo(file);
                System.out.println("上传设置成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //这里这些数据适用于测试插入模块的编写
//        String path=null;
//        String id="3001";
//        String content="hello";
//        String recordType="lalala";
//        Date start=new Date();
//        Date end=new Date();
//        String other="成功了";
        if(clientid==null){
            resultInfo.setResult(false);
            resultInfo.setReason("session保存的clientid为空");
            return resultInfo;
        }
        else {
            externalSettlementService.addCertfContent(content,recordType,start,end,other,filepath,clientid);
            AttachInfo attachInfo=new AttachInfo();
            attachInfo.setPath(parentPath);
            attachInfo.setName(name);
            resultInfo.setData(attachInfo);
            return resultInfo;
        }

    }
    //处理车险核佣
    @RequestMapping(value = "carSettlement",method = RequestMethod.POST)
    public Object carSettlement(@RequestParam("branchs")String[]branchs,@RequestParam("insurcompanys")String[]companys,@RequestParam("date1")Date date1,@RequestParam("date2")Date date2,@RequestParam("check")String check,HttpSession session){
//    public Object carSettlement(HttpSession session){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setResult(true);
        List<CarInsuranceParam>carInsuranceParams=externalSettlementService.getCarInsuranceParam();
        List<CarInsuranceParam>list=new ArrayList<>();
        if(branchs==null&&companys==null){
            session.setAttribute("carlist",carInsuranceParams);
            resultInfo.setData(carInsuranceParams);
            return resultInfo;
        }
        else if(branchs==null){
            for (CarInsuranceParam c:carInsuranceParams){
                for(String str:companys){
                    if(c.getCompanyName().equals(str)){
                        list.add(c);
                        break;
                    }
                }
            }
            session.setAttribute("carlist",list);
            resultInfo.setData(list);
            return resultInfo;
        }
        else if(companys==null){
            for (CarInsuranceParam c:carInsuranceParams){
                for(String str:branchs){
                    if(c.getBranch().equals(str)){
                        list.add(c);
                        break;
                    }
                }
            }
            session.setAttribute("carlist",list);
            resultInfo.setData(list);
            return resultInfo;

        }
        else {
            session.setAttribute("carlist",carInsuranceParams);
            resultInfo.setResult(false);
            return resultInfo;
        }

    }
    @RequestMapping("exportCarInsurance")
    public Object exportCarInsurance(@RequestParam("heads")String[]heads,@RequestParam("path") String path,HttpSession session){
        ResultInfo resultInfo=new ResultInfo();
        List<CarInsuranceParam>carInsuranceParams= (List<CarInsuranceParam>) session.getAttribute("carlist");
        ExcelData excelData=new ExcelData();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        String[]head=heads;
        excelData.setHead(head);
        excelData.setFilename(path);
        List<String[]>data=new ArrayList<>();
        for (CarInsuranceParam s:carInsuranceParams){
            String[]strings=new String[head.length];
            for(int i=0;i<head.length;i++){
                switch (head[i]){
                    case "保险公司":
                        strings[i]=s.getCompanyName();
                        break;
                    case "保单号码":
                        strings[i]=s.getPolicyNo();
                        break;
                    case "出单日期":
                        strings[i]=simpleDateFormat.format(s.getBillDate());
                        break;
                    case "起保日期":
                        strings[i]=simpleDateFormat.format(s.getValidDate());
                        break;
                    case "承揽人":
                        strings[i]=s.getContractorName();
                        break;
                    case "投保人":
                        strings[i]=s.getHolderName();
                        break;
                    case "被保人":
                        strings[i]=s.getBeholderName();
                        break;
                    case "分支机构":
                        strings[i]=s.getBranch();
                        break;
                    case "核佣":
                        strings[i]=s.getCheck();
                        break;
                    case "是否计佣":
                        strings[i]=s.getJiyong();
                        break;
                    case "支项交强":
                        strings[i]=String.valueOf(s.getExpenditureJiaoqiangRate());
                        break;
                    case "收项交强":
                        strings[i]=String.valueOf(s.getReciveJiaoQiangsRate());
                        break;
                    case "支项商业":
                        strings[i]=String.valueOf(s.getExpenditureBusinessRate());
                        break;
                    case "收项商业":
                        strings[i]=String.valueOf(s.getReciveBusinessRate());
                        break;
                    case "交强保费":
                        strings[i]=String.valueOf(s.getJiaoqiangPremium());
                        break;
                    case "商业保费":
                        strings[i]=String.valueOf(s.getBusinessPremium());
                        break;
                    case "总保费":
                        strings[i]=String.valueOf(s.getTotalPremium());
                        break;
                }
                data.add(strings);
            }
        }
        excelData.setData(data);
        excelData.setFilename(path);
        ExcelUtil.exportExcel(excelData);
        return resultInfo;
    }

}
