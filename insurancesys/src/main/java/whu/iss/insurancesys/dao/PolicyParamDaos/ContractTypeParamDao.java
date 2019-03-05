package whu.iss.insurancesys.dao.PolicyParamDaos;

/*
 * @Author SeanShe
 * @Date 3/5/2019 11:50
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.PolicyParamEntities.ContractTypeParam;

import java.util.List;

@Mapper
public interface ContractTypeParamDao {

    public void insert(ContractTypeParam contractTypeParam);

    public void delete(ContractTypeParam contractTypeParam);

    public void update(ContractTypeParam contractTypeParam);

    public List<ContractTypeParam> findAll();

}
