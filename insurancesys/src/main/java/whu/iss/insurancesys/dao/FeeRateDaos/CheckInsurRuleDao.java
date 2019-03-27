package whu.iss.insurancesys.dao.FeeRateDaos;

/*
 * @Author SeanShe
 * @Date 3/25/2019 12:19
 * Notes:
 * */

import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.FeeRateEntities.CheckInsurRule;

import java.util.Date;
import java.util.List;

public interface CheckInsurRuleDao {

    int insertSelective(CheckInsurRule checkInsurRule);

    int deleteById(@Param("id")int id);

    List<CheckInsurRule> getByParam(@Param("companyNames")List<String> companyNames,
                                    @Param("branchNames")List<String> branchNames,
                                    @Param("from")Date from, @Param("to")Date to, @Param("name")String name);

}
