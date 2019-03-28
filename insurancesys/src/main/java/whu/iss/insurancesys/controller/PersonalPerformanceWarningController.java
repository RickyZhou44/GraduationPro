package whu.iss.insurancesys.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities.PersonalPerformanceWaringObjectResult;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities.PersonalPerformanceWarningQueryResult;
import whu.iss.insurancesys.service.PersonalPerformanceWarningService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 个人绩效预警
 */
@RestController
@RequestMapping("/api")
public class PersonalPerformanceWarningController {

    private final static Logger logger = LoggerFactory.getLogger(PersonalPerformanceWarningController.class);

    @Resource
    private PersonalPerformanceWarningService personalPerformanceWarningService;

    @GetMapping("/performanceWarnPeople")
    private String performanceWarnPeople(@RequestParam(value = "name") String name, @RequestParam(value = "number", required = false) String number, @RequestParam(value = "idCard") String idCard, @RequestParam(value = "branch", required = false) String[] branchs) {
        logger.debug("name:{},number:{},idCard:{},branch:{}\n", name, number, idCard, branchs);
        ResultInfo resultInfo = new ResultInfo();
        name = (name.equals("")) ? null : name;
        number = (number.equals("")) ? "-1" : number;
        idCard = (idCard.equals("")) ? null : idCard;
        List<PersonalPerformanceWaringObjectResult> data = personalPerformanceWarningService.getPeopleInfo(name, Long.parseLong(number), idCard, branchs);
        if (data != null) {
            resultInfo.setData(data);
        }
        resultInfo.setResult(true);
        String res = JSONObject.toJSONString(resultInfo);
        logger.debug("查询结果：{}", res);
        return res;
    }


    @GetMapping("/performanceWarn")
    private String performanceWarn(@RequestParam(value = "name") String name, @RequestParam(value = "number") String number, @RequestParam(value = "idCard") String idCard, @RequestParam(value = "baseMonth") String baseMonth, @RequestParam("project") String project, @RequestParam("category") String category, @RequestParam("period") String period, @RequestParam("insuranceType") String insuranceKind) throws ParseException {
        logger.debug("name:{}\nnumber:{}\nidCard:{}\nbaseMonth:{}\nproject:{}\ncategory:{}\nperiod:{}\ninsuranceType:{}", name, number, idCard, baseMonth, project, category, period, insuranceKind);
        ResultInfo resultInfo = new ResultInfo();
        if (number.equals("")) {
            resultInfo.setResult(false);
            resultInfo.setReason("未指定number");
            String res = JSONObject.toJSONString(resultInfo);
            logger.debug("查询结果:{}", res);
            return res;
        }
        if (project.equals("")) {
            resultInfo.setResult(false);
            resultInfo.setReason("未指定project");
            String res = JSONObject.toJSONString(resultInfo);
            logger.debug("查询结果:{}", res);
            return res;
        }
        if (category.equals("")) {
            resultInfo.setResult(false);
            resultInfo.setReason("未指定category");
            String res = JSONObject.toJSONString(resultInfo);
            logger.debug("查询结果:{}", res);
            return res;
        }
        baseMonth = (baseMonth.equals("")) ? null : baseMonth;
        period = (period.equals("")) ? "自始" : period;
        insuranceKind = (insuranceKind.equals("")) ? "全部" : insuranceKind;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date base = (baseMonth == null) ? null : simpleDateFormat.parse(baseMonth);
        PersonalPerformanceWarningQueryResult result = personalPerformanceWarningService.query(Long.parseLong(number), insuranceKind, base, project, category, period);
        resultInfo.setData(result);
        resultInfo.setResult(true);
        String res = JSONObject.toJSONString(resultInfo);
        logger.debug("查询结果:{}", res);
        return res;
    }
}
