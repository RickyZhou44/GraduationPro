package whu.iss.insurancesys.controller;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.SettlementParamEntities.*;
import whu.iss.insurancesys.service.ExternalSettlementService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    //public Object uploadAttachment(HttpSession session,@RequestParam("recordType")String recordType, @RequestParam("content")String content, @RequestParam("dateStart")Date start, @RequestParam("dateEnd")Date end, @RequestParam("other")String other, @RequestParam("pic")MultipartFile pic){
    public Object uploadAttachment(@RequestParam("pic")MultipartFile pic){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setResult(true);
        if(pic!=null){
            //获取文件原始文件名
            String originalFilename;
            originalFilename=pic.getOriginalFilename();
           // String clientid= (String) session.getAttribute("clientId");
            String clientid="3001";
            //设置一个绝对路径参数
            String pathname="/Users/rickzhou/Desktop/"+clientid;
            //文件名使用当前时间
            SimpleDateFormat std =new SimpleDateFormat("yyyyMMddHHmmssSSS");
            Calendar calendar=Calendar.getInstance();
            String name=std.format(calendar.getTime())+originalFilename;

            File parent=new File(pathname);
            //检查这个以这个id命名的文件夹是否存在，如果不存在就创建他
            if(!parent.exists()&&!parent.isDirectory()){
                if(!parent.mkdir())
                    System.out.println("目录创建失败");
            }
            String filepath=pathname+"/"+name;
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
        String path=null;
        String id=null;
        //externalSettlementService.addCertfContent(content,recordType,start,end,other,path,id);
        return resultInfo;
    }

}
