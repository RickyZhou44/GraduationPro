package whu.iss.insurancesys.dao.PolicyParamDaos;

/*
 * @Author SeanShe
 * @Date 3/5/2019 11:55
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.PolicyParamEntities.PolicyStateParam;

import java.util.List;

@Mapper
public interface PolicyStateParamDao {

    public void insert(PolicyStateParam policyStateParam);

    public void delete(PolicyStateParam policyStateParam);

    public void update(PolicyStateParam policyStateParam);

    public List<PolicyStateParam> getAll();

}
