package whu.iss.insurancesys.dao.HumanCapital;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonRankDao {

    public List<Map<String,String>> getCustomerList(@Param("employee_no") String staffNo,
                                                    @Param("name") String staffName,
                                                    @Param("branch_name") String branch,
                                                    @Param("department") String dept,
                                                    @Param("current_rank") String rank,
                                                    @Param("phone_number") String tel);

    public int deletePersonRankByNum(@Param("employee_no") int num);

    public Map<String,String> getPersonRankByNum(@Param("employee_no") int num);
}
