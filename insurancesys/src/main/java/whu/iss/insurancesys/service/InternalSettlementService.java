package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.InternalSettlementEntities.CommissionParam;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/29
 */
public interface InternalSettlementService {
    public void insertCommisionDate(String branch,Date dateStart,Date dateEnd);
    public List<CommissionParam>getCommissionRecords();
    public void deleteCommissionRecord(String branch,Date dateStart,Date dateEnd);
}
