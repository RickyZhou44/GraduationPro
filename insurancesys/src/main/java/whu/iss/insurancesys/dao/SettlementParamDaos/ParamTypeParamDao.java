package whu.iss.insurancesys.dao.SettlementParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 12:44
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.SettlementParamEntities.ParamTypeParam;

import java.util.List;

@Mapper
public interface ParamTypeParamDao {

    public List<ParamTypeParam> getAll();

}
