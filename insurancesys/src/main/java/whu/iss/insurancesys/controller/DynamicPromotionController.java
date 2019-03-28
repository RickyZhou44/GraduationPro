package whu.iss.insurancesys.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.DynamicPromotionQueryResult;
import whu.iss.insurancesys.service.DynamicPromotionService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 人资-动态晋升考核管理
 */
@RestController
public class DynamicPromotionController {
    private final static Logger logger = LoggerFactory.getLogger(DynamicPromotionController.class);
    @Resource
    private DynamicPromotionService dynamicPromotionService;

    @GetMapping("/api/dynamicPromotion")
    private Object dynamicPromotion(@RequestParam(name = "status") String status, @RequestParam(name = "baseMonth")
            String baseMonth, @RequestParam(name = "branch") String branch, @RequestParam(name = "dept") String
                                            dept, @RequestParam(name = "objRank", required = false) String[] rank, @RequestParam(name = "project") String project,
                                    @RequestParam(name = "category") String category, @RequestParam(name = "period")
                                            String period, @RequestParam(name = "condition") String condition, @RequestParam(name = "conditionValue") Double conditionValue,
                                    @RequestParam("insuranceType") String insuranceKind) throws ParseException {
        ResultInfo resultInfo = new ResultInfo();
        if (project.equals("")) {
            resultInfo.setResult(false);
            resultInfo.setReason("未指定project");
            String res = JSONObject.toJSONString(resultInfo);
            logger.debug("查询结果:{}", res);
            return resultInfo;
        }
        if (category.equals("")) {
            resultInfo.setResult(false);
            resultInfo.setReason("未指定category");
            String res = JSONObject.toJSONString(resultInfo);
            logger.debug("查询结果:{}", res);
            return resultInfo;
        }
        baseMonth = (baseMonth.equals("")) ? null : baseMonth;
        period = (period.equals("")) ? "自始" : period;
        insuranceKind = (insuranceKind.equals("")) ? "全部" : insuranceKind;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date base = (baseMonth == null) ? null : simpleDateFormat.parse(baseMonth);
        condition = (condition.equals("")) ? null : condition;
        status = (status.equals("")) ? null : status;
        String state = (status == null) ? null : status.substring(0, 2);
        branch = (branch.equals("")) ? null : branch;
        dept = (dept.equals("")) ? null : dept;
        List<DynamicPromotionQueryResult> list = dynamicPromotionService.query(state, base, branch, dept, rank, project, insuranceKind, category, period, condition, conditionValue);
        resultInfo.setResult(true);
        resultInfo.setData(list);
        String res = JSONObject.toJSONString(resultInfo);
        logger.debug("查询结果:{}", res);
        return resultInfo;
    }
}
