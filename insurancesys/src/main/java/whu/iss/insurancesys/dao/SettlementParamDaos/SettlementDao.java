package whu.iss.insurancesys.dao.SettlementParamDaos;

import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.SettlementParamEntities.*;

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
    public Client getClient(String certfId);
    public List<AssociatePolicy>getAssoPolicy(String certfId);
    public List<RelationShip>getRelationShip(String certfId);
}
