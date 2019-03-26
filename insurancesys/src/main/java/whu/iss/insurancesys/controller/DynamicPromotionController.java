package whu.iss.insurancesys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.DynamicPromotionQueryResult;
import whu.iss.insurancesys.service.DynamicPromotionService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 人资-动态晋升考核管理
 */
@RestController
public class DynamicPromotionController {
    @Resource
    private DynamicPromotionService dynamicPromotionService;

    @GetMapping("/api/dynamicPromotion")
    private Object dynamicPromotion(@RequestParam(name = "status") String status, @RequestParam(name = "baseMonth")
            String baseMonth, @RequestParam(name = "branch") String branch, @RequestParam(name = "dept") String
                                            dept, @RequestParam(name = "rank[]") String[] rank, @RequestParam(name = "project") String project,
                                    @RequestParam(name = "category") String category, @RequestParam(name = "period")
                                            String period, @RequestParam(name = "condition") String condition, @RequestParam(name = "conditionValue") String conditionValue,
                                    @RequestParam("insuranceKind") String insuranceKind) {
        ResultInfo resultInfo = new ResultInfo();
        List<DynamicPromotionQueryResult> list = dynamicPromotionService.query(status, new Date(baseMonth), branch, dept, rank, project, category, insuranceKind, period, condition, Double.parseDouble(conditionValue));
        resultInfo.setResult(true);
        resultInfo.setData(list);
        return resultInfo;
    }
}
