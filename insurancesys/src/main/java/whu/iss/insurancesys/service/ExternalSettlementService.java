package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.SettlementParamEntities.ExternSettlementParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.ExternalSettleData;
import whu.iss.insurancesys.entity.SettlementParamEntities.SettlementEditDate;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/22
 */
public interface ExternalSettlementService {
    public ExternalSettleData getExternalSData(Date date,String checkIf);
    public SettlementEditDate getSettlementEditData(ExternSettlementParam externSettlementParam);
}
