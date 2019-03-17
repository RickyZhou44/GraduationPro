package whu.iss.insurancesys.controller;

/*
 * @Author SeanShe
 * @Date 3/5/2019 14:42
 * Notes:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.iss.insurancesys.entity.PolicyParamEntities.*;
import whu.iss.insurancesys.service.PolicyParamService;

import java.util.List;

@RestController
@RequestMapping("/policyParam")
public class PolicyParamController {

    @Autowired
    private PolicyParamService policyParamService;

    @GetMapping("/getContractTypeParam")
    public List<ContractTypeParam> getContractTypeParam(){

        return policyParamService.getAllContractTypeParam();

    }

    @GetMapping("/getInsuranceTypeParam")
    public List<InsuranceTypeParam> getInsuranceTypeParam(){

        return policyParamService.getAllInsuranceTypeParam();

    }

    @GetMapping("/getPayTypeParam")
    public List<PayTypeParam> getPayTypeParam(){

        return policyParamService.getAllPayTypeParam();

    }

    @GetMapping("/getPayWayParam")
    public List<PayWayParam> getPayWayParam(){

        return policyParamService.getAllPayWayParam();

    }

    @GetMapping("/getPolicyStateParam")
    public List<PolicyStateParam> getPolicyStateParam(){

        return policyParamService.getAllPolicyStateParam();

    }

}
