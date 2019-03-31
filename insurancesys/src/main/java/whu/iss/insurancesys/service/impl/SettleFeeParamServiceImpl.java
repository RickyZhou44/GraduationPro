package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 3/25/2019 13:31
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.FeeRateDaos.ParamDao;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.service.SettleFeeParamService;

//费率模块 4
@Service
public class SettleFeeParamServiceImpl implements SettleFeeParamService {

    @Autowired
    ParamDao paramDao;

    public ResultInfo getParamTypeParam(){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllParamTypeParam());
        return resultInfo;

    }

    public ResultInfo getFeeRateParam(){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllFeeRateParam());
        return resultInfo;

    }

}
