package whu.iss.insurancesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.SettlementParamDaos.SettlementDao;
import whu.iss.insurancesys.entity.InternalSettlementEntities.CommissionParam;
import whu.iss.insurancesys.service.InternalSettlementService;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
//
@Service
public class InternalSettlementServiceImpl implements InternalSettlementService {
    @Autowired
    private SettlementDao settlementDao;
    @Override
    public void insertCommisionDate(String branch, Date dateStart, Date dateEnd) {
        settlementDao.insertCommissionRecord(branch,dateStart,dateEnd);
    }

    @Override
    public List<CommissionParam> getCommissionRecords() {
        return settlementDao.getCommissionRecords();
    }
}
