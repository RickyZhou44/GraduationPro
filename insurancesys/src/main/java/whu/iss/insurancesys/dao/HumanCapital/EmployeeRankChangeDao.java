package whu.iss.insurancesys.dao.HumanCapital;

import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.HumanCapital.EmployeeRankChangeInfo;

import java.util.List;
import java.util.Map;

public interface EmployeeRankChangeDao {
    public int addRankChange(EmployeeRankChangeInfo rankChangeInfo);

    public List<Map<String, String>> getRankChangeByNum(@Param("employee_no") String staffNo);
}
