package whu.iss.insurancesys.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 个人绩效预警
 */
@RestController
@RequestMapping("/api")
public class PersonalPerformanceWarning {

    private final static Logger logger = LoggerFactory.getLogger(PersonalPerformanceWarning.class);

    @Resource
    private PersonalPerformanceWarningService personalPerformanceWarningService;

    @GetMapping("/performanceWarnPeople")
    private String performanceWarnPeople(@RequestParam(value = "name") String name, @RequestParam(value = "number") String number, @RequestParam(value = "idCard") String idCard, @RequestParam(value = "branch[]", required = false) String[] branchs) {
        logger.debug("name:{},number:{},idCard:{},branch:{}\n", name, number, idCard, branchs);
        ResultInfo resultInfo = new ResultInfo();
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
    private String performanceWarn(@RequestParam(value = "name") String name, @RequestParam(value = "number") String number, @RequestParam(value = "idCard") String idCard, @RequestParam(value = "baseMonth") String baseMonth, @RequestParam("project") String project, @RequestParam("category") String category, @RequestParam("objRank") String rank, @RequestParam("period") String period, @RequestParam("insuranceKind") String insuranceKind) {
        logger.debug("name:{}\nnumber:{}\nidCard:{}\nbaseMonth:{}\nproject:{}\ncategory:{}\nobjRank:{}\nperiod:{}\n", name, number, idCard, baseMonth, project, category, rank, period);
        ResultInfo resultInfo = new ResultInfo();
        PersonalPerformanceWarningQueryResult result = personalPerformanceWarningService.query(Long.parseLong(number), insuranceKind, new Date(baseMonth), project, category, period);
        if (result != null) {
            resultInfo.setData(result);
        }
        resultInfo.setResult(true);
        String res = JSONObject.toJSONString(resultInfo);
        logger.debug("查询结果:{}", res);
        return res;
    }
}
