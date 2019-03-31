package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.DynamicPromotionQueryResult;

import java.util.Date;
import java.util.List;

/**
 * 动态晋升考核管理业务逻辑
 */
public interface DynamicPromotionService {
    /**
     * @param status
     * @param baseMonth
     * @param branch
     * @param dept
     * @param rank
     * @param project
     * @param category
     * @param period
     * @param condition
     * @param conditionValue
     * @return 前端查询的数据
     */
    List<DynamicPromotionQueryResult> query(String status, Date baseMonth, String branch, String dept, String[] rank, String project, String category, String insuranceKind, String period, String condition, Double conditionValue);
}
