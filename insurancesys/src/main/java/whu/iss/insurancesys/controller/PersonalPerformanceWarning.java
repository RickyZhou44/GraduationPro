package whu.iss.insurancesys.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;
import whu.iss.insurancesys.service.PersonalPerformanceWarningService;

import javax.annotation.Resource;

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
        PersonalPerformanceWaringObjectResult data = personalPerformanceWarningService.getPeopleInfo(name, Long.parseLong(number), idCard, branchs);
        if (data != null) {
            resultInfo.setResult(true);
            resultInfo.setData(data);
        }
        String res = JSONObject.toJSONString(resultInfo);
        logger.debug("查询结果：{}", res);
        return res;
    }
}
