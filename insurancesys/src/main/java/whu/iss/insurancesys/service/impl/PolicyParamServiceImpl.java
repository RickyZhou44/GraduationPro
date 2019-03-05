package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 3/5/2019 11:47
 * Notes:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.PolicyParamDaos.*;
import whu.iss.insurancesys.entity.PolicyParamEntities.*;
import whu.iss.insurancesys.service.PolicyParamService;

import java.util.List;

@Service
public class PolicyParamServiceImpl implements PolicyParamService {

    @Autowired
    private ContractTypeParamDao contractTypeParamDao;
    @Autowired
    private InsuranceTypeParamDao insuranceTypeParamDao;
    @Autowired
    private PayTypeParamDao payTypeParamDao;
    @Autowired
    private PayWayParamDao payWayParamDao;
    @Autowired
    private PolicyStateParamDao policyStateParamDao;

    public List<ContractTypeParam> getAllContractTypeParam(){

        return contractTypeParamDao.findAll();

    }

    public List<InsuranceTypeParam> getAllInsuranceTypeParam() {

        return insuranceTypeParamDao.findAll();

    }

    public List<PayTypeParam> getAllPayTypeParam() {

        return payTypeParamDao.findAll();

    }

    public List<PayWayParam> getAllPayWayParam() {

        return payWayParamDao.findAll();

    }

    public List<PolicyStateParam> getAllPolicyStateParam() {

        return policyStateParamDao.findAll();

    }

}
