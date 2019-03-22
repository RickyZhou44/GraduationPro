package whu.iss.insurancesys.controller;

import com.alibaba.fastjson.JSONObject;
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

    @Resource
    private PersonalPerformanceWarningService personalPerformanceWarningService;

    @GetMapping("/performanceWarnPeople")
    private String performanceWarnPeople(@RequestParam(value = "name") String name, @RequestParam(value = "number") String number, @RequestParam(value = "idCard") String idCard, @RequestParam(value = "branch[]", required = false) String[] branchs) {
        ResultInfo resultInfo = new ResultInfo();
        PersonalPerformanceWaringObjectResult data = personalPerformanceWarningService.getPeopleInfo(name, number, idCard, branchs);
        if (data != null) {
            resultInfo.setResult(true);
            resultInfo.setData(data);
        }
        String res = JSONObject.toJSONString(resultInfo);
        return res;
    }
}
