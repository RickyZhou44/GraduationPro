package whu.iss.insurancesys.dao;

import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.DynamicPromotionQueryResult;

import java.util.Date;

/**
 * 动态晋升考核管理dao层
 */
public interface DynamicPromotionDao {

    DynamicPromotionQueryResult findAll(@Param("status") String status, @Param("baseMonth") Date baseMonth, @Param("branch") String branch, @Param("dept") String dept, @Param("rank") String[] rank, @Param("project") String project, @Param("category") String category, @Param("period") String period, @Param("condition") String condition, @Param("conditionValue") double conditionValue);
}
