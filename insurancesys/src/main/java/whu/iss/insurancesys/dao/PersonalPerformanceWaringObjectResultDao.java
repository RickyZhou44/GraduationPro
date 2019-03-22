package whu.iss.insurancesys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;

@Repository
public interface PersonalPerformanceWaringObjectResultDao {

    public PersonalPerformanceWaringObjectResult findAll(@Param("name") String name, @Param("number") String number, @Param("idCard") String idCard, @Param("branchs") String[] branchs);
}
