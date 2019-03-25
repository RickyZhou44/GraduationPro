package whu.iss.insurancesys.service;


import whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities.PersonalPerformanceWaringObjectResult;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities.PersonalPerformanceWarningQueryResult;

import java.util.Date;
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

    PersonalPerformanceWarningQueryResult query(long number, String insuranceKind, Date baseMonth, String project, String category, String period);
}
