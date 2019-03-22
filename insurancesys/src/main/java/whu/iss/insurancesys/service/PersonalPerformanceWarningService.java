package whu.iss.insurancesys.service;


import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;

/**
 * 个人绩效预警业务逻辑
 */
public interface PersonalPerformanceWarningService {

    /**
     * @param name
     * @param number
     * @param idCard
     * @param branchs
     * @return 前段需要的字段信息
     */
    PersonalPerformanceWaringObjectResult getPeopleInfo(String name, long number, String idCard, String[] branchs);
}
