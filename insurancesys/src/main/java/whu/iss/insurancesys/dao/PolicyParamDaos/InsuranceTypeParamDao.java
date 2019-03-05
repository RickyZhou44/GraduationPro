package whu.iss.insurancesys.dao.PolicyParamDaos;

/*
 * @Author SeanShe
 * @Date 3/5/2019 11:51
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.PolicyParamEntities.InsuranceTypeParam;

import java.util.List;

@Mapper
public interface InsuranceTypeParamDao {

    public void insert(InsuranceTypeParam insuranceTypeParam);

    public void delete(InsuranceTypeParam insuranceTypeParam);

    public void update(InsuranceTypeParam insuranceTypeParam);

    public List<InsuranceTypeParam> findAll();

}
