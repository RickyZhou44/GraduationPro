package whu.iss.insurancesys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities.*;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonalPerformanceWaringDao {

    List<PersonalPerformanceWaringObjectResult> findPersonInfo(@Param("name") String name, @Param("number") long number, @Param("idCard") String idCard, @Param("branchs") String[] branchs);

    PersonalPerformanceWarningQueryResult findOne(@Param("number") long number);

    List<LifeInsuranceFyc> getLifeInsuranceFycBasicData(@Param("employeeNo") long employeeNo, @Param("category") String category, @Param("period") String period, @Param("baseMonth") Date baseMonth);

    List<CarInsuranceFyc> getCarInsuranceFycBasicData(@Param("employeeNo") long employeeNo, @Param("category") String category, @Param("period") String period, @Param("baseMonth") Date baseMonth);
}
