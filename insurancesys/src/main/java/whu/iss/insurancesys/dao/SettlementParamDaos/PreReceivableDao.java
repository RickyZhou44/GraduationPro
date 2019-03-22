package whu.iss.insurancesys.dao.SettlementParamDaos;

import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.SettlementParamEntities.PaidPremiumParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.PreReceivableParam;

import java.util.List;


/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/18
 */
@Repository
public interface PreReceivableDao {
    public List<PreReceivableParam>queryAll();
    public List<PaidPremiumParam>queryPaid();
    public List<String>employeeNo();
    public List<String>branchName();
}
