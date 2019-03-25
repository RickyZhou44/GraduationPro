package whu.iss.insurancesys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningQueryResult;

import java.util.List;

@Repository
public interface PersonalPerformanceWaringDao {

    List<PersonalPerformanceWaringObjectResult> findPersonInfo(@Param("name") String name, @Param("number") long number, @Param("idCard") String idCard, @Param("branchs") String[] branchs);

    PersonalPerformanceWarningQueryResult findOne(@Param("number") long number);
}
