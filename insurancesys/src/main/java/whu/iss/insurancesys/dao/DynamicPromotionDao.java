package whu.iss.insurancesys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.DynamicPromotionQueryResult;

import java.util.Date;
import java.util.List;

/**
 * 动态晋升考核管理dao层
 */
@Repository
public interface DynamicPromotionDao {

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
     * @return 寿险查询结果
     */
    List<DynamicPromotionQueryResult> queryLifeInsurance(@Param("state") String status, @Param("baseMonth") Date baseMonth, @Param("branch") String branch, @Param("dept") String dept, @Param("rank") String[] rank, @Param("project") String project, @Param("category") String category, @Param("period") String period, @Param("condition") String condition, @Param("conditionValue") Double conditionValue);

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
     * @return 车险查询结果
     */
    List<DynamicPromotionQueryResult> queryCarInsurance(@Param("state") String status, @Param("baseMonth") Date baseMonth, @Param("branch") String branch, @Param("dept") String dept, @Param("rank") String[] rank, @Param("project") String project, @Param("category") String category, @Param("period") String period, @Param("condition") String condition, @Param("conditionValue") Double conditionValue);


}
