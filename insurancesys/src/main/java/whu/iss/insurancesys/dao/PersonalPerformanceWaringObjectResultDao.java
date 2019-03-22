package whu.iss.insurancesys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;

@Repository
public interface PersonalPerformanceWaringObjectResultDao {

    PersonalPerformanceWaringObjectResult findAll(@Param("name") String name, @Param("number") long number, @Param("idCard") String idCard, @Param("branchs") String[] branchs);
}
