package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 3/6/2019 13:02
 * Notes:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.SettlementParamDaos.FeeRateParamDao;
import whu.iss.insurancesys.dao.SettlementParamDaos.ParamTypeParamDao;
import whu.iss.insurancesys.entity.SettlementParamEntities.FeeRateParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.ParamTypeParam;
import whu.iss.insurancesys.service.SettlementParamService;

import java.util.List;

@Service
public class SettlementParamServiceImpl implements SettlementParamService {

    @Autowired
    FeeRateParamDao feeRateParamDao;
    @Autowired
    ParamTypeParamDao paramTypeParamDao;

    public List<FeeRateParam> getAllFeeRateParam() {

        return feeRateParamDao.getAll();

    }

    public List<ParamTypeParam> getAllParamTypeParam() {

        return paramTypeParamDao.getAll();

    }

}
