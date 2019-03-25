package whu.iss.insurancesys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人资-动态晋升考核管理
 */
@RestController
public class DynamicPromotionController {

    @GetMapping("/api/dynamicPromotion")
    private String dynamicPromotion(@RequestParam(name = "status") String status, @RequestParam(name = "baseMonth")
            String baseMonth, @RequestParam(name = "branch") String branch, @RequestParam(name = "dept") String
                                            dept, @RequestParam(name = "rank[]") String[] rank, @RequestParam(name = "project") String project,
                                    @RequestParam(name = "category") String category,
                                    @RequestParam(name = "period") String period, @RequestParam(name = "condition") String condition,
                                    @RequestParam(name = "conditionValue") String conditionValue) {
        return null;

    }
}
