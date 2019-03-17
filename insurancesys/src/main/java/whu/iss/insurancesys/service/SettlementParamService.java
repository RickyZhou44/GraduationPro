package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 3/6/2019 13:01
 * Notes:
 */

import whu.iss.insurancesys.entity.SettlementParamEntities.FeeRateParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.ParamTypeParam;

import java.util.List;

public interface SettlementParamService {

    public List<FeeRateParam> getAllFeeRateParam();

    public List<ParamTypeParam> getAllParamTypeParam();

}
