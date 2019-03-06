package whu.iss.insurancesys.dao.SettlementParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 12:43
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.SettlementParamEntities.FeeRateParam;

import java.util.List;

@Mapper
public interface FeeRateParamDao {

    public List<FeeRateParam> getAll();

}
