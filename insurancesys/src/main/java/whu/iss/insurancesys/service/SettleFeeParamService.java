package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 3/25/2019 13:31
 * Notes:
 * */

import whu.iss.insurancesys.dto.ResultInfo;

public interface SettleFeeParamService {

    ResultInfo getParamTypeParam();

    ResultInfo getFeeRateParam();

}
