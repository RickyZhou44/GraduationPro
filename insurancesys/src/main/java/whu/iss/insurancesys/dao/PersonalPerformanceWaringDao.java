package whu.iss.insurancesys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities.*;

import java.util.Date;
import java.util.List;

/**
 * 个人绩效预警Dao层
 */
@Repository
public interface PersonalPerformanceWaringDao {
    /**
     * @param name
     * @param number
     * @param idCard
     * @param branchs
     * @return 弹框查询的结果
     */
    List<PersonalPerformanceWaringObjectResult> findPersonInfo(@Param("name") String name, @Param("number") long number, @Param("idCard") String idCard, @Param("branchs") String[] branchs);

    /**
     *
     * @param number
     * @return 前端查询结果
     */
    PersonalPerformanceWarningQueryResult findOne(@Param("number") long number);

    /**
     * 获取计算寿险Fyc的数据
     * @param employeeNo
     * @param category
     * @param period
     * @param baseMonth
     * @return
     */
    List<LifeInsuranceFyc> getLifeInsuranceFycBasicData(@Param("employeeNo") long employeeNo, @Param("category") String category, @Param("period") String period, @Param("baseMonth") Date baseMonth);

    /**
     * 获取计算车险Fyc的数据
     * @param employeeNo
     * @param category
     * @param period
     * @param baseMonth
     * @return
     */
    List<CarInsuranceFyc> getCarInsuranceFycBasicData(@Param("employeeNo") long employeeNo, @Param("category") String category, @Param("period") String period, @Param("baseMonth") Date baseMonth);
}
