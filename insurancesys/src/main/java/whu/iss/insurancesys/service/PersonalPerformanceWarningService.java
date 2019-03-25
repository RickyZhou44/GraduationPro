package whu.iss.insurancesys.service;


import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningQueryResult;

import java.util.List;

/**
 * 个人绩效预警业务逻辑
 */
public interface PersonalPerformanceWarningService {

    /**
     * @param name
     * @param number
     * @param idCard
     * @param branchs
     * @return 前端需要的字段信息
     */
    List<PersonalPerformanceWaringObjectResult> getPeopleInfo(String name, long number, String idCard, String[] branchs);

    PersonalPerformanceWarningQueryResult query(long number, String baseMonth, String project, String category, String period);
}
