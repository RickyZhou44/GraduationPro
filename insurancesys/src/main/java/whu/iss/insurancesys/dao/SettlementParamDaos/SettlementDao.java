package whu.iss.insurancesys.dao.SettlementParamDaos;

import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.SettlementParamEntities.ExternalSettleData;
import whu.iss.insurancesys.entity.SettlementParamEntities.ExternalSettleEntity;
import whu.iss.insurancesys.entity.SettlementParamEntities.InsuranceTypeEntity;
import whu.iss.insurancesys.entity.SettlementParamEntities.Insured;

import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/23
 */
@Repository
public interface SettlementDao {
    public List<ExternalSettleEntity>getExternalData();
    public List<InsuranceTypeEntity>getInsuranceData();
    public Insured getInsured(String policy);
}
