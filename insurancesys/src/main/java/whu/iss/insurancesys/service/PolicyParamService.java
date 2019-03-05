package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 3/5/2019 11:46
 * Notes:
 */

import whu.iss.insurancesys.entity.PolicyParamEntities.*;

import java.util.List;

public interface PolicyParamService {

    public List<ContractTypeParam> getAllContractTypeParam();

    public List<InsuranceTypeParam> getAllInsuranceTypeParam();

    public List<PayTypeParam> getAllPayTypeParam();

    public List<PayWayParam> getAllPayWayParam();

    public List<PolicyStateParam> getAllPolicyStateParam();

}
